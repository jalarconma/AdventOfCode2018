package main;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class FileUtil {
	
	public static String filterFileData(String fileName) throws IOException {
		String content = new String (Files.readAllBytes(Paths.get(getCurrentDirectory() + fileName)), Charset.forName("UTF-8"));
		return content;
	}
	
	private static String getCurrentDirectory() {
		return System.getProperty("user.dir") + "/src/main/";
	}

}
