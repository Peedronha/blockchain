package br.com;

import br.com.block.Block;
import br.com.validation.ChainValidation;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;


public class Main {

    static ChainValidation chainValidation = new ChainValidation();
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static int difficulty = 7;

    static void main(String[] args) {

        blockchain.add(new Block("Hi im the first block", "0"));
        blockchain.getLast().mineBlock(difficulty);

        blockchain.add(new Block("Yo im the second block", blockchain.getLast().hash));
        blockchain.getLast().mineBlock(difficulty);

        blockchain.add(new Block("Hey im the third block", blockchain.getLast().hash));
        blockchain.getLast().mineBlock(difficulty);

        chainValidation.isChainValid(blockchain);

        String blockchainJson = new GsonBuilder()
                                    .setPrettyPrinting()
                                    .create()
                                    .toJson(blockchain);

        System.out.println(blockchainJson);
    }
}
