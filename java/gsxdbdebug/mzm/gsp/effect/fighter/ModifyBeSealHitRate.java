/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyBeSealHitRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int besealhitrate;
/*    */   
/*    */   public ModifyBeSealHitRate(int besealhitrate)
/*    */   {
/* 11 */     this.besealhitrate = besealhitrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addBeSealHitRate(this.besealhitrate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addBeSealHitRate(-this.besealhitrate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyBeSealHitRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */