/*     */ package mzm.gsp.feisheng.zhuxianjianzhen;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengZhuXianJianZhenActivityCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.FeiShengZhuXianJianZhenInfo;
/*     */ import xbean.RoleFeiShengZhuXianJianZhenInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_fei_sheng_zhu_xian_jian_zhen_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class PKillMonsterStageStart
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PKillMonsterStageStart(long roleid, int activityCfgid)
/*     */   {
/*  28 */     this.roleid = roleid;
/*  29 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     SFeiShengZhuXianJianZhenActivityCfg cfg = SFeiShengZhuXianJianZhenActivityCfg.get(this.activityCfgid);
/*  36 */     if (cfg == null)
/*     */     {
/*     */ 
/*  39 */       onFail(-3, null);
/*  40 */       return false;
/*     */     }
/*  42 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  44 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  46 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  48 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*     */     
/*  50 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  53 */       Map<String, Object> extraInfo = new HashMap();
/*  54 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  55 */       onFail(1, extraInfo);
/*  56 */       return false;
/*     */     }
/*  58 */     if (!RoleStatusInterface.containsStatus(this.roleid, 959))
/*     */     {
/*     */ 
/*  61 */       onFail(-2, null);
/*  62 */       return false;
/*     */     }
/*  64 */     RoleFeiShengZhuXianJianZhenInfo xRoleFeiShengZhuXianJianZhenInfo = Role_fei_sheng_zhu_xian_jian_zhen_infos.get(Long.valueOf(this.roleid));
/*  65 */     if (xRoleFeiShengZhuXianJianZhenInfo == null)
/*     */     {
/*     */ 
/*  68 */       onFail(-6, null);
/*  69 */       return false;
/*     */     }
/*  71 */     FeiShengZhuXianJianZhenInfo xFeiShengZhuXianJianZhenInfo = (FeiShengZhuXianJianZhenInfo)xRoleFeiShengZhuXianJianZhenInfo.getFei_sheng_zhu_xian_jian_zhen_infos().get(Integer.valueOf(this.activityCfgid));
/*     */     
/*  73 */     if (xFeiShengZhuXianJianZhenInfo == null)
/*     */     {
/*     */ 
/*  76 */       onFail(-6, null);
/*  77 */       return false;
/*     */     }
/*  79 */     if (xFeiShengZhuXianJianZhenInfo.getStage() != 1)
/*     */     {
/*     */ 
/*  82 */       onFail(4, null);
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     ZhuXianJianZhenActivityManager.onKillMonsterStageStart(this.roleid, this.activityCfgid, xFeiShengZhuXianJianZhenInfo);
/*  87 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/*  92 */     StringBuilder sb = new StringBuilder();
/*  93 */     sb.append(String.format("[feisheng]PKillMonsterStageStart.processImp@kill monster stage start fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/*  96 */     if (extraInfo != null)
/*     */     {
/*  98 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 100 */         sb.append("|").append((String)entry.getKey());
/* 101 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\zhuxianjianzhen\PKillMonsterStageStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */