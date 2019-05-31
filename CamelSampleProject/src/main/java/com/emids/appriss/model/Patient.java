package com.emids.appriss.model;

public class Patient {

	private long patientId;
	private String patientName;
	private String patientCountry;

	public Patient(long patientId, String patientName, String patientCountry) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientCountry = patientCountry;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientCountry() {
		return patientCountry;
	}

	public void setPatientCountry(String patientCountry) {
		this.patientCountry = patientCountry;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", patientCountry=" + patientCountry
				+ "]";
	}

}
