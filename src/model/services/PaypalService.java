package model.services;

public class PaypalService implements OnlinePaymentService {
  @Override
  public Double paymentFee(double amount) {
    return amount + (amount * 0.01) * 1;
  }

  @Override
  public Double interest(Double amount, Integer months) {
    return amount + amount * 0.02;
  }
}
