package com.beonadiet.beonadiet.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = {"member","purchase"})
public class Review extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, length = 4000)
    private String content;

    @Column(nullable = false)
    private Float score;

    private Long likecount;

    @PrePersist
    public void prePersist() {
        this.likecount = this.likecount == null ? 0 : this.likecount;
    }

    @ManyToOne(fetch = FetchType.EAGER)    
    @JoinColumn(name = "member_id")
    private Member member;
  
    @ManyToOne(fetch = FetchType.EAGER)    
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;
}
