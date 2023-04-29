/*     */ package mzm.gsp.crossbattle.own;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.crossbattle.SGetRegisterInfoInCrossBattleFail;
/*     */ import mzm.gsp.crossbattle.SGetRegisterInfoInCrossBattleSuccess;
/*     */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.CrossBattleOwn;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetRegisterInfoInfoInCrossBattle extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final long corpsid;
/*     */   
/*     */   public PCGetRegisterInfoInfoInCrossBattle(long roleid, int activityCfgid, long corpsid)
/*     */   {
/*  26 */     this.roleid = roleid;
/*  27 */     this.activityCfgid = activityCfgid;
/*  28 */     this.corpsid = corpsid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (this.corpsid <= 0L)
/*     */     {
/*     */ 
/*  37 */       onFail(-3, null);
/*  38 */       return false;
/*     */     }
/*  40 */     if (!CrossBattleOwnManager.isCrossBattleActivitySwitchOpenForRole(this.roleid, this.activityCfgid))
/*     */     {
/*     */ 
/*  43 */       onFail(-1, null);
/*  44 */       return false;
/*     */     }
/*  46 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/*  47 */     if (cfg == null)
/*     */     {
/*     */ 
/*  50 */       onFail(-3, null);
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  56 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  58 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*     */ 
/*  61 */     if (!CrossBattleOwnManager.isActivityOpen(this.activityCfgid))
/*     */     {
/*     */ 
/*  64 */       onFail(1, null);
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  69 */     CrossBattleOwn xCrossBattleOwn = xtable.Cross_battle_owns.get(Long.valueOf(globalActivityCfgid));
/*  70 */     SGetRegisterInfoInCrossBattleSuccess protocol = new SGetRegisterInfoInCrossBattleSuccess();
/*  71 */     protocol.activity_cfg_id = this.activityCfgid;
/*  72 */     protocol.corps_id = this.corpsid;
/*  73 */     if (xCrossBattleOwn.getAttend_corps_infos().containsKey(Long.valueOf(this.corpsid)))
/*     */     {
/*  75 */       protocol.register_info = 1;
/*     */     }
/*     */     else
/*     */     {
/*  79 */       protocol.register_info = 0;
/*     */     }
/*  81 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/*  83 */     StringBuilder sb = new StringBuilder();
/*  84 */     sb.append(String.format("[crossbattle_own]PCGetRegisterInfoInfoInCrossBattle.processImp@get register info fail|roleid=%d|activity_cfg_id=%d|corpsid=%d|register_info", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Long.valueOf(this.corpsid), Byte.valueOf(protocol.register_info) }));
/*     */     
/*     */ 
/*  87 */     CrossBattleOwnManager.logger.info(sb.toString());
/*  88 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/*  93 */     StringBuilder sb = new StringBuilder();
/*  94 */     sb.append(String.format("[crossbattle_own]PCGetRegisterInfoInfoInCrossBattle.processImp@get register info fail|roleid=%d|activity_cfg_id=%d|corpsid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Long.valueOf(this.corpsid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/*  97 */     if (extraInfo != null)
/*     */     {
/*  99 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 101 */         sb.append("|").append((String)entry.getKey());
/* 102 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 105 */     CrossBattleOwnManager.logger.info(sb.toString());
/* 106 */     if (res > 0)
/*     */     {
/* 108 */       SGetRegisterInfoInCrossBattleFail protocol = new SGetRegisterInfoInCrossBattleFail();
/* 109 */       protocol.res = res;
/* 110 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\PCGetRegisterInfoInfoInCrossBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */