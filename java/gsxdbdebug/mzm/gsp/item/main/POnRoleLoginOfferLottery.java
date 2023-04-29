/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import xbean.Lottery;
/*    */ 
/*    */ public class POnRoleLoginOfferLottery
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 15 */     Lottery lottery = LotteryManager.getLottery(((Long)this.arg).longValue());
/* 16 */     if (lottery == null)
/*    */     {
/* 18 */       return false;
/*    */     }
/* 20 */     for (Iterator i$ = lottery.getLottery().keySet().iterator(); i$.hasNext();) { int lotteryType = ((Integer)i$.next()).intValue();
/*    */       
/* 22 */       new POfferLotteryResult(((Long)this.arg).longValue(), lotteryType).execute();
/*    */     }
/*    */     
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\POnRoleLoginOfferLottery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */