/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.aircraft.main.AircraftInterface;
/*    */ import mzm.gsp.feijian.confbean.SFeiJianCfg;
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.map.main.group.MapGroupType;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class PRemoveMapGroup extends LogicProcedure
/*    */ {
/*    */   private final MapGroupType groupType;
/*    */   private final long groupid;
/*    */   private final List<Long> roleids;
/*    */   
/*    */   public PRemoveMapGroup(MapGroupType groupType, long groupid, List<Long> roleids)
/*    */   {
/* 27 */     this.groupType = groupType;
/* 28 */     this.groupid = groupid;
/* 29 */     this.roleids = roleids;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 35 */     lock(xtable.Role2properties.getTable(), this.roleids);
/*    */     
/* 37 */     Map<Long, Integer> nowFlyingRoles = new HashMap();
/* 38 */     Set<Long> offlineRoles = new HashSet();
/* 39 */     for (Iterator i$ = this.roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */       
/* 41 */       if (RoleStatusInterface.containsStatus(roleid, 2))
/*    */       {
/* 43 */         int feijianCfgid = AircraftInterface.getEquipedFeiJianCfgId(roleid, true);
/* 44 */         if (feijianCfgid <= 0)
/*    */         {
/* 46 */           RoleStatusInterface.unsetStatus(roleid, 2);
/*    */         }
/*    */         else
/*    */         {
/* 50 */           SFeiJianCfg feiJianCfg = ItemInterface.getFeiJianCfg(feijianCfgid);
/* 51 */           if (feiJianCfg == null)
/*    */           {
/* 53 */             RoleStatusInterface.unsetStatus(roleid, 2);
/*    */             
/* 55 */             GameServer.logger().info(String.format("[map]PRemoveMapGroup.processImp@fei jian config is not exist|roleid=%d|configid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(feijianCfgid) }));
/*    */ 
/*    */ 
/*    */           }
/*    */           else
/*    */           {
/*    */ 
/* 62 */             nowFlyingRoles.put(Long.valueOf(roleid), Integer.valueOf(feiJianCfg.velocity));
/*    */           }
/*    */         }
/*    */       }
/*    */       
/* 67 */       if (!OnlineManager.getInstance().isOnline(roleid))
/*    */       {
/* 69 */         offlineRoles.add(Long.valueOf(roleid));
/*    */       }
/*    */     }
/*    */     
/* 73 */     MapInterface.removeMapGroup(this.groupType, this.groupid, nowFlyingRoles, offlineRoles);
/*    */     
/* 75 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PRemoveMapGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */