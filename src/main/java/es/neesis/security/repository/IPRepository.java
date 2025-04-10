package es.neesis.security.repository;

import es.neesis.security.entities.IP;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPRepository extends CrudRepository<IP, Long> {
    public IP findByip(String ip);
}
