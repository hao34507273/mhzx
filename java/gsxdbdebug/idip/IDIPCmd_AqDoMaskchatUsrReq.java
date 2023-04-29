/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_AqDoMaskchatUsrReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_AqDoMaskchatUsrReq
/*    */   extends IDIPCmd<IDIPPacket_AqDoMaskchatUsrReq, IDIPPacket_AqDoMaskchatUsrRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4157;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_AqDoMaskchatUsrReq, IDIPPacket_AqDoMaskchatUsrRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_AqDoMaskchatUsrReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_AqDoMaskchatUsrReq req, IDIPPacket_AqDoMaskchatUsrRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_AqDoMaskchatUsrReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_AqDoMaskchatUsrReq create()
/*    */   {
/* 33 */     IDIPPacket_AqDoMaskchatUsrReq req = IDIPPacket_AqDoMaskchatUsrReq.create();
/* 34 */     IDIPPacket_AqDoMaskchatUsrRsp rsp = IDIPPacket_AqDoMaskchatUsrRsp.create();
/* 35 */     return new IDIPCmd_AqDoMaskchatUsrReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_AqDoMaskchatUsrReq create(IDIPPacket_AqDoMaskchatUsrReq req, IDIPPacket_AqDoMaskchatUsrRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_AqDoMaskchatUsrReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_AqDoMaskchatUsrReq(IDIPPacket_AqDoMaskchatUsrReq req, IDIPPacket_AqDoMaskchatUsrRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4157;
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
/* 62 */     return new PIDIPCmd_AqDoMaskchatUsrReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_AqDoMaskchatUsrReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */