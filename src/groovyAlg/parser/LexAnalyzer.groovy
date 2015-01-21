package groovyAlg.parser

import java.text.CharacterIterator
import java.text.StringCharacterIterator

class Lex_Analyzer {
    String input
    String lexeme
    TOKEN_TYPE token
    String next_char
    CHAR_CLASS next_char_class
    CharacterIterator input_tokenizer

    Lex_Analyzer(String text) {
        input = text
        lexeme = ""
        input_tokenizer = new StringCharacterIterator(text)
        next_char = input_tokenizer.first()
        setCharClass()
    }

    void addChar() {
        lexeme += next_char
    }

    void setNextChar() {
        next_char = input_tokenizer.next()
        setCharClass()
    }

    void setCharClass() {
        if (next_char != "DONE") {
            if (next_char.matches("[a-zA-Z]")) {
                next_char_class = CHAR_CLASS.LETTER
            } else if (next_char.matches("[0-9]")) {
                next_char_class = CHAR_CLASS.DIGIT
            } else {
                next_char_class = CHAR_CLASS.OTHER
            }
        } else {
            next_char_class = CHAR_CLASS.END
        }
    }

    TOKEN_TYPE lex() {
        lexeme = ""

        switch (next_char_class) {
            case CHAR_CLASS.LETTER:
                addChar()
                setNextChar()
                while (next_char_class == CHAR_CLASS.LETTER) {
                    switch (lexeme) {
                        case 's':
                            switch (next_char) {
                                case 'i':
                                    addChar()
                                    setNextChar()
                                    if (next_char == 'n') {
                                        addChar()
                                        setNextChar()
                                        return token = TOKEN_TYPE.SIN
                                    }
                                    break

                                case 'e':
                                    addChar()
                                    setNextChar()
                                    if (next_char == 'c') {
                                        addChar()
                                        setNextChar()
                                        return token = TOKEN_TYPE.SEC
                                    }
                                    break
                            }
                            break

                        case 'c':
                            switch (next_char) {
                                case 'o':
                                    addChar()
                                    setNextChar()
                                    switch (next_char) {
                                        case 's':
                                            addChar()
                                            setNextChar()
                                            return token = TOKEN_TYPE.COS

                                        case 't':
                                            addChar()
                                            setNextChar()
                                            return token = TOKEN_TYPE.COT
                                    }
                                    break

                                case 's':
                                    addChar()
                                    setNextChar()
                                    if (next_char == 'c') {
                                        addChar()
                                        setNextChar()
                                        return token = TOKEN_TYPE.CSC
                                    }
                                    break
                            }
                            break

                        case 't':
                            if (next_char == 'a') {
                                addChar()
                                setNextChar()
                                if (next_char == 'n') {
                                    addChar()
                                    setNextChar()
                                    return token = TOKEN_TYPE.TAN
                                }
                            }
                            break

                        case 'l':
                            if (next_char == 'o') {
                                addChar()
                                setNextChar()
                                if (next_char == 'g') {
                                    addChar()
                                    setNextChar()
                                    return token = TOKEN_TYPE.LOG
                                }
                            }
                            break
                    }
                    error()
                }
                token = TOKEN_TYPE.VAR
                break

            case CHAR_CLASS.DIGIT:
                addChar()
                setNextChar()
                while (next_char_class == CHAR_CLASS.DIGIT) {
                    addChar()
                    setNextChar()
                }
                token = TOKEN_TYPE.NUM
                break

            case CHAR_CLASS.OTHER:
                lookup(next_char.charAt(0))
                setNextChar()
                break

            case CHAR_CLASS.END:
                token = TOKEN_TYPE.END
                lexeme = "END"
                break
        }
//        printf("Next token is: %s, next lexeme is %s%n",token,lexeme)
        return token
    }

    TOKEN_TYPE lookup(char c) {
        lexeme += c;
        switch (c) {
            case '(': token = TOKEN_TYPE.L_PAREN; break
            case ')': token = TOKEN_TYPE.R_PAREN; break
            case '+': token = TOKEN_TYPE.ADD; break
            case '-': token = TOKEN_TYPE.SUB; break
            case '*': token = TOKEN_TYPE.MULT; break
            case '/': token = TOKEN_TYPE.DIV; break
            case '^': token = TOKEN_TYPE.POW; break
            case '|': token = TOKEN_TYPE.OR; break
            case '&': token = TOKEN_TYPE.AND; break
            case '=': token = TOKEN_TYPE.EQ; break
            default: token = TOKEN_TYPE.END; break
        }
        token
    }

    static void error() {
        throw new InputMismatchException("Invalid Syntax for Expression")
    }

}

enum TOKEN_TYPE {
    NUM, VAR,
    ADD, SUB, MULT, DIV, POW,
    SIN, COS, TAN, SEC, CSC, COT, LOG,
    OR, NOR, AND, NAND, EQ, XOR, IMPL,//TODO Implement logical operations
    L_PAREN, R_PAREN,
    END
}

enum CHAR_CLASS {
    LETTER, DIGIT, OTHER, END
}