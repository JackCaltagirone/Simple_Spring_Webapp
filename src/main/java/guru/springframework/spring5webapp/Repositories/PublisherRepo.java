package guru.springframework.spring5webapp.Repositories;

import guru.springframework.spring5webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepo extends CrudRepository<Publisher, Long> {
}
