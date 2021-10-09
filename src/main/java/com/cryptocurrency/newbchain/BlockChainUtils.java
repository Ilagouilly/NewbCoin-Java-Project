package com.cryptocurrency.newbchain;

import java.util.List;

/**
 * This class handles everything related to our BlockChain
 */
public class BlockChainUtils {

	public static String buildPrefixString(int prefix) {
		return new String(new char[prefix]).replace('\0', '0');
	}
    
    public static Boolean checkBlockChain(List<Block> newbchain, int prefix) {
		Block currentBlock;
		Block previousBlock;
		String hashTarget = buildPrefixString(prefix);

		// loop through blockchain to check hashes:
		for (int i = 1; i < newbchain.size(); i++) {
			currentBlock = newbchain.get(i);
			previousBlock = newbchain.get(i - 1);
			// compare registered hash and calculated hash:
			if (!currentBlock.getHash().equals(currentBlock.calculateBlockHash())) {
				System.out.println("Current Hashes not equal");
				return false;
			}
			// compare previous hash and registered previous hash
			if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
				System.out.println("Previous Hashes not equal");
				return false;
			}
			// check if hash is solved
			if (!currentBlock.getHash().substring(0, prefix).equals(hashTarget)) {
				System.out.println("This block hasn't been mined " + currentBlock.getHash() + " " + hashTarget);
				return false;
			}
		}
		return true;
	}
}
