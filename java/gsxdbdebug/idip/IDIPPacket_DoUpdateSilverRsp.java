/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoUpdateSilverRsp
/*    */   extends IDIPPacket<DoUpdateSilverRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4102;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoUpdateSilverRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoUpdateSilverRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4102;
/* 28 */     DoUpdateSilverRsp body = new DoUpdateSilverRsp();
/* 29 */     return new IDIPPacket_DoUpdateSilverRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoUpdateSilverRsp(IdipHeader head, DoUpdateSilverRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4102;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoUpdateSilverRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */