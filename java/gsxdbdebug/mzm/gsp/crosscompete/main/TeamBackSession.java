/*    */ package mzm.gsp.crosscompete.main;
/*    */ 
/*    */ import mzm.gsp.crosscompete.team.PDesignTeam;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class TeamBackSession
/*    */   extends Session
/*    */ {
/*    */   TeamBackSession(long seconds, long contextid)
/*    */   {
/* 16 */     super(seconds, contextid);
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 21 */     NoneRealTimeTaskManager.getInstance().addTask(new RTeamBackTimeout(getOwerId()));
/*    */   }
/*    */   
/*    */   static class RTeamBackTimeout extends LogicRunnable
/*    */   {
/*    */     private final long contextid;
/*    */     
/*    */     RTeamBackTimeout(long contextid) {
/* 29 */       this.contextid = contextid;
/*    */     }
/*    */     
/*    */     public void process() throws Exception
/*    */     {
/* 34 */       TeamBackContext context = TeamBackContextManager.getInstance().removeContext(this.contextid);
/* 35 */       if (context == null) {
/* 36 */         return;
/*    */       }
/*    */       
/* 39 */       if (context.isTeamRestore())
/*    */       {
/* 41 */         new PDesignTeam(context.getRoleidList()).call();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\main\TeamBackSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */