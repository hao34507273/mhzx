/*    */ package mzm.gsp.floplottery.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.awardpool.confbean.SFlopLotteryMainCfg;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.tlog.LogReason;
/*    */ import mzm.gsp.tlog.TLogArg;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import xbean.FlopLotteryEntry;
/*    */ import xtable.Role2floplotteryentry;
/*    */ 
/*    */ public class FlopLotteryItemHandlerImpl
/*    */   implements FlopLotteryHandlerInterface
/*    */ {
/*    */   private final long itemUUID;
/*    */   
/*    */   public FlopLotteryItemHandlerImpl(long itemUUID)
/*    */   {
/* 20 */     this.itemUUID = itemUUID;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handle(long roleId)
/*    */   {
/* 26 */     FlopLotteryEntry xFlopLotteryEntry = Role2floplotteryentry.get(Long.valueOf(roleId));
/* 27 */     SFlopLotteryMainCfg flopLotteryMainCfg = SFlopLotteryMainCfg.get(xFlopLotteryEntry.getFloplotterymaincfgid());
/* 28 */     int xSize = xFlopLotteryEntry.getFloplotteryawardpoolresultlist().size();
/* 29 */     if (xSize == 0)
/*    */     {
/*    */ 
/* 32 */       boolean result = ItemInterface.removeItemByUuid(roleId, this.itemUUID, 1, new TLogArg(LogReason.FLOP_LOTTERY_DELETE_ITEM));
/*    */       
/* 34 */       if (!result)
/*    */       {
/* 36 */         return false;
/*    */       }
/*    */       
/* 39 */       xFlopLotteryEntry.setExpiretimestamp(DateTimeUtils.getCurrTimeInMillis() + TimeUnit.HOURS.toMillis(flopLotteryMainCfg.validDuration));
/*    */     }
/*    */     
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floplottery\main\FlopLotteryItemHandlerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */