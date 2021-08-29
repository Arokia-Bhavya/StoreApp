package com.store.inventory.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name="cart")
@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	@Column(name="sessionid")
	String sessionId;
	String token;
	Integer status;
	@CreationTimestamp
	@Column(name="createdat")
	Timestamp createdAt;
	@OneToMany(targetEntity = CartItem.class, cascade = CascadeType.ALL)	
	@JoinColumn(name = "cartid")	
	private List<CartItem> cartItems;
}
