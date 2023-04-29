/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.aircraft.main.AircraftInterface;
/*    */ import mzm.gsp.feijian.confbean.SFeiJianCfg;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.map.main.message.MMH_DissoleTeam;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnTeamDissolve extends LogicProcedure
/*    */ {
/*    */   private final long teamid;
/*    */   private final List<Long> members;
/*    */   
/*    */   public POnTeamDissolve(long teamid, List<Long> members)
/*    */   {
/* 24 */     this.teamid = teamid;
/* 25 */     this.members = members;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if (this.members.isEmpty())
/*    */     {
/* 33 */       GameServer.logger().info(String.format("[map]POnTeamDissolve.processImp@team member is empty|teamid=%d|members=%s", new Object[] { Long.valueOf(this.teamid), this.members }));
/*    */       
/*    */ 
/* 36 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 40 */     lock(xtable.Role2properties.getTable(), this.members);
/*    */     
/* 42 */     Map<Long, Boolean> nowOnlineRoles = new HashMap();
/* 43 */     Map<Long, Integer> nowFlyingRoles = new HashMap();
/* 44 */     for (Iterator i$ = this.members.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */       
/* 46 */       nowOnlineRoles.put(Long.valueOf(roleid), Boolean.valueOf(OnlineManager.getInstance().isOnline(roleid)));
/*    */       
/* 48 */       if (RoleStatusInterface.containsStatus(roleid, 2))
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 53 */         int flySpeed = 0;
/* 54 */         int feijianCfgid = AircraftInterface.getEquipedFeiJianCfgId(roleid, true);
/* 55 */         if (feijianCfgid <= 0)
/*    */         {
/* 57 */           RoleStatusInterface.unsetStatus(roleid, 2);
/*    */         }
/*    */         else
/*    */         {
/* 61 */           SFeiJianCfg feijianCfg = ItemInterface.getFeiJianCfg(feijianCfgid);
/* 62 */           if (feijianCfg == null)
/*    */           {
/* 64 */             RoleStatusInterface.unsetStatus(roleid, 2);
/*    */             
/* 66 */             GameServer.logger().info(String.format("[map]POnTeamDissolve.processImp@feijian config not exist|teamid=%d|members=%s|roleid=%d|feijiancfgid=%d", new Object[] { Long.valueOf(this.teamid), this.members, Long.valueOf(roleid), Integer.valueOf(feijianCfgid) }));
/*    */ 
/*    */ 
/*    */           }
/*    */           else
/*    */           {
/*    */ 
/* 73 */             flySpeed = feijianCfg.velocity;
/*    */           }
/*    */         }
/* 76 */         nowFlyingRoles.put(Long.valueOf(roleid), Integer.valueOf(flySpeed));
/*    */       }
/*    */     }
/* 79 */     new MMH_DissoleTeam(this.teamid, this.members, nowFlyingRoles, nowOnlineRoles).execute();
/*    */     
/* 81 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnTeamDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */