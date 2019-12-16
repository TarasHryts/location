package com.task.geo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private String canonicalIPv4Representation;
    private String cityName;
    private String countryCode;
    private String countryName;
    private Long ipv4;
    private Double latitude;
    private Double longitude;
    private String regionName;
}
