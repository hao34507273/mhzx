/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.changemodelcard.main.ChangeModelCardInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.timer.main.Observer;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PointRaceBackObserver extends Observer
/*    */ {
/*    */   public final long corpsid;
/*    */   
/*    */   public PointRaceBackObserver(long intervalSeconds, long corpsid)
/*    */   {
/* 20 */     super(intervalSeconds);
/* 21 */     this.corpsid = corpsid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 27 */     new PPointRaceBackTimeOut(this.corpsid).execute();
/* 28 */     return false;
/*    */   }
/*    */   
/*    */   private static class PPointRaceBackTimeOut extends LogicProcedure
/*    */   {
/*    */     private final long corpsid;
/*    */     
/*    */     public PPointRaceBackTimeOut(long corpsid)
/*    */     {
/* 37 */       this.corpsid = corpsid;
/*    */     }
/*    */     
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 44 */       PointRaceBackContext backContext = PointRaceBackContextManager.getInstance().remove(this.corpsid);
/* 45 */       if (backContext == null)
/*    */       {
/* 47 */         return false;
/*    */       }
/*    */       
/* 50 */       List<String> users = new ArrayList();
/* 51 */       List<Long> roleids = new ArrayList();
/* 52 */       for (PointRaceUserBackData userDataBack : backContext.userDatas)
/*    */       {
/* 54 */         users.add(userDataBack.userid);
/* 55 */         roleids.add(Long.valueOf(userDataBack.roleid));
/*    */       }
/*    */       
/* 58 */       lock(User.getTable(), users);
/* 59 */       lock(Basic.getTable(), roleids);
/* 60 */       PointRaceUserBackData leaderDataBack = (PointRaceUserBackData)backContext.userDatas.get(0);
/* 61 */       long leader = leaderDataBack.roleid;
/*    */       
/* 63 */       if (OnlineManager.getInstance().isOnline(leader))
/*    */       {
/* 65 */         Long teamId = TeamInterface.getTeamidByRoleid(leader, true);
/* 66 */         if (teamId != null)
/*    */         {
/* 68 */           long teamLeader = TeamInterface.getTeamLeaderByTeamid(teamId.longValue(), true);
/* 69 */           if (teamLeader != leader)
/*    */           {
/* 71 */             TeamInterface.appointLeader(teamId.longValue(), leader);
/*    */           }
/* 73 */           TeamInterface.designTeam(teamId.longValue(), roleids);
/*    */         }
/*    */       }
/*    */       
/* 77 */       mzm.gsp.status.main.RoleStatusInterface.unsetStatus(roleids, 65);
/*    */       
/* 79 */       int pvps = backContext.pvps;
/* 80 */       for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */         
/* 82 */         ChangeModelCardInterface.consumePVPFightCount(roleid, pvps);
/*    */       }
/*    */       
/* 85 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PointRaceBackObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */