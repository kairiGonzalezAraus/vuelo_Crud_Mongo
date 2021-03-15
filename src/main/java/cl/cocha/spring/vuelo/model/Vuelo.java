package cl.cocha.spring.vuelo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "vuelo")
public class Vuelo {
	
	@Id
	private String id;
	
	private Long idFlight;
	private String titleFlight;
	
	public Vuelo() {
		super();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return "Vuelo [id=" + id + "idFlight=" + idFlight + ", titleFlight=" + titleFlight + "]";
		
	}
	
}
