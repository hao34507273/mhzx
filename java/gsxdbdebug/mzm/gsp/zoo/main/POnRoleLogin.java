/*    */ package mzm.gsp.zoo.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.homeland.confbean.SAnimalConst;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.zoo.SyncAnimalInfos;
/*    */ import xbean.ZooInfo;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Animal;
/*    */ import xtable.Role2zooinfo;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     long roleid = ((Long)this.arg).longValue();
/* 25 */     long marriageRoleid = mzm.gsp.marriage.main.MarriageInterface.getMarriedRoleid(roleid, true);
/* 26 */     if (marriageRoleid > 0L)
/*    */     {
/*    */ 
/* 29 */       new PCheckClean(marriageRoleid).execute();
/*    */     }
/*    */     
/* 32 */     int level = mzm.gsp.role.main.RoleInterface.getLevel(roleid);
/* 33 */     if (level < SAnimalConst.getInstance().OPEN_LEVEL)
/*    */     {
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     ZooInfo xZooInfo = Role2zooinfo.get(Long.valueOf(roleid));
/* 39 */     if (xZooInfo == null)
/*    */     {
/* 41 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 45 */     new PCheckClean(roleid).execute();
/*    */     
/* 47 */     List<Long> xList = xZooInfo.getAnimals();
/* 48 */     if (xList.isEmpty())
/*    */     {
/* 50 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 54 */     Lockeys.lock(Lockeys.get(Animal.getTable(), xList));
/* 55 */     ZooManager.checkAnimalLife(roleid, xZooInfo);
/*    */     
/*    */ 
/* 58 */     syncAnimals(roleid, xList);
/*    */     
/* 60 */     return true;
/*    */   }
/*    */   
/*    */   private void syncAnimals(long roleid, List<Long> xList)
/*    */   {
/* 65 */     SyncAnimalInfos msg = new SyncAnimalInfos();
/* 66 */     lock(Lockeys.get(Animal.getTable(), xList));
/* 67 */     for (Long animalid : xList)
/*    */     {
/* 69 */       xbean.AnimalInfo xAnimalInfo = Animal.get(animalid);
/* 70 */       if (xAnimalInfo != null)
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 75 */         mzm.gsp.zoo.AnimalInfo animalInfo = ZooManager.transToAnimalInfo(animalid.longValue(), xAnimalInfo);
/* 76 */         msg.animals.put(animalid, animalInfo);
/*    */       }
/*    */     }
/* 79 */     OnlineManager.getInstance().send(roleid, msg);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */