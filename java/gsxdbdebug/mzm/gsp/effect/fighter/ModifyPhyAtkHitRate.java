/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyPhyAtkHitRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int phyhitrate;
/*    */   
/*    */   public ModifyPhyAtkHitRate(int phyhitrate)
/*    */   {
/* 11 */     this.phyhitrate = phyhitrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addPHYATKHITRate(this.phyhitrate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addPHYATKHITRate(-this.phyhitrate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyPhyAtkHitRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */