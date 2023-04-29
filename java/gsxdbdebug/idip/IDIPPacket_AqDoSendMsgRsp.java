/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoSendMsgRsp
/*    */   extends IDIPPacket<AqDoSendMsgRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4138;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoSendMsgRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoSendMsgRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4138;
/* 28 */     AqDoSendMsgRsp body = new AqDoSendMsgRsp();
/* 29 */     return new IDIPPacket_AqDoSendMsgRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoSendMsgRsp(IdipHeader head, AqDoSendMsgRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4138;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoSendMsgRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */