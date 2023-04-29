/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_SysFunSwitchReq
/*    */   extends IDIPPacket<SysFunSwitchReq>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4169;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_SysFunSwitchReq.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_SysFunSwitchReq create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4169;
/* 28 */     SysFunSwitchReq body = new SysFunSwitchReq();
/* 29 */     return new IDIPPacket_SysFunSwitchReq(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_SysFunSwitchReq(IdipHeader head, SysFunSwitchReq body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4169;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_SysFunSwitchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */