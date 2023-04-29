/*     */ package mzm.gsp.instance.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activitycompensate.main.ActivityCompensateInterface;
/*     */ import mzm.gsp.award.AwardBean;
/*     */ import mzm.gsp.award.SSendDefaultAwardInfo;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.fight.main.FightInterface;
/*     */ import mzm.gsp.fight.main.FightReason;
/*     */ import mzm.gsp.idip.main.IdipManager;
/*     */ import mzm.gsp.instance.Item2Count;
/*     */ import mzm.gsp.instance.SLeaveInstanceRes;
/*     */ import mzm.gsp.instance.SSingleBossAward;
/*     */ import mzm.gsp.instance.SSingleInfoRes;
/*     */ import mzm.gsp.instance.SUpdateSingleInfo;
/*     */ import mzm.gsp.instance.SingleInfo;
/*     */ import mzm.gsp.instance.confbean.SInstanceCfg;
/*     */ import mzm.gsp.instance.confbean.SInstanceConsts;
/*     */ import mzm.gsp.instance.confbean.SingleInstanceData;
/*     */ import mzm.gsp.instance.confbean.SingleInstanceSaoDangCfg;
/*     */ import mzm.gsp.instance.event.SingleFightArg;
/*     */ import mzm.gsp.instance.event.SingleInstanceFightEvent;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.item.main.ItemOperateResult;
/*     */ import mzm.gsp.item.main.LotteryManager;
/*     */ import mzm.gsp.item.main.access.ItemAccessManager;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.monster.confbean.SInstanceMonster;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.CostResult;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.InstanceBean;
/*     */ import xbean.InstanceCacheBean;
/*     */ import xbean.Pod;
/*     */ import xbean.ProcessBean;
/*     */ import xdb.Xdb;
/*     */ import xtable.Instance;
/*     */ import xtable.Role2instanceuuid;
/*     */ 
/*     */ class SingleInstance
/*     */ {
/*     */   static boolean reqSaoDang(String userid, long roleid, int instanceCfgid, int toProcessid, int costItemNum, int costYuanBaoNum, InstanceBean xInstanceBean)
/*     */   {
/*  65 */     SingleInstanceSaoDangCfg saoDangCfg = SingleInstanceSaoDangCfg.get(instanceCfgid);
/*  66 */     if (saoDangCfg == null)
/*     */     {
/*  68 */       GameServer.logger().info(String.format("[SingleInstance]SingleInstance.reqSaoDang@param error|roleid=%d|instanceid=%d|to_processid=%d|cost_item_num=%d|cost_yuanbao_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(instanceCfgid), Integer.valueOf(toProcessid), Integer.valueOf(costItemNum), Integer.valueOf(costYuanBaoNum) }));
/*     */       
/*     */ 
/*     */ 
/*  72 */       return false;
/*     */     }
/*  74 */     SingleInstanceData singleInstanceDataCfg = InstanceCfgManager.getSingleInstanceCfg(instanceCfgid, toProcessid);
/*  75 */     if (singleInstanceDataCfg == null)
/*     */     {
/*  77 */       GameServer.logger().info(String.format("[SingleInstance]SingleInstance.reqSaoDang@param error|roleid=%d|instanceid=%d|to_processid=%d|cost_item_num=%d|cost_yuanbao_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(instanceCfgid), Integer.valueOf(toProcessid), Integer.valueOf(costItemNum), Integer.valueOf(costYuanBaoNum) }));
/*     */       
/*     */ 
/*     */ 
/*  81 */       return false;
/*     */     }
/*  83 */     if (xInstanceBean == null)
/*     */     {
/*  85 */       GameServer.logger().info(String.format("[SingleInstance]SingleInstance.reqSaoDang@no instance data|roleid=%d|instanceid=%d|to_processid=%d|cost_item_num=%d|cost_yuanbao_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(instanceCfgid), Integer.valueOf(toProcessid), Integer.valueOf(costItemNum), Integer.valueOf(costYuanBaoNum) }));
/*     */       
/*     */ 
/*     */ 
/*  89 */       return false;
/*     */     }
/*  91 */     if (xInstanceBean.getSinglefailtime() >= SInstanceConsts.getInstance().SINGLE_INSTANCE_FAIL_TIMES)
/*     */     {
/*  93 */       GameServer.logger().info(String.format("[SingleInstance]SingleInstance.reqSaoDang@fail times to limit|roleid=%d|instanceid=%d|to_processid=%d|cost_item_num=%d|cost_yuanbao_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(instanceCfgid), Integer.valueOf(toProcessid), Integer.valueOf(costItemNum), Integer.valueOf(costYuanBaoNum) }));
/*     */       
/*     */ 
/*     */ 
/*  97 */       return false;
/*     */     }
/*  99 */     xbean.SingleInstance xSingleInstance = (xbean.SingleInstance)xInstanceBean.getSingleinstancemap().get(Integer.valueOf(instanceCfgid));
/* 100 */     if (xSingleInstance == null)
/*     */     {
/* 102 */       GameServer.logger().info(String.format("[SingleInstance]SingleInstance.reqSaoDang@no instance data|roleid=%d|instanceid=%d|to_processid=%d|cost_item_num=%d|cost_yuanbao_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(instanceCfgid), Integer.valueOf(toProcessid), Integer.valueOf(costItemNum), Integer.valueOf(costYuanBaoNum) }));
/*     */       
/*     */ 
/*     */ 
/* 106 */       return false;
/*     */     }
/* 108 */     if (xSingleInstance.getSign() == 0)
/*     */     {
/* 110 */       GameServer.logger().info(String.format("[SingleInstance]SingleInstance.reqSaoDang@instance is closed|roleid=%d|instanceid=%d|to_processid=%d|cost_item_num=%d|cost_yuanbao_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(instanceCfgid), Integer.valueOf(toProcessid), Integer.valueOf(costItemNum), Integer.valueOf(costYuanBaoNum) }));
/*     */       
/*     */ 
/*     */ 
/* 114 */       return false;
/*     */     }
/* 116 */     if (xSingleInstance.getHighprocess() < saoDangCfg.sao_dang_open_process_id)
/*     */     {
/* 118 */       GameServer.logger().info(String.format("[SingleInstance]SingleInstance.reqSaoDang@cannot sao dang|roleid=%d|instanceid=%d|to_processid=%d|cost_item_num=%d|cost_yuanbao_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(instanceCfgid), Integer.valueOf(toProcessid), Integer.valueOf(costItemNum), Integer.valueOf(costYuanBaoNum) }));
/*     */       
/*     */ 
/*     */ 
/* 122 */       return false;
/*     */     }
/* 124 */     if (toProcessid < xSingleInstance.getCurprocess())
/*     */     {
/* 126 */       GameServer.logger().info(String.format("[SingleInstance]SingleInstance.reqSaoDang@to process error|roleid=%d|instanceid=%d|to_processid=%d|cost_item_num=%d|cost_yuanbao_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(instanceCfgid), Integer.valueOf(toProcessid), Integer.valueOf(costItemNum), Integer.valueOf(costYuanBaoNum) }));
/*     */       
/*     */ 
/*     */ 
/* 130 */       return false;
/*     */     }
/* 132 */     if (toProcessid != xSingleInstance.getHighprocess() - saoDangCfg.sao_dang_reserve_process_num)
/*     */     {
/* 134 */       GameServer.logger().info(String.format("[SingleInstance]SingleInstance.reqSaoDang@to process error|roleid=%d|instanceid=%d|to_processid=%d|cost_item_num=%d|cost_yuanbao_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(instanceCfgid), Integer.valueOf(toProcessid), Integer.valueOf(costItemNum), Integer.valueOf(costYuanBaoNum) }));
/*     */       
/*     */ 
/*     */ 
/* 138 */       return false;
/*     */     }
/*     */     
/* 141 */     if (InstanceInterface.isRoleInInstance(roleid, true))
/*     */     {
/* 143 */       GameServer.logger().info(String.format("[SingleInstance]SingleInstance.reqSaoDang@role in instance|roleid=%d|instanceid=%d|to_processid=%d|cost_item_num=%d|cost_yuanbao_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(instanceCfgid), Integer.valueOf(toProcessid), Integer.valueOf(costItemNum), Integer.valueOf(costYuanBaoNum) }));
/*     */       
/*     */ 
/*     */ 
/* 147 */       return false;
/*     */     }
/*     */     
/* 150 */     if (SInstanceCfg.get(instanceCfgid).finishTime <= xSingleInstance.getFinishtimes())
/*     */     {
/* 152 */       GameServer.logger().info(String.format("[SingleInstance]SingleInstance.reqSaoDang@finish times to limit|roleid=%d|instanceid=%d|to_processid=%d|cost_item_num=%d|cost_yuanbao_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(instanceCfgid), Integer.valueOf(toProcessid), Integer.valueOf(costItemNum), Integer.valueOf(costYuanBaoNum) }));
/*     */       
/*     */ 
/*     */ 
/* 156 */       return false;
/*     */     }
/* 158 */     int needItemNum = 0;
/* 159 */     for (int processid = xSingleInstance.getCurprocess(); processid <= toProcessid; processid++)
/*     */     {
/* 161 */       SingleInstanceData dataCfg = InstanceCfgManager.getSingleInstanceCfg(instanceCfgid, processid);
/* 162 */       if (singleInstanceDataCfg == null)
/*     */       {
/* 164 */         GameServer.logger().info(String.format("[SingleInstance]SingleInstance.reqSaoDang@param error|roleid=%d|instanceid=%d|to_processid=%d|cost_item_num=%d|cost_yuanbao_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(instanceCfgid), Integer.valueOf(toProcessid), Integer.valueOf(costItemNum), Integer.valueOf(costYuanBaoNum) }));
/*     */         
/*     */ 
/*     */ 
/* 168 */         return false;
/*     */       }
/* 170 */       needItemNum += dataCfg.sao_dang_item_num;
/*     */     }
/* 172 */     if (needItemNum <= 0)
/*     */     {
/* 174 */       GameServer.logger().info(String.format("[SingleInstance]SingleInstance.reqSaoDang@need item num error|roleid=%d|instanceid=%d|to_processid=%d|cost_item_num=%d|cost_yuanbao_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(instanceCfgid), Integer.valueOf(toProcessid), Integer.valueOf(costItemNum), Integer.valueOf(costYuanBaoNum) }));
/*     */       
/*     */ 
/*     */ 
/* 178 */       return false;
/*     */     }
/* 180 */     if ((costItemNum < 0) || (costItemNum > needItemNum))
/*     */     {
/* 182 */       GameServer.logger().info(String.format("[SingleInstance]SingleInstance.reqSaoDang@cost item num error|roleid=%d|instanceid=%d|to_processid=%d|cost_item_num=%d|cost_yuanbao_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(instanceCfgid), Integer.valueOf(toProcessid), Integer.valueOf(costItemNum), Integer.valueOf(costYuanBaoNum) }));
/*     */       
/*     */ 
/*     */ 
/* 186 */       return false;
/*     */     }
/*     */     
/* 189 */     int num = ItemInterface.getItemNumberById(roleid, saoDangCfg.cost_item_id);
/* 190 */     int realCostItemNum = 0;
/* 191 */     if (num > 0)
/*     */     {
/* 193 */       if (((num >= needItemNum) && (needItemNum != costItemNum)) || ((num < needItemNum) && (num != costItemNum)))
/*     */       {
/* 195 */         GameServer.logger().info(String.format("[SingleInstance]SingleInstance.reqSaoDang@cost item num not match|roleid=%d|instanceid=%d|to_processid=%d|cost_item_num=%d|cost_yuanbao_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(instanceCfgid), Integer.valueOf(toProcessid), Integer.valueOf(costItemNum), Integer.valueOf(costYuanBaoNum) }));
/*     */         
/*     */ 
/*     */ 
/* 199 */         return false;
/*     */       }
/* 201 */       if (!ItemInterface.removeItemById(roleid, 340600000, saoDangCfg.cost_item_id, costItemNum, new TLogArg(LogReason.INSTANCE_SAO_DANG_REM, instanceCfgid)))
/*     */       {
/*     */ 
/* 204 */         GameServer.logger().info(String.format("[SingleInstance]SingleInstance.reqSaoDang@cost item error|roleid=%d|instanceid=%d|to_processid=%d|cost_item_num=%d|cost_yuanbao_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(instanceCfgid), Integer.valueOf(toProcessid), Integer.valueOf(costItemNum), Integer.valueOf(costYuanBaoNum) }));
/*     */         
/*     */ 
/*     */ 
/* 208 */         return false;
/*     */       }
/* 210 */       realCostItemNum = costItemNum;
/*     */     }
/* 212 */     int restNeedItemNum = needItemNum - realCostItemNum;
/* 213 */     if (restNeedItemNum > 0)
/*     */     {
/* 215 */       int needYuanBaoNum = ItemInterface.getItemYuanBaoPrice(saoDangCfg.cost_item_id) * restNeedItemNum;
/* 216 */       if (needYuanBaoNum <= 0)
/*     */       {
/* 218 */         GameServer.logger().info(String.format("[SingleInstance]SingleInstance.reqSaoDang@need yuanbao num error|roleid=%d|instanceid=%d|to_processid=%d|cost_item_num=%d|cost_yuanbao_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(instanceCfgid), Integer.valueOf(toProcessid), Integer.valueOf(costItemNum), Integer.valueOf(costYuanBaoNum) }));
/*     */         
/*     */ 
/*     */ 
/* 222 */         return false;
/*     */       }
/* 224 */       if (needYuanBaoNum != costYuanBaoNum)
/*     */       {
/* 226 */         GameServer.logger().info(String.format("[SingleInstance]SingleInstance.reqSaoDang@cost yuanbao num not match|roleid=%d|instanceid=%d|to_processid=%d|cost_item_num=%d|cost_yuanbao_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(instanceCfgid), Integer.valueOf(toProcessid), Integer.valueOf(costItemNum), Integer.valueOf(costYuanBaoNum) }));
/*     */         
/*     */ 
/*     */ 
/* 230 */         return false;
/*     */       }
/* 232 */       if (QingfuInterface.costYuanbao(userid, roleid, costYuanBaoNum, mzm.gsp.qingfu.main.CostType.COST_BIND_FIRST_SINGLE_INSTANCE_SAO_DANG, new TLogArg(LogReason.INSTANCE_SAO_DANG_REM, instanceCfgid)) != CostResult.Success)
/*     */       {
/*     */ 
/* 235 */         GameServer.logger().info(String.format("[SingleInstance]SingleInstance.reqSaoDang@cost yuanbao error|roleid=%d|instanceid=%d|to_processid=%d|cost_item_num=%d|cost_yuanbao_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(instanceCfgid), Integer.valueOf(toProcessid), Integer.valueOf(costItemNum), Integer.valueOf(costYuanBaoNum) }));
/*     */         
/*     */ 
/*     */ 
/* 239 */         return false;
/*     */       }
/*     */     }
/* 242 */     for (int processid = xSingleInstance.getCurprocess(); processid <= toProcessid; processid++)
/*     */     {
/* 244 */       int origialInstanceProcessid = xSingleInstance.getCurprocess();
/* 245 */       SingleInstanceData origialInstanceDataCfg = InstanceCfgManager.getSingleInstanceCfg(instanceCfgid, origialInstanceProcessid);
/*     */       
/* 247 */       if (isCanRewardRole(roleid, xSingleInstance, instanceCfgid))
/*     */       {
/* 249 */         if (!sendInstanceAwardbySaoDang(userid, roleid, instanceCfgid, origialInstanceDataCfg))
/*     */         {
/*     */ 
/* 252 */           GameServer.logger().info(String.format("[SingleInstance]SingleInstance.reqSaoDang@award error|roleid=%d|instanceid=%d|to_processid=%d|cost_item_num=%d|cost_yuanbao_num=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(instanceCfgid), Integer.valueOf(toProcessid), Integer.valueOf(costItemNum), Integer.valueOf(costYuanBaoNum) }));
/*     */           
/*     */ 
/*     */ 
/* 256 */           return false;
/*     */         }
/*     */       }
/* 259 */       boolean sendProtocol = processid == toProcessid;
/* 260 */       enterNextProcessBySaoDang(roleid, xInstanceBean, instanceCfgid, xSingleInstance, sendProtocol);
/*     */       
/* 262 */       SingleFightArg singleFightArg = new SingleFightArg(roleid, instanceCfgid, true);
/* 263 */       SingleInstanceFightEvent singleInstanceFightEvent = new SingleInstanceFightEvent();
/* 264 */       TriggerEventsManger.getInstance().triggerEvent(singleInstanceFightEvent, singleFightArg);
/*     */     }
/*     */     
/* 267 */     InstanceManager.sendNormalRet(roleid, 10, new String[0]);
/* 268 */     return true;
/*     */   }
/*     */   
/*     */   static boolean isCanRewardRole(long roleid, xbean.SingleInstance xSingleInstance, int instanceCfgid) {
/* 272 */     return xSingleInstance.getFinishtimes() < SInstanceCfg.get(instanceCfgid).finishTime;
/*     */   }
/*     */   
/*     */ 
/*     */   static void enterNextProcessBySaoDang(long roleid, InstanceBean xInstanceBean, int instanceCfgid, xbean.SingleInstance xSingleInstance, boolean sendProtocol)
/*     */   {
/* 278 */     SInstanceCfg instanceCfg = SInstanceCfg.get(instanceCfgid);
/* 279 */     int curProcess = xSingleInstance.getCurprocess();
/*     */     
/* 281 */     ProcessBean processBean = (ProcessBean)xSingleInstance.getProcessmap().get(Integer.valueOf(curProcess));
/* 282 */     if (processBean == null)
/*     */     {
/* 284 */       processBean = Pod.newProcessBean();
/* 285 */       xSingleInstance.getProcessmap().put(Integer.valueOf(curProcess), processBean);
/*     */     }
/* 287 */     processBean.setSuctimes(processBean.getSuctimes() + 1);
/*     */     
/* 289 */     if (curProcess > xSingleInstance.getHighprocess())
/*     */     {
/* 291 */       xSingleInstance.setHighprocess(curProcess);
/*     */     }
/* 293 */     int nextcurProcess = curProcess + 1;
/* 294 */     SingleInstanceData singleInstanceDataCfg = InstanceCfgManager.getSingleInstanceCfg(instanceCfgid, nextcurProcess);
/* 295 */     if (singleInstanceDataCfg == null)
/*     */     {
/* 297 */       xSingleInstance.setFinishtimes(xSingleInstance.getFinishtimes() + 1);
/* 298 */       if (xSingleInstance.getFinishtimes() < instanceCfg.finishTime)
/*     */       {
/* 300 */         xSingleInstance.setCurprocess(1);
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 305 */       xSingleInstance.setCurprocess(nextcurProcess);
/*     */     }
/*     */     
/* 308 */     if (sendProtocol)
/*     */     {
/*     */ 
/* 311 */       SUpdateSingleInfo updateSingleInfo = new SUpdateSingleInfo();
/* 312 */       updateSingleInfo.failtime = xInstanceBean.getSinglefailtime();
/* 313 */       fillInSingleInfo(updateSingleInfo.singleinfo, xSingleInstance.getHighprocess(), xSingleInstance.getCurprocess(), xSingleInstance.getFinishtimes(), instanceCfgid, xSingleInstance.getSign());
/*     */       
/* 315 */       OnlineManager.getInstance().send(roleid, updateSingleInfo);
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
/*     */   static void enterNextProcess(long roleid, InstanceBean xInstanceBean, int instanceCfgid, xbean.SingleInstance xSingleInstance, int second)
/*     */   {
/* 328 */     SInstanceCfg instanceCfg = SInstanceCfg.get(instanceCfgid);
/* 329 */     int curProcess = xSingleInstance.getCurprocess();
/*     */     
/* 331 */     ProcessBean processBean = (ProcessBean)xSingleInstance.getProcessmap().get(Integer.valueOf(curProcess));
/* 332 */     if (processBean == null) {
/* 333 */       processBean = Pod.newProcessBean();
/* 334 */       xSingleInstance.getProcessmap().put(Integer.valueOf(curProcess), processBean);
/*     */     }
/* 336 */     processBean.setSuctimes(processBean.getSuctimes() + 1);
/* 337 */     if ((second > 0) && (
/* 338 */       (processBean.getSecond() <= 0) || (second < processBean.getSecond()))) {
/* 339 */       processBean.setSecond(second);
/*     */     }
/*     */     
/*     */ 
/* 343 */     if (curProcess > xSingleInstance.getHighprocess()) {
/* 344 */       xSingleInstance.setHighprocess(curProcess);
/*     */     }
/* 346 */     int nextcurProcess = curProcess + 1;
/* 347 */     SingleInstanceData singleInstanceDataCfg = InstanceCfgManager.getSingleInstanceCfg(instanceCfgid, nextcurProcess);
/*     */     
/* 349 */     if (singleInstanceDataCfg == null) {
/* 350 */       xSingleInstance.setFinishtimes(xSingleInstance.getFinishtimes() + 1);
/* 351 */       if (xSingleInstance.getFinishtimes() < instanceCfg.finishTime) {
/* 352 */         xSingleInstance.setCurprocess(1);
/*     */       }
/*     */     } else {
/* 355 */       xSingleInstance.setCurprocess(nextcurProcess);
/*     */     }
/*     */     
/*     */ 
/* 359 */     SUpdateSingleInfo updateSingleInfo = new SUpdateSingleInfo();
/* 360 */     updateSingleInfo.failtime = xInstanceBean.getSinglefailtime();
/* 361 */     fillInSingleInfo(updateSingleInfo.singleinfo, xSingleInstance.getHighprocess(), xSingleInstance.getCurprocess(), xSingleInstance.getFinishtimes(), instanceCfgid, xSingleInstance.getSign());
/*     */     
/*     */ 
/* 364 */     OnlineManager.getInstance().send(roleid, updateSingleInfo);
/*     */   }
/*     */   
/*     */   static void fillInSingleInfo(SingleInfo singleinfo, int highProcess, int curProcess, int finishTimes, int instancecfgid, int sign)
/*     */   {
/* 369 */     singleinfo.highprocess = highProcess;
/* 370 */     singleinfo.curprocess = curProcess;
/* 371 */     singleinfo.finishtimes = finishTimes;
/* 372 */     singleinfo.instancecfgid = instancecfgid;
/* 373 */     singleinfo.sign = sign;
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean onleaveInstance(long roleid, long instanceUuid, InstanceCacheBean xInstanceCacheBean, InstanceBean xInstanceBean)
/*     */   {
/* 393 */     SInstanceCfg instanceCfg = SInstanceCfg.get(xInstanceCacheBean.getInstancecfgid());
/*     */     
/* 395 */     long worldid = xInstanceCacheBean.getWorldid();
/*     */     
/*     */ 
/* 398 */     Role2instanceuuid.remove(Long.valueOf(roleid));
/*     */     
/* 400 */     Instance.remove(Long.valueOf(instanceUuid));
/*     */     
/* 402 */     RoleStatusInterface.unsetStatus(roleid, 13);
/*     */     
/* 404 */     MapInterface.forceTransferToScene(roleid, instanceCfg.out_mapid, instanceCfg.out_x, instanceCfg.out_y);
/*     */     
/* 406 */     MapInterface.destroyWorld(worldid);
/*     */     
/* 408 */     TeamInterface.unRegisterJoinTeam(worldid);
/*     */     
/*     */ 
/* 411 */     long passtime = (DateTimeUtils.getCurrTimeInMillis() - xInstanceCacheBean.getOpentime()) / 1000L;
/* 412 */     InstanceManager.logInstance(roleid, instanceUuid, instanceCfg.id, 4, passtime, ((xbean.SingleInstance)xInstanceBean.getSingleinstancemap().get(Integer.valueOf(instanceCfg.id))).getCurprocess(), 1);
/*     */     
/* 414 */     InstanceManager.tlogInstance(roleid, instanceUuid, instanceCfg.id, 4, passtime, ((xbean.SingleInstance)xInstanceBean.getSingleinstancemap().get(Integer.valueOf(instanceCfg.id))).getCurprocess());
/*     */     
/*     */ 
/* 417 */     SLeaveInstanceRes leaveInstanceRes = new SLeaveInstanceRes();
/* 418 */     leaveInstanceRes.instancetype = instanceCfg.instanceType;
/* 419 */     leaveInstanceRes.instancecfgid = instanceCfg.id;
/* 420 */     OnlineManager.getInstance().send(roleid, leaveInstanceRes);
/* 421 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void fightMonster(long roleid, int monsterInstanceid, long instanceUuid, InstanceCacheBean xInstanceCacheBean, InstanceBean xInstanceBean)
/*     */   {
/* 432 */     int instanceid = xInstanceCacheBean.getInstancecfgid();
/*     */     
/* 434 */     if (xInstanceBean.getSinglefailtime() >= SInstanceConsts.getInstance().SINGLE_INSTANCE_FAIL_TIMES) {
/* 435 */       if (GameServer.logger().isDebugEnabled())
/* 436 */         GameServer.logger().debug("单人挑战的失败次数不足!!!!");
/* 437 */       return;
/*     */     }
/* 439 */     xbean.SingleInstance xSingleInstance = (xbean.SingleInstance)xInstanceBean.getSingleinstancemap().get(Integer.valueOf(instanceid));
/* 440 */     int processid = xSingleInstance.getCurprocess();
/* 441 */     SingleInstanceData singleInstanceDataCfg = InstanceCfgManager.getSingleInstanceCfg(instanceid, processid);
/* 442 */     int monsterid = MapInterface.getVisibleMonsterCfgId(monsterInstanceid);
/* 443 */     if (singleInstanceDataCfg.monsterid != monsterid) {
/* 444 */       if (GameServer.logger().isDebugEnabled())
/* 445 */         GameServer.logger().debug("单人副本攻打怪物不一致!!!");
/* 446 */       return;
/*     */     }
/* 448 */     SInstanceCfg instanceCfg = SInstanceCfg.get(instanceid);
/*     */     
/* 450 */     SInstanceMonster instanceMonster = SInstanceMonster.get(monsterid);
/* 451 */     SingleInstanceFightContext fightContext = new SingleInstanceFightContext(monsterInstanceid, instanceid, processid);
/*     */     
/* 453 */     FightInterface.startPVEFight(roleid, instanceMonster.monsterFightTableId, fightContext, instanceCfg.fightType, FightReason.INSTANCE);
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean fightResult(String userid, long roleid, boolean isWin, int second, SingleInstanceFightContext fightContext, InstanceBean xInstanceBean, long instanceUuid, InstanceCacheBean xInstanceCacheBean)
/*     */   {
/* 473 */     int instanceid = xInstanceCacheBean.getInstancecfgid();
/* 474 */     xbean.SingleInstance xSingleInstance = (xbean.SingleInstance)xInstanceBean.getSingleinstancemap().get(Integer.valueOf(instanceid));
/* 475 */     long passtime = (DateTimeUtils.getCurrTimeInMillis() - xInstanceCacheBean.getOpentime()) / 1000L;
/*     */     
/* 477 */     if (isWin) {
/* 478 */       int origalFinishTime = xSingleInstance.getFinishtimes();
/*     */       
/* 480 */       int origialInstanceProcessid = xSingleInstance.getCurprocess();
/* 481 */       SingleInstanceData origialInstanceDataCfg = InstanceCfgManager.getSingleInstanceCfg(instanceid, origialInstanceProcessid);
/*     */       
/* 483 */       if (isCanRewardRole(roleid, xSingleInstance, instanceid)) {
/* 484 */         boolean ret = sendInstanceAward(userid, roleid, instanceid, origialInstanceDataCfg);
/* 485 */         if (!ret)
/*     */         {
/* 487 */           return ret;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 492 */       if (origialInstanceDataCfg.triggerid > 0) {
/* 493 */         ControllerInterface.triggerController(roleid, origialInstanceDataCfg.triggerid);
/*     */       }
/*     */       
/* 496 */       enterNextProcess(roleid, xInstanceBean, instanceid, xSingleInstance, second);
/* 497 */       int nowFinishTime = xSingleInstance.getFinishtimes();
/* 498 */       if (nowFinishTime > origalFinishTime) {
/* 499 */         MapInterface.destroyVisibleMonster(fightContext.monsterInstanceid);
/*     */         
/* 501 */         new SingleInstanceLeaveTimer(SInstanceConsts.getInstance().SINGLE_INSTANCE_LEAVE_TIMER, instanceUuid, roleid);
/*     */       }
/*     */       else {
/* 504 */         SingleInstanceData cursingleInstanceDataCfg = InstanceCfgManager.getSingleInstanceCfg(instanceid, xSingleInstance.getCurprocess());
/*     */         
/*     */ 
/* 507 */         MapInterface.destroyVisibleMonster(fightContext.monsterInstanceid);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 523 */         MapInterface.spawnVisibleMonster(xInstanceCacheBean.getWorldid(), cursingleInstanceDataCfg.in_mapid, cursingleInstanceDataCfg.monsterid);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 528 */       InstanceManager.logInstance(roleid, instanceUuid, instanceid, 3, passtime, origialInstanceProcessid, 1);
/*     */       
/* 530 */       InstanceManager.tlogInstance(roleid, instanceUuid, instanceid, 3, passtime, origialInstanceProcessid);
/*     */     }
/*     */     else {
/* 533 */       xInstanceBean.setSinglefailtime(xInstanceBean.getSinglefailtime() + 1);
/*     */       
/* 535 */       SUpdateSingleInfo updateSingleInfo = new SUpdateSingleInfo();
/* 536 */       updateSingleInfo.failtime = xInstanceBean.getSinglefailtime();
/* 537 */       fillInSingleInfo(updateSingleInfo.singleinfo, xSingleInstance.getHighprocess(), xSingleInstance.getCurprocess(), xSingleInstance.getFinishtimes(), instanceid, xSingleInstance.getSign());
/*     */       
/*     */ 
/* 540 */       OnlineManager.getInstance().send(roleid, updateSingleInfo);
/*     */       
/* 542 */       InstanceManager.logInstance(roleid, instanceUuid, instanceid, 5, passtime, xSingleInstance.getCurprocess(), 1);
/*     */       
/* 544 */       InstanceManager.tlogInstance(roleid, instanceUuid, instanceid, 5, passtime, xSingleInstance.getCurprocess());
/*     */       
/*     */ 
/*     */ 
/* 548 */       if (xInstanceBean.getSinglefailtime() >= SInstanceConsts.getInstance().SINGLE_INSTANCE_FAIL_TIMES)
/*     */       {
/* 550 */         InstanceManager.sendNormalRet(roleid, 20, new String[0]);
/* 551 */         new SingleInstanceLeaveTimer(1L, instanceUuid, roleid);
/*     */       }
/*     */     }
/* 554 */     SingleFightArg singleFightArg = new SingleFightArg(roleid, instanceid, isWin);
/* 555 */     SingleInstanceFightEvent singleInstanceFightEvent = new SingleInstanceFightEvent();
/* 556 */     TriggerEventsManger.getInstance().triggerEvent(singleInstanceFightEvent, singleFightArg);
/* 557 */     return true;
/*     */   }
/*     */   
/*     */   static boolean sendInstanceAward(String userid, long roleid, int instanceid, SingleInstanceData origialInstanceDataCfg)
/*     */   {
/* 562 */     AwardReason awardReason = new AwardReason(LogReason.INSTANCE_SINGLE_AWARD_ADD, instanceid);
/* 563 */     AwardInterface.award(origialInstanceDataCfg.awardid, userid, roleid, false, true, awardReason);
/*     */     
/* 565 */     if (origialInstanceDataCfg.awardPoolLibid > 0) {
/* 566 */       if (!IdipManager.isZeroProfit(roleid))
/*     */       {
/* 568 */         List<AwardPoolResultData> awardPoolResultDatas = AwardPoolInterface.getAwardPoolData(origialInstanceDataCfg.awardPoolLibid);
/*     */         
/* 570 */         int awardDataSize = awardPoolResultDatas.size();
/* 571 */         if ((awardPoolResultDatas != null) && (awardDataSize > 0)) {
/* 572 */           ArrayList<Item2Count> item2Counts = new ArrayList();
/* 573 */           for (AwardPoolResultData awardPoolResultData : awardPoolResultDatas)
/* 574 */             for (Map.Entry<Integer, List<Integer>> entry : awardPoolResultData.getItemId2NumList().entrySet())
/*     */             {
/* 576 */               itemid = ((Integer)entry.getKey()).intValue();
/* 577 */               for (i$ = ((List)entry.getValue()).iterator(); i$.hasNext();) { int number = ((Integer)i$.next()).intValue();
/* 578 */                 Item2Count item2Count = new Item2Count();
/* 579 */                 item2Count.itemid = itemid;
/* 580 */                 item2Count.itemcount = number;
/* 581 */                 item2Counts.add(item2Count);
/*     */               } }
/*     */           int itemid;
/*     */           Iterator i$;
/* 585 */           if (item2Counts.size() > 0) {
/* 586 */             int index = Xdb.random().nextInt(item2Counts.size());
/* 587 */             Item2Count item2Count = (Item2Count)item2Counts.remove(index);
/* 588 */             item2Counts.add(0, item2Count);
/* 589 */             SSingleBossAward singleBossAward = new SSingleBossAward();
/* 590 */             singleBossAward.items = item2Counts;
/* 591 */             OnlineManager.getInstance().send(roleid, singleBossAward);
/* 592 */             AwardPoolResultData resultData = new AwardPoolResultData();
/* 593 */             resultData.getItemMap().put(Integer.valueOf(item2Count.itemid), Integer.valueOf(item2Count.itemcount));
/*     */             
/* 595 */             boolean ret = LotteryManager.addLottery(roleid, 3, 0, resultData, new TLogArg(LogReason.INSTANCE_SINGLE_AWARDPOOL_ADD, instanceid));
/*     */             
/* 597 */             if (!ret) {
/* 598 */               GameServer.logger().error(String.format("[SingleInstance]SingleInstance.fightResult@增加抽奖结果返回false|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */               
/*     */ 
/* 601 */               return ret;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 607 */         GameServer.logger().info("奖池库表中随机出的物品数目错误,奖池库表id:" + origialInstanceDataCfg.awardPoolLibid);
/*     */       }
/*     */     }
/*     */     
/* 611 */     return true;
/*     */   }
/*     */   
/*     */   static boolean sendInstanceAwardbySaoDang(String userid, long roleid, int instanceid, SingleInstanceData origialInstanceDataCfg)
/*     */   {
/* 616 */     AwardReason awardReason = new AwardReason(LogReason.INSTANCE_SINGLE_AWARD_ADD, instanceid);
/* 617 */     AwardInterface.award(origialInstanceDataCfg.awardid, userid, roleid, false, true, awardReason);
/*     */     
/* 619 */     if (origialInstanceDataCfg.awardPoolLibid > 0) {
/* 620 */       if (!IdipManager.isZeroProfit(roleid))
/*     */       {
/* 622 */         List<AwardPoolResultData> awardPoolResultDatas = AwardPoolInterface.getAwardPoolData(origialInstanceDataCfg.awardPoolLibid);
/*     */         
/* 624 */         int awardDataSize = awardPoolResultDatas.size();
/* 625 */         if ((awardPoolResultDatas != null) && (awardDataSize > 0)) {
/* 626 */           ArrayList<Item2Count> item2Counts = new ArrayList();
/* 627 */           for (AwardPoolResultData awardPoolResultData : awardPoolResultDatas)
/* 628 */             for (Map.Entry<Integer, List<Integer>> entry : awardPoolResultData.getItemId2NumList().entrySet())
/*     */             {
/* 630 */               itemid = ((Integer)entry.getKey()).intValue();
/* 631 */               for (i$ = ((List)entry.getValue()).iterator(); i$.hasNext();) { int number = ((Integer)i$.next()).intValue();
/* 632 */                 Item2Count item2Count = new Item2Count();
/* 633 */                 item2Count.itemid = itemid;
/* 634 */                 item2Count.itemcount = number;
/* 635 */                 item2Counts.add(item2Count);
/*     */               } }
/*     */           int itemid;
/*     */           Iterator i$;
/* 639 */           if (item2Counts.size() > 0) {
/* 640 */             int index = Xdb.random().nextInt(item2Counts.size());
/* 641 */             Item2Count item2Count = (Item2Count)item2Counts.remove(index);
/* 642 */             item2Counts.add(0, item2Count);
/* 643 */             AwardPoolResultData resultData = new AwardPoolResultData();
/* 644 */             resultData.getItemMap().put(Integer.valueOf(item2Count.itemid), Integer.valueOf(item2Count.itemcount));
/* 645 */             ItemOperateResult itemOperateResult = ItemInterface.addItem(roleid, item2Count.itemid, item2Count.itemcount, false, new TLogArg(LogReason.INSTANCE_SINGLE_AWARDPOOL_ADD, instanceid));
/* 646 */             if ((!itemOperateResult.success()) && (!itemOperateResult.isBagFull()))
/*     */             {
/* 648 */               return false;
/*     */             }
/* 650 */             SSendDefaultAwardInfo protocol = new SSendDefaultAwardInfo();
/* 651 */             protocol.awardinfo.itemmap.put(Integer.valueOf(item2Count.itemid), Integer.valueOf(item2Count.itemcount));
/* 652 */             OnlineManager.getInstance().send(roleid, protocol);
/*     */           }
/*     */         }
/*     */       }
/*     */       else {
/* 657 */         GameServer.logger().info("奖池库表中随机出的物品数目错误,奖池库表id:" + origialInstanceDataCfg.awardPoolLibid);
/*     */       }
/*     */     }
/*     */     
/* 661 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void reqSingleInfo(long roleid, int instanceid, int processid, InstanceBean xInstanceBean)
/*     */   {
/* 672 */     SSingleInfoRes singleInfoRes = new SSingleInfoRes();
/* 673 */     if (xInstanceBean != null) {
/* 674 */       xbean.SingleInstance singleInstance = (xbean.SingleInstance)xInstanceBean.getSingleinstancemap().get(Integer.valueOf(instanceid));
/* 675 */       if (singleInstance != null) {
/* 676 */         ProcessBean processBean = (ProcessBean)singleInstance.getProcessmap().get(Integer.valueOf(processid));
/* 677 */         if (processBean != null) {
/* 678 */           singleInfoRes.second = processBean.getSecond();
/* 679 */           singleInfoRes.suctimes = processBean.getSuctimes();
/*     */         }
/*     */       }
/*     */     }
/* 683 */     OnlineManager.getInstance().send(roleid, singleInfoRes);
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean onRoleTransferScene(long roleId, long newWorldId, int newScenecfgid, long oldWorldId, int oldMapCfgId, long instanceUuid, InstanceCacheBean xInstanceCacheBean, InstanceBean instanceBean)
/*     */   {
/* 703 */     if (oldWorldId == xInstanceCacheBean.getWorldid()) {
/* 704 */       onleaveInstance(roleId, instanceUuid, xInstanceCacheBean, instanceBean);
/*     */     }
/* 706 */     return true;
/*     */   }
/*     */   
/*     */   static boolean onDataUpdate(long roleid, InstanceBean xInstanceBean) {
/* 710 */     if (xInstanceBean == null) {
/* 711 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 721 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 722 */     for (Map.Entry<Integer, xbean.SingleInstance> entry : xInstanceBean.getSingleinstancemap().entrySet()) {
/* 723 */       xbean.SingleInstance xSingleInstance = (xbean.SingleInstance)entry.getValue();
/* 724 */       int instanceid = ((Integer)entry.getKey()).intValue();
/* 725 */       reset(roleLevel, xSingleInstance, instanceid);
/*     */     }
/* 727 */     List<SingleInstanceData> instanceCfgs = InstanceCfgManager.getAllSingleInstanceCfgs();
/* 728 */     for (SingleInstanceData singleInstanceCfg : instanceCfgs) {
/* 729 */       SInstanceCfg sInstanceCfg = SInstanceCfg.get(singleInstanceCfg.instanceid);
/* 730 */       if (!xInstanceBean.getSingleinstancemap().containsKey(Integer.valueOf(singleInstanceCfg.instanceid)))
/*     */       {
/*     */ 
/* 733 */         if ((sInstanceCfg.closeLevel > 0) && (sInstanceCfg.closeLevel <= roleLevel)) {
/* 734 */           xbean.SingleInstance xSingleInstance = Pod.newSingleInstance();
/* 735 */           xSingleInstance.setSign(0);
/* 736 */           xInstanceBean.getSingleinstancemap().put(Integer.valueOf(singleInstanceCfg.instanceid), xSingleInstance);
/*     */         }
/*     */       }
/*     */     }
/* 740 */     xInstanceBean.setSinglefailtime(0);
/*     */     
/* 742 */     if (SInstanceConsts.getInstance().SINGLG_GUIDE_GRAPHID > 0) {
/* 743 */       TaskInterface.activeGraph(Long.valueOf(roleid), SInstanceConsts.getInstance().SINGLG_GUIDE_GRAPHID);
/*     */     }
/*     */     
/* 746 */     return true;
/*     */   }
/*     */   
/*     */   private static void reset(int roleLevel, xbean.SingleInstance xSingleInstance, int instanceid) {
/* 750 */     SInstanceCfg sInstanceCfg = SInstanceCfg.get(instanceid);
/* 751 */     if (sInstanceCfg != null) {
/* 752 */       if ((sInstanceCfg.closeLevel > 0) && (sInstanceCfg.closeLevel <= roleLevel)) {
/* 753 */         xSingleInstance.setSign(0);
/* 754 */       } else if (sInstanceCfg.level <= roleLevel) {
/* 755 */         xSingleInstance.setSign(1);
/*     */       }
/*     */     }
/* 758 */     xSingleInstance.setCurprocess(1);
/* 759 */     xSingleInstance.setFinishtimes(0);
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean canTransfer(long roleId, int mapId, int sceneId, int targetMapId, int targetSceneId, int instancecfgid)
/*     */   {
/* 777 */     return true;
/*     */   }
/*     */   
/*     */   static void init() {
/* 781 */     ActivityInterface.registerActivityByLogicType(4, new SingleInstanceHandler());
/* 782 */     ActivityCompensateInterface.registerCompensateHandler(4, new SingleInstanceActivityCompensateHandler());
/*     */     
/*     */ 
/* 785 */     for (SingleInstanceData singleInstanceDataCfg : InstanceCfgManager.getAllSingleInstanceCfgs()) {
/* 786 */       ItemAccessManager.registerActivityReward(SInstanceConsts.getInstance().SINGLE_INSTANCE_ACTIVITY_TYPE_ID, singleInstanceDataCfg.awardid);
/*     */       
/* 788 */       ItemAccessManager.registerActivityAwardPoolLibid(SInstanceConsts.getInstance().SINGLE_INSTANCE_ACTIVITY_TYPE_ID, singleInstanceDataCfg.awardPoolLibid);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void postinit()
/*     */     throws Exception
/*     */   {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void setProcess(long roleid, int instanceid, int process, InstanceBean xInstanceBean)
/*     */   {
/* 806 */     if (xInstanceBean == null) {
/* 807 */       xInstanceBean = Pod.newInstanceBean();
/* 808 */       InstanceManager.initInstanceBean(xInstanceBean, DateTimeUtils.getCurrTimeInMillis());
/* 809 */       xtable.Role2instance.insert(Long.valueOf(roleid), xInstanceBean);
/*     */     }
/* 811 */     xbean.SingleInstance xSingleInstance = (xbean.SingleInstance)xInstanceBean.getSingleinstancemap().get(Integer.valueOf(instanceid));
/* 812 */     if (xSingleInstance == null) {
/* 813 */       xSingleInstance = Pod.newSingleInstance();
/* 814 */       xInstanceBean.getSingleinstancemap().put(Integer.valueOf(instanceid), xSingleInstance);
/*     */     }
/* 816 */     if (xSingleInstance.getHighprocess() < process) {
/* 817 */       xSingleInstance.setHighprocess(process);
/*     */     }
/*     */     
/* 820 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 821 */     reset(roleLevel, xSingleInstance, instanceid);
/*     */     
/* 823 */     xInstanceBean.setSinglefailtime(0);
/*     */     
/* 825 */     ((xbean.SingleInstance)xInstanceBean.getSingleinstancemap().get(Integer.valueOf(instanceid))).setSign(1);
/*     */     
/* 827 */     SUpdateSingleInfo updateSingleInfo = new SUpdateSingleInfo();
/* 828 */     updateSingleInfo.failtime = xInstanceBean.getSinglefailtime();
/* 829 */     fillInSingleInfo(updateSingleInfo.singleinfo, xSingleInstance.getHighprocess(), xSingleInstance.getCurprocess(), xSingleInstance.getFinishtimes(), instanceid, xSingleInstance.getSign());
/*     */     
/*     */ 
/* 832 */     OnlineManager.getInstance().send(roleid, updateSingleInfo);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\main\SingleInstance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */