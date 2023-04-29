/*    */ package mzm.gsp.achievement.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.question.event.KeJuEndArg;
/*    */ import mzm.gsp.question.event.KeJuEndRunnable;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class ROnKeJuEnd extends KeJuEndRunnable
/*    */ {
/*    */   public void process()
/*    */   {
/* 12 */     updateAchievement(((KeJuEndArg)this.arg).getZhuangYuanRoleid(), 2402);
/*    */     
/* 14 */     updateAchievement(((KeJuEndArg)this.arg).getBangYanRoleid(), 2403);
/*    */     
/* 16 */     updateAchievement(((KeJuEndArg)this.arg).getTanHuaRoleid(), 2404);
/*    */     
/* 18 */     for (Iterator i$ = ((KeJuEndArg)this.arg).getJinShiList().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*    */       
/* 20 */       updateAchievement(roleId, 2405);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   private void updateAchievement(final long roleId, int goalType)
/*    */   {
/* 27 */     if (roleId <= 0L)
/*    */     {
/* 29 */       return;
/*    */     }
/*    */     
/* 32 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 37 */         AchievementManager.updateGoalTypeState(roleId, this.val$goalType, Integer.valueOf(1), String.format("ROnKeJuEnd.updateAchievement@handle goalType[%d] success", new Object[] { Integer.valueOf(this.val$goalType) }));
/*    */         
/* 39 */         return true;
/*    */       }
/*    */     }.call();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\main\ROnKeJuEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */