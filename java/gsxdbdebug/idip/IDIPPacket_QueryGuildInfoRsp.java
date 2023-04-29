/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QueryGuildInfoRsp
/*    */   extends IDIPPacket<QueryGuildInfoRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4210;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QueryGuildInfoRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QueryGuildInfoRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4210;
/* 28 */     QueryGuildInfoRsp body = new QueryGuildInfoRsp();
/* 29 */     return new IDIPPacket_QueryGuildInfoRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QueryGuildInfoRsp(IdipHeader head, QueryGuildInfoRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4210;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QueryGuildInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */