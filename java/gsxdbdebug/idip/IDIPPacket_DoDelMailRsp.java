/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoDelMailRsp
/*    */   extends IDIPPacket<DoDelMailRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4228;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoDelMailRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoDelMailRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4228;
/* 28 */     DoDelMailRsp body = new DoDelMailRsp();
/* 29 */     return new IDIPPacket_DoDelMailRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoDelMailRsp(IdipHeader head, DoDelMailRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4228;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoDelMailRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */