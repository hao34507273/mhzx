/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoSendItemBySystemMailRsp
/*    */   extends IDIPPacket<DoSendItemBySystemMailRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4134;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoSendItemBySystemMailRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoSendItemBySystemMailRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4134;
/* 28 */     DoSendItemBySystemMailRsp body = new DoSendItemBySystemMailRsp();
/* 29 */     return new IDIPPacket_DoSendItemBySystemMailRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoSendItemBySystemMailRsp(IdipHeader head, DoSendItemBySystemMailRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4134;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoSendItemBySystemMailRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */