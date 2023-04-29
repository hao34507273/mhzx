/*    */ package mzm.gsp.ladder.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeRunnable;
/*    */ 
/*    */ public class ROnOpenChange
/*    */   extends OpenChangeRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 12 */     if (!LadderManager.postInitFlag)
/*    */     {
/* 14 */       return;
/*    */     }
/* 16 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 18 */       return;
/*    */     }
/* 20 */     if ((((OpenChangeComplexArg)this.arg).getType() != 188) || (!((OpenChangeComplexArg)this.arg).isOpen()))
/*    */     {
/* 22 */       return;
/*    */     }
/* 24 */     LadderRankManager.getInstance().checkAndGetRemoteRank();
/* 25 */     LadderRankManager.getInstance().checkAndSendAward();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\main\ROnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */