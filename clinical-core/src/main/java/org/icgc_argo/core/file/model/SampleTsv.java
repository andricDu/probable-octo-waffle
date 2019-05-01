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
@JsonPropertyOrder({
  "donor_submitter_id",
  "specimen_submitter_id",
  "sample_submitter_id",
  "sample_type"
})
public class SampleTsv {

  @JsonProperty("donor_submitter_id")
  String donorSubmitterId;

  @JsonProperty("specimen_submitter_id")
  String specimenSubmitterId;

  @JsonProperty("sample_submitter_id")
  String sampleSubmitterId;

  @JsonProperty("sample_type")
  String sampleType;

}
