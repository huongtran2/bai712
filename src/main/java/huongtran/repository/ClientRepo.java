package huongtran.repository;

import huongtran.model.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface ClientRepo extends PagingAndSortingRepository<Client, Long> {


    @Query(value = "select s from Client s join type c on s.type.id = c.id where c.name =:name")
    public ArrayList<Client> findByNameClassZoom(@Param(value = "name") String name);

    @Query(nativeQuery = true, value = "select * from client order by name")
    public Page<Client> findAllOrderByName(Pageable pageable);}
