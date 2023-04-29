/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoUnbanUsrReq
/*    */   extends IDIPPacket<DoUnbanUsrReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4125;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoUnbanUsrReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoUnbanUsrReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4125;
/* 28 */     DoUnbanUsrReq body = new DoUnbanUsrReq();
/* 29 */     return new IDIPPacket_DoUnbanUsrReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoUnbanUsrReq(IdipHeader head, DoUnbanUsrReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4125;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoUnbanUsrReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */