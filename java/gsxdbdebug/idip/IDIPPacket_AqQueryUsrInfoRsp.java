/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_AqQueryUsrInfoRsp
/*    */   extends IDIPPacket<AqQueryUsrInfoRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4136;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_AqQueryUsrInfoRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_AqQueryUsrInfoRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4136;
/* 28 */     AqQueryUsrInfoRsp body = new AqQueryUsrInfoRsp();
/* 29 */     return new IDIPPacket_AqQueryUsrInfoRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_AqQueryUsrInfoRsp(IdipHeader head, AqQueryUsrInfoRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4136;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_AqQueryUsrInfoRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */