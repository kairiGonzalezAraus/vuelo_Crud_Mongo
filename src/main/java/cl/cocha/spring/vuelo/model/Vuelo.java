package cl.cocha.spring.vuelo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Document (collection = "vuelo")
public class Vuelo {
	
	@Id
	@Field("_id")
	@JsonIgnore
	private String id;
	
	private Long idFlight;
	private String titleFlight;
	
	public Vuelo() {
		super();
	}

	public Long getIdFligth() {
		return idFlight;
	}
	
	public void setIdFligth(Long idFligth) {
		this.idFlight = idFligth;
	}
	
	public String getTitleFlight() {
		return titleFlight;
	}
	
	public void setTitleFlight(String titleFlight) {
		this.titleFlight = titleFlight;
	}
	
	@Override
	public String toString() {
		return "Vuelo [idFlight=" + idFlight + ", titleFlight=" + titleFlight + "]";
		
	}
	
}
