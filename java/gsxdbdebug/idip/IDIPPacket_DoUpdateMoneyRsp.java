/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoUpdateMoneyRsp
/*    */   extends IDIPPacket<DoUpdateMoneyRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4100;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoUpdateMoneyRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoUpdateMoneyRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4100;
/* 28 */     DoUpdateMoneyRsp body = new DoUpdateMoneyRsp();
/* 29 */     return new IDIPPacket_DoUpdateMoneyRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoUpdateMoneyRsp(IdipHeader head, DoUpdateMoneyRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4100;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoUpdateMoneyRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */