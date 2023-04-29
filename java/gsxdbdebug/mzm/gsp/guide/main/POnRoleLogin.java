/*    */ package mzm.gsp.guide.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.guide.SSynAllGuideId;
/*    */ import mzm.gsp.guide.confbean.GuideCfgConsts;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.pk.main.PKStatusManager;
/*    */ import mzm.gsp.yzdd.SSynStageChange;
/*    */ import mzm.gsp.yzdd.confbean.YzddConsts;
/*    */ import mzm.gsp.yzdd.main.YzddManager;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class POnRoleLogin extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 22 */     int mapId = MapInterface.getRoleMapId(((Long)this.arg).longValue());
/* 23 */     if (ActivityInterface.isActivityOpen(YzddConsts.getInstance().ActivityId)) {
/* 24 */       if (YzddManager.getInstance().getAllMapIds().contains(Integer.valueOf(mapId))) {
/* 25 */         SSynStageChange synStageChange = new SSynStageChange();
/* 26 */         synStageChange.stage = ActivityInterface.getActivityStage(YzddConsts.getInstance().ActivityId);
/* 27 */         OnlineManager.getInstance().sendAtOnce(((Long)this.arg).longValue(), synStageChange);
/*    */         
/* 29 */         PKStatusManager.setPKEnabled(((Long)this.arg).longValue());
/*    */       }
/*    */     }
/* 32 */     else if (YzddManager.getInstance().getAllMapIds().contains(Integer.valueOf(mapId))) {
/* 33 */       MapInterface.forceTransferToScene(((Long)this.arg).longValue(), 330000001);
/*    */     }
/*    */     
/* 36 */     if (!GuideManager.isRoleStateCanGuide(((Long)this.arg).longValue(), false)) {
/* 37 */       return false;
/*    */     }
/* 39 */     Set<Integer> noconGuideids = GuideManager.getNoConGuideids();
/* 40 */     Integer param = GuideManager.getGuideParam(((Long)this.arg).longValue(), GuideCfgConsts.getInstance().NEWER_OR_OLDER_GUIDEID);
/* 41 */     if (param == null) {
/* 42 */       param = Integer.valueOf(0);
/*    */     }
/* 44 */     GuideManager.synIsNewOrOld(((Long)this.arg).longValue(), param.intValue());
/* 45 */     for (Integer num : noconGuideids) {
/* 46 */       int guideid = num.intValue();
/* 47 */       if (!GuideManager.isGuided(((Long)this.arg).longValue(), guideid)) {
/* 48 */         GuideManager.setUnGuidedState(((Long)this.arg).longValue(), guideid);
/*    */       } else {
/* 50 */         Set<Integer> guides = GuideManager.getGuideIdsByGuideid(guideid);
/* 51 */         for (Integer num2 : guides) {
/* 52 */           int g = num2.intValue();
/* 53 */           if (!GuideManager.isGuided(((Long)this.arg).longValue(), g)) {
/* 54 */             GuideManager.setUnGuidedState(((Long)this.arg).longValue(), g);
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/* 59 */     List<Integer> canguideids = GuideManager.getUnguidedids(((Long)this.arg).longValue());
/* 60 */     SSynAllGuideId sSynAllGuideId = new SSynAllGuideId();
/* 61 */     sSynAllGuideId.guideids.addAll(canguideids);
/* 62 */     OnlineManager.getInstance().sendAtOnce(((Long)this.arg).longValue(), sSynAllGuideId);
/* 63 */     String logstr = String.format("[guide]POnRoleLogin.processImp@send can guideid success roleid=%d|guideids=%s", new Object[] { this.arg, canguideids.toString() });
/* 64 */     GuideManager.logger.info(logstr);
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guide\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */