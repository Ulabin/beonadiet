package com.beonadiet.beonadiet.entity.my_own_series;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@ToString(exclude = "myOwnLunchboxSidedish")
@Getter
public class MyOwnLunchboxSidedishImage {
    @Id
    private String uuid;
    private String imgName;
    private String path;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private MyOwnLunchboxSidedish myOwnLunchboxSidedish;
}