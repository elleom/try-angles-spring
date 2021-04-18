package com.martins.leonardo.triangles.controller;

import com.martins.leonardo.triangles.exception.DataTamperedException;
import com.martins.leonardo.triangles.models.Triangle;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;
import java.util.ArrayList;

/***
 * @author LM
 */
@Controller
public class MainController {

    //returns index page
    @RequestMapping({"/", "index", "index.html"})
    private String getIndex(){
        return "index";
    }


    //display template
    @GetMapping({"display", "display.html"})
    private String getResults(@RequestParam int x1,
                            @RequestParam int y1,
                            @RequestParam int x2,
                            @RequestParam int y2,
                            @RequestParam int x3,
                            @RequestParam int y3,
                            Model model) {
        ArrayList<Integer> coordinatesX = new ArrayList<>();
        ArrayList<Integer> coordinatesY = new ArrayList<>();
        coordinatesX.add(x1);
        coordinatesY.add(y1);
        coordinatesX.add(x2);
        coordinatesY.add(y2);
        coordinatesX.add(x3);
        coordinatesY.add(y3);

        try{

            /**
             * checks for data consistency
             */
            for (Integer value: coordinatesX) {
                if (!(value instanceof Integer)
                        || value < 0
                        || value > 950){
                    throw new DataTamperedException("Data corrupted!");
                }
            }
            for (Integer value: coordinatesY) {
                if (!(value instanceof Integer)
                        || value < 0
                        || value > 550){
                    throw new DataTamperedException("Data corrupted!");
                }
            }
            //creates x,y to construct the triangle
            Point pointA = new Point(x1,y1);
            Point pointB = new Point(x2,y2);
            Point pointC = new Point(x3,y3);

            Triangle triangle = new Triangle(pointA, pointB, pointC);
            //ArrayList deconstructed for readability
            ArrayList<Double> sideLengths = triangle.getSidesLength();

            Double sideBC = sideLengths.get(0);
            Double sideAC = sideLengths.get(1);
            Double sideAB = sideLengths.get(2);

            /**
             *  to set decimal precision point onto .00
             *  avoid extreme comparison
             *  eg. 40.60456 != 40.60457
             */
            sideBC = Math.floor (sideBC * 10) /10;
            sideAC = Math.floor (sideAC * 10) /10;
            sideAB = Math.floor (sideAB * 10) /10;


            //check type
            String triangleType = triangle.getTriangleType(sideAB, sideAC, sideBC); //x, y, z

            /**
             * loads data to thymeleaf template
             */
            model.addAttribute("x1", x1);
            model.addAttribute("y1", y1);
            model.addAttribute("x2", x2);
            model.addAttribute("y2", y2);
            model.addAttribute("x3", x3);
            model.addAttribute("y3", y3);
            model.addAttribute("sideBC", sideBC);
            model.addAttribute("sideAC", sideAC);
            model.addAttribute("sideAB", sideAB);
            model.addAttribute("type", triangleType);

        } catch (DataTamperedException e ){
            System.out.println(e.getMessage());
            return "error";
        }
        return "result";
    }

    @GetMapping({"lines", "lines.html"})
    private String getResultsWithLines(){
        return "lines";
    }

}
