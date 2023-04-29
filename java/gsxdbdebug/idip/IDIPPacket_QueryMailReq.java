/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QueryMailReq
/*    */   extends IDIPPacket<QueryMailReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4225;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QueryMailReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QueryMailReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4225;
/* 28 */     QueryMailReq body = new QueryMailReq();
/* 29 */     return new IDIPPacket_QueryMailReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QueryMailReq(IdipHeader head, QueryMailReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4225;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QueryMailReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */