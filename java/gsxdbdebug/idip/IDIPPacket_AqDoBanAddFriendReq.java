/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoBanAddFriendReq
/*    */   extends IDIPPacket<AqDoBanAddFriendReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4199;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoBanAddFriendReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoBanAddFriendReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4199;
/* 28 */     AqDoBanAddFriendReq body = new AqDoBanAddFriendReq();
/* 29 */     return new IDIPPacket_AqDoBanAddFriendReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoBanAddFriendReq(IdipHeader head, AqDoBanAddFriendReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4199;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoBanAddFriendReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */