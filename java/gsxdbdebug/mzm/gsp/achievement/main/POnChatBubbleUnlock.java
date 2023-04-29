/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import mzm.gsp.chatbubble.event.ChatBubbleUnlockArg;
/*    */ import mzm.gsp.chatbubble.event.ChatBubbleUnlockProcedure;
/*    */ 
/*    */ public class POnChatBubbleUnlock
/*    */   extends ChatBubbleUnlockProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */   {
/* 11 */     AchievementManager.updateGoalTypeState(((ChatBubbleUnlockArg)this.arg).roleId, 5808, null, "POnChatBubbleUnlock.processImp@handle BUBBLE_OWN success");
/*    */     
/*    */ 
/*    */ 
/* 15 */     AchievementManager.updateGoalTypeState(((ChatBubbleUnlockArg)this.arg).roleId, 5809, null, "POnChatBubbleUnlock.processImp@handle BUBBLE_SPECIFIC_OWN success");
/*    */     
/*    */ 
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\POnChatBubbleUnlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */