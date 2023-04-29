/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_QueryRoleActivityParticipationReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_QueryRoleActivityParticipationReq
/*    */   extends IDIPCmd<IDIPPacket_QueryRoleActivityParticipationReq, IDIPPacket_QueryRoleActivityParticipationRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4201;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_QueryRoleActivityParticipationReq, IDIPPacket_QueryRoleActivityParticipationRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_QueryRoleActivityParticipationReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_QueryRoleActivityParticipationReq req, IDIPPacket_QueryRoleActivityParticipationRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_QueryRoleActivityParticipationReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_QueryRoleActivityParticipationReq create()
/*    */   {
/* 33 */     IDIPPacket_QueryRoleActivityParticipationReq req = IDIPPacket_QueryRoleActivityParticipationReq.create();
/* 34 */     IDIPPacket_QueryRoleActivityParticipationRsp rsp = IDIPPacket_QueryRoleActivityParticipationRsp.create();
/* 35 */     return new IDIPCmd_QueryRoleActivityParticipationReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_QueryRoleActivityParticipationReq create(IDIPPacket_QueryRoleActivityParticipationReq req, IDIPPacket_QueryRoleActivityParticipationRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_QueryRoleActivityParticipationReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_QueryRoleActivityParticipationReq(IDIPPacket_QueryRoleActivityParticipationReq req, IDIPPacket_QueryRoleActivityParticipationRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4201;
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
/* 62 */     return new PIDIPCmd_QueryRoleActivityParticipationReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_QueryRoleActivityParticipationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */