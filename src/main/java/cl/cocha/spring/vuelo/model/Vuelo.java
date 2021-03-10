package cl.cocha.spring.vuelo.model;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document (collection = "vuelo")
public class Vuelo implements Serializable{
	
	@Id
	private Long idFligth;
	private String titleFlight;
	
	public Vuelo(String titleFlight) {
		super();
		this.titleFlight = titleFlight;
	}

	public Long getIdFligth() {
		return idFligth;
	}
	
	public void setIdFligth(Long idFligth) {
		this.idFligth = idFligth;
	}
	
	public String getTitleFlight() {
		return titleFlight;
	}
	
	public void setTitleFlight(String titleFlight) {
		this.titleFlight = titleFlight;
	}
	
}
