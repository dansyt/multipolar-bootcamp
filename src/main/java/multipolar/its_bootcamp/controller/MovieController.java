package multipolar.its_bootcamp.controller;

import multipolar.its_bootcamp.dto.MovieRequest;
import multipolar.its_bootcamp.service.Movieservice;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MovieController {
    private final Movieservice movieservice;

    public MovieController(Movieservice movieservice){
        this.movieservice = movieservice;
    }
    @PostMapping(value = "/add")
    public String addMovie(@RequestBody MovieRequest request){
        String output = movieservice.save(request);
        return output;
    }
    @GetMapping(value = "/get/{id}")
    public String getDataStudentById(@PathVariable Long id){
        return movieservice.get(id);
    }
}
