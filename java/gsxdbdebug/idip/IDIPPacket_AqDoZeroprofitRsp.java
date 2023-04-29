/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoZeroprofitRsp
/*    */   extends IDIPPacket<AqDoZeroprofitRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4164;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoZeroprofitRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoZeroprofitRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4164;
/* 28 */     AqDoZeroprofitRsp body = new AqDoZeroprofitRsp();
/* 29 */     return new IDIPPacket_AqDoZeroprofitRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoZeroprofitRsp(IdipHeader head, AqDoZeroprofitRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4164;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoZeroprofitRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */