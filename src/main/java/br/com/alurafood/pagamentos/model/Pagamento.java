package br.com.alurafood.pagamentos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name="pagamentos")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Positive
	private BigDecimal valor;
	
	@NotBlank
	@Size(max=100)
	private String nome;
	
	@NotBlank
	@Size(min=19, max=19)
	private String numeroCartao;
	
	@NotBlank
	@Size(max=7)
	private String expiracaoCartao;
	
	@NotBlank
	@Size(min=3, max=3)
	private String cvvCartao;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private StatusPagamento status;
	
	@NotNull
	private long pedidoId;
	
	@NotNull
	private long formaDePagamentoId;
}
