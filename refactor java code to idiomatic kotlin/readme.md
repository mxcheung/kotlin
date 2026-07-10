Kotlin was designed to reduce Java boilerplate, but migrations don't always get there. Production codebases often land in an in-between state: valid Kotlin that still follows Java patterns, with verbose class declarations, manual null guards, and imperative loops all doing work that idiomatic Kotlin can express in far fewer lines. Knowing how to recognize and eliminate those patterns is the skill that turns a working port into genuinely idiomatic Kotlin.

In this lab, you'll work with a running JVM CLI inventory application written in that Java-style Kotlin. The application processes and reports on a list of inventory items. You'll refactor it step by step, converting verbose class declarations to data classes, replacing explicit getter and setter methods with Kotlin property access, applying null-safe operators in place of manual guards, and swapping imperative loops for collection extension functions.

To start, you'll run the application to observe its current output and establish a green test baseline you'll carry as a safety net through every step.

The application directory already contains a runnable CLI application, a JUnit 5 behavioral test suite, and a Gradle Kotlin DSL build.
