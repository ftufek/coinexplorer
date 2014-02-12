package org.coinexplorer.rpc;

public class ScriptSignature {
	private String asm; // Assembly code of the Script;
	private String hex;
	
	public String getAsm() {
		return asm;
	}
	public void setAsm(String asm) {
		this.asm = asm;
	}
	public String getHex() {
		return hex;
	}
	public void setHex(String hex) {
		this.hex = hex;
	}
	
}
