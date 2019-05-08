package org.icgc_argo.server.model;

import java.util.Date;
import javax.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "submission")
public class SubmissionDao {

  @Id
  @Column(name = "id")
  @EqualsAndHashCode.Include
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String program;
  private String name;
  private Date created;
  private Date modified;
}
