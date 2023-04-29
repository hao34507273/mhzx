/*     */ package mzm.gsp.flowerparade.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity4.confbean.FlowerParadeConstCfg;
/*     */ import mzm.gsp.activity4.confbean.FlowerParadeDanceBean;
/*     */ import mzm.gsp.activity4.confbean.SFlowerParadeCfg;
/*     */ import mzm.gsp.activity4.confbean.SFlowerParadeDanceCfg;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.flowerparade.SFlowerParadeDanceFailedRep;
/*     */ import mzm.gsp.flowerparade.SFlowerParadeDanceSuccessRep;
/*     */ import mzm.gsp.flowerparade.SSynFlowerParadeAward;
/*     */ import mzm.gsp.map.event.PlayerPlayExpressionActionArg;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.object.MapEntityType;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.DanceAwardInfo;
/*     */ import xbean.FlowerParade;
/*     */ import xbean.RoleFlowerParadeRecord;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2flowerparaderecord;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnPlayExpressionAction extends mzm.gsp.map.event.PlayerPlayExpressionActionProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  37 */     long roleId = ((PlayerPlayExpressionActionArg)this.arg).roleid;
/*  38 */     int activityId = FlowerParadeConstCfg.getInstance().activityId;
/*     */     
/*  40 */     if (!ActivityInterface.isActivityOpen(activityId))
/*     */     {
/*  42 */       return false;
/*     */     }
/*  44 */     if (!FlowerParadeManager.isOpen(roleId))
/*     */     {
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     long localid = mzm.gsp.GameServerInfoManager.getLocalId();
/*     */     
/*  51 */     FlowerParade xFlowerParade = xtable.Flowerparade.select(Long.valueOf(localid));
/*  52 */     if (xFlowerParade == null)
/*     */     {
/*  54 */       return false;
/*     */     }
/*     */     
/*  57 */     if (xFlowerParade.getState() != 0)
/*     */     {
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     SFlowerParadeCfg cfg = SFlowerParadeCfg.get(activityId);
/*  63 */     SFlowerParadeDanceCfg danceCfg = SFlowerParadeDanceCfg.get(cfg.danceGroupId);
/*  64 */     int danceActionId = ((FlowerParadeDanceBean)danceCfg.danceList.get(xFlowerParade.getDanceindex())).actionId;
/*     */     
/*     */ 
/*  67 */     boolean isNearFlower = MapInterface.isNearByMapEntity(roleId, MapEntityType.MET_FLOAT_PARADE, xFlowerParade.getFlowerinstanceid());
/*     */     
/*  69 */     if (!isNearFlower)
/*     */     {
/*  71 */       GameServer.logger().info(String.format("[flowerparade]POnPlayExpressionAction.processImp@is near flower false|paradeinstance=%d|activityid=%d", new Object[] { Long.valueOf(xFlowerParade.getFlowerinstanceid()), Integer.valueOf(activityId) }));
/*     */       
/*     */ 
/*     */ 
/*  75 */       SFlowerParadeDanceFailedRep protocol = new SFlowerParadeDanceFailedRep(activityId, 3);
/*     */       
/*  77 */       OnlineManager.getInstance().sendAtOnce(roleId, protocol);
/*  78 */       return false;
/*     */     }
/*  80 */     List<Long> roleIds = new ArrayList();
/*  81 */     roleIds.add(Long.valueOf(roleId));
/*  82 */     Map<Long, String> roleId2Userid = new HashMap();
/*  83 */     roleId2Userid.put(Long.valueOf(roleId), RoleInterface.getUserId(roleId));
/*     */     
/*  85 */     lock(User.getTable(), roleId2Userid.values());
/*  86 */     lock(Basic.getTable(), roleIds);
/*     */     
/*     */ 
/*  89 */     if (!mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(roleId, 1771, true, true))
/*     */     {
/*  91 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  95 */     ActivityJoinResult joinResult = ActivityInterface.canJoinAndCheckInitActivityData(roleId2Userid, roleIds, activityId);
/*     */     
/*  97 */     if (!joinResult.isCanJoin())
/*     */     {
/*  99 */       if (joinResult.isRoleLevelWrong())
/*     */       {
/* 101 */         SFlowerParadeDanceFailedRep protocol = new SFlowerParadeDanceFailedRep(activityId, 5);
/*     */         
/*     */ 
/* 104 */         OnlineManager.getInstance().sendAtOnce(roleId, protocol);
/*     */       }
/*     */       
/* 107 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 111 */     if (((PlayerPlayExpressionActionArg)this.arg).action != danceActionId)
/*     */     {
/* 113 */       SFlowerParadeDanceFailedRep protocol = new SFlowerParadeDanceFailedRep(activityId, 2);
/*     */       
/* 115 */       GameServer.logger().info(String.format("[flowerparade]POnPlayExpressionAction.processImp@danceaward failed for dance action index|paradeinstance=%d|activityid=%d|roleId=%d|dancecfgIndex=%d|roleaction=%d", new Object[] { Long.valueOf(xFlowerParade.getFlowerinstanceid()), Integer.valueOf(activityId), Long.valueOf(roleId), Integer.valueOf(xFlowerParade.getDanceindex()), Integer.valueOf(((PlayerPlayExpressionActionArg)this.arg).action) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 120 */       OnlineManager.getInstance().sendAtOnce(roleId, protocol);
/* 121 */       return false;
/*     */     }
/*     */     
/* 124 */     RoleFlowerParadeRecord xRoleRecord = Role2flowerparaderecord.get(Long.valueOf(roleId));
/* 125 */     if (xRoleRecord != null)
/*     */     {
/* 127 */       if (xRoleRecord.getDanceawardcount() >= cfg.danceAwardCount)
/*     */       {
/* 129 */         SFlowerParadeDanceFailedRep protocol = new SFlowerParadeDanceFailedRep(activityId, 1);
/*     */         
/* 131 */         OnlineManager.getInstance().sendAtOnce(roleId, protocol);
/*     */         
/* 133 */         GameServer.logger().info(String.format("[flowerparade]POnPlayExpressionAction.processImp@danceaward failed for max count|paradeinstance=%d|activityid=%d|roleId=%d|dancecfgIndex=%d", new Object[] { Long.valueOf(xFlowerParade.getFlowerinstanceid()), Integer.valueOf(activityId), Long.valueOf(roleId), Integer.valueOf(xFlowerParade.getDanceindex()) }));
/*     */         
/*     */ 
/*     */ 
/* 137 */         return false;
/*     */       }
/*     */       
/* 140 */       if ((xRoleRecord.getPredanceawardinfo().getParadeindex() == xFlowerParade.getParadeindex()) && (xRoleRecord.getPredanceawardinfo().getPos() == xFlowerParade.getToposindex()))
/*     */       {
/*     */ 
/* 143 */         GameServer.logger().info(String.format("[flowerparade]POnPlayExpressionAction.processImp@danceaward failed for pos already taken|paradeinstance=%d|activityid=%d|roleId=%d|dancecfgIndex=%d|pos=%d", new Object[] { Long.valueOf(xFlowerParade.getFlowerinstanceid()), Integer.valueOf(activityId), Long.valueOf(roleId), Integer.valueOf(xFlowerParade.getDanceindex()), Integer.valueOf(xFlowerParade.getToposindex()) }));
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
/* 154 */         return false;
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 159 */       xRoleRecord = xbean.Pod.newRoleFlowerParadeRecord();
/* 160 */       Role2flowerparaderecord.insert(Long.valueOf(roleId), xRoleRecord);
/*     */     }
/*     */     
/* 163 */     int awardId = cfg.danceAwardId;
/* 164 */     AwardPoolResultData awardPoolResultData = AwardPoolInterface.getAwardPoolData(awardId, roleId, RoleInterface.getLevel(roleId));
/*     */     
/* 166 */     if (awardPoolResultData == null)
/*     */     {
/*     */ 
/* 169 */       GameServer.logger().error(String.format("[flowerparade]POnPlayExpressionAction.processImp@awardpool failed|paradeinstance=%d|activityid=%d|roleId=%d|dancecfgIndex=%d|awardId=%d", new Object[] { Long.valueOf(xFlowerParade.getFlowerinstanceid()), Integer.valueOf(activityId), Long.valueOf(roleId), Integer.valueOf(xFlowerParade.getDanceindex()), Integer.valueOf(awardId) }));
/*     */       
/*     */ 
/*     */ 
/* 173 */       return false;
/*     */     }
/* 175 */     AwardPoolInterface.doAward((String)roleId2Userid.get(Long.valueOf(roleId)), roleId, awardPoolResultData, new TLogArg(mzm.gsp.tlog.LogReason.FLOWER_PARADE, awardId));
/*     */     
/*     */ 
/* 178 */     SSynFlowerParadeAward notify = new SSynFlowerParadeAward();
/* 179 */     notify.awardtype = 2;
/* 180 */     mzm.gsp.award.main.AwardInterface.fillAwardBean(notify.award, mzm.gsp.award.main.AwardModel.getAwardModel(awardPoolResultData));
/* 181 */     OnlineManager.getInstance().send(roleId, notify);
/*     */     
/*     */ 
/* 184 */     xRoleRecord.setDanceawardcount(xRoleRecord.getDanceawardcount() + 1);
/* 185 */     xRoleRecord.getPredanceawardinfo().setPos(xFlowerParade.getToposindex());
/* 186 */     xRoleRecord.getPredanceawardinfo().setParadeindex(xFlowerParade.getParadeindex());
/*     */     
/* 188 */     SFlowerParadeDanceSuccessRep protocol = new SFlowerParadeDanceSuccessRep(activityId, xRoleRecord.getDanceawardcount(), cfg.danceAwardCount);
/*     */     
/* 190 */     GameServer.logger().info(String.format("[flowerparade]POnPlayExpressionAction.processImp@dance award success|paradeinstance=%d|activityid=%d|roleId=%d|dancecfgIndex=%d", new Object[] { Long.valueOf(xFlowerParade.getFlowerinstanceid()), Integer.valueOf(activityId), Long.valueOf(roleId), Integer.valueOf(xFlowerParade.getDanceindex()) }));
/*     */     
/*     */ 
/*     */ 
/* 194 */     OnlineManager.getInstance().send(roleId, protocol);
/* 195 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\flowerparade\main\POnPlayExpressionAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */