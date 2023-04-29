/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ 
/*    */ public class RGM_clearunrealgangmember extends mzm.gsp.util.LogicRunnable
/*    */ {
/*    */   private long gangid;
/*    */   private long gmroleid;
/*    */   
/*    */   public RGM_clearunrealgangmember(long gmroleid, long gangid)
/*    */   {
/* 13 */     this.gangid = gangid;
/* 14 */     this.gmroleid = gmroleid;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 20 */     new RDeleteMemberNotInGang(this.gangid).run();
/*    */     
/* 22 */     String logStr = String.format("清理不在帮派里的成员处理完毕 |gangid=%d", new Object[] { Long.valueOf(this.gangid) });
/* 23 */     sendMessage(this.gmroleid, logStr.toString());
/*    */   }
/*    */   
/*    */   private void sendMessage(long gmroleid, String messageStr) {
/* 27 */     if (gmroleid == -1L) {
/* 28 */       GameServer.logger().info(messageStr);
/*    */     } else {
/* 30 */       GmManager.getInstance().sendResultToGM(gmroleid, messageStr);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\RGM_clearunrealgangmember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */