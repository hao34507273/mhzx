/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum CancelMatchType
/*    */ {
/* 12 */   ACTIVE_CANCEL(1), 
/* 13 */   CREATE_TEAM_CANCEL(2), 
/* 14 */   LEAVE_TEAM_CANCEL(3), 
/* 15 */   CHANGE_LEADER_CANCEL(4), 
/* 16 */   LOGOFF_CANCEL(5), 
/* 17 */   LOGIN_CANCEL(6), 
/* 18 */   TEAM_DISSOLVE_CANCEL(7), 
/* 19 */   TIME_OUT_CANCEL(8), 
/*    */   
/* 21 */   JOIN_TEAM_SUC_CANCEL(20), 
/* 22 */   TEAM_FULL_SUC_CANCEL(21);
/*    */   
/*    */ 
/*    */   public final int value;
/*    */   
/*    */   private CancelMatchType(int value)
/*    */   {
/* 29 */     this.value = value;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\CancelMatchType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */