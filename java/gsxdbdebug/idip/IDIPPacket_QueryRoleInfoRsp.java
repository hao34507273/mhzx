/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QueryRoleInfoRsp
/*    */   extends IDIPPacket<QueryRoleInfoRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4130;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QueryRoleInfoRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QueryRoleInfoRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4130;
/* 28 */     QueryRoleInfoRsp body = new QueryRoleInfoRsp();
/* 29 */     return new IDIPPacket_QueryRoleInfoRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QueryRoleInfoRsp(IdipHeader head, QueryRoleInfoRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4130;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QueryRoleInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */