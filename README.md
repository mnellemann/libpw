Secure Random Password Generator
-----------------------------------

Simple library to generate secure random passwords.


To build and test the code;

    gradle build
    gradle test


## Usage

Import the library and call the static PasswordGenerator.random() method, which return a String with a new random pasword. There are options to specify the length of the password, if the password should contain capitalized, numeric and/or symbol characters.


    String newRandomPassword = PasswordGenerator.random(int length, boolean optionCapitalize, boolean optionNumerals, boolean optionSymbols)


### Gradle
    
    repositories {
        maven { url 'https://dl.bintray.com/mnellemann/libs' } 
    }
    
    dependencies {
        compile 'biz.nellemann.pwgen:pwgen:0.0.1'
    }