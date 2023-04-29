/*     */ package mzm.gsp.bless.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.bless.SBlessFailed;
/*     */ import mzm.gsp.bless.SBlessSuccess;
/*     */ import mzm.gsp.bless.confbean.SBlessCfg;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCBless
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCBless(long roleid, int activityCfgid)
/*     */   {
/*  35 */     this.roleid = roleid;
/*  36 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     if (this.activityCfgid <= 0)
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     SBlessCfg blessCfg = SBlessCfg.get(this.activityCfgid);
/*  48 */     if (blessCfg == null)
/*     */     {
/*  50 */       onFailed(3);
/*     */     }
/*     */     
/*  53 */     if (!BlessManager.canDoAction(this.roleid, 1102))
/*     */     {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     if (!BlessManager.isFunOpen(this.roleid))
/*     */     {
/*  60 */       return false;
/*     */     }
/*     */     
/*  63 */     String userid = RoleInterface.getUserId(this.roleid);
/*  64 */     if (userid == null)
/*     */     {
/*  66 */       onFailed(2);
/*  67 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  71 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/*  73 */     if (!result.isCanJoin())
/*     */     {
/*  75 */       Map<String, Object> extras = new HashMap();
/*  76 */       extras.put("reason", Integer.valueOf(result.getReasonValue()));
/*  77 */       onFailed(-4, extras);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     xbean.BlessInfo xBlessInfo = BlessManager.getBlessInfo(this.roleid, this.activityCfgid);
/*  82 */     if (xBlessInfo == null)
/*     */     {
/*  84 */       onFailed(1);
/*  85 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  89 */     if (ItemInterface.isBagFull(this.roleid, 340600000, true))
/*     */     {
/*  91 */       onFailed(-2);
/*  92 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  96 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  97 */     BlessManager.checkBlessTime(xBlessInfo, now);
/*     */     
/*     */ 
/* 100 */     int blessNum = xBlessInfo.getNum();
/* 101 */     if (blessNum >= blessCfg.maxNum)
/*     */     {
/* 103 */       Map<String, Object> extras = new HashMap();
/* 104 */       extras.put("num", Integer.valueOf(blessNum));
/* 105 */       onFailed(-3, extras);
/* 106 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 110 */     xBlessInfo.setNum(blessNum + 1);
/* 111 */     xBlessInfo.setLast_time(now);
/*     */     
/*     */ 
/* 114 */     boolean free = false;
/* 115 */     if (blessNum < blessCfg.freeNum)
/*     */     {
/* 117 */       free = true;
/*     */     }
/*     */     
/* 120 */     int needItemNum = blessCfg.itemNum;
/* 121 */     int itemCfgid = blessCfg.itemCfgid;
/* 122 */     LogReason logReason = LogReason.BLESS;
/* 123 */     if (!free)
/*     */     {
/*     */ 
/* 126 */       int itemNum = ItemInterface.getItemNumberById(this.roleid, itemCfgid);
/* 127 */       if (itemNum < needItemNum)
/*     */       {
/* 129 */         onFailed(-1);
/* 130 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 134 */       TLogArg tLogArg = new TLogArg(logReason, this.activityCfgid);
/* 135 */       if (!ItemInterface.removeItemById(this.roleid, itemCfgid, needItemNum, tLogArg))
/*     */       {
/* 137 */         Map<String, Object> extras = new HashMap();
/* 138 */         extras.put("item_cfgid", Integer.valueOf(itemCfgid));
/* 139 */         extras.put("item_num", Integer.valueOf(needItemNum));
/* 140 */         onFailed(4, extras);
/* 141 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 146 */     int awardCfgid = blessCfg.awardCfgid;
/* 147 */     AwardReason awardReason = new AwardReason(logReason, awardCfgid);
/* 148 */     awardReason.setAwardItemBind(true);
/* 149 */     AwardModel awardModel = AwardInterface.awardFixAward(awardCfgid, userid, this.roleid, true, true, awardReason);
/* 150 */     if (awardModel == null)
/*     */     {
/*     */ 
/* 153 */       Map<String, Object> extras = new HashMap();
/* 154 */       extras.put("award_cfgid", Integer.valueOf(awardCfgid));
/* 155 */       onFailed(3, extras);
/* 156 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 160 */     ActivityInterface.addActivityCount(userid, this.roleid, this.activityCfgid);
/*     */     
/*     */ 
/* 163 */     BlessManager.addTLog(this.roleid, "BlessActiveJoinActivityForServer", new Object[] { Integer.valueOf(xBlessInfo.getNum()), Long.valueOf(xBlessInfo.getLast_time()), Integer.valueOf(free ? 1 : 0), Integer.valueOf(itemCfgid), Integer.valueOf(needItemNum), Integer.valueOf(awardCfgid), Integer.valueOf(this.activityCfgid) });
/*     */     
/*     */ 
/*     */ 
/* 167 */     ActivityInterface.logActivity(this.roleid, this.activityCfgid, ActivityLogStatus.FINISH);
/*     */     
/* 169 */     ActivityInterface.tlogActivity(this.roleid, this.activityCfgid, ActivityLogStatus.FINISH);
/*     */     
/*     */ 
/* 172 */     mzm.gsp.bless.BlessInfo blessInfo = new mzm.gsp.bless.BlessInfo();
/* 173 */     BlessManager.fillBlessInfo(blessInfo, xBlessInfo);
/* 174 */     SBlessSuccess rsp = new SBlessSuccess();
/* 175 */     rsp.activity_cfgid = this.activityCfgid;
/* 176 */     rsp.bless_info = blessInfo;
/* 177 */     OnlineManager.getInstance().send(this.roleid, rsp);
/*     */     
/* 179 */     GameServer.logger().info(String.format("[bless]PCBless.processImp@bless success|roleid=%d|activity_cfgid=%d|num=%d|free=%b", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(xBlessInfo.getNum()), Boolean.valueOf(free) }));
/*     */     
/*     */ 
/*     */ 
/* 183 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode)
/*     */   {
/* 188 */     onFailed(retcode, null);
/*     */   }
/*     */   
/*     */   private void onFailed(int retcode, Map<String, Object> extraParams)
/*     */   {
/* 193 */     SBlessFailed rsp = new SBlessFailed();
/* 194 */     rsp.activity_cfgid = this.activityCfgid;
/* 195 */     rsp.retcode = retcode;
/* 196 */     OnlineManager.getInstance().sendAtOnce(this.roleid, rsp);
/*     */     
/* 198 */     StringBuffer logBuilder = new StringBuffer();
/* 199 */     logBuilder.append("[bless]PCBless.onFailed@bless failed");
/* 200 */     logBuilder.append('|').append("roleid=").append(this.roleid);
/* 201 */     logBuilder.append('|').append("activity_cfgid=").append(this.activityCfgid);
/* 202 */     logBuilder.append('|').append("retcode=").append(retcode);
/*     */     
/* 204 */     if (extraParams != null)
/*     */     {
/* 206 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 208 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 212 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bless\main\PCBless.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */