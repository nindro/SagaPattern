package saga;

import java.util.*;

public class SagaOrchestrator {
	private final List<SagaStep> steps;
	private final Deque<SagaStep> completedSteps = new ArrayDeque<>();
	
	public SagaOrchestrator(List<SagaStep> steps){
		this.steps = steps;
	}
	
	public void execute() {
		System.out.println("Starting Checkout Saga");
		try {
			for (SagaStep step : steps) {
				System.out.println("Executing: " + step.getName());
				step.process();
				completedSteps.push(step);
			}
			System.out.println("Checkout Successful!");
		} catch (Exception e) {
			System.err.println("Error detected: " + e.getMessage());
			rollback();
		}
	}
	private void rollback() {
        System.out.println("--- Starting Compensation (Rollback) ---");
        while (!completedSteps.isEmpty()) {
            SagaStep step = completedSteps.pop();
            step.compensate();
        }
        System.out.println("--- Rollback Complete. System is consistent. ---");
    }
}
