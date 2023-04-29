/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QueryUsrInfoRsp
/*    */   extends IDIPPacket<QueryUsrInfoRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4128;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QueryUsrInfoRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QueryUsrInfoRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4128;
/* 28 */     QueryUsrInfoRsp body = new QueryUsrInfoRsp();
/* 29 */     return new IDIPPacket_QueryUsrInfoRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QueryUsrInfoRsp(IdipHeader head, QueryUsrInfoRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4128;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QueryUsrInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */