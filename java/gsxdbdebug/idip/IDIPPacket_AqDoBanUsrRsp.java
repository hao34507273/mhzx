/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoBanUsrRsp
/*    */   extends IDIPPacket<AqDoBanUsrRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4156;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoBanUsrRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoBanUsrRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4156;
/* 28 */     AqDoBanUsrRsp body = new AqDoBanUsrRsp();
/* 29 */     return new IDIPPacket_AqDoBanUsrRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoBanUsrRsp(IdipHeader head, AqDoBanUsrRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4156;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoBanUsrRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */