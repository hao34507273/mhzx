/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QueryRoleArchivementRsp
/*    */   extends IDIPPacket<QueryRoleArchivementRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4224;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QueryRoleArchivementRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QueryRoleArchivementRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4224;
/* 28 */     QueryRoleArchivementRsp body = new QueryRoleArchivementRsp();
/* 29 */     return new IDIPPacket_QueryRoleArchivementRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QueryRoleArchivementRsp(IdipHeader head, QueryRoleArchivementRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4224;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QueryRoleArchivementRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */