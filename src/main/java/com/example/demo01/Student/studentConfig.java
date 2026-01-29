package com.example.demo01.Student;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class studentConfig {
    @Bean
    CommandLineRunner commandLineRunner(studentRepository repository){
        return args -> {
            student harsh =new student(
                    "Harsh",
                    "harshg31m@gmail.com",
                    LocalDate.of(2001,01, 05)

            );

            student alex = new student(

                    "ALEX",
                    "ALex1m@gmail.com",
                    LocalDate.of(2004,01, 05)

            );
            repository.saveAll(
                    List.of(harsh, alex)
            );
        };
    }
}
