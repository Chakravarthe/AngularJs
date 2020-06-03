package com.spring.Model;

import com.andromeda.commons.model.BaseModel;

public class FileModel extends BaseModel
{
	private String fileName;
	private String base64String;
	private String name;
	private String folderName;
	public String institutioncode;
	
	

	public String getInstitutioncode() {
		return institutioncode;
	}

	public void setInstitutioncode(String institutioncode) {
		this.institutioncode = institutioncode;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public String getBase64String()
	{
		return base64String;
	}

	public void setBase64String(String base64String)
	{
		this.base64String = base64String;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getFolderName()
	{
		return folderName;
	}

	public void setFolderName(String folderName)
	{
		this.folderName = folderName;
	}

}
