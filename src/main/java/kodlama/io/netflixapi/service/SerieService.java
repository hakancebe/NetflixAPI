package kodlama.io.netflixapi.service;

import kodlama.io.netflixapi.dto.SerieRequest;
import kodlama.io.netflixapi.dto.SerieResponse;
import kodlama.io.netflixapi.dto.SerieUpdate;
import kodlama.io.netflixapi.model.Serie;
import kodlama.io.netflixapi.repository.SeriesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SerieService {
    // declaring repository

    SeriesRepository seriesRepository;

    public SerieService(SeriesRepository seriesRepository) {
        this.seriesRepository = seriesRepository;
    }

   public SerieResponse createSeries(SerieRequest seriesRequest) {
        Serie serie = new Serie();
        serie.setName(seriesRequest.getName());
        serie.setDescription(seriesRequest.getDescription());

        Serie savedSerie = seriesRepository.save(serie);

        return convertToResponse(savedSerie);
   }

   public SerieResponse convertToResponse(Serie serie) {
        SerieResponse serieResponse = new SerieResponse();
        serieResponse.setId(serie.getId());
        serieResponse.setName(serie.getName());
        serieResponse.setDescription(serie.getDescription());
        serieResponse.setCreatedAt(serie.getCreatedAt());
        serieResponse.setStatus(serie.getStatus());

        return serieResponse;

   }

   public SerieResponse getSerieById(Long id){
        Serie serie = seriesRepository.findById(id).
                orElseThrow(() -> new RuntimeException("The series didn't find " + id));
        return convertToResponse(serie);
   }

   public SerieResponse updateSerieById(Long id, SerieUpdate updateRequest) {
        Serie serie = seriesRepository.findById(id).
                orElseThrow(() -> new RuntimeException("The series didn't find " + id));

        if(serie.getName() !=  null) {
            serie.setName(updateRequest.getName());
        }

       if(serie.getDescription() !=  null) {
           serie.setDescription(updateRequest.getDescription());
       }

       if(serie.getStatus() !=  null) {
           serie.setStatus(updateRequest.getStatus());
       }

       Serie updatedSerie = seriesRepository.save(serie);

       return convertToResponse(updatedSerie);
   }

   public void deleteSerieById(Long id){
        Serie serie = seriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("The series didn't find " + id));
        seriesRepository.delete(serie);
   }

   public List<SerieResponse> getAllSeries() {
        return seriesRepository.findAll()
                .stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
   }

    public List<SerieResponse> syncSeriesBulk (List<SerieRequest> incomingSeries) {
        List<Serie> existingSeries = seriesRepository.findAll();

        HashMap<String, Serie> taskMap = new HashMap<>();
        for(Serie s : existingSeries){
            taskMap.put(s.getName(), s);
        }

        List<Serie> seriesToSave = new ArrayList<>();

        for(SerieRequest incomingSerie : incomingSeries){
            Serie matchedSerie = taskMap.get(incomingSerie.getName());

            if(matchedSerie != null){
             matchedSerie.setDescription(incomingSerie.getDescription());
             seriesToSave.add(matchedSerie);
            } else {
                Serie newSerie = new Serie();
                newSerie.setName(incomingSerie.getName());
                newSerie.setDescription(incomingSerie.getDescription());
                seriesToSave.add(newSerie);
            }

        }
        List<Serie> savedSeries = seriesRepository.saveAll(seriesToSave);

        return savedSeries.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
    }

}
