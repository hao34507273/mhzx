/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Gang;
/*    */ import xbean.GangMember;
/*    */ 
/*    */ public class PDeleteMemberNotInGang extends LogicProcedure
/*    */ {
/*    */   private final long gangId;
/*    */   private final long roleId;
/*    */   
/*    */   PDeleteMemberNotInGang(long gangId, long roleId)
/*    */   {
/* 15 */     this.gangId = gangId;
/* 16 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     GangMember xMember = xtable.Role2gangmember.get(Long.valueOf(this.roleId));
/*    */     
/* 24 */     Gang xGang = GangManager.getXGang(this.gangId, true);
/*    */     
/* 26 */     if (xMember == null) {
/* 27 */       String logStr = String.format("PDeleteMemberNotInGang.process@GangMember is null |gangid=%d|memberId=%d", new Object[] { Long.valueOf(this.gangId), Long.valueOf(this.roleId) });
/* 28 */       GangManager.logger.error(logStr);
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     if (xGang == null) {
/* 33 */       String logStr = String.format("PDeleteMemberNotInGang.process@gang is null |gangid=%d", new Object[] { Long.valueOf(this.gangId) });
/* 34 */       GangManager.logger.error(logStr);
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     xbean.GangMemoryBean xGangMemory = GangManager.getXGangMemory(this.gangId, true);
/*    */     
/*    */ 
/* 41 */     boolean ret = GangManager.removeMember(this.gangId, xGang, xGangMemory, this.roleId, xMember, true);
/* 42 */     if (ret)
/*    */     {
/* 44 */       GangManager.triggerChangeDutyEvent(xMember.getGangid(), Long.valueOf(this.roleId));
/*    */     }
/*    */     
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PDeleteMemberNotInGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */