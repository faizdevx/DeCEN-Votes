package com.votechain.votechain_india;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Date;

public class Block {
    private final int    index;
    private final long   timestamp;
    private final String data;
    private final String previousHash;
    private final String hash;

    public Block(int index, String data, String previousHash) {
        this.index        = index;
        this.timestamp    = new Date().getTime();
        this.data         = data;
        this.previousHash = previousHash;
        this.hash         = calculateHash();
    }

    public String calculateHash() {
        String input = index + timestamp + data + previousHash;
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-256");
            byte[] bytes = sha.digest(input.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) sb.append('0');
                sb.append(hex);
            }
            return sb.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /* getters */
    public int    getIndex()        { return index; }
    public long   getTimestamp()    { return timestamp; }
    public String getData()         { return data; }
    public String getPreviousHash() { return previousHash; }
    public String getHash()         { return hash; }
}
