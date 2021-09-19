package com.honsoft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "languages")
public class LanguageEntity {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column
    private Integer id;

    @Column
    private String locale;

    @Column(name = "messagekey")
    private String key;

    @Column(name = "messagecontent")
    private String content;
  
  //Getter & Setter
  
}