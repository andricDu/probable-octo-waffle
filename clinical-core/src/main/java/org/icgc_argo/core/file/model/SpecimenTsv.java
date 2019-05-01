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
  "specimen_type",
  "normal_or_tumour_designation",
  "histological_type",
  "aquistion_interval", // TODO: Fix spelling in data model.
  "anatomic_location_of_specimen_collection",
  "central_pathology_confirmed",
  "tumor_grading_system", // TODO: Ask why tumor is spelled differently here.
  "tumour_grade",
  "number_lymph_nodes",
  "percent_tumour_cells",
  "percent_proliferating_cells",
  "percent_inflammatory_tissue",
  "percent_stromal_cells",
  "percent_necrosis"
})
public class SpecimenTsv {

  @JsonProperty("donor_submitter_id")
  String donorSubmitterId;

  @JsonProperty("specimen_submitter_id")
  String specimenSubmitterId;

  @JsonProperty("specimen_type")
  String specimenType;

  @JsonProperty("normal_or_tumour_designation")
  String normalOrTumourDesignation;

  @JsonProperty("histological_type")
  String historologicalType;

  @JsonProperty("aquistion_interval")
  String aquisitionInterval;

  @JsonProperty("anatomic_location_of_specimen_collection")
  String anatomicLocationOfSpecimenCollection;

  @JsonProperty("central_pathology_confirmed")
  String centralPathologyConfirmed;

  @JsonProperty("tumor_grading_system")
  String tumourGradingSystem;

  @JsonProperty("tumour_grade")
  String tumourGrade;

  @JsonProperty("number_lymph_nodes")
  Integer numberOfLymphNodes;

  @JsonProperty("percent_tumour_cells")
  Double percentTumourCells;

  @JsonProperty("percent_proliferating_cells")
  Double perfectProfileratingCells;

  @JsonProperty("percent_inflammatory_tissue")
  Double percentInflammatoryTissue;

  @JsonProperty("percent_stromal_cells")
  Double PercentStromalCells;

  @JsonProperty("percent_necrosis")
  Double percentNecrosis;
}
