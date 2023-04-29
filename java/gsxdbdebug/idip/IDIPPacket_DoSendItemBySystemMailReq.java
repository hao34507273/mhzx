/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoSendItemBySystemMailReq
/*    */   extends IDIPPacket<DoSendItemBySystemMailReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4133;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoSendItemBySystemMailReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoSendItemBySystemMailReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4133;
/* 28 */     DoSendItemBySystemMailReq body = new DoSendItemBySystemMailReq();
/* 29 */     return new IDIPPacket_DoSendItemBySystemMailReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoSendItemBySystemMailReq(IdipHeader head, DoSendItemBySystemMailReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4133;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoSendItemBySystemMailReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */