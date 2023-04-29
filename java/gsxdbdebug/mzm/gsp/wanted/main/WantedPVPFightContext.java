/*    */ package mzm.gsp.wanted.main;
/*    */ 
/*    */ import mzm.gsp.fight.main.FightContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WantedPVPFightContext
/*    */   implements FightContext
/*    */ {
/*    */   final long wantedRoleId;
/*    */   
/*    */   public WantedPVPFightContext(long wantedRoleId)
/*    */   {
/* 14 */     this.wantedRoleId = wantedRoleId;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isRecordEnable()
/*    */   {
/* 20 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wanted\main\WantedPVPFightContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */