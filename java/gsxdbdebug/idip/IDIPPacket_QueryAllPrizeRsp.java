/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QueryAllPrizeRsp
/*    */   extends IDIPPacket<QueryAllPrizeRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4230;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QueryAllPrizeRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QueryAllPrizeRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4230;
/* 28 */     QueryAllPrizeRsp body = new QueryAllPrizeRsp();
/* 29 */     return new IDIPPacket_QueryAllPrizeRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QueryAllPrizeRsp(IdipHeader head, QueryAllPrizeRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4230;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QueryAllPrizeRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */