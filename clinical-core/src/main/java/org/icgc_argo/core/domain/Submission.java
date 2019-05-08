package org.icgc_argo.core.domain;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Submission {

  private Long id;
  private String program;
  private String name;
  private Date created;
  private Date modified;

}
