package es.neesis.security.service;

import es.neesis.security.entities.IP;
import es.neesis.security.repository.IPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IPDetailsServiceImpl {

    @Autowired
    private IPRepository ipRepository;

    public IP loadIP(String ip) {
        IP ipEntity = ipRepository.findByip(ip);
        if (ipEntity == null) {
            /*throw new IllegalArgumentException("IP address cannot be null or empty");*/
        }
        return ipEntity;
    }
}
