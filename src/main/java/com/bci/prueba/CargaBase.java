package com.bci.prueba;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class CargaBase {

  private static final Logger log = LoggerFactory.getLogger(CargaBase.class);

  @Bean
  CommandLineRunner initDatabase(UserRepository repository) {

    return args -> {
    	/*Phone tel = new Phone();
    	tel.setNumber("535342");
    	tel.setCitycode("23");
    	tel.setCountrycode("31");
    	Phone[] arr = new Phone[1];
    	arr[0] = tel;
    	Usuario user = new Usuario("Camilo Alvarez", "a@b.com");
    	Usuario user2 = new Usuario("Sebastian Silva", "c@d.com");
      log.info("Preloading " + repository.save(user));
      log.info("Preloading " + repository.save(user2));*/
    };
  }
}