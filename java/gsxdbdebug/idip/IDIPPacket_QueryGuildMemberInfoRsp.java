/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QueryGuildMemberInfoRsp
/*    */   extends IDIPPacket<QueryGuildMemberInfoRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4212;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QueryGuildMemberInfoRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QueryGuildMemberInfoRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4212;
/* 28 */     QueryGuildMemberInfoRsp body = new QueryGuildMemberInfoRsp();
/* 29 */     return new IDIPPacket_QueryGuildMemberInfoRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QueryGuildMemberInfoRsp(IdipHeader head, QueryGuildMemberInfoRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4212;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QueryGuildMemberInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */