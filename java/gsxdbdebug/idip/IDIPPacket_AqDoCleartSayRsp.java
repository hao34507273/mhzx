/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoCleartSayRsp
/*    */   extends IDIPPacket<AqDoCleartSayRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4166;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoCleartSayRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoCleartSayRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4166;
/* 28 */     AqDoCleartSayRsp body = new AqDoCleartSayRsp();
/* 29 */     return new IDIPPacket_AqDoCleartSayRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoCleartSayRsp(IdipHeader head, AqDoCleartSayRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4166;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoCleartSayRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */