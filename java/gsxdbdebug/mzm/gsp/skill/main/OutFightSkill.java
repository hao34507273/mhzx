/*    */ package mzm.gsp.skill.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.common.IOutFightObject;
/*    */ import mzm.gsp.effect.main.OutFightEffect;
/*    */ import mzm.gsp.effect.outfight.OutFightEffectInterface;
/*    */ import mzm.gsp.skill.confbean.SOutFightEffectGroup;
/*    */ import mzm.gsp.skill.formula.outfight.FormulaFunction;
/*    */ import mzm.gsp.skill.formula.outfight.FormulaFunctionFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class OutFightSkill
/*    */ {
/*    */   private int level;
/*    */   
/*    */   public abstract List<SOutFightEffectGroup> getEffectGroup();
/*    */   
/*    */   public OutFightSkill(int level)
/*    */   {
/* 27 */     this.level = level;
/*    */   }
/*    */   
/*    */   public int getLevel() {
/* 31 */     return this.level;
/*    */   }
/*    */   
/*    */   public List<OutFightEffect> getEffectList(IOutFightObject outFightObject) {
/* 35 */     List<OutFightEffect> outFightEffectList = new ArrayList();
/* 36 */     for (SOutFightEffectGroup group : getEffectGroup())
/* 37 */       if (OutFightEffectInterface.isOutFightEffect(group.effectId))
/*    */       {
/*    */ 
/* 40 */         List<Integer> paramList = new ArrayList();
/* 41 */         for (Integer funcId : group.formulaList) {
/* 42 */           FormulaFunction function = FormulaFunctionFactory.getFormula(funcId.intValue());
/* 43 */           if (null != function) {
/* 44 */             paramList.add(Integer.valueOf(function.calc(outFightObject, this)));
/*    */           }
/*    */         }
/* 47 */         OutFightEffect effect = OutFightEffectInterface.createOutFightEffect(group.effectId, paramList);
/* 48 */         outFightEffectList.add(effect);
/*    */       }
/* 50 */     return outFightEffectList;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\main\OutFightSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */