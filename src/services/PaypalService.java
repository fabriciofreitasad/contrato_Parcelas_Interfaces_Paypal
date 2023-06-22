package services;

public class PaypalService implements OnlinePagamentoService {

	@Override
	public double taxPagamento(double quantia) {
		
		return quantia * 0.02;
	}

	@Override
	public double jurus(double quantia, int meses) {
		
		return quantia * 0.01 * meses;
	}

}
