/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoUpdateGangContributionReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoUpdateGangContributionReq
/*    */   extends IDIPCmd<IDIPPacket_DoUpdateGangContributionReq, IDIPPacket_DoUpdateGangContributionRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4111;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoUpdateGangContributionReq, IDIPPacket_DoUpdateGangContributionRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoUpdateGangContributionReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoUpdateGangContributionReq req, IDIPPacket_DoUpdateGangContributionRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoUpdateGangContributionReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoUpdateGangContributionReq create()
/*    */   {
/* 33 */     IDIPPacket_DoUpdateGangContributionReq req = IDIPPacket_DoUpdateGangContributionReq.create();
/* 34 */     IDIPPacket_DoUpdateGangContributionRsp rsp = IDIPPacket_DoUpdateGangContributionRsp.create();
/* 35 */     return new IDIPCmd_DoUpdateGangContributionReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoUpdateGangContributionReq create(IDIPPacket_DoUpdateGangContributionReq req, IDIPPacket_DoUpdateGangContributionRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoUpdateGangContributionReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoUpdateGangContributionReq(IDIPPacket_DoUpdateGangContributionReq req, IDIPPacket_DoUpdateGangContributionRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4111;
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
/* 62 */     return new PIDIPCmd_DoUpdateGangContributionReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoUpdateGangContributionReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */