/*    */ package mzm.gsp.role.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedList;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ class FightValueRankObserver extends Observer
/*    */ {
/*    */   public FightValueRankObserver(long intervalSeconds)
/*    */   {
/* 14 */     super(intervalSeconds);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 20 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicRunnable()
/*    */     {
/*    */ 
/*    */       public void process()
/*    */         throws Exception
/*    */       {
/* 26 */         for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { final long roleid = ((Long)i$.next()).longValue();
/*    */           
/* 28 */           NoneRealTimeTaskManager.getInstance().addTask(new mzm.gsp.util.LogicProcedure()
/*    */           {
/*    */ 
/*    */             protected boolean processImp()
/*    */               throws Exception
/*    */             {
/* 34 */               int fightvalue = RoleInterface.getFightValue(roleid);
/* 35 */               RoleFightValueChart roleFightValueChart = new RoleFightValueChart(roleid, fightvalue);
/* 36 */               FightValueRankManager.getInstance().rank(roleFightValueChart);
/* 37 */               return true;
/*    */             }
/*    */             
/*    */ 
/*    */           });
/*    */         }
/*    */       }
/* 44 */     });
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\main\FightValueRankObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */