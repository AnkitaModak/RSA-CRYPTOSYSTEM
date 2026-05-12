🔐 RSA Cryptosystem in Java

A Java-based implementation of the RSA Cryptographic Algorithm used for secure message encryption and decryption using public and private keys. This project demonstrates the fundamentals of asymmetric cryptography, modular arithmetic, and secure communication systems.

---

📌 Features

- RSA Key Generation using prime numbers
- Public & Private Key Encryption System
- Message Encryption and Decryption
- Modular Arithmetic Operations
- GCD & Euler Totient Function Calculation
- BigInteger-based RSA Computation
- Menu-Driven Console Interface
- Password-Protected Decryption

---

🛠️ Technologies Used

- Java
- Object-Oriented Programming (OOP)
- BigInteger Class
- Modular Exponentiation
- Cryptography Concepts

---

📚 Concepts Implemented

- RSA Algorithm
- Public Key Cryptography
- Prime Number Generation
- Euler’s Totient Function "φ(n)"
- Modular Multiplicative Inverse
- Encryption & Decryption Logic

---

⚙️ How It Works

1. Two prime numbers ("p" and "q") are generated.

2. The modulus "n = p × q" is calculated.

3. Euler’s Totient Function is generated:

4. Public key "e" and private key "d" are generated.

5. Messages are encrypted using:

6. Ciphertext is decrypted using:

---

▶️ How to Run

1. Clone the repository
2. Open the project in IntelliJ IDEA / VS Code / Eclipse
3. Compile the Java files
4. Run the "Main.java" file
5. Enter lower and upper bounds for prime generation
6. Encrypt and decrypt messages through the menu interface

---

🚀 Improvements Made

- Fixed incorrect private key ("d") generation
- Replaced "Math.pow()" with "BigInteger.modPow()"
- Improved RSA calculation accuracy
- Corrected decrypted character conversion
- Optimized encryption/decryption logic

---

👩‍💻 Author
Ankita Modak
