/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.MatchActivityCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCancelMatch
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PCancelMatch(long roleId)
/*    */   {
/* 19 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     MatchActivityCfg matchData = TeamMatchMananger.getRoleActivity(this.roleId, false);
/* 27 */     if (matchData == null)
/*    */     {
/*    */ 
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     int matchType = matchData.getMatchtype();
/* 34 */     switch (matchType)
/*    */     {
/*    */     case 0: 
/* 37 */       return RoleQueueManager.cancelMatch(this.roleId, CancelMatchType.ACTIVE_CANCEL);
/*    */     case 1: 
/* 39 */       return TeamQueueManager.cancelMatch(this.roleId, CancelMatchType.ACTIVE_CANCEL);
/*    */     }
/*    */     
/* 42 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\PCancelMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */