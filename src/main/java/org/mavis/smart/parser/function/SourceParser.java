package org.mavis.smart.parser.function;

import org.mavis.smart.model.Source;

public interface SourceParser<T> {
	T parse(Source source);
}
