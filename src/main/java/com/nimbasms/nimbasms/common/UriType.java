package com.nimbasms.nimbasms.common;

public enum UriType {
    ACCOUNTS("accounts"),
    CONTACTS("contacts"),
    GROUPS("groups"),
    SENDER_NAMES("sendernames"),
    MESSAGES("messages");

    private final String path;

    UriType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
