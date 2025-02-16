## SBT template demonstrating Java and Scala Native interop via FFM

Powered by [sbt-jextract plugin](https://github.com/indoorvivants/sbt-jextract), uses setup described in my [blog post](https://blog.indoorvivants.com/2025-02-16-scala-native-from-java-via-ffm).

**This project requires JDK 23+ to work**

If you have [Coursier](https://get-coursier.io/docs/overview) installed, you can launch SBT with `cs launch sbt --jvm 23`,
or just run the Java code with `cs launch sbt --jvm 23 -- jvmSide/run`
