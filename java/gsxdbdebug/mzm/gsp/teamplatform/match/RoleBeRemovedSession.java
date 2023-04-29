/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.MatchActivityCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleBeRemovedSession
/*    */   extends Session
/*    */ {
/*    */   private final long roleId;
/*    */   private final int matchType;
/*    */   
/*    */   public RoleBeRemovedSession(long interval, long roleId, int matchType)
/*    */   {
/* 20 */     super(interval, roleId);
/* 21 */     this.roleId = roleId;
/* 22 */     this.matchType = matchType;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 28 */     MatchNRTimeTaskManager.getInstance().addTask(new RoleBeRemovedTimeOut());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static long beginRoleBeRemovedSession(long interval, long roleId, int matchType)
/*    */   {
/* 41 */     RoleBeRemovedSession removedSession = new RoleBeRemovedSession(interval, roleId, matchType);
/* 42 */     return removedSession.getSessionId();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   class RoleBeRemovedTimeOut
/*    */     extends LogicProcedure
/*    */   {
/*    */     RoleBeRemovedTimeOut() {}
/*    */     
/*    */ 
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 57 */       MatchActivityCfg roleMatchInfo = TeamMatchMananger.getRoleActivity(RoleBeRemovedSession.this.roleId, false);
/* 58 */       if (roleMatchInfo == null)
/*    */       {
/* 60 */         return false;
/*    */       }
/* 62 */       switch (RoleBeRemovedSession.this.matchType)
/*    */       {
/*    */       case 0: 
/* 65 */         return RoleQueueManager.cancelMatch(RoleBeRemovedSession.this.roleId, CancelMatchType.TIME_OUT_CANCEL);
/*    */       case 1: 
/* 67 */         return TeamQueueManager.cancelMatch(RoleBeRemovedSession.this.roleId, CancelMatchType.TIME_OUT_CANCEL);
/*    */       }
/* 69 */       return false;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\RoleBeRemovedSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */