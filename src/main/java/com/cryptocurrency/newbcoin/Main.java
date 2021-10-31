package com.cryptocurrency.newbcoin;

import java.util.ArrayList;
import java.util.List;

/**
 * this class contains the minimum instructions required to create and test our crypocurrency.
 */
public class Main {

	public static List<Block> newbchain = new ArrayList<>();
	public static int prefix = 5;

	public static void main(String[] args) {

		// DisplayInformation Instantiation
		DisplayInformation displayDataImplSystemOut = new DisplayInformationImpl();

		// Display opening banner
		displayDataImplSystemOut.displayOpeningBanner();

		DigitalWallet myWallet = DigitalWallet.getInstance();

		// Display all blocks
		displayDataImplSystemOut.displayWallet(myWallet);

		Block block1 = new Block("Thomas sends 1n to Jean-françois", "0");
		block1.mineBlock(prefix);
		newbchain.add(block1);

		Block block2 = new Block("Jean-françois sends 0.1n to Taqueria el farolito",
				newbchain.get(newbchain.size() - 1).getHash());
		block2.mineBlock(prefix);
		newbchain.add(block2);

		Block block3 = new Block("José sends 5n to Maria", newbchain.get(newbchain.size() - 1).getHash());
		block3.mineBlock(prefix);
		newbchain.add(block3);

		// Display all blocks
		displayDataImplSystemOut.displayAllBlocks(newbchain);

		// Check and display if the BlockChain is valid
		displayDataImplSystemOut.displayValidityOfBlockChain(BlockChainUtils.checkBlockChain(newbchain, prefix));

		// Display closing banner
		displayDataImplSystemOut.displayClosingBanner();
	}
}