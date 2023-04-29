/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoUpdateReputationReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoUpdateReputationReq
/*    */   extends IDIPCmd<IDIPPacket_DoUpdateReputationReq, IDIPPacket_DoUpdateReputationRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4109;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoUpdateReputationReq, IDIPPacket_DoUpdateReputationRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoUpdateReputationReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoUpdateReputationReq req, IDIPPacket_DoUpdateReputationRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoUpdateReputationReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoUpdateReputationReq create()
/*    */   {
/* 33 */     IDIPPacket_DoUpdateReputationReq req = IDIPPacket_DoUpdateReputationReq.create();
/* 34 */     IDIPPacket_DoUpdateReputationRsp rsp = IDIPPacket_DoUpdateReputationRsp.create();
/* 35 */     return new IDIPCmd_DoUpdateReputationReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoUpdateReputationReq create(IDIPPacket_DoUpdateReputationReq req, IDIPPacket_DoUpdateReputationRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoUpdateReputationReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoUpdateReputationReq(IDIPPacket_DoUpdateReputationReq req, IDIPPacket_DoUpdateReputationRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4109;
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
/* 62 */     return new PIDIPCmd_DoUpdateReputationReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoUpdateReputationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */