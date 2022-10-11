package com.beonadiet.beonadiet.entity;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 4000)
    private String content;

    @Column(nullable = false)
    private Float score;

    private Long like;

    public void prePersist() {
        this.like = this.like == null ? 0 : this.like;
    }

    @ManyToOne(fetch = FetchType.EAGER)    
    @JoinColumn(name = "member_id")
    private Member member;
  
    @ManyToOne(fetch = FetchType.EAGER)    
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;
}
