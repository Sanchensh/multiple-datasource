package com.mrxu.config;

public enum DatabaseType {
    dev("dev", "1"),
    fat("fat", "2"),
    pro("pro", "3");

    DatabaseType(String name, String value) {
        this.name = name;
        this.value = value;
    }

    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}