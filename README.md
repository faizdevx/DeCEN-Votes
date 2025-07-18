# DeCEN-Votes

# why and what this is 

so as i have grasp in java and spring boot so i decided to let that concept to create a blockchain based voting system and create a smart contract using this java and spring boot and create a private blockchain system 
i will also giving documentation that how i be adding that to public blockchain to increase the validation from voters side 

## what is blockchain 

nodes connected to each other named as blocks in a chain is know as bkockchain each block contains info like data,previous hash,current hash , detaild of wallet address , timestamp it all based on santhosi nagamoto paper of bitcoin decentralized bank later ethereum introduced Vitaly Dmitrievich Buterin that introduced and let decentrilized apps to public there private blockchain on it which increases the craze of this blockchain 

eventually the concept of blockchain is vast but it short why it helps in voting 

1) it is immutable
2) it is anonymous
3) peer to peer network
4) no tempering case if in public blockchain or even in private blockchain as the concept of private key and public key is immatchable


## working 

i created a application of blockchain anyone downloads it he become a miner in terms of blockchain so it will give them walled id and private key public key and all where private key stored in local encrypted all these things done by application then my smart contracts came in action and done all the work so that i can also implement whole blockchain to voting 


# how my blockchain voting system works 

user input adhar card and voter id and name ( eventually i know thats not enough i can add biometric and face recognition further for it ) 
then a persons new wallet if that person have not registrerd means here a concept of log in and registration first then it goes into blockchain concept create a wallet address for user then public private keyy that makes you anonymous and eligible for voting and then smart contracts apply to it such that only one vote for one and time period for each 4 year then a script that calculates a voting system at end of time i values like when i start blockchain i consittuted time period that it runs for 1 month then it stops then it will run for 1 month after 4 years from beginning no previos transcation only the wallet adress will be there plus new registred 



# core features 

| Feature            | Description                                            |
| ------------------ | ------------------------------------------------------ |
| Voter Registration | Verify Aadhaar + VoterID + Name                        |
| Voting Wallet      | Each verified voter gets a wallet address (public key) |
| Cast Vote          | Smart contract (service layer) checks: one vote only   |
| Blockchain         | Store each vote as a block with hash                   |
| Election Cycle     | Lock voting after deadline (simulate 5-year cycle)     |
| Results            | Count votes from chain and display                     |
| Security           | No mining; trusted validator bots (Spring Services)    |


