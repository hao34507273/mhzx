/*    */ package mzm.gsp.watchmoon.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.Location;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.map.main.group.MapGroupType;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.watchmoon.confbean.SWatchmoonMapCfg;
/*    */ import xbean.Watchmoon;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Role2watchmoon;
/*    */ 
/*    */ public class PrepareToFlySession extends Session
/*    */ {
/*    */   private List<Long> roleIds;
/*    */   
/*    */   public PrepareToFlySession(long interval, List<Long> roleIds)
/*    */   {
/* 23 */     super(interval, ((Long)roleIds.get(0)).longValue());
/* 24 */     this.roleIds = roleIds;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 31 */     new PrepareToFlySessionTimeOutPro(this.roleIds).execute();
/*    */   }
/*    */   
/*    */   private static class PrepareToFlySessionTimeOutPro
/*    */     extends LogicProcedure
/*    */   {
/*    */     private List<Long> roleIds;
/*    */     
/*    */     public PrepareToFlySessionTimeOutPro(List<Long> roleIds)
/*    */     {
/* 41 */       this.roleIds = roleIds;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 47 */       Lockeys.lock(Role2watchmoon.getTable(), this.roleIds);
/* 48 */       Watchmoon xWatchmoon = null;
/* 49 */       for (Iterator i$ = this.roleIds.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */         
/* 51 */         xWatchmoon = Role2watchmoon.get(Long.valueOf(roleid));
/* 52 */         if (xWatchmoon == null)
/*    */         {
/* 54 */           return false;
/*    */         }
/* 56 */         if (!RoleStatusInterface.containsStatus(roleid, 28))
/*    */         {
/* 58 */           return false;
/*    */         }
/*    */       }
/* 61 */       SWatchmoonMapCfg watchmoonMapCfg = SWatchmoonMapCfg.get(xWatchmoon.getMapid());
/*    */       
/* 63 */       List<Location> keyPathList = new ArrayList();
/* 64 */       keyPathList.add(new Location(watchmoonMapCfg.startposX, watchmoonMapCfg.startposY));
/* 65 */       keyPathList.add(new Location(watchmoonMapCfg.endposX, watchmoonMapCfg.endposY));
/*    */       
/*    */ 
/* 68 */       if (xWatchmoon.getIscouple())
/*    */       {
/* 70 */         MapInterface.groupMove(MapGroupType.MGT_WATCH_MOON_XYXW_FLY, xWatchmoon.getGroupid(), keyPathList);
/*    */       }
/*    */       else {
/* 73 */         MapInterface.groupMove(MapGroupType.MGT_WATCH_MOON_SIDE_BY_SIDE_FLY, xWatchmoon.getGroupid(), keyPathList);
/*    */       }
/*    */       
/* 76 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\main\PrepareToFlySession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */