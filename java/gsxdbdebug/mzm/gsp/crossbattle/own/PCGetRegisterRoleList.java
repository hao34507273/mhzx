/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.crossbattle.SGetRegisterRoleListFail;
/*     */ import mzm.gsp.crossbattle.SGetRegisterRoleListSuccess;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AttendCorpsInfo;
/*     */ import xbean.CrossBattleOwn;
/*     */ 
/*     */ public class PCGetRegisterRoleList extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final long corpsid;
/*     */   
/*     */   public PCGetRegisterRoleList(long roleid, int activityCfgid, long corpsid)
/*     */   {
/*  22 */     this.roleid = roleid;
/*  23 */     this.activityCfgid = activityCfgid;
/*  24 */     this.corpsid = corpsid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     if (this.corpsid < 0L)
/*     */     {
/*     */ 
/*  33 */       onFail(-3, null);
/*  34 */       return false;
/*     */     }
/*  36 */     if (!CrossBattleOwnManager.isCrossBattleActivitySwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  39 */       onFail(-1, null);
/*  40 */       return false;
/*     */     }
/*  42 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/*  43 */     if (cfg == null)
/*     */     {
/*     */ 
/*  46 */       onFail(-3, null);
/*  47 */       return false;
/*     */     }
/*     */     
/*  50 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*     */     
/*  52 */     lock(xtable.User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  54 */     lock(xtable.Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*     */ 
/*  57 */     if (!CrossBattleOwnManager.isActivityOpen(this.activityCfgid))
/*     */     {
/*     */ 
/*  60 */       onFail(1, null);
/*  61 */       return false;
/*     */     }
/*     */     
/*  64 */     long globalActivityCfgid = mzm.gsp.GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  65 */     CrossBattleOwn xCrossBattleOwn = xtable.Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*  66 */     AttendCorpsInfo xAttendCorpsInfo = (AttendCorpsInfo)xCrossBattleOwn.getAttend_corps_infos().get(Long.valueOf(this.corpsid));
/*  67 */     if (xAttendCorpsInfo == null)
/*     */     {
/*     */ 
/*  70 */       onFail(3, null);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     SGetRegisterRoleListSuccess protocol = new SGetRegisterRoleListSuccess();
/*  75 */     protocol.activity_cfg_id = this.activityCfgid;
/*  76 */     protocol.corps_id = this.corpsid;
/*  77 */     protocol.role_list.addAll(xAttendCorpsInfo.getMembers());
/*  78 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/*  80 */     StringBuilder sb = new StringBuilder();
/*  81 */     sb.append(String.format("[crossbattle_own]PCGetRegisterRoleList.processImp@get register role list success|roleid=%d|activity_cfg_id=%d|corps_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Long.valueOf(this.corpsid) }));
/*     */     
/*     */ 
/*  84 */     CrossBattleOwnManager.logger.info(sb.toString());
/*  85 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/*  90 */     StringBuilder sb = new StringBuilder();
/*  91 */     sb.append(String.format("[crossbattle_own]PCGetRegisterRoleList.processImp@get register role list fail|roleid=%d|activity_cfg_id=%d|corps_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Long.valueOf(this.corpsid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/*  94 */     if (extraInfo != null)
/*     */     {
/*  96 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/*  98 */         sb.append("|").append((String)entry.getKey());
/*  99 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 102 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 103 */     if (res > 0)
/*     */     {
/* 105 */       SGetRegisterRoleListFail protocol = new SGetRegisterRoleListFail();
/* 106 */       protocol.res = res;
/* 107 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\PCGetRegisterRoleList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */