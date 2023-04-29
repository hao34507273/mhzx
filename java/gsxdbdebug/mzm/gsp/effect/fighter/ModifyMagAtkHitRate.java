/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyMagAtkHitRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int mgchitrate;
/*    */   
/*    */   public ModifyMagAtkHitRate(int mgchitrate)
/*    */   {
/* 11 */     this.mgchitrate = mgchitrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addMAGHITRate(this.mgchitrate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addMAGHITRate(-this.mgchitrate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyMagAtkHitRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */