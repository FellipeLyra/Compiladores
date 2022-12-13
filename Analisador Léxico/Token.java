package Léxico;

public class Token {
    public TipoToken nome;
    public String lexema;

    public Token(TipoToken nome, String lexema){
        super();
        this.nome = nome;
        this.lexema =lexema;
    }

    public String toString(){
        return "<" + nome + "," + lexema + ">";
    }
}
