``` java
Platform.initialize(getApplicationContext(), new IAuthCodeProvider() {
    @Override
    public void fetchAuthCodeAsync(String oauthUrl, Platform.IAuthCodeHandler authCodeHandler) {
    	performOAuthFlow(oauthUrl, authCodeHandler);            
    }
}
```
``` java
public performOAuthFlow (String oauthUrl, Platform.IAuthCodeHandler authCodeHandler) {

	WebView web;
	web = (WebView) _authDialog.findViewById(R.id.webv);
	web.setWebChromeClient(new WebChromeClient());
	web.getSettings().setJavaScriptEnabled(true);
	web.getSettings().setDomStorageEnabled(true);

	// Get auth_code
	web.loadUrl(oauthUrl);

	WebViewClient webViewClient = new WebViewClient() {
		boolean authComplete = false;
		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);

			if (url.startsWith(REDIRECT_URI)) {
			    Uri uri = Uri.parse(url);
			    String code = uri.getQueryParameter("code");
			    String error = uri.getQueryParameter("error");
			    if (code != null && !authComplete) {
				authComplete = true;
				authCodeHandler.onAuthCodeFetched(code);
			    } else if (error != null) {
			      // Handle error case                                    }
			}
		 }
	};

	_web.setWebViewClient(webViewClient);
}
```

```java
RemoteSystemDiscovery.Builder discoveryBuilder;
discoveryBuilder = new RemoteSystemDiscovery.Builder().setListener(new IRemoteSystemDiscoveryListener() {
    @Override
    public void onRemoteSystemAdded(RemoteSystem remoteSystem) {
        Log.d(TAG, "RemoveSystemAdded = " + remoteSystem.getDisplayName());
        devices.add(new Device(remoteSystem));
        // Sort devices
        Collections.sort(devices, new Comparator<Device>() {
            @Override
            public int compare(Device d1, Device d2)
            {
                return d1.getName().compareTo(d2.getName());
            }
        });
       }
});
startDiscovery();
```

```java
new RemoteSystemConnectionRequest(remoteSystem)
String url = "http://msn.com"

new RemoteLauncher().LaunchUriAsync(connectionRequest,
        url,
        new IRemoteLauncherListener() {
            @Override
            public void onCompleted(RemoteLaunchUriStatus status) {
            
            …
            }
        };
```

	
