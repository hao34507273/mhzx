/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.GangDutyMembers;
/*    */ 
/*    */ public class RGM_dealnonebangzhu extends mzm.gsp.util.LogicRunnable
/*    */ {
/*    */   private long gangid;
/*    */   private long gmroleid;
/*    */   
/*    */   public RGM_dealnonebangzhu(long gmroleid, long gangid)
/*    */   {
/* 14 */     this.gangid = gangid;
/* 15 */     this.gmroleid = gmroleid;
/*    */   }
/*    */   
/*    */   public void process() throws Exception
/*    */   {
/* 20 */     xbean.Gang xGang = xtable.Gang.select(Long.valueOf(this.gangid));
/* 21 */     if (xGang == null) {
/* 22 */       String logStr = String.format("PGM_dealnonebangzhu.process@xGang is null |gangid=%d", new Object[] { Long.valueOf(this.gangid) });
/* 23 */       sendMessage(this.gmroleid, logStr.toString());
/* 24 */       return;
/*    */     }
/*    */     
/* 27 */     GangDutyMembers xGangDutyMembers = (GangDutyMembers)xGang.getDuty2members().get(Integer.valueOf(mzm.gsp.gang.confbean.SGangConst.getInstance().BANGZHU_ID));
/* 28 */     if (xGangDutyMembers != null)
/*    */     {
/* 30 */       if (xGangDutyMembers.getMembers().size() > 1) {
/* 31 */         String logStr = String.format("不能使用此命令，当前帮派帮主个数 |gangid=%d|bangzhunum=%d", new Object[] { Long.valueOf(this.gangid), Integer.valueOf(xGangDutyMembers.getMembers().size()) });
/* 32 */         sendMessage(this.gmroleid, logStr.toString());
/* 33 */         return;
/*    */       }
/* 35 */       new RCheckOneBangZhuAndRecoverError(this.gangid).run();
/* 36 */       String logStr = String.format("没帮主的情况处理完毕 |gangid=%d", new Object[] { Long.valueOf(this.gangid) });
/* 37 */       sendMessage(this.gmroleid, logStr.toString());
/*    */     } else {
/* 39 */       String logStr = String.format("PGM_dealnonebangzhu.process@GangDutyMembers BANGZHU_ID is null |gangid=%d", new Object[] { Long.valueOf(this.gangid) });
/* 40 */       sendMessage(this.gmroleid, logStr.toString());
/*    */     }
/*    */   }
/*    */   
/*    */   private void sendMessage(long gmroleid, String messageStr)
/*    */   {
/* 46 */     if (gmroleid == -1L) {
/* 47 */       mzm.gsp.GameServer.logger().info(messageStr);
/*    */     } else {
/* 49 */       GmManager.getInstance().sendResultToGM(gmroleid, messageStr);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\RGM_dealnonebangzhu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */