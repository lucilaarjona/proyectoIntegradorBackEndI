package com.dh.dentalClinic.service;

import com.dh.dentalClinic.persistence.entities.Appointment;
import com.dh.dentalClinic.persistence.entities.Dentist;
import com.dh.dentalClinic.persistence.repository.AppointmentsRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    private static final Logger logger = Logger.getLogger(AppointmentService.class);

    @Autowired
    AppointmentsRepository repository;

    public String save (Appointment a){
        if (repository.save(a)!=null){
            logger.info("Appointment was succesfully saved");
            return "Ok";
        }else{
            logger.error("There was something wrong...");
            return null;
        }
    }

    public List<Appointment> getAll(){
        logger.info("Searching all appointments...");
        return repository.findAll();
    }

    public Appointment getById(Long id){

        if(repository.existsById(id)){
            Appointment appointment = repository.findById(id).get();
            logger.info("Looking for appointments with id:" + id);
            return appointment;
        }
        logger.info("Appointment was not found");
        return null;
    }

    public String delete(Long id) {
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
            logger.info("Appointment was succesfully deleted");
            return "Appointment with id"+ id + " was deleted. ";
        }
        logger.error("Appointment was not found");
        return "Appointment with id "+ id + " was not found. ";
    }

    public String updateAppointment(Appointment a){
        Long appId = a.getId();

        if(repository.findById(appId).isPresent()) {
            Appointment modifiedAppointment = repository.getById(appId);

            modifiedAppointment.setPatient(a.getPatient());
            modifiedAppointment.setDentist(a.getDentist());
            modifiedAppointment.setDate(a.getDate());

            repository.save(modifiedAppointment);
            logger.info("Appointment " + appId +" was succesfully modified.");
            return "Appointment with Id: " + appId + " was modified.";

        } else {
            logger.error("Appointment doesn't exist");
            return "Appointment with Id " + appId + " does not exist.";
        }
    }
}
