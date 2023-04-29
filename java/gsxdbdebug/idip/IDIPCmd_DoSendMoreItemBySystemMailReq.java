/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoSendMoreItemBySystemMailReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoSendMoreItemBySystemMailReq
/*    */   extends IDIPCmd<IDIPPacket_DoSendMoreItemBySystemMailReq, IDIPPacket_DoSendMoreItemBySystemMailRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4215;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoSendMoreItemBySystemMailReq, IDIPPacket_DoSendMoreItemBySystemMailRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoSendMoreItemBySystemMailReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoSendMoreItemBySystemMailReq req, IDIPPacket_DoSendMoreItemBySystemMailRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoSendMoreItemBySystemMailReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoSendMoreItemBySystemMailReq create()
/*    */   {
/* 33 */     IDIPPacket_DoSendMoreItemBySystemMailReq req = IDIPPacket_DoSendMoreItemBySystemMailReq.create();
/* 34 */     IDIPPacket_DoSendMoreItemBySystemMailRsp rsp = IDIPPacket_DoSendMoreItemBySystemMailRsp.create();
/* 35 */     return new IDIPCmd_DoSendMoreItemBySystemMailReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoSendMoreItemBySystemMailReq create(IDIPPacket_DoSendMoreItemBySystemMailReq req, IDIPPacket_DoSendMoreItemBySystemMailRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoSendMoreItemBySystemMailReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoSendMoreItemBySystemMailReq(IDIPPacket_DoSendMoreItemBySystemMailReq req, IDIPPacket_DoSendMoreItemBySystemMailRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4215;
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
/* 62 */     return new PIDIPCmd_DoSendMoreItemBySystemMailReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoSendMoreItemBySystemMailReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */