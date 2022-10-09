package com.beonadiet.beonadiet.entity.product;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "myOwnLunchboxSnack")
@Getter
public class MyOwnLunchboxSnackImg {
    @Id
    private String uuid;
    private String imgName;
    private String path;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private MyOwnLunchboxSnack myOwnLunchboxSnack;
}