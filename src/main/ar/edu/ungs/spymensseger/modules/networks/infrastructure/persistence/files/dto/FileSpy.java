package ar.edu.ungs.spymensseger.modules.networks.infrastructure.persistence.files.dto;

import ar.edu.ungs.spymensseger.modules.spies.domain.Spy;
import org.json.simple.JSONObject;

import java.util.Objects;

public final class FileSpy {
	private final Integer id;
	private final String name;

	public FileSpy(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public static FileSpy map(Spy aggregate){
		return new FileSpy(aggregate.id(), aggregate.name());
	}

	public static Spy map(FileSpy dto) {
		return new Spy(dto.id(), dto.name());
	}

	public static JSONObject toJson(FileSpy dto){
		return new JSONObject() {{
			put("id", dto.id());
			put("name", dto.name());
		}};
	}

	public static FileSpy fromJson(JSONObject jsonObject) {
		return new FileSpy(Integer.valueOf(jsonObject.get("id").toString()),
		                   (String) jsonObject.get("name"));
	}

	public Integer id() {
		return id;
	}

	public String name() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		FileSpy fileSpy = (FileSpy) o;
		return Objects.equals(id, fileSpy.id) && Objects.equals(name, fileSpy.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public String toString() {
		return "FileSpy{" + "id=" + id + ", name='" + name + '\'' + '}';
	}
}
