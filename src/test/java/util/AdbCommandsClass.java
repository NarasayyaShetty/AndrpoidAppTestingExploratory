package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AdbCommandsClass {
	
	
	
	public static void runAdbCommand(String... command) {
        try {
            ProcessBuilder builder = new ProcessBuilder(command);
            builder.redirectErrorStream(true);
            Process process = builder.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static void launchApp(String activityName){
		runAdbCommand("adb", "shell", "am", "start", "-n", activityName);
	}

}
