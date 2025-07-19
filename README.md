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

1. Decentralized Identity & Private Authentication
Given the restrictions on direct API access to sensitive government databases like Aadhaar and Voter ID for small repositories, our system will implement a robust and privacy-preserving authentication mechanism:

Multi-Factor Authentication (MFA): Users will authenticate using multiple factors to enhance security.

Decentralized Identity (DID) with Zero-Knowledge Proofs (ZKPs): Voters will be able to prove their eligibility (e.g., that they are a registered voter and meet age requirements) without revealing their actual identity or sensitive personal information to the application or third parties. This leverages Zero-Knowledge Proofs to ensure privacy while maintaining verifiability.

2. Authoritative Smart Contract for Election Automation
At the core of the election system is a smart contract designed to automate and enforce the election process:

Automated Election Lifecycle: An authoritative smart contract will govern the entire election process, from registration to result declaration.

Automatic Result Calculation & Publication: When polls officially close, the smart contract will automatically calculate the final election results based on the recorded votes and immutably publish them on the blockchain, ensuring transparency and preventing tampering.

3. Verifiable Voting with Privacy
Voter trust is paramount. Our system ensures that voters can independently verify their vote while maintaining their privacy:

Individual Vote Verification: Each voter will receive a unique cryptographic receipt or identifier upon casting their vote. They can use this to verify that their vote was indeed recorded on the blockchain.

Zero-Knowledge Proofs for Choice Privacy: The verification process will allow voters to confirm their vote's inclusion and accuracy without revealing their specific choice to any third party, including the election administrators or other voters. This preserves the secrecy of the ballot.

4. Docker Deployment
The entire application, including the Spring Boot backend and any associated blockchain nodes, will be deployed using Docker. This approach offers significant benefits:

Consistency: Ensures the application runs identically across development, testing, and production environments.

Portability: Simplifies deployment across various cloud providers or on-premises infrastructure.

Scalability: Facilitates easy scaling of application components and blockchain nodes as needed.

Isolation: Provides a clean, isolated environment for each component, preventing conflicts.

5. Enhanced Administrative Features
The system will provide comprehensive tools for election administrators:

Election Event Management:

Start/End Elections: Admins can initiate and conclude election periods.

Candidate Management: Tools to add, modify, or remove candidates.

Participation Analytics: Real-time dashboards showing voter turnout and engagement.

Validator Health Monitoring: Overview of the health and status of blockchain validator nodes (if applicable to the chosen blockchain architecture).

Automated Reporting & Analytics:

Downloadable Reports: Generate and download detailed election reports.

Advanced Graphs: Visualizations of voting trends, participation rates, and other key metrics.

Anomaly Detection (AI/ML): Integration of Artificial Intelligence and Machine Learning models to detect unusual voting patterns or potential fraud attempts, providing alerts to administrators.
