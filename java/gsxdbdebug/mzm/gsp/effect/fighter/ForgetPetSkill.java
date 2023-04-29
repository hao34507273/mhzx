/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.effect.main.FighterEffect;
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ForgetPetSkill
/*    */   extends FighterEffect
/*    */ {
/*    */   public boolean attach(Fighter paramFighter)
/*    */   {
/* 11 */     paramFighter.addBuffState(1002);
/* 12 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter paramFighter)
/*    */   {
/* 17 */     paramFighter.remBuffState(1002);
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ForgetPetSkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */