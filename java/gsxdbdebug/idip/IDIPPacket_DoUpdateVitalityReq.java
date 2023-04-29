/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoUpdateVitalityReq
/*    */   extends IDIPPacket<DoUpdateVitalityReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4103;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoUpdateVitalityReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoUpdateVitalityReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4103;
/* 28 */     DoUpdateVitalityReq body = new DoUpdateVitalityReq();
/* 29 */     return new IDIPPacket_DoUpdateVitalityReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoUpdateVitalityReq(IdipHeader head, DoUpdateVitalityReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4103;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoUpdateVitalityReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */