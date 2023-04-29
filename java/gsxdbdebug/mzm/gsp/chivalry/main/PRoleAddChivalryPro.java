/*     */ package mzm.gsp.chivalry.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.chivalry.confbean.ChivalryConsts;
/*     */ import mzm.gsp.chivalry.confbean.STChivalryDescCfg;
/*     */ import mzm.gsp.chivalry.confbean.STDaySumType2GainTypes;
/*     */ import mzm.gsp.idip.main.IdipManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChivalryDayInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2chivalrydayinfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PRoleAddChivalryPro
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int needAddNum;
/*     */   private final int activityType;
/*     */   private final TLogArg logArg;
/*     */   private final boolean isSend;
/*     */   private int addNumLast;
/*     */   
/*     */   public PRoleAddChivalryPro(long roleId, int needAddNum, int activityType, TLogArg logArg, boolean isSend)
/*     */   {
/*  37 */     this.roleId = roleId;
/*  38 */     this.needAddNum = needAddNum;
/*  39 */     this.activityType = activityType;
/*  40 */     this.logArg = logArg;
/*  41 */     this.isSend = isSend;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  47 */     if (this.needAddNum == 0)
/*     */     {
/*  49 */       return true;
/*     */     }
/*  51 */     if (!canAddChivarly())
/*     */     {
/*  53 */       return false;
/*     */     }
/*  55 */     STChivalryDescCfg cfg = STChivalryDescCfg.get(this.activityType);
/*  56 */     if (cfg == null)
/*     */     {
/*  58 */       GameServer.logger().error(String.format("[chivalry]PRoleAddChivalryPro.processImp@ STChivalryDescCfg is null!|roleId=%d|activityType=%d|needAddNum=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityType), Integer.valueOf(this.needAddNum) }));
/*     */       
/*     */ 
/*     */ 
/*  62 */       return false;
/*     */     }
/*     */     
/*  65 */     ChivalryDayInfo xCDayInfo = getLastXChivalryData();
/*  66 */     int xActivityDaySum = ChivalryManager.getRoleActivityChivalrySum(xCDayInfo, this.activityType);
/*  67 */     if (xActivityDaySum < 0)
/*     */     {
/*  69 */       return false;
/*     */     }
/*  71 */     if (xActivityDaySum >= cfg.gainUp)
/*     */     {
/*  73 */       return false;
/*     */     }
/*  75 */     int xDaySum = getRoleXDayGainSum(cfg.daySumType, xCDayInfo.getActivitydaysum());
/*  76 */     if (xDaySum >= cfg.allDaySum)
/*     */     {
/*  78 */       return false;
/*     */     }
/*  80 */     this.addNumLast = ChivalryManager.getNeedAddChivalryNum(xDaySum, xActivityDaySum, this.needAddNum, cfg.allDaySum, cfg.gainUp);
/*  81 */     if (this.addNumLast <= 0)
/*     */     {
/*  83 */       return false;
/*     */     }
/*  85 */     int changeNum = ChivalryManager.addRoleChivalry(this.roleId, this.addNumLast, this.logArg);
/*  86 */     if (changeNum <= 0)
/*     */     {
/*  88 */       return false;
/*     */     }
/*  90 */     ChivalryManager.addRoleActivityChivalry(xCDayInfo, this.activityType, changeNum);
/*     */     
/*  92 */     if (this.isSend)
/*     */     {
/*  94 */       AwardInterface.awardCurrencyNotice(this.roleId, 2, 1, this.addNumLast);
/*     */     }
/*  96 */     return true;
/*     */   }
/*     */   
/*     */   private boolean canAddChivarly()
/*     */   {
/* 101 */     if (this.needAddNum < 0)
/*     */     {
/* 103 */       return false;
/*     */     }
/* 105 */     if (RoleInterface.getLevel(this.roleId) < ChivalryConsts.getInstance().NEED_LEVEL_LOW)
/*     */     {
/* 107 */       return false;
/*     */     }
/* 109 */     if (isInZero())
/*     */     {
/* 111 */       return false;
/*     */     }
/* 113 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private ChivalryDayInfo getLastXChivalryData()
/*     */   {
/* 125 */     ChivalryDayInfo xCDayInfo = ChivalryManager.getRoleChivalryDayInfo(this.roleId, true);
/* 126 */     if (xCDayInfo == null)
/*     */     {
/* 128 */       xCDayInfo = Pod.newChivalryDayInfo();
/* 129 */       xCDayInfo.setLastflushtime(DateTimeUtils.getCurrTimeInMillis());
/* 130 */       Role2chivalrydayinfo.insert(Long.valueOf(this.roleId), xCDayInfo);
/*     */     }
/* 132 */     if (DateTimeUtils.needDailyReset(xCDayInfo.getLastflushtime(), DateTimeUtils.getCurrTimeInMillis(), 0))
/*     */     {
/* 134 */       ChivalryManager.chivalryDayDataInit(xCDayInfo);
/*     */     }
/* 136 */     return xCDayInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getAddNumLast()
/*     */   {
/* 146 */     return this.addNumLast;
/*     */   }
/*     */   
/*     */   boolean isInZero()
/*     */   {
/* 151 */     return DateTimeUtils.getCurrTimeInMillis() < IdipManager.zeroProfitExpireTime(this.roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int getRoleXDayGainSum(int gainType, Map<Integer, Integer> xActivitydaysum)
/*     */   {
/* 163 */     if (xActivitydaysum == null)
/*     */     {
/* 165 */       return -1;
/*     */     }
/* 167 */     STDaySumType2GainTypes gainTypeCfg = STDaySumType2GainTypes.get(gainType);
/* 168 */     if (gainTypeCfg == null)
/*     */     {
/* 170 */       return -1;
/*     */     }
/* 172 */     int dayGainSum = 0;
/* 173 */     for (Iterator i$ = gainTypeCfg.activityTypes.iterator(); i$.hasNext();) { int tmpGainType = ((Integer)i$.next()).intValue();
/*     */       
/* 175 */       Integer gainNum = (Integer)xActivitydaysum.get(Integer.valueOf(tmpGainType));
/* 176 */       if (gainNum != null)
/*     */       {
/*     */ 
/*     */ 
/* 180 */         dayGainSum += gainNum.intValue(); }
/*     */     }
/* 182 */     return dayGainSum;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chivalry\main\PRoleAddChivalryPro.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */