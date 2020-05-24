package com.sunil.unittesting.unittesting.business;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SomeDataServiceStub implements SomeDataService{

    @Override
    public int[] retrieveData() {
        return new int[]{1,2,3};
    }
}

class BusinessImplTest {

    @Test
    void calculateSum() {
        BusinessImpl business = new BusinessImpl();
        int actualResult = business.calculateSum(new  int[] {1,2,3});
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSumUsingDataService() {
        BusinessImpl business = new BusinessImpl();
        business.setSomeDataService(new SomeDataServiceStub());
        int actualResult = business.calculateSumUsingDataService();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

}