package ar.edu.ungs.spymensseger.modules.shared.persistence.file;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.file.Paths;

public abstract class FileRepository {
	private final String fileName;

	public FileRepository(String fileName) {
		this.fileName = fileName;
	}

	protected void write(String object) {
		try (FileWriter file = new FileWriter(fileName)) {
			file.write(object);
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void write(JSONObject object) {
		write(object.toJSONString());
	}

	protected void write(JSONArray array) {
		try (FileWriter file = new FileWriter(fileName)) {
			file.write(array.toJSONString());
			file.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected JSONArray read() {
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader(fileName)) {
			Object obj = jsonParser.parse(reader);

			return (JSONArray) obj;
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public void clean() {
		write("");
	}
}
