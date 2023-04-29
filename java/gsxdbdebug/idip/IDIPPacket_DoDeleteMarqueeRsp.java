/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_DoDeleteMarqueeRsp
/*    */   extends IDIPPacket<DoDeleteMarqueeRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4180;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_DoDeleteMarqueeRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_DoDeleteMarqueeRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4180;
/* 28 */     DoDeleteMarqueeRsp body = new DoDeleteMarqueeRsp();
/* 29 */     return new IDIPPacket_DoDeleteMarqueeRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_DoDeleteMarqueeRsp(IdipHeader head, DoDeleteMarqueeRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4180;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_DoDeleteMarqueeRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */