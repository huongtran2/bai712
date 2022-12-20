package huongtran.service;

import huongtran.model.type;
import huongtran.repository.TypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements ITypeService {
    @Autowired
    TypeRepo typeRepo;
    @Override
    public List<type> findAll() {
        return (List<type>) typeRepo.findAll();
    }

    public type findById(Long id){
        return typeRepo.findById(id).get();
    }
}
