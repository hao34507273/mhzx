/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoMonitorBanLoginReq
/*    */   extends IDIPPacket<DoMonitorBanLoginReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4217;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoMonitorBanLoginReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoMonitorBanLoginReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4217;
/* 28 */     DoMonitorBanLoginReq body = new DoMonitorBanLoginReq();
/* 29 */     return new IDIPPacket_DoMonitorBanLoginReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoMonitorBanLoginReq(IdipHeader head, DoMonitorBanLoginReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4217;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoMonitorBanLoginReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */