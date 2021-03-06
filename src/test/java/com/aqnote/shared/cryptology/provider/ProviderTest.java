/*
 * Copyright 2013-2023 "Peng Li"<aqnote@qq.com> Licensed under the AQNote License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.aqnote.com/licenses/LICENSE-1.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 */
package com.aqnote.shared.cryptology.provider;

import java.security.Provider;
import java.security.Security;
import java.util.Iterator;
import java.util.Set;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import cryptix.provider.Cryptix;

/**
 * ProviderOpr.java desc：provider信息查询
 * 
 * @author "Peng Li"<aqnote@qq.com> Jun 9, 2014 1:04:08 PM
 */
public class ProviderTest {

    public static void listProviders() {
        Provider[] providers = Security.getProviders();
        for (int i = 0; i < providers.length; i++) {
            printProvider(providers[i]);
        }
    }

    public static void printProvider(Provider provider) {
        if (provider == null) {
            return;
        }
        System.out.println("Provider name: " + provider.getName());
        System.out.println("Provider information: " + provider.getInfo());
        System.out.println("Provider version: " + provider.getVersion());
        Set<?> entries = provider.entrySet();
        Iterator<?> iterator = entries.iterator();
        while (iterator.hasNext()) {
            System.out.println("\tProperty entry: " + iterator.next());
        }
    }

    public static void addProvider(Provider provider) {
        if (provider == null) {
            return;
        }
        Security.addProvider(provider);
    }

    public static void insertProvider(Provider provider) {
        if (provider == null) {
            return;
        }
        Security.insertProviderAt(provider, 1);
    }

    public static void main(String[] args) {
//        printProvider(new sun.security.pkcs11.SunPKCS11());
        printProvider(new BouncyCastleProvider());
        printProvider(new Cryptix());

        listProviders();

        addProvider(new BouncyCastleProvider());
        addProvider(new Cryptix());
        listProviders();
    }
}
