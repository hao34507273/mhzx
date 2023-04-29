/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoInitAccountReq
/*    */   extends IDIPPacket<AqDoInitAccountReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4161;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoInitAccountReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoInitAccountReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4161;
/* 28 */     AqDoInitAccountReq body = new AqDoInitAccountReq();
/* 29 */     return new IDIPPacket_AqDoInitAccountReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoInitAccountReq(IdipHeader head, AqDoInitAccountReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4161;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoInitAccountReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */