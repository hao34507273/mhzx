/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.Gang;
/*    */ 
/*    */ public class PGM_setbangzhuduty extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long gangid;
/*    */   private long roleid;
/*    */   private long gmroleid;
/*    */   
/*    */   public PGM_setbangzhuduty(long gmroleid, long gangid, long roleid)
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
/* 25 */     Gang xGang = GangManager.getXGang(this.gangid, true);
/*    */     
/* 27 */     if (xMember == null) {
/* 28 */       String logStr = String.format("PGM_setbangzhuduty.process@GangMember is null |gangid=%d|memberId=%d", new Object[] { Long.valueOf(this.gangid), Long.valueOf(this.roleid) });
/* 29 */       sendMessage(this.gmroleid, logStr.toString());
/* 30 */       return false;
/*    */     }
/*    */     
/* 33 */     if (xGang == null) {
/* 34 */       String logStr = String.format("PGM_setbangzhuduty.process@gang is null |gangid=%d", new Object[] { Long.valueOf(this.gangid) });
/* 35 */       sendMessage(this.gmroleid, logStr.toString());
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     if (!GangManager.isInGang(xGang, this.roleid)) {
/* 40 */       String logStr = String.format("PGM_setbangzhuduty.process@GangMember is not in gang |gangid=%d|memberId=%d", new Object[] { Long.valueOf(this.gangid), Long.valueOf(this.roleid) });
/* 41 */       sendMessage(this.gmroleid, logStr.toString());
/* 42 */       return false;
/*    */     }
/*    */     
/* 45 */     boolean isChange = false;
/*    */     
/* 47 */     if (xMember.getDuty() != SGangConst.getInstance().BANGZHU_ID) {
/* 48 */       GangManager.changeDutyRelation(this.roleid, xMember, this.gangid, xGang, SGangConst.getInstance().BANGZHU_ID, -100L, 0);
/* 49 */       isChange = true;
/*    */     }
/*    */     
/* 52 */     if (xGang.getBangzhuid() != this.roleid) {
/* 53 */       xGang.setBangzhuid(this.roleid);
/* 54 */       isChange = true;
/*    */     }
/*    */     
/* 57 */     if (isChange) {
/* 58 */       GangManager.triggerChangeDutyEvent(this.gangid, Long.valueOf(this.roleid));
/*    */     }
/*    */     
/* 61 */     String logStr = String.format("设置帮主成功 |gangid=%d|memberId=%d", new Object[] { Long.valueOf(this.gangid), Long.valueOf(this.roleid) });
/* 62 */     sendMessage(this.gmroleid, logStr.toString());
/*    */     
/* 64 */     return true;
/*    */   }
/*    */   
/*    */   private void sendMessage(long gmroleid, String messageStr) {
/* 68 */     if (gmroleid == -1L) {
/* 69 */       mzm.gsp.GameServer.logger().info(messageStr);
/*    */     } else {
/* 71 */       GmManager.getInstance().sendResultToGM(gmroleid, messageStr);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PGM_setbangzhuduty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */