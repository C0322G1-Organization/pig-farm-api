package vn.codegym.pig_farm.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.dto.FoodDto;
import vn.codegym.pig_farm.entity.Food;
import vn.codegym.pig_farm.entity.Storage;
import vn.codegym.pig_farm.service.IFoodService;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/food")
public class FoodRestController {
    @Autowired
    private IFoodService iFoodService;

    /**
     * Create by HoanTV
     * Date: 16:30 pm  08-9-2022
     * method show list and search and paging
     * HoanTV-list-food
     *
     * @param pageable
     * @param foodType
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<Page<Food>> getAllFood(@PageableDefault(3) Pageable pageable, Optional<String> foodType) {
        String searchKeyWork = foodType.orElse("");
        Page<Food> iFoodPage = this.iFoodService.getAllFood(pageable, searchKeyWork);
        if (iFoodPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iFoodPage, HttpStatus.OK);
    }

    /**
     * Create by: HungNV
     * Date created: 08/09/2022
     * function: create a food
     *
     * @param foodDto
     * @return if created food return HttpStatus.CREATED(201)
     */
    @PostMapping("/create")
    public ResponseEntity<Object> add(@Validated @RequestBody FoodDto foodDto, BindingResult bindingResult) {
        if (foodDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_FOUND);
        }
        Food food = new Food();

        BeanUtils.copyProperties(foodDto, food);
        food.setAmount(foodDto.getAmount());
        food.setUnit(foodDto.getUnit());
        food.setStorage(foodDto.getStorage());
        food.setPigsty(foodDto.getPigsty());

        iFoodService.create(food);
        Storage storage = iFoodService.findByIdStorage(foodDto.getStorage().getId());
        int amountSet = storage.getAmount() - foodDto.getAmount();
        if (amountSet < 0) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_FOUND);
        }
        iFoodService.updateStorage(amountSet, storage.getId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Create by: HungNV
     * Date created: 08/09/2022
     * function: edit a food
     *
     * @param foodDto
     * @return if created food return HttpStatus.CREATED(201)
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Integer id, @Validated @RequestBody FoodDto foodDto, BindingResult bindingResult) {
        Food foods = iFoodService.findById(id);
        if (foods == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        foods.setAmount(foodDto.getAmount());
        foods.setUnit(foodDto.getUnit());
        foods.setPigsty(foodDto.getPigsty());
        foods.setStorage(foodDto.getStorage());
        iFoodService.update(foods);
        return new ResponseEntity<>(foods, HttpStatus.CREATED);
    }

}