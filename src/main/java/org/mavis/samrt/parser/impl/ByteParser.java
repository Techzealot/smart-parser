package org.mavis.samrt.parser.impl;

import java.io.File;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import org.mavis.samrt.parser.Parser;

public abstract class ByteParser<T> implements Parser<T>{

	@Override
	public T Parse(String content) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T Parse(ByteBuffer buffer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T Parse(byte[] bytes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public abstract T Parse(byte[] bytes, Charset charset);

	@Override
	public T Parse(File file) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T Parse(InputStream is) {
		// TODO Auto-generated method stub
		return null;
	}

}
