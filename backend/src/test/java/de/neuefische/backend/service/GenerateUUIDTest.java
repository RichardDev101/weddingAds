package de.neuefische.backend.service;

import org.junit.jupiter.api.Test;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;

class GenerateUUIDTest {

    @Test
    void getUUIDServiceTest() {
        // given
        GenerateUUID generateUUID = new GenerateUUID();

        // when
        String newUUID = generateUUID.getUUID();

        // then
        assertNotNull(newUUID);
        assertTrue(isValidUUID(newUUID));
    }

    private boolean isValidUUID(String uuid) {
        try {
            UUID.fromString(uuid);
            return true;
        } catch (IllegalArgumentException exception) {
            return false;
        }
    }

}