package com.example.auditing.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class PostEntity {

    @Id
    Long id;
}
