package org.icgc_argo.core.file.reader;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import lombok.*;

import java.io.IOException;
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

  public Stream<T> read(@NonNull Path path, boolean containsHeader) throws IOException {
    Stream<String> stream = Files.readAllLines(path).stream();
    if (containsHeader) stream = stream.skip(1);
    return stream.map(this::getEntity);
  }

  @SneakyThrows
  private T getEntity(String line) {
    return MAPPER.readerFor(tClass).with(schema).readValue(line);
  }

}

