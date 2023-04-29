/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoUpdateHisContributionReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoUpdateHisContributionReq
/*    */   extends IDIPCmd<IDIPPacket_DoUpdateHisContributionReq, IDIPPacket_DoUpdateHisContributionRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4105;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoUpdateHisContributionReq, IDIPPacket_DoUpdateHisContributionRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoUpdateHisContributionReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoUpdateHisContributionReq req, IDIPPacket_DoUpdateHisContributionRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoUpdateHisContributionReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoUpdateHisContributionReq create()
/*    */   {
/* 33 */     IDIPPacket_DoUpdateHisContributionReq req = IDIPPacket_DoUpdateHisContributionReq.create();
/* 34 */     IDIPPacket_DoUpdateHisContributionRsp rsp = IDIPPacket_DoUpdateHisContributionRsp.create();
/* 35 */     return new IDIPCmd_DoUpdateHisContributionReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoUpdateHisContributionReq create(IDIPPacket_DoUpdateHisContributionReq req, IDIPPacket_DoUpdateHisContributionRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoUpdateHisContributionReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoUpdateHisContributionReq(IDIPPacket_DoUpdateHisContributionReq req, IDIPPacket_DoUpdateHisContributionRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4105;
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
/* 62 */     return new PIDIPCmd_DoUpdateHisContributionReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoUpdateHisContributionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */