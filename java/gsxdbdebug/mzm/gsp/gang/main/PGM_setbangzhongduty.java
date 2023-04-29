/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ 
/*    */ public class PGM_setbangzhongduty extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long gangid;
/*    */   private long roleid;
/*    */   private long gmroleid;
/*    */   
/*    */   public PGM_setbangzhongduty(long gmroleid, long gangid, long roleid)
/*    */   {
/* 15 */     this.gmroleid = gmroleid;
/* 16 */     this.gangid = gangid;
/* 17 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     xbean.GangMember xMember = xtable.Role2gangmember.get(Long.valueOf(this.roleid));
/*    */     
/* 25 */     xbean.Gang xGang = GangManager.getXGang(this.gangid, true);
/*    */     
/* 27 */     if (xMember == null) {
/* 28 */       String logStr = String.format("PSetMemberDutyToBangZhong.process@GangMember is null |gangid=%d|memberId=%d", new Object[] { Long.valueOf(this.gangid), Long.valueOf(this.roleid) });
/* 29 */       sendMessage(this.gmroleid, logStr.toString());
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     if (xGang == null) {
/* 34 */       String logStr = String.format("PSetMemberDutyToBangZhong.process@gang is null |gangid=%d", new Object[] { Long.valueOf(this.gangid) });
/* 35 */       sendMessage(this.gmroleid, logStr.toString());
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     if (!GangManager.isInGang(xGang, this.roleid)) {
/* 40 */       String logStr = String.format("PSetMemberDutyToBangZhong.process@GangMember is not in gang |gangid=%d|memberId=%d", new Object[] { Long.valueOf(this.gangid), Long.valueOf(this.roleid) });
/* 41 */       sendMessage(this.gmroleid, logStr.toString());
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     GangManager.changeDutyRelation(this.roleid, xMember, this.gangid, xGang, SGangConst.getInstance().BANGZHONG_ID, -100L, 0);
/* 46 */     GangManager.triggerChangeDutyEvent(this.gangid, Long.valueOf(this.roleid));
/*    */     
/* 48 */     String logStr = String.format("设置帮众成功 |gangid=%d|memberId=%d", new Object[] { Long.valueOf(this.gangid), Long.valueOf(this.roleid) });
/* 49 */     sendMessage(this.gmroleid, logStr.toString());
/* 50 */     return true;
/*    */   }
/*    */   
/* 53 */   private void sendMessage(long gmroleid, String messageStr) { if (gmroleid == -1L) {
/* 54 */       GameServer.logger().info(messageStr);
/*    */     } else {
/* 56 */       GmManager.getInstance().sendResultToGM(gmroleid, messageStr);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PGM_setbangzhongduty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */