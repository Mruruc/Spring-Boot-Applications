package com.mruruc.Exercise;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier(value = "mongodb")
public class MongoDbDataService implements DataService{
    @Override
    public int[] retrieveData() {
        return new int[]{5,6,8,4};
    }
}
