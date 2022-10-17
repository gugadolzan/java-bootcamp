package br.com.dh.spring03;

//import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@Log4j2
@SpringBootApplication
public class Spring03Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring03Application.class, args);
        //        log.info("info");
        //        log.warn("warn");
        //        log.error("error");
    }
}
