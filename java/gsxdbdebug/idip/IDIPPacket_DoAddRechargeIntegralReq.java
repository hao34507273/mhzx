/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoAddRechargeIntegralReq
/*    */   extends IDIPPacket<DoAddRechargeIntegralReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4219;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoAddRechargeIntegralReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoAddRechargeIntegralReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4219;
/* 28 */     DoAddRechargeIntegralReq body = new DoAddRechargeIntegralReq();
/* 29 */     return new IDIPPacket_DoAddRechargeIntegralReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoAddRechargeIntegralReq(IdipHeader head, DoAddRechargeIntegralReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4219;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoAddRechargeIntegralReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */