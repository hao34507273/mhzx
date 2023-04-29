/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xtable.Team;
/*    */ 
/*    */ public class TransferSession extends Session
/*    */ {
/*    */   private final int mapId;
/*    */   
/*    */   public TransferSession(long interval, int mapId, long worldid)
/*    */   {
/* 20 */     super(interval, worldid);
/*    */     
/* 22 */     this.mapId = mapId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 28 */     new TransferSessionPro(this.mapId, getOwerId()).execute();
/*    */   }
/*    */   
/*    */ 
/*    */   private static class TransferSessionPro
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final long worldid;
/*    */     private final int mapId;
/*    */     
/*    */     public TransferSessionPro(int mapId, long worldid)
/*    */     {
/* 40 */       this.worldid = worldid;
/* 41 */       this.mapId = mapId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 47 */       List<Long> roleList = MapInterface.getRoleList(this.worldid);
/*    */       
/* 49 */       lock(xtable.Role2properties.getTable(), roleList);
/*    */       
/* 51 */       Set<Long> teamids = new HashSet();
/*    */       
/* 53 */       for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*    */         
/* 55 */         Long teamid = TeamInterface.getTeamidByRoleid(r, false);
/* 56 */         if (teamid != null)
/*    */         {
/* 58 */           teamids.add(teamid);
/*    */         }
/*    */       }
/*    */       
/*    */ 
/* 63 */       lock(Team.getTable(), teamids);
/* 64 */       for (Iterator i$ = teamids.iterator(); i$.hasNext();) { long teamid = ((Long)i$.next()).longValue();
/*    */         
/* 66 */         TeamInfo teamInfo = TeamInterface.getTeamInfo(teamid, true);
/*    */         
/* 68 */         MapInterface.transferToScene(teamInfo.getLeaderId(), this.worldid, this.mapId);
/*    */       }
/*    */       
/*    */ 
/* 72 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\TransferSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */