/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QueryMarqueeReq
/*    */   extends IDIPPacket<QueryMarqueeReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4193;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QueryMarqueeReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QueryMarqueeReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4193;
/* 28 */     QueryMarqueeReq body = new QueryMarqueeReq();
/* 29 */     return new IDIPPacket_QueryMarqueeReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QueryMarqueeReq(IdipHeader head, QueryMarqueeReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4193;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QueryMarqueeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */