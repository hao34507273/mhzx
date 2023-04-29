/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoUpdateCompetitivePointReq
/*    */   extends IDIPPacket<DoUpdateCompetitivePointReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4113;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoUpdateCompetitivePointReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoUpdateCompetitivePointReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4113;
/* 28 */     DoUpdateCompetitivePointReq body = new DoUpdateCompetitivePointReq();
/* 29 */     return new IDIPPacket_DoUpdateCompetitivePointReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoUpdateCompetitivePointReq(IdipHeader head, DoUpdateCompetitivePointReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4113;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoUpdateCompetitivePointReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */