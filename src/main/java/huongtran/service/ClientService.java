package huongtran.service;

import huongtran.model.Client;
import huongtran.repository.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientService implements IClientService {
    @Autowired
    ClientRepo clientRepo;

    @Override
    public Page<Client> findAll(Pageable pageable) {
        return clientRepo.findAll(pageable);
    }

    @Override
    public List<Client> findAll() {
        return (List<Client>) clientRepo.findAll();
    }

    @Override
    public void save(Client client) {
        clientRepo.save(client);
    }

    @Override
    public void delete(long id) {
        clientRepo.deleteById(id);
    }

    @Override
    public Optional<Client> findById(long id) {
        return clientRepo.findById(id);
    }

}
