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

package com.msopentech.thali.utilities.java.test;

import com.couchbase.lite.CouchbaseLiteException;
import com.msopentech.thali.utilities.universal.test.ThaliTestEktorpClient;
import junit.framework.TestCase;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.spec.InvalidKeySpecException;

public class JavaEktorpCreateClientBuilderTest extends TestCase {
    private static ThaliTestEktorpClient testEktorpClient = null;

    public void setUp() throws IOException, InterruptedException, KeyManagementException, UnrecoverableEntryException,
            NoSuchAlgorithmException, KeyStoreException {
        //ThaliTestUtilities.outputAsMuchLoggingAsPossible();
        //ThaliTestUtilities.configuringLoggingApacheClient();

        // TODO: The hard coding of the socks proxy and addresses, onion address, etc. are hacks until we put in
        // automated TOR Onion Proxy support. That will be in the next check in.

        /*
        Right /now setting up the testing is really dorky because I don't have self hosting for the Tor Onion Proxy.
        But all the nonsense below is temporary. The checkin after this one will fix this so all of this manual stuff will just
        go away.

        First, download the Tor Browser Bundle, it's probably the easiest way to get Tor up and running. In my case it
        installed to /c/users/yarong/Desktop/Tor Browser/Tor/tor.exe.

        Now go create a text file, traditionally called torrc somewhere (there is one in your distribution you can
        start with at /c/users/yarong/Desktop/Tor Browser/Data/Tor/torrc) and put in the following content:

        -------
        # This file was generated by Tor; if you edit it, comments will not be preserved
        # The old torrc file was renamed to torrc.orig.1 or similar, and Tor will ignore it

        DataDirectory C:\Users\yarong\Desktop\Tor Browser\Data\Tor
        DirReqStatistics 0
        GeoIPFile C:\Users\yarong\Desktop\Tor Browser\Data\Tor\geoip
        HiddenServiceDir c:\Users\yarong\Desktop\Tor Browser\Data\HiddenServiceDir
        HiddenServicePort 9999 127.0.0.1:9898
        HiddenServicePort 10000 127.0.0.1:9600
        SOCKSPort 192.168.1.188:9150
        --------

        Change the paths obviously based on your installation and change the SOCKSPort IP address to the address for
         your machine.

         Now go to the command line and run "tor -f 'path to your torrc file". This will start a local Tor Onion Proxy.

        Now you need to go to the HiddenServiceDir directory on your hard drive and find the file called 'hostname'.
        It will contain a string that ends in '.onion'. That full string is your Tor hidden service address for
        your machine. Please copy that string below (as an argument to ThaliTestEkctorpClient( ) where you see
        the '.onion' string. Note that you only need to
         do this once as the same address will continue to be re-used in the future by your local Tor instance.

        Also below please replace the IP address with your host machine's IP address.

        Now you are ready to run tests!
       */

        Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress("192.168.1.188", 9150));

        // I have to create a single global listener for all tests (which is really a mess in terms of bring sure
        // where bugs come from) because of https://github.com/couchbase/couchbase-lite-java-listener/issues/43
        if (testEktorpClient == null) {
//            testEktorpClient = new ThaliTestEktorpClient(ThaliListener.DefaultThaliDeviceHubAddress, 9898,
//                    "hrl5z4arnyciqsll.onion", 9999,
//                    ThaliCryptoUtilities.DefaultPassPhrase, new CreateContextInTemp(),
//                    new JavaEktorpCreateClientBuilder(), this.getClass(), proxy);
//
            //ThaliTestUtilities.turnCouchbaseLoggingTo11();
        }

        testEktorpClient.setUp();
    }

    public void tearDown() {
        testEktorpClient.tearDown();
    }

    public void testPullReplication() throws InterruptedException, NoSuchAlgorithmException, CouchbaseLiteException,
            URISyntaxException, IOException, InvalidKeySpecException, KeyManagementException,
            UnrecoverableEntryException, KeyStoreException {
        testEktorpClient.testPullReplication();
    }

    public void testPushReplication() throws IOException, NoSuchAlgorithmException, URISyntaxException,
            UnrecoverableEntryException, InterruptedException, CouchbaseLiteException, KeyStoreException,
            InvalidKeySpecException, KeyManagementException {
        testEktorpClient.testPushReplication();
    }

    public void testRetrieve() throws InterruptedException, NoSuchAlgorithmException, IOException,
            KeyManagementException, KeyStoreException, UnrecoverableEntryException, InvalidKeySpecException {
        testEktorpClient.testRetrieve();
    }
}
