package Six;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Maximum {
    @JsonProperty(value = "Value")
    private String value;
    @JsonProperty(value = "Unit")
    private String unit;
    @JsonProperty(value = "UnitType")
    private String unitType;

}
