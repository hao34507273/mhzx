/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoUpdateMoneyReq
/*    */   extends IDIPPacket<AqDoUpdateMoneyReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4139;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoUpdateMoneyReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoUpdateMoneyReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4139;
/* 28 */     AqDoUpdateMoneyReq body = new AqDoUpdateMoneyReq();
/* 29 */     return new IDIPPacket_AqDoUpdateMoneyReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoUpdateMoneyReq(IdipHeader head, AqDoUpdateMoneyReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4139;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoUpdateMoneyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */