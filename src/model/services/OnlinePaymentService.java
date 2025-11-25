package model.services;

public interface OnlinePaymentService {
  Double paymentFee(double amount);
  Double interest(Double amount, Integer months);
}
