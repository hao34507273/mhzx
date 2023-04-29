/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.achievement.main.goaltype.AbstractTwoCondAccumulate.Context;
/*    */ import mzm.gsp.chatgift.event.ChatGiftSendArg;
/*    */ import mzm.gsp.chatgift.event.ChatGiftSendEventProcedure;
/*    */ 
/*    */ public class POnChatGiftSend
/*    */   extends ChatGiftSendEventProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 12 */     AbstractTwoCondAccumulate.Context ctx1 = new AbstractTwoCondAccumulate.Context(((ChatGiftSendArg)this.arg).channelType, ((ChatGiftSendArg)this.arg).moneyType, ((ChatGiftSendArg)this.arg).moneyNum);
/* 13 */     AchievementManager.updateGoalTypeState(((ChatGiftSendArg)this.arg).roleId, 1202, ctx1, "POnChatGiftSend.processImp@handle CHAT_GIFT_SEND_AMOUNT finish");
/*    */     
/*    */ 
/*    */ 
/* 17 */     AbstractTwoCondAccumulate.Context ctx2 = new AbstractTwoCondAccumulate.Context(((ChatGiftSendArg)this.arg).channelType, ((ChatGiftSendArg)this.arg).moneyType, 1);
/* 18 */     AchievementManager.updateGoalTypeState(((ChatGiftSendArg)this.arg).roleId, 1201, ctx2, "POnChatGiftSend.processImp@handle CHAT_GIFT_SEND_COUNT finish");
/*    */     
/*    */ 
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnChatGiftSend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */