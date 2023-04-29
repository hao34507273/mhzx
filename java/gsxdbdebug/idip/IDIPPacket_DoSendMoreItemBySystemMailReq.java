/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoSendMoreItemBySystemMailReq
/*    */   extends IDIPPacket<DoSendMoreItemBySystemMailReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4215;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoSendMoreItemBySystemMailReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoSendMoreItemBySystemMailReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4215;
/* 28 */     DoSendMoreItemBySystemMailReq body = new DoSendMoreItemBySystemMailReq();
/* 29 */     return new IDIPPacket_DoSendMoreItemBySystemMailReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoSendMoreItemBySystemMailReq(IdipHeader head, DoSendMoreItemBySystemMailReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4215;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoSendMoreItemBySystemMailReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */