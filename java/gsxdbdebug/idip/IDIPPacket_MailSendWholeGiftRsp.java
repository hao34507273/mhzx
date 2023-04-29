/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_MailSendWholeGiftRsp
/*    */   extends IDIPPacket<MailSendWholeGiftRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4174;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_MailSendWholeGiftRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_MailSendWholeGiftRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4174;
/* 28 */     MailSendWholeGiftRsp body = new MailSendWholeGiftRsp();
/* 29 */     return new IDIPPacket_MailSendWholeGiftRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_MailSendWholeGiftRsp(IdipHeader head, MailSendWholeGiftRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4174;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_MailSendWholeGiftRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */