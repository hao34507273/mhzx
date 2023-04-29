/*     */ package mzm.gsp.personal.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.common.TimeCommonUtil;
/*     */ import mzm.gsp.common.confbean.STimeCommonCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.personal.SPraisePersonalFailed;
/*     */ import mzm.gsp.personal.SPraisePersonalSuccess;
/*     */ import mzm.gsp.personal.confbean.PersonalConsts;
/*     */ import mzm.gsp.personal.event.PersonalPraise;
/*     */ import mzm.gsp.personal.event.PersonalPraiseArg;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PersonalInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.PraiseInfo;
/*     */ import xbean.PraiseRecord;
/*     */ import xtable.Role2personal;
/*     */ 
/*     */ public class PCPraisePersonal extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long targetRoleId;
/*     */   
/*     */   public PCPraisePersonal(long roleId, long targetRoleId)
/*     */   {
/*  31 */     this.roleId = roleId;
/*  32 */     this.targetRoleId = targetRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!PersonalManager.isFunOpen(this.roleId))
/*     */     {
/*  40 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  44 */     if (!PersonalManager.checkRoleStatus(this.roleId))
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  50 */     if (this.roleId == this.targetRoleId)
/*     */     {
/*  52 */       onFailed(6);
/*  53 */       return false;
/*     */     }
/*     */     
/*  56 */     if (!mzm.gsp.role.main.RoleInterface.isRoleExist(this.targetRoleId, false))
/*     */     {
/*  58 */       onFailed(0);
/*  59 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  63 */     lock(xdb.Lockeys.get(Role2personal.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId) })));
/*     */     
/*     */ 
/*  66 */     PersonalInfo xTargetPersonalInfo = Role2personal.get(Long.valueOf(this.targetRoleId));
/*  67 */     if (xTargetPersonalInfo == null)
/*     */     {
/*  69 */       onFailed(5);
/*  70 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  74 */     int maxNum = PersonalConsts.getInstance().PRAISE_MAX;
/*  75 */     if (xTargetPersonalInfo.getPraise().getBe_praised_num() >= maxNum)
/*     */     {
/*  77 */       onFailed(9);
/*  78 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  82 */     PersonalInfo xPersonalInfo = Role2personal.get(Long.valueOf(this.roleId));
/*  83 */     if (xPersonalInfo == null)
/*     */     {
/*  85 */       xPersonalInfo = Pod.newPersonalInfo();
/*  86 */       PersonalManager.initXPersonalInfo(this.roleId, xPersonalInfo);
/*  87 */       Role2personal.insert(Long.valueOf(this.roleId), xPersonalInfo);
/*     */     }
/*     */     
/*     */ 
/*  91 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  92 */     long lastPraiseTime = xPersonalInfo.getPraise().getPraise_timestamp();
/*  93 */     STimeCommonCfg sTimeCommonCfg = TimeCommonUtil.getCommonCfg(PersonalConsts.getInstance().PRAISE_CLEAR_TIME);
/*  94 */     if (DateTimeUtils.needDailyReset(lastPraiseTime, now, sTimeCommonCfg.activeHour, sTimeCommonCfg.activeMinute))
/*     */     {
/*  96 */       xPersonalInfo.getPraise().getPraise_records().clear();
/*     */     }
/*     */     
/*     */ 
/* 100 */     int todayPraiseNum = getTodayPraiseNum(xPersonalInfo);
/* 101 */     if (todayPraiseNum >= PersonalConsts.getInstance().DAYLIY_PRAISE_MAX)
/*     */     {
/* 103 */       onFailed(8);
/* 104 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 108 */     PraiseRecord xPraiseRecord = (PraiseRecord)xPersonalInfo.getPraise().getPraise_records().get(Long.valueOf(this.targetRoleId));
/* 109 */     if ((xPraiseRecord != null) && (xPraiseRecord.getNum() >= PersonalConsts.getInstance().DAYLIY_PRAISE_ROLE_MAX))
/*     */     {
/* 111 */       onFailed(7);
/* 112 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 116 */     if (xPraiseRecord == null)
/*     */     {
/* 118 */       xPraiseRecord = Pod.newPraiseRecord();
/* 119 */       xPersonalInfo.getPraise().getPraise_records().put(Long.valueOf(this.targetRoleId), xPraiseRecord);
/*     */     }
/* 121 */     xPraiseRecord.setNum(xPraiseRecord.getNum() + 1);
/* 122 */     xPersonalInfo.getPraise().setPraise_timestamp(now);
/* 123 */     int newPraisedNum = xPersonalInfo.getPraise().getPraised_num() + 1;
/* 124 */     xPersonalInfo.getPraise().setPraised_num(newPraisedNum);
/*     */     
/*     */ 
/* 127 */     int newBePraisedNum = xTargetPersonalInfo.getPraise().getBe_praised_num() + 1;
/* 128 */     xTargetPersonalInfo.getPraise().setBe_praised_num(newBePraisedNum);
/*     */     
/*     */ 
/* 131 */     SPraisePersonalSuccess resp = new SPraisePersonalSuccess();
/* 132 */     resp.praisenum = newBePraisedNum;
/* 133 */     resp.roleid = this.targetRoleId;
/* 134 */     resp.praise = xPraiseRecord.getNum();
/* 135 */     OnlineManager.getInstance().send(this.roleId, resp);
/*     */     
/*     */ 
/* 138 */     PersonalPraise event = new PersonalPraise();
/* 139 */     PersonalPraiseArg arg = new PersonalPraiseArg(this.roleId, newPraisedNum, this.targetRoleId, newBePraisedNum);
/* 140 */     TriggerEventsManger.getInstance().triggerEvent(event, arg, RoleOneByOneManager.getInstance().getTaskOneByOne(Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/* 143 */     GameServer.logger().info(String.format("[personal]PCPraisePersonal.processImp@praise success|roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId) }));
/*     */     
/*     */ 
/* 146 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retCode)
/*     */   {
/* 151 */     SPraisePersonalFailed resp = new SPraisePersonalFailed();
/* 152 */     resp.retcode = retCode;
/* 153 */     resp.roleid = this.targetRoleId;
/* 154 */     OnlineManager.getInstance().sendAtOnce(this.roleId, resp);
/*     */     
/* 156 */     GameServer.logger().info(String.format("[personal]PCPraisePersonal.onFailed@praise failed|roleid=%d|target_roleid=%d|ret=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId), Integer.valueOf(retCode) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private int getTodayPraiseNum(PersonalInfo xPersonalInfo)
/*     */   {
/* 163 */     Map<Long, PraiseRecord> praises = xPersonalInfo.getPraise().getPraise_records();
/* 164 */     if (praises.isEmpty())
/*     */     {
/* 166 */       return 0;
/*     */     }
/* 168 */     int result = 0;
/* 169 */     for (Map.Entry<Long, PraiseRecord> entry : praises.entrySet())
/*     */     {
/* 171 */       result += ((PraiseRecord)entry.getValue()).getNum();
/*     */     }
/* 173 */     return result;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\PCPraisePersonal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */