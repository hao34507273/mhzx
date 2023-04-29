/*     */ package mzm.gsp.task.operation;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.pet.main.Pet;
/*     */ import mzm.gsp.pet.main.PetBag;
/*     */ import mzm.gsp.pet.main.PetDeleteTLogEnum;
/*     */ import mzm.gsp.pet.main.PetInterface;
/*     */ import mzm.gsp.task.confbean.STaskOpertakePet;
/*     */ import mzm.gsp.task.operParamObj.TakePetsParamObj;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Oper_TakePets
/*     */   extends AbsOperation
/*     */ {
/*     */   public Oper_TakePets(int operId, STaskOpertakePet taskPets, int taskId)
/*     */   {
/*  27 */     super(operId, taskPets.operType, taskPets.teamType, taskId);
/*     */   }
/*     */   
/*     */   STaskOpertakePet getSTaskOpertakePet()
/*     */   {
/*  32 */     return STaskOpertakePet.get(getOperId());
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean check(long roleId, Map<Integer, Object> operParamsMap)
/*     */   {
/*  38 */     STaskOpertakePet taskPets = getSTaskOpertakePet();
/*  39 */     Long givePet = Long.valueOf(0L);
/*  40 */     if (taskPets.takePet <= 0)
/*     */     {
/*  42 */       return true;
/*     */     }
/*  44 */     PetBag petBag = PetInterface.getPetBag(roleId, false);
/*  45 */     if (!(operParamsMap.get(Integer.valueOf(this.operId)) instanceof TakePetsParamObj))
/*     */     {
/*  47 */       return false;
/*     */     }
/*  49 */     TakePetsParamObj givePetobj = (TakePetsParamObj)operParamsMap.get(Integer.valueOf(this.operId));
/*  50 */     List<Long> givePets = givePetobj.getGivePetIds();
/*  51 */     if (givePets.size() <= 0)
/*     */     {
/*  53 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/*  55 */         GameServer.logger().debug(String.format("[task]Oper_TakePets.check@玩家上交的宠物数量小于0！|roleId=%d|taskId=%d|needPetId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(getTaskId()), Integer.valueOf(taskPets.takePet) }));
/*     */       }
/*     */       
/*     */ 
/*  59 */       return false;
/*     */     }
/*  61 */     givePet = (Long)givePets.get(0);
/*  62 */     int petConfId = PetInterface.getPetCfgIdByPetId(roleId, givePet.longValue());
/*  63 */     if (taskPets.takePet != petConfId)
/*     */     {
/*  65 */       if (GameServer.logger().isDebugEnabled())
/*     */       {
/*  67 */         GameServer.logger().debug(String.format("[task]Oper_TakePets.check@玩家上交的宠物不满足任务条件！|roleId=%d|taskId=%d|needPetId=%d|givePetId", new Object[] { Long.valueOf(roleId), Integer.valueOf(getTaskId()), Integer.valueOf(taskPets.takePet), Integer.valueOf(petConfId) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*  72 */       return false;
/*     */     }
/*  74 */     Pet pet = petBag.getPetById(givePet.longValue());
/*  75 */     if (pet != null)
/*     */     {
/*  77 */       return true;
/*     */     }
/*  79 */     if (GameServer.logger().isDebugEnabled())
/*     */     {
/*  81 */       GameServer.logger().info(String.format("[task]Oper_TakePets.check@玩家上交的宠物不存在！|roleId=%d|taskId=%d|needPetId=%d|givePetId", new Object[] { Long.valueOf(roleId), Integer.valueOf(getTaskId()), Integer.valueOf(taskPets.takePet), Integer.valueOf(petConfId) }));
/*     */     }
/*     */     
/*     */ 
/*  85 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean execute(long roleId, Map<Integer, Object> operParamsMap, int graphId)
/*     */   {
/*  91 */     STaskOpertakePet taskPets = getSTaskOpertakePet();
/*  92 */     PetBag petBag = PetInterface.getPetBag(roleId, true);
/*  93 */     Long givePet = Long.valueOf(0L);
/*  94 */     if (!(operParamsMap.get(Integer.valueOf(this.operId)) instanceof TakePetsParamObj))
/*     */     {
/*  96 */       return false;
/*     */     }
/*  98 */     TakePetsParamObj givePetobj = (TakePetsParamObj)operParamsMap.get(Integer.valueOf(this.operId));
/*  99 */     List<Long> givePets = givePetobj.getGivePetIds();
/*     */     
/* 101 */     givePet = (Long)givePets.get(0);
/*     */     
/* 103 */     if (petBag.removePet(givePet.longValue(), PetDeleteTLogEnum.TASK_COST) != null)
/*     */     {
/* 105 */       return true;
/*     */     }
/* 107 */     if (GameServer.logger().isDebugEnabled())
/*     */     {
/* 109 */       GameServer.logger().debug(String.format("[task]Oper_TakePets.execute@移除玩家身上宠物失败！|roleId=%d|taskId=%d|needPetId=%d|givePetId", new Object[] { Long.valueOf(roleId), Integer.valueOf(getTaskId()), Integer.valueOf(taskPets.takePet), givePet }));
/*     */     }
/*     */     
/*     */ 
/* 113 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public void checkCfg()
/*     */   {
/* 119 */     STaskOpertakePet taskPets = getSTaskOpertakePet();
/* 120 */     if (!PetInterface.isPetCfgExist(taskPets.takePet))
/*     */     {
/* 122 */       throw new RuntimeException("任务配置宠物Id出错,petId:" + taskPets.takePet + " 取走宠物操作");
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\operation\Oper_TakePets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */