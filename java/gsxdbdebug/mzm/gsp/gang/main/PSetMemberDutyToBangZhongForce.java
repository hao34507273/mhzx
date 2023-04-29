/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Gang;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PSetMemberDutyToBangZhongForce
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gangId;
/*    */   private final long roleId;
/*    */   
/*    */   PSetMemberDutyToBangZhongForce(long gangId, long roleId)
/*    */   {
/* 18 */     this.gangId = gangId;
/* 19 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     GangMember xMember = Role2gangmember.get(Long.valueOf(this.roleId));
/*    */     
/* 27 */     Gang xGang = GangManager.getXGang(this.gangId, true);
/*    */     
/* 29 */     if (xMember == null) {
/* 30 */       String logStr = String.format("PSetMemberDutyToBangZhong.process@GangMember is null |gangid=%d|memberId=%d", new Object[] { Long.valueOf(this.gangId), Long.valueOf(this.roleId) });
/* 31 */       GangManager.logger.error(logStr);
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     if (xGang == null) {
/* 36 */       String logStr = String.format("PSetMemberDutyToBangZhong.process@gang is null |gangid=%d", new Object[] { Long.valueOf(this.gangId) });
/* 37 */       GangManager.logger.error(logStr);
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     if (!GangManager.isInGang(xGang, this.roleId)) {
/* 42 */       String logStr = String.format("PSetMemberDutyToBangZhong.process@GangMember is not in gang |gangid=%d|memberId=%d", new Object[] { Long.valueOf(this.gangId), Long.valueOf(this.roleId) });
/* 43 */       GangManager.logger.error(logStr);
/* 44 */       return false;
/*    */     }
/*    */     
/* 47 */     GangManager.changeDutyRelation(this.roleId, xMember, this.gangId, xGang, SGangConst.getInstance().BANGZHONG_ID, -100L, 0);
/* 48 */     GangManager.triggerChangeDutyEvent(this.gangId, Long.valueOf(this.roleId));
/*    */     
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PSetMemberDutyToBangZhongForce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */