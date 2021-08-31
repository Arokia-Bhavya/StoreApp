package com.store.inventory.domain;

import java.sql.Timestamp;

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
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	Long id;
	@Column(name="userid")
	Long userId;	
	String title;
	String slug;
	Integer type;
	String sku;
	Float price;
	Float discount;
	Integer quantity;
	Integer shop;
	@CreationTimestamp
	@Column(name="createdat",updatable=false)
	Timestamp createdAt;
	@UpdateTimestamp
	@Column(name="updatedat")
	Timestamp updatedAt;
	@CreationTimestamp
	@Column(name="publishedat")
	Timestamp publishedAt;
	@Column(name="startsat")
	Timestamp startsAt;
	@Column(name="endsat")
	Timestamp endsAt;
	@Column(name="content")
	String content;
}
