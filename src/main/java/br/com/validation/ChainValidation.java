package br.com.validation;

import br.com.block.Block;

import java.util.ArrayList;

public class ChainValidation {

    public ChainValidation() {
        /* This utility class should not be instantiated */
    }

    public static void isChainValid(ArrayList<Block> blockchain) {
         Block currentBlock;
         Block previousBlock;

        for(int i=1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);

            if(!currentBlock.hash.equals(currentBlock.calculateHash()) ){
                IO.println("Current Hashes not equal");
                return;
            }

            if(!previousBlock.hash.equals(currentBlock.previousHash) ) {
                IO.println("Previous Hashes not equal");
                return;
            }
        }
        IO.println("\nBlockchain is valid!\n");
    }
}
