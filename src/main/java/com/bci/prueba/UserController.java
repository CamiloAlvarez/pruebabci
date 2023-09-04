package com.bci.prueba;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserController {

  private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
  private final UserRepository repository;
  private final PhoneRepository phoneRepository;

  UserController(UserRepository repository, PhoneRepository phoneRepository) {
    this.repository = repository;
    this.phoneRepository = phoneRepository;
  }


  @GetMapping("/usuarios")
  	List<ResponseUser> getUsuarios() {
	List<ResponseUser> res = new ArrayList<ResponseUser>();
    List<Usuario> listaUsuario = repository.findAll();
    listaUsuario.forEach(lu -> {
    	ResponseUser ru = new ResponseUser();
    	ru.setName(lu.getName());
    	ru.setEmail(lu.getEmail());
    	ru.setPass(lu.getPass());
    	//log.info(lu.getPhones().getNumber());
        res.add(ru);
    });
    return res;
  }

  @PostMapping("/crearUsuario")
  Usuario newUsuario(@RequestBody RequestUser newUser) {
	Usuario saveUser = new Usuario();
	saveUser.setName(newUser.getName());
	saveUser.setEmail(newUser.getEmail());
	saveUser.setPass(newUser.getPass());
	
	String format = "MM-dd-yyyy HH:mm:ss";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
	String date = simpleDateFormat.format(new Date());
	saveUser.setCreated(date);
	saveUser.setModified(date);
	saveUser.setIsActive(Long.parseLong("1"));
	
	String regexPattern = "^(.+)@(\\S+)$";
	
	if(!Pattern.compile(regexPattern).matcher(newUser.getEmail()).matches()) {
		throw new InvalidEmailException();
	} else {
		List<Usuario> correo = repository.findByEmail(newUser.getEmail());
		if(correo.size() <= 0) {
		    Usuario res = repository.save(saveUser);
		    Phone savePhone = new Phone();
		    savePhone.setNumber(newUser.getPhones()[0].getNumber());
		    savePhone.setCitycode(newUser.getPhones()[0].getCitycode());
		    savePhone.setCountrycode(newUser.getPhones()[0].getCountrycode());
		    savePhone.setUser(res);
		    phoneRepository.save(savePhone);
		    return res;
		} else {
			throw new EmailExistsException();
		}
	}
  }

  // Usuario unico
  
  @GetMapping("/usuario/{id}")
  Usuario getUsuario(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new UserNotFoundException(id));
  }

  @PostMapping("/editarUsuario/{id}")
  Usuario editUsuario(@RequestBody RequestUser newUser, @PathVariable Long id) {
	Usuario saveUser = repository.findById(id).get();
	saveUser.setName(newUser.getName());
	saveUser.setEmail(newUser.getEmail());
	saveUser.setPass(newUser.getPass());
	
	String format = "MM-dd-yyyy HH:mm:ss";
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
	String date = simpleDateFormat.format(new Date());
	saveUser.setModified(date);
	
	String regexPattern = "^(.+)@(\\S+)$";
	
	if(!Pattern.compile(regexPattern).matcher(newUser.getEmail()).matches()) {
		throw new InvalidEmailException();
	} else {
	    Usuario res = repository.save(saveUser);
	    Phone savePhone = new Phone();
	    savePhone.setNumber(newUser.getPhones()[0].getNumber());
	    savePhone.setCitycode(newUser.getPhones()[0].getCitycode());
	    savePhone.setCountrycode(newUser.getPhones()[0].getCountrycode());
	    savePhone.setUser(res);
	    phoneRepository.save(savePhone);
	    return res;
	}
    /*return repository.findById(id)
      .map(user -> {
    	  user.setName(newUser.getName());
    	  user.setEmail(newUser.getEmail());
        return repository.save(user);
      })
      .orElseGet(() -> {
        newUser.setId(id);
        return repository.save(newUser);
      });*/
  }

  @DeleteMapping("/eliminarUsuario/{id}")
  void deleteUsuario(@PathVariable Long id) {
    repository.deleteById(id);
  }
}