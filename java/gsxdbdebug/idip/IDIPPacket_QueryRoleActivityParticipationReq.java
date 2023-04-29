/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QueryRoleActivityParticipationReq
/*    */   extends IDIPPacket<QueryRoleActivityParticipationReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4201;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QueryRoleActivityParticipationReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QueryRoleActivityParticipationReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4201;
/* 28 */     QueryRoleActivityParticipationReq body = new QueryRoleActivityParticipationReq();
/* 29 */     return new IDIPPacket_QueryRoleActivityParticipationReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QueryRoleActivityParticipationReq(IdipHeader head, QueryRoleActivityParticipationReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4201;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QueryRoleActivityParticipationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */