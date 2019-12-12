package com.task.geo.services;

import com.task.geo.entity.GeoIpDataBase;

public interface GeoIpDataBaseServices {
    GeoIpDataBase findIp(Long ip);
}
