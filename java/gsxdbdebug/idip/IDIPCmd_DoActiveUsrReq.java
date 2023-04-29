/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoActiveUsrReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoActiveUsrReq
/*    */   extends IDIPCmd<IDIPPacket_DoActiveUsrReq, IDIPPacket_DoActiveUsrRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4121;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoActiveUsrReq, IDIPPacket_DoActiveUsrRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoActiveUsrReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoActiveUsrReq req, IDIPPacket_DoActiveUsrRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoActiveUsrReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoActiveUsrReq create()
/*    */   {
/* 33 */     IDIPPacket_DoActiveUsrReq req = IDIPPacket_DoActiveUsrReq.create();
/* 34 */     IDIPPacket_DoActiveUsrRsp rsp = IDIPPacket_DoActiveUsrRsp.create();
/* 35 */     return new IDIPCmd_DoActiveUsrReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoActiveUsrReq create(IDIPPacket_DoActiveUsrReq req, IDIPPacket_DoActiveUsrRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoActiveUsrReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoActiveUsrReq(IDIPPacket_DoActiveUsrReq req, IDIPPacket_DoActiveUsrRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4121;
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
/* 62 */     return new PIDIPCmd_DoActiveUsrReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoActiveUsrReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */