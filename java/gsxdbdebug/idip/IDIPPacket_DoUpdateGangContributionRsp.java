/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoUpdateGangContributionRsp
/*    */   extends IDIPPacket<DoUpdateGangContributionRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4112;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoUpdateGangContributionRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoUpdateGangContributionRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4112;
/* 28 */     DoUpdateGangContributionRsp body = new DoUpdateGangContributionRsp();
/* 29 */     return new IDIPPacket_DoUpdateGangContributionRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoUpdateGangContributionRsp(IdipHeader head, DoUpdateGangContributionRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4112;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoUpdateGangContributionRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */