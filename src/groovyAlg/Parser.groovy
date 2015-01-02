package groovyAlg

class Parser {
    String lex;

    static MathObject parse(String formula){

    }

    Parser(){
        lex = "";
    }

    int lex(){

    }

}

enum LEX_TYPE{
    NUM,VAR,
    ADD_OP,SUB_OP,MULT_OP,DIV_OP,POW_OP,
    SIN,COS,TAN,SEC,CSC,COT,
    L_PAREN,R_PAREN
}