/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QueryAllPrizeReq
/*    */   extends IDIPPacket<QueryAllPrizeReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4229;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QueryAllPrizeReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QueryAllPrizeReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4229;
/* 28 */     QueryAllPrizeReq body = new QueryAllPrizeReq();
/* 29 */     return new IDIPPacket_QueryAllPrizeReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QueryAllPrizeReq(IdipHeader head, QueryAllPrizeReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4229;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QueryAllPrizeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */