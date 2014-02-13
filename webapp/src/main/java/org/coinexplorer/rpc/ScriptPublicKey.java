package org.coinexplorer.rpc;
import java.util.ArrayList;
import java.util.List;


public class ScriptPublicKey {
	private String asm;
	private int reqSigs;
	private String type;
	private List<String> addresses = new ArrayList<>();
	private String hex;
	
	public String getHex() {
		return hex;
	}
	public void setHex(String hex) {
		this.hex = hex;
	}
	public String getAsm() {
		return asm;
	}
	public void setAsm(String asm) {
		this.asm = asm;
	}
	public int getReqSigs() {
		return reqSigs;
	}
	public void setReqSigs(int reqSigs) {
		this.reqSigs = reqSigs;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<String> addresses) {
		this.addresses = addresses;
	}
	
}
