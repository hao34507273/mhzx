/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_ChannelSignLimitFunRsp
/*    */   extends IDIPPacket<ChannelSignLimitFunRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4172;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_ChannelSignLimitFunRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_ChannelSignLimitFunRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4172;
/* 28 */     ChannelSignLimitFunRsp body = new ChannelSignLimitFunRsp();
/* 29 */     return new IDIPPacket_ChannelSignLimitFunRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_ChannelSignLimitFunRsp(IdipHeader head, ChannelSignLimitFunRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4172;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_ChannelSignLimitFunRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */