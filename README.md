Password Library
-----------------------------------

Java library to generate secure random passwords.


To build and test the code;

    ./gradlew build


## Usage

Import the library and use the static PasswordGenerator.random() method, which returns a String with a new random pasword. There are options to specify the length of the password, if the password should contain capitalized, numeric and/or symbol characters.

    String newRandomPassword = PasswordGenerator.random(int length, boolean optionCapitalize, boolean optionNumerals, boolean optionSymbols)


### Gradle

```groovy
repositories {
    maven { url 'https://jitpack.io' }  // Add the JitPack repository to your build file
}

dependencies {
    implementation 'org.bitbucket.mnellemann:libpw:v1.0.9'  // Add the dependency
}
```

### Maven

Add the JitPack repository to your build file

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```


Add the dependency

```xml
<dependency>
    <groupId>org.bitbucket.mnellemann</groupId>
    <artifactId>libpw</artifactId>
    <version>v1.0.9</version>
</dependency>
```
