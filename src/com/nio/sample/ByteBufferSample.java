package com.nio.sample;

import java.nio.ByteBuffer;

public class ByteBufferSample {

	public static void main(String[] args) {

		ByteBuffer buffer = ByteBuffer.allocate(10);

		System.out.format("初始化 positon:%d remaining:%d limit:%d capacity:%d\n", buffer.position(), buffer.remaining(),
				buffer.limit(), buffer.capacity());

		String str = "ABC";
		byte[] bytes = str.getBytes();

		System.out.format("bytes length :%d\n", bytes.length);

		buffer.put(bytes);

		System.out.format("put调用后 positon:%d remaining:%d limit:%d capacity:%d\n", buffer.position(),
				buffer.remaining(), buffer.limit(), buffer.capacity());

		buffer.flip();
		System.out.format("flip调用后 positon:%d remaining:%d limit:%d capacity:%d\n", buffer.position(),
				buffer.remaining(), buffer.limit(), buffer.capacity());

		Byte byte1 = buffer.get();
		System.out.format("get调用后 positon:%d remaining:%d limit:%d capacity:%d\n", buffer.position(),
				buffer.remaining(), buffer.limit(), buffer.capacity());
		System.out.println("byte1 = " + byte1.toString());

		buffer.mark();

		System.out.format("mark调用后  positon:%d remaining:%d limit:%d capacity:%d\n", buffer.position(),
				buffer.remaining(), buffer.limit(), buffer.capacity());

		Byte byte2 = buffer.get();
		System.out.format("第二次get调用后 positon:%d remaining:%d limit:%d capacity:%d\n", buffer.position(),
				buffer.remaining(), buffer.limit(), buffer.capacity());
		System.out.println("byte2 = " + byte2.toString());

		buffer.reset();

		System.out.format("reset调用后 positon:%d remaining:%d limit:%d capacity:%d\n", buffer.position(),
				buffer.remaining(), buffer.limit(), buffer.capacity());

		Byte byte3 = buffer.get();
		System.out.format("第三次get调用后 positon:%d remaining:%d limit:%d capacity:%d\n", buffer.position(),
				buffer.remaining(), buffer.limit(), buffer.capacity());
		System.out.println("byte3 = " + byte3.toString());

		buffer.rewind();

		System.out.format("rewind调用后 positon:%d remaining:%d limit:%d capacity:%d\n", buffer.position(),
				buffer.remaining(), buffer.limit(), buffer.capacity());

		buffer.clear();

		System.out.format("clear调用后 positon:%d remaining:%d limit:%d capacity:%d\n", buffer.position(),
				buffer.remaining(), buffer.limit(), buffer.capacity());

		// buffer.put("D".getBytes());
		//
		// System.out.format("positon:%d remaining:%d limit:%d capacity:%d\n",
		// buffer.position(), buffer.remaining(),
		// buffer.limit(), buffer.capacity());
		//
		// System.out.println("byte4 = " + buffer.get());

	}
}
