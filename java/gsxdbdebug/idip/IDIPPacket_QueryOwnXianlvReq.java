/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QueryOwnXianlvReq
/*    */   extends IDIPPacket<QueryOwnXianlvReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4207;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QueryOwnXianlvReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QueryOwnXianlvReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4207;
/* 28 */     QueryOwnXianlvReq body = new QueryOwnXianlvReq();
/* 29 */     return new IDIPPacket_QueryOwnXianlvReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QueryOwnXianlvReq(IdipHeader head, QueryOwnXianlvReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4207;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QueryOwnXianlvReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */