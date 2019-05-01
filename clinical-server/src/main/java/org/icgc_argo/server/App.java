package org.icgc_argo.server;

import org.icgc_argo.server.config.StorageProperties;
import org.icgc_argo.server.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class App {

  public static void main(String... args) {
    SpringApplication.run(App.class);
  }

  @Bean
  CommandLineRunner init(StorageService storageService) {
    return (args) -> {
      storageService.deleteAll();
      storageService.init();
    };
  }

}
