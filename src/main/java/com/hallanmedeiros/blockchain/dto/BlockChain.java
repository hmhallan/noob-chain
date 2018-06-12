package com.hallanmedeiros.blockchain.dto;

import java.util.ArrayList;

import com.google.gson.GsonBuilder;

public class BlockChain {

	private ArrayList<Block> chain;

	public BlockChain() {
		super();
		this.chain = new ArrayList<>();
	} 
	
	public void addBlock(Block b) {
		this.chain.add(b);
	}
	
	public boolean isValid( int difficulty ) {
		Block currentBlock; 
		Block previousBlock;
		
		
		String hashTarget = new String(new char[difficulty]).replace('\0', '0');
		
		//loop em toda a cadeia para verificar os hashes
		for(int i=1; i < chain.size(); i++) {
			currentBlock = chain.get(i);
			previousBlock = chain.get(i-1);
			
			//compara o hash registrado e o hash calculado
			if(!currentBlock.getHash().equals(currentBlock.calculateHash()) ){
				System.out.println("Hashes diferentes");			
				return false;
			}
			//compara o hash anterior e o hash registrado anterior 
			if(!previousBlock.getHash().equals(currentBlock.getPreviousHash()) ) {
				System.out.println("Hashes anteriores diferentes");
				return false;
			}
			
			//verifica se o hash foi resolvido
			if(!currentBlock.getHash().substring( 0, difficulty).equals(hashTarget)) {
				System.out.println("Bloco não foi mineirado");
				return false;
			}
		}
		return true;
	}

	public ArrayList<Block> getChain() {
		return chain;
	}
	
	public String toJson() {
		return new GsonBuilder().setPrettyPrinting().create().toJson(this.chain);
	}
	
}
