/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoUpdateReputationReq
/*    */   extends IDIPPacket<DoUpdateReputationReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4109;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoUpdateReputationReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoUpdateReputationReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4109;
/* 28 */     DoUpdateReputationReq body = new DoUpdateReputationReq();
/* 29 */     return new IDIPPacket_DoUpdateReputationReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoUpdateReputationReq(IdipHeader head, DoUpdateReputationReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4109;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoUpdateReputationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */