/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoUpdateVitalityReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoUpdateVitalityReq
/*    */   extends IDIPCmd<IDIPPacket_DoUpdateVitalityReq, IDIPPacket_DoUpdateVitalityRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4103;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoUpdateVitalityReq, IDIPPacket_DoUpdateVitalityRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoUpdateVitalityReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoUpdateVitalityReq req, IDIPPacket_DoUpdateVitalityRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoUpdateVitalityReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoUpdateVitalityReq create()
/*    */   {
/* 33 */     IDIPPacket_DoUpdateVitalityReq req = IDIPPacket_DoUpdateVitalityReq.create();
/* 34 */     IDIPPacket_DoUpdateVitalityRsp rsp = IDIPPacket_DoUpdateVitalityRsp.create();
/* 35 */     return new IDIPCmd_DoUpdateVitalityReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoUpdateVitalityReq create(IDIPPacket_DoUpdateVitalityReq req, IDIPPacket_DoUpdateVitalityRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoUpdateVitalityReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoUpdateVitalityReq(IDIPPacket_DoUpdateVitalityReq req, IDIPPacket_DoUpdateVitalityRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4103;
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
/* 62 */     return new PIDIPCmd_DoUpdateVitalityReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoUpdateVitalityReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */