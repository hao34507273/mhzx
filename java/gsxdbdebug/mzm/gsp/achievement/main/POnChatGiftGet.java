/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractTwoCondAccumulate.Context;
/*    */ import mzm.gsp.chatgift.event.ChatGiftGetArg;
/*    */ import mzm.gsp.chatgift.event.ChatGiftGetEventProcedure;
/*    */ 
/*    */ public class POnChatGiftGet
/*    */   extends ChatGiftGetEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     AbstractTwoCondAccumulate.Context ctx1 = new AbstractTwoCondAccumulate.Context(((ChatGiftGetArg)this.arg).channelType, ((ChatGiftGetArg)this.arg).getMoneyType, ((ChatGiftGetArg)this.arg).getMoney);
/* 13 */     AchievementManager.updateGoalTypeState(((ChatGiftGetArg)this.arg).getRoldId, 1204, ctx1, "POnChatGiftGet.processImp@handle CHAT_GIFT_GET_AMOUNT finish");
/*    */     
/*    */ 
/*    */ 
/* 17 */     AbstractTwoCondAccumulate.Context ctx2 = new AbstractTwoCondAccumulate.Context(((ChatGiftGetArg)this.arg).channelType, ((ChatGiftGetArg)this.arg).getMoneyType, 1);
/* 18 */     AchievementManager.updateGoalTypeState(((ChatGiftGetArg)this.arg).getRoldId, 1203, ctx2, "POnChatGiftGet.processImp@handle CHAT_GIFT_GET_COUNT finish");
/*    */     
/*    */ 
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnChatGiftGet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */