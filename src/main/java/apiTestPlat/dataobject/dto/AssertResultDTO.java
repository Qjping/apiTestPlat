package apiTestPlat.dataobject.dto;

import lombok.Data;

@Data
public class AssertResultDTO {
    public Boolean isPass;
    public String failCause;
}
