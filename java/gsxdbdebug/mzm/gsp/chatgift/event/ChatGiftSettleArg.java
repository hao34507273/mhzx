/*    */ package mzm.gsp.chatgift.event;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.ChatGiftRoleMoney;
/*    */ 
/*    */ public class ChatGiftSettleArg
/*    */ {
/*    */   public final int channelType;
/*    */   public final int giftMoneyType;
/* 10 */   public final Map<Long, Integer> roleMoneyNums = new java.util.HashMap();
/*    */   
/*    */   public ChatGiftSettleArg(int channelType, int giftMoneyType, Map<Long, ChatGiftRoleMoney> role2money)
/*    */   {
/* 14 */     this.channelType = channelType;
/* 15 */     this.giftMoneyType = giftMoneyType;
/* 16 */     for (java.util.Map.Entry<Long, ChatGiftRoleMoney> entry : role2money.entrySet())
/*    */     {
/* 18 */       this.roleMoneyNums.put(entry.getKey(), Integer.valueOf(((ChatGiftRoleMoney)entry.getValue()).getMoneynum()));
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\event\ChatGiftSettleArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */