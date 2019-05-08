package org.icgc_argo.server.service;

import java.sql.Date;
import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.icgc_argo.core.domain.Submission;
import org.icgc_argo.core.file.model.DonorTsv;
import org.icgc_argo.core.file.reader.TsvReader;
import org.icgc_argo.server.model.SubmissionDao;
import org.icgc_argo.server.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SubmissionService {

  private final SubmissionRepository repository;
  private final StorageService storageService;

  @Autowired
  public SubmissionService(SubmissionRepository repository, StorageService storageService) {
    this.repository = repository;
    this.storageService = storageService;
  }

  public SubmissionDao create(Submission submission) {
    val createEntity =
        SubmissionDao.builder()
            .name(submission.getName())
            .program(submission.getProgram())
            .created(Date.from(Instant.now()))
            .modified(Date.from(Instant.now()))
            .build();

    return repository.save(createEntity);
  }

  public void stage(String id) {
    log.info("Staging submission: {}", id);
    val filePaths = storageService.loadAll(id);
    val tsvReader = new TsvReader<>(DonorTsv.class);
    filePaths
        .filter(path -> path.toString().contains("donor"))
        .flatMap(path -> tsvReader.read(path, true))
        .forEach(System.out::println);
  }

  public Iterable<SubmissionDao> listAll() {
    return repository.findAll();
  }
}
