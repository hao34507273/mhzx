/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoSendMarqueeReq
/*    */   extends IDIPPacket<DoSendMarqueeReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4177;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoSendMarqueeReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoSendMarqueeReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4177;
/* 28 */     DoSendMarqueeReq body = new DoSendMarqueeReq();
/* 29 */     return new IDIPPacket_DoSendMarqueeReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoSendMarqueeReq(IdipHeader head, DoSendMarqueeReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4177;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoSendMarqueeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */