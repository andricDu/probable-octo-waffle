package org.icgc_argo.core.file.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({ "program_short_name", "submitter_id", "gender", "ethnicity", "vital_status", "causeOfDeath", "survival_time" })
public class DonorTsv {

  @JsonProperty("program_short_name")
  String program;

  @JsonProperty("submitter_id")
  String submitterId;

  @JsonProperty("gender")
  String gender;

  @JsonProperty("ethnicity")
  String ethnicity;

  @JsonProperty("vital_status")
  String vitalStatus;

  @JsonProperty("cause_of_death")
  String causeOfDeath;

  @JsonProperty("survival_time")
  Integer survivalTime;

}