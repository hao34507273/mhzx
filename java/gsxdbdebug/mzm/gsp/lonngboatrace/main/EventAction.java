/*     */ package mzm.gsp.lonngboatrace.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.Random;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.lonngboatrace.SEvent;
/*     */ import mzm.gsp.lonngboatrace.STeamFinish;
/*     */ import mzm.gsp.lonngboatrace.Statistic;
/*     */ import mzm.gsp.lonngboatrace.confbean.Event;
/*     */ import mzm.gsp.lonngboatrace.confbean.EventId2Event;
/*     */ import mzm.gsp.lonngboatrace.confbean.LonngBoatRaceCfg;
/*     */ import mzm.gsp.lonngboatrace.confbean.Phase;
/*     */ import mzm.gsp.lonngboatrace.confbean.STLonngBoatRaceEventCfg;
/*     */ import mzm.gsp.lonngboatrace.confbean.TriggerEvent;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.LonngBoatRaceMatch;
/*     */ import xbean.LonngBoatRaceStat;
/*     */ import xbean.LonngBoatRaceTeamStat;
/*     */ import xdb.Xdb;
/*     */ import xtable.Lonngboatrace;
/*     */ 
/*     */ public class EventAction
/*     */ {
/*     */   final long lonngboatraceId;
/*     */   final TriggerEvent triggerEvent;
/*     */   final Map<Integer, Phase> phaseNo2phase;
/*     */   Map<Long, Long> rankList;
/*     */   
/*     */   public EventAction(long lonngboatraceId, TriggerEvent triggerEvent, Map<Integer, Phase> phaseNo2phase)
/*     */   {
/*  46 */     this.lonngboatraceId = lonngboatraceId;
/*  47 */     this.triggerEvent = triggerEvent;
/*  48 */     this.phaseNo2phase = phaseNo2phase;
/*     */   }
/*     */   
/*     */ 
/*     */   boolean doAction()
/*     */   {
/*  54 */     Map<Integer, Event> eventId2Event = getEventId2Event(this.triggerEvent.eventTypeId);
/*  55 */     if (eventId2Event == null) {
/*  56 */       return false;
/*     */     }
/*  58 */     RandomCollection<Event> eventRandomCollection = new RandomCollection();
/*     */     
/*  60 */     HashMap<Long, Integer> teamId2eventId = new HashMap();
/*     */     
/*  62 */     for (Map.Entry<Integer, Event> entry : eventId2Event.entrySet())
/*     */     {
/*  64 */       Event event = (Event)entry.getValue();
/*  65 */       eventRandomCollection.add(event.weight, event);
/*     */     }
/*     */     
/*  68 */     LonngBoatRaceMatch xLonngBoatRaceMatch = Lonngboatrace.get(Long.valueOf(this.lonngboatraceId));
/*  69 */     int phaseNo = xLonngBoatRaceMatch.getPhaseno();
/*  70 */     int roundNo = xLonngBoatRaceMatch.getRoundno();
/*  71 */     int timesNo = xLonngBoatRaceMatch.getTimesno();
/*  72 */     Phase phase = (Phase)this.phaseNo2phase.get(Integer.valueOf(phaseNo));
/*  73 */     int raceId = xLonngBoatRaceMatch.getRaceid();
/*     */     
/*  75 */     Map<Long, LonngBoatRaceTeamStat> teamId2teamStat = xLonngBoatRaceMatch.getTeamid2teamstat();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  80 */     for (Map.Entry<Long, LonngBoatRaceTeamStat> entry : teamId2teamStat.entrySet())
/*     */     {
/*  82 */       long teamId = ((Long)entry.getKey()).longValue();
/*  83 */       LonngBoatRaceTeamStat teamStat = (LonngBoatRaceTeamStat)entry.getValue();
/*     */       
/*     */ 
/*  86 */       Event event = (Event)eventRandomCollection.next();
/*  87 */       teamStat.setEventtypeid(this.triggerEvent.eventTypeId);
/*  88 */       teamStat.setEventtriggerid(this.triggerEvent.id);
/*     */       
/*  90 */       if (this.triggerEvent.eventTriggerType == 1)
/*     */       {
/*  92 */         boolean canTrigger = canTriggerEvent(teamStat.getRole2stat_phase());
/*  93 */         if (!canTrigger)
/*     */         {
/*  95 */           teamId2eventId.put(Long.valueOf(teamId), Integer.valueOf(-1));
/*  96 */           teamStat.setEventid(-1);
/*  97 */           GameServer.logger().info(String.format("[lonngboatrace]EventAction.doAction@lonngboatrace can not trigger event|lonngboatraceid=%d|teamid=%d|phaseno=%d|roundno=%d|timesno=%d", new Object[] { Long.valueOf(this.lonngboatraceId), Long.valueOf(teamId), Integer.valueOf(phaseNo), Integer.valueOf(roundNo), Integer.valueOf(timesNo) }));
/*     */           
/*     */ 
/* 100 */           continue;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 105 */       teamStat.setEventid(event.id);
/*     */       
/* 107 */       float speed = teamStat.getSpeed();
/* 108 */       float tmp = (float)(speed + event.delta);
/* 109 */       if (event.delta > 0.0D) {
/* 110 */         speed = tmp > phase.maxSpeed ? (float)phase.maxSpeed : tmp;
/*     */       } else
/* 112 */         speed = tmp < phase.minSpeed ? (float)phase.minSpeed : tmp;
/* 113 */       teamStat.setSpeed(speed);
/*     */       
/* 115 */       teamId2eventId.put(Long.valueOf(teamId), Integer.valueOf(event.id));
/* 116 */       GameServer.logger().info(String.format("[lonngboatrace]EventAction.doAction@lonngboatrace trigger event|lonngboatraceid=%d|teamid=%d|eventid=%d|teamspeed=%f|phaseno=%d|roundno=%d|timesno=%d", new Object[] { Long.valueOf(this.lonngboatraceId), Long.valueOf(teamId), Integer.valueOf(event.id), Float.valueOf(speed), Integer.valueOf(phaseNo), Integer.valueOf(roundNo), Integer.valueOf(timesNo) }));
/*     */     }
/*     */     
/*     */ 
/* 120 */     xLonngBoatRaceMatch.setState(3);
/*     */     
/*     */ 
/*     */ 
/* 124 */     long currTimesStamp = DateTimeUtils.getCurrTimeInMillis();
/* 125 */     if (this.triggerEvent.eventTimeType == 0)
/*     */     {
/* 127 */       long endTimeStamp = this.triggerEvent.eventTime * 1000 + currTimesStamp;
/*     */       
/* 129 */       xLonngBoatRaceMatch.setEndtimestamp(endTimeStamp);
/*     */       
/*     */ 
/* 132 */       new FixedTimeEventSession(this.triggerEvent.eventTime, this.lonngboatraceId);
/*     */       
/* 134 */       return OnlineManager.getInstance().sendMulti(new SEvent(phase.id, this.triggerEvent.id, teamId2eventId, endTimeStamp, currTimesStamp, 0), LonngBoatRaceManager.getRoleIdsFromLonngBoatRaceMatch(xLonngBoatRaceMatch));
/*     */     }
/*     */     float minTimeRemain;
/*     */     long endTimeStamp;
/* 138 */     if (this.triggerEvent.eventTimeType == 1)
/*     */     {
/* 140 */       float tackLen = (float)LonngBoatRaceCfg.get(raceId).trackLen;
/* 141 */       minTimeRemain = Float.MAX_VALUE;
/* 142 */       for (Map.Entry<Long, LonngBoatRaceTeamStat> entry : teamId2teamStat.entrySet())
/*     */       {
/* 144 */         long teamId = ((Long)entry.getKey()).longValue();
/* 145 */         LonngBoatRaceTeamStat teamStat = (LonngBoatRaceTeamStat)entry.getValue();
/* 146 */         float tackRemain = tackLen - teamStat.getLocation();
/* 147 */         float timeRemain = tackRemain / teamStat.getSpeed();
/* 148 */         if (timeRemain < minTimeRemain)
/* 149 */           minTimeRemain = timeRemain;
/* 150 */         long endTimeStamp = (timeRemain * 1000.0F) + currTimesStamp;
/* 151 */         teamStat.setEndtimestamp(endTimeStamp);
/* 152 */         GameServer.logger().info(String.format("[lonngboatrace]EventAction.doAction@lonngboatrace remain time|lonngboatraceid=%d|teamid=%d|timeRemain=%f|endTimeStamp=%d|phaseno=%d|roundno=%d|timesno=%d", new Object[] { Long.valueOf(this.lonngboatraceId), Long.valueOf(teamId), Float.valueOf(timeRemain), Long.valueOf(endTimeStamp), Integer.valueOf(phaseNo), Integer.valueOf(roundNo), Integer.valueOf(timesNo) }));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 157 */       this.rankList = LonngBoatRaceManager.getRankList(xLonngBoatRaceMatch);
/*     */       
/*     */ 
/* 160 */       endTimeStamp = (minTimeRemain * 1000.0F) + currTimesStamp;
/* 161 */       xLonngBoatRaceMatch.setEndtimestamp(endTimeStamp);
/*     */       
/*     */ 
/* 164 */       for (Map.Entry<Long, LonngBoatRaceTeamStat> entry : teamId2teamStat.entrySet())
/*     */       {
/* 166 */         long teamId = ((Long)entry.getKey()).longValue();
/*     */         
/* 168 */         if (teamId >= 0L)
/*     */         {
/*     */ 
/*     */ 
/* 172 */           new RemainTimeEventSession(minTimeRemain, Long.valueOf(teamId));
/*     */           
/*     */ 
/* 175 */           OnlineManager.getInstance().sendMulti(new SEvent(phase.id, this.triggerEvent.id, teamId2eventId, endTimeStamp, currTimesStamp, 0), ((LonngBoatRaceTeamStat)entry.getValue()).getRole2stat().keySet());
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 180 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private boolean canTriggerEvent(Map<Long, LonngBoatRaceStat> role2stat_phase)
/*     */   {
/* 186 */     if (role2stat_phase.isEmpty()) {
/* 187 */       return false;
/*     */     }
/* 189 */     boolean result = true;
/* 190 */     for (Map.Entry<Long, LonngBoatRaceStat> entry : role2stat_phase.entrySet())
/*     */     {
/* 192 */       if (((LonngBoatRaceStat)entry.getValue()).getWrong() != 0)
/*     */       {
/* 194 */         result = false;
/* 195 */         break;
/*     */       }
/*     */     }
/* 198 */     return result;
/*     */   }
/*     */   
/*     */   class RandomCollection<E>
/*     */   {
/* 203 */     private final NavigableMap<Double, E> map = new TreeMap();
/* 204 */     private double total = 0.0D;
/*     */     
/*     */     RandomCollection() {}
/*     */     
/* 208 */     void add(double weight, E result) { if (weight <= 0.0D)
/* 209 */         return;
/* 210 */       this.total += weight;
/* 211 */       this.map.put(Double.valueOf(this.total), result);
/*     */     }
/*     */     
/*     */     public E next()
/*     */     {
/* 216 */       double key = Xdb.random().nextDouble() * this.total;
/* 217 */       return (E)this.map.higherEntry(Double.valueOf(key)).getValue();
/*     */     }
/*     */   }
/*     */   
/*     */   private HashMap<Integer, Event> getEventId2Event(int eventTypeId)
/*     */   {
/* 223 */     STLonngBoatRaceEventCfg eventCfg = (STLonngBoatRaceEventCfg)STLonngBoatRaceEventCfg.getAll().values().iterator().next();
/* 224 */     if ((eventCfg == null) || (eventCfg.eventTypeId2Events == null))
/* 225 */       return null;
/* 226 */     EventId2Event eventId2Event = (EventId2Event)eventCfg.eventTypeId2Events.get(Integer.valueOf(eventTypeId));
/* 227 */     if (eventId2Event == null)
/* 228 */       return null;
/* 229 */     return eventId2Event.eventId2Event;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   class FixedTimeEventSession
/*     */     extends Session
/*     */   {
/*     */     public FixedTimeEventSession(long interval, long roleId)
/*     */     {
/* 243 */       super(roleId);
/*     */     }
/*     */     
/*     */ 
/*     */     protected void onTimeOut()
/*     */     {
/* 249 */       new EventAction.FixedTimeEventProcedure(EventAction.this).execute();
/*     */     }
/*     */   }
/*     */   
/*     */   class FixedTimeEventProcedure
/*     */     extends LogicProcedure
/*     */   {
/*     */     FixedTimeEventProcedure() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 260 */       LonngBoatRaceMatch xLonngBoatRaceMatch = Lonngboatrace.get(Long.valueOf(EventAction.this.lonngboatraceId));
/*     */       
/*     */ 
/* 263 */       Map<Long, LonngBoatRaceTeamStat> teamId2TeamStat = xLonngBoatRaceMatch.getTeamid2teamstat();
/* 264 */       LonngBoatRaceManager.updateBoatLocationAndSpeed(teamId2TeamStat, EventAction.this.triggerEvent.eventTime, null);
/*     */       
/*     */ 
/* 267 */       return LonngBoatRaceManager.nextAction(EventAction.this.lonngboatraceId, EventAction.this.phaseNo2phase);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   class RemainTimeEventSession
/*     */     extends Session
/*     */   {
/*     */     final long teamId;
/*     */     
/*     */ 
/*     */ 
/*     */     public RemainTimeEventSession(long interval, Long teamId)
/*     */     {
/* 283 */       super(teamId.longValue());
/* 284 */       this.teamId = teamId.longValue();
/*     */     }
/*     */     
/*     */ 
/*     */     protected void onTimeOut()
/*     */     {
/* 290 */       new EventAction.RemainTimeEventProcedure(EventAction.this, Long.valueOf(this.teamId)).execute();
/*     */     }
/*     */   }
/*     */   
/*     */   class RemainTimeEventProcedure extends LogicProcedure
/*     */   {
/*     */     final Long teamId;
/*     */     
/*     */     RemainTimeEventProcedure(Long teamId)
/*     */     {
/* 300 */       this.teamId = teamId;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 313 */       LonngBoatRaceMatch xLonngBoatRaceMatch = Lonngboatrace.select(Long.valueOf(EventAction.this.lonngboatraceId));
/* 314 */       java.util.Set<Long> memberSet = ((LonngBoatRaceTeamStat)xLonngBoatRaceMatch.getTeamid2teamstat().get(this.teamId)).getRole2stat().keySet();
/*     */       
/* 316 */       Map<Long, String> roleId2UserId = new HashMap();
/* 317 */       for (Long roleId : memberSet)
/*     */       {
/* 319 */         roleId2UserId.put(roleId, RoleInterface.getUserId(roleId.longValue()));
/*     */       }
/*     */       
/*     */ 
/* 323 */       lock(xtable.User.getTable(), roleId2UserId.values());
/*     */       
/*     */ 
/* 326 */       lock(xtable.Basic.getTable(), memberSet);
/*     */       
/*     */ 
/* 329 */       lock(Lonngboatrace.getTable(), Arrays.asList(new Long[] { Long.valueOf(EventAction.this.lonngboatraceId) }));
/*     */       
/* 331 */       LonngBoatRaceTeamStat xTeamStat = (LonngBoatRaceTeamStat)xLonngBoatRaceMatch.getTeamid2teamstat().get(this.teamId);
/* 332 */       HashMap<Long, Statistic> role2statistic = new HashMap();
/* 333 */       Map<Long, LonngBoatRaceStat> role2stat = xTeamStat.getRole2stat();
/* 334 */       for (Map.Entry<Long, LonngBoatRaceStat> entry : role2stat.entrySet()) {
/* 335 */         role2statistic.put(entry.getKey(), new Statistic(((LonngBoatRaceStat)entry.getValue()).getRight(), ((LonngBoatRaceStat)entry.getValue()).getWrong()));
/*     */       }
/*     */       
/* 338 */       OnlineManager.getInstance().sendMulti(new STeamFinish(role2statistic), xTeamStat.getRole2stat().keySet());
/*     */       
/* 340 */       int activityId = xLonngBoatRaceMatch.getActivityid();
/*     */       
/*     */ 
/* 343 */       LonngBoatRaceManager.awardForTeam(activityId, this.teamId.longValue(), xTeamStat, EventAction.this.rankList);
/*     */       
/* 345 */       java.util.List<Long> memberList = new ArrayList(memberSet);
/*     */       
/*     */ 
/* 348 */       LonngBoatRaceManager.deleteMatchRecordAndStatus(memberList);
/*     */       
/*     */ 
/* 351 */       LonngBoatRaceTLogManager.tlogLonngBoatRace(memberList, ((Long)EventAction.this.rankList.get(this.teamId)).longValue());
/*     */       
/* 353 */       for (Long roleid : memberList)
/*     */       {
/*     */ 
/* 356 */         ActivityInterface.addActivityCount((String)roleId2UserId.get(roleid), roleid.longValue(), activityId);
/*     */         
/*     */ 
/* 359 */         ActivityInterface.logActivity(roleid.longValue(), activityId, ActivityLogStatus.FINISH);
/*     */       }
/*     */       
/* 362 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\main\EventAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */