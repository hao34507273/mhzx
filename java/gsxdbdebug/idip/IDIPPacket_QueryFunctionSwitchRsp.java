/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_QueryFunctionSwitchRsp
/*    */   extends IDIPPacket<QueryFunctionSwitchRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4222;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_QueryFunctionSwitchRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_QueryFunctionSwitchRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4222;
/* 28 */     QueryFunctionSwitchRsp body = new QueryFunctionSwitchRsp();
/* 29 */     return new IDIPPacket_QueryFunctionSwitchRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_QueryFunctionSwitchRsp(IdipHeader head, QueryFunctionSwitchRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4222;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_QueryFunctionSwitchRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */