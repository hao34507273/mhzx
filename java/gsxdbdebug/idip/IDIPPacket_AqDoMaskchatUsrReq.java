/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoMaskchatUsrReq
/*    */   extends IDIPPacket<AqDoMaskchatUsrReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4157;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoMaskchatUsrReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoMaskchatUsrReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4157;
/* 28 */     AqDoMaskchatUsrReq body = new AqDoMaskchatUsrReq();
/* 29 */     return new IDIPPacket_AqDoMaskchatUsrReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoMaskchatUsrReq(IdipHeader head, AqDoMaskchatUsrReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4157;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoMaskchatUsrReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */