/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ public class DelayLeaveQueueSession extends Session
/*    */ {
/*    */   private final String userid;
/*    */   private final int linkid;
/*    */   
/*    */   public DelayLeaveQueueSession(long interval, String userid, long linksid, int linkid)
/*    */   {
/* 13 */     super(interval, linksid);
/* 14 */     this.userid = userid;
/* 15 */     this.linkid = linkid;
/*    */   }
/*    */   
/*    */   private int getLinkSid() {
/* 19 */     return (int)getOwerId();
/*    */   }
/*    */   
/*    */   protected void onTimeOut()
/*    */   {
/* 24 */     NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicRunnable()
/*    */     {
/*    */       public void process() throws Exception
/*    */       {
/* 28 */         LoginManager.getInstance().leaveQueue(DelayLeaveQueueSession.this.userid, DelayLeaveQueueSession.this.linkid, DelayLeaveQueueSession.this.getLinkSid(), false);
/*    */       }
/*    */     });
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\DelayLeaveQueueSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */