package cl.cocha.spring.vuelo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import cl.cocha.spring.vuelo.model.Vuelo;
import cl.cocha.spring.vuelo.repository.VueloRepository;

@RestController
public class VueloController {
	
	@Autowired
	public VueloRepository vueloRepository;

	@GetMapping(value = "/all")
	public List<Vuelo> getAllVuelos() {
		
		return vueloRepository.findAll();
	}
	
	@PostMapping(value = "/createVuelo")
	public String createVuelo(@RequestBody Vuelo vuelo) {
		
		Vuelo insertedVuelo = vueloRepository.insert(vuelo);
		return "Vuelo registrado "+ insertedVuelo.getTitleFlight();
	}
	
	@PutMapping(value = "/updateVuelo/{id}")
	public ResponseEntity<?> updateVueloById(@PathVariable("id") Long idFlight, @RequestBody Vuelo newVueloData) {
		Optional<Vuelo> idVueloEncontrada = vueloRepository.findById(idFlight);
			if (idVueloEncontrada.isPresent()) {
				
				Vuelo vueloEncontrado = idVueloEncontrada.get();
				vueloEncontrado.setIdFligth ( newVueloData.getIdFligth() != null ? newVueloData.getIdFligth() : vueloEncontrado.getIdFligth());
				vueloEncontrado.setTitleFlight ( newVueloData.getTitleFlight() != null ? newVueloData.getTitleFlight() : vueloEncontrado.getTitleFlight());
				vueloRepository.save(vueloEncontrado);
				return new ResponseEntity<>(vueloEncontrado, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>("Vuelo actualizado"+ idFlight, HttpStatus.NOT_FOUND);
			}
	}
	
}
