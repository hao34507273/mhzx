/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QueryGuildMemberInfoReq
/*    */   extends IDIPPacket<QueryGuildMemberInfoReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4211;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QueryGuildMemberInfoReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QueryGuildMemberInfoReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4211;
/* 28 */     QueryGuildMemberInfoReq body = new QueryGuildMemberInfoReq();
/* 29 */     return new IDIPPacket_QueryGuildMemberInfoReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QueryGuildMemberInfoReq(IdipHeader head, QueryGuildMemberInfoReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4211;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QueryGuildMemberInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */