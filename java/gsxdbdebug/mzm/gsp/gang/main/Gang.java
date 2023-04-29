/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import hub.CrossCompeteFactionDutyMembers;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.gang.confbean.SGangConst;
/*     */ import mzm.gsp.gang.confbean.SGangDutyCfg;
/*     */ import mzm.gsp.gang.confbean.SGangLevelCfg;
/*     */ import mzm.gsp.gang.event.GangLevelChangeArg;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.team.main.JoinTeamResult;
/*     */ import mzm.gsp.team.main.JoinTeamType;
/*     */ import mzm.gsp.team.main.ReturnTeamResult;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import xbean.GangMember;
/*     */ import xbean.GangMemoryBean;
/*     */ import xbean.JinKu;
/*     */ import xbean.ShuYuan;
/*     */ import xio.Protocol;
/*     */ import xtable.Gangmemory;
/*     */ import xtable.Role2gangmember;
/*     */ 
/*     */ public class Gang extends AbsGangBuilding
/*     */ {
/*     */   Gang(long gangId, int buildingType, xbean.Gang xGang)
/*     */   {
/*  33 */     super(gangId, buildingType, xGang);
/*     */   }
/*     */   
/*     */   void init()
/*     */   {
/*  38 */     super.init();
/*  39 */     new mzm.gsp.util.LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/*  43 */         GangMemoryBean xGangMemoryBean = Gangmemory.get(Long.valueOf(Gang.this.gangId));
/*  44 */         if (xGangMemoryBean == null) {
/*  45 */           xGangMemoryBean = xbean.Pod.newGangMemoryBean();
/*  46 */           Gangmemory.add(Long.valueOf(Gang.this.gangId), xGangMemoryBean);
/*     */         }
/*  48 */         long worldId = MapInterface.createWorld(Arrays.asList(new Integer[] { Integer.valueOf(SGangConst.getInstance().GANG_MAP) }));
/*  49 */         TeamInterface.registerJoinTeam(worldId, new mzm.gsp.team.main.JoinTeamCheckHandler()
/*     */         {
/*     */ 
/*     */           public ReturnTeamResult canReturnTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId)
/*     */           {
/*  54 */             ReturnTeamResult result = new ReturnTeamResult();
/*  55 */             result.setSucceed(true);
/*  56 */             return result;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */           public JoinTeamResult canJoinTeam(TeamInfo teamInfo, long roleId, long leaderWorldId, long roleWorldId, boolean tf2LeaderAftJoin, JoinTeamType joinTeamType)
/*     */           {
/*  63 */             JoinTeamResult result = new JoinTeamResult();
/*  64 */             result.setSucceed(true);
/*  65 */             return result;
/*     */           }
/*  67 */         });
/*  68 */         xGangMemoryBean.setGangworldid(worldId);
/*  69 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */   
/*     */ 
/*     */   public long getLevelUpEndTime()
/*     */   {
/*  77 */     return this.xGang.getLeveluptime();
/*     */   }
/*     */   
/*     */   public int getLevelUpNeedMoney()
/*     */   {
/*  82 */     SGangLevelCfg sGangLevelCfg = SGangLevelCfg.get(getLevel());
/*  83 */     return sGangLevelCfg.levelUpNeedMoney;
/*     */   }
/*     */   
/*     */   public int getMaintainMoney()
/*     */   {
/*  88 */     SGangLevelCfg sGangLevelCfg = SGangLevelCfg.get(getLevel());
/*  89 */     return sGangLevelCfg.maintainCostMoneyPerDay;
/*     */   }
/*     */   
/*     */   void onGanglevelDown()
/*     */   {
/*  94 */     if (getLevel() == 1) {
/*  95 */       if (OpenInterface.getOpenStatus(183)) {
/*  96 */         dissolve();
/*     */       }
/*     */     } else {
/*  99 */       setLevel(getLevel() - 1);
/* 100 */       levelDown();
/*     */     }
/*     */   }
/*     */   
/*     */   private void dissolve() {
/* 105 */     if (GangManager.getDiffDay(this.xGang.getCreatetime(), mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis()) < SGangConst.getInstance().NEW_GANG_PROTECT_TIME_D) {
/* 106 */       this.xGang.getJinku().setGangmoney(0);
/* 107 */       GangManager.sendMail(this.xGang, SGangConst.getInstance().CAN_NOT_MAINTAIN_MAIL_ID, new TLogArg(LogReason.GANG_MAINTIAN_DISSOLVE_MAIL, SGangConst.getInstance().CAN_NOT_MAINTAIN_MAIL_ID), new String[0]);
/* 108 */       return;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 113 */     GangMemoryBean xGangMemory = GangManager.getXGangMemory(this.gangId, true);
/* 114 */     xbean.GangGlobal xGlobal = GangManager.getXGlobal(true);
/*     */     
/* 116 */     boolean ret = GangManager.dissolveGang(this.gangId, this.xGang, xGangMemory, xGlobal);
/* 117 */     int gangMemberSize = GangManager.getMemberSize(this.xGang);
/* 118 */     long bangzhuId = this.xGang.getBangzhuid();
/* 119 */     long gangDisplayId = this.xGang.getDisplayid();
/* 120 */     if (ret)
/*     */     {
/* 122 */       new PRecordGangDismissTlog(this.gangId, bangzhuId, gangMemberSize, gangDisplayId).execute();
/*     */     }
/*     */   }
/*     */   
/*     */   private void levelDown() {
/* 127 */     GangManager.sendMail(this.xGang, SGangConst.getInstance().GANG_LEVEL_DOWN_MAIL_ID, new TLogArg(LogReason.GANG_MAINTIAN_LEVELDOWN_MAIL, SGangConst.getInstance().GANG_LEVEL_DOWN_MAIL_ID), new String[] { this.xGang.getLevel() + 1 + "", this.xGang.getLevel() + "" });
/*     */   }
/*     */   
/*     */   public int getLevel()
/*     */   {
/* 132 */     return this.xGang.getLevel();
/*     */   }
/*     */   
/*     */   public boolean isMaxLv()
/*     */   {
/* 137 */     SGangLevelCfg sGangLevelCfg = SGangLevelCfg.get(getLevel() + 1);
/* 138 */     return sGangLevelCfg == null;
/*     */   }
/*     */   
/*     */   public int getLevelUpNeedTimeMInCfg()
/*     */   {
/* 143 */     SGangLevelCfg sGangLevelCfg = SGangLevelCfg.get(getLevel());
/* 144 */     return sGangLevelCfg.levelUpNeedTimeM;
/*     */   }
/*     */   
/*     */   void setLevelupendtime(long newEndTime)
/*     */   {
/* 149 */     this.xGang.setLeveluptime(newEndTime);
/*     */   }
/*     */   
/*     */   void setLevel(int newLevel)
/*     */   {
/* 154 */     int oldLevel = this.xGang.getLevel();
/* 155 */     this.xGang.setLevel(newLevel);
/* 156 */     if (oldLevel != newLevel) {
/* 157 */       GangLevelChangeArg gangLevelChangeArg = new GangLevelChangeArg();
/* 158 */       gangLevelChangeArg.gangId = this.gangId;
/* 159 */       gangLevelChangeArg.newLevel = newLevel;
/* 160 */       gangLevelChangeArg.oldLevel = oldLevel;
/* 161 */       TriggerEventsManger.getInstance().triggerEvent(new mzm.gsp.gang.event.GangLevelChange(), gangLevelChangeArg);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean canLevelUp()
/*     */   {
/* 168 */     SGangLevelCfg sGangLevelCfg = SGangLevelCfg.get(this.xGang.getLevel());
/* 169 */     if (sGangLevelCfg == null) {
/* 170 */       return false;
/*     */     }
/* 172 */     int avabuildingNum = 0;
/* 173 */     if (this.xGang.getXiangfang().getLevel() >= sGangLevelCfg.needBuildingLevel) {
/* 174 */       avabuildingNum++;
/*     */     }
/* 176 */     if (this.xGang.getCangku().getLevel() >= sGangLevelCfg.needBuildingLevel) {
/* 177 */       avabuildingNum++;
/*     */     }
/* 179 */     if (this.xGang.getJinku().getLevel() >= sGangLevelCfg.needBuildingLevel) {
/* 180 */       avabuildingNum++;
/*     */     }
/* 182 */     if (this.xGang.getYaodian().getLevel() >= sGangLevelCfg.needBuildingLevel) {
/* 183 */       avabuildingNum++;
/*     */     }
/* 185 */     if (this.xGang.getShuyuan().getLevel() >= sGangLevelCfg.needBuildingLevel) {
/* 186 */       avabuildingNum++;
/*     */     }
/* 188 */     if (avabuildingNum < sGangLevelCfg.needBuildingNum) {
/* 189 */       return false;
/*     */     }
/* 191 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public String getName()
/*     */   {
/* 199 */     return this.xGang.getName();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getMemberSize()
/*     */   {
/* 207 */     return GangManager.getMemberSize(this.xGang);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getBangZhuId()
/*     */   {
/* 216 */     return this.xGang.getBangzhuid();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<Long> getMemberList()
/*     */   {
/* 224 */     List<Long> members = new ArrayList();
/* 225 */     members.addAll(GangManager.getMembers(this.xGang));
/* 226 */     return members;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isNormalState()
/*     */   {
/* 235 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void brocadcast(Protocol protocol)
/*     */   {
/* 243 */     GangManager.broadcast(this.xGang, protocol);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isInGang(long roleId)
/*     */   {
/* 252 */     return GangManager.isInGang(this.xGang, roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getGangId()
/*     */   {
/* 260 */     return this.gangId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addGangMoney(int addMoney)
/*     */   {
/* 268 */     if (addMoney <= 0) return;
/* 269 */     GangManager.addGangMoney(this.xGang, addMoney);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addLiHe(int addNum)
/*     */   {
/* 277 */     GangManager.addGangLiHe(this.xGang, addNum);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getGangDuty(long roleId)
/*     */   {
/* 287 */     GangMember xMember = Role2gangmember.select(Long.valueOf(roleId));
/* 288 */     if (xMember == null) {
/* 289 */       return -1;
/*     */     }
/* 291 */     SGangDutyCfg dutyCfg = GangManager.getDutyCfg(xMember);
/* 292 */     return dutyCfg.dutyLevel;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getCreateTime()
/*     */   {
/* 300 */     return this.xGang.getCreatetime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getVitality()
/*     */   {
/* 308 */     return this.xGang.getVitality();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isNormalMember(long roleId)
/*     */   {
/* 318 */     GangMember xMember = Role2gangmember.select(Long.valueOf(roleId));
/* 319 */     if (xMember == null) {
/* 320 */       return false;
/*     */     }
/* 322 */     if (!GangManager.isInGang(this.xGang, roleId)) {
/* 323 */       return false;
/*     */     }
/* 325 */     return xMember.getDuty() != SGangConst.getInstance().XUETU_ID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean addGongXun(long roleId, int addValue)
/*     */   {
/* 336 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(roleId));
/* 337 */     return GangManager.addGongXun(this.gangId, this.xGang, roleId, xGangMember, addValue);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void addGongXunAsyc(long roleId, int addValue)
/*     */   {
/* 346 */     GangInterface.addGongXunAsyc(roleId, addValue);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getJoinTime(long roleId)
/*     */   {
/* 357 */     GangMember xMember = Role2gangmember.select(Long.valueOf(roleId));
/* 358 */     if (xMember == null) {
/* 359 */       return -1L;
/*     */     }
/* 361 */     if (!GangManager.isInGang(this.xGang, roleId)) {
/* 362 */       return -1L;
/*     */     }
/* 364 */     return xMember.getJointime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getJoinDays(long roleid)
/*     */   {
/* 375 */     GangMember xMember = Role2gangmember.select(Long.valueOf(roleid));
/* 376 */     if (xMember == null) {
/* 377 */       return -1;
/*     */     }
/* 379 */     if (!GangManager.isInGang(this.xGang, roleid)) {
/* 380 */       return -1;
/*     */     }
/* 382 */     return GangManager.getDiffDays(xMember.getJointime());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getJoinTimestamp(long roleid)
/*     */   {
/* 393 */     GangMember xMember = Role2gangmember.select(Long.valueOf(roleid));
/* 394 */     if (xMember == null) {
/* 395 */       return -1L;
/*     */     }
/* 397 */     if (!GangManager.isInGang(this.xGang, roleid)) {
/* 398 */       return -1L;
/*     */     }
/* 400 */     return xMember.getJointime();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getGangTitleid()
/*     */   {
/* 410 */     return this.xGang.getDesigntitlecaseid();
/*     */   }
/*     */   
/*     */   int getCombineValidCount()
/*     */   {
/* 415 */     return GangManager.getCombineValidCount(this.xGang);
/*     */   }
/*     */   
/*     */   int getNormalMemberCount() {
/* 419 */     return GangManager.getNormalMemberCount(this.xGang);
/*     */   }
/*     */   
/*     */   int getNormalMemberCapacity() {
/* 423 */     return GangManager.getNormalMemberCapacity(this.xGang);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public long getDisplayid()
/*     */   {
/* 431 */     return this.xGang.getDisplayid();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void broadcast(Protocol pro)
/*     */   {
/* 439 */     GangManager.broadcast(this.xGang, pro);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getOnlineCount()
/*     */   {
/* 447 */     return GangManager.getOnlineCount(this.xGang);
/*     */   }
/*     */   
/*     */   public void fillCrossCompeteFactionDutyMembersList(List<CrossCompeteFactionDutyMembers> dutyMembersList)
/*     */   {
/* 452 */     GangManager.fillCrossCompeteFactionDutyMembersList(this.xGang, dutyMembersList);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\Gang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */