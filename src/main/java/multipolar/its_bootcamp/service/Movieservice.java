package multipolar.its_bootcamp.service;

import multipolar.its_bootcamp.dto.MovieRequest;

public interface Movieservice {
    String save(MovieRequest movie);
    String get(Long id);
}
