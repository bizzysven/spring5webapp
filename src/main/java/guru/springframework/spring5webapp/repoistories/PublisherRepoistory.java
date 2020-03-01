package guru.springframework.spring5webapp.repoistories;

import guru.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepoistory extends CrudRepository<Publisher, Long> {
}
