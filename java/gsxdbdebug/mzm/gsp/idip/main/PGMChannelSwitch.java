/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.online.main.ForbidInfoManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGMChannelSwitch extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final String channel;
/*    */   private final boolean forbidden;
/*    */   
/*    */   public PGMChannelSwitch(long gmRoleId, String channel, int open)
/*    */   {
/* 15 */     this.gmRoleId = gmRoleId;
/* 16 */     this.channel = channel;
/* 17 */     this.forbidden = (open == 0);
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     boolean result = true;
/* 24 */     if (this.forbidden)
/*    */     {
/* 26 */       result = ForbidInfoManager.addForbiddenChannel(this.channel);
/*    */     }
/*    */     else
/*    */     {
/* 30 */       result = ForbidInfoManager.removeForbiddenChannel(this.channel);
/*    */     }
/* 32 */     if (result)
/*    */     {
/* 34 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("操作成功，%s为%s状态", new Object[] { this.channel, this.forbidden ? "关闭" : "开启" }));
/*    */     }
/*    */     else
/*    */     {
/* 38 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "重复操作");
/*    */     }
/* 40 */     return result;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGMChannelSwitch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */