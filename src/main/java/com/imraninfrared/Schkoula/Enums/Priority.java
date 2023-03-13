package com.imraninfrared.Schkoula.Enums;

public enum Priority {
    VERY_LOW("VERY_LOW"),
    LOW("LOW"),
    MEDIUM("MEDIUM"),
    HIGH("HIGH"),
    URGENT("URGENT");

    private String priority;

    Priority(String priority) {
        this.priority = priority;
    }
}
