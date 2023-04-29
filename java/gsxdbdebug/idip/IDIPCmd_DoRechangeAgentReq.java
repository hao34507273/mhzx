/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_DoRechangeAgentReq
/*    */   extends IDIPCmd<IDIPPacket_DoRechangeAgentReq, IDIPPacket_DoRechangeAgentRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4213;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_DoRechangeAgentReq, IDIPPacket_DoRechangeAgentRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_DoRechangeAgentReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_DoRechangeAgentReq req, IDIPPacket_DoRechangeAgentRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_DoRechangeAgentReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_DoRechangeAgentReq create()
/*    */   {
/* 33 */     IDIPPacket_DoRechangeAgentReq req = IDIPPacket_DoRechangeAgentReq.create();
/* 34 */     IDIPPacket_DoRechangeAgentRsp rsp = IDIPPacket_DoRechangeAgentRsp.create();
/* 35 */     return new IDIPCmd_DoRechangeAgentReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_DoRechangeAgentReq create(IDIPPacket_DoRechangeAgentReq req, IDIPPacket_DoRechangeAgentRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_DoRechangeAgentReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_DoRechangeAgentReq(IDIPPacket_DoRechangeAgentReq req, IDIPPacket_DoRechangeAgentRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4213;
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
/* 62 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_DoRechangeAgentReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */