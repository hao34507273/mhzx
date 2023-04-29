/*     */ package mzm.gsp.fight.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import hub.DataBroadcast;
/*     */ import hub.GHubHelper;
/*     */ import hub.NotifyFightRecordEndInfo;
/*     */ import hub.NotifyFightRecordRoundInfo;
/*     */ import hub.NotifyFightRecordStartInfo;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.grc.main.GrcInterface;
/*     */ 
/*     */ 
/*     */ class FightRecordManager
/*     */ {
/*     */   public static void onReportFightRecordDone(int retcode, long recordid, int dataType, Octets data, Octets context)
/*     */   {
/*  21 */     if ((retcode == 8) || (retcode == 8102))
/*     */     {
/*     */       try
/*     */       {
/*  25 */         OctetsStream os = new OctetsStream(context);
/*  26 */         int round = os.unmarshal_int();
/*  27 */         int count = os.unmarshal_int();
/*  28 */         if (count >= 6)
/*     */         {
/*  30 */           return;
/*     */         }
/*     */         
/*  33 */         os.clear();
/*  34 */         os.marshal(round);
/*  35 */         os.marshal(count + 1);
/*  36 */         if (!GrcInterface.asyncReportFightRecord(recordid, dataType, data, os))
/*     */         {
/*  38 */           AsyncReportFightRecordInfo info = new AsyncReportFightRecordInfo(recordid, dataType, data, os);
/*  39 */           new AsyncReportFightRecordObserver(info);
/*     */         }
/*     */         
/*     */       }
/*     */       catch (MarshalException e)
/*     */       {
/*  45 */         return;
/*     */       }
/*     */     }
/*  48 */     if (retcode == 0)
/*     */     {
/*  50 */       DataBroadcast dataBroadcast = new DataBroadcast();
/*  51 */       dataBroadcast.direction = 0;
/*  52 */       dataBroadcast.src_id = GameServerInfoManager.getZoneId();
/*  53 */       dataBroadcast.data_type = dataType;
/*  54 */       if (dataType == 1)
/*     */       {
/*  56 */         NotifyFightRecordStartInfo notifyFightRecordStartInfo = new NotifyFightRecordStartInfo();
/*  57 */         notifyFightRecordStartInfo.recordid = recordid;
/*  58 */         notifyFightRecordStartInfo.start_content = data;
/*  59 */         dataBroadcast.data = notifyFightRecordStartInfo.marshal(new OctetsStream());
/*     */       }
/*  61 */       else if (dataType == 2)
/*     */       {
/*     */         try
/*     */         {
/*  65 */           OctetsStream os = new OctetsStream(context);
/*  66 */           int maxRound = os.unmarshal_int();
/*  67 */           NotifyFightRecordEndInfo notifyFightRecordEndInfo = new NotifyFightRecordEndInfo();
/*  68 */           notifyFightRecordEndInfo.recordid = recordid;
/*  69 */           notifyFightRecordEndInfo.max_round = maxRound;
/*  70 */           notifyFightRecordEndInfo.end_content = data;
/*  71 */           dataBroadcast.data = notifyFightRecordEndInfo.marshal(new OctetsStream());
/*     */ 
/*     */         }
/*     */         catch (MarshalException e)
/*     */         {
/*  76 */           return;
/*     */         }
/*     */       }
/*  79 */       else if (dataType == 3)
/*     */       {
/*     */         try
/*     */         {
/*  83 */           OctetsStream os = new OctetsStream(context);
/*  84 */           int round = os.unmarshal_int();
/*  85 */           NotifyFightRecordRoundInfo notifyFightRecordRoundInfo = new NotifyFightRecordRoundInfo();
/*  86 */           notifyFightRecordRoundInfo.recordid = recordid;
/*  87 */           notifyFightRecordRoundInfo.round = round;
/*  88 */           notifyFightRecordRoundInfo.round_content = data;
/*  89 */           dataBroadcast.data = notifyFightRecordRoundInfo.marshal(new OctetsStream());
/*     */ 
/*     */         }
/*     */         catch (MarshalException e)
/*     */         {
/*  94 */           return;
/*     */         }
/*     */       }
/*     */       
/*  98 */       GHubHelper.broadcast(dataBroadcast);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static void onGetFightRecordDone(int retcode, long recordid, int dataType, Octets context, Octets rspdata)
/*     */   {
/* 105 */     if ((retcode == 8) || (retcode == 8102))
/*     */     {
/*     */       try
/*     */       {
/* 109 */         OctetsStream os = new OctetsStream(context);
/* 110 */         int count = os.unmarshal_int();
/* 111 */         if (count >= 3)
/*     */         {
/* 113 */           return;
/*     */         }
/*     */         
/* 116 */         os.clear();
/* 117 */         os.marshal(count + 1);
/* 118 */         GrcInterface.asyncGetFightRecord(recordid, dataType, os);
/*     */       }
/*     */       catch (MarshalException e) {}
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 125 */     if (retcode == 0)
/*     */     {
/* 127 */       RoamFightRecorderCache recorderCache = RoamFightRecorderCacheManager.getInstance().getRoamFightRecorderCache(recordid);
/*     */       
/* 129 */       if (recorderCache == null)
/*     */       {
/* 131 */         return;
/*     */       }
/*     */       
/*     */       try
/*     */       {
/* 136 */         OctetsStream osResInfo = new OctetsStream(rspdata);
/* 137 */         Octets fightStart = osResInfo.unmarshal_Octets();
/* 138 */         Octets fightEnd = osResInfo.unmarshal_Octets();
/* 139 */         int maxRounds = osResInfo.unmarshal_int();
/* 140 */         List<Octets> roundDataList = new LinkedList();
/* 141 */         for (int i = 0; i < maxRounds; i++)
/*     */         {
/* 143 */           roundDataList.add(osResInfo.unmarshal_Octets());
/*     */         }
/* 145 */         recorderCache.onReady(fightStart, fightEnd, roundDataList);
/*     */ 
/*     */       }
/*     */       catch (MarshalException e) {}
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/* 154 */       RoamFightRecorderCacheManager.getInstance().removeRoamFightRecorderCache(recordid);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void onRoamFightRecordStart(long recordid, Octets startData)
/*     */   {
/* 160 */     RoamFightRecorder recorder = RoamFightRecorderManager.getInstance().addRoamFightRecorder(recordid);
/* 161 */     if (recorder == null)
/*     */     {
/* 163 */       return;
/*     */     }
/*     */     
/* 166 */     recorder.fightStart(startData);
/*     */   }
/*     */   
/*     */   public static void onRoamFightRecordEnd(long recordid, int maxRound, Octets endData)
/*     */   {
/* 171 */     RoamFightRecorder recorder = RoamFightRecorderManager.getInstance().getRoamFightRecorder(recordid);
/* 172 */     if (recorder == null)
/*     */     {
/* 174 */       return;
/*     */     }
/*     */     
/* 177 */     if (recorder.fightEnd(maxRound, endData))
/*     */     {
/* 179 */       RoamFightRecorderManager.getInstance().removeRoamFightRecorder(recordid);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void onRoamFightRecordRound(long recordid, int round, Octets roundData)
/*     */   {
/* 185 */     RoamFightRecorder recorder = RoamFightRecorderManager.getInstance().getRoamFightRecorder(recordid);
/* 186 */     if (recorder == null)
/*     */     {
/* 188 */       return;
/*     */     }
/*     */     
/* 191 */     recorder.fightRound(round, roundData);
/*     */   }
/*     */   
/*     */ 
/*     */   public static void getRoamFightRecord(long roleid, long recordid)
/*     */   {
/* 197 */     RoamFightRecorder recorder = RoamFightRecorderManager.getInstance().getRoamFightRecorder(recordid);
/* 198 */     if (recorder != null)
/*     */     {
/* 200 */       AddObserverResult result = recorder.addObserver(roleid);
/* 201 */       switch (result)
/*     */       {
/*     */       case DuplicateAdd: 
/* 204 */         return;
/*     */       
/*     */       case RecordDataDirty: 
/* 207 */         return;
/*     */       
/*     */       case SUCCESS: 
/* 210 */         RoamFightRecorderManager.getInstance().addObserverRecorder(roleid, recordid);
/* 211 */         RoamFightRecorderCacheManager.getInstance().removeObserverRecorderCache(roleid); return;
/*     */       case FightEnd: 
/*     */         break;
/*     */       }
/*     */       
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 224 */     RoamFightRecorderManager.getInstance().removeObserverRecorder(roleid);
/* 225 */     RoamFightRecorderCacheManager.getInstance().removeObserverRecorderCache(roleid);
/*     */     
/* 227 */     RoamFightRecorderCache recorderCache = RoamFightRecorderCacheManager.getInstance().getRoamFightRecorderCache(recordid);
/*     */     
/* 229 */     if (recorderCache == null)
/*     */     {
/* 231 */       recorderCache = RoamFightRecorderCacheManager.getInstance().addRoamFightRecorderCache(recordid);
/*     */     }
/*     */     
/* 234 */     int result = recorderCache.trySyncFightRecordInfo(roleid);
/* 235 */     if (result > 0)
/*     */     {
/* 237 */       return;
/*     */     }
/*     */     
/* 240 */     RoamFightRecorderCacheManager.getInstance().addObserverRecorderCache(roleid, recordid);
/*     */     
/* 242 */     if (result == 0)
/*     */     {
/* 244 */       int dataType = 0;
/* 245 */       OctetsStream context = new OctetsStream();
/* 246 */       context.marshal(1);
/* 247 */       if (!GrcInterface.asyncGetFightRecord(recordid, 0, context))
/*     */       {
/* 249 */         AsyncGetFightRecordInfo info = new AsyncGetFightRecordInfo(recordid, 0, context);
/* 250 */         new AsyncGetFightRecordObserver(info);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\main\FightRecordManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */