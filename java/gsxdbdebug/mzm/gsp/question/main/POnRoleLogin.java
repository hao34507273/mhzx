/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.question.confbean.KeJuQuestionConsts;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import xbean.KeJuInfo;
/*    */ import xbean.RolePictureQuestionInfo;
/*    */ import xbean.RoleWordQuestionInfo;
/*    */ import xbean.WordQuestionInfo;
/*    */ import xtable.Picturequestion;
/*    */ 
/*    */ public class POnRoleLogin extends mzm.gsp.online.event.PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 22 */         KeJuInfo xKeJuInfo = xtable.Role2keju.select((Long)POnRoleLogin.this.arg);
/* 23 */         if (xKeJuInfo == null)
/*    */         {
/* 25 */           return false;
/*    */         }
/* 27 */         if (ActivityInterface.isActivityOpen(KeJuQuestionConsts.getInstance().ACTIVITY_ID))
/*    */         {
/* 29 */           int activityStage = ActivityInterface.getActivityStage(KeJuQuestionConsts.getInstance().ACTIVITY_ID);
/*    */           
/* 31 */           KeJuQuestionManager.getInstance().syncKeJuState(((Long)POnRoleLogin.this.arg).longValue(), xKeJuInfo, activityStage);
/*    */         }
/*    */         
/*    */ 
/* 35 */         if ((xKeJuInfo.getIspasshuishi()) && (xKeJuInfo.getState() == 3))
/*    */         {
/* 37 */           int usetime = (int)(java.util.concurrent.TimeUnit.MILLISECONDS.toSeconds(xKeJuInfo.getFinishtime() - xKeJuInfo.getStarttime()) + xKeJuInfo.getPunishtime());
/*    */           
/* 39 */           KejuRankManager.getInstance().rank(new RoleKejuChart(((Long)POnRoleLogin.this.arg).longValue(), usetime));
/*    */         }
/*    */         
/* 42 */         return true;
/*    */       }
/* 44 */     });
/* 45 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 50 */         Long qid = xtable.Role2wordquestion.get((Long)POnRoleLogin.this.arg);
/* 51 */         if (qid == null)
/* 52 */           return false;
/* 53 */         WordQuestionInfo xWordInfo = xtable.Wordquestion.get(qid);
/* 54 */         if (xWordInfo == null)
/* 55 */           return false;
/* 56 */         RoleWordQuestionInfo xRoleWordQuestionInfo = (RoleWordQuestionInfo)xWordInfo.getRolequestionmap().get(POnRoleLogin.this.arg);
/* 57 */         WordQuestionManager.getInstance().syncWorldQuestionInfo(((Long)POnRoleLogin.this.arg).longValue(), xRoleWordQuestionInfo, xWordInfo.getLevelcfgid());
/* 58 */         return true;
/*    */       }
/*    */       
/* 61 */     });
/* 62 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 67 */         RolePictureQuestionInfo xRoleInfo = xtable.Role2picturequestion.select((Long)POnRoleLogin.this.arg);
/* 68 */         if (xRoleInfo == null)
/* 69 */           return false;
/* 70 */         long questionid = xRoleInfo.getPicinfoid();
/*    */         
/* 72 */         Integer state = Picturequestion.selectState(Long.valueOf(questionid));
/* 73 */         if (state == null)
/*    */         {
/* 75 */           return false;
/*    */         }
/*    */         
/* 78 */         if (state.intValue() == 0)
/*    */         {
/* 80 */           return true;
/*    */         }
/*    */         
/*    */ 
/*    */ 
/* 85 */         xdb.Lockeys.lock(xtable.Role2picturequestion.getTable(), Picturequestion.selectRoleidlist(Long.valueOf(questionid)));
/* 86 */         xbean.PictureInfo pictureInfo = Picturequestion.get(Long.valueOf(questionid));
/*    */         
/* 88 */         PictureQuestionManager.getInstance().notifyLogin(((Long)POnRoleLogin.this.arg).longValue(), pictureInfo);
/* 89 */         return true;
/*    */ 
/*    */       }
/*    */       
/*    */ 
/* 94 */     });
/* 95 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */