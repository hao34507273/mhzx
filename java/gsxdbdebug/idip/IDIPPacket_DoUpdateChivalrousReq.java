/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoUpdateChivalrousReq
/*    */   extends IDIPPacket<DoUpdateChivalrousReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4107;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoUpdateChivalrousReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoUpdateChivalrousReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4107;
/* 28 */     DoUpdateChivalrousReq body = new DoUpdateChivalrousReq();
/* 29 */     return new IDIPPacket_DoUpdateChivalrousReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoUpdateChivalrousReq(IdipHeader head, DoUpdateChivalrousReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4107;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoUpdateChivalrousReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */