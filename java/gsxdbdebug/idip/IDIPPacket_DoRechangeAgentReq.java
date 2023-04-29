/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoRechangeAgentReq
/*    */   extends IDIPPacket<DoRechangeAgentReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4213;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoRechangeAgentReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoRechangeAgentReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4213;
/* 28 */     DoRechangeAgentReq body = new DoRechangeAgentReq();
/* 29 */     return new IDIPPacket_DoRechangeAgentReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoRechangeAgentReq(IdipHeader head, DoRechangeAgentReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4213;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoRechangeAgentReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */