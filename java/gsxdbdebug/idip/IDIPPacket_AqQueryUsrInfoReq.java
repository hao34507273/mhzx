/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqQueryUsrInfoReq
/*    */   extends IDIPPacket<AqQueryUsrInfoReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4135;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqQueryUsrInfoReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqQueryUsrInfoReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4135;
/* 28 */     AqQueryUsrInfoReq body = new AqQueryUsrInfoReq();
/* 29 */     return new IDIPPacket_AqQueryUsrInfoReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqQueryUsrInfoReq(IdipHeader head, AqQueryUsrInfoReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4135;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqQueryUsrInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */