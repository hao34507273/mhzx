/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoUpdateOtherCashRsp
/*    */   extends IDIPPacket<AqDoUpdateOtherCashRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4144;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoUpdateOtherCashRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoUpdateOtherCashRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4144;
/* 28 */     AqDoUpdateOtherCashRsp body = new AqDoUpdateOtherCashRsp();
/* 29 */     return new IDIPPacket_AqDoUpdateOtherCashRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoUpdateOtherCashRsp(IdipHeader head, AqDoUpdateOtherCashRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4144;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoUpdateOtherCashRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */