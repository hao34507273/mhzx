/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QueryMarqueeRsp
/*    */   extends IDIPPacket<QueryMarqueeRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4194;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QueryMarqueeRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QueryMarqueeRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4194;
/* 28 */     QueryMarqueeRsp body = new QueryMarqueeRsp();
/* 29 */     return new IDIPPacket_QueryMarqueeRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QueryMarqueeRsp(IdipHeader head, QueryMarqueeRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4194;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QueryMarqueeRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */