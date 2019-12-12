package com.task.geo.controller;

import com.task.geo.converter.GeoIpConverterToLocation;
import com.task.geo.converter.IpConverter;
import com.task.geo.entity.GeoIpDataBase;
import com.task.geo.entity.Location;
import com.task.geo.services.GeoIpDataBaseServices;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/geoip")
public class Controller {
    @Autowired
    private GeoIpDataBaseServices geoIpDataBaseServices;
    @GetMapping("/{canonicalIPv4Representation}")
    public Location findLocation(@PathVariable(value = "canonicalIPv4Representation")
                                                String canonicalIPv4Representation) {
        int start = LocalTime.now(ZoneOffset.UTC).get(ChronoField.MILLI_OF_DAY);
        GeoIpDataBase geoIpDataBase = geoIpDataBaseServices
                .findIp(IpConverter.stringToLong(canonicalIPv4Representation));
        Location location = GeoIpConverterToLocation
                .createGeoLocationFromDB(geoIpDataBase, canonicalIPv4Representation);
        int finish = LocalTime.now(ZoneOffset.UTC).get(ChronoField.MILLI_OF_DAY);
        System.out.println(start - finish);
        return location;

    }
}
