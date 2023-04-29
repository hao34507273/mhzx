/*     */ package mzm.gsp.foolsday.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.foolsday.SGetFoolsDayInfoFail;
/*     */ import mzm.gsp.foolsday.SSynFoolsDayInfo;
/*     */ import mzm.gsp.foolsday.confbean.FoolsDayConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FoolsDayInfo;
/*     */ import xbean.RoleFoolsDayInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetFoolsDayInfo extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PCGetFoolsDayInfo(long roleid)
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
/*  40 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 933, true))
/*     */     {
/*     */ 
/*  43 */       onFail(-2, null);
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  49 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  51 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  53 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, FoolsDayConsts.getInstance().ACTIVITY_CFG_ID);
/*     */     
/*  55 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  58 */       Map<String, Object> extraInfo = new HashMap();
/*  59 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  60 */       onFail(1, extraInfo);
/*  61 */       return false;
/*     */     }
/*  63 */     RoleFoolsDayInfo xRoleFoolsDayInfo = xtable.Role_fools_day_infos.get(Long.valueOf(this.roleid));
/*  64 */     if (xRoleFoolsDayInfo == null)
/*     */     {
/*  66 */       onFail(-4, null);
/*  67 */       return false;
/*     */     }
/*  69 */     FoolsDayInfo xFoolsDayInfo = (FoolsDayInfo)xRoleFoolsDayInfo.getFools_day_infos().get(Integer.valueOf(FoolsDayConsts.getInstance().ACTIVITY_CFG_ID));
/*     */     
/*  71 */     if (xFoolsDayInfo == null)
/*     */     {
/*  73 */       onFail(-4, null);
/*  74 */       return false;
/*     */     }
/*  76 */     SSynFoolsDayInfo protocol = new SSynFoolsDayInfo();
/*  77 */     protocol.make_chest_num = xFoolsDayInfo.getMake_chest_num();
/*  78 */     protocol.alternative_buff_cfg_ids.addAll(xFoolsDayInfo.getAlternative_buff_cfg_ids());
/*  79 */     protocol.refresh_time = xFoolsDayInfo.getRefresh_time();
/*  80 */     protocol.point = xFoolsDayInfo.getPoint();
/*  81 */     protocol.has_get_title_award = (xFoolsDayInfo.getHas_get_title_award() ? 1 : 0);
/*  82 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/*  84 */     StringBuilder sb = new StringBuilder();
/*  85 */     sb.append(String.format("[foolsday]PCGetFoolsDayInfo.processImp@get fools day info success|roleid=%d|make_chest_num=%d|alternative_buff_cfg_ids=%s|refresh_time=%d|point=%d|has_get_title_award=%b", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(xFoolsDayInfo.getMake_chest_num()), xFoolsDayInfo.getAlternative_buff_cfg_ids().toString(), Integer.valueOf(xFoolsDayInfo.getRefresh_time()), Integer.valueOf(xFoolsDayInfo.getPoint()), Boolean.valueOf(xFoolsDayInfo.getHas_get_title_award()) }));
/*     */     
/*     */ 
/*     */ 
/*  89 */     FoolsDayManager.logger.info(sb.toString());
/*  90 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/*  95 */     StringBuilder sb = new StringBuilder();
/*  96 */     sb.append(String.format("[foolsday]PCGetFoolsDayInfo.processImp@get fools day info fail|roleid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(res) }));
/*     */     
/*  98 */     if (extraInfo != null)
/*     */     {
/* 100 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 102 */         sb.append("|").append((String)entry.getKey());
/* 103 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 106 */     FoolsDayManager.logger.info(sb.toString());
/* 107 */     if (res > 0)
/*     */     {
/* 109 */       SGetFoolsDayInfoFail protocol = new SGetFoolsDayInfoFail();
/* 110 */       protocol.res = res;
/* 111 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\foolsday\main\PCGetFoolsDayInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */