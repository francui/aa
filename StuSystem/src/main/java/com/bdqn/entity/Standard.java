package com.bdqn.entity;

import java.util.Date;

public class Standard {
	private int id;
	private String std_um;
	private String zhname;
	private String version;
	private String keys;
	private Date release_date;
	private Date impl_date;
	private String package_path;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStd_um() {
		return std_um;
	}

	public void setStd_um(String std_um) {
		this.std_um = std_um;
	}

	public String getZhname() {
		return zhname;
	}

	public void setZhname(String zhname) {
		this.zhname = zhname;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getKeys() {
		return keys;
	}

	public void setKeys(String keys) {
		this.keys = keys;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public Date getImpl_date() {
		return impl_date;
	}

	public void setImpl_date(Date impl_date) {
		this.impl_date = impl_date;
	}

	public String getPackage_path() {
		return package_path;
	}

	public void setPackage_path(String package_path) {
		this.package_path = package_path;
	}

}
