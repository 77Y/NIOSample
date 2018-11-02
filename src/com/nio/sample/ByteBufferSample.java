package com.nio.sample;

import java.nio.ByteBuffer;

public class ByteBufferSample {

	public static void main(String[] args) {
	

		ByteBuffer buffer = ByteBuffer.allocate(10);

		System.out.format("positon:%d remaining:%d limit:%d capacity:%d\n", buffer.position(), buffer.remaining(),
				buffer.limit(), buffer.capacity());

		String str = "ABC";
		byte[] bytes = str.getBytes();

		System.out.format("bytes length :%d\n", bytes.length);

		buffer.put(bytes);

		System.out.format("positon:%d remaining:%d limit:%d capacity:%d\n", buffer.position(), buffer.remaining(),
				buffer.limit(), buffer.capacity());

		buffer.flip();
		System.out.format("positon:%d remaining:%d limit:%d capacity:%d\n", buffer.position(), buffer.remaining(),
				buffer.limit(), buffer.capacity());

		Byte byte1 = buffer.get();
		System.out.format("positon:%d remaining:%d limit:%d capacity:%d\n", buffer.position(), buffer.remaining(),
				buffer.limit(), buffer.capacity());
		System.out.println("byte1 = " + byte1.toString());

		buffer.mark();

		Byte byte2 = buffer.get();
		System.out.format("positon:%d remaining:%d limit:%d capacity:%d\n", buffer.position(), buffer.remaining(),
				buffer.limit(), buffer.capacity());
		System.out.println("byte2 = " + byte2.toString());

		buffer.reset();

		System.out.format("positon:%d remaining:%d limit:%d capacity:%d\n", buffer.position(), buffer.remaining(),
				buffer.limit(), buffer.capacity());

		Byte byte3 = buffer.get();
		System.out.format("positon:%d remaining:%d limit:%d capacity:%d\n", buffer.position(), buffer.remaining(),
				buffer.limit(), buffer.capacity());
		System.out.println("byte3 = " + byte3.toString());

		buffer.rewind();

		System.out.format("positon:%d remaining:%d limit:%d capacity:%d\n", buffer.position(), buffer.remaining(),
				buffer.limit(), buffer.capacity());

		buffer.clear();

		System.out.format("positon:%d remaining:%d limit:%d capacity:%d\n", buffer.position(), buffer.remaining(),
				buffer.limit(), buffer.capacity());

		// buffer.put("D".getBytes());
		//
		// System.out.format("positon:%d remaining:%d limit:%d capacity:%d\n",
		// buffer.position(), buffer.remaining(),
		// buffer.limit(), buffer.capacity());
		//
		// System.out.println("byte4 = " + buffer.get());

	}
}
