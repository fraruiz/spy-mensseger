package ar.edu.ungs.persistence.file;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;

public abstract class FileRepository {
	private final String fileName;

	public FileRepository(String fileName) {
		this.fileName = fileName;
	}

	protected void write(String object) {
		try {
			write("src/main/resources/" + fileName, object);
		} catch (Exception e) {
			try {
				ClassLoader classLoader = getClass().getClassLoader();
				String filePath = classLoader.getResource(fileName).getPath();

				write(filePath, object);
			} catch (Exception error) {
				error.printStackTrace();
			}
		}
	}

	protected void write(JsonElement element) {
		write(element.toString());
	}

	public void clean() {
		write("");
	}

	private void write(String filePath, String object) {
		try (FileWriter file = new FileWriter(filePath)) {
			file.write(object);
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected JsonArray read() {
		try {
			return read("src/main/resources/" + fileName);
		} catch (Exception e) {
			try {
				ClassLoader classLoader = getClass().getClassLoader();
				String filePath = classLoader.getResource(fileName).getPath();

				return read(filePath);
			} catch (Exception error) {
				e.printStackTrace();
			}
		}

		return null;
	}

	private JsonArray read(String filePath) {
		JsonParser jsonParser = new JsonParser();

		try (FileReader reader = new FileReader(filePath)) {
			Object obj = jsonParser.parse(reader);

			return (JsonArray) obj;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
