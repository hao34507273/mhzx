/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.gang.confbean.SGangConst;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.GangDutyMembers;
/*    */ import xbean.GangGlobal;
/*    */ 
/*    */ public class RCheckAndRecoverBangzhuError extends mzm.gsp.util.LogicRunnable
/*    */ {
/*    */   public void process() throws Exception
/*    */   {
/* 14 */     GangGlobal xGlobal = GangManager.getXGlobal(false);
/* 15 */     if ((xGlobal == null) || (xGlobal.getAllgangids().isEmpty())) {
/* 16 */       return;
/*    */     }
/* 18 */     for (Iterator i$ = xGlobal.getAllgangids().iterator(); i$.hasNext();) { long gangid = ((Long)i$.next()).longValue();
/* 19 */       xbean.Gang xGang = xtable.Gang.select(Long.valueOf(gangid));
/* 20 */       if (xGang == null) {
/* 21 */         String logStr = String.format("checkBangzhuErrorAndRecover.process@invalid gangid in set|gangid=%d", new Object[] { Long.valueOf(gangid) });
/* 22 */         GangManager.logger.error(logStr);
/*    */       }
/*    */       else
/*    */       {
/* 26 */         GangDutyMembers xGangDutyMembers = (GangDutyMembers)xGang.getDuty2members().get(Integer.valueOf(SGangConst.getInstance().BANGZHU_ID));
/* 27 */         if (xGangDutyMembers != null)
/*    */         {
/* 29 */           if (xGangDutyMembers.getMembers().size() > 1) {
/* 30 */             new RRecoverDataMoreBangzhu(gangid).run();
/*    */ 
/*    */ 
/*    */ 
/*    */           }
/* 35 */           else if (xGangDutyMembers.getMembers().size() == 1) {
/* 36 */             new RCheckOneBangZhuAndRecoverError(gangid).run();
/*    */           }
/*    */         } else {
/* 39 */           String logStr = String.format("checkBangzhuErrorAndRecover.process@BANGZHU_ID GangDutyMembers is null |gangid=%d", new Object[] { Long.valueOf(gangid) });
/* 40 */           GangManager.logger.error(logStr);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\RCheckAndRecoverBangzhuError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */