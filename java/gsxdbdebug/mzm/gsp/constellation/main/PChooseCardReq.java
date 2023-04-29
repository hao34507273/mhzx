/*     */ package mzm.gsp.constellation.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Map;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.constellation.confbean.SCardStarCfg;
/*     */ import mzm.gsp.constellation.confbean.SConstellationConsts;
/*     */ import mzm.gsp.constellation.event.ChooseCard;
/*     */ import mzm.gsp.constellation.event.ChooseCardArg;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.Constellation;
/*     */ import xbean.RoleConstellation;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PChooseCardReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int constellation;
/*     */   private final int index;
/*     */   
/*     */   public PChooseCardReq(long roleid, int constellation, int index)
/*     */   {
/*  33 */     this.roleid = roleid;
/*  34 */     this.constellation = constellation;
/*  35 */     this.index = index;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  41 */     if (!OpenInterface.getOpenStatus(227)) {
/*  42 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  46 */     if (!ActivityInterface.isActivityOpen(SConstellationConsts.getInstance().Activityid)) {
/*  47 */       ConstellationManager.logError("PChooseCardReq.processImp@not open|roleid=%d|constellation=%d|index=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.constellation), Integer.valueOf(this.index) });
/*     */       
/*     */ 
/*  50 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  54 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*     */ 
/*  57 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  59 */     RoleConstellation xRoleConstellation = ConstellationManager.getXRoleConstellationIfNotExist(this.roleid);
/*     */     
/*  61 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, SConstellationConsts.getInstance().Activityid);
/*     */     
/*  63 */     if (!result.isCanJoin()) {
/*  64 */       ConstellationManager.logError("PChooseCardReq.processImp@cannot join activity|roleid=%d|reason=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(result.getReasonValue()) });
/*     */       
/*     */ 
/*  67 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  71 */     Constellation xConstellation = ConstellationManager.getXConstellation(false);
/*  72 */     if (xConstellation == null) {
/*  73 */       ConstellationManager.logError("PChooseCardReq.processImp@xconstellation null|roleid=%d|constellation=%d|index=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.constellation), Integer.valueOf(this.index) });
/*     */       
/*     */ 
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  80 */     if (!ConstellationManager.isCardConstellationValid(xConstellation, this.constellation)) {
/*  81 */       ConstellationManager.logError("PChooseCardReq.processImp@constellation invalid|roleid=%d|constellation=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.constellation) });
/*     */       
/*     */ 
/*  84 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  88 */     if (xRoleConstellation.getAward_constellations().containsKey(Integer.valueOf(this.constellation))) {
/*  89 */       ConstellationManager.logError("PChooseCardReq.processImp@already choose|roleid=%d|constellation=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.constellation) });
/*     */       
/*     */ 
/*  92 */       ConstellationManager.sendNormalResult(this.roleid, 1);
/*     */       
/*  94 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  98 */     int star = ConstellationManager.getStar(xConstellation, this.constellation, this.index);
/*  99 */     if (star < 0) {
/* 100 */       ConstellationManager.logError("PChooseCardReq.processImp@constellation invalid|roleid=%d|constellation=%d|index=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.constellation), Integer.valueOf(this.index) });
/*     */       
/*     */ 
/* 103 */       return false;
/*     */     }
/*     */     
/* 106 */     SCardStarCfg cardCfg = SCardStarCfg.get(star);
/*     */     
/*     */ 
/* 109 */     AwardReason awardReason = new AwardReason(LogReason.CONSTELLATION_CHOOSE_CARD, star);
/* 110 */     AwardModel awardModel = AwardInterface.award(cardCfg.awardid, userid, this.roleid, true, true, awardReason);
/*     */     
/*     */ 
/* 113 */     if (awardModel == null) {
/* 114 */       ConstellationManager.logError("PChooseCardReq.processImp@award null|roleid=%d|constellation=%d|index=%d|star=%d|awardid=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.constellation), Integer.valueOf(this.index), Integer.valueOf(star), Integer.valueOf(cardCfg.awardid) });
/*     */       
/*     */ 
/* 117 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 121 */     xRoleConstellation.getAward_constellations().put(Integer.valueOf(this.constellation), Integer.valueOf(this.index));
/*     */     
/* 123 */     xRoleConstellation.setSum_exp(xRoleConstellation.getSum_exp() + awardModel.getRoleExp());
/*     */     
/*     */ 
/* 126 */     ConstellationManager.sendChooseCardNormalRes(this.roleid, awardModel, this.constellation, this.index);
/*     */     
/*     */ 
/* 129 */     if (!ActivityInterface.addActivityCount(userid, this.roleid, SConstellationConsts.getInstance().Activityid))
/*     */     {
/* 131 */       int count = ActivityInterface.getActivityCount(userid, this.roleid, SConstellationConsts.getInstance().Activityid, true);
/*     */       
/* 133 */       ConstellationManager.logError("PChooseCardReq.processImp@add activity count failed|roleid=%d|activityid=%d|cur_count=%d|constellation=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(SConstellationConsts.getInstance().Activityid), Integer.valueOf(count), Integer.valueOf(this.constellation) });
/*     */       
/*     */ 
/* 136 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 140 */     ActivityInterface.tlogActivity(this.roleid, SConstellationConsts.getInstance().Activityid, ActivityLogStatus.FINISH);
/*     */     
/* 142 */     ChooseCardArg chooseArg = new ChooseCardArg(this.roleid, this.constellation, star);
/* 143 */     TriggerEventsManger.getInstance().triggerEvent(new ChooseCard(), chooseArg);
/*     */     
/* 145 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\constellation\main\PChooseCardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */