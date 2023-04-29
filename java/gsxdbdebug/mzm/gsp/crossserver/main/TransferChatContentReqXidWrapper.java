/*    */ package mzm.gsp.crossserver.main;
/*    */ 
/*    */ import com.goldhuman.Common.Octets;
/*    */ import hub.DataTransferReq;
/*    */ import hub.DataTransferReqXidWrapper;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TransferChatContentReqXidWrapper
/*    */   extends DataTransferReqXidWrapper
/*    */ {
/*    */   private final long roleid;
/*    */   private final int channel;
/*    */   private final long orgKey;
/*    */   private final Octets chatContent;
/*    */   
/*    */   public TransferChatContentReqXidWrapper(DataTransferReq proto, long roleid, int channel, long orgKey, Octets chatContent)
/*    */   {
/* 22 */     super(proto);
/* 23 */     this.roleid = roleid;
/* 24 */     this.channel = channel;
/* 25 */     this.orgKey = orgKey;
/* 26 */     this.chatContent = chatContent;
/*    */   }
/*    */   
/*    */   public long getRoleid()
/*    */   {
/* 31 */     return this.roleid;
/*    */   }
/*    */   
/*    */   public int getChannel()
/*    */   {
/* 36 */     return this.channel;
/*    */   }
/*    */   
/*    */   public long getOrgKey()
/*    */   {
/* 41 */     return this.orgKey;
/*    */   }
/*    */   
/*    */   public Octets getChatContent()
/*    */   {
/* 46 */     return this.chatContent;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossserver\main\TransferChatContentReqXidWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */