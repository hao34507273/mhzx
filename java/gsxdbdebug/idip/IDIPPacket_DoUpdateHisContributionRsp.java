/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoUpdateHisContributionRsp
/*    */   extends IDIPPacket<DoUpdateHisContributionRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4106;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoUpdateHisContributionRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoUpdateHisContributionRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4106;
/* 28 */     DoUpdateHisContributionRsp body = new DoUpdateHisContributionRsp();
/* 29 */     return new IDIPPacket_DoUpdateHisContributionRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoUpdateHisContributionRsp(IdipHeader head, DoUpdateHisContributionRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4106;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoUpdateHisContributionRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */