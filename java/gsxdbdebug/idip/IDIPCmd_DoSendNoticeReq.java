/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoSendNoticeReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoSendNoticeReq
/*    */   extends IDIPCmd<IDIPPacket_DoSendNoticeReq, IDIPPacket_DoSendNoticeRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4185;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoSendNoticeReq, IDIPPacket_DoSendNoticeRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoSendNoticeReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoSendNoticeReq req, IDIPPacket_DoSendNoticeRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoSendNoticeReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoSendNoticeReq create()
/*    */   {
/* 33 */     IDIPPacket_DoSendNoticeReq req = IDIPPacket_DoSendNoticeReq.create();
/* 34 */     IDIPPacket_DoSendNoticeRsp rsp = IDIPPacket_DoSendNoticeRsp.create();
/* 35 */     return new IDIPCmd_DoSendNoticeReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoSendNoticeReq create(IDIPPacket_DoSendNoticeReq req, IDIPPacket_DoSendNoticeRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoSendNoticeReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoSendNoticeReq(IDIPPacket_DoSendNoticeReq req, IDIPPacket_DoSendNoticeRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4185;
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
/* 62 */     return new PIDIPCmd_DoSendNoticeReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoSendNoticeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */