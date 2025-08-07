package com.maxxenergy.edap.model;

public class SolarData {
    private String plantName;
    private double generation;
    private double revenue;

    public SolarData(String plantName, double generation, double revenue) {
        this.plantName = plantName;
        this.generation = generation;
        this.revenue = revenue;
    }


    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public double getGeneration() {
        return generation;
    }

    public void setGeneration(double generation) {
        this.generation = generation;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
}