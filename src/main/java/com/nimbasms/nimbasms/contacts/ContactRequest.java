package com.nimbasms.nimbasms.contacts;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactRequest {

    private String name;
    @NonNull
    private String numero;
    private List<String> groups;
}
