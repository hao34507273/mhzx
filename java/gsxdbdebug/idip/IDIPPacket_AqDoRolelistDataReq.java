/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoRolelistDataReq
/*    */   extends IDIPPacket<AqDoRolelistDataReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4153;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoRolelistDataReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoRolelistDataReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4153;
/* 28 */     AqDoRolelistDataReq body = new AqDoRolelistDataReq();
/* 29 */     return new IDIPPacket_AqDoRolelistDataReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoRolelistDataReq(IdipHeader head, AqDoRolelistDataReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4153;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoRolelistDataReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */