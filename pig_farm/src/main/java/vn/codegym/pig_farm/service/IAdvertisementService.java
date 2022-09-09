package vn.codegym.pig_farm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.pig_farm.entity.Advertisement;
import vn.codegym.pig_farm.projection.IAdvertisementProjection;

import java.util.Optional;

public interface IAdvertisementService {
    /**
     * @param pageable
     * @param keySearch
     * @return List Advertisement, status 200
     * @function (Query to display all Advertisement and search)
     * @creator DucNH
     * @date-create 08/09/2022
     */
    Page<IAdvertisementProjection> findAllAdvertisement(Pageable pageable, String keySearch);

    /**
     * @param id must not be
     * @return Advertisement, status 200
     * @function (Query to Advertisement)
     * @creator DucNH
     * @date-create 08/09/2022
     */
    Optional<Advertisement> findById(int id);

    /**
     * @param id
     * @function (Query to delete Advertisement)
     * @creator DucNH
     * @date-create 08/09/2022
     */
    void deleteAdvertisement(int id);
}
