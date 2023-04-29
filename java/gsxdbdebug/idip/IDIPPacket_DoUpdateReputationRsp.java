/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoUpdateReputationRsp
/*    */   extends IDIPPacket<DoUpdateReputationRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4110;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoUpdateReputationRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoUpdateReputationRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4110;
/* 28 */     DoUpdateReputationRsp body = new DoUpdateReputationRsp();
/* 29 */     return new IDIPPacket_DoUpdateReputationRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoUpdateReputationRsp(IdipHeader head, DoUpdateReputationRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4110;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoUpdateReputationRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */