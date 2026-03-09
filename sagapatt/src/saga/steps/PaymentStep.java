package saga.steps;

import saga.SagaStep;
public class PaymentStep implements SagaStep {
	@Override
	public void process() throws Exception {
		System.out.println("[Payment] Charging credit card...");
	}
	
	public void compensate() {
		System.out.println("[Payment] Rollback: Refunding transaction...");
	}
	
	public String getName() {return "Payment Service"; }
}
