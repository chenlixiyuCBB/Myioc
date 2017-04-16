package com.test;

/**
 * Created by clxy on 2017/4/16.
 */
public class HelloWorldServiceImpl implements HelloWorldService {

	private String text;

	private OutputService outputService;


	public void helloWorld() {
		outputService.output(text);
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setOutputService(OutputService outputService) {
		this.outputService = outputService;
	}

}
