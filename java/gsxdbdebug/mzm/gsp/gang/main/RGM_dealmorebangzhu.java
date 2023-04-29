/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.GangDutyMembers;
/*    */ 
/*    */ public class RGM_dealmorebangzhu extends mzm.gsp.util.LogicRunnable
/*    */ {
/*    */   private long gangid;
/*    */   private long gmroleid;
/*    */   
/*    */   public RGM_dealmorebangzhu(long gmroleid, long gangid)
/*    */   {
/* 14 */     this.gangid = gangid;
/* 15 */     this.gmroleid = gmroleid;
/*    */   }
/*    */   
/*    */   public void process() throws Exception
/*    */   {
/* 20 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(this.gangid));
/* 21 */     if (xGang == null) {
/* 22 */       String logStr = String.format("PGM_dealmorebangzhu.process@xGang is null |gangid=%d", new Object[] { Long.valueOf(this.gangid) });
/* 23 */       sendMessage(this.gmroleid, logStr.toString());
/* 24 */       return;
/*    */     }
/*    */     
/* 27 */     GangDutyMembers xGangDutyMembers = (GangDutyMembers)xGang.getDuty2members().get(Integer.valueOf(mzm.gsp.gang.confbean.SGangConst.getInstance().BANGZHU_ID));
/* 28 */     if (xGangDutyMembers != null)
/*    */     {
/* 30 */       if (xGangDutyMembers.getMembers().size() > 1) {
/* 31 */         new RRecoverDataMoreBangzhu(this.gangid).run();
/* 32 */         String logStr = String.format("多个帮主的情况处理完毕 |gangid=%d", new Object[] { Long.valueOf(this.gangid) });
/* 33 */         sendMessage(this.gmroleid, logStr.toString());
/*    */       } else {
/* 35 */         String logStr = String.format("不能使用此命令，当前帮派帮主个数 |gangid=%d|bangzhunum=%d", new Object[] { Long.valueOf(this.gangid), Integer.valueOf(xGangDutyMembers.getMembers().size()) });
/* 36 */         sendMessage(this.gmroleid, logStr.toString());
/*    */       }
/*    */     } else {
/* 39 */       String logStr = String.format("PGM_dealmorebangzhu.process@GangDutyMembers BANGZHU_ID is null |gangid=%d", new Object[] { Long.valueOf(this.gangid) });
/* 40 */       sendMessage(this.gmroleid, logStr.toString());
/*    */     }
/*    */   }
/*    */   
/* 44 */   private void sendMessage(long gmroleid, String messageStr) { if (gmroleid == -1L) {
/* 45 */       mzm.gsp.GameServer.logger().info(messageStr);
/*    */     } else {
/* 47 */       GmManager.getInstance().sendResultToGM(gmroleid, messageStr);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\RGM_dealmorebangzhu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */