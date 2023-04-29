/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoBanAddFriendRsp
/*    */   extends IDIPPacket<AqDoBanAddFriendRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4200;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoBanAddFriendRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoBanAddFriendRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4200;
/* 28 */     AqDoBanAddFriendRsp body = new AqDoBanAddFriendRsp();
/* 29 */     return new IDIPPacket_AqDoBanAddFriendRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoBanAddFriendRsp(IdipHeader head, AqDoBanAddFriendRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4200;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoBanAddFriendRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */