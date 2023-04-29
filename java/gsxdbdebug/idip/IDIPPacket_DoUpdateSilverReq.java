/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoUpdateSilverReq
/*    */   extends IDIPPacket<DoUpdateSilverReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4101;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoUpdateSilverReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoUpdateSilverReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4101;
/* 28 */     DoUpdateSilverReq body = new DoUpdateSilverReq();
/* 29 */     return new IDIPPacket_DoUpdateSilverReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoUpdateSilverReq(IdipHeader head, DoUpdateSilverReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4101;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoUpdateSilverReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */