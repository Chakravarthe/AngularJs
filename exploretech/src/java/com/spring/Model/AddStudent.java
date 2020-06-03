package com.spring.Model;

import com.andromeda.commons.model.BaseModel;
import java.util.List;

	public class AddStudent extends BaseModel{
		private static final long serialVersionUID = 1L;
		public Integer intake;
		public String name;
		public String courseid;
		public String fname;
		public String hno;
		public String institutioncode;  
		public String village;
		public String mandal;                                                                   
		public Integer pincode;
		public String mobileno;
		public String applicationid;
		public String year;
		private String ipAddress;
		public int InstitutionCode;
		private String fileName;
		private String base64String;
		private List<FileModel> filePaths;
		private List<String> paths;
		private String filePath;
		private String fileExtension;
		private String fileFormat;
		private String role;
		
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		public Integer getIntake() {
			return intake;
		}

		public void setIntake(Integer intake) {
			this.intake = intake;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getFname() {
			return fname;
		}

		public void setFname(String fname) {
			this.fname = fname;
		}

		public String getHno() {
			return hno;
		}

		public void setHno(String hno) {
			this.hno = hno;
		}

		public String getVillage() {
			return village;
		}

		public void setVillage(String village) {
			this.village = village;
		}

		public String getMandal() {
			return mandal;
		}

		public void setMandal(String mandal) {
			this.mandal = mandal;
		}  

		public Integer getPincode() {
			return pincode;
		}

		public void setPincode(Integer pincode) {
			this.pincode = pincode;
		}

		public String getMobileno() {
			return mobileno;
		}

		public void setMobileno(String mobileno) {
			this.mobileno = mobileno;
		}

		public String getYear() {
			return year;
		}

		public void setYear(String year) {
			this.year = year;
		}

		public String getIpAddress() {
			return ipAddress;
		}

		public void setIpAddress(String ipAddress) {
			this.ipAddress = ipAddress;
		}

		public int getInstitutionCode() {
			return InstitutionCode;
		}

		public void setInstitutionCode(int institutionCode) {
			InstitutionCode = institutionCode;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public String getBase64String() {
			return base64String;
		}

		public void setBase64String(String base64String) {
			this.base64String = base64String;
		}

		public List<FileModel> getFilePaths() {
			return filePaths;
		}

		public void setFilePaths(List<FileModel> filePaths) {
			this.filePaths = filePaths;
		}

		public List<String> getPaths() {
			return paths;
		}

		public void setPaths(List<String> paths) {
			this.paths = paths;
		}

		public String getFilePath() {
			return filePath;
		}

		public void setFilePath(String filePath) {
			this.filePath = filePath;
		}

		public String getFileExtension() {
			return fileExtension;
		}

		public void setFileExtension(String fileExtension) {
			this.fileExtension = fileExtension;
		}

		public String getFileFormat() {
			return fileFormat;
		}

		public void setFileFormat(String fileFormat) {
			this.fileFormat = fileFormat;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public String getApplicationid() {
			return applicationid;
		}

		public void setApplicationid(String applicationid) {
			this.applicationid = applicationid;
		}

		public String getCourseid() {
			return courseid;
		}

		public void setCourseid(String courseid) {
			this.courseid = courseid;
		}

		public String getInstitutioncode() {
			return institutioncode;
		}

		public void setInstitutioncode(String institutioncode) {
			this.institutioncode = institutioncode;
		}

		
		
		
		
	}


