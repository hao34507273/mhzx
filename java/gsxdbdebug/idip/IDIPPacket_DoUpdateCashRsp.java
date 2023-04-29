/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoUpdateCashRsp
/*    */   extends IDIPPacket<DoUpdateCashRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4098;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoUpdateCashRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoUpdateCashRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4098;
/* 28 */     DoUpdateCashRsp body = new DoUpdateCashRsp();
/* 29 */     return new IDIPPacket_DoUpdateCashRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoUpdateCashRsp(IdipHeader head, DoUpdateCashRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4098;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoUpdateCashRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */