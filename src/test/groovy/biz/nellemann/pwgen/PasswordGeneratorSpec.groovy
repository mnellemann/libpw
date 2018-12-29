package biz.nellemann.pwgen

import spock.lang.Specification

class PasswordGeneratorSpec extends Specification {

    String regexpAlphaLower = /[a-z]+/
    String regexpAlphaUpper = /[A-Z]+/
    String regexpNumeral = /[0-9]+/
    String regexpSymbols = /[^a-zA-Z\d\s:]/


    def setup() {
    }

    def cleanup() { }


    void "test passwords with 4 random chars"() {

        given:
        def randomPassword = PasswordGenerator.random(4, false, false, false)

        expect:
        randomPassword.length() == 4
        randomPassword.findAll(regexpAlphaLower)
    }


    void "test passwords with 8 random alpha chars"() {

        given:
        def randomPassword = PasswordGenerator.random(8, false, false, false)

        expect:
        randomPassword.length() == 8
        !randomPassword.findAll(regexpAlphaUpper)
        !randomPassword.findAll(regexpNumeral)
        !randomPassword.findAll(regexpSymbols)
    }


    void "test passwords with 8 random alpha + alphaUpperCase chars"() {

        given:
        def randomPassword = PasswordGenerator.random(8, true, false, false)

        expect:
        randomPassword.length() == 8
        randomPassword.findAll(regexpAlphaUpper)
        !randomPassword.findAll(regexpNumeral)
        !randomPassword.findAll(regexpSymbols)
    }

    void "test passwords with 8 random alpha + numeral chars"() {

        given:
        def randomPassword = PasswordGenerator.random(8, false, true, false)

        expect:
        randomPassword.length() == 8
        !randomPassword.findAll(regexpAlphaUpper)
        randomPassword.findAll(regexpNumeral)
        !randomPassword.findAll(regexpSymbols)
    }

    void "test passwords with 8 random alpha + symbol chars"() {

        given:
        def randomPassword = PasswordGenerator.random(8, false, false, true)

        expect:
        randomPassword.length() == 8
        !randomPassword.findAll(regexpAlphaUpper)
        !randomPassword.findAll(regexpNumeral)
        randomPassword.findAll(regexpSymbols)
    }

    void "test passwords with 32 random chars from all classes"() {

        given:
        def randomPassword = PasswordGenerator.random(32, true, true, true)

        expect:
        randomPassword.length() == 32
        randomPassword.findAll(/[A-Z]+/)
        randomPassword.findAll(/\d+/)
        randomPassword.findAll(/[^a-zA-Z\d\s:]/)
    }

}

