/*     */ package mzm.gsp.crossfield.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.crossfield.confbean.SCrossFieldGradeCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleSingleCrossFieldInfo;
/*     */ import xbean.RoleSingleCrossFieldSeasonInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Role_single_cross_field_infos;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PSendGradeAward extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int season;
/*     */   
/*     */   PSendGradeAward(long roleid, int season)
/*     */   {
/*  28 */     this.roleid = roleid;
/*  29 */     this.season = season;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     if (!CrossFieldManager.isCrossFieldSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  38 */       onFail(-1, null);
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  44 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  46 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  48 */     RoleSingleCrossFieldInfo xRoleSingleCrossFieldInfo = Role_single_cross_field_infos.get(Long.valueOf(this.roleid));
/*  49 */     if (xRoleSingleCrossFieldInfo == null)
/*     */     {
/*  51 */       xRoleSingleCrossFieldInfo = Pod.newRoleSingleCrossFieldInfo();
/*  52 */       xRoleSingleCrossFieldInfo.setWeekly_point_sum_timestamp(DateTimeUtils.getCurrTimeInMillis());
/*  53 */       xRoleSingleCrossFieldInfo.setDaily_award_times_timestamp(DateTimeUtils.getCurrTimeInMillis());
/*  54 */       Role_single_cross_field_infos.insert(Long.valueOf(this.roleid), xRoleSingleCrossFieldInfo);
/*     */     }
/*  56 */     RoleSingleCrossFieldSeasonInfo xRoleSingleCrossFieldSeasonInfo = (RoleSingleCrossFieldSeasonInfo)xRoleSingleCrossFieldInfo.getSeason_infos().get(Integer.valueOf(this.season));
/*     */     
/*  58 */     if (xRoleSingleCrossFieldSeasonInfo == null)
/*     */     {
/*  60 */       xRoleSingleCrossFieldSeasonInfo = Pod.newRoleSingleCrossFieldSeasonInfo();
/*  61 */       xRoleSingleCrossFieldSeasonInfo.setStar_num_timestamp(DateTimeUtils.getCurrTimeInMillis());
/*  62 */       xRoleSingleCrossFieldInfo.getSeason_infos().put(Integer.valueOf(this.season), xRoleSingleCrossFieldSeasonInfo);
/*     */     }
/*     */     
/*  65 */     if (xRoleSingleCrossFieldSeasonInfo.getAwarded())
/*     */     {
/*     */ 
/*  68 */       onFail(10, null);
/*  69 */       return false;
/*     */     }
/*  71 */     TreeMap<Integer, SCrossFieldGradeCfg> treeMap = (TreeMap)SCrossFieldGradeCfg.getAll();
/*  72 */     Map.Entry<Integer, SCrossFieldGradeCfg> entry = treeMap.floorEntry(Integer.valueOf(xRoleSingleCrossFieldSeasonInfo.getStar_num()));
/*  73 */     if ((entry == null) || (((SCrossFieldGradeCfg)entry.getValue()).fix_award_id <= 0))
/*     */     {
/*  75 */       CrossFieldManager.logger.info(String.format("[crossfield]PSendGradeAward.processImp@no award|roleid=%d|season=%d|star_num=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.season), Integer.valueOf(xRoleSingleCrossFieldSeasonInfo.getStar_num()) }));
/*     */       
/*     */ 
/*  78 */       xRoleSingleCrossFieldSeasonInfo.setAwarded(true);
/*  79 */       return true;
/*     */     }
/*     */     
/*  82 */     AwardReason awardReason = new AwardReason(LogReason.SINGLE_CROSS_FIELD_GRADE_AWARD, this.season);
/*  83 */     mzm.gsp.award.main.AwardModel awardModel = AwardInterface.awardFixAward(((SCrossFieldGradeCfg)entry.getValue()).fix_award_id, userid, this.roleid, false, true, awardReason);
/*     */     
/*  85 */     if (awardModel == null)
/*     */     {
/*     */ 
/*  88 */       onFail(11, null);
/*  89 */       return false;
/*     */     }
/*  91 */     xRoleSingleCrossFieldSeasonInfo.setAwarded(true);
/*     */     
/*  93 */     CrossFieldManager.logger.info(String.format("[crossfield]PSendGradeAward.processImp@send grade award success|roleid=%d|season=%d|star_num=%d|grade=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.season), Integer.valueOf(xRoleSingleCrossFieldSeasonInfo.getStar_num()), Integer.valueOf(((SCrossFieldGradeCfg)entry.getValue()).sort_id) }));
/*     */     
/*     */ 
/*  96 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 101 */     StringBuilder sb = new StringBuilder();
/* 102 */     sb.append(String.format("[crossfield]PSendGradeAward.processImp@send grade award fail|roleid=%d|season=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.season), Integer.valueOf(res) }));
/*     */     
/* 104 */     if (extraInfo != null)
/*     */     {
/* 106 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 108 */         sb.append("|").append((String)entry.getKey());
/* 109 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 112 */     CrossFieldManager.logger.info(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\main\PSendGradeAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */