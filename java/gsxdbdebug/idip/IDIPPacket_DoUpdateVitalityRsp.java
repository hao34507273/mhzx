/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoUpdateVitalityRsp
/*    */   extends IDIPPacket<DoUpdateVitalityRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4104;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoUpdateVitalityRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoUpdateVitalityRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4104;
/* 28 */     DoUpdateVitalityRsp body = new DoUpdateVitalityRsp();
/* 29 */     return new IDIPPacket_DoUpdateVitalityRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoUpdateVitalityRsp(IdipHeader head, DoUpdateVitalityRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4104;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoUpdateVitalityRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */