/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoDeleteNoticeReq
/*    */   extends IDIPPacket<DoDeleteNoticeReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4191;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoDeleteNoticeReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoDeleteNoticeReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4191;
/* 28 */     DoDeleteNoticeReq body = new DoDeleteNoticeReq();
/* 29 */     return new IDIPPacket_DoDeleteNoticeReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoDeleteNoticeReq(IdipHeader head, DoDeleteNoticeReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4191;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoDeleteNoticeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */