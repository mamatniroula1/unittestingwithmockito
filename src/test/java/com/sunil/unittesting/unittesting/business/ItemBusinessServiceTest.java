package com.sunil.unittesting.unittesting.business;

import com.sunil.unittesting.unittesting.data.ItemRepository;
import com.sunil.unittesting.unittesting.model.Item;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class ItemBusinessServiceTest {



    @InjectMocks
    private ItemBusinessService businessService;

    @Mock
    private ItemRepository itemRepository;

    @Test
    void retrieveAllItems() {
        Mockito.when(itemRepository.findAll()).
                thenReturn(Arrays.asList(new Item(2,"Item2", 10,10)));
        List<Item> items = businessService.retrieveAllItems();
        assertEquals(100, items.get(0).getValue());

    }
}