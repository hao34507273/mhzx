/*    */ package mzm.gsp.floplottery.main;
/*    */ 
/*    */ import mzm.gsp.awardpool.confbean.SFlopLotteryMainCfg;
/*    */ import mzm.gsp.awardpool.confbean.TFlopLotteryAwardPoolCfg;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import xbean.FlopLotteryEntry;
/*    */ import xtable.Role2floplotteryentry;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     long roleId = ((Long)this.arg).longValue();
/* 14 */     FlopLotteryEntry xFlopLotteryEntry = Role2floplotteryentry.get(Long.valueOf(roleId));
/* 15 */     if (xFlopLotteryEntry == null)
/*    */     {
/* 17 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 21 */     if ((xFlopLotteryEntry.getExpiretimestamp() != 0L) && (xFlopLotteryEntry.getExpiretimestamp() < mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis()))
/*    */     {
/*    */ 
/*    */ 
/* 25 */       Role2floplotteryentry.delete(Long.valueOf(roleId));
/* 26 */       return true;
/*    */     }
/* 28 */     SFlopLotteryMainCfg flopLotteryMainCfg = SFlopLotteryMainCfg.get(xFlopLotteryEntry.getFloplotterymaincfgid());
/* 29 */     int xSize = xFlopLotteryEntry.getFloplotteryawardpoolresultlist().size();
/* 30 */     if (xSize == TFlopLotteryAwardPoolCfg.get(flopLotteryMainCfg.typeId).flopLotteryAwardPools.size())
/*    */     {
/*    */ 
/* 33 */       Role2floplotteryentry.delete(Long.valueOf(roleId));
/* 34 */       return true;
/*    */     }
/* 36 */     if (xSize == 0)
/*    */     {
/* 38 */       return true;
/*    */     }
/*    */     
/* 41 */     return FlopLotteryManager.handleLastFlopLottery(xFlopLotteryEntry, roleId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floplottery\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */