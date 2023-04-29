/*    */ package mzm.gsp.effect.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.effect.formula.fighter.EffectFormula;
/*    */ import mzm.gsp.effect.formula.fighter.EffectFormulaFactory;
/*    */ import mzm.gsp.skill.main.SkillInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EffectInterface
/*    */ {
/*    */   public static FighterEffect getFighterEffectInstance(int id, List<Integer> params)
/*    */   {
/* 28 */     return FighterEffectConfigManager.getInstance().getFighterEffectInstance(id, params);
/*    */   }
/*    */   
/*    */   public static List<FighterEffect> getAllOutFighterEffects(long roleid) {
/* 32 */     List<FighterEffect> fighterEffects = new ArrayList();
/*    */     
/* 34 */     return fighterEffects;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static FighterEffectGroup getEffectGroup(int effectGroupID)
/*    */   {
/* 44 */     if (SkillInterface.getEffectGroupCfg(effectGroupID) == null) {
/* 45 */       return null;
/*    */     }
/* 47 */     return new FighterEffectGroup(SkillInterface.getEffectGroupCfg(effectGroupID));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static EffectFormula getFighterEffectFormula(int formulaid)
/*    */   {
/* 57 */     return EffectFormulaFactory.getFormula(formulaid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\main\EffectInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */