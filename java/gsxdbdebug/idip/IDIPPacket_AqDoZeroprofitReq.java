/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoZeroprofitReq
/*    */   extends IDIPPacket<AqDoZeroprofitReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4163;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoZeroprofitReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoZeroprofitReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4163;
/* 28 */     AqDoZeroprofitReq body = new AqDoZeroprofitReq();
/* 29 */     return new IDIPPacket_AqDoZeroprofitReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoZeroprofitReq(IdipHeader head, AqDoZeroprofitReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4163;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoZeroprofitReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */