/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoBanUsrReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoBanUsrReq
/*    */   extends IDIPCmd<IDIPPacket_DoBanUsrReq, IDIPPacket_DoBanUsrRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4123;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoBanUsrReq, IDIPPacket_DoBanUsrRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoBanUsrReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoBanUsrReq req, IDIPPacket_DoBanUsrRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoBanUsrReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoBanUsrReq create()
/*    */   {
/* 33 */     IDIPPacket_DoBanUsrReq req = IDIPPacket_DoBanUsrReq.create();
/* 34 */     IDIPPacket_DoBanUsrRsp rsp = IDIPPacket_DoBanUsrRsp.create();
/* 35 */     return new IDIPCmd_DoBanUsrReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoBanUsrReq create(IDIPPacket_DoBanUsrReq req, IDIPPacket_DoBanUsrRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoBanUsrReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoBanUsrReq(IDIPPacket_DoBanUsrReq req, IDIPPacket_DoBanUsrRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4123;
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
/* 62 */     return new PIDIPCmd_DoBanUsrReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoBanUsrReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */