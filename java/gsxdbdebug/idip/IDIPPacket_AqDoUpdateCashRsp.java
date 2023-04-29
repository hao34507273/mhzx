/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoUpdateCashRsp
/*    */   extends IDIPPacket<AqDoUpdateCashRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4142;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoUpdateCashRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoUpdateCashRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4142;
/* 28 */     AqDoUpdateCashRsp body = new AqDoUpdateCashRsp();
/* 29 */     return new IDIPPacket_AqDoUpdateCashRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoUpdateCashRsp(IdipHeader head, AqDoUpdateCashRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4142;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoUpdateCashRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */