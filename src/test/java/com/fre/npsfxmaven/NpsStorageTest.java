package com.fre.npsfxmaven;

import com.fre.npsfxmaven.model.Nps;
import com.fre.npsfxmaven.model.NpsStorage;
import com.fre.npsfxmaven.model.Storable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NpsStorageTest {

    NpsStorage storage;

    @BeforeEach
    void initiateTest() {
        storage = new NpsStorage();
    }

    @Test
    @DisplayName("fails when no nps is added to the storage collection")
    void testAddNps() {
        Storable nps = new Nps("name", 1);
        storage.getNpsRecords().add(nps);
        assertEquals(1, storage.getNpsRecords().size());
    }

    @Test
    @DisplayName("fails when processingOrder of two nps doesn't switch")
    void testSwitchNps() {
        Storable nps = new Nps("name", 1);
        Storable nps2 = new Nps("name2", 2);
        storage.addNps(nps);
        storage.addNps(nps2);
        storage.switchNps(String.valueOf(nps.getProcessingOrder()), String.valueOf(nps2.getProcessingOrder()));
        assertEquals(2, nps.getProcessingOrder());
        assertEquals(1, nps2.getProcessingOrder());
    }
}