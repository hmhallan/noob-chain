package com.hallanmedeiros.blockchain;

import org.junit.Test;

import com.hallanmedeiros.blockchain.dto.Block;
import com.hallanmedeiros.blockchain.dto.BlockChain;

public class ChainTest {

	private static int DIFICULDADE = 2;
	
	@Test
	public void cria_blocos() {
		
		
		BlockChain blockChain = new BlockChain();
		
		Block genesisBlock = new Block("Primeiro bloco", "0");
		Block secondBlock = new Block("Dados do segundo bloco", genesisBlock.getHash());
		Block thirdBlock = new Block("Dados do terceiro bloco", secondBlock.getHash());
		
		blockChain.addBlock(genesisBlock);
		blockChain.addBlock(secondBlock);
		blockChain.addBlock(thirdBlock);
		
		for( Block b: blockChain.getChain() ) {
			b.mineBlock(DIFICULDADE);
		}
		
		System.out.println("Hash do bloco 1 : " + genesisBlock.getHash());
		
		System.out.println("Hash do bloco 2 : " + secondBlock.getHash());
		
		System.out.println("Hash do bloco 3 : " + thirdBlock.getHash());
	}
}
