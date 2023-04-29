/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifySealHitRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int sealhitrate;
/*    */   
/*    */   public ModifySealHitRate(int sealhitrate)
/*    */   {
/* 11 */     this.sealhitrate = sealhitrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addSealHitRate(this.sealhitrate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addSealHitRate(-this.sealhitrate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifySealHitRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */