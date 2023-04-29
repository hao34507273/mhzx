/*    */ package mzm.gsp.crossserver.event;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class ReceiveChatContentArg
/*    */ {
/*    */   private final long roleid;
/*    */   private final int channel;
/*    */   private final long orgKey;
/*    */   private final Octets chatContent;
/*    */   
/*    */   public ReceiveChatContentArg(long roleid, int channel, long orgKey, Octets chatContent)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.channel = channel;
/* 16 */     this.orgKey = orgKey;
/* 17 */     this.chatContent = chatContent;
/*    */   }
/*    */   
/*    */   public long getRoleid()
/*    */   {
/* 22 */     return this.roleid;
/*    */   }
/*    */   
/*    */   public int getChannel()
/*    */   {
/* 27 */     return this.channel;
/*    */   }
/*    */   
/*    */   public long getOrgKey()
/*    */   {
/* 32 */     return this.orgKey;
/*    */   }
/*    */   
/*    */   public Octets getChatContent()
/*    */   {
/* 37 */     return this.chatContent;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\event\ReceiveChatContentArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */