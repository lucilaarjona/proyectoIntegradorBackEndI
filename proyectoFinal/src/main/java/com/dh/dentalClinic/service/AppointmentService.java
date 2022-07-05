package com.dh.dentalClinic.service;
import com.dh.dentalClinic.exceptions.BadRequestException;
import com.dh.dentalClinic.persistence.entities.Appointment;
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

    public Appointment save (Appointment a) throws BadRequestException {
        logger.info("Appointment was succesfully saved");
        return repository.save(a);
    }

    public List<Appointment> getAll() throws BadRequestException{
        logger.info("Searching all appointments...");
        if (repository.findAll().size() == 0) {
            throw new BadRequestException("There aren't any appointments created yet.");
        }
        return repository.findAll();
    }

    public Appointment getById(Long id) throws BadRequestException{

        if(repository.existsById(id)){
            Appointment appointment = repository.findById(id).get();
            logger.info("Looking for appointments with id:" + id);
            return appointment;
        }
        logger.info("Appointment with id " + id + " was not found.");
        throw new BadRequestException("Appointment with id " + id + " was not found.");
    }

    public String delete(Long id) throws BadRequestException{
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
            logger.info("Appointment was succesfully deleted");
            return "Appointment with id "+ id + " was deleted. ";
        }
        logger.error("Appointment with id " + id + " was not found.");
        throw new BadRequestException("Appointment with id " + id + " was not found.");
    }

    public String updateAppointment(Appointment a) throws BadRequestException{
        Long id = a.getId();

        if(repository.findById(id).isPresent()) {
            Appointment modifiedA = repository.findById(id).get();

            modifiedA.setPatient(a.getPatient());
            modifiedA.setDentist(a.getDentist());
            modifiedA.setDate(a.getDate());

            repository.save(modifiedA);
            logger.info("Appointment " + id +" was succesfully modified.");
            return "Appointment with Id: " + id + " was modified.";

        } else {
            logger.error("Appointment with id " + id + " doesn't exist");
            throw new BadRequestException("Appointment with id " + id + " doesn't exist");
        }
    }
}
