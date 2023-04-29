/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import mzm.gsp.homeland.SSynRefreshFurnitureRes;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.HomeOperate;
/*    */ 
/*    */ public class PQueryFurnitureReq extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PQueryFurnitureReq(long roleId)
/*    */   {
/* 15 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     if (!HomelandManager.isHomeSwitchOpenForRole(this.roleId))
/*    */     {
/* 23 */       return false;
/*    */     }
/* 25 */     if (!HomelandManager.isRoleStateCanOperateHome(this.roleId))
/*    */     {
/* 27 */       String logStr = String.format("[home]PQueryFurnitureReq.processImp@role state can not operate home|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 29 */       HomelandManager.logger.info(logStr);
/* 30 */       return false;
/*    */     }
/* 32 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/* 33 */     if (userid == null)
/*    */     {
/* 35 */       String logString = String.format("[home]PQueryFurnitureReq.processImp@userid is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 37 */       HomelandManager.logger.error(logString);
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     HomeInfoWrapper homeInfoWrapper = HomelandManager.getHomeInfoWrapper(this.roleId);
/* 42 */     if (homeInfoWrapper == null)
/*    */     {
/* 44 */       String logString = String.format("[home]PQueryFurnitureReq.processImp@xHomeInfo is null|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*    */       
/* 46 */       HomelandManager.logger.warn(logString);
/*    */       
/* 48 */       return false;
/*    */     }
/* 50 */     boolean isOwner = this.roleId == homeInfoWrapper.getOwnerRoleId();
/* 51 */     long partnerRoleId = isOwner ? homeInfoWrapper.getPartnerRoleId() : homeInfoWrapper.getOwnerRoleId();
/*    */     
/* 53 */     long homeWorleId = homeInfoWrapper.getHomeWorldId();
/* 54 */     if (!HomelandManager.isAtHome(this.roleId, homeWorleId))
/*    */     {
/* 56 */       String logString = String.format("[home]PQueryFurnitureReq.processImp@role is not at home|roleId=%d|partenerRoleId=%d|homeWorleId=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(partnerRoleId), Long.valueOf(homeWorleId) });
/*    */       
/*    */ 
/*    */ 
/* 60 */       HomelandManager.logger.info(logString);
/* 61 */       return false;
/*    */     }
/*    */     
/* 64 */     HomeOperate xHomeOperate = HomelandManager.getXHomeOperate(this.roleId);
/*    */     
/* 66 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/* 67 */     HomelandManager.initHomeOperateCount(this.roleId, xHomeOperate, now);
/*    */     
/* 69 */     SSynRefreshFurnitureRes res = new SSynRefreshFurnitureRes();
/* 70 */     res.dayrefreshcount = xHomeOperate.getDayrefreshcount();
/* 71 */     res.canbuyitems.putAll(xHomeOperate.getCanbuyitem2num());
/*    */     
/* 73 */     OnlineManager.getInstance().send(this.roleId, res);
/*    */     
/* 75 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\PQueryFurnitureReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */