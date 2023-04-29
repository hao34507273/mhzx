/*    */ package mzm.gsp.pet.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.TriggerEventsManger;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.fight.main.FightInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pet.SPetNormalResult;
/*    */ import mzm.gsp.pet.SSyncPetStateChange;
/*    */ import mzm.gsp.pet.event.PetEventArg;
/*    */ import mzm.gsp.pet.event.PetRest;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Pet;
/*    */ import xbean.PetBag;
/*    */ import xbean.Role2PetBean;
/*    */ import xtable.Role2petbag;
/*    */ import xtable.Role2petoutfightbean;
/*    */ 
/*    */ public class PPetRestReq extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long petId;
/*    */   
/*    */   public PPetRestReq(long roleId, long petId)
/*    */   {
/* 27 */     this.roleId = roleId;
/* 28 */     this.petId = petId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 35 */     PetBag xPetBag = Role2petbag.get(Long.valueOf(this.roleId));
/* 36 */     if (xPetBag == null)
/*    */     {
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(this.roleId, 533, true, true))
/*    */     {
/* 43 */       StringBuilder sBuilder = new StringBuilder();
/* 44 */       sBuilder.append("[pet]PPetRestReq.processImp@rest pet fail,status error");
/* 45 */       sBuilder.append("|role_id=").append(this.roleId);
/* 46 */       sBuilder.append("|pet_id=").append(this.petId);
/*    */       
/* 48 */       GameServer.logger().error(sBuilder.toString());
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     Pet xPet = (Pet)xPetBag.getPetmap().get(Long.valueOf(this.petId));
/* 53 */     if (xPet == null)
/*    */     {
/* 55 */       return false;
/*    */     }
/* 57 */     if (FightInterface.isInFight(this.roleId))
/*    */     {
/*    */ 
/* 60 */       Role2PetBean role2PetBean = Role2petoutfightbean.get(Long.valueOf(this.roleId));
/* 61 */       role2PetBean.setAction(this);
/* 62 */       SPetNormalResult normalResult = new SPetNormalResult();
/* 63 */       normalResult.result = 19;
/* 64 */       OnlineManager.getInstance().sendAtOnce(this.roleId, normalResult);
/* 65 */       return true;
/*    */     }
/* 67 */     if (xPetBag.getFightpet() == this.petId)
/*    */     {
/* 69 */       xPetBag.setFightpet(-1L);
/*    */     }
/* 71 */     SSyncPetStateChange petStateChange = new SSyncPetStateChange();
/* 72 */     petStateChange.petid = this.petId;
/* 73 */     petStateChange.state = 3;
/* 74 */     OnlineManager.getInstance().send(this.roleId, petStateChange);
/*    */     
/* 76 */     PetEventArg arg = new PetEventArg();
/* 77 */     arg.petId = this.petId;
/* 78 */     arg.roleId = this.roleId;
/* 79 */     TriggerEventsManger.getInstance().triggerEvent(new PetRest(), arg);
/* 80 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\main\PPetRestReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */