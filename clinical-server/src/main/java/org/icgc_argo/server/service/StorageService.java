package org.icgc_argo.server.service;

import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

  void init();

  void store(MultipartFile file, String submission);

  Stream<Path> loadAll();

  Stream<Path> loadAll(String submission);

  Path load(String filename);

  Resource loadAsResource(String filename);

  void deleteAll();
}
