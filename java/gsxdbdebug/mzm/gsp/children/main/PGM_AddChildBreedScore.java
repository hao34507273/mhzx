/*     */ package mzm.gsp.children.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.gm.SGMMessageTipRes;
/*     */ import mzm.gsp.marriage.main.MarriageInterface;
/*     */ import mzm.gsp.marriage.main.MarriageInterface.PregnantState;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2properties;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PGM_AddChildBreedScore extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int breedType;
/*     */   private final int step;
/*     */   private final int score;
/*     */   
/*     */   public PGM_AddChildBreedScore(long roleId, int breedType, int step, int score)
/*     */   {
/*  24 */     this.roleId = roleId;
/*  25 */     this.breedType = breedType;
/*  26 */     this.step = step;
/*  27 */     this.score = score;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  33 */     if (!ChildrenManager.isFunOpen(this.roleId))
/*     */     {
/*  35 */       notifyClient(this.roleId, "功能开关未打开");
/*  36 */       return false;
/*     */     }
/*  38 */     long marriedRoleId = MarriageInterface.getMarriedRoleid(this.roleId, false);
/*     */     
/*  40 */     String roleUserId = RoleInterface.getUserId(this.roleId);
/*  41 */     if (marriedRoleId > 0L)
/*     */     {
/*  43 */       String marriedRoleUserId = RoleInterface.getUserId(this.roleId);
/*  44 */       lock(User.getTable(), Arrays.asList(new String[] { roleUserId, marriedRoleUserId }));
/*  45 */       lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(marriedRoleId) }));
/*     */     }
/*     */     else
/*     */     {
/*  49 */       lock(Lockeys.get(User.getTable(), roleUserId));
/*  50 */       lock(Lockeys.get(Role2properties.getTable(), Long.valueOf(this.roleId)));
/*     */     }
/*     */     
/*  53 */     long marriedId = MarriageInterface.getMarriedId(this.roleId, true);
/*  54 */     if (marriedId > 0L)
/*     */     {
/*  56 */       lock(Lockeys.get(xtable.Marriage.getTable(), Long.valueOf(marriedId)));
/*     */     }
/*     */     
/*  59 */     BreedInfo breedInfo = ChildrenManager.getBreedInfo(this.roleId, true);
/*     */     
/*  61 */     if (this.breedType == 1)
/*     */     {
/*  63 */       if ((breedInfo != null) && (breedInfo.breed_state == 0))
/*     */       {
/*  65 */         notifyClient(this.roleId, "您在夫妻孕育状态!,请先放弃");
/*  66 */         return false;
/*     */       }
/*     */       
/*  69 */       ChildrenInterface.addSignalWayChildScore(this.roleId, this.score);
/*     */       
/*  71 */       notifyClient(this.roleId, "增加子女积分成功!");
/*     */       
/*  73 */       return true;
/*     */     }
/*     */     
/*  76 */     if (this.breedType == 0)
/*     */     {
/*  78 */       if ((breedInfo != null) && (breedInfo.breed_state == 1))
/*     */       {
/*  80 */         notifyClient(this.roleId, "您在单人孕育状态!,请先放弃");
/*     */         
/*  82 */         return false;
/*     */       }
/*     */       
/*  85 */       if (marriedId < 0L)
/*     */       {
/*  87 */         notifyClient(this.roleId, "您还没有结婚,不能孕育夫妻子女!");
/*  88 */         return false;
/*     */       }
/*     */       
/*  91 */       MarriageInterface.PregnantState pregnantState = MarriageInterface.getPregnantState(marriedId, false);
/*  92 */       if ((pregnantState != null) && (pregnantState.step != this.step))
/*     */       {
/*  94 */         notifyClient(this.roleId, "增加积分的step与step不相同!");
/*  95 */         return false;
/*     */       }
/*     */       
/*  98 */       if (this.step == 1)
/*     */       {
/* 100 */         ChildrenInterface.addPreparePregnantScore(this.roleId, marriedRoleId, marriedId, this.score);
/* 101 */         notifyClient(this.roleId, "增加子女积分成功!");
/*     */         
/* 103 */         return true;
/*     */       }
/* 105 */       if (this.step == 2)
/*     */       {
/* 107 */         notifyClient(this.roleId, "怀孕阶段不用增加积分,请夫妻二人组队怀胎!");
/*     */         
/* 109 */         return false;
/*     */       }
/* 111 */       if (this.step == 3)
/*     */       {
/* 113 */         ChildrenInterface.addGiveBirthScore(this.roleId, marriedRoleId, marriedId, this.score);
/* 114 */         notifyClient(this.roleId, "增加子女积分成功!");
/*     */         
/* 116 */         return true;
/*     */       }
/* 118 */       if (this.step == 4)
/*     */       {
/* 120 */         notifyClient(this.roleId, "生产阶段不用增加积分,请前往做生产任务!");
/* 121 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 125 */     return true;
/*     */   }
/*     */   
/*     */   private void notifyClient(long roleId, String str)
/*     */   {
/* 130 */     SGMMessageTipRes messagetip = new SGMMessageTipRes();
/* 131 */     messagetip.result = Integer.MAX_VALUE;
/* 132 */     messagetip.args.add(str);
/* 133 */     OnlineManager.getInstance().sendAtOnce(roleId, messagetip);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\PGM_AddChildBreedScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */