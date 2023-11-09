package com.nimbasms.nimbasms.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GroupDto {
    @JsonProperty("groupe_id")
    private String groupeId;
    private String name;
    @JsonProperty("added_at")
    private String addedAt;
    @JsonProperty("total_contact")
    private Integer totalContact;
}
