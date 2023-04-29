/*     */ package mzm.gsp.gangrace.main.game;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.gangrace.ActionInfo;
/*     */ import mzm.gsp.gangrace.PlayerInfo;
/*     */ import mzm.gsp.gangrace.RunningInfo;
/*     */ 
/*     */ public class RaceObj
/*     */ {
/*     */   private int raceId;
/*     */   private final long roleid;
/*     */   private final int roleGender;
/*     */   private final int roleMenpai;
/*     */   private final int avatarId;
/*     */   private final int frameId;
/*     */   private final String roleName;
/*  18 */   private int curStep = 0;
/*     */   
/*     */   private RaceBase raceBase;
/*  21 */   volatile VoteInfo voteInfo = new VoteInfo();
/*  22 */   ArrayList<ActionInfo> actionInfos = new ArrayList();
/*     */   
/*     */   public RaceObj(RaceBase _raceBase, int _raceId, long _roleId, int _gender, int _menpai, int _avatarId, int _frameId, String _name)
/*     */   {
/*  26 */     this.raceId = _raceId;
/*  27 */     this.raceBase = _raceBase;
/*  28 */     this.roleid = _roleId;
/*  29 */     this.roleGender = _gender;
/*  30 */     this.roleMenpai = _menpai;
/*  31 */     this.avatarId = _avatarId;
/*  32 */     this.frameId = _frameId;
/*  33 */     this.roleName = _name;
/*  34 */     this.curStep = 0;
/*     */   }
/*     */   
/*     */   public int getId() {
/*  38 */     return this.raceId;
/*     */   }
/*     */   
/*     */   public long getRoleId() {
/*  42 */     return this.roleid;
/*     */   }
/*     */   
/*     */   public int getRoleGender() {
/*  46 */     return this.roleGender;
/*     */   }
/*     */   
/*     */   public int getRoleMenpai() {
/*  50 */     return this.roleMenpai;
/*     */   }
/*     */   
/*     */   public int getCurStep() {
/*  54 */     return this.curStep;
/*     */   }
/*     */   
/*     */   public String getRoleName() {
/*  58 */     return this.roleName;
/*     */   }
/*     */   
/*     */   public int onAction(int _round) {
/*  62 */     if (_round >= this.actionInfos.size()) {
/*  63 */       RaceBaseAction action = this.raceBase.getNextAction();
/*  64 */       action.action(this.actionInfos, this.curStep);
/*     */     }
/*  66 */     this.curStep += ((ActionInfo)this.actionInfos.get(_round)).getMoveSpace();
/*     */     
/*  68 */     return this.curStep;
/*     */   }
/*     */   
/*     */   public void cleanAction(int _maxRound) {
/*  72 */     while (this.actionInfos.size() > _maxRound)
/*  73 */       this.actionInfos.remove(this.actionInfos.size() - 1);
/*     */   }
/*     */   
/*     */   public void onVote(long _roleid, int _voteCount) {
/*  77 */     synchronized (this.voteInfo) {
/*  78 */       VoteInfo.access$012(this.voteInfo, _voteCount);
/*  79 */       this.voteInfo.getRoleVotes().put(Long.valueOf(_roleid), Integer.valueOf(_voteCount));
/*     */     }
/*     */   }
/*     */   
/*     */   public PlayerInfo getPlayerInfo() {
/*  84 */     PlayerInfo ret = new PlayerInfo();
/*  85 */     ret.playeridx = getId();
/*  86 */     ret.gender = this.roleGender;
/*  87 */     ret.menpai = this.roleMenpai;
/*  88 */     ret.avatarid = this.avatarId;
/*  89 */     ret.avatarframeid = this.frameId;
/*  90 */     ret.name = this.roleName;
/*  91 */     return ret;
/*     */   }
/*     */   
/*     */   public int getVoteCount() {
/*  95 */     return this.voteInfo.voteCount;
/*     */   }
/*     */   
/*     */   public Map<Long, Integer> getVoteInfo() {
/*  99 */     return this.voteInfo.roleVotes;
/*     */   }
/*     */   
/*     */   public RunningInfo getRunningInfo() {
/* 103 */     RunningInfo ret = new RunningInfo();
/* 104 */     ret.playeridx = getId();
/* 105 */     for (ActionInfo action : this.actionInfos) {
/* 106 */       ActionInfo actionInfo = new ActionInfo(action.getActionCode(), action.getMoveSpace());
/* 107 */       ret.actioninfos.add(actionInfo);
/*     */     }
/* 109 */     return ret;
/*     */   }
/*     */   
/*     */   public static class ActionInfo {
/*     */     private int actionCode;
/*     */     private int moveSpace;
/*     */     
/*     */     public ActionInfo(int _actionCode, int _moveSpace) {
/* 117 */       this.actionCode = _actionCode;
/* 118 */       this.moveSpace = _moveSpace;
/*     */     }
/*     */     
/*     */     public int getActionCode() {
/* 122 */       return this.actionCode;
/*     */     }
/*     */     
/*     */ 
/* 126 */     public int getMoveSpace() { return this.moveSpace; } }
/*     */   
/*     */   protected class VoteInfo { private volatile int voteCount;
/*     */     
/*     */     protected VoteInfo() {}
/*     */     
/* 132 */     private volatile Map<Long, Integer> roleVotes = new java.util.HashMap();
/*     */     
/*     */     public int getSumVote() {
/* 135 */       return this.voteCount;
/*     */     }
/*     */     
/*     */     public Map<Long, Integer> getRoleVotes() {
/* 139 */       return this.roleVotes;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gangrace\main\game\RaceObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */