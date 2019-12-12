package com.task.geo.controller;

import com.task.geo.converter.GeoIpConverterToLocation;
import com.task.geo.converter.IpConverter;
import com.task.geo.entity.GeoIpDataBase;
import com.task.geo.entity.Location;
import com.task.geo.services.GeoIpDataBaseServices;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {
    private static final Logger logger = Logger.getLogger(Controller.class);
    @Autowired
    private GeoIpDataBaseServices geoIpDataBaseServices;
    @GetMapping("/geoip/{canonicalIPv4Representation}")
    public Location findLocation(@PathVariable(value = "canonicalIPv4Representation")
                                                String canonicalIPv4Representation) {
        int start = LocalTime.now(ZoneOffset.UTC).get(ChronoField.MILLI_OF_DAY);
        GeoIpDataBase geoIpDataBase = geoIpDataBaseServices
                .findIp(IpConverter.stringToLong(canonicalIPv4Representation));
        Location location = GeoIpConverterToLocation
                .createGeoLocationFromDB(geoIpDataBase, canonicalIPv4Representation);
        int finish = LocalTime.now(ZoneOffset.UTC).get(ChronoField.MILLI_OF_DAY);
        logger.info(String.format("Request completed in %d milliseconds", finish-start));
        return location;
    }
}
