package com.nimbasms.nimbasms.accounts;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Link {
    private String desc;
    private String href;
    private String method;
}
