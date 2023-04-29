/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoAddRechargeIntegralReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoAddRechargeIntegralReq
/*    */   extends IDIPCmd<IDIPPacket_DoAddRechargeIntegralReq, IDIPPacket_DoAddRechargeIntegralRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4219;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoAddRechargeIntegralReq, IDIPPacket_DoAddRechargeIntegralRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoAddRechargeIntegralReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoAddRechargeIntegralReq req, IDIPPacket_DoAddRechargeIntegralRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoAddRechargeIntegralReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoAddRechargeIntegralReq create()
/*    */   {
/* 33 */     IDIPPacket_DoAddRechargeIntegralReq req = IDIPPacket_DoAddRechargeIntegralReq.create();
/* 34 */     IDIPPacket_DoAddRechargeIntegralRsp rsp = IDIPPacket_DoAddRechargeIntegralRsp.create();
/* 35 */     return new IDIPCmd_DoAddRechargeIntegralReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoAddRechargeIntegralReq create(IDIPPacket_DoAddRechargeIntegralReq req, IDIPPacket_DoAddRechargeIntegralRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoAddRechargeIntegralReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoAddRechargeIntegralReq(IDIPPacket_DoAddRechargeIntegralReq req, IDIPPacket_DoAddRechargeIntegralRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4219;
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
/* 62 */     return new PIDIPCmd_DoAddRechargeIntegralReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoAddRechargeIntegralReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */