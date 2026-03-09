# E-Commerce Checkout: Saga Pattern Implementation

This project demonstrates the **Saga Design Pattern (Orchestration-based)** to manage distributed transactions within a microservices architecture.

## Overview
In a distributed system, traditional ACID transactions across multiple services are not possible. The Saga pattern solves this by breaking a large transaction into smaller, atomic **local transactions**. If any step fails, the Saga executes **compensating transactions** to roll back previous changes and maintain data consistency.

## Design
- **Pattern:** Orchestration (Centralized control).
- **Core Components:**
  - `SagaOrchestrator`: The "Brain" that manages the sequence and tracks successful steps for potential rollback.
  - `SagaStep`: An interface defining `process()` (Do) and `compensate()` (Undo) actions.
  - **Services:** Payment, Inventory, and Shipping.

## Workflow Logic
1. **Payment:** Charges the customer.
2. **Inventory:** Reserves stock.
3. **Shipping:** Generates a label.
4. **Compensation:** If Shipping fails, the Orchestrator automatically triggers a stock restoration in Inventory and a refund in Payment.

## How to Run
1. Clone the repository.
2. Navigate to `src`.
3. Compile and run `saga.Main`.
4. Observe the console output for both "Success" and "Rollback" scenarios.
