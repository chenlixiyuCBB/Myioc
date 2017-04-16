---
title: 简单的IoC实现及设计模式分析
date: 2017-04-14 19:59:12
tags:
      - Spring原理
      - 设计模式
      - IoC
      - JAVA
      - 反射
---

最近进行了大量的JAVA相关知识的学习，对于JAVA知识也算是比较了解了，IoC，反射，设计模式等知识都能讲清楚，但是感觉由于平时使用框架做Web后台开发的原因，明明每天都在接触这些东西，但是又没有真正在使用它们，只是使用了Spring等框架基于它们来实现的服务，纸上得来终觉浅，不练习不行。

正好IoC容器的实现大量地使用了IoC,反射，设计模式，所以打算自己写一个简单的IoC容器来练习，网上查了一下，发现github上有一个叫 [*tiny-spring*](https://github.com/code4craft/tiny-spring) 的开源项目，简化了Spring的IoC容器和AOP，API名字都是仿照Spring，所以临摹了一下IoC，后续打算临摹下它的AOP。

我的项目地址为 [*Myioc*](https://github.com/chenlixiyuCBB/Myioc)，目前只实现了IoC容器，后续将会有更新AOP实现

# 大体结构

项目是以使用ApplicationContext作为入口，应用上下文封装了BeanFactory、BeanDefinitionReader。BeanDefinitionReader是获取并存储bean定义的类；BeanFactory则是IoC容器，负责bean的创建和获取，二者由应用上下文持有，然后组合使用以完成控制反转。

# 具体介绍

## IoC容器

### 由xml中获取bean的定义

![获取bean定义类图](https://cl.ly/302q111l0919)

#### Resource及ResourceLoader

Resource是一个接口，它的实现类必须实现getInputStream()方法，返回一个InputStream。
ResourceLoader则用于生成并返回一个Resource对象（这是面向对象设计中的单一职责原则，Resource负责加载URL，而ResourceLoder则负责生成URL）。在本项目中二者的实现类分别是XmlResource和XmlResourceLoader，用于读取classPath下的xml配置文件。

### BeanDefinition

这是一个普通类，保存了Bean的定义，包括名字，类型名，Class，参数等

### BeanDefinitionReader

BeanDefinitionReader为核心的接口,AbstractBeanDefinitionReader继承自BeanDefinitionReader，定义了读取bean的定义的流程，这是设计模式中的模板模式，我们先用一个抽象类定义好一个流程，完成部分步骤，某些步骤则由客户来自行完成，这样做既能规范流程又能增加系统的可扩展性。在这里使用模板模式，后续如果想增加由注解来获取Bean的定义的功能，则只需要实现AbstractBeanDefinitionReader即可。我们目前只实现XML读取，则实现一个XmlBeanDedinitionReader。

所以获取bean的定义就有以下流程：

* 1 由ResourceLoder返回一个Resource，并通过Rsource获取Inputstream
* 2 BeanDefinitionReader通过inputStream获取相应的bean定义并解析，保存。

### 装配bean
![BeanFactory](https://cl.ly/3p2N2b0z183f)


BeanFactory为核心接口，定义了getBean()方法，通过bean的名字来获取bean（这是一个工厂方法，是工厂模式的一种实现方法，这里bean由BeanFactory生成，并交由工厂方法bean返回，将用户和具体的bean解耦，解耦正是控制反转的目标）。和BeanDefinitionReader类似，这里也有一个AbstractBeanFactory,它定义了装载bean的流程，将生成bean的关键部分交由实现类来完成。这里我们完成了一个AutowireCapableBeanFactory来实现bean的自动装载。

## 应用上下文

![应用上下文](https://cl.ly/0g3U3V1Q2K0M)

现在整个IoC容器几乎大功告成了，但是获取bean的定义和bean的装载并未连接在一起，所以需要一个上下文来完成这整一个流程，于是就有了ApplicationContext接口为核心的一系列类。


ApplicationContext是一个继承BeanFactory的接口，这样做的目的是实现一个静态代理，然后ApplicationContext持有一个BeanFactory，用户获取bean时是从ApplicationContext来获取，这样就将用户和BeanFactory解耦了，用户不必持有一个BeanFactory对象，即可获取Bean的实现。

至于以ApplicationContext的实现类，和之前的类一样，都是使用一个抽象实现类来定义模板，然后再子类实现具体功能。这里就不再过多赘述。

# 总结
就算是IoC这么一个在JAVA开发中很常见的概念，要将其简单实现也是不容易的。想要提升自身JAVA编码能力，单纯去了解各种各样的特性是不够的。了解JVM，字节码不如动手写一个东西出来。
