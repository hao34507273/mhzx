/*    */ package mzm.gsp.chat.question;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ import mzm.gsp.timer.main.DateObserver;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class RefreshObserve
/*    */   extends DateObserver
/*    */ {
/*    */   private final int timeCommonCfgId;
/*    */   
/*    */   public RefreshObserve(int timeCommonCfgId)
/*    */   {
/* 17 */     super(timeCommonCfgId);
/* 18 */     this.timeCommonCfgId = timeCommonCfgId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean onTimeOut()
/*    */   {
/* 24 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 26 */       return false;
/*    */     }
/* 28 */     if (!ActivityInterface.isActivityOpen(WorldQuestion.getInstance().getActivityId()))
/*    */     {
/* 30 */       GameServer.logger().error(String.format("[wordlQuestion]RefreshObserve.onTimeOut@ world question activity not open yet!|timeCommonCfgId=%d", new Object[] { Integer.valueOf(this.timeCommonCfgId) }));
/*    */       
/*    */ 
/*    */ 
/* 34 */       return false;
/*    */     }
/* 36 */     if (!OpenInterface.getOpenStatus(51))
/*    */     {
/* 38 */       GameServer.logger().info(String.format("[wordlQuestion]RefreshObserve.onTimeOut@ wordlQuestion ban!", new Object[0]));
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     new PSetNewQuestionNoticTime().execute();
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\question\RefreshObserve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */