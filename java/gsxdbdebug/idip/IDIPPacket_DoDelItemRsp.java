/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoDelItemRsp
/*    */   extends IDIPPacket<DoDelItemRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4120;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoDelItemRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoDelItemRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4120;
/* 28 */     DoDelItemRsp body = new DoDelItemRsp();
/* 29 */     return new IDIPPacket_DoDelItemRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoDelItemRsp(IdipHeader head, DoDelItemRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4120;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoDelItemRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */