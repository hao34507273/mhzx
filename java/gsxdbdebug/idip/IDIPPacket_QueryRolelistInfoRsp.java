/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QueryRolelistInfoRsp
/*    */   extends IDIPPacket<QueryRolelistInfoRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4150;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QueryRolelistInfoRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QueryRolelistInfoRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4150;
/* 28 */     QueryRolelistInfoRsp body = new QueryRolelistInfoRsp();
/* 29 */     return new IDIPPacket_QueryRolelistInfoRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QueryRolelistInfoRsp(IdipHeader head, QueryRolelistInfoRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4150;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QueryRolelistInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */