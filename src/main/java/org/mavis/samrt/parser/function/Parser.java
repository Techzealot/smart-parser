package org.mavis.samrt.parser.function;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Objects;

import com.google.common.io.ByteStreams;

@FunctionalInterface
public interface Parser<T> {
	T parse(byte[] bytes);
	default Charset getCharset(){
		return StandardCharsets.UTF_8;
	}

	default T Parse(String content, Charset charset) {
		Objects.requireNonNull(content, "content is null");
		return parse(content.getBytes(getCharset()));
	}

	default T Parse(String content) {
		Objects.requireNonNull(content, "content is null");
		return parse(content.getBytes(Charset.defaultCharset()));
	}

	default T Parse(ByteBuffer buffer) {
		Objects.requireNonNull(buffer, "buffer is null");
		return parse(buffer.array());
	}

	default T Parse(File file) throws IOException {
		Objects.requireNonNull(file, "file is null");
		return parse(Files.readAllBytes(file.toPath()));
	}

	default T Parse(InputStream is) throws IOException {
		Objects.requireNonNull(is, "inputStream is null");
		return parse(ByteStreams.toByteArray(is));
	}
}
