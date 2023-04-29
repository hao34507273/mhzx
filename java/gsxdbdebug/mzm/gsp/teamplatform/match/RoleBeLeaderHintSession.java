/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.teamplatform.SBeLeaderToMatch;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.MatchActivityCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RoleBeLeaderHintSession
/*    */   extends Session
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public RoleBeLeaderHintSession(long interval, long roleId)
/*    */   {
/* 21 */     super(interval, roleId);
/* 22 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 28 */     MatchNRTimeTaskManager.getInstance().addTask(new RoleBeLeaderHint());
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
/*    */ 
/*    */   public static long beginRoleBeLeaderHintSession(long interval, long roleId)
/*    */   {
/* 42 */     RoleBeLeaderHintSession roleBeLeaderHintSession = new RoleBeLeaderHintSession(interval, roleId);
/* 43 */     return roleBeLeaderHintSession.getSessionId();
/*    */   }
/*    */   
/*    */   class RoleBeLeaderHint extends LogicProcedure
/*    */   {
/*    */     RoleBeLeaderHint() {}
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 52 */       MatchActivityCfg roleMatchInfo = TeamMatchMananger.getRoleActivity(RoleBeLeaderHintSession.this.roleId, false);
/* 53 */       if (roleMatchInfo == null)
/*    */       {
/* 55 */         return false;
/*    */       }
/* 57 */       OnlineManager.getInstance().send(RoleBeLeaderHintSession.this.roleId, new SBeLeaderToMatch());
/* 58 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\RoleBeLeaderHintSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */