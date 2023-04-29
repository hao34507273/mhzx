/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoMonitorBanLoginReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoMonitorBanLoginReq
/*    */   extends IDIPCmd<IDIPPacket_DoMonitorBanLoginReq, IDIPPacket_DoMonitorBanLoginRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4217;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoMonitorBanLoginReq, IDIPPacket_DoMonitorBanLoginRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoMonitorBanLoginReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoMonitorBanLoginReq req, IDIPPacket_DoMonitorBanLoginRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoMonitorBanLoginReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoMonitorBanLoginReq create()
/*    */   {
/* 33 */     IDIPPacket_DoMonitorBanLoginReq req = IDIPPacket_DoMonitorBanLoginReq.create();
/* 34 */     IDIPPacket_DoMonitorBanLoginRsp rsp = IDIPPacket_DoMonitorBanLoginRsp.create();
/* 35 */     return new IDIPCmd_DoMonitorBanLoginReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoMonitorBanLoginReq create(IDIPPacket_DoMonitorBanLoginReq req, IDIPPacket_DoMonitorBanLoginRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoMonitorBanLoginReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoMonitorBanLoginReq(IDIPPacket_DoMonitorBanLoginReq req, IDIPPacket_DoMonitorBanLoginRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4217;
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
/* 62 */     return new PIDIPCmd_DoMonitorBanLoginReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoMonitorBanLoginReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */