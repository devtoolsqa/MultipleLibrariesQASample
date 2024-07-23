# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-keepclassmembers class * extends androidx.fragment.app.Fragment {
    public void onInflate(android.content.Context, android.util.AttributeSet, android.os.Bundle);
}

-keep class androidx.navigation.** { *; }
-keep class com.google.android.material.navigation.** { *; }

-keepattributes *Annotation*
-keep class com.example.kotlinpracticeudemy.startscreen.AppStartFragment { *; }
-keep class com.navigation.component.sample.data.MyParcelableDataArgs { *; }
-keep class com.navigation.component.sample.data.** { *; }
-keep class retrofit2.http.** { *; }

-keep class retrofit2.** { *; }
-keep interface retrofit2.** { *; }
-keep interface com.example.kotlinpracticeudemy.mvvm.requests.AuthApi { *; }
-keep class com.example.kotlinpracticeudemy.mvvm.models.Photos { *; }
-keep class com.example.kotlinpracticeudemy.mvvm.models.Camera { *; }
-keep class com.example.kotlinpracticeudemy.mvvm.models.Cameras { *; }
-keep class com.example.kotlinpracticeudemy.mvvm.models.Photo { *; }
-keep class com.example.kotlinpracticeudemy.mvvm.models.Rover { *; }
-keep class kotlinx.coroutines.internal.** { *; }
-keepclassmembers class kotlinx.coroutines.internal.MainDispatcherFactory { *; }
-dontwarn io.reactivex.**
-keep class io.reactivex.** { *; }
-keepclassmembers class io.reactivex.** { *; }

-keep class androidx.startup.** { *; }
 -keep class com.example.kotlinpracticeudemy.proguardbug.SplitInitializer { *; }