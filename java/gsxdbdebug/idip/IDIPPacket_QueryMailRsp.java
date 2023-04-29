/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QueryMailRsp
/*    */   extends IDIPPacket<QueryMailRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4226;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QueryMailRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QueryMailRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4226;
/* 28 */     QueryMailRsp body = new QueryMailRsp();
/* 29 */     return new IDIPPacket_QueryMailRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QueryMailRsp(IdipHeader head, QueryMailRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4226;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QueryMailRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */