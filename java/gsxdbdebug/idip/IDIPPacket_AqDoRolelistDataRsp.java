/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoRolelistDataRsp
/*    */   extends IDIPPacket<AqDoRolelistDataRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4154;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoRolelistDataRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoRolelistDataRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4154;
/* 28 */     AqDoRolelistDataRsp body = new AqDoRolelistDataRsp();
/* 29 */     return new IDIPPacket_AqDoRolelistDataRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoRolelistDataRsp(IdipHeader head, AqDoRolelistDataRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4154;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoRolelistDataRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */