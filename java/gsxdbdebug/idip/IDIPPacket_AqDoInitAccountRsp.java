/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoInitAccountRsp
/*    */   extends IDIPPacket<AqDoInitAccountRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4162;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoInitAccountRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoInitAccountRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4162;
/* 28 */     AqDoInitAccountRsp body = new AqDoInitAccountRsp();
/* 29 */     return new IDIPPacket_AqDoInitAccountRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoInitAccountRsp(IdipHeader head, AqDoInitAccountRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4162;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoInitAccountRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */