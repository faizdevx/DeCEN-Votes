# 🗳️ DeCEN-Votes – A Blockchain-Based Voting System in Java & Spring Boot

## 🔍 Why & What This Is

**DeCEN-Votes** is a prototype for a private blockchain-based voting system engineered in Java with Spring Boot. Inspired by cutting-edge cryptography, the app demonstrates how modern elections can be made secure, transparent, and tamper-proof.  
It lays the groundwork for advanced features like smart contracts, full user identity verification (using Aadhaar & Voter ID), time-bound voting cycles, and even synchronization to public blockchains for future auditability.

## 🔗 What is Blockchain?

A **blockchain** is a distributed digital ledger where each block contains:
- **Data:** (for voting: encrypted vote info or voter/candidate IDs)
- **Hash:** SHA256 fingerprint of current block’s contents
- **Previous Hash:** hash of the preceding block (chains them together)
- **Timestamp:** when the vote/block was created
- *(Prototype note: Public/private key info and wallet addresses are logical features, ready for future upgrade)*

**Key Advantages in Voting:**
- **Immutable:** Once data is written, it cannot change unnoticed.
- **Anonymous:** Voters are tracked by cryptographic credentials instead of personal details.
- **Transparent & Tamper-Proof:** Anyone can audit, but no one can secretly manipulate.
- **Decentralized:** Minimizes single points of failure and trust.

## ⚙️ How DeCEN-Votes Operates (Prototype Flow)

1. **User Authenticates:**  
   - User logs in with username and password (demo users).
   - Unique session for each voter, enforced by Spring Security.

2. **Voting:**  
   - On the web form, an eligible voter casts a single vote for any candidate.
   - Voting is limited: only **one submission per user**.
   - Vote is recorded as a new block on the blockchain.

3. **Blockchain Storage:**  
   - Each block contains: voter ID, candidate selected, and cryptographic hashes for security.
   - Every block confirms and depends on its predecessor, ensuring tamper evidence.

4. **Election Integrity & Live Results:**  
   - Any manipulation (even a single changed vote) breaks the hash chain and is immediately detectable (“Chain valid: false”).
   - Results tally page displays updated, real-time counts per candidate.

5. **REST API Access:**  
   - Fetch raw blockchain and live tally as JSON for integration or auditing.

## 🔒 Core Features

| Feature            | Description                                         |
|--------------------|-----------------------------------------------------|
| User Auth/Login    | Demo accounts with password (Spring Security)        |
| One-Vote Policy    | Users can vote for one candidate, only once         |
| Blockchain Ledger  | Each vote is a block, hashed, and chained           |
| Tally & Results    | Votes are auto-counted live after every vote        |
| Vote Integrity     | Blockchain validity visible (chain tampering flagged)|
| Simple Web UI      | Modern Thymeleaf-based forms and dashboards         |

## 💡 Design Philosophy

> “Decentralization isn’t about trustlessness — it’s about **transparent trust**.”

DeCEN-Votes enforces strict one-voter-one-vote policy, instant auditability, and privacy-first design.  
Vote integrity is maintained through cryptographic hashes; no mining or public network required for demo.

## 🚀 Tech Stack

- **Java 17**
- **Spring Boot 3.x**
- **Spring Security** (user auth)
- **Thymeleaf** (dynamic web UI)
- **Maven**
- **RESTful APIs**
- *(Future-ready for: Bouncy Castle, Public Blockchain, SQL DBs)*

## 👨‍💻 How to Run This Prototype

1. **Build and start:**
   ```bash
   ./mvnw clean spring-boot:run
   ```
2. **Login in your browser at:**  
   ```
   http://localhost:8080/login
   ```

   Use demo credentials:
   - **alice / alice**
   - **bob / bob**
   - **charlie / charlie**

3. **Dashboard (`/blockchain`):**
   - View all blocks (votes)
   - See current chain health

4. **Vote (`/vote`):**
   - Select a candidate
   - Submit—vote is accepted if not already cast

5. **Live Results (`/results`):**
   - See running tally per candidate

6. **APIs (for developers/auditors):**
   - `/api/chain` – Blockchain as JSON
   - `/api/chain/tally` – Vote summary as JSON

## 📂 Folder Structure

```
/decen-votes
├── src/
│   └── main/java/com/votechain/votechain_india/
│        ├── Block.java
│        ├── BlockchainService.java
│        ├── BlockchainController.java
│        ├── SecurityConfig.java
│        └── VotechainIndiaApplication.java
│   └── resources/templates/
│        ├── login.html
│        ├── blockchain.html
│        ├── vote.html
│        └── results.html
├── pom.xml
└── README.md
```


## 🙋‍♂️ Author

Built with ❤️ by **Faizal** | CSE-AI UnderGrad

## 🏁 Status

> **This project is an MVP/prototype.**  
The current system demonstrates blockchain-based vote recording, one-vote user enforcement, and real-time transparency in a single-Java-instance context.  
Further enhancements (wallets, Aadhaar/voter ID, face/biometric verification, mobile, public-chain sync, etc.) are outlined for future roadmaps.

**Enjoy transparent, tamper-proof, auditable e-voting!**

## FEATURES IN PROCESS

Decentralized Identity (Zero-Knowledge Proofs): Secure, private voter authentication without traditional IDs.

Automated Smart Contract: Authoritative contract for election process and automatic result publication.

Verifiable & Private Voting: Voters verify their vote without revealing their choice.

Docker Deployment: Ensures consistent, portable, and scalable application deployment.

Enhanced Admin Features:

Election management (start/end, candidates, analytics).

Automated reporting, graphs, and AI/ML for fraud detection.
