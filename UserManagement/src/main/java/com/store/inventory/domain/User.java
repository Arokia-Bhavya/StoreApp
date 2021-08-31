package com.store.inventory.domain;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	Long id;
	@Column(name="firstname")
	String firstName;
	@Column(name="middlename")
	String middleName;
	@Column(name="lastname")
	String lastName;
	@Column(name="email")
	String email;
	@Column(name="passwordhash")
	 String passwordHash;
	@Column(name="admin")
	 byte admin=0;
	@Column(name="vendor")
	 byte vendor=0;
	@CreationTimestamp	
	@Column(name="registeredat",updatable=false)
	LocalDateTime  registeredAt;
	@UpdateTimestamp	
	@Column(name="lastlogin")
	LocalDateTime  lastLogin;
	@Column(name="intro")
	 String intro;
	@Column(name="profile")
	 String profile;
	
	
	
}
