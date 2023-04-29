/*    */ package mzm.gsp.zoo.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.homeland.confbean.SAnimalConst;
/*    */ import mzm.gsp.zoo.SyncRemoveAnimal;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.AnimalInfo;
/*    */ import xbean.ZooInfo;
/*    */ import xtable.Animal;
/*    */ 
/*    */ public class AnimalLifeObserver extends mzm.gsp.timer.main.Observer
/*    */ {
/*    */   private final long roleid;
/*    */   private final long animalid;
/*    */   
/*    */   public AnimalLifeObserver(long delaySeconds, long roleid, long animalid)
/*    */   {
/* 19 */     super(delaySeconds);
/*    */     
/* 21 */     this.roleid = roleid;
/* 22 */     this.animalid = animalid;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean update()
/*    */   {
/* 28 */     new PAnimalGone(this.roleid, this.animalid).execute();
/*    */     
/* 30 */     return false;
/*    */   }
/*    */   
/*    */   private static class PAnimalGone extends mzm.gsp.util.LogicProcedure
/*    */   {
/*    */     private final long roleid;
/*    */     private final long animalid;
/*    */     
/*    */     public PAnimalGone(long roleid, long animalid)
/*    */     {
/* 40 */       this.roleid = roleid;
/* 41 */       this.animalid = animalid;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 47 */       if (!ZooManager.isFunOpen())
/*    */       {
/* 49 */         GameServer.logger().error(String.format("[zoo]PAnimalGone.processImp@fun not open|role_id=%d|animal_id=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.animalid) }));
/*    */         
/*    */ 
/* 52 */         return false;
/*    */       }
/*    */       
/* 55 */       ZooInfo xZooInfo = xtable.Role2zooinfo.get(Long.valueOf(this.roleid));
/* 56 */       if (xZooInfo == null)
/*    */       {
/* 58 */         GameServer.logger().error(String.format("[zoo]PAnimalGone.processImp@xbean zoo info is null|role_id=%d|animal_id=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.animalid) }));
/*    */         
/*    */ 
/* 61 */         return false;
/*    */       }
/* 63 */       List<Long> xList = xZooInfo.getAnimals();
/* 64 */       if (!xList.contains(Long.valueOf(this.animalid)))
/*    */       {
/* 66 */         GameServer.logger().error(String.format("[zoo]PAnimalGone.processImp@list not contains the animal|role_id=%d|animal_id=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.animalid) }));
/*    */         
/*    */ 
/* 69 */         return false;
/*    */       }
/* 71 */       AnimalInfo xAnimalInfo = Animal.get(Long.valueOf(this.animalid));
/* 72 */       if (xAnimalInfo == null)
/*    */       {
/* 74 */         GameServer.logger().error(String.format("[zoo]PAnimalGone.processImp@xbean animal info is null|role_id=%d|animal_id=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.animalid) }));
/*    */         
/*    */ 
/* 77 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 81 */       xList.remove(Long.valueOf(this.animalid));
/* 82 */       Animal.remove(Long.valueOf(this.animalid));
/*    */       
/* 84 */       ZooManager.cancelAnimalLifeObserver(this.animalid);
/*    */       
/*    */ 
/* 87 */       ZooManager.syncSendEscapeMail(this.roleid, SAnimalConst.getInstance().ANIMAL_LIFE_END_MAIL_CFG_ID, xAnimalInfo.getName());
/*    */       
/*    */ 
/* 90 */       SyncRemoveAnimal msg = new SyncRemoveAnimal(this.animalid);
/* 91 */       mzm.gsp.online.main.OnlineManager.getInstance().send(this.roleid, msg);
/*    */       
/*    */ 
/* 94 */       ZooManager.triggerAnimalDisappearEvent(this.roleid, this.animalid, 3);
/*    */       
/*    */ 
/* 97 */       ZooManager.goneTlog(this.roleid, this.animalid, xAnimalInfo, 3);
/*    */       
/* 99 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\main\AnimalLifeObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */