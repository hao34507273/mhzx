/*     */ package mzm.gsp.shitu.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.personal.main.PersonalInterface;
/*     */ import mzm.gsp.shitu.ShiTuRoleInfoAndModelInfo;
/*     */ import mzm.gsp.shitu.SynMasterRecommendInfos;
/*     */ import mzm.gsp.shitu.confbean.SMasterRecommendConsts;
/*     */ import mzm.gsp.shitu.confbean.ShiTuConsts;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.MasterInfo;
/*     */ import xbean.role2ShiTuInfo;
/*     */ import xtable.Role2shitu;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PFilterAndSendMasterRecommend
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final List<Long> recommendMasterRoleIdList;
/*     */   private role2ShiTuInfo xRoleIdAShiTuInfo;
/*     */   private MasterInfo xMasterInfo;
/*     */   private MasterInfo xRoleMasterInfo;
/*  35 */   private final Set<Long> recommendRoleIds = new HashSet(SMasterRecommendConsts.getInstance().MIN_MASTER_RECOMMEND_NUM);
/*     */   
/*     */   public PFilterAndSendMasterRecommend(long roleId, List<Long> recommendMasterRoleIdList)
/*     */   {
/*  39 */     this.roleId = roleId;
/*  40 */     this.recommendMasterRoleIdList = recommendMasterRoleIdList;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     Collections.shuffle(this.recommendMasterRoleIdList);
/*     */     
/*     */ 
/*  50 */     this.xRoleIdAShiTuInfo = Role2shitu.select(Long.valueOf(this.roleId));
/*  51 */     if (this.xRoleIdAShiTuInfo == null)
/*     */     {
/*  53 */       return false;
/*     */     }
/*  55 */     this.xRoleMasterInfo = this.xRoleIdAShiTuInfo.getMasterinfo();
/*     */     
/*     */ 
/*  58 */     List<Long> youYuanFang = new ArrayList(PersonalInterface.getDesireMasters());
/*     */     
/*  60 */     youYuanFang.retainAll(this.recommendMasterRoleIdList);
/*  61 */     for (Iterator i$ = youYuanFang.iterator(); i$.hasNext();) { long checkRoleId = ((Long)i$.next()).longValue();
/*     */       
/*  63 */       checkAndAdd(checkRoleId);
/*  64 */       if (this.recommendRoleIds.size() >= SMasterRecommendConsts.getInstance().YOUYUAN_MASTER_RECOMMEND_NUM) {
/*     */         break;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  70 */     for (Iterator i$ = this.recommendMasterRoleIdList.iterator(); i$.hasNext();) { long checkRoleId = ((Long)i$.next()).longValue();
/*     */       
/*  72 */       checkAndAdd(checkRoleId);
/*  73 */       if (this.recommendRoleIds.size() >= SMasterRecommendConsts.getInstance().MIN_MASTER_RECOMMEND_NUM) {
/*     */         break;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  79 */     if (this.recommendRoleIds.size() < SMasterRecommendConsts.getInstance().MIN_MASTER_RECOMMEND_NUM)
/*     */     {
/*     */ 
/*  82 */       ShiTuManager.triggerMasterRecommendEvent(this.roleId, this.recommendMasterRoleIdList, false);
/*  83 */       return true;
/*     */     }
/*     */     
/*  86 */     MasterRecommendSession sessinon = new MasterRecommendSession(SMasterRecommendConsts.getInstance().RECOMMEND_MASTER_COUNTDOWN_TIME, this.roleId, this.recommendRoleIds);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  91 */     SynMasterRecommendInfos syn = new SynMasterRecommendInfos();
/*  92 */     syn.sessionid = sessinon.getSessionId();
/*  93 */     for (Iterator i$ = this.recommendRoleIds.iterator(); i$.hasNext();) { long recommendRoleId = ((Long)i$.next()).longValue();
/*     */       
/*  95 */       syn.all_master_recommend_infos.add(ShiTuManager.setShiTuRoleInfoAndModelInfo(recommendRoleId, new ShiTuRoleInfoAndModelInfo()));
/*     */     }
/*     */     
/*  98 */     OnlineManager.getInstance().send(this.roleId, syn);
/*     */     
/* 100 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void checkAndAdd(long checkRoleId)
/*     */   {
/* 112 */     if (this.recommendRoleIds.contains(Long.valueOf(checkRoleId)))
/*     */     {
/* 114 */       return;
/*     */     }
/*     */     
/* 117 */     this.xRoleIdAShiTuInfo = Role2shitu.select(Long.valueOf(checkRoleId));
/*     */     
/* 119 */     if (this.xRoleIdAShiTuInfo == null)
/*     */     {
/* 121 */       return;
/*     */     }
/* 123 */     this.xMasterInfo = this.xRoleIdAShiTuInfo.getMasterinfo();
/*     */     
/* 125 */     if (this.xMasterInfo.getApprentice_now().size() >= ShiTuConsts.getInstance().maxApprenticeNum)
/*     */     {
/* 127 */       return;
/*     */     }
/*     */     
/*     */ 
/* 131 */     if (ShiTuManager.checkIsInPunishTime(checkRoleId, this.roleId, this.xMasterInfo, this.xRoleMasterInfo, null, false))
/*     */     {
/* 133 */       return;
/*     */     }
/*     */     
/* 136 */     this.recommendRoleIds.add(Long.valueOf(checkRoleId));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shitu\main\PFilterAndSendMasterRecommend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */