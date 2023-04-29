/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QueryFunctionSwitchReq
/*    */   extends IDIPPacket<QueryFunctionSwitchReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4221;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QueryFunctionSwitchReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QueryFunctionSwitchReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4221;
/* 28 */     QueryFunctionSwitchReq body = new QueryFunctionSwitchReq();
/* 29 */     return new IDIPPacket_QueryFunctionSwitchReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QueryFunctionSwitchReq(IdipHeader head, QueryFunctionSwitchReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4221;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QueryFunctionSwitchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */