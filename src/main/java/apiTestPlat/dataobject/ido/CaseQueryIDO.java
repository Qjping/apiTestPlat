package apiTestPlat.dataobject.ido;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CaseQueryIDO extends PageReceiveIDO {
    @JsonProperty("group_id")
    public String groupId;
    public String id;

}
