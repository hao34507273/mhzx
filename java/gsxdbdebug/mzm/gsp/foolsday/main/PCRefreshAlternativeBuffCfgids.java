/*     */ package mzm.gsp.foolsday.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.foolsday.SRefreshAlternativeBuffCfgidsFail;
/*     */ import mzm.gsp.foolsday.SSynFoolsDayInfo;
/*     */ import mzm.gsp.foolsday.confbean.FoolsDayConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FoolsDayInfo;
/*     */ import xbean.RoleFoolsDayInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCRefreshAlternativeBuffCfgids extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PCRefreshAlternativeBuffCfgids(long roleid)
/*     */   {
/*  28 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  34 */     if (!FoolsDayManager.isFoolsDaySwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  37 */       onFail(-1, null);
/*  38 */       return false;
/*     */     }
/*  40 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 934, true))
/*     */     {
/*     */ 
/*     */ 
/*  44 */       onFail(-2, null);
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  50 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  52 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  54 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, FoolsDayConsts.getInstance().ACTIVITY_CFG_ID);
/*     */     
/*  56 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  59 */       Map<String, Object> extraInfo = new HashMap();
/*  60 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  61 */       onFail(1, extraInfo);
/*  62 */       return false;
/*     */     }
/*  64 */     RoleFoolsDayInfo xRoleFoolsDayInfo = xtable.Role_fools_day_infos.get(Long.valueOf(this.roleid));
/*  65 */     if (xRoleFoolsDayInfo == null)
/*     */     {
/*  67 */       onFail(-4, null);
/*  68 */       return false;
/*     */     }
/*  70 */     FoolsDayInfo xFoolsDayInfo = (FoolsDayInfo)xRoleFoolsDayInfo.getFools_day_infos().get(Integer.valueOf(FoolsDayConsts.getInstance().ACTIVITY_CFG_ID));
/*     */     
/*  72 */     if (xFoolsDayInfo == null)
/*     */     {
/*  74 */       onFail(-4, null);
/*  75 */       return false;
/*     */     }
/*     */     
/*  78 */     if (xFoolsDayInfo.getRefresh_time() >= FoolsDayConsts.getInstance().REFRESH_MAX_TIME)
/*     */     {
/*     */ 
/*  81 */       onFail(2, null);
/*  82 */       return false;
/*     */     }
/*  84 */     xFoolsDayInfo.getAlternative_buff_cfg_ids().clear();
/*  85 */     xFoolsDayInfo.getAlternative_buff_cfg_ids().addAll(FoolsDayManager.getAlternativeBuffCfgids());
/*  86 */     xFoolsDayInfo.setRefresh_time(xFoolsDayInfo.getRefresh_time() + 1);
/*     */     
/*  88 */     SSynFoolsDayInfo protocol = new SSynFoolsDayInfo();
/*  89 */     protocol.make_chest_num = xFoolsDayInfo.getMake_chest_num();
/*  90 */     protocol.alternative_buff_cfg_ids.addAll(xFoolsDayInfo.getAlternative_buff_cfg_ids());
/*  91 */     protocol.refresh_time = xFoolsDayInfo.getRefresh_time();
/*  92 */     protocol.point = xFoolsDayInfo.getPoint();
/*  93 */     protocol.has_get_title_award = (xFoolsDayInfo.getHas_get_title_award() ? 1 : 0);
/*  94 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/*  96 */     StringBuilder sb = new StringBuilder();
/*  97 */     sb.append(String.format("[foolsday]PCRefreshAlternativeBuffCfgids.processImp@refresh alternative buff cfg ids success|roleid=%d|make_chest_num=%d|alternative_buff_cfg_ids=%s|refresh_time=%d|point=%d|has_get_title_award=%b", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(xFoolsDayInfo.getMake_chest_num()), xFoolsDayInfo.getAlternative_buff_cfg_ids().toString(), Integer.valueOf(xFoolsDayInfo.getRefresh_time()), Integer.valueOf(xFoolsDayInfo.getPoint()), Boolean.valueOf(xFoolsDayInfo.getHas_get_title_award()) }));
/*     */     
/*     */ 
/*     */ 
/* 101 */     FoolsDayManager.logger.info(sb.toString());
/* 102 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 107 */     StringBuilder sb = new StringBuilder();
/* 108 */     sb.append(String.format("[foolsday]PCRefreshAlternativeBuffCfgids.processImp@refresh alternative buff cfg ids fail|roleid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 111 */     if (extraInfo != null)
/*     */     {
/* 113 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 115 */         sb.append("|").append((String)entry.getKey());
/* 116 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 119 */     FoolsDayManager.logger.info(sb.toString());
/* 120 */     if (res > 0)
/*     */     {
/* 122 */       SRefreshAlternativeBuffCfgidsFail protocol = new SRefreshAlternativeBuffCfgidsFail();
/* 123 */       protocol.res = res;
/* 124 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\foolsday\main\PCRefreshAlternativeBuffCfgids.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */