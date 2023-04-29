/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoBanAssignPlayReq
/*    */   extends IDIPPacket<AqDoBanAssignPlayReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4181;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoBanAssignPlayReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoBanAssignPlayReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4181;
/* 28 */     AqDoBanAssignPlayReq body = new AqDoBanAssignPlayReq();
/* 29 */     return new IDIPPacket_AqDoBanAssignPlayReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoBanAssignPlayReq(IdipHeader head, AqDoBanAssignPlayReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4181;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoBanAssignPlayReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */