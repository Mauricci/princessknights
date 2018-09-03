package Characters.Data;

public class Abilities {
    protected String abilityName;
    protected AttributeEnum attributeEnum;
    protected int value;

    public Abilities(String abilityName, AttributeEnum attributeEnum, int value) {
        this.abilityName = abilityName;
        this.attributeEnum = attributeEnum;
        this.value = value;
    }

    public String getAbilityName() {
        return abilityName;
    }

    public AttributeEnum getAttributeEnum() {
        return attributeEnum;
    }

    public int getValue() {
        return value;
    }
}
