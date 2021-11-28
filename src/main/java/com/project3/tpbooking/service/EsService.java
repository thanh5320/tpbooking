package com.project3.tpbooking.service;

import com.project3.tpbooking.data.model.request.HomeSearchRequest;
import com.project3.tpbooking.document.Hotel;
import com.project3.tpbooking.repository.es.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EsService {
    private final HotelRepository hotelRepository;

    public EsService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> home(){
        return hotelRepository.homeSearch();
    }
    public List<Hotel> search(HomeSearchRequest request){
        return hotelRepository.search(request);
    }

    public Hotel findHotelById(String id){
        List<Hotel> result = hotelRepository.findById(id);
        if(result.size()>0){
            return result.get(0);
        }
        return null;
    }
}
