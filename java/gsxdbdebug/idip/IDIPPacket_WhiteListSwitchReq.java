/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_WhiteListSwitchReq
/*    */   extends IDIPPacket<WhiteListSwitchReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4167;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_WhiteListSwitchReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_WhiteListSwitchReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4167;
/* 28 */     WhiteListSwitchReq body = new WhiteListSwitchReq();
/* 29 */     return new IDIPPacket_WhiteListSwitchReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_WhiteListSwitchReq(IdipHeader head, WhiteListSwitchReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4167;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_WhiteListSwitchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */