/*    */ package idip;
/*    */ 
/*    */ import idip.core.IDIPCmd;
/*    */ import idip.core.IDIPCmdCreator;
/*    */ import mzm.gsp.idip.main.PIDIPCmd_QueryRoleAchievement;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IDIPCmd_QueryRoleArchivementReq
/*    */   extends IDIPCmd<IDIPPacket_QueryRoleArchivementReq, IDIPPacket_QueryRoleArchivementRsp>
/*    */ {
/*    */   public static final int IDIP_CMD_ID = 4223;
/*    */   
/*    */   public static class Creator
/*    */     implements IDIPCmdCreator<IDIPPacket_QueryRoleArchivementReq, IDIPPacket_QueryRoleArchivementRsp>
/*    */   {
/*    */     public IDIPCmd<?, ?> create()
/*    */     {
/* 19 */       return IDIPCmd_QueryRoleArchivementReq.create();
/*    */     }
/*    */     
/*    */ 
/*    */     public IDIPCmd<?, ?> create(IDIPPacket_QueryRoleArchivementReq req, IDIPPacket_QueryRoleArchivementRsp rsp)
/*    */     {
/* 25 */       return IDIPCmd_QueryRoleArchivementReq.create(req, rsp);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static IDIPCmd_QueryRoleArchivementReq create()
/*    */   {
/* 33 */     IDIPPacket_QueryRoleArchivementReq req = IDIPPacket_QueryRoleArchivementReq.create();
/* 34 */     IDIPPacket_QueryRoleArchivementRsp rsp = IDIPPacket_QueryRoleArchivementRsp.create();
/* 35 */     return new IDIPCmd_QueryRoleArchivementReq(req, rsp);
/*    */   }
/*    */   
/*    */   public static IDIPCmd_QueryRoleArchivementReq create(IDIPPacket_QueryRoleArchivementReq req, IDIPPacket_QueryRoleArchivementRsp rsp)
/*    */   {
/* 40 */     return new IDIPCmd_QueryRoleArchivementReq(req, rsp);
/*    */   }
/*    */   
/*    */   public IDIPCmd_QueryRoleArchivementReq(IDIPPacket_QueryRoleArchivementReq req, IDIPPacket_QueryRoleArchivementRsp rsp)
/*    */   {
/* 45 */     super(req, rsp);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCmdID()
/*    */   {
/* 51 */     return 4223;
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
/* 62 */     return new PIDIPCmd_QueryRoleAchievement(this).call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\idip\IDIPCmd_QueryRoleArchivementReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */