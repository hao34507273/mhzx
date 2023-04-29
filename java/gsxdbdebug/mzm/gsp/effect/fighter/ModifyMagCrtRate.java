/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyMagCrtRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int magcrtrate;
/*    */   
/*    */   public ModifyMagCrtRate(int magcrtrate)
/*    */   {
/* 11 */     this.magcrtrate = magcrtrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addMAGCRTRate(this.magcrtrate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addMAGCRTRate(-this.magcrtrate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyMagCrtRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */