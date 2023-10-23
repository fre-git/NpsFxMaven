package com.fre.npsfxmaven.model;

import com.fre.npsfxmaven.model.Nps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NpsTest {
    Nps nps;

    @BeforeEach
    void initiateTest() {
        nps = new Nps("name", 1, "state", 0, "condId",
                "condData", "12", "data");
    }

    @Test
    @DisplayName("Fails if processingOrder doesn't increase by one")
    void testBumpProcessingOrder() {
        nps.bumpProcessingOrder();
        assertEquals(2, nps.getProcessingOrder());
    }


    @Test
    @DisplayName("Fails if getName() doesn't return correct name")
    void testGetName() {
        assertEquals("name", nps.getName());
    }

    @Test
    @DisplayName("Fails if getProcessingOrder() doesn't return correct processingOrder")
    void testGetProcessingOrder() {
        assertEquals(1, nps.getProcessingOrder());
    }

    @Test
    @DisplayName("Fails if getState() doesn't return correct state")
    void testGetState() {
        assertEquals("state", nps.getState());
    }

    @Test
    @DisplayName("Fails if getPolicySource() doesn't return correct policy")
    void testGetPolicySource() {
        assertEquals(0, nps.getPolicySource());
    }

    @Test
    @DisplayName("Fails if getConditionId() doesn't return correct condition Id")
    void testGetConditionId() {
        assertEquals("condId", nps.getConditionId());
    }

    @Test
    @DisplayName("Fails if getConditionData() doesn't return correct condition data")
    void testGetConditionData() {
        assertEquals("condData", nps.getConditionData());
    }

    @Test
    @DisplayName("Fails if getProfileId() doesn't return correct profile id")
    void testGetProfileId() {
        assertEquals("12", nps.getProfileId());
    }

    @Test
    @DisplayName("Fails if getProfileData() doesn't return correct profile data")
    void testGetProfileData() {
        assertEquals("data", nps.getProfileData());
    }

    @Test
    @DisplayName("Fails if setProcessingOrder() doesn't set the processingOrder")
    void testSetProcessingOrder() {
        nps.setProcessingOrder(10);
        assertEquals(10, nps.getProcessingOrder());
    }

    @Test
    @DisplayName("should throw RuntimeException when processingOrder is negative")
    void testValidateProcessingOrder() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            nps.setProcessingOrder(-5);
            nps.validateProcessingOrder();
        });
    }

    @Test
    @DisplayName("should throw RuntimeException when name is Empty")
    void testValidateNpsName() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            Nps nps1 = new Nps("", 1, "state", 0, "condId",
                    "condData", "12", "data");
            nps1.validateNpsName();
        });
    }
}