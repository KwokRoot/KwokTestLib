package org.kwok.jython;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Test_Python {

	public static void main(String[] args) {

		String[] cmd = new String[] { "python", "-V"};
		try {
			/*
			 * ProcessBuilder processBuilder = new ProcessBuilder(cmd);
			 * Process process = processBuilder.start();
			 */
			Process process = Runtime.getRuntime().exec(cmd);

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader reader_error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			Stream.concat(reader.lines(), reader_error.lines()).forEach(
					line -> {
						System.out.println(line);
					}
			);

			int exitCode = process.waitFor();
			System.out.println("return " + exitCode);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
