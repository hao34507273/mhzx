/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGMProtocolSwitch extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final int protocolId;
/*    */   private final boolean forbidden;
/*    */   
/*    */   public PGMProtocolSwitch(long gmRoleId, int protocolId, int open)
/*    */   {
/* 15 */     this.gmRoleId = gmRoleId;
/* 16 */     this.protocolId = protocolId;
/* 17 */     this.forbidden = (open == 0);
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     boolean result = true;
/* 24 */     if (this.forbidden)
/*    */     {
/* 26 */       result = GameServerInfoManager.addDisableProtocol(this.protocolId);
/*    */     }
/*    */     else
/*    */     {
/* 30 */       result = GameServerInfoManager.removeDisableProtocol(this.protocolId);
/*    */     }
/*    */     
/* 33 */     if (result)
/*    */     {
/* 35 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("操作成功，协议%d目前为%s状态", new Object[] { Integer.valueOf(this.protocolId), this.forbidden ? "关闭" : "开启" }));
/*    */ 
/*    */     }
/*    */     else
/*    */     {
/* 40 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "操作失败");
/*    */     }
/* 42 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGMProtocolSwitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */