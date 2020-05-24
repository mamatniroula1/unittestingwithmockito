package com.sunil.unittesting.unittesting.business;

import java.util.Arrays;

public class BusinessImpl{
    private SomeDataService someDataService;

    public BusinessImpl(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public BusinessImpl() {
    }

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int[] data){
        return Arrays.stream(data).sum();
    }


    public int calculateSumUsingDataService() {
        int sum = 0;
        int[] data = someDataService.retrieveData();
        return Arrays.stream(data).sum();
    }
}
