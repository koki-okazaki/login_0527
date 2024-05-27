package com.example.teamA3_okazaki;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;
	private String role;
}
