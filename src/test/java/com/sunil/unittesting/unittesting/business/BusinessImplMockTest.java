package com.sunil.unittesting.unittesting.business;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class BusinessImplMockTest {

    @InjectMocks
    BusinessImpl business;

    @Mock
    SomeDataService someDataService;

    List<String> mock = mock(List.class);

    @Test
    void calculateSum() {
        BusinessImpl business = new BusinessImpl(someDataService);
        int actualResult = business.calculateSum(new  int[] {1,2,3});
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    //this is using mock
    @Test
    @Disabled
    void calculateSumUsingDataService() {
        when(someDataService.retrieveData()).thenReturn(new int[] {1,2,3});
        assertEquals(6, business.calculateSumUsingDataService());
    }


    @Test
    void argumentCapturing() {
        mock.add("someString");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock).add(captor.capture());
        assertEquals("someString", captor.getValue());

    }

    @Test
    void multipleArgumentCapturing() {
        mock.add("someString1");
        mock.add("someString2");
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(mock, times(2)).add(captor.capture());
        List<String> allValues = captor.getAllValues();
        assertEquals("someString1", allValues.get(0));
        assertEquals("someString2", allValues.get(1));

    }

    @Test
    void mocking() {
        ArrayList arrayListMock = mock(ArrayList.class);
        System.out.println(arrayListMock.get(0)); //returns null
        System.out.println(arrayListMock.size()); //returns 0
        arrayListMock.add("Test1");
        arrayListMock.add("Test2");
        System.out.println(arrayListMock.size());  //returns 0
        when(arrayListMock.size()).thenReturn(5);
        System.out.println(arrayListMock.size());  //returns 5
    }


    @Test
    void spying() {
        ArrayList arrayListSpy = spy(ArrayList.class);
        System.out.println(arrayListSpy.get(0));  //returns iob exception
        //this will throw index out of bounds exception as it will be like a real class behaviour
        System.out.println(arrayListSpy.size());  //returns 0
        arrayListSpy.add("Test1");
        arrayListSpy.add("Test2");
        System.out.println(arrayListSpy.size());  //returns 2
        when(arrayListSpy.size()).thenReturn(5);
        System.out.println(arrayListSpy.size());  //returns 5

        //mocking is a watching not a real world actions but spying is watching the real world actions
    }


























}