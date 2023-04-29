/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoSendMarqueeRsp
/*    */   extends IDIPPacket<DoSendMarqueeRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4178;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoSendMarqueeRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoSendMarqueeRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4178;
/* 28 */     DoSendMarqueeRsp body = new DoSendMarqueeRsp();
/* 29 */     return new IDIPPacket_DoSendMarqueeRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoSendMarqueeRsp(IdipHeader head, DoSendMarqueeRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4178;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoSendMarqueeRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */