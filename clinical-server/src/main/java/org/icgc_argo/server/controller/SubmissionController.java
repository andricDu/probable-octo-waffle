package org.icgc_argo.server.controller;

import org.icgc_argo.core.domain.Submission;
import org.icgc_argo.server.model.SubmissionDao;
import org.icgc_argo.server.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/submissions")
public class SubmissionController {

  private final SubmissionService service;

  @Autowired
  public SubmissionController(SubmissionService service) {
    this.service = service;
  }

  @PostMapping
  public ResponseEntity<SubmissionDao> createSubmission(@RequestBody Submission submission) {
    return ResponseEntity.ok(service.create(submission));
  }

  @PostMapping("/{id}/stage")
  public ResponseEntity<String> stageSubmission(@PathVariable("id") String id) {
    service.stage(id);
    return ResponseEntity.ok("foobar");
  };

  @GetMapping
  public ResponseEntity<Iterable<SubmissionDao>> listSubmissions() {
    return ResponseEntity.ok(service.listAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<String> getSubmission(@PathVariable("id") String id) {
    return ResponseEntity.ok(id);
  }
}
