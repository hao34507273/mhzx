/*    */ package mzm.gsp.alllotto.event;
/*    */ 
/*    */ public class RoleGetALLLottoAwardArg
/*    */ {
/*    */   private final int activityCfgid;
/*    */   private final int turn;
/*    */   private final long roleid;
/*    */   
/*    */   public RoleGetALLLottoAwardArg(int activityCfgid, int turn, long roleid)
/*    */   {
/* 11 */     this.activityCfgid = activityCfgid;
/* 12 */     this.turn = turn;
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   public int getActivityCfgid()
/*    */   {
/* 18 */     return this.activityCfgid;
/*    */   }
/*    */   
/*    */   public int getTurn()
/*    */   {
/* 23 */     return this.turn;
/*    */   }
/*    */   
/*    */   public long getRoleid()
/*    */   {
/* 28 */     return this.roleid;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\event\RoleGetALLLottoAwardArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */