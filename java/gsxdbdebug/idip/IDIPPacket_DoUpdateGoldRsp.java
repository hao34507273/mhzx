/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoUpdateGoldRsp
/*    */   extends IDIPPacket<DoUpdateGoldRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4184;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoUpdateGoldRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoUpdateGoldRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4184;
/* 28 */     DoUpdateGoldRsp body = new DoUpdateGoldRsp();
/* 29 */     return new IDIPPacket_DoUpdateGoldRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoUpdateGoldRsp(IdipHeader head, DoUpdateGoldRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4184;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoUpdateGoldRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */