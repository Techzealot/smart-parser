package org.mavis.smart.parser;

import java.io.IOException;
import java.nio.file.Paths;

import org.junit.Test;
import org.mavis.samrt.model.CSVObject;
import org.mavis.samrt.parser.csv.impl.CSVParsers;

public class CSVParsersTest {
	@Test
	public void testParse() throws IOException{
		CSVParsers<Object> parser=new CSVParsers<>();
		CSVObject csvObject = parser.parse(Paths.get("src","test","java","test.csv"));
		System.out.println(csvObject.getHeader());
		System.out.println(csvObject.getBody());
	}
}
