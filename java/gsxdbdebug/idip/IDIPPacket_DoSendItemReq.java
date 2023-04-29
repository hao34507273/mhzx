/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoSendItemReq
/*    */   extends IDIPPacket<DoSendItemReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4117;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoSendItemReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoSendItemReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4117;
/* 28 */     DoSendItemReq body = new DoSendItemReq();
/* 29 */     return new IDIPPacket_DoSendItemReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoSendItemReq(IdipHeader head, DoSendItemReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4117;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoSendItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */