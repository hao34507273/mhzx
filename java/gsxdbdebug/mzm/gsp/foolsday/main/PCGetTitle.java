/*     */ package mzm.gsp.foolsday.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.foolsday.SGetTitleFail;
/*     */ import mzm.gsp.foolsday.SGetTitleSuccess;
/*     */ import mzm.gsp.foolsday.confbean.FoolsDayConsts;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FoolsDayInfo;
/*     */ import xbean.RoleFoolsDayInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_fools_day_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCGetTitle extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PCGetTitle(long roleid)
/*     */   {
/*  32 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  38 */     if (!FoolsDayManager.isFoolsDaySwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  41 */       onFail(-1, null);
/*  42 */       return false;
/*     */     }
/*  44 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleid, 935, true))
/*     */     {
/*     */ 
/*  47 */       onFail(-2, null);
/*  48 */       return false;
/*     */     }
/*     */     
/*  51 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  53 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  55 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  57 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, FoolsDayConsts.getInstance().ACTIVITY_CFG_ID);
/*     */     
/*  59 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  62 */       Map<String, Object> extraInfo = new HashMap();
/*  63 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  64 */       onFail(1, extraInfo);
/*  65 */       return false;
/*     */     }
/*  67 */     RoleFoolsDayInfo xRoleFoolsDayInfo = Role_fools_day_infos.get(Long.valueOf(this.roleid));
/*  68 */     if (xRoleFoolsDayInfo == null)
/*     */     {
/*  70 */       onFail(-4, null);
/*  71 */       return false;
/*     */     }
/*  73 */     FoolsDayInfo xFoolsDayInfo = (FoolsDayInfo)xRoleFoolsDayInfo.getFools_day_infos().get(Integer.valueOf(FoolsDayConsts.getInstance().ACTIVITY_CFG_ID));
/*     */     
/*  75 */     if (xFoolsDayInfo == null)
/*     */     {
/*  77 */       onFail(-4, null);
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     if (xFoolsDayInfo.getHas_get_title_award())
/*     */     {
/*     */ 
/*  84 */       onFail(2, null);
/*  85 */       return false;
/*     */     }
/*  87 */     if (xFoolsDayInfo.getPoint() < FoolsDayConsts.getInstance().TITLE_AWARD_NEED_POINT)
/*     */     {
/*     */ 
/*  90 */       onFail(3, null);
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     if (FoolsDayConsts.getInstance().TITLE_AWARD_ID > 0)
/*     */     {
/*  96 */       AwardModel awardModel = AwardInterface.awardFixAward(FoolsDayConsts.getInstance().TITLE_AWARD_ID, userid, this.roleid, true, true, new AwardReason(LogReason.FOOLS_DAY_TITLE_AWARD, FoolsDayConsts.getInstance().ACTIVITY_CFG_ID));
/*     */       
/*     */ 
/*  99 */       if (awardModel == null)
/*     */       {
/*     */ 
/* 102 */         onFail(4, null);
/* 103 */         return false;
/*     */       }
/*     */     }
/* 106 */     xFoolsDayInfo.setHas_get_title_award(true);
/*     */     
/* 108 */     SGetTitleSuccess protocol = new SGetTitleSuccess();
/* 109 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 111 */     StringBuilder sb = new StringBuilder();
/* 112 */     sb.append(String.format("[foolsday]PCGetTitle.processImp@get title success|roleid=%d|make_chest_num=%d|alternative_buff_cfg_ids=%s|refresh_time=%d|point=%d|has_get_title_award=%b", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(xFoolsDayInfo.getMake_chest_num()), xFoolsDayInfo.getAlternative_buff_cfg_ids().toString(), Integer.valueOf(xFoolsDayInfo.getRefresh_time()), Integer.valueOf(xFoolsDayInfo.getPoint()), Boolean.valueOf(xFoolsDayInfo.getHas_get_title_award()) }));
/*     */     
/*     */ 
/*     */ 
/* 116 */     FoolsDayManager.logger.info(sb.toString());
/* 117 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 122 */     StringBuilder sb = new StringBuilder();
/* 123 */     sb.append(String.format("[foolsday]PCGetTitle.processImp@get title fail|roleid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(res) }));
/* 124 */     if (extraInfo != null)
/*     */     {
/* 126 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 128 */         sb.append("|").append((String)entry.getKey());
/* 129 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 132 */     FoolsDayManager.logger.info(sb.toString());
/* 133 */     if (res > 0)
/*     */     {
/* 135 */       SGetTitleFail protocol = new SGetTitleFail();
/* 136 */       protocol.res = res;
/* 137 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\foolsday\main\PCGetTitle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */