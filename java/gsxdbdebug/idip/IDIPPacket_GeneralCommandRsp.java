/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_GeneralCommandRsp
/*    */   extends IDIPPacket<GeneralCommandRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4176;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_GeneralCommandRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_GeneralCommandRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4176;
/* 28 */     GeneralCommandRsp body = new GeneralCommandRsp();
/* 29 */     return new IDIPPacket_GeneralCommandRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_GeneralCommandRsp(IdipHeader head, GeneralCommandRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4176;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_GeneralCommandRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */