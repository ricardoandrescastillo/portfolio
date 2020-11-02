package com.zemoga.portfolio.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "portfolio", schema = "zemoga_test_db")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial", name = "idportfolio")
    private Long idPortfolio;

    @Column( name = "description")
    private String description;

    @Column( name = "image_url")
    private String imageUrl;

    @Column( name = "twitter_user_name")
    private String twitterUserName;

    @Column( name = "title")
    private String title;
}
