package Léxico;

public class Analisador {
    Entrada ent;
    public Analisador(String arquivo){
        ent = new Entrada(arquivo);
    }

    public Token proximoToken(){
        int caracterLido = -1;
        while((caracterLido = ent.LerProximoCaractere()) != -1){
            char c = (char) caracterLido;
            if(c ==' ' || c == '\n'){
                continue;
            }
            if (c == '*'){
                return new Token(TipoToken.OprAritMult,"*");
            } else if (c == '+'){
                return new Token(TipoToken.OprAritSoma, "+");
            } else if (c == '<'){
                c = (char)ent.LerProximoCaractere();
                if(c == '>'){
                    return new Token(TipoToken.OprRelDif, "<>");
                } else if(c == '='){
                    return new Token(TipoToken.OprRealMenorIgual, "<=");
                } else{
                    return new Token(TipoToken.OprRealMenor,"<");
                }
            } 
        }
        return null;
    }
}
