package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopNavigationData {
    String topMenuItemName;
    String classifierItemName;
    String asideItemName;
    String dropDownItemName;
    String schemaHeaderText;
}
