package com.beonadiet.beonadiet.entity.recipe;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "morPost")
@Data
public class MorImage {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long inum;

  private String uuid;
  private String imgName;
  private String path;
  
  @ManyToOne(fetch = FetchType.LAZY)
  private MyOwnRecipePost morPost;
}
