/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_WhiteListSwitchRsp
/*    */   extends IDIPPacket<WhiteListSwitchRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4168;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_WhiteListSwitchRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_WhiteListSwitchRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4168;
/* 28 */     WhiteListSwitchRsp body = new WhiteListSwitchRsp();
/* 29 */     return new IDIPPacket_WhiteListSwitchRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_WhiteListSwitchRsp(IdipHeader head, WhiteListSwitchRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4168;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_WhiteListSwitchRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */