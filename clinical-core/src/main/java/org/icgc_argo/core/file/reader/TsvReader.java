package org.icgc_argo.core.file.reader;

import com.fasterxml.jackson.core.util.Separators;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class TsvReader<T> {

  /**
   * Constants
   */
  private static CsvMapper MAPPER = new CsvMapper();

  /**
   * State
   */
  private CsvSchema schema;
  private Class<T> tClass;

  public TsvReader(Class<T> tClass) {
    this.tClass = tClass;
    this.schema = MAPPER.schemaFor(tClass).withColumnSeparator('\t');
  }

  @SneakyThrows
  public Stream<T> read(Path path) {
    return Files.lines(path)
      .skip(1) // Skip over header
      .map(this::getEntity);
  }

  @SneakyThrows
  private T getEntity(String line) {
    return MAPPER.readerFor(tClass).with(schema).readValue(line);
  }

}
