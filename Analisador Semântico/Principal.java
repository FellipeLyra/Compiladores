package Semantico;

import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) throws IOException{
        String caminho ="";
        JFileChooser fc = new JFileChooser();
        int retorno = fc.showOpenDialog(null);
        if(retorno == JFileChooser.APPROVE_OPTION){
            caminho = fc.getSelectedFile().getAbsolutePath();
            System.out.println(caminho);
        }
        CharStream cs = CharStreams.fromFileName(caminho);
        bccLexer bl = new bccLexer(cs);

        Token t = null;
        while((t = bl.nextToken()).getType() != Token.EOF){
            System.out.println("<" + bccLexer.VOCABULARY.getDisplayName(t.getType())+t.getText()+">");
        };

        CommonTokenStream tokens = new CommonTokenStream(bl);

        bccParser parser = new bccParser(tokens);
        bccParser.ProgramContext arvore = parser.programa();
        Calculadora c = new Calculadora();
        double val = c.visitProgram(arvore);
        JOptionPane.showMessageDialog(null, "Resposta"+val);
    }
}
