package org.mavis.samrt.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CSVObject {
	private List<String> header = new ArrayList<>();
	private List<Map<String, Object>> body = new ArrayList<>();

	public CSVObject() {
		super();
	}

	public CSVObject(List<String> header, List<Map<String, Object>> body) {
		super();
		this.header = header;
		this.body = body;
	}

	public int getSize() {
		return body.size();
	}

	public List<String> getHeader() {
		return header;
	}

	public void setHeader(List<String> header) {
		this.header = header;
	}

	public List<Map<String, Object>> getBody() {
		return body;
	}

	public void setBody(List<Map<String, Object>> body) {
		this.body = body;
	}

}
