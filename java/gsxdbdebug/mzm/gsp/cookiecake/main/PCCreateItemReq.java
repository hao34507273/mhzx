/*     */ package mzm.gsp.cookiecake.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.confbean.SActivityCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.cookiecake.SCreateItemFail;
/*     */ import mzm.gsp.cookiecake.SCreateItemSuccess;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.midautumnholiday.confbean.SComposeCfg;
/*     */ import mzm.gsp.midautumnholiday.confbean.SCookieCakeCfg;
/*     */ import mzm.gsp.midautumnholiday.confbean.SCreateCostInfo;
/*     */ import mzm.gsp.midautumnholiday.confbean.SCreateInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCCreateItemReq extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int createItemCfgid;
/*     */   private final int actionType;
/*     */   
/*     */   public PCCreateItemReq(long roleid, int activityCfgid, int createItemCfgid, int actionType)
/*     */   {
/*  34 */     this.roleid = roleid;
/*  35 */     this.activityCfgid = activityCfgid;
/*  36 */     this.createItemCfgid = createItemCfgid;
/*  37 */     this.actionType = actionType;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  46 */     if (this.activityCfgid <= 0)
/*     */     {
/*  48 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  53 */     SCookieCakeCfg sCookieCakeCfg = SCookieCakeCfg.get(this.activityCfgid);
/*  54 */     if (sCookieCakeCfg == null)
/*     */     {
/*  56 */       onFailed(3);
/*  57 */       return false;
/*     */     }
/*  59 */     SComposeCfg sComposeCfg = SComposeCfg.get(sCookieCakeCfg.composeGroupId);
/*  60 */     if (sComposeCfg == null)
/*     */     {
/*  62 */       onFailed(3);
/*  63 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  68 */     SCreateCostInfo sCreateCostInfo = (SCreateCostInfo)sComposeCfg.createInfoMap.createItemId2CreateCostInfo.get(Integer.valueOf(this.createItemCfgid));
/*  69 */     if (sCreateCostInfo == null)
/*     */     {
/*  71 */       onFailed(4);
/*  72 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  78 */     if (!CookieCakeManager.isFunOpen(this.roleid, sCookieCakeCfg.openId))
/*     */     {
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     String userid = RoleInterface.getUserId(this.roleid);
/*  84 */     if (userid == null)
/*     */     {
/*  86 */       onFailed(2);
/*  87 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  92 */     lock(Lockeys.get(User.getTable(), userid));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  97 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 1871, true, true))
/*     */     {
/*  99 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 104 */     if (ItemInterface.isBagFull(this.roleid, 340600000, true))
/*     */     {
/* 106 */       onFailed(6);
/* 107 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 114 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/* 116 */     if (!result.isCanJoin())
/*     */     {
/* 118 */       Map<String, Object> extras = new HashMap();
/* 119 */       extras.put("reason", Integer.valueOf(result.getReasonValue()));
/* 120 */       onFailed(5, extras);
/* 121 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 127 */     int createNum = CookieCakeManager.getMaxCreateNum(this.roleid, sCreateCostInfo);
/* 128 */     if (this.actionType == 1)
/*     */     {
/* 130 */       createNum = Math.min(1, createNum);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 135 */     int maxActivityCount = ActivityInterface.getActivityCfg(this.activityCfgid).count;
/* 136 */     if (maxActivityCount > 0)
/*     */     {
/* 138 */       int currentActivityCount = ActivityInterface.getActivityCount(userid, this.roleid, this.activityCfgid, true);
/* 139 */       createNum = Math.min(maxActivityCount - currentActivityCount, createNum);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 144 */     if (!CookieCakeManager.createItem(this.roleid, sCreateCostInfo, createNum))
/*     */     {
/* 146 */       onFailed(7);
/* 147 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 155 */     ActivityInterface.addActivityCount(userid, this.roleid, this.activityCfgid, createNum);
/*     */     
/*     */ 
/* 158 */     ActivityInterface.logActivity(this.roleid, this.activityCfgid, ActivityLogStatus.FINISH);
/*     */     
/* 160 */     ActivityInterface.tlogActivity(this.roleid, this.activityCfgid, ActivityLogStatus.FINISH);
/*     */     
/* 162 */     CookieCakeTLogManager.tlogCookieCake(this.roleid, this.activityCfgid, this.createItemCfgid, this.actionType, createNum);
/*     */     
/*     */ 
/* 165 */     SCreateItemSuccess sCreateItemSuccess = new SCreateItemSuccess();
/* 166 */     sCreateItemSuccess.activity_id = this.activityCfgid;
/* 167 */     sCreateItemSuccess.create_item_id = this.createItemCfgid;
/* 168 */     sCreateItemSuccess.create_num = createNum;
/* 169 */     sCreateItemSuccess.action_type = this.actionType;
/* 170 */     OnlineManager.getInstance().send(this.roleid, sCreateItemSuccess);
/*     */     
/* 172 */     GameServer.logger().info(String.format("[cookiecake]PCCreateItemReq.processImp@ success|roleid=%d|activity_cfgid=%d|create_item_id=%d|action_type=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.createItemCfgid), Integer.valueOf(this.actionType) }));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 177 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 182 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 193 */     SCreateItemFail rsp = new SCreateItemFail();
/* 194 */     rsp.activity_id = this.activityCfgid;
/* 195 */     rsp.create_item_id = this.createItemCfgid;
/* 196 */     rsp.action_type = this.actionType;
/* 197 */     rsp.error_code = retcode;
/* 198 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 200 */     StringBuffer logBuilder = new StringBuffer();
/* 201 */     logBuilder.append("[cookiecake]PCCreateItemReq.onFailed@ failed");
/* 202 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 203 */     logBuilder.append('|').append("activity_id=").append(this.activityCfgid);
/* 204 */     logBuilder.append('|').append("create_item_id=").append(this.createItemCfgid);
/* 205 */     logBuilder.append('|').append("action_type=").append(this.actionType);
/* 206 */     logBuilder.append('|').append("error_code=").append(retcode);
/*     */     
/* 208 */     if (extraParams != null)
/*     */     {
/* 210 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 212 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 216 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cookiecake\main\PCCreateItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */