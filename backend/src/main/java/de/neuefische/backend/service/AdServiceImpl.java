package de.neuefische.backend.service;

import de.neuefische.backend.repository.AdRepository;
import de.neuefische.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdServiceImpl implements AdService{

    @Autowired
    private AdRepository adRepository;
    @Autowired
    private GenerateUUID uuid;

}
