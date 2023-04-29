/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_AqDoRolelistDataReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_AqDoRolelistDataReq
/*    */   extends IDIPCmd<IDIPPacket_AqDoRolelistDataReq, IDIPPacket_AqDoRolelistDataRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4153;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_AqDoRolelistDataReq, IDIPPacket_AqDoRolelistDataRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_AqDoRolelistDataReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_AqDoRolelistDataReq req, IDIPPacket_AqDoRolelistDataRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_AqDoRolelistDataReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_AqDoRolelistDataReq create()
/*    */   {
/* 33 */     IDIPPacket_AqDoRolelistDataReq req = IDIPPacket_AqDoRolelistDataReq.create();
/* 34 */     IDIPPacket_AqDoRolelistDataRsp rsp = IDIPPacket_AqDoRolelistDataRsp.create();
/* 35 */     return new IDIPCmd_AqDoRolelistDataReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_AqDoRolelistDataReq create(IDIPPacket_AqDoRolelistDataReq req, IDIPPacket_AqDoRolelistDataRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_AqDoRolelistDataReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_AqDoRolelistDataReq(IDIPPacket_AqDoRolelistDataReq req, IDIPPacket_AqDoRolelistDataRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4153;
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
/* 62 */     return new PIDIPCmd_AqDoRolelistDataReq(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_AqDoRolelistDataReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */