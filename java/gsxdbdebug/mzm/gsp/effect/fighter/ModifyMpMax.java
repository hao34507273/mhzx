/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyMpMax extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int mpmax;
/*    */   
/*    */   public ModifyMpMax(int mpmax)
/*    */   {
/* 11 */     this.mpmax = mpmax;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addMaxMp(this.mpmax);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addMaxMp(-this.mpmax);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyMpMax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */