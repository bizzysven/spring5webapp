package guru.springframework.spring5webapp.repoistories;

import guru.springframework.spring5webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

// The CrudRepoistory has two generics (The Entity and the ID)
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
