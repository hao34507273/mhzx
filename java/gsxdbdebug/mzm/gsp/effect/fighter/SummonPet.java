/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.fighter.Interface.OpOnce;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.main.ExcuteCmdResult;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class SummonPet
/*    */   extends FighterEffect
/*    */   implements OpOnce
/*    */ {
/*    */   public boolean perform(Skill paramSkill, FighterEffectGroup paramFighterEffectGroup, Fighter paramFighter1, Fighter paramFighter2)
/*    */   {
/* 16 */     ExcuteCmdResult localExcuteCmdResult = new ExcuteCmdResult();
/* 17 */     paramFighter1.summonPetAtAfter(localExcuteCmdResult);
/* 18 */     paramFighter1.addCmdResult(localExcuteCmdResult);
/*    */     
/* 20 */     return true;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter paramFighter)
/*    */   {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter paramFighter)
/*    */   {
/* 30 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\SummonPet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */