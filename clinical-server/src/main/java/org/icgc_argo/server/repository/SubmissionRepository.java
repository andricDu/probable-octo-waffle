package org.icgc_argo.server.repository;

import java.util.Optional;
import org.icgc_argo.server.model.SubmissionDao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmissionRepository extends CrudRepository<SubmissionDao, Long> {

  @Override
  Optional<SubmissionDao> findById(Long aLong);

  @Override
  Iterable<SubmissionDao> findAll();

  Optional<SubmissionDao> findByName(String name);
}
