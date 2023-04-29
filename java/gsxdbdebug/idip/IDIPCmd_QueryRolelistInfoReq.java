/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_QueryRolelistInfoReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_QueryRolelistInfoReq
/*    */   extends IDIPCmd<IDIPPacket_QueryRolelistInfoReq, IDIPPacket_QueryRolelistInfoRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4149;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_QueryRolelistInfoReq, IDIPPacket_QueryRolelistInfoRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_QueryRolelistInfoReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_QueryRolelistInfoReq req, IDIPPacket_QueryRolelistInfoRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_QueryRolelistInfoReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_QueryRolelistInfoReq create()
/*    */   {
/* 33 */     IDIPPacket_QueryRolelistInfoReq req = IDIPPacket_QueryRolelistInfoReq.create();
/* 34 */     IDIPPacket_QueryRolelistInfoRsp rsp = IDIPPacket_QueryRolelistInfoRsp.create();
/* 35 */     return new IDIPCmd_QueryRolelistInfoReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_QueryRolelistInfoReq create(IDIPPacket_QueryRolelistInfoReq req, IDIPPacket_QueryRolelistInfoRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_QueryRolelistInfoReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_QueryRolelistInfoReq(IDIPPacket_QueryRolelistInfoReq req, IDIPPacket_QueryRolelistInfoRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4149;
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
/* 62 */     return new PIDIPCmd_QueryRolelistInfoReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_QueryRolelistInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */