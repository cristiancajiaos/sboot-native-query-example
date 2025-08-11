package com.example.sbootnativequeryexample;

import com.example.sbootnativequeryexample.entity.Tutorial;
import com.example.sbootnativequeryexample.repository.TutorialRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbootNativeQueryExampleApplication implements CommandLineRunner {

  @Autowired
  TutorialRepository tutorialRepository;

  public static void main(String[] args) {
    SpringApplication.run(SbootNativeQueryExampleApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    /* Buscar por valor de columna published */
    // List<Tutorial> tutorials = tutorialRepository.findByPublished(true);
    // show(tutorials);

    /* Buscar por valor que sigue un patrón */
    List<Tutorial> tutorials = tutorialRepository.findByTitleLike("Java");
    show(tutorials);
  }

  private void show(List<Tutorial> tutorials) {
    tutorials.forEach(System.out::println);
  }
}
