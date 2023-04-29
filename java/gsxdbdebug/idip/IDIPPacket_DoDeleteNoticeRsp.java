/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoDeleteNoticeRsp
/*    */   extends IDIPPacket<DoDeleteNoticeRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4192;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoDeleteNoticeRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoDeleteNoticeRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4192;
/* 28 */     DoDeleteNoticeRsp body = new DoDeleteNoticeRsp();
/* 29 */     return new IDIPPacket_DoDeleteNoticeRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoDeleteNoticeRsp(IdipHeader head, DoDeleteNoticeRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4192;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoDeleteNoticeRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */