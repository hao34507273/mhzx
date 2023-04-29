/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoSendItemBySystemMailReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoSendItemBySystemMailReq
/*    */   extends IDIPCmd<IDIPPacket_DoSendItemBySystemMailReq, IDIPPacket_DoSendItemBySystemMailRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4133;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoSendItemBySystemMailReq, IDIPPacket_DoSendItemBySystemMailRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoSendItemBySystemMailReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoSendItemBySystemMailReq req, IDIPPacket_DoSendItemBySystemMailRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoSendItemBySystemMailReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoSendItemBySystemMailReq create()
/*    */   {
/* 33 */     IDIPPacket_DoSendItemBySystemMailReq req = IDIPPacket_DoSendItemBySystemMailReq.create();
/* 34 */     IDIPPacket_DoSendItemBySystemMailRsp rsp = IDIPPacket_DoSendItemBySystemMailRsp.create();
/* 35 */     return new IDIPCmd_DoSendItemBySystemMailReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoSendItemBySystemMailReq create(IDIPPacket_DoSendItemBySystemMailReq req, IDIPPacket_DoSendItemBySystemMailRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoSendItemBySystemMailReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoSendItemBySystemMailReq(IDIPPacket_DoSendItemBySystemMailReq req, IDIPPacket_DoSendItemBySystemMailRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4133;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 62 */     return new PIDIPCmd_DoSendItemBySystemMailReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoSendItemBySystemMailReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */