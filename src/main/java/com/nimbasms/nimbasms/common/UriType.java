package com.nimbasms.nimbasms.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UriType {
    ACCOUNTS("accounts"),
    CONTACTS("contacts"),
    GROUPS("groups"),
    SENDER_NAMES("sendernames"),
    MESSAGES("messages"),
    PURCHASES("purchases");

    private final String path;

}
