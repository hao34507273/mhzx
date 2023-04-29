/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyBePhyAtkHitRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int bephyhitrate;
/*    */   
/*    */   public ModifyBePhyAtkHitRate(int bephyhitrate)
/*    */   {
/* 11 */     this.bephyhitrate = bephyhitrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addBEPHYATKHITRate(this.bephyhitrate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addBEPHYATKHITRate(-this.bephyhitrate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyBePhyAtkHitRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */