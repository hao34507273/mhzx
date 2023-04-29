/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoRechangeAgentRsp
/*    */   extends IDIPPacket<DoRechangeAgentRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4214;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoRechangeAgentRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoRechangeAgentRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4214;
/* 28 */     DoRechangeAgentRsp body = new DoRechangeAgentRsp();
/* 29 */     return new IDIPPacket_DoRechangeAgentRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoRechangeAgentRsp(IdipHeader head, DoRechangeAgentRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4214;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoRechangeAgentRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */