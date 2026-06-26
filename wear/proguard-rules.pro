# Wear OS ProGuard rules
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable
-dontobfuscate

# Keep serialization
-keepclassmembers class com.kokeeu.siwoplayer.shared.** {
    *;
}
