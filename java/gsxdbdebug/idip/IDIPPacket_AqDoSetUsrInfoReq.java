/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoSetUsrInfoReq
/*    */   extends IDIPPacket<AqDoSetUsrInfoReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4145;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoSetUsrInfoReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoSetUsrInfoReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4145;
/* 28 */     AqDoSetUsrInfoReq body = new AqDoSetUsrInfoReq();
/* 29 */     return new IDIPPacket_AqDoSetUsrInfoReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoSetUsrInfoReq(IdipHeader head, AqDoSetUsrInfoReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4145;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoSetUsrInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */