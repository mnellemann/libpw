Password Library
-----------------------------------

Simple library to generate secure random passwords.


To build and test the code;

    ./gradlew build


## Usage

Import the library and use the static PasswordGenerator.random() method, which returns a String with a new random pasword. There are options to specify the length of the password, if the password should contain capitalized, numeric and/or symbol characters.

    String newRandomPassword = PasswordGenerator.random(int length, boolean optionCapitalize, boolean optionNumerals, boolean optionSymbols)


### Gradle

    repositories {
        maven { url 'https://dl.bintray.com/mnellemann/libs' } 
    }

    dependencies {
        compile 'biz.nellemann.libs:libpw:1.0.+'
    }
