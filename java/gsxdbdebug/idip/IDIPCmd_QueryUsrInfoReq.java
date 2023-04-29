/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_QueryUsrInfoReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_QueryUsrInfoReq
/*    */   extends IDIPCmd<IDIPPacket_QueryUsrInfoReq, IDIPPacket_QueryUsrInfoRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4127;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_QueryUsrInfoReq, IDIPPacket_QueryUsrInfoRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_QueryUsrInfoReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_QueryUsrInfoReq req, IDIPPacket_QueryUsrInfoRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_QueryUsrInfoReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_QueryUsrInfoReq create()
/*    */   {
/* 33 */     IDIPPacket_QueryUsrInfoReq req = IDIPPacket_QueryUsrInfoReq.create();
/* 34 */     IDIPPacket_QueryUsrInfoRsp rsp = IDIPPacket_QueryUsrInfoRsp.create();
/* 35 */     return new IDIPCmd_QueryUsrInfoReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_QueryUsrInfoReq create(IDIPPacket_QueryUsrInfoReq req, IDIPPacket_QueryUsrInfoRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_QueryUsrInfoReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_QueryUsrInfoReq(IDIPPacket_QueryUsrInfoReq req, IDIPPacket_QueryUsrInfoRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4127;
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
/* 62 */     return new PIDIPCmd_QueryUsrInfoReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_QueryUsrInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */