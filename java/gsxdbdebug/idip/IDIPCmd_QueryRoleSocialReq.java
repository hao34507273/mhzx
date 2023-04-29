/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_QueryRoleSocialReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_QueryRoleSocialReq
/*    */   extends IDIPCmd<IDIPPacket_QueryRoleSocialReq, IDIPPacket_QueryRoleSocialRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4203;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_QueryRoleSocialReq, IDIPPacket_QueryRoleSocialRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_QueryRoleSocialReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_QueryRoleSocialReq req, IDIPPacket_QueryRoleSocialRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_QueryRoleSocialReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_QueryRoleSocialReq create()
/*    */   {
/* 33 */     IDIPPacket_QueryRoleSocialReq req = IDIPPacket_QueryRoleSocialReq.create();
/* 34 */     IDIPPacket_QueryRoleSocialRsp rsp = IDIPPacket_QueryRoleSocialRsp.create();
/* 35 */     return new IDIPCmd_QueryRoleSocialReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_QueryRoleSocialReq create(IDIPPacket_QueryRoleSocialReq req, IDIPPacket_QueryRoleSocialRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_QueryRoleSocialReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_QueryRoleSocialReq(IDIPPacket_QueryRoleSocialReq req, IDIPPacket_QueryRoleSocialRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4203;
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
/* 62 */     return new PIDIPCmd_QueryRoleSocialReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_QueryRoleSocialReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */