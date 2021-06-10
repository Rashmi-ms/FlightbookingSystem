package Resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightbookingsystem.passengerservice.model.Passenger;
import com.flightbookingsystem.passengerservice.repository.PassengerRepository;

@RestController
@RequestMapping("/Passenger")
public class PassengerResource {
	
	@Autowired
	private PassengerRepository repo;
	
	@PostMapping("/addPassenger")
	public String savePassenger(@RequestBody Passenger passenger) {
		repo.save(passenger);
		return "added passenger with id:" + passenger.getUser_id();
	}
	
	
	
	@GetMapping("/findAllPassenger")
	public List<Passenger> getPassenger(){
		return repo.findAll();
	}
	
	@GetMapping("/findAllPassenger/{age}")
	public Optional<Passenger> getPassenger(@PathVariable int age){
		return repo.findByAge(age);
	}

	
	@DeleteMapping("/delete/{age}")
	public String deletePassenger(@PathVariable int age) {
		repo.deleteByAge(age);
		return "Passenger deleted with age:"+age;
	}
	
	@PutMapping("/update/{age}")
	public Passenger updatePassenger(@PathVariable int age, @RequestBody Passenger passenger) {
		passenger.setAge(age);
		repo.save(passenger);
		return passenger;
	}

}
