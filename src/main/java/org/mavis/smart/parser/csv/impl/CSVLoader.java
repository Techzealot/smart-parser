package org.mavis.smart.parser.csv.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.mavis.samrt.antlr4.parser.csv.CSVBaseListener;
import org.mavis.samrt.antlr4.parser.csv.CSVParser;
import org.mavis.samrt.antlr4.parser.csv.CSVParser.EmptyContext;
import org.mavis.samrt.antlr4.parser.csv.CSVParser.HdrContext;
import org.mavis.samrt.antlr4.parser.csv.CSVParser.RowContext;
import org.mavis.samrt.antlr4.parser.csv.CSVParser.StringContext;
import org.mavis.samrt.antlr4.parser.csv.CSVParser.TextContext;
import org.mavis.smart.model.CSVObject;

public class CSVLoader extends CSVBaseListener {
	public static final String EMPTY = "";
	private List<String> currentRowFieldValues = new ArrayList<>();
	private CSVObject csvObject = new CSVObject();
	private List<String> header = csvObject.getHeader();
	private List<Map<String, Object>> body = csvObject.getBody();

	@Override
	public void exitHdr(HdrContext ctx) {
		header.addAll(currentRowFieldValues);
	}

	@Override
	public void exitRow(RowContext ctx) {
		// if current row is header,do nothing
		// if(ctx.parent instanceof CSVParser.HdrContext) return; or
		if (ctx.getParent().getRuleIndex() == CSVParser.RULE_hdr)
			return;
		// if data row
		Map<String, Object> row = new LinkedHashMap<>();
		int i = 0;
		for (String filed : currentRowFieldValues) {
			row.put(header.get(i), filed);
			i++;
		}
		body.add(row);
	}

	@Override
	public void exitText(TextContext ctx) {
		currentRowFieldValues.add(ctx.TEXT().getText());
	}

	@Override
	public void exitString(StringContext ctx) {
		currentRowFieldValues.add(ctx.STRING().getText());
	}

	@Override
	public void exitEmpty(EmptyContext ctx) {
		currentRowFieldValues.add(EMPTY);
	}

	@Override
	public void enterRow(RowContext ctx) {
		// better clear the list instead of new one
		currentRowFieldValues.clear();
	}

	public CSVObject load() {
		return this.csvObject;
	}

}
