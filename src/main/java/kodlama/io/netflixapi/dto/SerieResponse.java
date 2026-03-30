package kodlama.io.netflixapi.dto;

import kodlama.io.netflixapi.model.SerieStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SerieResponse {
    private Long  id;
    private String name;
    private String description;
    private SerieStatus status;
    private LocalDateTime createdAt;
}
