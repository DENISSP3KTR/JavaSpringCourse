package ru.osipov.orm02;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * The type Phone controller.
 *
 * @author Robley Gori - ro6ley.github.io
 */
@RestController
@RequestMapping("/api/v1")
public class PhoneController {

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private PhoneMakerRepository phoneMakerRepository;
    /**
     * Get all phones list.
     *
     * @return the list
     */
    @GetMapping("/phones")   // GET Method for reading operation
    public List<Phone> getAllPhones() {
        return phoneRepository.findAll();
    }

    /**
     * Gets phones by id.
     *
     * @param phoneId the phone id
     * @return the phones by id
     * @throws Exception
     */
    @GetMapping("/phones/{id}")    // GET Method for Read operation
    public ResponseEntity<Phone> getPhoneById(@PathVariable(value = "id") Long phoneId)
            throws Exception {

        Phone phone = phoneRepository.findById(phoneId)
                .orElseThrow(() -> new Exception("Phone " + phoneId + " not found"));
        return ResponseEntity.ok().body(phone);
    }

    /**
     * Create phone.
     *
     * @param phone the phone
     * @return the phone
     */
    @PostMapping("/phones")     // POST Method for Create operation
    public Phone createPhone(@Valid @RequestBody Phone phone) {
        return phoneRepository.save(phone);
    }

    /**
     * Update phone response entity.
     *
     * @param phoneId the phone id
     * @param phoneDetails the phone details
     * @return the response entity
     * @throws Exception
     */
    @PutMapping("/phones/{id}")    // PUT Method for Update operation
    public ResponseEntity<Phone> updatePhone(
            @PathVariable(value = "id") Long phoneId, @Valid @RequestBody Phone phoneDetails)
            throws Exception {

        Phone phone = phoneRepository.findById(phoneId)
                .orElseThrow(() -> new Exception("Phone " + phoneId + " not found"));

        phone.setPhoneName(phoneDetails.getPhoneName());
        phone.setOs(phoneDetails.getOs());

        final Phone updatedPhone = phoneRepository.save(phone);
        return ResponseEntity.ok(updatedPhone);
    }

    /**
     * Delete phone map.
     *
     * @param phoneId the phone id
     * @return the map of the deleted phone
     * @throws Exception the exception
     */
    @DeleteMapping("/phone/{id}")    // DELETE Method for Delete operation
    public Map<String, Boolean> deletePhone(@PathVariable(value = "id") Long phoneId) throws Exception {
        Phone phone = phoneRepository.findById(phoneId)
                .orElseThrow(() -> new Exception("Phone " + phoneId + " not found"));

        phoneRepository.delete(phone);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


    @GetMapping("/phones-maker")   // GET Method for reading operation
    public List<PhoneMaker> getAllPhonesMaker() {
        return phoneMakerRepository.findAll();
    }

    @GetMapping("/phones-maker/{id}")    // GET Method for Read operation
    public ResponseEntity<PhoneMaker> getPhoneMakerById(@PathVariable(value = "id") Long phoneMakerId)
            throws Exception {

        PhoneMaker phoneMaker = phoneMakerRepository.findById(phoneMakerId)
                .orElseThrow(() -> new Exception("PhoneMaker " + phoneMakerId + " not found"));
        return ResponseEntity.ok().body(phoneMaker);
    }

    @PostMapping("/phones-maker")     // POST Method for Create operation
    public PhoneMaker createPhoneMaker(@Valid @RequestBody PhoneMaker phoneMaker) {
        return phoneMakerRepository.save(phoneMaker);
    }

    @PutMapping("/phones-maker/{id}")    // PUT Method for Update operation
    public ResponseEntity<PhoneMaker> updatePhoneMaker(
            @PathVariable(value = "id") Long phoneMakerId, @Valid @RequestBody PhoneMaker phoneMakerDetails)
            throws Exception {

        PhoneMaker phoneMaker = phoneMakerRepository.findById(phoneMakerId)
                .orElseThrow(() -> new Exception("PhoneMaker " + phoneMakerId + " not found"));

        phoneMaker.setName(phoneMakerDetails.getName());

        final PhoneMaker updatedPhone = phoneMakerRepository.save(phoneMaker);
        return ResponseEntity.ok(updatedPhone);
    }

    @DeleteMapping("/phone-maker/{id}")    // DELETE Method for Delete operation
    public Map<String, Boolean> deletePhoneMaker(@PathVariable(value = "id") Long phoneMakerId) throws Exception {
        PhoneMaker phoneMaker = phoneMakerRepository.findById(phoneMakerId)
                .orElseThrow(() -> new Exception("PhoneMaker " + phoneMakerId + " not found"));

        phoneMakerRepository.delete(phoneMaker);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}