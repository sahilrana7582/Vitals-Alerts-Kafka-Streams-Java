package com.logistic_management_system.model;


import java.time.Instant;
import java.util.Objects;

public class Vitals {

    private String patientId;
    private String hospitalId;
    private String tenantId;

    private double heartRate;       // bpm
    private double bloodPressureSystolic;   // mmHg
    private double bloodPressureDiastolic;  // mmHg
    private double oxygenSaturation;        // %
    private double bodyTemperature;         // °C


    // Constructor
    public Vitals() {
    }

    public Vitals(String patientId, String hospitalId, String tenantId,
                  double heartRate, double bloodPressureSystolic, double bloodPressureDiastolic,
                  double oxygenSaturation, double bodyTemperature) {
        this.patientId = patientId;
        this.hospitalId = hospitalId;
        this.tenantId = tenantId;
        this.heartRate = heartRate;
        this.bloodPressureSystolic = bloodPressureSystolic;
        this.bloodPressureDiastolic = bloodPressureDiastolic;
        this.oxygenSaturation = oxygenSaturation;
        this.bodyTemperature = bodyTemperature;
    }



    // Getters & Setters

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(double heartRate) {
        this.heartRate = heartRate;
    }

    public double getBloodPressureSystolic() {
        return bloodPressureSystolic;
    }

    public void setBloodPressureSystolic(double bloodPressureSystolic) {
        this.bloodPressureSystolic = bloodPressureSystolic;
    }

    public double getBloodPressureDiastolic() {
        return bloodPressureDiastolic;
    }

    public void setBloodPressureDiastolic(double bloodPressureDiastolic) {
        this.bloodPressureDiastolic = bloodPressureDiastolic;
    }

    public double getOxygenSaturation() {
        return oxygenSaturation;
    }

    public void setOxygenSaturation(double oxygenSaturation) {
        this.oxygenSaturation = oxygenSaturation;
    }

    public double getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(double bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }



    // equals & hashCode for deduplication/stream operations
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vitals)) return false;
        Vitals vitals = (Vitals) o;
        return Double.compare(vitals.heartRate, heartRate) == 0 &&
                Double.compare(vitals.bloodPressureSystolic, bloodPressureSystolic) == 0 &&
                Double.compare(vitals.bloodPressureDiastolic, bloodPressureDiastolic) == 0 &&
                Double.compare(vitals.oxygenSaturation, oxygenSaturation) == 0 &&
                Double.compare(vitals.bodyTemperature, bodyTemperature) == 0 &&
                Objects.equals(patientId, vitals.patientId) &&
                Objects.equals(hospitalId, vitals.hospitalId) &&
                Objects.equals(tenantId, vitals.tenantId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, hospitalId, tenantId, heartRate, bloodPressureSystolic,
                bloodPressureDiastolic, oxygenSaturation, bodyTemperature);
    }

    @Override
    public String toString() {
        return "Vitals{" +
                "patientId='" + patientId + '\'' +
                ", hospitalId='" + hospitalId + '\'' +
                ", tenantId='" + tenantId + '\'' +
                ", heartRate=" + heartRate +
                ", bloodPressureSystolic=" + bloodPressureSystolic +
                ", bloodPressureDiastolic=" + bloodPressureDiastolic +
                ", oxygenSaturation=" + oxygenSaturation +
                ", bodyTemperature=" + bodyTemperature +
                '}';
    }
}

