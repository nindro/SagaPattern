package saga.steps;

import saga.SagaStep;

public class ShippingStep implements SagaStep {
    @Override
    public String getName() { return "Shipping Service"; }

    @Override
    public void process() throws Exception {
        System.out.println("[Shipping] Generating shipping label...");
        throw new Exception("Shipping address invalid!");
    }

    @Override
    public void compensate() {
        System.out.println("[Shipping] Rollback: Cancelling shipping label...");
    }
}