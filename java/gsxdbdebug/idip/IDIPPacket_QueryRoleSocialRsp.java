/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QueryRoleSocialRsp
/*    */   extends IDIPPacket<QueryRoleSocialRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4204;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QueryRoleSocialRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QueryRoleSocialRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4204;
/* 28 */     QueryRoleSocialRsp body = new QueryRoleSocialRsp();
/* 29 */     return new IDIPPacket_QueryRoleSocialRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QueryRoleSocialRsp(IdipHeader head, QueryRoleSocialRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4204;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QueryRoleSocialRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */