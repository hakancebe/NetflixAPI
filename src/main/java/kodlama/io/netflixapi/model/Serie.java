package kodlama.io.netflixapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "netflix")
public class Serie {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable=false)
private String name;

@Enumerated(EnumType.STRING)
private SerieStatus status;

private String description;

private LocalDateTime createdAt;

@PrePersist
public void onCreate() {
    createdAt = LocalDateTime.now();

    if(status == null) {
        status = SerieStatus.TODO;
    }

}

}
