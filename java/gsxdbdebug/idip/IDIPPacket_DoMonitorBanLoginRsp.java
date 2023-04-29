/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoMonitorBanLoginRsp
/*    */   extends IDIPPacket<DoMonitorBanLoginRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4218;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoMonitorBanLoginRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoMonitorBanLoginRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4218;
/* 28 */     DoMonitorBanLoginRsp body = new DoMonitorBanLoginRsp();
/* 29 */     return new IDIPPacket_DoMonitorBanLoginRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoMonitorBanLoginRsp(IdipHeader head, DoMonitorBanLoginRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4218;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoMonitorBanLoginRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */