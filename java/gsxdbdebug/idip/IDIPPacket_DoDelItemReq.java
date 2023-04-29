/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoDelItemReq
/*    */   extends IDIPPacket<DoDelItemReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4119;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoDelItemReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoDelItemReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4119;
/* 28 */     DoDelItemReq body = new DoDelItemReq();
/* 29 */     return new IDIPPacket_DoDelItemReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoDelItemReq(IdipHeader head, DoDelItemReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4119;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoDelItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */