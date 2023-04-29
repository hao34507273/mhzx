/*    */ package mzm.gsp.title.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import xbean.AppellationInfo;
/*    */ import xbean.TitleAppellation;
/*    */ import xtable.Role2titleappellation;
/*    */ 
/*    */ public class PChangePropertyReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int appellationCfgId;
/*    */   
/*    */   public PChangePropertyReq(long roleId, int appellationCfgId)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.appellationCfgId = appellationCfgId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 229, true))
/*    */     {
/* 24 */       return false;
/*    */     }
/* 26 */     TitleAppellation xTitleAppellation = Role2titleappellation.get(Long.valueOf(this.roleId));
/* 27 */     if (xTitleAppellation == null)
/*    */     {
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     AppellationInfo xAppellationInfo = (AppellationInfo)xTitleAppellation.getAppellations().get(Integer.valueOf(this.appellationCfgId));
/* 33 */     if (xAppellationInfo == null)
/*    */     {
/* 35 */       TitleManager.logger.error(String.format("[title]PChangePropertyReq.processImp@appellation not found in role data!|role_id=%d|appellation_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.appellationCfgId) }));
/*    */       
/*    */ 
/* 38 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 42 */     long timeOut = xAppellationInfo.getTimeout();
/* 43 */     if (timeOut != 0L)
/*    */     {
/* 45 */       if (timeOut < mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis())
/*    */       {
/* 47 */         return false;
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 52 */     if (!TitleManager.checkAppellationOccupation("PChangePropertyReq.processImp", this.roleId, this.appellationCfgId))
/*    */     {
/* 54 */       return false;
/*    */     }
/*    */     
/* 57 */     TitleManager.changeProAppId(this.roleId, this.appellationCfgId, xTitleAppellation);
/* 58 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\PChangePropertyReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */