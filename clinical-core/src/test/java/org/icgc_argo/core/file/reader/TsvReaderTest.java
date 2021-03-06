package org.icgc_argo.core.file.reader;

import lombok.SneakyThrows;
import lombok.val;
import org.icgc_argo.core.file.model.DonorTsv;
import org.icgc_argo.core.file.model.SampleTsv;
import org.icgc_argo.core.file.model.SpecimenTsv;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

import static java.util.stream.Collectors.toUnmodifiableList;
import static org.junit.jupiter.api.Assertions.*;

class TsvReaderTest {

  @Test
  @SneakyThrows
  void DonorReaderTest() {
    val reader = new TsvReader<>(DonorTsv.class);
    val path = Paths.get(getClass().getResource("/fixtures/tsv/donor.tsv").getPath());

    val donors = reader.read(path, true).collect(toUnmodifiableList());
    assertEquals(donors.get(0).getSubmitterId(), "ICGC_0001");
    assertEquals(donors.size(), 461);
  }

  @Test
  @SneakyThrows
  void SpecimenReaderTest() {
    val reader = new TsvReader<>(SpecimenTsv.class);
    val path = Paths.get(getClass().getResource("/fixtures/tsv/specimen.tsv").getPath());

    val specimens = reader.read(path, true).collect(toUnmodifiableList());
    assertEquals(specimens.get(0).getSpecimenSubmitterId(), "8013858");
    assertEquals(specimens.get(33).getSpecimenType(), "Pleural effusion");
    assertEquals(specimens.size(), 1657);
  }

  @Test
  @SneakyThrows
  void SampleReaderTest() {
    val reader = new TsvReader<>(SampleTsv.class);
    val path = Paths.get(getClass().getResource("/fixtures/tsv/sample.tsv").getPath());

    val samples = reader.read(path, true).collect(toUnmodifiableList());
    assertEquals(samples.get(0).getSampleSubmitterId(), "8013858");
    assertEquals(samples.get(33).getSampleSubmitterId(), "8031123");
    assertEquals(samples.size(), 1657);
  }

}