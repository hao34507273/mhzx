/*    */ package mzm.gsp.marriage.main;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ public class RobMarrageFightContext implements FightContext
/*    */ {
/*    */   public final boolean brideFight;
/*    */   public final long roleid;
/*    */   
/*    */   public RobMarrageFightContext(boolean birdeFight, long roleid) {
/* 11 */     this.brideFight = birdeFight;
/* 12 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   public boolean isRecordEnable()
/*    */   {
/* 17 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\main\RobMarrageFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */