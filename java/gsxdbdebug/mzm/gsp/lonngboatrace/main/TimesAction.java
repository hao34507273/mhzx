/*     */ package mzm.gsp.lonngboatrace.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.lonngboatrace.SCommandResults;
/*     */ import mzm.gsp.lonngboatrace.SSendCommand;
/*     */ import mzm.gsp.lonngboatrace.confbean.Command;
/*     */ import mzm.gsp.lonngboatrace.confbean.Phase;
/*     */ import mzm.gsp.lonngboatrace.confbean.TLonngBoatRaceConsoleCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.LonngBoatRaceMatch;
/*     */ import xbean.LonngBoatRaceTeamStat;
/*     */ import xdb.Xdb;
/*     */ import xtable.Lonngboatrace;
/*     */ 
/*     */ public class TimesAction
/*     */ {
/*     */   final long lonngboatraceId;
/*     */   final Map<Integer, Phase> phaseNo2phase;
/*     */   
/*     */   public TimesAction(Map<Integer, Phase> phaseNo2phase, long lonngboatraceId)
/*     */   {
/*  34 */     this.phaseNo2phase = phaseNo2phase;
/*  35 */     this.lonngboatraceId = lonngboatraceId;
/*     */   }
/*     */   
/*     */   boolean commandAction()
/*     */   {
/*  40 */     LonngBoatRaceMatch xLonngBoatRaceMatch = Lonngboatrace.get(Long.valueOf(this.lonngboatraceId));
/*     */     
/*  42 */     int phaseNo = xLonngBoatRaceMatch.getPhaseno();
/*  43 */     int roundNo = xLonngBoatRaceMatch.getRoundno();
/*  44 */     int timesNo = xLonngBoatRaceMatch.getTimesno();
/*  45 */     Phase phase = (Phase)this.phaseNo2phase.get(Integer.valueOf(phaseNo));
/*     */     
/*     */ 
/*  48 */     List<Integer> commandList = xLonngBoatRaceMatch.getCommandlist();
/*  49 */     LonngBoatRaceManager.clearRole2isright_times(xLonngBoatRaceMatch);
/*  50 */     commandList.clear();
/*  51 */     randomCommand(commandList, phase, xLonngBoatRaceMatch.getRaceid());
/*  52 */     GameServer.logger().info(String.format("[lonngboatrace]TimesAction.commandAction@lonngboatrace random command done|lonngboatraceid=%d|phaseno=%d|roundno=%d|timesno=%d|commandlist=%s", new Object[] { Long.valueOf(this.lonngboatraceId), Integer.valueOf(phaseNo), Integer.valueOf(roundNo), Integer.valueOf(timesNo), Arrays.toString(commandList.toArray()) }));
/*     */     
/*     */ 
/*     */ 
/*  56 */     List<Long> allReceiver = LonngBoatRaceManager.getRoleIdsFromLonngBoatRaceMatch(xLonngBoatRaceMatch);
/*  57 */     long currTimeStamp = DateTimeUtils.getCurrTimeInMillis();
/*  58 */     long endTimeStampInMillis = phase.commandTime * 1000 + currTimeStamp;
/*     */     
/*     */ 
/*  61 */     xLonngBoatRaceMatch.setState(1);
/*  62 */     xLonngBoatRaceMatch.setEndtimestamp(endTimeStampInMillis);
/*     */     
/*     */ 
/*  65 */     new CommandSession(phase.commandTime, this.lonngboatraceId);
/*     */     
/*  67 */     SSendCommand sendCond = new SSendCommand(phase.id, roundNo, timesNo, new ArrayList(), endTimeStampInMillis, currTimeStamp);
/*     */     
/*  69 */     sendCond.commandlist.addAll(commandList);
/*  70 */     OnlineManager.getInstance().sendMulti(sendCond, allReceiver);
/*     */     
/*  72 */     GameServer.logger().info(String.format("[lonngboatrace]TimesAction.commandAction@lonngboatrace send command done|lonngboatraceid=%d|phaseno=%d|roundno=%d|timesno=%d|endTimeStampInMillis=%d", new Object[] { Long.valueOf(this.lonngboatraceId), Integer.valueOf(phaseNo), Integer.valueOf(roundNo), Integer.valueOf(timesNo), Long.valueOf(endTimeStampInMillis) }));
/*     */     
/*     */ 
/*     */ 
/*  76 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void randomCommand(List<Integer> commandList, Phase phase, int raceId)
/*     */   {
/*  84 */     int commendCount = phase.commandCount;
/*  85 */     ArrayList<Command> commands = TLonngBoatRaceConsoleCfg.get(raceId).commandList;
/*  86 */     int commandTotal = commands.size();
/*  87 */     for (int i = 0; i < commendCount; i++)
/*     */     {
/*  89 */       commandList.add(i, Integer.valueOf(((Command)commands.get(Xdb.random().nextInt(commandTotal))).commandType));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   class CommandSession
/*     */     extends Session
/*     */   {
/*     */     public CommandSession(long interval, long roleId)
/*     */     {
/* 104 */       super(roleId);
/*     */     }
/*     */     
/*     */ 
/*     */     protected void onTimeOut()
/*     */     {
/* 110 */       new TimesAction.CommandProcedure(TimesAction.this).execute();
/*     */     }
/*     */   }
/*     */   
/*     */   class CommandProcedure extends LogicProcedure
/*     */   {
/*     */     CommandProcedure() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 120 */       LonngBoatRaceMatch xLonngBoatRaceMatch = Lonngboatrace.get(Long.valueOf(TimesAction.this.lonngboatraceId));
/*     */       
/* 122 */       int phaseNo = xLonngBoatRaceMatch.getPhaseno();
/* 123 */       int roundNo = xLonngBoatRaceMatch.getRoundno();
/* 124 */       int timesNo = xLonngBoatRaceMatch.getTimesno();
/* 125 */       Phase phase = (Phase)TimesAction.this.phaseNo2phase.get(Integer.valueOf(phaseNo));
/*     */       
/*     */ 
/* 128 */       Map<Long, LonngBoatRaceTeamStat> teamId2TeamStat = xLonngBoatRaceMatch.getTeamid2teamstat();
/*     */       
/* 130 */       HashMap<Long, Integer> teamId2isAllRight = new HashMap();
/* 131 */       HashMap<Long, HashMap<Long, Integer>> teamId2roleId2isRight = new HashMap();
/* 132 */       HashMap<Long, Integer> roleId2isRandom = new HashMap();
/*     */       
/* 134 */       List<Long> roleIds = LonngBoatRaceManager.getRoleIdsFromLonngBoatRaceMatch(xLonngBoatRaceMatch);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 142 */       ArrayList<Integer> randomCommandList = new ArrayList();
/* 143 */       Map<Long, Long> roleId2TeamId = new HashMap();
/* 144 */       for (Map.Entry<Long, LonngBoatRaceTeamStat> teamStatEntry : teamId2TeamStat.entrySet())
/*     */       {
/* 146 */         boolean isAllCorrect = true;
/*     */         
/* 148 */         long teamId = ((Long)teamStatEntry.getKey()).longValue();
/*     */         
/* 150 */         if (teamId < 0L)
/*     */         {
/* 152 */           int random = Xdb.random().nextInt(100);
/* 153 */           if (random >= phase.aIAccuracy) {
/* 154 */             isAllCorrect = false;
/*     */           }
/*     */         }
/*     */         else {
/* 158 */           Set<Long> memberIdList = ((LonngBoatRaceTeamStat)teamStatEntry.getValue()).getRole2stat().keySet();
/* 159 */           LonngBoatRaceTeamStat xTeamStat = (LonngBoatRaceTeamStat)teamStatEntry.getValue();
/* 160 */           Map<Long, Boolean> roleId2isright = xTeamStat.getRole2isright_times();
/* 161 */           HashMap<Long, Integer> roleId2isRight = new HashMap();
/* 162 */           for (Long roleId : memberIdList)
/*     */           {
/* 164 */             roleId2TeamId.put(roleId, Long.valueOf(teamId));
/* 165 */             boolean isright; if (!roleId2isright.containsKey(roleId))
/*     */             {
/* 167 */               randomCommandList.clear();
/* 168 */               TimesAction.this.randomCommand(randomCommandList, phase, xLonngBoatRaceMatch.getRaceid());
/*     */               
/*     */ 
/* 171 */               boolean isright = LonngBoatRaceManager.checkCommand(xLonngBoatRaceMatch.getCommandlist(), randomCommandList);
/*     */               
/*     */ 
/*     */ 
/* 175 */               LonngBoatRaceManager.updateRoleStat(xTeamStat, isright, roleId.longValue());
/* 176 */               roleId2isRandom.put(roleId, Integer.valueOf(2));
/*     */               
/* 178 */               GameServer.logger().info(String.format("[lonngboatrace]TimesAction.CommandProcedure.processImp@lonngboatrace role command judge|lonngboatraceid=%d|phaseno=%d|roundno=%d|timesno=%d|teamid=%d|roleid=%d|isright=%b|israndom=%s", new Object[] { Long.valueOf(TimesAction.this.lonngboatraceId), Integer.valueOf(phaseNo), Integer.valueOf(roundNo), Integer.valueOf(timesNo), Long.valueOf(teamId), roleId, Boolean.valueOf(isright), "yes" }));
/*     */ 
/*     */             }
/*     */             else
/*     */             {
/*     */ 
/* 184 */               roleId2isRandom.put(roleId, Integer.valueOf(3));
/* 185 */               isright = ((Boolean)roleId2isright.get(roleId)).booleanValue();
/*     */               
/* 187 */               GameServer.logger().info(String.format("[lonngboatrace]TimesAction.CommandProcedure.processImp@lonngboatrace role command judge|lonngboatraceid=%d|phaseno=%d|roundno=%d|timesno=%d|teamid=%d|roleid=%d|isright=%b|israndom=%s", new Object[] { Long.valueOf(TimesAction.this.lonngboatraceId), Integer.valueOf(phaseNo), Integer.valueOf(roundNo), Integer.valueOf(timesNo), Long.valueOf(teamId), roleId, Boolean.valueOf(isright), "no" }));
/*     */             }
/*     */             
/*     */ 
/* 191 */             roleId2isRight.put(roleId, Integer.valueOf(isright ? 0 : 1));
/* 192 */             if (!isright)
/* 193 */               isAllCorrect = false;
/*     */           }
/* 195 */           teamId2roleId2isRight.put(Long.valueOf(teamId), roleId2isRight);
/*     */         }
/* 197 */         teamId2isAllRight.put(Long.valueOf(teamId), Integer.valueOf(isAllCorrect ? 0 : 1));
/*     */       }
/*     */       
/* 200 */       long currTimeStamp = DateTimeUtils.getCurrTimeInMillis();
/* 201 */       long endTimeStampInMillis = phase.tipTime * 1000 + currTimeStamp;
/*     */       
/*     */ 
/* 204 */       LonngBoatRaceManager.updateBoatLocationAndSpeed(teamId2TeamStat, phase.commandTime, teamId2isAllRight, phase);
/*     */       
/*     */ 
/* 207 */       xLonngBoatRaceMatch.setState(2);
/* 208 */       xLonngBoatRaceMatch.setEndtimestamp(endTimeStampInMillis);
/* 209 */       xLonngBoatRaceMatch.getRoleid2israndom().putAll(roleId2isRandom);
/* 210 */       xLonngBoatRaceMatch.getTeamid2isallright().putAll(teamId2isAllRight);
/*     */       
/*     */ 
/* 213 */       new TimesAction.TipSession(TimesAction.this, phase.tipTime, TimesAction.this.lonngboatraceId);
/*     */       
/*     */ 
/* 216 */       for (Long rid : roleIds)
/*     */       {
/* 218 */         long teamId = ((Long)roleId2TeamId.get(rid)).longValue();
/* 219 */         OnlineManager.getInstance().send(rid.longValue(), new SCommandResults(phase.id, teamId2isAllRight, (HashMap)teamId2roleId2isRight.get(Long.valueOf(teamId)), ((Integer)roleId2isRandom.get(rid)).intValue(), endTimeStampInMillis, currTimeStamp, 4));
/*     */       }
/*     */       
/*     */ 
/* 223 */       GameServer.logger().info(String.format("[lonngboatrace]TimesAction.CommandProcedure.processImp@lonngboatrace send command result to role|lonngboatraceid=%d|phaseno=%d|roundno=%d|timesno=%d|endTimeStamp=%d", new Object[] { Long.valueOf(TimesAction.this.lonngboatraceId), Integer.valueOf(phaseNo), Integer.valueOf(roundNo), Integer.valueOf(timesNo), Long.valueOf(endTimeStampInMillis) }));
/*     */       
/*     */ 
/*     */ 
/* 227 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   class TipSession
/*     */     extends Session
/*     */   {
/*     */     public TipSession(long interval, long roleId)
/*     */     {
/* 241 */       super(roleId);
/*     */     }
/*     */     
/*     */ 
/*     */     protected void onTimeOut()
/*     */     {
/* 247 */       new TimesAction.TipProcedure(TimesAction.this).execute();
/*     */     }
/*     */   }
/*     */   
/*     */   class TipProcedure
/*     */     extends LogicProcedure
/*     */   {
/*     */     TipProcedure() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 258 */       LonngBoatRaceMatch xLonngBoatRaceMatch = Lonngboatrace.get(Long.valueOf(TimesAction.this.lonngboatraceId));
/* 259 */       int phaseNo = xLonngBoatRaceMatch.getPhaseno();
/* 260 */       Phase phase = (Phase)TimesAction.this.phaseNo2phase.get(Integer.valueOf(phaseNo));
/*     */       
/*     */ 
/* 263 */       Map<Long, LonngBoatRaceTeamStat> teamId2TeamStat = xLonngBoatRaceMatch.getTeamid2teamstat();
/* 264 */       LonngBoatRaceManager.updateBoatLocationAndSpeed(teamId2TeamStat, phase.tipTime, null);
/*     */       
/* 266 */       int raceId = xLonngBoatRaceMatch.getRaceid();
/*     */       
/* 268 */       mzm.gsp.lonngboatrace.confbean.TriggerEvent triggerEvent = LonngBoatRaceManager.getTriggerEvent(raceId, phase.id, xLonngBoatRaceMatch.getRoundno(), xLonngBoatRaceMatch.getTimesno());
/*     */       
/* 270 */       if (triggerEvent != null)
/*     */       {
/* 272 */         GameServer.logger().info(String.format("[lonngboatrace]TimesAction.TipProcedure.processImp@lonngboatrace trigger event|lonngboatraceid=%d|phaseno=%d|roundno=%d|timesno=%d", new Object[] { Long.valueOf(TimesAction.this.lonngboatraceId), Integer.valueOf(phaseNo), Integer.valueOf(xLonngBoatRaceMatch.getRoundno()), Integer.valueOf(xLonngBoatRaceMatch.getTimesno()) }));
/*     */         
/*     */ 
/* 275 */         return new EventAction(TimesAction.this.lonngboatraceId, triggerEvent, TimesAction.this.phaseNo2phase).doAction();
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 280 */       return LonngBoatRaceManager.nextAction(TimesAction.this.lonngboatraceId, TimesAction.this.phaseNo2phase);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\main\TimesAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */