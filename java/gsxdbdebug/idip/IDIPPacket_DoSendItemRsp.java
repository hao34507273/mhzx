/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoSendItemRsp
/*    */   extends IDIPPacket<DoSendItemRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4118;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoSendItemRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoSendItemRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4118;
/* 28 */     DoSendItemRsp body = new DoSendItemRsp();
/* 29 */     return new IDIPPacket_DoSendItemRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoSendItemRsp(IdipHeader head, DoSendItemRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4118;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoSendItemRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */