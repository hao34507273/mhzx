/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoRelievePunishReq
/*    */   extends IDIPPacket<AqDoRelievePunishReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4159;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoRelievePunishReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoRelievePunishReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4159;
/* 28 */     AqDoRelievePunishReq body = new AqDoRelievePunishReq();
/* 29 */     return new IDIPPacket_AqDoRelievePunishReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoRelievePunishReq(IdipHeader head, AqDoRelievePunishReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4159;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoRelievePunishReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */