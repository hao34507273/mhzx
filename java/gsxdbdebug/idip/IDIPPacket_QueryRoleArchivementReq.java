/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QueryRoleArchivementReq
/*    */   extends IDIPPacket<QueryRoleArchivementReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4223;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QueryRoleArchivementReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QueryRoleArchivementReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4223;
/* 28 */     QueryRoleArchivementReq body = new QueryRoleArchivementReq();
/* 29 */     return new IDIPPacket_QueryRoleArchivementReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QueryRoleArchivementReq(IdipHeader head, QueryRoleArchivementReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4223;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QueryRoleArchivementReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */