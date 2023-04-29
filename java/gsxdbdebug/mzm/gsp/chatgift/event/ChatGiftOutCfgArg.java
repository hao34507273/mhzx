/*    */ package mzm.gsp.chatgift.event;
/*    */ 
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChatGiftOutCfgArg
/*    */ {
/*    */   public final Set<Long> chatGiftIds;
/*    */   public final int channelType;
/*    */   public final long channelId;
/*    */   
/*    */   public ChatGiftOutCfgArg(Set<Long> chatGiftIds, int channelType, long channelId)
/*    */   {
/* 16 */     this.chatGiftIds = chatGiftIds;
/* 17 */     this.channelId = channelId;
/* 18 */     this.channelType = channelType;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\event\ChatGiftOutCfgArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */