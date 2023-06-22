package services;

public interface OnlinePagamentoService {
											//paymentFee - taxPagamento
	double taxPagamento(double quantia);
											//interest - jurus / months - meses
	double jurus(double quantia, int meses);
	

}
