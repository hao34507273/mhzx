/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoDelMailReq
/*    */   extends IDIPPacket<DoDelMailReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4227;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoDelMailReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoDelMailReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4227;
/* 28 */     DoDelMailReq body = new DoDelMailReq();
/* 29 */     return new IDIPPacket_DoDelMailReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoDelMailReq(IdipHeader head, DoDelMailReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4227;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoDelMailReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */