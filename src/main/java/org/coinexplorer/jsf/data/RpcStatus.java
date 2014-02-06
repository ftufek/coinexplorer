package org.coinexplorer.jsf.data;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class RpcStatus {
	public boolean isConnected(){
		return false;
	}
}
