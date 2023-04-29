/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoUpdateHisContributionReq
/*    */   extends IDIPPacket<DoUpdateHisContributionReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4105;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoUpdateHisContributionReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoUpdateHisContributionReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4105;
/* 28 */     DoUpdateHisContributionReq body = new DoUpdateHisContributionReq();
/* 29 */     return new IDIPPacket_DoUpdateHisContributionReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoUpdateHisContributionReq(IdipHeader head, DoUpdateHisContributionReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4105;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoUpdateHisContributionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */