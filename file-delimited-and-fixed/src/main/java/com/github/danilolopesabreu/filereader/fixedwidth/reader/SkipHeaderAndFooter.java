package com.github.danilolopesabreu.filereader.fixedwidth.reader;

import org.springframework.batch.item.file.LineCallbackHandler;

public class SkipHeaderAndFooter implements LineCallbackHandler {

	@Override
	public void handleLine(String line) {
		System.out.println(line);
	}

}
