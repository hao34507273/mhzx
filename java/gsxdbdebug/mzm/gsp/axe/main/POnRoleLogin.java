/*     */ package mzm.gsp.axe.main;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.axe.SSynAxeActivityInfo;
/*     */ import mzm.gsp.axe.confbean.SAxeAvtivityCfg;
/*     */ import xbean.AxeActivityInfo;
/*     */ import xbean.RoleAxeActivityInfo;
/*     */ import xbean.UserAxeActivityInfo;
/*     */ import xtable.User_axe_activity_infos;
/*     */ 
/*     */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  19 */     long loginRoleid = ((Long)this.arg).longValue();
/*     */     
/*  21 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(loginRoleid);
/*     */     
/*  23 */     lock(xtable.User.getTable(), java.util.Arrays.asList(new String[] { userid }));
/*     */     
/*  25 */     Set<Long> roleids = mzm.gsp.role.main.RoleInterface.getRoleSet(userid);
/*  26 */     lock(xtable.Basic.getTable(), roleids);
/*     */     
/*  28 */     for (SAxeAvtivityCfg cfg : SAxeAvtivityCfg.getAll().values())
/*     */     {
/*  30 */       int maxContinuousNotGoldTimes = 0;
/*  31 */       long maxStartTimestamp = -1L;
/*  32 */       for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/*  34 */         ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, roleid, cfg.activity_cfg_id);
/*     */         
/*  36 */         if (activityJoinResult.isCanJoin())
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*  41 */           RoleAxeActivityInfo xRoleAxeActivityInfo = xtable.Role_axe_activity_infos.get(Long.valueOf(roleid));
/*  42 */           if (xRoleAxeActivityInfo != null)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*  47 */             AxeActivityInfo xAxeActivityInfoInRoleInfo = (AxeActivityInfo)xRoleAxeActivityInfo.getAxe_activity_infos().get(Integer.valueOf(cfg.activity_cfg_id));
/*     */             
/*  49 */             if (xAxeActivityInfoInRoleInfo != null)
/*     */             {
/*     */ 
/*     */ 
/*     */ 
/*  54 */               maxContinuousNotGoldTimes = xAxeActivityInfoInRoleInfo.getContinuous_not_gold_times() > maxContinuousNotGoldTimes ? xAxeActivityInfoInRoleInfo.getContinuous_not_gold_times() : maxContinuousNotGoldTimes;
/*     */               
/*  56 */               maxStartTimestamp = xAxeActivityInfoInRoleInfo.getStart_timestamp() > maxStartTimestamp ? xAxeActivityInfoInRoleInfo.getStart_timestamp() : maxStartTimestamp;
/*     */             }
/*     */           } } }
/*  59 */       if (maxStartTimestamp > 0L)
/*     */       {
/*  61 */         UserAxeActivityInfo xUserAxeActivityInfo = User_axe_activity_infos.get(userid);
/*  62 */         if (xUserAxeActivityInfo == null)
/*     */         {
/*  64 */           xUserAxeActivityInfo = xbean.Pod.newUserAxeActivityInfo();
/*  65 */           User_axe_activity_infos.insert(userid, xUserAxeActivityInfo);
/*     */         }
/*  67 */         AxeActivityInfo xAxeActivityInfo = (AxeActivityInfo)xUserAxeActivityInfo.getAxe_activity_infos().get(Integer.valueOf(cfg.activity_cfg_id));
/*  68 */         if (xAxeActivityInfo == null)
/*     */         {
/*  70 */           xAxeActivityInfo = xbean.Pod.newAxeActivityInfo();
/*  71 */           xAxeActivityInfo.setContinuous_not_gold_times(maxContinuousNotGoldTimes);
/*  72 */           xAxeActivityInfo.setStart_timestamp(maxStartTimestamp);
/*  73 */           xUserAxeActivityInfo.getAxe_activity_infos().put(Integer.valueOf(cfg.activity_cfg_id), xAxeActivityInfo);
/*  74 */           StringBuilder sb = new StringBuilder();
/*  75 */           sb.append(String.format("[axe]POnRoleLogin.processImp@user axe activity date init|userid=%s|activity_cfg_id=%d|continuous_not_gold_times=%d|start_timestamp=%d", new Object[] { userid, Integer.valueOf(cfg.activity_cfg_id), Integer.valueOf(xAxeActivityInfo.getContinuous_not_gold_times()), Long.valueOf(xAxeActivityInfo.getStart_timestamp()) }));
/*     */           
/*     */ 
/*     */ 
/*  79 */           AxeManager.logger.info(sb.toString());
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  84 */     SSynAxeActivityInfo protocol = new SSynAxeActivityInfo();
/*  85 */     for (SAxeAvtivityCfg cfg : SAxeAvtivityCfg.getAll().values())
/*     */     {
/*  87 */       ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, loginRoleid, cfg.activity_cfg_id);
/*     */       
/*  89 */       if (activityJoinResult.isCanJoin())
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*  94 */         AxeManager.initData(userid, cfg.activity_cfg_id);
/*     */         
/*  96 */         UserAxeActivityInfo xUserAxeActivityInfo = User_axe_activity_infos.get(userid);
/*  97 */         if (xUserAxeActivityInfo == null)
/*     */         {
/*     */ 
/* 100 */           return false;
/*     */         }
/* 102 */         AxeActivityInfo xAxeActivityInfo = (AxeActivityInfo)xUserAxeActivityInfo.getAxe_activity_infos().get(Integer.valueOf(cfg.activity_cfg_id));
/* 103 */         if (xAxeActivityInfo == null)
/*     */         {
/*     */ 
/* 106 */           return false;
/*     */         }
/* 108 */         protocol.activity_infos.put(Integer.valueOf(cfg.activity_cfg_id), Integer.valueOf((int)(xAxeActivityInfo.getStart_timestamp() / 1000L)));
/*     */       } }
/* 110 */     mzm.gsp.online.main.OnlineManager.getInstance().send(loginRoleid, protocol);
/* 111 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\axe\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */