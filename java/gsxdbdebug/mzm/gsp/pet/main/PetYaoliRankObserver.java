/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ 
/*    */ class PetYaoliRankObserver extends Observer
/*    */ {
/*    */   public PetYaoliRankObserver(long intervalSeconds)
/*    */   {
/* 12 */     super(intervalSeconds);
/*    */   }
/*    */   
/*    */   public boolean update()
/*    */   {
/* 17 */     NoneRealTimeTaskManager.getInstance().addTask(new RrankAllRolesPetYaoli());
/* 18 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   private static class RrankAllRolesPetYaoli
/*    */     extends mzm.gsp.util.LogicRunnable
/*    */   {
/*    */     public void process()
/*    */       throws Exception
/*    */     {
/* 28 */       for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/* 29 */         new PetYaoliRankObserver.PrankRolesPetYaoli(roleid).execute();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   private static class PrankRolesPetYaoli extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final long roleId;
/*    */     
/*    */     PrankRolesPetYaoli(long roleId) {
/* 39 */       this.roleId = roleId;
/*    */     }
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 44 */       for (Iterator i$ = PetInterface.getPetList(this.roleId, false).iterator(); i$.hasNext();) { long petid = ((Long)i$.next()).longValue();
/* 45 */         int petYaoli = PetInterface.getPetYaoli(this.roleId, petid);
/* 46 */         long changeTime = PetInterface.getPetYaoliChangeTime(this.roleId, petid);
/* 47 */         if (petYaoli > 0) {
/* 48 */           PetYaoLiChart petYaoLiChart = new PetYaoLiChart(petid, this.roleId, petYaoli, changeTime);
/* 49 */           PetYaoLiChartRankManager.getInstance().rank(petYaoLiChart);
/*    */         }
/*    */       }
/*    */       
/* 53 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PetYaoliRankObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */