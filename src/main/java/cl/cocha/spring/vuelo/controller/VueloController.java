package cl.cocha.spring.vuelo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import cl.cocha.spring.vuelo.model.Vuelo;
import cl.cocha.spring.vuelo.repository.VueloRepository;

@RestController
public class VueloController {
	
	@Autowired
	public VueloRepository vueloRepository;

	@GetMapping (value = "/all")
	public List<Vuelo> getAllVuelos() {
		
		return vueloRepository.findAll();
	}
	
	@PostMapping (value = "/createVuelo")
	public String createVuelo(@RequestBody Vuelo vuelo) {
		
		Vuelo insertedVuelo = vueloRepository.insert(vuelo);
		return "Vuelo registrado" + insertedVuelo.getTitleFlight();
	}
	
}
