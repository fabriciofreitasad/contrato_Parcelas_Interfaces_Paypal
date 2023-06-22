package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

			//Contract - Contrato
public class Contrato {
	private Integer number;
	private LocalDate date;
	private Double valorTotal;
	// Um contratato pode ter varias prestacoes
	private List<Prestacao> prestacao = new ArrayList<>();

	public Contrato() {
	}

	public Contrato(Integer number, LocalDate date, Double valorTotal) {
		this.number = number;
		this.date = date;
		this.valorTotal = valorTotal;

	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<Prestacao> getPrestacao() {
		return prestacao;
	}

}
