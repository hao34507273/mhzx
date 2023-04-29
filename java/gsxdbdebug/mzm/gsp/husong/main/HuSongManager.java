/*     */ package mzm.gsp.husong.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.activity.SEndHuSongRes;
/*     */ import mzm.gsp.activity.SupdateHuSong;
/*     */ import mzm.gsp.activity.SynHuSongData;
/*     */ import mzm.gsp.activity.confbean.SHuSongCfg;
/*     */ import mzm.gsp.activity.confbean.SHuSongConst;
/*     */ import mzm.gsp.activity.confbean.SHuSongModifyCfg;
/*     */ import mzm.gsp.activity.confbean.SHuSongSpecialNpcCfg;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.SSendDefaultAwardInfo;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.husong.event.HuSongArg;
/*     */ import mzm.gsp.husong.event.HuSongEvent;
/*     */ import mzm.gsp.idip.main.IdipManager;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import xbean.HuSongDataBean;
/*     */ import xdb.Xdb;
/*     */ 
/*     */ class HuSongManager
/*     */ {
/*     */   static void syncHusongData(String userid, long roleid, HuSongDataBean xHuSongDataBean)
/*     */   {
/*  36 */     SynHuSongData synHuSongData = new SynHuSongData();
/*  37 */     synHuSongData.husongmap.put(Integer.valueOf(2), Integer.valueOf(xHuSongDataBean.getSpecialcount()));
/*  38 */     int count = ActivityInterface.getActivityCount(userid, roleid, SHuSongConst.getInstance().activity, true);
/*  39 */     count = Math.max(0, count);
/*  40 */     synHuSongData.husongmap.put(Integer.valueOf(1), Integer.valueOf(count));
/*  41 */     OnlineManager.getInstance().send(roleid, synHuSongData);
/*     */   }
/*     */   
/*     */   static boolean containsHuSong(long roleid)
/*     */   {
/*  46 */     Set<Integer> statusSet = RoleStatusInterface.selectStatusSet(roleid);
/*  47 */     return (statusSet.contains(Integer.valueOf(32))) || (statusSet.contains(Integer.valueOf(33)));
/*     */   }
/*     */   
/*     */   static boolean setRoleHuSongStatus(long roleid, int husongType)
/*     */   {
/*  52 */     return RoleStatusInterface.setStatus(roleid, husongType == 1 ? 32 : 33, true);
/*     */   }
/*     */   
/*     */ 
/*     */   static void unsetRoleHuSongStatus(long roleid, int husongType)
/*     */   {
/*  58 */     RoleStatusInterface.unsetStatus(roleid, husongType == 1 ? 32 : 33);
/*     */   }
/*     */   
/*     */ 
/*     */   static void unsetRoleHuSongStatus(long roleid)
/*     */   {
/*  64 */     RoleStatusInterface.unsetStatus(roleid, Arrays.asList(new Integer[] { Integer.valueOf(32), Integer.valueOf(33) }));
/*     */   }
/*     */   
/*     */ 
/*     */   static int randomHuSongCoupleNpcCfgid(int gender)
/*     */   {
/*  70 */     SHuSongSpecialNpcCfg cfg = SHuSongSpecialNpcCfg.get(gender);
/*  71 */     return ((Integer)cfg.npc_cfgids.get(Xdb.random().nextInt(cfg.npc_cfgids.size()))).intValue();
/*     */   }
/*     */   
/*     */   static int getHusongCoupleNpcCfgidAndSetMapRoleHuSongState(long roleid, SHuSongCfg huSongCfg)
/*     */   {
/*  76 */     if (huSongCfg.HuSongType == 2)
/*     */     {
/*  78 */       int gender = mzm.gsp.role.main.RoleInterface.getGender(roleid);
/*  79 */       int husongCoupleNpcCfgid = randomHuSongCoupleNpcCfgid(gender);
/*  80 */       MapInterface.setSpecialHuSongState(roleid, huSongCfg.handupNPCid, husongCoupleNpcCfgid, gender);
/*  81 */       return husongCoupleNpcCfgid;
/*     */     }
/*     */     
/*     */ 
/*  85 */     MapInterface.setNormalHuSongState(roleid, huSongCfg.handupNPCid, huSongCfg.huSongMonsterid);
/*  86 */     return 0;
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
/*     */   static void finishHusong(String userId, long roleid, HuSongDataBean xHuSongDataBean, SHuSongCfg huSongCfg)
/*     */   {
/*  99 */     SupdateHuSong updateHuSong = new SupdateHuSong();
/*     */     
/* 101 */     Integer failTime = (Integer)xHuSongDataBean.getParammap().get(Integer.valueOf(3));
/* 102 */     if (failTime == null)
/*     */     {
/* 104 */       failTime = Integer.valueOf(0);
/*     */     }
/* 106 */     if (!IdipManager.isZeroProfit(roleid))
/*     */     {
/* 108 */       SHuSongModifyCfg huSongModifyCfg = SHuSongModifyCfg.get(failTime.intValue());
/* 109 */       mzm.gsp.award.main.AwardModel awardModel = null;
/* 110 */       if (huSongModifyCfg == null)
/*     */       {
/* 112 */         awardModel = AwardInterface.award(huSongCfg.awardid, userId, roleid, false, false, new AwardReason(LogReason.HU_SONG_AWARD, huSongCfg.HuSongType));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 117 */         awardModel = AwardInterface.award(huSongCfg.awardid, userId, roleid, huSongModifyCfg.modifyid, false, false, new AwardReason(LogReason.HU_SONG_AWARD, huSongCfg.HuSongType));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 122 */       SSendDefaultAwardInfo sendDefaultAwardInfo = new SSendDefaultAwardInfo();
/* 123 */       if (awardModel != null)
/*     */       {
/* 125 */         AwardInterface.fillAwardBean(sendDefaultAwardInfo.awardinfo, awardModel);
/*     */       }
/* 127 */       OnlineManager.getInstance().send(roleid, sendDefaultAwardInfo);
/*     */     }
/*     */     
/*     */ 
/* 131 */     switch (huSongCfg.HuSongType)
/*     */     {
/*     */     case 1: 
/* 134 */       ActivityInterface.addActivityCount(userId, roleid, SHuSongConst.getInstance().activity);
/* 135 */       int count = Math.max(0, ActivityInterface.getActivityCount(userId, roleid, SHuSongConst.getInstance().activity, false));
/*     */       
/* 137 */       updateHuSong.husongmap.put(Integer.valueOf(1), Integer.valueOf(count));
/* 138 */       break;
/*     */     
/*     */     case 2: 
/* 141 */       xHuSongDataBean.setSpecialcount(xHuSongDataBean.getSpecialcount() + 1);
/* 142 */       updateHuSong.husongmap.put(Integer.valueOf(2), Integer.valueOf(xHuSongDataBean.getSpecialcount()));
/* 143 */       break;
/*     */     }
/*     */     
/*     */     
/*     */ 
/*     */ 
/* 149 */     xHuSongDataBean.getParammap().clear();
/*     */     
/*     */ 
/* 152 */     unsetRoleHuSongStatus(roleid, huSongCfg.HuSongType);
/*     */     
/* 154 */     OnlineManager.getInstance().send(roleid, updateHuSong);
/*     */     
/*     */ 
/* 157 */     SEndHuSongRes endHuSongRes = new SEndHuSongRes();
/* 158 */     endHuSongRes.husongcfgid = huSongCfg.id;
/* 159 */     endHuSongRes.ret = 1;
/* 160 */     OnlineManager.getInstance().send(roleid, endHuSongRes);
/*     */     
/* 162 */     HuSongEvent huSongEvent = new HuSongEvent();
/* 163 */     HuSongArg huSongArg = new HuSongArg(roleid, true, huSongCfg.id);
/* 164 */     TriggerEventsManger.getInstance().triggerEvent(huSongEvent, huSongArg);
/* 165 */     ActivityInterface.logActivity(roleid, SHuSongConst.getInstance().activity, ActivityLogStatus.FINISH);
/* 166 */     ActivityInterface.tlogActivity(roleid, SHuSongConst.getInstance().activity, ActivityLogStatus.FINISH);
/*     */   }
/*     */   
/*     */   static int getHuSongActivityid()
/*     */   {
/* 171 */     return SHuSongConst.getInstance().activity;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\husong\main\HuSongManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */