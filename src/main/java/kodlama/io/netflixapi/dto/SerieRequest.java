package kodlama.io.netflixapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SerieRequest {
    @NotBlank(message = "The name can't be left empty!")
    @Size(min = 3, max = 20, message = "The name should be between 3 and 20 characters!")
    private String name;
    @Size(max = 500, message = "The description can not be longer than 500 characters!")
    private String description;
}
