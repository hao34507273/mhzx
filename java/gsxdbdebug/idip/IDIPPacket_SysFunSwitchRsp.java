/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPPacket;
/*    */ import idip.core.IDIPPacketCreator;
/*    */ import idip.core.IdipHeader;
/*    */ 
/*    */ 
/*    */ public class IDIPPacket_SysFunSwitchRsp
/*    */   extends IDIPPacket<SysFunSwitchRsp>
/*    */ {
/*    */   public static final int IDIP_PACKET_ID = 4170;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPPacketCreator
/*    */   {
/*    */     public IDIPPacket<?> create()
/*    */     {
/* 18 */       return IDIPPacket_SysFunSwitchRsp.create();
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPPacket_SysFunSwitchRsp create()
/*    */   {
/* 26 */     IdipHeader head = new IdipHeader();
/* 27 */     head.Cmdid = 4170;
/* 28 */     SysFunSwitchRsp body = new SysFunSwitchRsp();
/* 29 */     return new IDIPPacket_SysFunSwitchRsp(head, body);
/*    */   }
/*    */   
/*    */   public IDIPPacket_SysFunSwitchRsp(IdipHeader head, SysFunSwitchRsp body)
/*    */   {
/* 34 */     super(head, body);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getPacketID()
/*    */   {
/* 40 */     return 4170;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPPacket_SysFunSwitchRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */