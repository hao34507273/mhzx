/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_QueryFunctionSwitchReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_QueryFunctionSwitchReq
/*    */   extends IDIPCmd<IDIPPacket_QueryFunctionSwitchReq, IDIPPacket_QueryFunctionSwitchRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4221;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_QueryFunctionSwitchReq, IDIPPacket_QueryFunctionSwitchRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_QueryFunctionSwitchReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_QueryFunctionSwitchReq req, IDIPPacket_QueryFunctionSwitchRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_QueryFunctionSwitchReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_QueryFunctionSwitchReq create()
/*    */   {
/* 33 */     IDIPPacket_QueryFunctionSwitchReq req = IDIPPacket_QueryFunctionSwitchReq.create();
/* 34 */     IDIPPacket_QueryFunctionSwitchRsp rsp = IDIPPacket_QueryFunctionSwitchRsp.create();
/* 35 */     return new IDIPCmd_QueryFunctionSwitchReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_QueryFunctionSwitchReq create(IDIPPacket_QueryFunctionSwitchReq req, IDIPPacket_QueryFunctionSwitchRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_QueryFunctionSwitchReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_QueryFunctionSwitchReq(IDIPPacket_QueryFunctionSwitchReq req, IDIPPacket_QueryFunctionSwitchRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4221;
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
/* 62 */     return new PIDIPCmd_QueryFunctionSwitchReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_QueryFunctionSwitchReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */