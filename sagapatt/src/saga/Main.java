package saga;

import saga.steps.*;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<SagaStep> workflow = Arrays.asList(
			new PaymentStep(),
			new InventoryStep(),
			new ShippingStep()
		);
		
		SagaOrchestrator saga = new SagaOrchestrator(workflow);
		saga.execute();
	}
}
