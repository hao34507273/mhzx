/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoUpdateNoticeReq
/*    */   extends IDIPPacket<DoUpdateNoticeReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4189;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoUpdateNoticeReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoUpdateNoticeReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4189;
/* 28 */     DoUpdateNoticeReq body = new DoUpdateNoticeReq();
/* 29 */     return new IDIPPacket_DoUpdateNoticeReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoUpdateNoticeReq(IdipHeader head, DoUpdateNoticeReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4189;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoUpdateNoticeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */