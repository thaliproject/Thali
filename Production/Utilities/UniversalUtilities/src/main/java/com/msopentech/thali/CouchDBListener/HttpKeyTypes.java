/*
Copyright (c) Microsoft Open Technologies, Inc.
All Rights Reserved
Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0

THIS CODE IS PROVIDED ON AN *AS IS* BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, EITHER EXPRESS OR IMPLIED,
INCLUDING WITHOUT LIMITATION ANY IMPLIED WARRANTIES OR CONDITIONS OF TITLE, FITNESS FOR A PARTICULAR PURPOSE,
MERCHANTABLITY OR NON-INFRINGEMENT.

See the Apache 2 License for the specific language governing permissions and limitations under the License.
*/

package com.msopentech.thali.CouchDBListener;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.msopentech.thali.utilities.universal.HttpKeyURL;

public class HttpKeyTypes {
    protected String localMachineIPHttpKeyURL = null;
    protected String onionHttpKeyURL = null;
    protected String socksOnionProxyPort = null;

    /**
     * This constructor is just meant for use when parsing from JSON.
     */
    @JsonCreator
    public HttpKeyTypes() {

    }

    public HttpKeyTypes(HttpKeyURL localMachineIpHttpKeyUrl, HttpKeyURL onionHttpKeyURL, Integer socksOnionProxyPort) {
        this.localMachineIPHttpKeyURL = localMachineIpHttpKeyUrl.toString();
        this.onionHttpKeyURL = onionHttpKeyURL.toString();
        this.socksOnionProxyPort = socksOnionProxyPort.toString();
    }

    public String getLocalMachineIPHttpKeyURL() {
        return localMachineIPHttpKeyURL;
    }

    public void setLocalMachineIPHttpKeyURL(String localMachineIPHttpKeyURL) {
        this.localMachineIPHttpKeyURL = localMachineIPHttpKeyURL;
    }

    public String getOnionHttpKeyURL() {
        return onionHttpKeyURL;
    }

    public void setOnionHttpKeyURL(String onionHttpKeyURL) {
        this.onionHttpKeyURL = onionHttpKeyURL;
    }

    public String getSocksOnionProxyPort() {
        return socksOnionProxyPort;
    }

    public void setSocksOnionProxyPort(String socksOnionProxyPort) {
        this.socksOnionProxyPort = socksOnionProxyPort;
    }
}
