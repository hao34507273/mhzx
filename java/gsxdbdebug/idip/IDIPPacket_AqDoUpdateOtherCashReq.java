/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoUpdateOtherCashReq
/*    */   extends IDIPPacket<AqDoUpdateOtherCashReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4143;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoUpdateOtherCashReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoUpdateOtherCashReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4143;
/* 28 */     AqDoUpdateOtherCashReq body = new AqDoUpdateOtherCashReq();
/* 29 */     return new IDIPPacket_AqDoUpdateOtherCashReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoUpdateOtherCashReq(IdipHeader head, AqDoUpdateOtherCashReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4143;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoUpdateOtherCashReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */