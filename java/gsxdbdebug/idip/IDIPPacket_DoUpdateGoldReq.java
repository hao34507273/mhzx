/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoUpdateGoldReq
/*    */   extends IDIPPacket<DoUpdateGoldReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4183;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoUpdateGoldReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoUpdateGoldReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4183;
/* 28 */     DoUpdateGoldReq body = new DoUpdateGoldReq();
/* 29 */     return new IDIPPacket_DoUpdateGoldReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoUpdateGoldReq(IdipHeader head, DoUpdateGoldReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4183;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoUpdateGoldReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */