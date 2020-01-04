package com.fourman.anamdobby.dto;

public class DobbyResponseDto {
    private long id;
    private String name;
    private String profileFileName;
    private double averageRate;

    public DobbyResponseDto(long id, String name, String profileFileName) {
        this.id = id;
        this.name = name;
        this.profileFileName = profileFileName;
    }

    public DobbyResponseDto(long id, String name, String profileFileName, double averageRate) {
        this.id = id;
        this.name = name;
        this.profileFileName = profileFileName;
        this.averageRate = averageRate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfileFileName() {
        return profileFileName;
    }

    public void setProfileFileName(String profileFileName) {
        this.profileFileName = profileFileName;
    }

    public double getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(double averageRate) {
        this.averageRate = averageRate;
    }
}
