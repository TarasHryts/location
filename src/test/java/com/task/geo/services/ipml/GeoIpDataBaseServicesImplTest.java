package com.task.geo.services.ipml;

import static org.mockito.Mockito.when;

import com.task.geo.entity.GeoIpDataBase;
import com.task.geo.repository.GeoIpDataBaseRepository;
import com.task.geo.services.GeoIpDataBaseServices;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class GeoIpDataBaseServicesImplTest {
    private GeoIpDataBaseRepository geoIpDataBaseRepository;
    private GeoIpDataBaseServices geoIpDataBaseServices;
    private GeoIpDataBase geoIpDataBase;

    @Before
    public void setUp() throws Exception {
        geoIpDataBaseRepository = Mockito.mock(GeoIpDataBaseRepository.class);
        geoIpDataBaseServices = new GeoIpDataBaseServicesImpl(geoIpDataBaseRepository);
        geoIpDataBase = new GeoIpDataBase(16777216L, 16777471L, "US", "United States",
                "California", "Los Angeles", 32.05223D, -118.24368D);
    }

    @Test
    public void findIpOk() {
        when(geoIpDataBaseRepository.findIp(16777217L)).thenReturn(geoIpDataBase);
        Assert.assertEquals(geoIpDataBase, geoIpDataBaseServices.findIp(16777217L));
    }
}