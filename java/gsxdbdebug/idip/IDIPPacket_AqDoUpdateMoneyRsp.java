/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoUpdateMoneyRsp
/*    */   extends IDIPPacket<AqDoUpdateMoneyRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4140;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoUpdateMoneyRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoUpdateMoneyRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4140;
/* 28 */     AqDoUpdateMoneyRsp body = new AqDoUpdateMoneyRsp();
/* 29 */     return new IDIPPacket_AqDoUpdateMoneyRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoUpdateMoneyRsp(IdipHeader head, AqDoUpdateMoneyRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4140;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoUpdateMoneyRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */