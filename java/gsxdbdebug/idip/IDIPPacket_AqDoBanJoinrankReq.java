/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoBanJoinrankReq
/*    */   extends IDIPPacket<AqDoBanJoinrankReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4151;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoBanJoinrankReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoBanJoinrankReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4151;
/* 28 */     AqDoBanJoinrankReq body = new AqDoBanJoinrankReq();
/* 29 */     return new IDIPPacket_AqDoBanJoinrankReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoBanJoinrankReq(IdipHeader head, AqDoBanJoinrankReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4151;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoBanJoinrankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */