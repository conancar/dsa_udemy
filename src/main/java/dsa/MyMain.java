package dsa;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MyMain {

	public static void main(String[] args) {

	}

	public static String getBytesOfObject(Object object) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(baos);
		out.writeObject(object);
		out.close();
		return "Bytes size="+baos.toByteArray().length;
	}

}