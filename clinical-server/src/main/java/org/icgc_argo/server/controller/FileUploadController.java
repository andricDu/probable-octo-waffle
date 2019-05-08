package org.icgc_argo.server.controller;

import static java.util.stream.Collectors.toUnmodifiableList;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.val;
import org.icgc_argo.server.fs.StorageFileNotFoundException;
import org.icgc_argo.server.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FileUploadController {

  private final StorageService storageService;

  @Autowired
  public FileUploadController(StorageService storageService) {
    this.storageService = storageService;
  }

  @GetMapping("/")
  public String listUploadedFiles(Model model) throws IOException {

    model.addAttribute(
        "files",
        storageService
            .loadAll()
            .map(
                path ->
                    MvcUriComponentsBuilder.fromMethodName(
                            FileUploadController.class, "serveFile", path.getFileName().toString())
                        .build()
                        .toString())
            .collect(Collectors.toList()));

    return "uploadForm";
  }

  @GetMapping("/files/list/{id}")
  public ResponseEntity<List<String>> listFiles(@PathVariable String id) {
    val files =
        storageService
            .loadAll(id)
            .map(path -> path.getFileName().toString())
            .collect(toUnmodifiableList());

    return ResponseEntity.ok(files);
  }

  @GetMapping("/files/{filename:.+}")
  @ResponseBody
  public ResponseEntity<Resource> serveFile(@PathVariable String filename) {

    Resource file = storageService.loadAsResource(filename);
    return ResponseEntity.ok()
        .header(
            HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
        .body(file);
  }

  @PostMapping("/")
  public String handleFileUpload(
      @RequestParam("file") MultipartFile file,
      @RequestParam("submission") String submission,
      RedirectAttributes redirectAttributes) {

    storageService.store(file, submission);
    redirectAttributes.addFlashAttribute(
        "message", "You successfully uploaded " + file.getOriginalFilename() + "!");

    return "redirect:/";
  }

  @ExceptionHandler(StorageFileNotFoundException.class)
  public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException __) {
    return ResponseEntity.notFound().build();
  }
}
