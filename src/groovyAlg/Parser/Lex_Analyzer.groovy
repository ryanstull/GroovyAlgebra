package groovyAlg.Parser

import java.text.CharacterIterator
import java.text.StringCharacterIterator

class Lex_Analyzer {
    private String input
    private String lexeme
    private CharacterIterator inputTokenizer

    Lex_Analyzer(String text){
        input = ""
        lexeme = ""
        inputTokenizer = new StringCharacterIterator(text)
    }

    void addChar(){
        lexeme+=inputTokenizer.next();
    }

    LEX_TYPE lex(){

    }

    LEX_TYPE lookup(char c){
        lexeme+=c;
        switch (c){
            case '(': return LEX_TYPE.L_PAREN
            case ')': return LEX_TYPE.R_PAREN
            case '+': return LEX_TYPE.ADD_OP
            case '-': return LEX_TYPE.SUB_OP
            case '*': return LEX_TYPE.MULT_OP
            case '/': return LEX_TYPE.DIV_OP
            case '^': return LEX_TYPE.POW_OP
            default: return LEX_TYPE.EOF
        }
    }
}

enum LEX_TYPE{
    NUM,VAR,
    ADD_OP,SUB_OP,MULT_OP,DIV_OP,POW_OP,
    SIN,COS,TAN,SEC,CSC,COT,
    L_PAREN,R_PAREN,
    EOF
}