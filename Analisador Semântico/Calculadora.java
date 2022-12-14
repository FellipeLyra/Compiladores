package Semantico;

public class Calculadora extends bccBaseVisitor<Double>{
    @Override
    public Double visitProgram(bccParser.ProgramaContext ctx){
        return visistExpressao(ctx.expressao());
    }
    @Override
    public Double visitExpressao(bcc.Parser.ExpressaoContext ctx){
        double valor = visitTermo(ctx.termo1);
        for(int i=0; i<ctx.outrosTermos.size(); i++){
            bccParser.Op1Context op1 = ctx.op1(i);
            bccParser.TermoContext ot = ctx.outrosTermos.get(i);
            String strOp1 = op1.getText();
            if(strOp1.equals("+")){
                valor += visitTermo(ot);
            } else{
                valor -= visitTermo(ot);
            }
        }
        return valor;
    }
    @Override
    public Double visitFator(bccParser.FatorContext ctx){
        if(ctx.NUM() != null){
            return Double.parseDouble(ctx.NUM().getText());
        } else{
            return visit(ctx.expressao());
        }
    }
}
