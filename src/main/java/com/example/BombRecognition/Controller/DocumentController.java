package com.example.BombRecognition.Controller;

import com.example.BombRecognition.Dto.DocumentResponseDTO;
import com.example.BombRecognition.Service.DocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/api/documents")
@Tag(name = "Document API", description = "Upload and classify documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }


    @PostMapping
    @Operation(summary = "Upload document (PDF or text)")
    public ResponseEntity<DocumentResponseDTO> uploadDocument(
            @RequestParam(required = false) MultipartFile file,
            @RequestParam(required = false) String text
    ) {

        DocumentResponseDTO response = documentService.processDocument(file, text);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }


    @GetMapping("/{id}/results")
    public ResponseEntity<DocumentResponseDTO> getResults(@PathVariable Long id) {

        DocumentResponseDTO response = documentService.getResults(id);

        return ResponseEntity.ok(response);
    }
}