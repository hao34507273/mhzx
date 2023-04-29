/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Gang;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ 
/*    */ public class PSetMemberDutyToBangZhuForce
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gangId;
/*    */   private final long roleId;
/*    */   
/*    */   PSetMemberDutyToBangZhuForce(long gangId, long roleId)
/*    */   {
/* 19 */     this.gangId = gangId;
/* 20 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     GangMember xMember = Role2gangmember.get(Long.valueOf(this.roleId));
/*    */     
/* 28 */     Gang xGang = GangManager.getXGang(this.gangId, true);
/*    */     
/* 30 */     if (xMember == null) {
/* 31 */       String logStr = String.format("PSetMemberDutyToBangZhu.process@GangMember is null |gangid=%d|memberId=%d", new Object[] { Long.valueOf(this.gangId), Long.valueOf(this.roleId) });
/* 32 */       GangManager.logger.error(logStr);
/* 33 */       return false;
/*    */     }
/*    */     
/* 36 */     if (xGang == null) {
/* 37 */       String logStr = String.format("PSetMemberDutyToBangZhu.process@gang is null |gangid=%d", new Object[] { Long.valueOf(this.gangId) });
/* 38 */       GangManager.logger.error(logStr);
/* 39 */       return false;
/*    */     }
/*    */     
/* 42 */     if (!GangManager.isInGang(xGang, this.roleId)) {
/* 43 */       String logStr = String.format("PSetMemberDutyToBangZhu.process@GangMember is not in gang |gangid=%d|memberId=%d", new Object[] { Long.valueOf(this.gangId), Long.valueOf(this.roleId) });
/* 44 */       GangManager.logger.error(logStr);
/* 45 */       return false;
/*    */     }
/*    */     
/* 48 */     boolean isChange = false;
/*    */     
/* 50 */     if (xMember.getDuty() != SGangConst.getInstance().BANGZHU_ID) {
/* 51 */       GangManager.changeDutyRelation(this.roleId, xMember, this.gangId, xGang, SGangConst.getInstance().BANGZHU_ID, -100L, 0);
/* 52 */       isChange = true;
/*    */     }
/*    */     
/* 55 */     if (xGang.getBangzhuid() != this.roleId) {
/* 56 */       xGang.setBangzhuid(this.roleId);
/* 57 */       isChange = true;
/*    */     }
/*    */     
/* 60 */     if (isChange) {
/* 61 */       GangManager.triggerChangeDutyEvent(this.gangId, Long.valueOf(this.roleId));
/*    */     }
/*    */     
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PSetMemberDutyToBangZhuForce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */