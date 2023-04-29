/*    */ package mzm.gsp.baitan.main;
/*    */ 
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import mzm.gsp.baitan.confbean.BaiTanConsts;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.RoleGrid;
/*    */ import xtable.Role2baitanshoppinglist;
/*    */ import xtable.Role2grid;
/*    */ 
/*    */ 
/*    */ 
/*    */ class ClearRoleBaitanInfoOberver
/*    */   extends Observer
/*    */ {
/*    */   private long roleid;
/*    */   
/*    */   ClearRoleBaitanInfoOberver(long roleid, long intervalSeconds)
/*    */   {
/* 22 */     super(intervalSeconds);
/* 23 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 29 */     new ClearRolebaitan(this, this.roleid).execute();
/*    */     
/* 31 */     return true;
/*    */   }
/*    */   
/*    */   private static class ClearRolebaitan
/*    */     extends LogicProcedure
/*    */   {
/*    */     private long roleid;
/*    */     private ClearRoleBaitanInfoOberver clearRoleBaitanInfoOberver;
/*    */     
/*    */     public ClearRolebaitan(ClearRoleBaitanInfoOberver clearRoleBaitanInfoOberver, long roleid)
/*    */     {
/* 42 */       this.clearRoleBaitanInfoOberver = clearRoleBaitanInfoOberver;
/* 43 */       this.roleid = roleid;
/*    */     }
/*    */     
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 50 */       RoleGrid role2grid = Role2grid.get(Long.valueOf(this.roleid));
/* 51 */       if (role2grid == null)
/*    */       {
/* 53 */         BaiTanManager.removeClearFreshObserver(this.roleid);
/* 54 */         this.clearRoleBaitanInfoOberver.stopTimer();
/* 55 */         return false;
/*    */       }
/* 57 */       long difsec = TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis() - role2grid.getLastrefreshtime());
/*    */       
/* 59 */       if (difsec <= BaiTanConsts.getInstance().FREE_REFRESH_TIME_COUNTER)
/*    */       {
/*    */ 
/* 62 */         return false;
/*    */       }
/* 64 */       BaiTanManager.removeClearFreshObserver(this.roleid);
/* 65 */       boolean r = Role2baitanshoppinglist.remove(Long.valueOf(this.roleid));
/*    */       
/* 67 */       String logStr = String.format("[baitan]ClearRoleBaitanInfoOberver.update@clear role baitan indo|roleid=%d|difsec=%d|suc=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(difsec), Integer.valueOf(r ? 1 : 0) });
/*    */       
/*    */ 
/* 70 */       BaiTanManager.logger.info(logStr);
/* 71 */       this.clearRoleBaitanInfoOberver.stopTimer();
/* 72 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\main\ClearRoleBaitanInfoOberver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */