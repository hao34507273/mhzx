/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_GeneralCommandReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_GeneralCommandReq
/*    */   extends IDIPCmd<IDIPPacket_GeneralCommandReq, IDIPPacket_GeneralCommandRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4175;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_GeneralCommandReq, IDIPPacket_GeneralCommandRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_GeneralCommandReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_GeneralCommandReq req, IDIPPacket_GeneralCommandRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_GeneralCommandReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_GeneralCommandReq create()
/*    */   {
/* 33 */     IDIPPacket_GeneralCommandReq req = IDIPPacket_GeneralCommandReq.create();
/* 34 */     IDIPPacket_GeneralCommandRsp rsp = IDIPPacket_GeneralCommandRsp.create();
/* 35 */     return new IDIPCmd_GeneralCommandReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_GeneralCommandReq create(IDIPPacket_GeneralCommandReq req, IDIPPacket_GeneralCommandRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_GeneralCommandReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_GeneralCommandReq(IDIPPacket_GeneralCommandReq req, IDIPPacket_GeneralCommandRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4175;
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
/* 62 */     PIDIPCmd_GeneralCommandReq proc = PIDIPCmd_GeneralCommandReq.getGeneralCommandReqProcedure(this);
/* 63 */     if (proc == null)
/*    */     {
/* 65 */       return false;
/*    */     }
/*    */     
/* 68 */     return proc.call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_GeneralCommandReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */