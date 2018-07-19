/*
 * Copyright 2013-2023 "Peng Li"<aqnote@qq.com>
 * Licensed under the AQNote License, Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.aqnote.com/licenses/LICENSE-1.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aqnote.shared.cryptology.cert.util;

import java.util.List;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.X500NameBuilder;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类X509PrincipalUtil.java的实现描述：x509规则构造类
 * 
 * @author "Peng Li"<aqnote@qq.com> Dec 5, 2013 4:39:19 PM
 */
public class X500NameUtil {

    private static final Logger logger = LoggerFactory.getLogger(X500NameUtil.class);

    public static final String DN_C              = "CN";
    public static final String DN_ST             = "ZheJiang";
    public static final String DN_L              = "HangZhou";
    public static final String DN_O              = "AQNote";
    public static final String DN_OU             = "Inc";

    public static final String DN_ROOT_O         = "AQNote Company Ltd.";
    public static final String DN_ROOT_OU        = "www.aqnote.com";
    public static final String DN_ROOT_CN        = "AQNote Cert Signing Authority";
    public static final String DN_ROOT_E         = "aqnote@aqnote.com";

    public static final String DN_CLASS1_ROOT_CN = "AQNote Class 1 Root";
    public static final String DN_CLASS2_ROOT_CN = "AQNote class 2 Root";
    public static final String DN_CLASS3_ROOT_CN = "AQNote Class 3 Root";
    public static final String DN_CLASS3_END_OU  = "developer";

    /** 根证书构造 */
    public static X500Name createRootCaPrincipal() {
        X500NameBuilder x500NameBuilder = new X500NameBuilder(BCStyle.INSTANCE);
        x500NameBuilder.addRDN(BCStyle.E, DN_ROOT_E);
        x500NameBuilder.addRDN(BCStyle.CN, DN_ROOT_CN);
        x500NameBuilder.addRDN(BCStyle.OU, DN_ROOT_OU);
        x500NameBuilder.addRDN(BCStyle.O, DN_ROOT_O);
        return x500NameBuilder.build();
    }

    public static X500Name createClass1CaPrincipal() {
        X500NameBuilder x500NameBuilder = new X500NameBuilder(BCStyle.INSTANCE);
        x500NameBuilder.addRDN(BCStyle.CN, DN_CLASS1_ROOT_CN);
        x500NameBuilder.addRDN(BCStyle.OU, DN_OU);
        x500NameBuilder.addRDN(BCStyle.O, DN_O);
        return x500NameBuilder.build();
    }

    public static X500Name createClass1EndPrincipal(String cn, String email) {
        X500NameBuilder x500NameBuilder = new X500NameBuilder(BCStyle.INSTANCE);
        x500NameBuilder.addRDN(BCStyle.E, email);
        x500NameBuilder.addRDN(BCStyle.CN, cn);
        x500NameBuilder.addRDN(BCStyle.OU, DN_OU);
        x500NameBuilder.addRDN(BCStyle.O, DN_O);
        x500NameBuilder.addRDN(BCStyle.L, DN_L);
        x500NameBuilder.addRDN(BCStyle.ST, DN_ST);
        x500NameBuilder.addRDN(BCStyle.C, DN_C);
        return x500NameBuilder.build();
    }

    public static X500Name createClass3CaPrincipal() {
        X500NameBuilder x500NameBuilder = new X500NameBuilder(BCStyle.INSTANCE);
        x500NameBuilder.addRDN(BCStyle.CN, DN_CLASS3_ROOT_CN);
        x500NameBuilder.addRDN(BCStyle.OU, DN_ROOT_OU);
        x500NameBuilder.addRDN(BCStyle.O, DN_ROOT_O);
        return x500NameBuilder.build();
    }

    public static X500Name createClass3EndPrincipal(String cn, String email, String title) {
        X500NameBuilder x500NameBuilder = new X500NameBuilder(BCStyle.INSTANCE);
        x500NameBuilder.addRDN(BCStyle.E, email);
        x500NameBuilder.addRDN(BCStyle.CN, cn);
        x500NameBuilder.addRDN(BCStyle.T, title);
        x500NameBuilder.addRDN(BCStyle.OU, DN_CLASS3_END_OU);
//        x500NameBuilder.addRDN(BCStyle.O, DN_O);
//        x500NameBuilder.addRDN(BCStyle.L, DN_L);
//        x500NameBuilder.addRDN(BCStyle.ST, DN_ST);
//        x500NameBuilder.addRDN(BCStyle.C, DN_C);
        return x500NameBuilder.build();
    }

    public static X500Name createClass3EndPrincipal(String cn, String email) {
        X500NameBuilder x500NameBuilder = new X500NameBuilder(BCStyle.INSTANCE);
        x500NameBuilder.addRDN(BCStyle.E, email);
        x500NameBuilder.addRDN(BCStyle.CN, cn);
        x500NameBuilder.addRDN(BCStyle.OU, DN_OU);
        x500NameBuilder.addRDN(BCStyle.O, DN_O);
        x500NameBuilder.addRDN(BCStyle.L, DN_L);
        x500NameBuilder.addRDN(BCStyle.ST, DN_ST);
        x500NameBuilder.addRDN(BCStyle.C, DN_C);
        return x500NameBuilder.build();
    }

    public static X500Name createClass3EndPrincipal(List<String> cnList, String email) {
        X500NameBuilder x500NameBuilder = new X500NameBuilder(BCStyle.INSTANCE);
        x500NameBuilder.addRDN(BCStyle.E, email);
        for (String cn : cnList) {
            x500NameBuilder.addRDN(BCStyle.CN, cn);
        }
        x500NameBuilder.addRDN(BCStyle.OU, DN_OU);
        x500NameBuilder.addRDN(BCStyle.O, DN_O);
        x500NameBuilder.addRDN(BCStyle.L, DN_L);
        x500NameBuilder.addRDN(BCStyle.ST, DN_ST);
        x500NameBuilder.addRDN(BCStyle.C, DN_C);
        return x500NameBuilder.build();
    }

}
