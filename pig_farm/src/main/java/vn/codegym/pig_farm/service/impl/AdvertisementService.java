package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.Advertisement;
import vn.codegym.pig_farm.repository.IAdvertisementRepository;
import vn.codegym.pig_farm.service.IAdvertisementService;

import java.util.List;
import java.util.Optional;

@Service
public class AdvertisementService implements IAdvertisementService {
    @Autowired
    private IAdvertisementRepository advertisementRepository;


    /**
     * Created by : ChungHV
     * Date create : 9/8/2022
     * Function : Post Advertisement
     * @param advertisement
     */
    @Override
    public void saveAdvertisement(Advertisement advertisement) {
        advertisementRepository.saveAdvertisement(advertisement.getImage(),advertisement.getSubmittedDate(),advertisement.getTimeExistence()
        ,advertisement.getTitle(),advertisement.getPlacement().getId());
    }

    /**
     * Created by : ChungHV
     * Date create : 9/8/2022
     * Function : Update Advertisement
     * @param advertisement
     */
    @Override
    public void updateAdvertisement(Advertisement advertisement) {
          advertisementRepository.updateAdvertisement(advertisement.getImage(),advertisement.getSubmittedDate(),advertisement.getTimeExistence()
                  ,advertisement.getTitle(),advertisement.getPlacement().getId(),advertisement.getId());
    }

    /**
     * Created by : ChungHV
     * Date create : 9/8/2022
     * Function : FindById Advertisement
     * @param id
     * @return :Optional<Advertisement>
     */
    @Override
    public Optional<Advertisement> findById(Integer id) {
        return advertisementRepository.findById(id);
    }
}