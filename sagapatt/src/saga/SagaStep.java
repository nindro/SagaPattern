package saga;

public interface SagaStep {
	void process() throws Exception;
	void compensate();
	String getName();
}
