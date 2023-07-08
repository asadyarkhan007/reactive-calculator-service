# Reactive Calculator Service

This is a reactive calculator service built using JDK 17, Spring WebFlux, and Lombok. It provides endpoints for performing addition, subtraction, multiplication, division, factorial, and table operations.

## Technologies Used

- JDK 17: The latest version of the Java Development Kit.
- Spring WebFlux: A reactive web framework provided by Spring.
- Lombok: A library that reduces boilerplate code by providing annotations for generating getters, setters, constructors, etc.

## Getting Started

To get started with the calculator service, follow these steps:

1. Clone the repository: `git clone https://github.com/your-username/your-repo.git`
2. Ensure JDK 17 is installed and set up on your system.
3. Open the project in your favorite IDE.
4. Build the project using your preferred build tool (Maven or Gradle).
5. Run the application.
6. The service will be available at `http://localhost:8080`.

## Endpoints

### Addition

**Request:**
- Method: POST
- URL: `/api/add`
- Body:
  ```json
  {
    "num1": 10,
    "num2": 5
  }
  ```

**Response:**
- Status: 200 OK
- Body:
  ```json
  {
    "result": 15,
    "date": "2023-07-04T12:34:56Z"
  }
  ```

### Subtraction

**Request:**
- Method: POST
- URL: `/api/subtract`
- Body:
  ```json
  {
    "num1": 10,
    "num2": 5
  }
  ```

**Response:**
- Status: 200 OK
- Body:
  ```json
  {
    "result": 5,
    "date": "2023-07-04T12:34:56Z"
  }
  ```

### Multiplication

**Request:**
- Method: POST
- URL: `/api/multiply`
- Body:
  ```json
  {
    "num1": 10,
    "num2": 5
  }
  ```

**Response:**
- Status: 200 OK
- Body:
  ```json
  {
    "result": 50,
    "date": "2023-07-04T12:34:56Z"
  }
  ```

### Division

**Request:**
- Method: POST
- URL: `/api/divide`
- Body:
  ```json
  {
    "num1": 10,
    "num2": 5
  }
  ```

**Response:**
- Status: 200 OK
- Body:
  ```json
  {
    "result": 2,
    "date": "2023-07-04T12:34:56Z"
  }
  ```

### Factorial

**Request:**
- Method: POST
- URL: `/api/factorial`
- Body:
  ```json
  {
    "num1": 5
  }
  ```

**Response:**
- Status: 200 OK
- Body:
  ```json
  {
    "result": 120,
    "date": "2023-07-04T12:34:56Z"
  }
  ```

### Table

**Request:**
- Method: POST
- URL: `/api/table`
- Body:
  ```json
  {
    "num1": 7
  }
  
  ```

**Response:**
- Status: 200 OK
- Body:
  ```json
  {
    "table": [7, 14, 21, 28, 35, 42, 49, 56, 63, 70],
    "date": "2023-07-04T12:34:56Z"
  }
  ```

## Contributing

Contributions to the calculator service are welcome! If you find any bugs or have suggestions for improvements, please open an issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

---

Please make sure to update the date field with the actual date when the response is generated.
