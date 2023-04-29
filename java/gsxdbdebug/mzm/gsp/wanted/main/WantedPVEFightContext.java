/*    */ package mzm.gsp.wanted.main;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WantedPVEFightContext
/*    */   implements FightContext
/*    */ {
/*    */   final long wantedRoleId;
/*    */   final int fightId;
/*    */   
/*    */   public WantedPVEFightContext(long wantedRoleId, int fightId)
/*    */   {
/* 15 */     this.wantedRoleId = wantedRoleId;
/* 16 */     this.fightId = fightId;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isRecordEnable()
/*    */   {
/* 22 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\WantedPVEFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */