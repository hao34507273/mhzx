/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoMaskchatUsrRsp
/*    */   extends IDIPPacket<AqDoMaskchatUsrRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4158;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoMaskchatUsrRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoMaskchatUsrRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4158;
/* 28 */     AqDoMaskchatUsrRsp body = new AqDoMaskchatUsrRsp();
/* 29 */     return new IDIPPacket_AqDoMaskchatUsrRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoMaskchatUsrRsp(IdipHeader head, AqDoMaskchatUsrRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4158;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoMaskchatUsrRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */