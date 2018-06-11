package com.hallanmedeiros.blockchain;

import org.junit.Test;

import com.hallanmedeiros.blockchain.dto.Block;

public class BlockTest {
	
	@Test
	public void cria_blocos() {
		Block genesisBlock = new Block("Primeiro bloco", "0");
		System.out.println("Hash do bloco 1 : " + genesisBlock.getHash());
		
		Block secondBlock = new Block("Dados do segundo bloco", genesisBlock.getHash());
		System.out.println("Hash do bloco 2 : " + secondBlock.getHash());
		
		Block thirdBlock = new Block("Dados do terceiro bloco", secondBlock.getHash());
		System.out.println("Hash do bloco 3 : " + thirdBlock.getHash());
	}
}