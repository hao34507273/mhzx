/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_MailSendWholeGiftReq
/*    */   extends IDIPPacket<MailSendWholeGiftReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4173;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_MailSendWholeGiftReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_MailSendWholeGiftReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4173;
/* 28 */     MailSendWholeGiftReq body = new MailSendWholeGiftReq();
/* 29 */     return new IDIPPacket_MailSendWholeGiftReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_MailSendWholeGiftReq(IdipHeader head, MailSendWholeGiftReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4173;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_MailSendWholeGiftReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */