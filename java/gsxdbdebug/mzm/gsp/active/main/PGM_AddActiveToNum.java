/*    */ package mzm.gsp.active.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.activity.confbean.SActivityCfg;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import xbean.Active;
/*    */ import xdb.Lockeys;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PGM_AddActiveToNum extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final int num;
/*    */   
/*    */   public PGM_AddActiveToNum(long roleId, int num)
/*    */   {
/* 18 */     this.roleId = roleId;
/* 19 */     this.num = num;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     if (this.num <= 0)
/*    */     {
/* 27 */       GmManager.getInstance().sendResultToGM(this.roleId, "活跃度的值不能小于等于0");
/* 28 */       return true;
/*    */     }
/*    */     
/* 31 */     String userId = RoleInterface.getUserId(this.roleId);
/* 32 */     lock(Lockeys.get(User.getTable(), userId));
/*    */     
/* 34 */     Active xActive = ActiveManager.checkAndInitActive(this.roleId, mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis());
/*    */     
/* 36 */     int nowActiveValue = ActiveManager.getTotalActiveValue(xActive);
/* 37 */     if (nowActiveValue >= this.num)
/*    */     {
/* 39 */       GmManager.getInstance().sendResultToGM(this.roleId, String.format("您当前的活跃度是%d,已经大于等于%d了", new Object[] { Integer.valueOf(nowActiveValue), Integer.valueOf(this.num) }));
/* 40 */       return true;
/*    */     }
/*    */     
/* 43 */     int needActive = this.num - nowActiveValue;
/*    */     
/* 45 */     for (SActivityCfg sActivityCfg : SActivityCfg.getAll().values())
/*    */     {
/* 47 */       int canAddActiveNum = sActivityCfg.awardActiveTimes;
/* 48 */       if (canAddActiveNum > 0)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 53 */         int activityCfgId = sActivityCfg.id;
/* 54 */         Integer times = (Integer)xActive.getActivitymap().get(Integer.valueOf(activityCfgId));
/* 55 */         if ((times == null) || (times.intValue() < canAddActiveNum))
/*    */         {
/*    */ 
/*    */ 
/* 59 */           int activityAleardyAddActive = times == null ? 0 : times.intValue();
/* 60 */           for (int index = activityAleardyAddActive + 1; index <= canAddActiveNum; index++)
/*    */           {
/* 62 */             if (ActiveManager.addActivityCount(this.roleId, xActive, activityCfgId))
/*    */             {
/* 64 */               needActive -= sActivityCfg.awardActiveValue;
/* 65 */               ActiveManager.sendUpdateActiveMsg(this.roleId, activityCfgId, ActiveManager.getActivityCount(xActive, activityCfgId));
/*    */               
/* 67 */               if (needActive <= 0)
/*    */               {
/* 69 */                 GmManager.getInstance().sendResultToGM(this.roleId, String.format("成功增加活跃度,您当前的活跃度值是%d", new Object[] { Integer.valueOf(ActiveManager.getTotalActiveValue(xActive)) }));
/*    */                 
/* 71 */                 return true;
/*    */               }
/*    */             } }
/*    */         }
/*    */       }
/*    */     }
/* 77 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\active\main\PGM_AddActiveToNum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */