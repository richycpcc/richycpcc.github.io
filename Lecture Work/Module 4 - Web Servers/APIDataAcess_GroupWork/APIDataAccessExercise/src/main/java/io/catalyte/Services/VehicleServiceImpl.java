package io.catalyte.Services;

import io.catalyte.repositories.VehicleRepository;
import io.catalyte.entities.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import javax.naming.ServiceUnavailableException;
import java.util.ArrayList;
import java.util.List;

@Service
public  class VehicleServiceImpl implements VehicleService
{
    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> GetVehicles()
    {
        List<Vehicle> retVehicle = new ArrayList<>();
        try{
            retVehicle = vehicleRepository.findAll();
            return retVehicle;
        }
        catch (DataAccessException dae)
        {
            throw new IllegalArgumentException();//need to update later **throw new ServiceUnavailable(dae.getMessage());
        }
    }



}
