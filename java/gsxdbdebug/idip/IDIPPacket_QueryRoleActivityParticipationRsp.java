/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QueryRoleActivityParticipationRsp
/*    */   extends IDIPPacket<QueryRoleActivityParticipationRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4202;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QueryRoleActivityParticipationRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QueryRoleActivityParticipationRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4202;
/* 28 */     QueryRoleActivityParticipationRsp body = new QueryRoleActivityParticipationRsp();
/* 29 */     return new IDIPPacket_QueryRoleActivityParticipationRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QueryRoleActivityParticipationRsp(IdipHeader head, QueryRoleActivityParticipationRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4202;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QueryRoleActivityParticipationRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */