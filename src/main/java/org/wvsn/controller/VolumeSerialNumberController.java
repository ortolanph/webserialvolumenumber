package org.wvsn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wvsn.beans.DateVSN;
import org.wvsn.service.VolumeSerialNumberService;

@RestController
@RequestMapping("/api/vsn")
public class VolumeSerialNumberController {


    @Autowired
    private VolumeSerialNumberService service;

    @GetMapping("/{date}")
    public DateVSN fromDate(@PathVariable("date") String date) {
        return service.fromDate(date);
    }

    @GetMapping("/random")
    public DateVSN randomg() {
        return service.randomDate();
    }

}
