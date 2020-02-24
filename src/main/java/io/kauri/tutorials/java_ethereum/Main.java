package io.kauri.tutorials.java_ethereum;

import java.io.IOException;
import java.math.BigInteger;

import jnr.ffi.Address;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeEncoder;
import org.web3j.codegen.TruffleJsonFunctionWrapperGenerator;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthFilter;
import org.web3j.protocol.http.HttpService;
import org.web3j.protocol.core.methods.response.EthBlockNumber;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;

public class Main {
    public static void main(String[] args){
        System.out.println("Connecting to Ethereum ...");
        Web3j web3 = Web3j.build(new HttpService("https://mainnet.infura.io/v3/8efa9729f0b844bfae86acef7c859c72"));
        System.out.println("Successfuly connected to Ethereum");
        try {
            // web3_clientVersion returns the current client version.
            Web3ClientVersion clientVersion = web3.web3ClientVersion().send();

            //eth_blockNumber returns the number of most recent block.
            EthBlockNumber blockNumber = web3.ethBlockNumber().send();

            //eth_gasPrice, returns the current price per gas in wei.
            EthGasPrice gasPrice =  web3.ethGasPrice().send();

            System.out.println("clientVersion: "+clientVersion.getWeb3ClientVersion());
            System.out.println("blockNumber: "+blockNumber.getBlockNumber());
            System.out.println("gasPrice: "+gasPrice.getGasPrice());


        } catch(IOException ex) {
            throw new RuntimeException("Error whilst sending json-rpc requests", ex);
        }


    }
}
