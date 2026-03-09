package saga.steps;

import saga.SagaStep;

public class InventoryStep implements SagaStep {
    @Override
    public String getName() { return "Inventory Service"; }

    @Override
    public void process() throws Exception {
        System.out.println("[Inventory] Reserving items in warehouse...");
    }

    @Override
    public void compensate() {
        System.out.println("[Inventory] Rollback: Restoring stock levels...");
    }
}