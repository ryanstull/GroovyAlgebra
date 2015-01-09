package groovyAlg.parser

import groovyAlg.*

class Parser {
    Lex_Analyzer lexer;

    Parser(String formula){
        lexer = new Lex_Analyzer(formula)
    }

    static MathObject parse(String formula){
        Parser p = new Parser(formula)
        p.lexer.lex()
        return p.ex1().simplify()
    }

    MathObject ex1(){
        MathObject f1,f2

        f1 = ex2()

        if(lexer.token == TOKEN_TYPE.ADD_OP){
            lexer.lex()
            f2 = ex1()
            return new Add('f1':f1,'f2':f2)
        }else if(lexer.token == TOKEN_TYPE.SUB_OP){
            lexer.lex()
            f2 = ex1()
            return new Subtract('f1':f1,'f2':f2)
        }

        return f1
    }

    MathObject ex2(){
        MathObject f1,f2

        f1 = ex3()

        if(lexer.token == TOKEN_TYPE.MULT_OP){
            lexer.lex()
            f2 = ex2()
            return new Multiply('f1':f1,'f2':f2)
        }else if(lexer.token == TOKEN_TYPE.DIV_OP){
            lexer.lex()
            f2 = ex2()
            return new Divide('f1':f1,'f2':f2)
        }

        return f1
    }

    MathObject ex3(){
        MathObject f1,f2

        f1 = ex4()

        if(lexer.token == TOKEN_TYPE.POW_OP){
            lexer.lex()
            f2 = ex3()
            return new Exponent('f1':f1,'f2':f2)
        }

        return f1
    }

    MathObject ex4(){
        MathObject f1,f2

        switch (lexer.token){
            case TOKEN_TYPE.NUM:
                f1 = new Num(lexer.lexeme)
                lexer.lex()
                break

            case TOKEN_TYPE.VAR:
                f1 = new Var()
                lexer.lex()
                break

            case [TOKEN_TYPE.SIN,TOKEN_TYPE.COS,TOKEN_TYPE.TAN,TOKEN_TYPE.CSC,TOKEN_TYPE.SEC,TOKEN_TYPE.COT,TOKEN_TYPE.LOG,'inlist']:
                Closure constructor;
                switch (lexer.token){
                    case TOKEN_TYPE.SIN:
                        constructor = Sin.metaClass.&invokeConstructor
                        break
                    case TOKEN_TYPE.COS:
                        constructor = Cos.metaClass.&invokeConstructor
                        break

                    case TOKEN_TYPE.TAN:
                        constructor = Tan.metaClass.&invokeConstructor
                        break

                    case TOKEN_TYPE.CSC:
                        constructor = Csc.metaClass.&invokeConstructor
                        break

                    case TOKEN_TYPE.SEC:
                        constructor = Sec.metaClass.&invokeConstructor
                        break

                    case TOKEN_TYPE.COT:
                        constructor = Cot.metaClass.&invokeConstructor
                        break

                    default:
                        Lex_Analyzer.error()
                }

                lexer.lex()
                if(lexer.token==TOKEN_TYPE.L_PAREN){
                    lexer.lex()
                    f2 = ex1()
                    f1 = constructor('f1':f2)
                    if(lexer.token == TOKEN_TYPE.R_PAREN){
                        lexer.lex()
                    }else{
                        Lex_Analyzer.error()
                    }
                }else{
                    Lex_Analyzer.error()
                }

                break
        }

        return f1
    }
}