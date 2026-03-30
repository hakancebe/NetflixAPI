package kodlama.io.netflixapi.controller;

import jakarta.validation.Valid;
import kodlama.io.netflixapi.dto.SerieRequest;
import kodlama.io.netflixapi.dto.SerieResponse;
import kodlama.io.netflixapi.dto.SerieUpdate;
import kodlama.io.netflixapi.service.SerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/series")
public class SerieController {

    private final SerieService service;

    public SerieController(SerieService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<SerieResponse> createSeries(@Valid @RequestBody SerieRequest req) {
        SerieResponse res = service.createSeries(req);
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<SerieResponse>> getAllTasks() {
        return ResponseEntity.ok(service.getAllSeries());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SerieResponse> getTaskById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getSerieById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<SerieResponse> updateTask(@PathVariable Long id, @RequestBody SerieUpdate request) {
        return ResponseEntity.ok(service.updateSerieById(id, request));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        service.deleteSerieById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/bulk-sync")
    public ResponseEntity<List<SerieResponse>> syncTasksBulk(@RequestBody List<SerieRequest> requests) {
        List<SerieResponse> syncedTasks = service.syncSeriesBulk(requests);
        return ResponseEntity.ok(syncedTasks);
    }

}
