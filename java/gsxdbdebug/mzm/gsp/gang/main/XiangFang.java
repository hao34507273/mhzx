/*     */ package mzm.gsp.gang.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.gang.SSyncSystemKickOut;
/*     */ import mzm.gsp.gang.confbean.SGangConst;
/*     */ import mzm.gsp.gang.confbean.SGangLevelCfg;
/*     */ import mzm.gsp.gang.confbean.SGangXiangFangCfg;
/*     */ import mzm.gsp.gang.event.LeaveGangArg.LeaveType;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.GangMember;
/*     */ import xbean.GangMemoryBean;
/*     */ import xtable.Role2gangmember;
/*     */ 
/*     */ public class XiangFang extends AbsGangBuilding
/*     */ {
/*     */   public XiangFang(long gangId, int buildingType, xbean.Gang xGang)
/*     */   {
/*  30 */     super(gangId, buildingType, xGang);
/*     */   }
/*     */   
/*     */   public long getLevelUpEndTime()
/*     */   {
/*  35 */     return this.xGang.getXiangfang().getLevelupendtime();
/*     */   }
/*     */   
/*     */   public int getLevelUpNeedMoney()
/*     */   {
/*  40 */     SGangXiangFangCfg sGangXiangFangCfg = SGangXiangFangCfg.get(getLevel());
/*  41 */     return sGangXiangFangCfg.levelUpNeedMoney;
/*     */   }
/*     */   
/*     */   public int getMaintainMoney()
/*     */   {
/*  46 */     SGangXiangFangCfg sGangXiangFangCfg = SGangXiangFangCfg.get(getLevel());
/*  47 */     return sGangXiangFangCfg.maintainCostMoneyPerDay;
/*     */   }
/*     */   
/*     */   List<Long> getAllSequenceRoleList(xbean.Gang xGang) {
/*  51 */     List<Long> oldMemberList = new ArrayList(GangManager.getMembers(xGang));
/*  52 */     Comparator<Long> comp = new Comparator()
/*     */     {
/*     */       public int compare(Long o1, Long o2)
/*     */       {
/*  56 */         GangMember m1 = Role2gangmember.select(o1);
/*  57 */         GangMember m2 = Role2gangmember.select(o2);
/*     */         
/*  59 */         if (!OnlineManager.getInstance().isOnline(o1.longValue())) {
/*  60 */           return 1;
/*     */         }
/*     */         
/*  63 */         if (!OnlineManager.getInstance().isOnline(o2.longValue())) {
/*  64 */           return -1;
/*     */         }
/*     */         
/*  67 */         long lf1 = RoleInterface.getLastLogoffTime(o1.longValue());
/*  68 */         long lf2 = RoleInterface.getLastLogoffTime(o2.longValue());
/*  69 */         if (lf1 < lf2) {
/*  70 */           return -1;
/*     */         }
/*  72 */         if (lf1 == lf2) {
/*  73 */           return m1.getHistorybanggong() - m2.getHistorybanggong() < 0L ? -1 : 0;
/*     */         }
/*  75 */         return 0;
/*     */       }
/*  77 */     };
/*  78 */     Collections.sort(oldMemberList, comp);
/*  79 */     return oldMemberList;
/*     */   }
/*     */   
/*     */   public void onGanglevelDown()
/*     */   {
/*  84 */     SGangLevelCfg gangLevelCfg = SGangLevelCfg.get(this.xGang.getLevel());
/*  85 */     if (isMaxLv()) {
/*  86 */       stopObserver();
/*     */     }
/*  88 */     if (gangLevelCfg.xiangFangMaxLevel < getLevel()) {
/*  89 */       executeLevelDown();
/*     */     }
/*     */   }
/*     */   
/*     */   private void executeLevelDown() {
/*  94 */     SGangLevelCfg gangLevelCfg = SGangLevelCfg.get(this.xGang.getLevel());
/*  95 */     setLevel(gangLevelCfg.xiangFangMaxLevel);
/*  96 */     stopObserver();
/*  97 */     LogicProcedure levelDownLP = new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception
/*     */       {
/* 101 */         xbean.Gang xGang = xtable.Gang.select(Long.valueOf(XiangFang.this.gangId));
/* 102 */         List<Long> roleIdList = XiangFang.this.getAllSequenceRoleList(xGang);
/* 103 */         Map<Integer, Integer> duty2count = new HashMap();
/* 104 */         Set<Long> changeToBangZhong = new HashSet();
/* 105 */         Set<Long> kickOutMembers = new HashSet();
/* 106 */         Map<Long, Integer> role2dutyid = new HashMap();
/* 107 */         for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */           
/* 109 */           int dutyId = Role2gangmember.selectDuty(Long.valueOf(roleId)).intValue();
/* 110 */           role2dutyid.put(Long.valueOf(roleId), Integer.valueOf(dutyId));
/* 111 */           Integer dutyCount = (Integer)duty2count.get(Integer.valueOf(dutyId));
/* 112 */           if (dutyCount == null) {
/* 113 */             dutyCount = Integer.valueOf(0);
/*     */           }
/* 115 */           duty2count.put(Integer.valueOf(dutyId), Integer.valueOf(dutyCount.intValue() + 1));
/*     */         }
/* 117 */         for (Map.Entry<Long, Integer> role2DutyEntry : role2dutyid.entrySet()) {
/* 118 */           Integer dutyCount = (Integer)duty2count.get(role2DutyEntry.getValue());
/* 119 */           if (dutyCount == null) dutyCount = Integer.valueOf(0);
/* 120 */           int duty = ((Integer)role2DutyEntry.getValue()).intValue();
/* 121 */           if (dutyCount.intValue() > GangManager.getDutyMemberCount(xGang, duty)) {
/* 122 */             if ((duty != SGangConst.getInstance().BANGZHONG_ID) && (duty != SGangConst.getInstance().XUETU_ID))
/*     */             {
/* 124 */               Integer bangZhongCount = (Integer)duty2count.get(Integer.valueOf(SGangConst.getInstance().BANGZHONG_ID));
/* 125 */               if (bangZhongCount == null) bangZhongCount = Integer.valueOf(0);
/* 126 */               if (bangZhongCount.intValue() < GangConfigManager.getInstance().getNormalMemberCapacity(xGang.getXiangfang().getLevel())) {
/* 127 */                 changeToBangZhong.add(role2DutyEntry.getKey());
/* 128 */                 duty2count.put(Integer.valueOf(SGangConst.getInstance().BANGZHONG_ID), Integer.valueOf(bangZhongCount.intValue() + 1));
/* 129 */                 duty2count.put(role2DutyEntry.getValue(), Integer.valueOf(dutyCount.intValue() - 1));
/* 130 */                 continue;
/*     */               }
/*     */             }
/* 133 */             kickOutMembers.add(role2DutyEntry.getKey());
/* 134 */             duty2count.put(role2DutyEntry.getValue(), Integer.valueOf(dutyCount.intValue() - 1));
/*     */           }
/*     */         }
/*     */         
/* 138 */         XiangFang xiangFang = (XiangFang)BuildingFactory.createGangBuilding(XiangFang.this.gangId, xGang, XiangFang.this.buildingType);
/* 139 */         xiangFang.kickOutMember(XiangFang.this.gangId, kickOutMembers, role2dutyid);
/* 140 */         xiangFang.changeDuty(XiangFang.this.gangId, changeToBangZhong);
/* 141 */         return true;
/*     */       }
/* 143 */     };
/* 144 */     NoneRealTimeTaskManager.getInstance().addTask(levelDownLP);
/*     */   }
/*     */   
/*     */   private void kickOutMember(final long gangId, final Set<Long> memberSet, Map<Long, Integer> role2dutyid)
/*     */   {
/* 149 */     LogicProcedure kickOutMember = new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp() throws Exception {
/* 152 */         lock(Role2gangmember.getTable(), memberSet);
/* 153 */         xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangId));
/* 154 */         GangMemoryBean xGangMemory = GangManager.getXGangMemory(gangId, true);
/*     */         
/* 156 */         for (Long roleId : memberSet) {
/* 157 */           GangMember xGangMember = Role2gangmember.get(roleId);
/*     */           
/* 159 */           GangManager.passiveLeaveGangHandle(xGangMember, roleId.longValue());
/* 160 */           GangManager.removeMember(gangId, xGang, xGangMemory, roleId.longValue(), xGangMember, true);
/* 161 */           ForbidTalkObserver.stopObserver(roleId.longValue());
/*     */         }
/* 163 */         SSyncSystemKickOut sSyncSystemKickOut = new SSyncSystemKickOut();
/* 164 */         sSyncSystemKickOut.rolelist.addAll(memberSet);
/* 165 */         OnlineManager.getInstance().sendMulti(sSyncSystemKickOut, memberSet);
/*     */         
/* 167 */         GangManager.triggerLeaveGangEvent(memberSet, gangId, LeaveGangArg.LeaveType.KickedOutByLvlDown);
/*     */         
/* 169 */         return true;
/*     */       }
/* 171 */     };
/* 172 */     NoneRealTimeTaskManager.getInstance().addTask(kickOutMember);
/*     */   }
/*     */   
/*     */   private void changeDuty(long gangId, Set<Long> changeToBangZhong) {
/* 176 */     for (Long roleId : changeToBangZhong) {
/* 177 */       NoneRealTimeTaskManager.getInstance().addTask(new PChange2BangZhong(roleId.longValue()));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public int getLevel()
/*     */   {
/* 184 */     return this.xGang.getXiangfang().getLevel();
/*     */   }
/*     */   
/*     */   public boolean isMaxLv()
/*     */   {
/* 189 */     SGangLevelCfg levelCfg = SGangLevelCfg.get(this.xGang.getLevel());
/* 190 */     return levelCfg.xiangFangMaxLevel == getLevel();
/*     */   }
/*     */   
/*     */   public int getLevelUpNeedTimeMInCfg()
/*     */   {
/* 195 */     SGangXiangFangCfg sGangXiangFangCfg = SGangXiangFangCfg.get(getLevel());
/* 196 */     return sGangXiangFangCfg.levelUpNeedTimeM;
/*     */   }
/*     */   
/*     */   public void setLevelupendtime(long newEndTime)
/*     */   {
/* 201 */     this.xGang.getXiangfang().setLevelupendtime(newEndTime);
/*     */   }
/*     */   
/*     */   public void setLevel(int newLevel)
/*     */   {
/* 206 */     this.xGang.getXiangfang().setLevel(newLevel);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\XiangFang.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */