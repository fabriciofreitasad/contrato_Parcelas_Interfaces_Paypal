package services;

import java.time.LocalDate;

import entities.Contrato;
import entities.Prestacao;

public class ContratoService {

	private OnlinePagamentoService onlinePagamentoService;

	public ContratoService(OnlinePagamentoService onlinePagamentoService) {
		this.onlinePagamentoService = onlinePagamentoService;
	}

	public void processContrato(Contrato contrato, int meses) {

		double parcelasBasica = contrato.getValorTotal() / meses;
		
		for (int i = 1; i <= meses; i++) {
			LocalDate dataVencimento = contrato.getDate().plusMonths(i);
			
			double juros = onlinePagamentoService.jurus(parcelasBasica, i);
			double tax = onlinePagamentoService.taxPagamento(parcelasBasica + juros);
			double quota = parcelasBasica + juros + tax;
			
			contrato.getPrestacao().add(new Prestacao(dataVencimento, quota));
			
		}
	}

}
