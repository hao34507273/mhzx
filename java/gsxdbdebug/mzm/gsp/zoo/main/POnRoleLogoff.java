/*    */ package mzm.gsp.zoo.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.homeland.confbean.SAnimalConst;
/*    */ import mzm.gsp.online.event.PlayerOfflineProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import xbean.ZooInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Animal;
/*    */ import xtable.Role2zooinfo;
/*    */ 
/*    */ public class POnRoleLogoff extends PlayerOfflineProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     long roleid = ((Long)this.arg).longValue();
/* 20 */     int level = mzm.gsp.role.main.RoleInterface.getLevel(roleid);
/* 21 */     if (level < SAnimalConst.getInstance().OPEN_LEVEL)
/*    */     {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     if (mzm.gsp.homeland.main.HomelandInterface.getHomeWorldIdByRoleId(roleid, false) != -1L)
/*    */     {
/* 28 */       return false;
/*    */     }
/*    */     
/* 31 */     List<Long> roles = new ArrayList();
/* 32 */     roles.add(Long.valueOf(roleid));
/* 33 */     long marriageRoleid = mzm.gsp.marriage.main.MarriageInterface.getMarriedRoleid(roleid, false);
/* 34 */     if (marriageRoleid > 0L)
/*    */     {
/* 36 */       if (!OnlineManager.getInstance().isOnline(marriageRoleid))
/*    */       {
/* 38 */         roles.add(Long.valueOf(marriageRoleid));
/*    */       }
/*    */     }
/*    */     
/* 42 */     lock(Lockeys.get(xtable.Basic.getTable(), roles));
/*    */     
/* 44 */     List<Long> animals = new ArrayList();
/*    */     
/* 46 */     for (Long r : roles)
/*    */     {
/* 48 */       ZooInfo xZooInfo = Role2zooinfo.get(r);
/* 49 */       if ((xZooInfo != null) && 
/*    */       
/*    */ 
/*    */ 
/* 53 */         (!xZooInfo.getAnimals().isEmpty()))
/*    */       {
/*    */ 
/*    */ 
/* 57 */         animals.addAll(xZooInfo.getAnimals());
/*    */       }
/*    */     }
/* 60 */     if (animals.isEmpty())
/*    */     {
/* 62 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 66 */     Lockeys.lock(Lockeys.get(Animal.getTable(), animals));
/* 67 */     for (Iterator i$ = animals.iterator(); i$.hasNext();) { long xAnimalid = ((Long)i$.next()).longValue();
/*    */       
/* 69 */       ZooManager.cancelAnimalLifeObserver(xAnimalid);
/*    */     }
/*    */     
/* 72 */     GameServer.logger().info(String.format("[zoo]POnRoleLogoff.processImp@cancel observer success|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/* 73 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\main\POnRoleLogoff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */