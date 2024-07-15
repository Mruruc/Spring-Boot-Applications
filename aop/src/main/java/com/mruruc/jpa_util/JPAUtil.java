package com.mruruc.jpa_util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    private static EntityManagerFactory emf = null;

    private JPAUtil() {}

    public static EntityManagerFactory getEmf() {
        if (emf == null) {
            try {
                emf = Persistence.createEntityManagerFactory("persistence-unit");
            } catch (Exception exception) {
                exception.printStackTrace();
                throw exception;
            }
        }
        return emf;
    }

    public static void shutDown() {
        if (emf != null) {
            emf.close();
        }
    }
}
