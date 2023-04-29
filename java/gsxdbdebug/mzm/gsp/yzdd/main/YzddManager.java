/*     */ package mzm.gsp.yzdd.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.RGMCloseActivity;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleOneByOneManager;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import mzm.gsp.yzdd.SSynStageChange;
/*     */ import mzm.gsp.yzdd.SSynYzddModel;
/*     */ import mzm.gsp.yzdd.confbean.YzddConsts;
/*     */ import org.apache.log4j.Logger;
/*     */ 
/*     */ 
/*     */ public class YzddManager
/*     */ {
/*  27 */   static Logger logger = Logger.getLogger("yzdd");
/*     */   
/*     */ 
/*     */   private static YzddManager instance;
/*     */   
/*     */   private long worldId;
/*     */   
/*  34 */   public boolean sendGunjunAward = false;
/*  35 */   public boolean sendJijunAward = false;
/*  36 */   public boolean sendYajunAward = false;
/*     */   
/*  38 */   private Set<Long> fightIds = new HashSet();
/*     */   
/*     */   public static YzddManager getInstance() {
/*  41 */     if (instance == null) {
/*  42 */       instance = new YzddManager();
/*     */     }
/*  44 */     return instance;
/*     */   }
/*     */   
/*     */   public void setWorldId(long worldId) {
/*  48 */     this.worldId = worldId;
/*     */   }
/*     */   
/*     */   public Long getWorldId() {
/*  52 */     return Long.valueOf(this.worldId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void AddFightId(long fightId)
/*     */   {
/*  61 */     this.fightIds.add(Long.valueOf(fightId));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void RemoveFight(long fightId)
/*     */   {
/*  70 */     this.fightIds.remove(Long.valueOf(fightId));
/*     */   }
/*     */   
/*     */   public Set<Long> getAllFightIds() {
/*  74 */     return this.fightIds;
/*     */   }
/*     */   
/*     */   public void clearAllFights() {
/*  78 */     this.fightIds.clear();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void LoseTransMap(long roleId)
/*     */   {
/*  87 */     int mapId = MapInterface.getRoleMapId(roleId);
/*  88 */     if (mapId == YzddConsts.getInstance().MapId1) {
/*  89 */       MapInterface.transferToScene(roleId, this.worldId, YzddConsts.getInstance().MapId2);
/*  90 */     } else if (mapId == YzddConsts.getInstance().MapId2) {
/*  91 */       MapInterface.transferToScene(roleId, this.worldId, YzddConsts.getInstance().MapId3);
/*  92 */     } else if (mapId == YzddConsts.getInstance().MapId3) {
/*  93 */       MapInterface.transferToScene(roleId, MapInterface.getBigWorldid(), 330000001);
/*  94 */       SendAwardMail(roleId, YzddConsts.getInstance().CanyuAward);
/*     */     }
/*     */   }
/*     */   
/*     */   public void CheckActivityEnd() {
/*  99 */     List<Long> guanjunroles = MapInterface.getRoleList(instance.getWorldId().longValue(), YzddConsts.getInstance().MapId1);
/* 100 */     List<Long> yajunroles = MapInterface.getRoleList(instance.getWorldId().longValue(), YzddConsts.getInstance().MapId2);
/* 101 */     List<Long> jijunroles = MapInterface.getRoleList(instance.getWorldId().longValue(), YzddConsts.getInstance().MapId3);
/* 102 */     if ((jijunroles.size() == 1) && (yajunroles.size() == 1) && (guanjunroles.size() == 1) && 
/* 103 */       (!this.sendJijunAward)) {
/* 104 */       SendAwardMail(((Long)jijunroles.get(0)).longValue(), YzddConsts.getInstance().JiJunAward);
/* 105 */       this.sendJijunAward = true;
/* 106 */       new RGMCloseActivity(YzddConsts.getInstance().ActivityId).execute();
/* 107 */       BulletinInterface.sendNotice("一战到底活动已经产生冠军，亚军，季军，活动提前结束，所有奖励已发放");
/*     */     }
/*     */     
/* 110 */     if ((yajunroles.size() == 1) && (guanjunroles.size() == 1) && 
/* 111 */       (!this.sendYajunAward)) {
/* 112 */       SendAwardMail(((Long)yajunroles.get(0)).longValue(), YzddConsts.getInstance().YaJunAward);
/* 113 */       this.sendYajunAward = true;
/*     */     }
/*     */     
/* 116 */     if ((guanjunroles.size() == 1) && 
/* 117 */       (!this.sendGunjunAward)) {
/* 118 */       SendAwardMail(((Long)guanjunroles.get(0)).longValue(), YzddConsts.getInstance().GuanJunAward);
/* 119 */       this.sendGunjunAward = true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void SendAwardMail(long roleId, String mailcontent)
/*     */   {
/* 131 */     MailAttachment attachment = new MailAttachment();
/* 132 */     String[] mail = mailcontent.split("\\|");
/* 133 */     String title = mail[0];
/* 134 */     String content = mail[1];
/* 135 */     String[] item2num = mail[2].split("\\s");
/* 136 */     for (String item : item2num) {
/* 137 */       String[] items = item.split(",");
/* 138 */       attachment.addItem(Integer.valueOf(items[0]).intValue(), Integer.valueOf(items[1]).intValue());
/*     */     }
/* 140 */     MailInterface.asynBuildAndSendMail(roleId, 1, title, content, attachment, new TLogArg(LogReason.GM_ADD));
/*     */   }
/*     */   
/*     */   public List<Integer> getAllMapIds()
/*     */   {
/* 145 */     List<Integer> mapIds = new ArrayList();
/* 146 */     mapIds.add(Integer.valueOf(YzddConsts.getInstance().PerpareMapId));
/* 147 */     mapIds.add(Integer.valueOf(YzddConsts.getInstance().MapId1));
/* 148 */     mapIds.add(Integer.valueOf(YzddConsts.getInstance().MapId2));
/* 149 */     mapIds.add(Integer.valueOf(YzddConsts.getInstance().MapId3));
/* 150 */     return mapIds;
/*     */   }
/*     */   
/*     */   public void syncPlayerModel(long roleId) {
/* 154 */     SSynYzddModel sBallBattlePlayerStatus = new SSynYzddModel();
/* 155 */     sBallBattlePlayerStatus.modelid = YzddConsts.getInstance().ModelId;
/* 156 */     sBallBattlePlayerStatus.rolename = YzddConsts.getInstance().RoleName;
/* 157 */     MapInterface.setModelProtocol(roleId, sBallBattlePlayerStatus);
/*     */   }
/*     */   
/*     */   public void brocastStage(int stage, List<Long> roleids) {
/* 161 */     SSynStageChange synStageChange = new SSynStageChange();
/* 162 */     synStageChange.stage = stage;
/* 163 */     OnlineManager.getInstance().sendMulti(synStageChange, roleids);
/*     */   }
/*     */   
/* 166 */   public void newRoleRelatedSession(long roleId, int seconds, LogicRunnable logicRunnable) { Session session = new Session(seconds, roleId)
/*     */     {
/*     */       protected void onTimeOut() {
/* 169 */         RoleOneByOneManager.getInstance().addLogicProcedure(Long.valueOf(this.val$roleId), new LogicProcedure()
/*     */         {
/*     */           protected boolean processImp() throws Exception {
/* 172 */             YzddManager.1.this.val$logicRunnable.process();
/* 173 */             return true;
/*     */           }
/*     */         });
/*     */       }
/*     */     }; }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\yzdd\main\YzddManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */