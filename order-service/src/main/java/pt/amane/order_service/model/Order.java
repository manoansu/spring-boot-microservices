package pt.amane.order_service.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_order")
@Entity
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String orderNumber;
  @OneToMany(cascade = CascadeType.ALL)
  List<OrderLineItems> orderLineItems;

}
