package com.example.exception1.constenum;

public enum EmployerBulkUploadItemErrorStatusEnum {
	
	MISSING_MANDATORY(1,"Missing Mandatory Field"),
	FORMAT_ERROR(2,"Field Value Containing Wrong Format"),
	DUPLICATE(3,"Duplicate Number"),
	INVALID(4,"Invalid Content"),
	FIELD_LENGTH(5,"Field Length Not Applicable"),
	PERSON_NOT_EXIST(6, "Person is not Exist"),
	TEMPALTE_ERROR(7,"Wrong template Format"),
	MEMBERNO_NULL(8,"Member Number Null Record is Founded"),
	FAIL_TO_ACCESS(9,"Cannot access the document");
	
	private final int id;
	private final String label;
	

	private EmployerBulkUploadItemErrorStatusEnum(int id, String label) {
		this.id = id;
		this.label = label;

	}
	
	public int getId() {
		return this.id;
	}
	
	public String getLabel() {
		return label;
	}
	
	
	public static EmployerBulkUploadItemErrorStatusEnum getValueById(Integer id) {
		for(EmployerBulkUploadItemErrorStatusEnum value : EmployerBulkUploadItemErrorStatusEnum.values()) {
			if(value.id == id) {
				return value;
			}
		}
		return null;
	}

}

