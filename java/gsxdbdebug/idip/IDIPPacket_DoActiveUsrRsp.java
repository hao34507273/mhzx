/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoActiveUsrRsp
/*    */   extends IDIPPacket<DoActiveUsrRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4122;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoActiveUsrRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoActiveUsrRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4122;
/* 28 */     DoActiveUsrRsp body = new DoActiveUsrRsp();
/* 29 */     return new IDIPPacket_DoActiveUsrRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoActiveUsrRsp(IdipHeader head, DoActiveUsrRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4122;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoActiveUsrRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */