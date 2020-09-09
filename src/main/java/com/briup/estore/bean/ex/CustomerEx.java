package com.briup.estore.bean.ex;

import java.util.List;

import com.briup.estore.bean.ShopAddress;

public class CustomerEx {
	private Integer id;

    private String name;

    private String password;

    private String zipcode;

    private String telephone;

    private String email;

    private List<ShopAddress> address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<ShopAddress> getAddress() {
		return address;
	}

	public void setAddress(List<ShopAddress> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "CustomerEx [id=" + id + ", name=" + name + ", password=" + password + ", zipcode=" + zipcode
				+ ", telephone=" + telephone + ", email=" + email + ", address=" + address + "]";
	}
    
    
}
