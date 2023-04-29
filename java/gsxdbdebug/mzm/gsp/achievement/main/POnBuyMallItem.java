/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractConditionalDoneOneEventTimes.Context;
/*    */ import mzm.gsp.achievement.main.goaltype.ExchangeShangChengBuy.Context;
/*    */ import mzm.gsp.mall.event.BuyItemArg;
/*    */ import mzm.gsp.mall.event.BuyItemProcedure;
/*    */ 
/*    */ public class POnBuyMallItem
/*    */   extends BuyItemProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     ExchangeShangChengBuy.Context context1 = new ExchangeShangChengBuy.Context(((BuyItemArg)this.arg).malltype, ((BuyItemArg)this.arg).num);
/* 14 */     AchievementManager.updateGoalTypeState(((BuyItemArg)this.arg).roleId, 1505, context1, "POnBuyMallItem.processImp@handle EXCHANGE_SHANG_CHENG_BUY success");
/*    */     
/*    */ 
/*    */ 
/* 18 */     AbstractConditionalDoneOneEventTimes.Context context2 = new AbstractConditionalDoneOneEventTimes.Context(((BuyItemArg)this.arg).itemId, ((BuyItemArg)this.arg).num);
/* 19 */     AchievementManager.updateGoalTypeState(((BuyItemArg)this.arg).roleId, 1508, context2, "POnBuyMallItem.processImp@handle EXCHANGE_SHANG_CHENG_BUY_ITEM success");
/*    */     
/*    */ 
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnBuyMallItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */