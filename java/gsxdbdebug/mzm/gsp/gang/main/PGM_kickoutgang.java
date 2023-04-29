/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.gang.SSyncKickOutMember;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PGM_kickoutgang extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long gangid;
/*    */   private long roleid;
/*    */   private long gmroleid;
/*    */   
/*    */   public PGM_kickoutgang(long gmroleid, long gangid, long roleid)
/*    */   {
/* 16 */     this.gangid = gangid;
/* 17 */     this.roleid = roleid;
/* 18 */     this.gmroleid = gmroleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 24 */     xbean.GangMember xtarget = Role2gangmember.get(Long.valueOf(this.roleid));
/* 25 */     if (xtarget == null) {
/* 26 */       String logStr = String.format("PGM_kickoutgang.process@GangMember is null |gangid=%d|memberId=%d", new Object[] { Long.valueOf(this.gangid), Long.valueOf(this.roleid) });
/* 27 */       sendMessage(this.gmroleid, logStr.toString());
/* 28 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 32 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(this.gangid));
/* 33 */     if (xGang == null) {
/* 34 */       String logStr = String.format("PGM_kickoutgang.process@gang is null |gangid=%d", new Object[] { Long.valueOf(this.gangid) });
/* 35 */       sendMessage(this.gmroleid, logStr.toString());
/* 36 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 40 */     xbean.GangMemoryBean xGangMemory = GangManager.getXGangMemory(this.gangid, true);
/*    */     
/*    */ 
/* 43 */     boolean ret = GangManager.removeMember(this.gangid, xGang, xGangMemory, this.roleid, xtarget, true);
/* 44 */     if (ret) {
/* 45 */       SSyncKickOutMember sSyncKickOutMember = new SSyncKickOutMember();
/* 46 */       sSyncKickOutMember.roleid = this.roleid;
/* 47 */       sSyncKickOutMember.managerid = -1L;
/* 48 */       GangManager.broadcast(xGang, sSyncKickOutMember);
/*    */       
/* 50 */       GangManager.triggerLeaveGangEvent(this.roleid, this.gangid, mzm.gsp.gang.event.LeaveGangArg.LeaveType.KickedOutByGm);
/*    */       
/* 52 */       String logStr = String.format("删除成功 |gangid=%d|memberId=%d", new Object[] { Long.valueOf(this.gangid), Long.valueOf(this.roleid) });
/* 53 */       sendMessage(this.gmroleid, logStr.toString());
/*    */     }
/*    */     
/* 56 */     return true;
/*    */   }
/*    */   
/*    */   private void sendMessage(long gmroleid, String messageStr) {
/* 60 */     if (gmroleid == -1L) {
/* 61 */       GameServer.logger().info(messageStr);
/*    */     } else {
/* 63 */       GmManager.getInstance().sendResultToGM(gmroleid, messageStr);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PGM_kickoutgang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */