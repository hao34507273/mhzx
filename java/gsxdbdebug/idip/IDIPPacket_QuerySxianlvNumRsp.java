/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QuerySxianlvNumRsp
/*    */   extends IDIPPacket<QuerySxianlvNumRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4206;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QuerySxianlvNumRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QuerySxianlvNumRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4206;
/* 28 */     QuerySxianlvNumRsp body = new QuerySxianlvNumRsp();
/* 29 */     return new IDIPPacket_QuerySxianlvNumRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QuerySxianlvNumRsp(IdipHeader head, QuerySxianlvNumRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4206;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QuerySxianlvNumRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */