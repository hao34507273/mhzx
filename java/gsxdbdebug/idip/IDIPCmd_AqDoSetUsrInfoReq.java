/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_AqDoSetUsrInfoReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_AqDoSetUsrInfoReq
/*    */   extends IDIPCmd<IDIPPacket_AqDoSetUsrInfoReq, IDIPPacket_AqDoSetUsrInfoRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4145;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_AqDoSetUsrInfoReq, IDIPPacket_AqDoSetUsrInfoRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_AqDoSetUsrInfoReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_AqDoSetUsrInfoReq req, IDIPPacket_AqDoSetUsrInfoRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_AqDoSetUsrInfoReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_AqDoSetUsrInfoReq create()
/*    */   {
/* 33 */     IDIPPacket_AqDoSetUsrInfoReq req = IDIPPacket_AqDoSetUsrInfoReq.create();
/* 34 */     IDIPPacket_AqDoSetUsrInfoRsp rsp = IDIPPacket_AqDoSetUsrInfoRsp.create();
/* 35 */     return new IDIPCmd_AqDoSetUsrInfoReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_AqDoSetUsrInfoReq create(IDIPPacket_AqDoSetUsrInfoReq req, IDIPPacket_AqDoSetUsrInfoRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_AqDoSetUsrInfoReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_AqDoSetUsrInfoReq(IDIPPacket_AqDoSetUsrInfoReq req, IDIPPacket_AqDoSetUsrInfoRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4145;
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
/* 62 */     return new PIDIPCmd_AqDoSetUsrInfoReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_AqDoSetUsrInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */