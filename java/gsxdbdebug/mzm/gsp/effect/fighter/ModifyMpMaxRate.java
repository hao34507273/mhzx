/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyMpMaxRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int mpmaxrate;
/*    */   
/*    */   public ModifyMpMaxRate(int mpmaxrate)
/*    */   {
/* 11 */     this.mpmaxrate = mpmaxrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addMaxMpRate(this.mpmaxrate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addMaxMpRate(-this.mpmaxrate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyMpMaxRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */