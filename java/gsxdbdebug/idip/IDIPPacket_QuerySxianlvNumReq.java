/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QuerySxianlvNumReq
/*    */   extends IDIPPacket<QuerySxianlvNumReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4205;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QuerySxianlvNumReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QuerySxianlvNumReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4205;
/* 28 */     QuerySxianlvNumReq body = new QuerySxianlvNumReq();
/* 29 */     return new IDIPPacket_QuerySxianlvNumReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QuerySxianlvNumReq(IdipHeader head, QuerySxianlvNumReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4205;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QuerySxianlvNumReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */