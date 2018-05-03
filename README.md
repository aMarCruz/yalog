# YaLog

[![Release](https://jitpack.io/v/aMarCruz/yalog.svg)](https://jitpack.io/#aMarCruz/yalog)
[![License](https://img.shields.io/npm/l/express.svg)](https://github.com/aMarCruz/yalog/blob/master/LICENSE)

Simple wrapper for Android Log with automatic level exclusion

## Yet Another Log library?

I want a super-simple, drop-in replacement for `android.util.Log` that...

* use formatted string or arbitrary comma-separated parameter list.
* does not generate output for tag/levels specified *by code*.
* has no performance penalties.
* use gradle 4.x

## Setup

1. Add JitPack in your root build.gradle at the end of repositories:

    ```gradle
    repositories {
        maven { url "https://jitpack.io" }
    }
    ```

2. Add the dependency

    ```gradle
    dependencies {
        implementation 'com.github.amarcruz:yalog:{version}'
    }
    ```

## Usage

```java
// Import this plugin instead the default android Log
import com.github.amarcruz.Log;

...
private static final String TAG = "MyTAG";

// The default log level is predefined to ALL, but you can change it with
Log.setLevel(BuildConfig.DEBUG ? Log.DEBUG : Log.WARN);

// and you can override the default level by tag
Log.setLevel(TAG, Log.ALL);

// Use it as the android.util.Log that you know...
Log.v(TAG, "Hello Log");

// With formatted string
Log.v(TAG, "%s %d", "Hello", 2);

// ...or list
Log.v(TAG, "Hello", 3);

// Because the default level restriction, this does not generates output:
Log.v("Tag2", "Hello");
```
