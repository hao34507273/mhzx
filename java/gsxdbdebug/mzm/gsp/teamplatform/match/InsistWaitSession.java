/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.teamplatform.SWrongTryMatchAgain;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.MatchActivityCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InsistWaitSession
/*    */   extends Session
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public InsistWaitSession(long interval, long roleId)
/*    */   {
/* 21 */     super(interval, roleId);
/* 22 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 28 */     MatchNRTimeTaskManager.getInstance().addTask(new InsistWaitTimeOut());
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
/*    */   public static long beginInsistWaitSession(long roleId, long interval)
/*    */   {
/* 42 */     InsistWaitSession insistWaitSession = new InsistWaitSession(interval, roleId);
/* 43 */     return insistWaitSession.getSessionId();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   class InsistWaitTimeOut
/*    */     extends LogicProcedure
/*    */   {
/*    */     InsistWaitTimeOut() {}
/*    */     
/*    */ 
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 59 */       MatchActivityCfg roleMatchInfo = TeamMatchMananger.getRoleActivity(InsistWaitSession.this.roleId, false);
/* 60 */       if (roleMatchInfo == null)
/*    */       {
/* 62 */         return false;
/*    */       }
/*    */       
/* 65 */       OnlineManager.getInstance().send(InsistWaitSession.this.roleId, new SWrongTryMatchAgain());
/* 66 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\InsistWaitSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */