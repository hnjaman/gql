package com.demo.grql.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Data
@Entity
@Table(name= "user")
@Builder
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@NotNull
	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "user_name")
	private String userName;

	@NotNull
	@Column(name = "email")
	private String email;

	@NotNull
	@Column(name = "password")
	private String password;
}
