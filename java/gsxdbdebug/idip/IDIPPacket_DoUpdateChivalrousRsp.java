/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoUpdateChivalrousRsp
/*    */   extends IDIPPacket<DoUpdateChivalrousRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4108;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoUpdateChivalrousRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoUpdateChivalrousRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4108;
/* 28 */     DoUpdateChivalrousRsp body = new DoUpdateChivalrousRsp();
/* 29 */     return new IDIPPacket_DoUpdateChivalrousRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoUpdateChivalrousRsp(IdipHeader head, DoUpdateChivalrousRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4108;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoUpdateChivalrousRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */