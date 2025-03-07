package web.controller;

import web.models.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import java.util.List;
@Controller
public class CarController {
    private final CarService carService;
    public CarController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping(value = "/cars")
    public String showCars(@RequestParam(value = "count",defaultValue = "5")int count, Model model){
        List <Car> carsList = carService.carsList(count);
        model.addAttribute("cars",carsList);
        return "cars";
    }

}
