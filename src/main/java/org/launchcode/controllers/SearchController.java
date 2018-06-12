package org.launchcode.controllers;

import org.launchcode.models.JobData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping("search")
public class SearchController {

    @RequestMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    // TODO #1 - Create handler to process search request and display results
    @RequestMapping(value = "results")
    public String search(Model model, @RequestParam String searchTerm, @RequestParam String searchType) {
        model.addAttribute("columns", ListController.columnChoices);
        if (searchType.equals("all")) {

            ArrayList<HashMap<String, String>> jobs = JobData.findByValue(searchTerm);
            model.addAttribute("title", "All Jobs");
            model.addAttribute("jobs", jobs);
            return "search";

        } else {
            ArrayList<HashMap<String, String>> jobs = JobData.findByColumnAndValue(searchTerm, searchType);
            model.addAttribute("jobs", jobs);
            return "search";

        }


            /*for (HashMap<String, String> row : allJobs) {

                for (String key : row.keySet()) {
                    String aValue = row.get(key);

                    if (aValue.toLowerCase().contains(searchTerm.toLowerCase())) {
                        allJobs.add(row);

                        // Finding one field in a job that matches is sufficient
                        break;
                    }*/


                }
            }