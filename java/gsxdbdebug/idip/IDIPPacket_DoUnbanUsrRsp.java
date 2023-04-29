/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoUnbanUsrRsp
/*    */   extends IDIPPacket<DoUnbanUsrRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4126;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoUnbanUsrRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoUnbanUsrRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4126;
/* 28 */     DoUnbanUsrRsp body = new DoUnbanUsrRsp();
/* 29 */     return new IDIPPacket_DoUnbanUsrRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoUnbanUsrRsp(IdipHeader head, DoUnbanUsrRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4126;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoUnbanUsrRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */