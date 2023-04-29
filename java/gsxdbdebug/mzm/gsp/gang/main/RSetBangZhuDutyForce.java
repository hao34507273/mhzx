/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Gang;
/*    */ import xbean.GangDutyMembers;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ class RSetBangZhuDutyForce extends LogicRunnable
/*    */ {
/*    */   private final long gangId;
/*    */   
/*    */   RSetBangZhuDutyForce(long gangId)
/*    */   {
/* 20 */     this.gangId = gangId;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 26 */     Gang xGang = GangManager.getXGang(this.gangId, false);
/* 27 */     if (xGang == null) {
/* 28 */       String logStr = String.format("RSetBangZhuDutyForce.process@Gang is null |gangid=%d", new Object[] { Long.valueOf(this.gangId) });
/* 29 */       GangManager.logger.error(logStr);
/*    */     }
/* 31 */     Set<Long> gangMemberSet = GangManager.getMembers(xGang);
/*    */     
/*    */ 
/* 34 */     GangDutyMembers xGangDutyMembers = (GangDutyMembers)xGang.getDuty2members().get(Integer.valueOf(SGangConst.getInstance().BANGZHU_ID));
/*    */     
/* 36 */     Iterator<Long> iter = xGangDutyMembers.getMembers().iterator();
/* 37 */     long bangzhuid = ((Long)iter.next()).longValue();
/* 38 */     new PSetMemberDutyToBangZhuForce(this.gangId, bangzhuid).call();
/*    */     
/*    */ 
/*    */ 
/* 42 */     for (Iterator i$ = gangMemberSet.iterator(); i$.hasNext();) { long memberId = ((Long)i$.next()).longValue();
/* 43 */       if (memberId != bangzhuid) {
/* 44 */         GangMember xGangMember = Role2gangmember.select(Long.valueOf(memberId));
/* 45 */         if (xGangMember == null) {
/* 46 */           String logStr = String.format("RSetBangZhuDutyForce.process@GangMember is null |gangid=%d|memberId=%d", new Object[] { Long.valueOf(this.gangId), Long.valueOf(memberId) });
/* 47 */           GangManager.logger.error(logStr);
/*    */ 
/*    */         }
/* 50 */         else if (xGangMember.getDuty() == SGangConst.getInstance().BANGZHU_ID) {
/* 51 */           new PSetMemberDutyToBangZhongForce(this.gangId, memberId).call();
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\RSetBangZhuDutyForce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */