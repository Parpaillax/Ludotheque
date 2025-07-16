package fr.eni.demo.bo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class StockCount {
  private String name;
  private long count;
}
