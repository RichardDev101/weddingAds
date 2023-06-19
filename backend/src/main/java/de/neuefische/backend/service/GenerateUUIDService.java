package de.neuefische.backend.service;

import org.springframework.stereotype.Service;
import java.util.UUID;
@Service
public class GenerateUUIDService {

    public String getUUID(){
        return UUID.randomUUID().toString();
    }
}
