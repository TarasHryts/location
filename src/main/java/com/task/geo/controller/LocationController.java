package com.task.geo.controller;

import com.task.geo.converter.GeoIpConverterToLocation;
import com.task.geo.converter.IpConverter;
import com.task.geo.dto.Location;
import com.task.geo.entity.GeoIpDataBase;
import com.task.geo.services.GeoIpDataBaseServices;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
    private static final Logger logger = Logger.getLogger(LocationController.class);
    private final GeoIpDataBaseServices geoIpDataBaseServices;

    @Autowired
    public LocationController(GeoIpDataBaseServices geoIpDataBaseServices) {
        this.geoIpDataBaseServices = geoIpDataBaseServices;
    }

    @GetMapping("/geoip/{canonicalIPv4Representation}")
    public Location findLocation(@PathVariable(value = "canonicalIPv4Representation")
                                         String canonicalIPv4Representation) {
        long start = System.currentTimeMillis();
        GeoIpDataBase geoIpDataBase = geoIpDataBaseServices
                .findIp(IpConverter.stringToLong(canonicalIPv4Representation));
        Location location = GeoIpConverterToLocation
                .createGeoLocationFromDB(geoIpDataBase, canonicalIPv4Representation);
        long finish = System.currentTimeMillis();
        logger.info(String.format("Request completed in %d milliseconds", finish - start));
        return location;
    }
}
