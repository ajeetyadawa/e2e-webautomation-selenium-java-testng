package Util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunCommandLine {

	public static void executeCMD(String cmd) throws InterruptedException, IOException {
		Runtime run = Runtime.getRuntime();
		Process process = run.exec(cmd);
		process.waitFor();
		BufferedReader buf = new BufferedReader(new InputStreamReader(process.getInputStream()));
		String line ="";
		while((line=buf.readLine())!=null) {
			System.out.println(line);
		}
		System.out.println("Command Line Execution Completed");
	}
	
}
