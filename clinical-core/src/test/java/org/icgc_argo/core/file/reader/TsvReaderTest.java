package org.icgc_argo.core.file.reader;

import lombok.val;
import org.icgc_argo.core.file.model.DonorTsv;
import org.icgc_argo.core.file.model.SpecimenTsv;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static java.util.stream.Collectors.toUnmodifiableList;
import static org.junit.jupiter.api.Assertions.*;

class TsvReaderTest {

  @Test
  void DonorReaderTest() {
    val reader = new TsvReader<>(DonorTsv.class);
    val path = Paths.get(getClass().getResource("/fixtures/tsv/donor.tsv").getPath());

    val donors = reader.read(path).collect(toUnmodifiableList());
    assertEquals(donors.get(0).getSubmitterId(), "ICGC_0001");
    assertEquals(donors.size(), 461);
  }

  @Test
  void SpecimenReaderTest() {
    val reader = new TsvReader<>(SpecimenTsv.class);
    val path = Paths.get(getClass().getResource("/fixtures/tsv/specimen.tsv").getPath());

    val specimens = reader.read(path).collect(toUnmodifiableList());
    assertEquals(specimens.get(0).getSpecimenSubmitterId(), "8013858");
    assertEquals(specimens.size(), 1657);
  }

}