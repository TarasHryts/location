package com.task.geo.repository;

import com.task.geo.entity.GeoIpDataBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GeoIpDataBaseRepository
        extends JpaRepository<GeoIpDataBase, Long> {
    @Query(value = "SELECT g FROM GeoIpDataBase g  WHERE g.ipFrom<=?1 and g.ipTo>=?1")
    GeoIpDataBase findIp(Long ip);
}
