/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QueryGuildInfoReq
/*    */   extends IDIPPacket<QueryGuildInfoReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4209;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QueryGuildInfoReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QueryGuildInfoReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4209;
/* 28 */     QueryGuildInfoReq body = new QueryGuildInfoReq();
/* 29 */     return new IDIPPacket_QueryGuildInfoReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QueryGuildInfoReq(IdipHeader head, QueryGuildInfoReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4209;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QueryGuildInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */