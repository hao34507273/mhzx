/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.team.main.TeamInfo;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.AllWorlds;
/*    */ import xbean.Paraselene;
/*    */ import xtable.Role2paraselene;
/*    */ 
/*    */ public class LeaveFubenObserver extends Session
/*    */ {
/*    */   private List<Long> roleList;
/*    */   
/*    */   public LeaveFubenObserver(long interval, List<Long> roleList)
/*    */   {
/* 24 */     super(interval, ((Long)roleList.get(0)).longValue());
/* 25 */     this.roleList = roleList;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 32 */     new LogicProcedure()
/*    */     {
/*    */ 
/*    */       protected boolean processImp()
/*    */         throws Exception
/*    */       {
/* 38 */         lock(xtable.Role2properties.getTable(), LeaveFubenObserver.this.roleList);
/*    */         
/* 40 */         final Set<Long> teamids = new HashSet();
/* 41 */         final Set<Long> worldidsSet = new HashSet();
/* 42 */         for (Iterator i$ = LeaveFubenObserver.this.roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*    */           
/* 44 */           Long teamid = TeamInterface.getTeamidByRoleid(r, false);
/*    */           
/* 46 */           if (teamid != null)
/*    */           {
/* 48 */             teamids.add(teamid); }
/*    */         }
/*    */         Iterator i$;
/*    */         Iterator i$;
/* 52 */         if (teamids.size() == 0)
/*    */         {
/* 54 */           for (i$ = LeaveFubenObserver.this.roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*    */             
/*    */ 
/* 57 */             if (ParaseleneManager.isInParaseleneWorld(r))
/*    */             {
/* 59 */               worldidsSet.add(Long.valueOf(MapInterface.getRoleWorldInstanceId(r)));
/* 60 */               mzm.gsp.status.main.RoleStatusInterface.unsetStatus(r, 12);
/* 61 */               ParaseleneManager.transferToWorld(r);
/*    */             }
/* 63 */             Paraselene paraselene = Role2paraselene.get(Long.valueOf(r));
/* 64 */             if (paraselene != null)
/*    */             {
/*    */ 
/* 67 */               paraselene.setRecentlayer(0);
/*    */             }
/*    */             
/*    */           }
/*    */           
/*    */         }
/*    */         else
/*    */         {
/* 75 */           lock(xtable.Team.getTable(), teamids);
/* 76 */           for (Iterator i$ = teamids.iterator(); i$.hasNext();) { long teamid = ((Long)i$.next()).longValue();
/*    */             
/*    */ 
/* 79 */             TeamInfo teamInfo = TeamInterface.getTeamInfo(teamid, true);
/* 80 */             List<Long> normalList = teamInfo.getTeamNormalList();
/* 81 */             LeaveFubenObserver.this.roleList.removeAll(normalList);
/* 82 */             if (ParaseleneManager.isInParaseleneWorld(teamInfo.getLeaderId()))
/*    */             {
/* 84 */               worldidsSet.add(Long.valueOf(MapInterface.getRoleWorldInstanceId(teamInfo.getLeaderId())));
/* 85 */               ParaseleneManager.transferToWorld(teamInfo.getLeaderId());
/*    */               
/* 87 */               new PUnsetParaseleneStatue(normalList).execute();
/*    */             }
/*    */           }
/*    */           
/*    */ 
/*    */ 
/* 93 */           for (i$ = LeaveFubenObserver.this.roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*    */             
/* 95 */             if (ParaseleneManager.isInParaseleneWorld(r))
/*    */             {
/* 97 */               worldidsSet.add(Long.valueOf(MapInterface.getRoleWorldInstanceId(r)));
/* 98 */               mzm.gsp.status.main.RoleStatusInterface.unsetStatus(r, 12);
/* 99 */               ParaseleneManager.transferToWorld(r);
/*    */             }
/* :1 */             Paraselene paraselene = Role2paraselene.get(Long.valueOf(r));
/* :2 */             if (paraselene != null)
/*    */             {
/*    */ 
/* :5 */               paraselene.setRecentlayer(0);
/*    */             }
/*    */           }
/*    */         }
/*    */         
/*    */ 
/* ;1 */         for (Iterator i$ = worldidsSet.iterator(); i$.hasNext();) { long worldid = ((Long)i$.next()).longValue();
/*    */           
/* ;3 */           TeamInterface.unRegisterJoinTeam(worldid);
/*    */           
/* ;5 */           MapInterface.destroyWorld(worldid);
/*    */         }
/* ;7 */         new LogicProcedure()
/*    */         {
/*    */ 
/*    */           protected boolean processImp()
/*    */             throws Exception
/*    */           {
/* <3 */             AllWorlds allWorlds = xtable.Allparaworlds.get(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/* <4 */             if (allWorlds != null)
/*    */             {
/* <6 */               for (Iterator i$ = teamids.iterator(); i$.hasNext();) { long teamid = ((Long)i$.next()).longValue();
/*    */                 
/* <8 */                 allWorlds.getTeamid2worldid().remove(Long.valueOf(teamid));
/*    */               }
/*    */               
/*    */ 
/* =2 */               Set<Long> tormove = new HashSet();
/* =3 */               for (Map.Entry<Long, Long> tw : allWorlds.getTeamid2worldid().entrySet())
/*    */               {
/* =5 */                 if (worldidsSet.contains(tw.getValue()))
/*    */                 {
/* =7 */                   tormove.add(tw.getKey());
/*    */                 }
/*    */               }
/* >0 */               for (Iterator i$ = tormove.iterator(); i$.hasNext();) { long teamid = ((Long)i$.next()).longValue();
/*    */                 
/* >2 */                 allWorlds.getTeamid2worldid().remove(Long.valueOf(teamid));
/*    */               }
/*    */               
/* >5 */               return true;
/*    */             }
/* >7 */             return false;
/*    */           }
/*    */           
/* ?0 */         }.execute();
/* ?1 */         return true;
/*    */       }
/*    */     }.execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\LeaveFubenObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */