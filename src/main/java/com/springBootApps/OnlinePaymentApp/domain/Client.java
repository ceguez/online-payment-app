package com.springBootApps.OnlinePaymentApp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {
	
	private Integer id;
	private String email;
	private String name;
	private String stripeId;
	private Set<Project> projects = new HashSet<>();
	
	@Id @GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStripeId() {
		return stripeId;
	}
	public void setStripeId(String stripeId) {
		this.stripeId = stripeId;
	}
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "client", fetch = FetchType.LAZY) //using 'LAZY' cuts a lot of the excessive reading from DB therefore makes app more efficient
	//Use CascadeType.All carefully: cascades into all PJs that are tied to the Client, in this cases it makes sense to use it based on Client to many relationship but PJ relation toward CLient is unique
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", email=" + email + ", name=" + name + "]";
	}
	
}
