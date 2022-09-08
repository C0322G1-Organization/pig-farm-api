package vn.codegym.pig_farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.entity.Advertisement;
import vn.codegym.pig_farm.entity.Placement;
import vn.codegym.pig_farm.repository.IPlacementRepository;
import vn.codegym.pig_farm.service.IAdvertisementService;
import vn.codegym.pig_farm.service.IPlacementService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/ads")
public class AdvertisementRestController {
    @Autowired
    private IAdvertisementService advertisementService;
    @Autowired
    private IPlacementService placementService;

    @GetMapping("/list")
    public ResponseEntity<List<Advertisement>> findAll(){
        return new ResponseEntity<>(advertisementService.findAllAdvertisement(), HttpStatus.OK);
    }

    /**
     * Created by :ChungHV
     * Date create : 9/8/2022
     * Function : show list placement
     * @return : Http.OK
     */
    @GetMapping("/list/placement")
    public ResponseEntity<List<Placement>> findAllPlacement(){
        return new ResponseEntity<>(placementService.findAllPlacement(), HttpStatus.OK);
    }

    /**
     * Created by :ChungHV
     * Date create : 9/8/2022
     * Function : Post Advertisement
     * @param advertisement
     * @return : Http.BAD_REQUEST
     * @return : Http.OK
     */
    @PostMapping("/post")
    public ResponseEntity<Object> postAdvertisement(@RequestBody Advertisement advertisement){
        if(advertisement == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            advertisementService.saveAdvertisement(advertisement);
            return new ResponseEntity<>(advertisementService.findAllAdvertisement(), HttpStatus.OK);
        }
    }

    /**
     * Created by :ChungHV
     * Date create : 9/8/2022
     * Function : Update Advertisement
     * @param advertisement
     * @param id
     * @return : Http.NOT_FOUND
     * @return : Http.OK
     */
    @PutMapping("/edit/{id}")
    public ResponseEntity<Object> editAdvertisement(@PathVariable("id") Integer id ,@RequestBody Advertisement advertisement){
        Optional<Advertisement> advertisementUpdate = advertisementService.findById(id);
        if(!advertisementUpdate.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            advertisementService.updateAdvertisement(advertisement);
            return new ResponseEntity<>(advertisementUpdate, HttpStatus.OK);
        }
    }

    /**
     * Created by :ChungHV
     * Date create : 9/8/2022
     * Function : FindById Advertisement
     * @param id
     * @return : Http.BAD_REQUEST
     * @return : Http.OK
     */
    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id){
        Optional<Advertisement> advertisement = advertisementService.findById(id);
        if(!advertisement.isPresent()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(advertisement,HttpStatus.OK);
        }
    }
}
