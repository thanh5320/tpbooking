package com.project3.tpbooking.service;

import com.project3.tpbooking.data.model.request.HomeSearchRequest;
import com.project3.tpbooking.document.Hotel;
import com.project3.tpbooking.repository.es.EsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsService {
    private final EsRepository esRepository;

    public EsService(EsRepository esRepository) {
        this.esRepository = esRepository;
    }

    public List<Hotel> home(){
        return esRepository.homeSearch();
    }
    public List<Hotel> search(HomeSearchRequest request){
        return esRepository.search(request);
    }

    public Hotel findHotelById(String id){
        List<Hotel> result = esRepository.findById(id);
        if(result.size()>0){
            return result.get(0);
        }
        return null;
    }

    public List<Hotel> getAll(){
        return esRepository.getAll();
    }
}
