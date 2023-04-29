/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoUpdateCompetitivePointRsp
/*    */   extends IDIPPacket<DoUpdateCompetitivePointRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4114;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoUpdateCompetitivePointRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoUpdateCompetitivePointRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4114;
/* 28 */     DoUpdateCompetitivePointRsp body = new DoUpdateCompetitivePointRsp();
/* 29 */     return new IDIPPacket_DoUpdateCompetitivePointRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoUpdateCompetitivePointRsp(IdipHeader head, DoUpdateCompetitivePointRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4114;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoUpdateCompetitivePointRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */