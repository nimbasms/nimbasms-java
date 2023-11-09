package com.nimbasms.nimbasms.contacts;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ContactDto {
    @JsonProperty("contact_id")
    private String contactId;
    private String name;
    private String numero;
    @JsonProperty("created_at")
    private Integer createdAt;
    private List<String> groups;
}
