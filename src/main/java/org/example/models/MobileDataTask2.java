package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobileDataTask2 {
    String topMenuItemName;
    String classifierItemName;
    String asideItemName;
    String dropDownItemName;
    String labelPrice;
    String minPrice;
    String maxPrice;
    String labelManufacturer;
    String manufacturerName;
    String labelRAM;
    String minRAM;
    String maxRAM;
    String labelInternalMemory;
    String minInternalMemory;
    String maxInternalMemory;
    String labelMemoryCardSupport;
    String supportMemoryCard;
    int numberOfPhones;
}
