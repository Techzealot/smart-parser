package org.mavis.samrt.parser;

import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public interface Parser<T> {
	T Parse(String content);
	T Parse(ByteBuffer buffer);
	T Parse(byte[] bytes);
	T Parse(byte[] bytes,Charset charset);
	T Parse(File file);
	T Parse(InputStream is);
}
