package com.example.tracker_app.controllers;

import com.example.tracker_app.Services.DataService;
import com.example.tracker_app.models.LocationStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    DataService dataService;

    @GetMapping("/")
    public String home(Model model){
        List<LocationStats> allStats = dataService.getAllStats();
        int totalReportedCases  = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases ", totalReportedCases);
        return "home";

    }
}
