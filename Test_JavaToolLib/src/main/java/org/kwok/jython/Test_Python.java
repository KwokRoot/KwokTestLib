package org.kwok.jython;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

			int exitCode = process.waitFor();
			System.out.println("return " + exitCode);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
