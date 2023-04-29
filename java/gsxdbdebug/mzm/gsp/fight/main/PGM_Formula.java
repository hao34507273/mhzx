/*    */ package mzm.gsp.fight.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.effect.confbean.SEffectFormula;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_Formula extends LogicProcedure
/*    */ {
/*    */   private long gm_roleid;
/*    */   private int formulaid;
/*    */   private List<String> params;
/*    */   
/*    */   public PGM_Formula(long gm_roleid, int formulaid, List<String> params)
/*    */   {
/* 17 */     this.gm_roleid = gm_roleid;
/* 18 */     this.formulaid = formulaid;
/* 19 */     this.params = params;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 24 */     SEffectFormula effectFormula = SEffectFormula.get(this.formulaid);
/* 25 */     if (effectFormula == null) {
/* 26 */       GmManager.getInstance().sendResultToGM(this.gm_roleid, "效果配置id不存在,formulaid:" + this.formulaid);
/* 27 */       return false;
/*    */     }
/* 29 */     if (effectFormula.params.size() != this.params.size()) {
/* 30 */       GmManager.getInstance().sendResultToGM(this.gm_roleid, "效果配置参数个数和修改的参数个数不一致,配置个数为:" + effectFormula.params.size());
/*    */       
/* 32 */       return false;
/*    */     }
/* 34 */     ArrayList<Double> doubleParams = new ArrayList();
/* 35 */     for (String param : this.params) {
/*    */       try {
/* 37 */         doubleParams.add(Double.valueOf(Double.parseDouble(param)));
/*    */       } catch (Exception e) {
/* 39 */         GmManager.getInstance().sendResultToGM(this.gm_roleid, "传递参数不是数值:" + param);
/* 40 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 44 */     effectFormula.params = doubleParams;
/* 45 */     GmManager.getInstance().sendResultToGM(this.gm_roleid, "操作成功，当前参数为" + this.params.toString());
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\PGM_Formula.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */