package cl.cocha.spring.vuelo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "vuelo")
public class Vuelo {
	
	@Id
	private String id;
	
	private String supplierId;
	private String titleFlight;
	private String descriptionFlight;
	private String imageFlight;
	private String originFlightCode;
	private String locationFlightCode;
	
	public Vuelo() {
		super();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSupplierId() {
		return supplierId;
	}
	
	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	
	public String getTitleFlight() {
		return titleFlight;
	}
	
	public void setTitleFlight(String titleFlight) {
		this.titleFlight = titleFlight;
	}
	
	public String getDescriptionFlight() {
		return descriptionFlight;
	}

	public void setDescriptionFlight(String descriptionFlight) {
		this.descriptionFlight = descriptionFlight;
	}

	public String getImageFlight() {
		return imageFlight;
	}

	public void setImageFlight(String imageFlight) {
		this.imageFlight = imageFlight;
	}

	public String getOriginFlightCode() {
		return originFlightCode;
	}

	public void setOriginFlightCode(String originFlightCode) {
		this.originFlightCode = originFlightCode;
	}

	public String getLocationFlightCode() {
		return locationFlightCode;
	}

	public void setLocationFlightCode(String locationFlightCode) {
		this.locationFlightCode = locationFlightCode;
	}

	@Override
	public String toString() {
		return "Vuelo [id=" + id + "supplierId=" + supplierId + ", titleFlight=" + titleFlight + 
				"descriptionFlight=" + descriptionFlight + "imageFlight=" + imageFlight + 
				"originFlightCode=" + originFlightCode + "locationFlightCode=" + locationFlightCode + "]";
	}
	
}
