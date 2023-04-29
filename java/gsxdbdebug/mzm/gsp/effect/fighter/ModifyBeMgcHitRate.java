/*    */ package mzm.gsp.effect.fighter;
/*    */ 
/*    */ import mzm.gsp.fight.main.Fighter;
/*    */ 
/*    */ public class ModifyBeMgcHitRate extends mzm.gsp.effect.main.FighterEffect
/*    */ {
/*    */   private int bemaghitrate;
/*    */   
/*    */   public ModifyBeMgcHitRate(int bemaghitrate)
/*    */   {
/* 11 */     this.bemaghitrate = bemaghitrate;
/*    */   }
/*    */   
/*    */   public boolean attach(Fighter fighter)
/*    */   {
/* 16 */     fighter.addBEMAGHITRate(this.bemaghitrate);
/* 17 */     return true;
/*    */   }
/*    */   
/*    */   public boolean detach(Fighter fighter)
/*    */   {
/* 22 */     fighter.addBEMAGHITRate(-this.bemaghitrate);
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\effect\fighter\ModifyBeMgcHitRate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */