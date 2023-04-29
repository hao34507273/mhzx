/*     */ package mzm.gsp.task.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.task.condition.Con_ActivityFinishCount_17;
/*     */ import mzm.gsp.task.condition.Con_Bag_9;
/*     */ import mzm.gsp.task.condition.Con_GatherItem_14;
/*     */ import mzm.gsp.task.condition.Con_GraphFinishCount_13;
/*     */ import mzm.gsp.task.condition.Con_KillMonster_8;
/*     */ import mzm.gsp.task.condition.Con_KillNpc_6;
/*     */ import mzm.gsp.task.condition.Con_Leitai_16;
/*     */ import mzm.gsp.task.condition.Con_Level_1;
/*     */ import mzm.gsp.task.condition.Con_Npc_Dlg_3;
/*     */ import mzm.gsp.task.condition.Con_Pet_10;
/*     */ import mzm.gsp.task.condition.Con_Question_19;
/*     */ import mzm.gsp.task.condition.Con_Sex_2;
/*     */ import mzm.gsp.task.condition.Con_Share_20;
/*     */ import mzm.gsp.task.condition.Con_Team_7;
/*     */ import mzm.gsp.task.condition.Con_TimeLimit_12;
/*     */ import mzm.gsp.task.condition.Con_ToPlace_4;
/*     */ import mzm.gsp.task.condition.Con_UseTaskGoods_15;
/*     */ import mzm.gsp.task.condition.Con_WinCount_5;
/*     */ import mzm.gsp.task.confbean.SActivityFinishCount;
/*     */ import mzm.gsp.task.confbean.SLeiTaiWinCount;
/*     */ import mzm.gsp.task.confbean.STTaskId2PvcId;
/*     */ import mzm.gsp.task.confbean.STUseId2STaskPvcCfgId;
/*     */ import mzm.gsp.task.confbean.STask;
/*     */ import mzm.gsp.task.confbean.STaskConBag;
/*     */ import mzm.gsp.task.confbean.STaskConFinishQuestion;
/*     */ import mzm.gsp.task.confbean.STaskConSharePengYouQuan;
/*     */ import mzm.gsp.task.confbean.STaskConUseTaskGoods;
/*     */ import mzm.gsp.task.confbean.STaskCongatherItem;
/*     */ import mzm.gsp.task.confbean.STaskCongraphFinishCount;
/*     */ import mzm.gsp.task.confbean.STaskConkillMonsterCount;
/*     */ import mzm.gsp.task.confbean.STaskConkillNpc;
/*     */ import mzm.gsp.task.confbean.STaskConlevel;
/*     */ import mzm.gsp.task.confbean.STaskConnpcDialog;
/*     */ import mzm.gsp.task.confbean.STaskConpetCon;
/*     */ import mzm.gsp.task.confbean.STaskConsex;
/*     */ import mzm.gsp.task.confbean.STaskConteam;
/*     */ import mzm.gsp.task.confbean.STaskContimeLimit;
/*     */ import mzm.gsp.task.confbean.STaskContoPlace;
/*     */ import mzm.gsp.task.confbean.STaskConwinCount;
/*     */ import mzm.gsp.task.confbean.STaskOperAddBuff;
/*     */ import mzm.gsp.task.confbean.STaskOperCloseControler;
/*     */ import mzm.gsp.task.confbean.STaskOperControler;
/*     */ import mzm.gsp.task.confbean.STaskOperDelBuff;
/*     */ import mzm.gsp.task.confbean.STaskOperGiveTaskGoods;
/*     */ import mzm.gsp.task.confbean.STaskOperGoToPosition;
/*     */ import mzm.gsp.task.confbean.STaskOperPlayEffect;
/*     */ import mzm.gsp.task.confbean.STaskOpergiveAward;
/*     */ import mzm.gsp.task.confbean.STaskOperplayOpera;
/*     */ import mzm.gsp.task.confbean.STaskOpertakeGoods;
/*     */ import mzm.gsp.task.confbean.STaskOpertakeMoney;
/*     */ import mzm.gsp.task.confbean.STaskOpertakePet;
/*     */ import mzm.gsp.task.confbean.STaskPvcCfg;
/*     */ import mzm.gsp.task.operation.Oper_AddBuff;
/*     */ import mzm.gsp.task.operation.Oper_CloseControler;
/*     */ import mzm.gsp.task.operation.Oper_Controler;
/*     */ import mzm.gsp.task.operation.Oper_DelBuff;
/*     */ import mzm.gsp.task.operation.Oper_GiveAward;
/*     */ import mzm.gsp.task.operation.Oper_GiveTaskGoods;
/*     */ import mzm.gsp.task.operation.Oper_GoToPosition;
/*     */ import mzm.gsp.task.operation.Oper_PlayEffect;
/*     */ import mzm.gsp.task.operation.Oper_PlayOpera;
/*     */ import mzm.gsp.task.operation.Oper_TakeGoods;
/*     */ import mzm.gsp.task.operation.Oper_TakeMoney;
/*     */ import mzm.gsp.task.operation.Oper_TakePets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TaskManager
/*     */ {
/*  84 */   private static TaskManager instance = new TaskManager();
/*     */   
/*     */   static TaskManager getInstance()
/*     */   {
/*  88 */     return instance;
/*     */   }
/*     */   
/*  91 */   private Map<Integer, Task> idToTaskMap = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  96 */   private static Map<Integer, Integer> taskId2PvcId = new HashMap();
/*     */   
/*     */   public static Map<Integer, Integer> getTaskId2PvcId()
/*     */   {
/* 100 */     return taskId2PvcId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 106 */   private static Map<Integer, Integer> taskId2AwardId = new HashMap();
/*     */   
/*     */   public Map<Integer, Integer> getTaskId2AwardId()
/*     */   {
/* 110 */     return taskId2AwardId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 116 */   private static Map<Integer, STaskPvcCfg> useId2STaskPvcCfg = new HashMap();
/*     */   
/*     */   public static Map<Integer, STaskPvcCfg> getUseId2STaskPvcCfg()
/*     */   {
/* 120 */     return useId2STaskPvcCfg;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   String getTaskName(int taskId)
/*     */   {
/* 131 */     Task task = (Task)this.idToTaskMap.get(Integer.valueOf(taskId));
/* 132 */     if (task == null)
/*     */     {
/* 134 */       return "";
/*     */     }
/* 136 */     return task.getTaskName();
/*     */   }
/*     */   
/*     */   void init()
/*     */     throws Exception
/*     */   {
/* 142 */     for (STaskPvcCfg sCfg : STaskPvcCfg.getAll().values())
/*     */     {
/* 144 */       if (useId2STaskPvcCfg.containsKey(Integer.valueOf(sCfg.taskUseId)))
/*     */       {
/* 146 */         throw new Exception("3435_任务镜像战斗表 , 配置了相同的任务用id:" + sCfg.taskUseId);
/*     */       }
/* 148 */       useId2STaskPvcCfg.put(Integer.valueOf(sCfg.taskUseId), sCfg);
/*     */     }
/*     */     
/* 151 */     for (STask stask : STask.getAll().values())
/*     */     {
/* 153 */       Task task = new Task();
/* 154 */       task.setTaskId(stask.id);
/* 155 */       for (Iterator i$ = stask.conIds.iterator(); i$.hasNext();) { int conIdInt = ((Integer)i$.next()).intValue();
/*     */         
/* 157 */         if (STaskConBag.getAll().containsKey(Integer.valueOf(conIdInt)))
/*     */         {
/*     */ 
/* 160 */           STaskConBag conBag = STaskConBag.get(conIdInt);
/* 161 */           Con_Bag_9 conbBag_9 = new Con_Bag_9(conIdInt, conBag.contype, stask.id);
/* 162 */           task.addCondition(conbBag_9);
/*     */ 
/*     */         }
/* 165 */         else if (STaskConkillMonsterCount.getAll().containsKey(Integer.valueOf(conIdInt)))
/*     */         {
/*     */ 
/* 168 */           STaskConkillMonsterCount skillMonsterCount = STaskConkillMonsterCount.get(conIdInt);
/* 169 */           Con_KillMonster_8 conKillMonster_8 = new Con_KillMonster_8(conIdInt, skillMonsterCount.contype, stask.id);
/* 170 */           task.addCondition(conKillMonster_8);
/*     */ 
/*     */         }
/* 173 */         else if (STaskConkillNpc.getAll().containsKey(Integer.valueOf(conIdInt)))
/*     */         {
/*     */ 
/* 176 */           STaskConkillNpc sConkillNpc = STaskConkillNpc.get(conIdInt);
/* 177 */           int pvcId = sConkillNpc.pvcId;
/* 178 */           if (pvcId > 0)
/*     */           {
/* 180 */             taskId2PvcId.put(Integer.valueOf(stask.id), Integer.valueOf(sConkillNpc.pvcId));
/*     */           }
/* 182 */           Con_KillNpc_6 conKillNpc_6 = new Con_KillNpc_6(conIdInt, sConkillNpc.contype, stask.id);
/* 183 */           task.addCondition(conKillNpc_6);
/*     */ 
/*     */         }
/* 186 */         else if (STaskConlevel.getAll().containsKey(Integer.valueOf(conIdInt)))
/*     */         {
/*     */ 
/* 189 */           STaskConlevel sConLevel = STaskConlevel.get(conIdInt);
/* 190 */           Con_Level_1 conLevel = new Con_Level_1(conIdInt, sConLevel.contype, stask.id);
/* 191 */           task.addCondition(conLevel);
/*     */ 
/*     */         }
/* 194 */         else if (STaskConnpcDialog.getAll().containsKey(Integer.valueOf(conIdInt)))
/*     */         {
/*     */ 
/* 197 */           STaskConnpcDialog sConnpcDialog = STaskConnpcDialog.get(conIdInt);
/* 198 */           Con_Npc_Dlg_3 con_Npc_Dlg_3 = new Con_Npc_Dlg_3(conIdInt, sConnpcDialog.contype, stask.id);
/* 199 */           task.addCondition(con_Npc_Dlg_3);
/*     */ 
/*     */         }
/* 202 */         else if (STaskConpetCon.getAll().containsKey(Integer.valueOf(conIdInt)))
/*     */         {
/*     */ 
/* 205 */           STaskConpetCon conpetCon = STaskConpetCon.get(conIdInt);
/* 206 */           Con_Pet_10 conPet_10 = new Con_Pet_10(conIdInt, conpetCon.contype, stask.id);
/* 207 */           task.addCondition(conPet_10);
/*     */ 
/*     */         }
/* 210 */         else if (STaskConsex.getAll().containsKey(Integer.valueOf(conIdInt)))
/*     */         {
/*     */ 
/* 213 */           STaskConsex sConsex = STaskConsex.get(conIdInt);
/* 214 */           Con_Sex_2 con_Sex_2 = new Con_Sex_2(conIdInt, sConsex.contype, stask.id);
/* 215 */           task.addCondition(con_Sex_2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/* 226 */         else if (STaskConteam.getAll().containsKey(Integer.valueOf(conIdInt)))
/*     */         {
/*     */ 
/* 229 */           STaskConteam sTaskConteam = STaskConteam.get(conIdInt);
/* 230 */           Con_Team_7 conTeam_7 = new Con_Team_7(conIdInt, sTaskConteam.contype, stask.id);
/* 231 */           task.addCondition(conTeam_7);
/*     */ 
/*     */         }
/* 234 */         else if (STaskContimeLimit.getAll().containsKey(Integer.valueOf(conIdInt)))
/*     */         {
/*     */ 
/* 237 */           STaskContimeLimit contimeLimit = STaskContimeLimit.get(conIdInt);
/* 238 */           Con_TimeLimit_12 conTimeLimit_12 = new Con_TimeLimit_12(conIdInt, contimeLimit.contype, stask.id);
/* 239 */           task.addCondition(conTimeLimit_12);
/*     */ 
/*     */         }
/* 242 */         else if (STaskContoPlace.getAll().containsKey(Integer.valueOf(conIdInt)))
/*     */         {
/*     */ 
/* 245 */           STaskContoPlace sTaskContoPlace = STaskContoPlace.get(conIdInt);
/* 246 */           Con_ToPlace_4 con_ToPlace_4 = new Con_ToPlace_4(conIdInt, sTaskContoPlace.contype, stask.id);
/* 247 */           task.addCondition(con_ToPlace_4);
/*     */ 
/*     */         }
/* 250 */         else if (STaskConwinCount.getAll().containsKey(Integer.valueOf(conIdInt)))
/*     */         {
/*     */ 
/* 253 */           STaskConwinCount sTaskConwinCount = STaskConwinCount.get(conIdInt);
/* 254 */           Con_WinCount_5 con_WinCount_5 = new Con_WinCount_5(conIdInt, sTaskConwinCount.contype, stask.id);
/* 255 */           task.addCondition(con_WinCount_5);
/*     */ 
/*     */         }
/* 258 */         else if (STaskCongraphFinishCount.getAll().containsKey(Integer.valueOf(conIdInt)))
/*     */         {
/*     */ 
/* 261 */           STaskCongraphFinishCount sTaskCongraphFinishCount = STaskCongraphFinishCount.get(conIdInt);
/* 262 */           Con_GraphFinishCount_13 con_GraphFinishCount_13 = new Con_GraphFinishCount_13(conIdInt, sTaskCongraphFinishCount.contype, stask.id);
/*     */           
/*     */ 
/*     */ 
/* 266 */           task.addCondition(con_GraphFinishCount_13);
/*     */ 
/*     */         }
/* 269 */         else if (STaskCongatherItem.getAll().containsKey(Integer.valueOf(conIdInt)))
/*     */         {
/*     */ 
/* 272 */           STaskCongatherItem sTaskCongatherItem = STaskCongatherItem.get(conIdInt);
/* 273 */           Con_GatherItem_14 con_GatherItem_14 = new Con_GatherItem_14(conIdInt, sTaskCongatherItem.contype, stask.id);
/* 274 */           task.addCondition(con_GatherItem_14);
/*     */ 
/*     */         }
/* 277 */         else if (STaskConUseTaskGoods.getAll().containsKey(Integer.valueOf(conIdInt)))
/*     */         {
/* 279 */           STaskConUseTaskGoods sTaskConUseTaskGoods = STaskConUseTaskGoods.get(conIdInt);
/* 280 */           Con_UseTaskGoods_15 conTaskGoods_15 = new Con_UseTaskGoods_15(conIdInt, sTaskConUseTaskGoods.contype, stask.id);
/*     */           
/* 282 */           task.addCondition(conTaskGoods_15);
/*     */         }
/* 284 */         else if (SActivityFinishCount.getAll().containsKey(Integer.valueOf(conIdInt)))
/*     */         {
/* 286 */           SActivityFinishCount sActivityFinishCount = SActivityFinishCount.get(conIdInt);
/* 287 */           Con_ActivityFinishCount_17 conTaskActvity_17 = new Con_ActivityFinishCount_17(conIdInt, sActivityFinishCount.contype, stask.id);
/*     */           
/*     */ 
/* 290 */           task.addCondition(conTaskActvity_17);
/*     */         }
/* 292 */         else if (SLeiTaiWinCount.getAll().containsKey(Integer.valueOf(conIdInt)))
/*     */         {
/* 294 */           SLeiTaiWinCount sLeiTaiWinCount = SLeiTaiWinCount.get(conIdInt);
/* 295 */           Con_Leitai_16 con_Leitai_16 = new Con_Leitai_16(conIdInt, sLeiTaiWinCount.contype, stask.id);
/* 296 */           task.addCondition(con_Leitai_16);
/*     */         }
/* 298 */         else if (STaskConFinishQuestion.getAll().containsKey(Integer.valueOf(conIdInt)))
/*     */         {
/* 300 */           STaskConFinishQuestion sQuestion = STaskConFinishQuestion.get(conIdInt);
/* 301 */           Con_Question_19 con_Question_19 = new Con_Question_19(conIdInt, sQuestion.contype, stask.id);
/* 302 */           task.addCondition(con_Question_19);
/*     */         }
/* 304 */         else if (STaskConSharePengYouQuan.getAll().containsKey(Integer.valueOf(conIdInt)))
/*     */         {
/* 306 */           STaskConSharePengYouQuan sShare = STaskConSharePengYouQuan.get(conIdInt);
/* 307 */           Con_Share_20 con_Share_20 = new Con_Share_20(conIdInt, sShare.contype, stask.id);
/* 308 */           task.addCondition(con_Share_20);
/*     */         }
/*     */         else
/*     */         {
/* 312 */           throw new Exception("不存在的ConditionId:" + conIdInt);
/*     */         }
/*     */       }
/* 315 */       for (Iterator i$ = stask.operIds.iterator(); i$.hasNext();) { int operId = ((Integer)i$.next()).intValue();
/*     */         
/*     */ 
/* 318 */         if (STaskOpergiveAward.getAll().containsKey(Integer.valueOf(operId)))
/*     */         {
/*     */ 
/* 321 */           STaskOpergiveAward giveAward = STaskOpergiveAward.get(operId);
/* 322 */           Oper_GiveAward oper_GiveAward = new Oper_GiveAward(operId, giveAward, stask.id);
/* 323 */           task.addOperation(oper_GiveAward);
/*     */           
/* 325 */           taskId2AwardId.put(Integer.valueOf(stask.id), Integer.valueOf(giveAward.rewardId));
/*     */ 
/*     */         }
/* 328 */         else if (STaskOperplayOpera.getAll().containsKey(Integer.valueOf(operId)))
/*     */         {
/*     */ 
/* 331 */           STaskOperplayOpera operplayOpera = STaskOperplayOpera.get(operId);
/* 332 */           Oper_PlayOpera oper_PlayOpera = new Oper_PlayOpera(operId, operplayOpera, stask.id);
/* 333 */           task.addOperation(oper_PlayOpera);
/*     */ 
/*     */         }
/* 336 */         else if (STaskOpertakeGoods.getAll().containsKey(Integer.valueOf(operId)))
/*     */         {
/*     */ 
/* 339 */           STaskOpertakeGoods sTaskOpertakeGoods = STaskOpertakeGoods.get(operId);
/* 340 */           Oper_TakeGoods oper_TakeGoods = new Oper_TakeGoods(operId, sTaskOpertakeGoods, stask.id);
/* 341 */           task.addOperation(oper_TakeGoods);
/*     */ 
/*     */         }
/* 344 */         else if (STaskOpertakeMoney.getAll().containsKey(Integer.valueOf(operId)))
/*     */         {
/*     */ 
/* 347 */           STaskOpertakeMoney sOpertakeMoney = STaskOpertakeMoney.get(operId);
/* 348 */           Oper_TakeMoney oper_TakeMoney = new Oper_TakeMoney(operId, sOpertakeMoney, stask.id);
/* 349 */           task.addOperation(oper_TakeMoney);
/*     */ 
/*     */         }
/* 352 */         else if (STaskOpertakePet.getAll().containsKey(Integer.valueOf(operId)))
/*     */         {
/*     */ 
/* 355 */           STaskOpertakePet sOpertakePet = STaskOpertakePet.get(operId);
/* 356 */           Oper_TakePets oper_TakePets = new Oper_TakePets(operId, sOpertakePet, stask.id);
/* 357 */           task.addOperation(oper_TakePets);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/* 369 */         else if (STaskOperControler.getAll().containsKey(Integer.valueOf(operId)))
/*     */         {
/*     */ 
/* 372 */           STaskOperControler sTaskOperControler = STaskOperControler.get(operId);
/* 373 */           Oper_Controler oper_Controler = new Oper_Controler(operId, sTaskOperControler, stask.id);
/* 374 */           task.addOperation(oper_Controler);
/*     */ 
/*     */         }
/* 377 */         else if (STaskOperGiveTaskGoods.getAll().containsKey(Integer.valueOf(operId)))
/*     */         {
/*     */ 
/* 380 */           STaskOperGiveTaskGoods sTaskOperGiveTaskGoods = STaskOperGiveTaskGoods.get(operId);
/* 381 */           Oper_GiveTaskGoods giveTaskGoods = new Oper_GiveTaskGoods(operId, sTaskOperGiveTaskGoods, stask.id);
/* 382 */           task.addOperation(giveTaskGoods);
/*     */ 
/*     */         }
/* 385 */         else if (STaskOperPlayEffect.getAll().containsKey(Integer.valueOf(operId)))
/*     */         {
/*     */ 
/* 388 */           STaskOperPlayEffect sTaskOperPlayEffect = STaskOperPlayEffect.get(operId);
/* 389 */           Oper_PlayEffect playEffect = new Oper_PlayEffect(operId, sTaskOperPlayEffect, stask.id);
/* 390 */           task.addOperation(playEffect);
/*     */         }
/* 392 */         else if (STaskOperCloseControler.getAll().containsKey(Integer.valueOf(operId)))
/*     */         {
/* 394 */           STaskOperCloseControler sTaskOperCloseControler = STaskOperCloseControler.get(operId);
/* 395 */           Oper_CloseControler closeControler = new Oper_CloseControler(operId, sTaskOperCloseControler, stask.id);
/* 396 */           task.addOperation(closeControler);
/*     */         }
/* 398 */         else if (STaskOperGoToPosition.getAll().containsKey(Integer.valueOf(operId)))
/*     */         {
/* 400 */           STaskOperGoToPosition sTaskOperGoToPosition = STaskOperGoToPosition.get(operId);
/* 401 */           Oper_GoToPosition goToPosition = new Oper_GoToPosition(operId, sTaskOperGoToPosition, stask.id);
/* 402 */           task.addOperation(goToPosition);
/*     */         }
/* 404 */         else if (STaskOperAddBuff.getAll().containsKey(Integer.valueOf(operId)))
/*     */         {
/* 406 */           STaskOperAddBuff sTaskOperAddBuff = STaskOperAddBuff.get(operId);
/* 407 */           Oper_AddBuff addBuff = new Oper_AddBuff(operId, sTaskOperAddBuff, stask.id);
/* 408 */           task.addOperation(addBuff);
/*     */         }
/* 410 */         else if (STaskOperDelBuff.getAll().containsKey(Integer.valueOf(operId)))
/*     */         {
/* 412 */           STaskOperDelBuff sTaskOperDelBuff = STaskOperDelBuff.get(operId);
/* 413 */           Oper_DelBuff delBuff = new Oper_DelBuff(operId, sTaskOperDelBuff, stask.id);
/* 414 */           task.addOperation(delBuff);
/*     */         }
/*     */         else
/*     */         {
/* 418 */           throw new Exception("不存在的operId:" + operId);
/*     */         }
/*     */       }
/*     */       
/* 422 */       this.idToTaskMap.put(Integer.valueOf(stask.id), task);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void clearCfgCacheData()
/*     */   {
/* 430 */     STask.getAll().clear();
/* 431 */     STaskConBag.getAll().clear();
/* 432 */     STaskConkillMonsterCount.getAll().clear();
/* 433 */     STaskConkillNpc.getAll().clear();
/* 434 */     STaskConlevel.getAll().clear();
/* 435 */     STaskConnpcDialog.getAll().clear();
/* 436 */     STaskConpetCon.getAll().clear();
/* 437 */     STaskConsex.getAll().clear();
/*     */     
/* 439 */     STaskConteam.getAll().clear();
/* 440 */     STaskContimeLimit.getAll().clear();
/* 441 */     STaskContoPlace.getAll().clear();
/* 442 */     STaskConwinCount.getAll().clear();
/* 443 */     STaskCongraphFinishCount.getAll().clear();
/* 444 */     STaskCongatherItem.getAll().clear();
/*     */     
/* 446 */     STaskOpergiveAward.getAll().clear();
/* 447 */     STaskOperplayOpera.getAll().clear();
/* 448 */     STaskOpertakeGoods.getAll().clear();
/* 449 */     STaskOpertakeMoney.getAll().clear();
/* 450 */     STaskOpertakePet.getAll().clear();
/*     */     
/* 452 */     STaskOperControler.getAll().clear();
/*     */   }
/*     */   
/*     */   public static Task getTaskById(int taskId)
/*     */   {
/* 457 */     return (Task)instance.idToTaskMap.get(Integer.valueOf(taskId));
/*     */   }
/*     */   
/*     */   static boolean isHasTask(int taskId)
/*     */   {
/* 462 */     return instance.idToTaskMap.containsKey(Integer.valueOf(taskId));
/*     */   }
/*     */   
/*     */   public void checkCfg()
/*     */   {
/* 467 */     for (Task task : this.idToTaskMap.values())
/*     */     {
/* 469 */       task.checkCfg();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   STaskPvcCfg getPvcCfg(int taskId)
/*     */   {
/* 482 */     return getSTaskPvcCfg(getPvcIdBy(taskId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   int getPvcIdBy(int taskId)
/*     */   {
/* 494 */     STTaskId2PvcId sTTaskId2PvcId = STTaskId2PvcId.get(taskId);
/* 495 */     if (sTTaskId2PvcId == null)
/*     */     {
/* 497 */       return -1;
/*     */     }
/* 499 */     return sTTaskId2PvcId.pvcId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   STaskPvcCfg getSTaskPvcCfg(int pvcId4TaskId)
/*     */   {
/* 511 */     if (pvcId4TaskId <= 0)
/*     */     {
/* 513 */       return null;
/*     */     }
/* 515 */     STUseId2STaskPvcCfgId cfg = STUseId2STaskPvcCfgId.get(pvcId4TaskId);
/* 516 */     if (cfg == null)
/*     */     {
/* 518 */       return null;
/*     */     }
/* 520 */     int sTaskPvcCfgId = cfg.sTaskPvcCfgId;
/* 521 */     return STaskPvcCfg.get(sTaskPvcCfgId);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\task\main\TaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */