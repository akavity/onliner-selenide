package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobileData {
    String topMenuItemName;
    String classifierItemName;
    String asideItemName;
    String dropDownItemName;
    String labelPrice;
    String minPrice;
    String maxPrice;
    String labelManufacturer;
    String manufacturerName;
    String labelShop;
    String shopName;
    String filter;
    String pieceOfName;
}
