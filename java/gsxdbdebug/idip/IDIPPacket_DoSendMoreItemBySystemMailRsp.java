/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoSendMoreItemBySystemMailRsp
/*    */   extends IDIPPacket<DoSendMoreItemBySystemMailRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4216;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoSendMoreItemBySystemMailRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoSendMoreItemBySystemMailRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4216;
/* 28 */     DoSendMoreItemBySystemMailRsp body = new DoSendMoreItemBySystemMailRsp();
/* 29 */     return new IDIPPacket_DoSendMoreItemBySystemMailRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoSendMoreItemBySystemMailRsp(IdipHeader head, DoSendMoreItemBySystemMailRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4216;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoSendMoreItemBySystemMailRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */