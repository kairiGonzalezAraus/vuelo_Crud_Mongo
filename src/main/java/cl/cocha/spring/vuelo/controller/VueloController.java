package cl.cocha.spring.vuelo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@GetMapping(value = "/singleVuelo/{_id}")
	public ResponseEntity<?> getSingleVuelo(@PathVariable("_id") String id) {
		Optional<Vuelo> idVueloEncontrada = vueloRepository.findById(id);
		if(idVueloEncontrada.isPresent()) {
			return new ResponseEntity<>(idVueloEncontrada.get(), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("no se encontro el Vuelo " + id, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PostMapping(value = "/createVuelo")
	public String createVuelo(@RequestBody Vuelo vuelo) {
		
		Vuelo insertedVuelo = vueloRepository.insert(vuelo);
		return "Vuelo registrado "+ insertedVuelo.getTitleFlight();
	}
	
	@PutMapping(value = "/updateVuelo/{_id}")
	public ResponseEntity<?> updateVueloById(@PathVariable("_id") String id, @RequestBody Vuelo newVueloData) {
		Optional<Vuelo> idVueloEncontrada = vueloRepository.findById(id);
			if (idVueloEncontrada.isPresent()) {
				
				Vuelo vueloEncontrado = idVueloEncontrada.get();
				vueloEncontrado.setSupplierId ( newVueloData.getSupplierId() != null ? newVueloData.getSupplierId() : vueloEncontrado.getSupplierId());
				vueloEncontrado.setTitleFlight ( newVueloData.getTitleFlight() != null ? newVueloData.getTitleFlight() : vueloEncontrado.getTitleFlight());		
				vueloEncontrado.setDescriptionFlight( newVueloData.getDescriptionFlight() != null ? newVueloData.getDescriptionFlight() : vueloEncontrado.getDescriptionFlight());
				vueloEncontrado.setImageFlight( newVueloData.getImageFlight() != null ? newVueloData.getImageFlight() : vueloEncontrado.getImageFlight());
				vueloEncontrado.setOriginFlightCode( newVueloData.getOriginFlightCode() != null ? newVueloData.getOriginFlightCode() : vueloEncontrado.getOriginFlightCode());
				vueloEncontrado.setLocationFlightCode( newVueloData.getLocationFlightCode() != null ? newVueloData.getLocationFlightCode() : vueloEncontrado.getLocationFlightCode());	
				vueloRepository.save(vueloEncontrado);
				return new ResponseEntity<>(vueloEncontrado, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>("Vuelo no actualizado "+ id, HttpStatus.NOT_FOUND);
			}
	}
	
	@DeleteMapping(value = "/deleteVuelo/{_id}")
	public ResponseEntity<?> deleteVueloById(@PathVariable("_id") String id){
		try {
			vueloRepository.deleteById(id);
			return new ResponseEntity<>("Vuelo eliminado exitosamente "+ id, HttpStatus.OK);	
		} 
		catch (Exception e){
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
}
