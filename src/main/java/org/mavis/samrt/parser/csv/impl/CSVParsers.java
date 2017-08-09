package org.mavis.samrt.parser.csv.impl;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.mavis.samrt.antlr4.parser.csv.CSVLexer;
import org.mavis.samrt.antlr4.parser.csv.CSVParser;
import org.mavis.samrt.model.CSVObject;
import org.mavis.samrt.parser.impl.ByteParser;

public class CSVParsers<T> extends ByteParser<T> {

	private ParseTreeWalker walker = new ParseTreeWalker();

	@Override
	public T Parse(byte[] bytes, Charset charset) {
		return null;
	}

	public CSVObject parse(Path path) throws IOException {
		CSVLoader loader = new CSVLoader();
		walker.walk(loader, getParseTree(path));
		return loader.load();
	}

	private ParseTree getParseTree(Path path) throws IOException {
		CharStream stream = CharStreams.fromPath(path);
		CSVLexer lexer = new CSVLexer(stream);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		CSVParser parser = new CSVParser(tokens);
		return parser.csvFile();
	}

}
