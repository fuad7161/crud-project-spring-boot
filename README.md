# Banking API Documentation
## Overview
A comprehensive RESTful API for a banking system that handles customer management, account operations, transactions, loans, cards, and administrative functions.

### Base URL
https://api.yourbank.com/v1

## Authentication
All endpoints (except /auth/*) require JWT authentication in the Authorization header:

```
Authorization: Bearer <your_access_token>
```
## API Endpoints
### 1. Authentication & Authorization
#### Endpoint	Method	Description	Access
   - /auth/register	POST	Register a new customer or staff account	Public
   - /auth/login	POST	Login and generate access tokens	Public
   - /auth/logout	POST	Invalidate the user session/token	Authenticated
   - /auth/refresh-token	POST	Refresh JWT access token	Authenticated
   - /auth/password-reset/request	POST	Send password reset email/SMS	Public
   - /auth/password-reset/confirm	POST	Confirm and reset password	Public
   - /auth/2fa/enable	POST	Enable two-factor authentication	Authenticated
   - /auth/2fa/verify	POST	Verify 2FA code	Authenticated
### 2. Customer Management
#### Endpoint	Method	Description	Access
   - /customers	GET	List all customers	Admin only 
   - /customers/{id}	GET	Get details of a specific customer	Admin or own account 
   - /customers	POST	Create a new customer profile	Admin only 
   - /customers/{id}	PUT	Update customer profile	Admin or own account 
   - /customers/{id}	DELETE	Deactivate/delete customer account	Admin only 
   - /customers/{id}/accounts	GET	List all bank accounts of a customer	Admin or own account
### 3. Accounts Management
   #### Endpoint	Method	Description	Access
   - /accounts	GET	List all bank accounts	Admin only 
   - /accounts/{id}	GET	Get account details	Admin or account owner 
   - /accounts	POST	Open a new bank account	Authenticated customers 
   - /accounts/{id}	PUT	Update account details	Admin only 
   - /accounts/{id}	DELETE	Close/deactivate an account	Admin or account owner 
   - /accounts/{id}/balance	GET	Check account balance	Admin or account owner 
   - /accounts/{id}/statements	GET	Retrieve account statements	Admin or account owner
### 4. Transactions
   #### Endpoint	Method	Description	Access
   - /transactions	GET	List all transactions	Admin only
   - /transactions/{id}	GET	Get details of a transaction	Admin or transaction participant
   - /transactions/deposit	POST	Deposit money into an account	Teller/Admin
   - /transactions/withdraw	POST	Withdraw money from an account	Teller/Admin or account owner
   - /transactions/transfer	POST	Transfer money between accounts	Account owner
   - /transactions/schedule	POST	Schedule a future transaction	Account owner
   - /transactions/history/{accountId}	GET	Get transaction history for an account	Admin or account owner
   - /transactions/reverse/{id}	POST	Reverse a transaction	Admin only
### 5. Loans & Credit
   #### Endpoint	Method	Description	Access
   - /loans	GET	List all loans	Admin or own loans
   - loans/{id}	GET	Get loan details	Admin or loan owner
   - loans/apply	POST	Apply for a new loan	Authenticated customers
   - loans/{id}/approve	POST	Approve a loan	Admin only
   - loans/{id}/repay	POST	Make a loan repayment	Loan owner
   - loans/{id}/schedule	GET	Get repayment schedule	Admin or loan owner
### 6. Cards (Debit/Credit)
   #### Endpoint	Method	Description	Access
   - cards	GET	List all cards	Admin or own cards
   - cards/{id}	GET	Card details	Admin or card owner
   - cards	POST	Issue a new card	Admin or account owner
   - cards/{id}/block	POST	Block a card	Admin or card owner
   - cards/{id}/unblock	POST	Unblock a card	Admin or card owner
   - cards/{id}/transactions	GET	Card transaction history	Admin or card owner
### 7. Notifications
   #### Endpoint	Method	Description	Access
   - notifications	GET	List all notifications	Admin or own notifications
   - notifications/{id}	GET	Get details of a notification	Admin or notification owner
   - notifications/send	POST	Send a new notification (email/SMS/app)	Admin only
   - notifications/{id}/read	POST	Mark notification as read	Notification owner
### 8. Admin & Reporting
   #### Endpoint	Method	Description	Access
   - reports/customers	GET	Generate customer report	Admin only
   - reports/accounts	GET	Generate account report	Admin only
   - reports/transactions	GET	Generate transaction report	Admin only
   - reports/loans	GET	Generate loan report	Admin only
   - admin/users	GET	List all system users	Admin only
   - admin/audit-logs	GET	Access audit logs for security	Admin only
### 9. Security / Risk
   #### Endpoint	Method	Description	Access
   - security/login-attempts	GET	List failed login attempts	Admin only
   - security/alerts	GET	List suspicious activity alerts	Admin only
   - security/fraud-check	POST	Check transaction for fraud risk	Admin only
   - security/session/{id}/terminate	POST	Terminate a user session	Admin only
10. Settings / Configurations
   #### Endpoint	Method	Description	Access
   - settings/interest-rates	GET	View current rates	Authenticated users
   - settings/interest-rates	PUT	Update interest rates	Admin only
   - settings/fees	GET	View bank fees	Authenticated users
   - settings/fees	PUT	Update bank fees	Admin only
   Error Responses
   The API uses standard HTTP status codes:

### Status code
- 200 OK: Request succeeded

- 201 Created: Resource created successfully

- 400 Bad Request: Invalid input

- 401 Unauthorized: Authentication required

- 403 Forbidden: Insufficient permissions

- 404 Not Found: Resource not found

- 500 Internal Server Error: Server error

### Rate Limiting
API requests are limited to:

1000 requests per hour for authenticated users

100 requests per hour for unauthenticated requests

### Support
For technical support or questions about this API, please contact:

Email: api-support@yourbank.com

Documentation: https://developer.yourbank.com

Versioning
This documentation is for API version 1. Current version can be accessed at https://api.yourbank.com/v1.