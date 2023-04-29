/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoBanJoinrankRsp
/*    */   extends IDIPPacket<AqDoBanJoinrankRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4152;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoBanJoinrankRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoBanJoinrankRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4152;
/* 28 */     AqDoBanJoinrankRsp body = new AqDoBanJoinrankRsp();
/* 29 */     return new IDIPPacket_AqDoBanJoinrankRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoBanJoinrankRsp(IdipHeader head, AqDoBanJoinrankRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4152;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoBanJoinrankRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */