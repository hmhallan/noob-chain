package com.hallanmedeiros.blockchain.dto;

import java.util.Date;

import com.hallanmedeiros.blockchain.util.CryptoUtil;

public class Block {
	
	private String hash;
	private String previousHash;
	
	private String data;
	
	private long timestamp;
	
	private int nonce;
	
	public Block() {
		super();
	}
	
	public Block(String data,String previousHash ) {
		this.data = data;
		this.previousHash = previousHash;
		this.timestamp = new Date().getTime();
		this.hash = calculateHash();  //calcula o hash
	}

	/**
	 * Calcula o hash deste bloco
	 * @return Hash do bloco atual
	 */
	public String calculateHash() {
		String calculatedhash = CryptoUtil.applySha256( 
				this.previousHash +
				Long.toString(this.timestamp) +
				Integer.toString(this.nonce) + 
				this.data 
				);
		return calculatedhash;
	}
	
	public void mineBlock(int difficulty) {
		String target = new String(new char[difficulty]).replace('\0', '0'); //cria uma String com conteúdo: ( difficulty * "0" )
		
		while(!hash.substring( 0, difficulty).equals(target)) {
			nonce ++;
			hash = calculateHash();
		}
		System.out.println("Bloco mineirado!!! : " + hash);
	}

	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getPreviousHash() {
		return previousHash;
	}
	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	
}
