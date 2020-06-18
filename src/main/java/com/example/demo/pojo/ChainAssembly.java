package com.example.demo.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ChainAssembly {
	@Value("${ChainAssemblyType1}")
	private  double ChainAssemblyType1;
	@Value("${ChainAssemblyType2}")
	private  double ChainAssemblyType2;
	@Value("${ChainAssemblyType3}")
	private  double ChainAssemblyType3;
	
	public  double getChainAssemblyType1() {
		return ChainAssemblyType1;
	}
	public  void setChainAssemblyType1(double chainAssemblyType1) {
		ChainAssemblyType1 = chainAssemblyType1;
	}
	public  double getChainAssemblyType2() {
		return ChainAssemblyType2;
	}
	public  void setChainAssemblyType2(double chainAssemblyType2) {
		ChainAssemblyType2 = chainAssemblyType2;
	}
	public  double getChainAssemblyType3() {
		return ChainAssemblyType3;
	}
	public  void setChainAssemblyType3(double chainAssemblyType3) {
		ChainAssemblyType3 = chainAssemblyType3;
	}
	public double getPrice( String value)
	{
		if(value.equalsIgnoreCase("ChainAssemblyType1"))
			return getChainAssemblyType1();
		else if(value.equalsIgnoreCase("ChainAssemblyType2"))
			return getChainAssemblyType2();
		else if(value.equalsIgnoreCase("ChainAssemblyType3"))
			return getChainAssemblyType3();
		return 0;
			
	}
}
