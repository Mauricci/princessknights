package Characters.Items;

import Characters.Attributes.AttributeEnum;

public class Item {
    private String itemName;
    private String itemDescription;
    private AttributeEnum attributeEnum;
    private int attributeValue;

    public Item(String itemName, String itemDescription, AttributeEnum attributeEnum, int attributeValue) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.attributeEnum = attributeEnum;
        this.attributeValue = attributeValue;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public AttributeEnum getAttributeEnum() {
        return attributeEnum;
    }

    public int getAttributeValue() {
        return attributeValue;
    }
}
