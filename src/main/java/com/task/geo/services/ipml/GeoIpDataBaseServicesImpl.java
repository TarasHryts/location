package com.task.geo.services.ipml;

import com.task.geo.entity.GeoIpDataBase;
import com.task.geo.repository.GeoIpDataBaseRepository;
import com.task.geo.services.GeoIpDataBaseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GeoIpDataBaseServicesImpl implements GeoIpDataBaseServices {
    private GeoIpDataBaseRepository geoIpDataBaseRepository;

    @Autowired
    public GeoIpDataBaseServicesImpl(GeoIpDataBaseRepository geoIpDataBaseRepository) {
        this.geoIpDataBaseRepository = geoIpDataBaseRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public GeoIpDataBase findIp(Long ip) {
        return geoIpDataBaseRepository.findIp(ip);
    }
}
