package org.example.model;

import javax.persistence.*;

@Entity
@Table(name = "user_info", schema = "public")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
