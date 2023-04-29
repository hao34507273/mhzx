/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_QueryRoleInfoReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_QueryRoleInfoReq
/*    */   extends IDIPCmd<IDIPPacket_QueryRoleInfoReq, IDIPPacket_QueryRoleInfoRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4129;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_QueryRoleInfoReq, IDIPPacket_QueryRoleInfoRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_QueryRoleInfoReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_QueryRoleInfoReq req, IDIPPacket_QueryRoleInfoRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_QueryRoleInfoReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_QueryRoleInfoReq create()
/*    */   {
/* 33 */     IDIPPacket_QueryRoleInfoReq req = IDIPPacket_QueryRoleInfoReq.create();
/* 34 */     IDIPPacket_QueryRoleInfoRsp rsp = IDIPPacket_QueryRoleInfoRsp.create();
/* 35 */     return new IDIPCmd_QueryRoleInfoReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_QueryRoleInfoReq create(IDIPPacket_QueryRoleInfoReq req, IDIPPacket_QueryRoleInfoRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_QueryRoleInfoReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_QueryRoleInfoReq(IDIPPacket_QueryRoleInfoReq req, IDIPPacket_QueryRoleInfoRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4129;
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
/* 62 */     return new PIDIPCmd_QueryRoleInfoReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_QueryRoleInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */