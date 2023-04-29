/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqDoCleartSayReq
/*    */   extends IDIPPacket<AqDoCleartSayReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4165;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqDoCleartSayReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqDoCleartSayReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4165;
/* 28 */     AqDoCleartSayReq body = new AqDoCleartSayReq();
/* 29 */     return new IDIPPacket_AqDoCleartSayReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqDoCleartSayReq(IdipHeader head, AqDoCleartSayReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4165;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqDoCleartSayReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */