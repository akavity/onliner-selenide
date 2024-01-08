package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccomData {
    String topMenuItemName;
    String titlePrice;
    String minPrice;
    String maxPrice;
    int numberRooms;
    String titleArea;
    String minArea;
    String maxArea;
    String material;
    String typeHome;
    String address;
}
