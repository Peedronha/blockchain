package br.com.block;

import br.com.stringUtil.StringUtil;

import java.util.Date;

public class Block {

    public String hash;
    public String previousHash;
    private final String data;
    private final Long timeStamp;
    private int nonce;

    public Block(String data, String previousHash) {
        this.previousHash = previousHash;
        this.hash = calculateHash();
        this.data = data;
        this.timeStamp = new Date().getTime();
    }

    public String calculateHash(){
        return StringUtil.applySha256(previousHash + timeStamp + nonce + data);
    }

    public void mineBlock(int difficulty){
        String target = new String(new char[difficulty]).replace('\0', '0');
        while(!hash.substring(0, difficulty).equals(target)){
            nonce++;
            hash = calculateHash();
        }
        IO.println("Block Mined: " + hash);
    }
}
