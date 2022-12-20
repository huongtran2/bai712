package huongtran.service;

import huongtran.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    public Page<Client> findAll(Pageable pageable);
    public List<Client> findAll();
    public void save(Client client);
    public void delete(long id);
    public Optional<Client> findById(long id);
}
