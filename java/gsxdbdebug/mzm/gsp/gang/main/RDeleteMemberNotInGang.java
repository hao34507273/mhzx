/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Gang;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ class RDeleteMemberNotInGang extends LogicRunnable
/*    */ {
/*    */   private final long gangId;
/*    */   
/*    */   RDeleteMemberNotInGang(long gangId)
/*    */   {
/* 17 */     this.gangId = gangId;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 23 */     Gang xGang = GangManager.getXGang(this.gangId, false);
/* 24 */     if (xGang == null) {
/* 25 */       String logStr = String.format("RDeleteMemberNotInGang.process@Gang is null |gangid=%d", new Object[] { Long.valueOf(this.gangId) });
/* 26 */       GangManager.logger.error(logStr);
/*    */     }
/* 28 */     Set<Long> gangMemberSet = GangManager.getMembers(xGang);
/*    */     
/*    */ 
/* 31 */     for (Iterator i$ = gangMemberSet.iterator(); i$.hasNext();) { long memberId = ((Long)i$.next()).longValue();
/*    */       
/* 33 */       GangMember xMember = Role2gangmember.select(Long.valueOf(memberId));
/* 34 */       if (xMember != null) {
/* 35 */         if (xMember.getGangid() != this.gangId)
/*    */         {
/* 37 */           new PDeleteMemberNotInGang(this.gangId, memberId).call();
/*    */         }
/*    */       } else {
/* 40 */         String logStr = String.format("RDeleteMemberNotInGang.process@GangMember is null |gangid=%d|memberId=%d", new Object[] { Long.valueOf(this.gangId), Long.valueOf(memberId) });
/* 41 */         GangManager.logger.error(logStr);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\RDeleteMemberNotInGang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */