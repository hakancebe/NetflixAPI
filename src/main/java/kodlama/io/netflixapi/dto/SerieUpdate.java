package kodlama.io.netflixapi.dto;

import kodlama.io.netflixapi.model.SerieStatus;
import lombok.Data;

@Data
public class SerieUpdate {
    private String name;
    private String description;
    private SerieStatus status;
}
