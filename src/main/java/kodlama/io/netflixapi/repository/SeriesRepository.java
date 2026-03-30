package kodlama.io.netflixapi.repository;

import kodlama.io.netflixapi.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeriesRepository extends JpaRepository<Serie, Long> {
}
