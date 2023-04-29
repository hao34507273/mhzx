/*     */ package mzm.gsp.feisheng.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.feisheng.SReportPlayFeiShengEffectFail;
/*     */ import mzm.gsp.feisheng.SSynPlayFeiShengEffectInfo;
/*     */ import mzm.gsp.feisheng.confbean.SFeiShengCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.FeiShengInfo;
/*     */ import xbean.RoleFeiShengInfo;
/*     */ import xtable.Role_fei_sheng_infos;
/*     */ 
/*     */ public class PCReportPlayFeiShengEffect extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   
/*     */   public PCReportPlayFeiShengEffect(long roleid, int activityCfgid)
/*     */   {
/*  23 */     this.roleid = roleid;
/*  24 */     this.activityCfgid = activityCfgid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  30 */     if (SFeiShengCfg.get(this.activityCfgid) == null)
/*     */     {
/*     */ 
/*  33 */       onFail(-3, null);
/*  34 */       return false;
/*     */     }
/*     */     
/*  37 */     RoleFeiShengInfo xRoleFeiShengInfo = Role_fei_sheng_infos.get(Long.valueOf(this.roleid));
/*  38 */     if (xRoleFeiShengInfo == null)
/*     */     {
/*     */ 
/*  41 */       onFail(2, null);
/*  42 */       return false;
/*     */     }
/*  44 */     FeiShengInfo xFeiShengInfo = (FeiShengInfo)xRoleFeiShengInfo.getFei_sheng_infos().get(Integer.valueOf(this.activityCfgid));
/*  45 */     if (xFeiShengInfo == null)
/*     */     {
/*     */ 
/*  48 */       onFail(2, null);
/*  49 */       return false;
/*     */     }
/*  51 */     if (!xFeiShengInfo.getIs_activity_complete())
/*     */     {
/*     */ 
/*  54 */       onFail(2, null);
/*  55 */       return false;
/*     */     }
/*  57 */     if (xFeiShengInfo.getAlready_play_effect())
/*     */     {
/*     */ 
/*  60 */       onFail(3, null);
/*  61 */       return false;
/*     */     }
/*  63 */     xFeiShengInfo.setAlready_play_effect(true);
/*     */     
/*  65 */     SSynPlayFeiShengEffectInfo protocol = new SSynPlayFeiShengEffectInfo();
/*  66 */     for (SFeiShengCfg cfg : SFeiShengCfg.getAll().values())
/*     */     {
/*  68 */       protocol.effect_info.put(Integer.valueOf(cfg.activity_cfg_id), Integer.valueOf((xRoleFeiShengInfo.getFei_sheng_infos().get(Integer.valueOf(cfg.activity_cfg_id)) != null) && (((FeiShengInfo)xRoleFeiShengInfo.getFei_sheng_infos().get(Integer.valueOf(cfg.activity_cfg_id))).getAlready_play_effect()) ? 1 : 0));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  73 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/*  75 */     StringBuilder sb = new StringBuilder();
/*  76 */     sb.append(String.format("[feisheng]PCReportPlayFeiShengEffect.processImp@report play fei sheng effect success|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid) }));
/*     */     
/*     */ 
/*  79 */     FeiShengManager.logger.info(sb.toString());
/*  80 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/*  85 */     StringBuilder sb = new StringBuilder();
/*  86 */     sb.append(String.format("[feisheng]PCReportPlayFeiShengEffect.processImp@report play fei sheng effect fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/*  89 */     if (extraInfo != null)
/*     */     {
/*  91 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/*  93 */         sb.append("|").append((String)entry.getKey());
/*  94 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*  97 */     FeiShengManager.logger.info(sb.toString());
/*  98 */     if (res > 0)
/*     */     {
/* 100 */       SReportPlayFeiShengEffectFail protocol = new SReportPlayFeiShengEffectFail();
/* 101 */       protocol.activity_cfg_id = this.activityCfgid;
/* 102 */       protocol.res = res;
/* 103 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\main\PCReportPlayFeiShengEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */