# 🗳️ DeCEN-Votes – A Blockchain-Based Voting System in Java & Spring Boot

## 🔍 Why & What This Is

As a Java and Spring Boot enthusiast, I decided to turn a powerful concept into code — creating a **private blockchain-based voting system**. This system ensures secure, transparent, and tamper-proof elections using **smart contracts**, identity verification (Aadhaar & Voter ID), and periodic voting enforcement.

Additionally, I'm documenting how this system can optionally be **synced to a public blockchain** (e.g., Ethereum) for audit-proof verification.

---

## 🔗 What is Blockchain?

**Blockchain** is a chain of blocks where each block contains:
- ✅ Data (e.g., votes)
- 🔒 Hash of the current and previous block
- ⏱️ Timestamp
- 📬 Wallet Address info

Introduced in **Satoshi Nakamoto's Bitcoin whitepaper**, the blockchain revolutionized decentralization. Later, **Vitalik Buterin's Ethereum** expanded this into smart contracts and dApps — allowing powerful applications like decentralized voting.

**Why blockchain for voting?**
- 🔐 Immutable: Records can’t be changed
- 👤 Anonymous: Public/private key system
- 🌐 Peer-to-peer network
- 🧾 Transparent yet tamper-proof

---

## ⚙️ Working – How DeCEN-Votes Operates

### Step-by-step Flow:

1. **User Login/Register**:
   - Inputs Aadhaar number, Voter ID, and full name
   - If already registered → logs in
   - Else → a new voter wallet is generated

2. **Wallet Creation**:
   - Generates public/private key pair (wallet address)
   - Private key is securely encrypted & stored locally
   - User becomes a node in the blockchain network

3. **Vote Casting**:
   - System checks if the voter is verified and hasn’t voted
   - Smart contract allows **only one vote**
   - Voter selects from a list of parties
   - Vote stored as a block in the chain

4. **Time-bound Election**:
   - Election is open for a specific period (e.g., 1 month)
   - Once closed, further transactions are blocked
   - Election resumes after 4–5 years (simulating real cycle)

5. **Result Calculation**:
   - Script reads the blockchain ledger
   - Tally votes for each candidate
   - Publish results after deadline

---

## 🔒 Core Features

| Feature            | Description                                                |
|--------------------|------------------------------------------------------------|
| Voter Verification | Aadhaar + Voter ID + Name                                  |
| Wallet Address     | One-time generation of Public/Private Key pair             |
| Smart Contract     | Allows only one vote per voter, within valid timeframe     |
| Blockchain Ledger  | Each vote stored as a block (immutable & hashed)           |
| Time-bound Voting  | Enforced 4–5 year election cycle using timestamps          |
| Result Calculation | Votes are auto-counted and displayed after election closes |
| Validator Nodes    | Trusted Java-based bots validate blocks (no mining needed) |

---

## 💡 Design Philosophy

> 🧠 “Decentralization isn’t about trustlessness — it’s about transparent trust.”

This project ensures that no fake votes, double voting, or unauthorized access is allowed. It uses cryptographic principles (SHA256), and domain-driven Spring services, and avoids mining for a **lightweight private chain**.

---

## 🚧 Future Improvements

- 🔍 Add biometric or face ID verification
- 🌍 Push a hash of the final blockchain state to a public chain (e.g., Ethereum)
- 📱 Build mobile interface using Flutter or React Native
- 🧠 Integrate AI/ML to detect anomalous patterns in vote casting
- 🔐 Secure storage using hardware wallet integration

---

## 🚀 Tech Stack

- 🧩 Java 17
- 🌀 Spring Boot 3.x
- 🔐 Bouncy Castle (for crypto)
- 🗄️ MySQL / PostgreSQL
- 📦 Maven
- 📡 REST APIs
- 🌐 (Optional) IPFS or Ethereum (public sync layer)

---

## 👨‍💻 How to Run

> Full setup + deployment instructions will be added after codebase stabilizes.

---

## 📂 Folder Structure (Planned)

/decen-votes
├── src/
│ ├── main/java/
│ │ └── com.decen.votes/
│ │ ├── model/
│ │ ├── controller/
│ │ ├── service/
│ │ ├── blockchain/
│ │ ├── config/
│ │ └── utils/
│ └── resources/
│ ├── application.yml
│ └── ...
└── README.md



---

## 📜 License

MIT License – Feel free to use, fork, contribute.

---

## 🙋‍♂️ Author

Made with ❤ by **Faizal** | CSE-AI Engineer | [faizalspace.com (coming soon)]()
