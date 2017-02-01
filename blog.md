``` java
Platform.initialize(getApplicationContext(), new IAuthCodeProvider() {
    @Override
    public void fetchAuthCodeAsync(String oauthUrl, Platform.IAuthCodeHandler authCodeHandler) {
    …            
    }
```
``` java
_web.loadUrl(_oauthUrl);
String code = uri.getQueryParameter("code");
_authCodeHandler.onAuthCodeFetched(code);
```

```
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


```
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

	