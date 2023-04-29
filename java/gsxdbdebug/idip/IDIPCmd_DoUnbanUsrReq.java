/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_DoUnbanUsrReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoUnbanUsrReq
/*    */   extends IDIPCmd<IDIPPacket_DoUnbanUsrReq, IDIPPacket_DoUnbanUsrRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4125;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoUnbanUsrReq, IDIPPacket_DoUnbanUsrRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoUnbanUsrReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoUnbanUsrReq req, IDIPPacket_DoUnbanUsrRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoUnbanUsrReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoUnbanUsrReq create()
/*    */   {
/* 33 */     IDIPPacket_DoUnbanUsrReq req = IDIPPacket_DoUnbanUsrReq.create();
/* 34 */     IDIPPacket_DoUnbanUsrRsp rsp = IDIPPacket_DoUnbanUsrRsp.create();
/* 35 */     return new IDIPCmd_DoUnbanUsrReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoUnbanUsrReq create(IDIPPacket_DoUnbanUsrReq req, IDIPPacket_DoUnbanUsrRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoUnbanUsrReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoUnbanUsrReq(IDIPPacket_DoUnbanUsrReq req, IDIPPacket_DoUnbanUsrRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4125;
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
/* 62 */     return new PIDIPCmd_DoUnbanUsrReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoUnbanUsrReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */