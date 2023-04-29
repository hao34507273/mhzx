/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoDelAllMailReq
/*    */   extends IDIPPacket<DoDelAllMailReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4233;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoDelAllMailReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoDelAllMailReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4233;
/* 28 */     DoDelAllMailReq body = new DoDelAllMailReq();
/* 29 */     return new IDIPPacket_DoDelAllMailReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoDelAllMailReq(IdipHeader head, DoDelAllMailReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4233;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoDelAllMailReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */