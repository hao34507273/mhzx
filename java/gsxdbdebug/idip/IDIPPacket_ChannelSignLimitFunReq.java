/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_ChannelSignLimitFunReq
/*    */   extends IDIPPacket<ChannelSignLimitFunReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4171;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_ChannelSignLimitFunReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_ChannelSignLimitFunReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4171;
/* 28 */     ChannelSignLimitFunReq body = new ChannelSignLimitFunReq();
/* 29 */     return new IDIPPacket_ChannelSignLimitFunReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_ChannelSignLimitFunReq(IdipHeader head, ChannelSignLimitFunReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4171;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_ChannelSignLimitFunReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */