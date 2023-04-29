/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.fighter.Interface.OpOnce;
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.effect.main.FighterEffectGroup;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ import mzm.gsp.skill.main.Skill;
/*    */ 
/*    */ public class ToSacrifice
/*    */   extends FighterEffect
/*    */   implements OpOnce
/*    */ {
/*    */   public boolean perform(Skill paramSkill, FighterEffectGroup paramFighterEffectGroup, Fighter paramFighter1, Fighter paramFighter2)
/*    */   {
/* 15 */     int i = (int)paramFighter2.getMaxHp() + 1;
/* 16 */     paramFighter2.addHp(-i);
/*    */     
/* 18 */     return true;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter paramFighter)
/*    */   {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter paramFighter)
/*    */   {
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ToSacrifice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */