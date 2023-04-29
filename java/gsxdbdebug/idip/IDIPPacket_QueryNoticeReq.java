/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QueryNoticeReq
/*    */   extends IDIPPacket<QueryNoticeReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4187;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QueryNoticeReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QueryNoticeReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4187;
/* 28 */     QueryNoticeReq body = new QueryNoticeReq();
/* 29 */     return new IDIPPacket_QueryNoticeReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QueryNoticeReq(IdipHeader head, QueryNoticeReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4187;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QueryNoticeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */