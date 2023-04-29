/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoUpdateGangContributionReq
/*    */   extends IDIPPacket<DoUpdateGangContributionReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4111;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoUpdateGangContributionReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoUpdateGangContributionReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4111;
/* 28 */     DoUpdateGangContributionReq body = new DoUpdateGangContributionReq();
/* 29 */     return new IDIPPacket_DoUpdateGangContributionReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoUpdateGangContributionReq(IdipHeader head, DoUpdateGangContributionReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4111;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoUpdateGangContributionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */