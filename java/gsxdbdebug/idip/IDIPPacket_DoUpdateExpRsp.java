/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoUpdateExpRsp
/*    */   extends IDIPPacket<DoUpdateExpRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4116;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoUpdateExpRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoUpdateExpRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4116;
/* 28 */     DoUpdateExpRsp body = new DoUpdateExpRsp();
/* 29 */     return new IDIPPacket_DoUpdateExpRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoUpdateExpRsp(IdipHeader head, DoUpdateExpRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4116;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoUpdateExpRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */