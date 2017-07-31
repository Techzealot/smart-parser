package org.mavis.samrt.parser.function;

import org.mavis.samrt.model.Source;

public interface SourceParser<T> {
	T parse(Source source);
}
