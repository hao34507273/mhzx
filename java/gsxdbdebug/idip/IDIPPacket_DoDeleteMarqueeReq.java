/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoDeleteMarqueeReq
/*    */   extends IDIPPacket<DoDeleteMarqueeReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4179;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoDeleteMarqueeReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoDeleteMarqueeReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4179;
/* 28 */     DoDeleteMarqueeReq body = new DoDeleteMarqueeReq();
/* 29 */     return new IDIPPacket_DoDeleteMarqueeReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoDeleteMarqueeReq(IdipHeader head, DoDeleteMarqueeReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4179;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoDeleteMarqueeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */