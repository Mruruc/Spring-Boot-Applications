package com.mruruc.exercise;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PostgreSqlDataService implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[]{69,6,-7,6};
    }
}
