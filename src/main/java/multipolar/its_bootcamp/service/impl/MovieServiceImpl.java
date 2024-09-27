package multipolar.its_bootcamp.service.impl;

import multipolar.its_bootcamp.dto.MovieRequest;
import multipolar.its_bootcamp.entity.Movie;
import multipolar.its_bootcamp.repository.MovieRepository;
import multipolar.its_bootcamp.service.Movieservice;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImpl implements Movieservice {
    private MovieRepository movieRepository;
    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }
    @Override
    public String save(MovieRequest request){
        saveToDB(request);
        return "Success";
    }

    @Override
    public String get(Long id){
        Optional<Movie> movie = movieRepository.findById(id);
        if(movie.isPresent()){
            return "success";
        }else {
            return "data not found";
        }

    }

    private void saveToDB(MovieRequest request){
        Movie movie = new Movie();
        movie.setTitle(request.getTitle());
        movie.setGenre(request.getGenre());
        movie.setDuration(request.getDuration());
        movie.setDirector(request.getDirector());
        movie.setRating(request.getRating());

        movieRepository.save(movie);
    }
}
