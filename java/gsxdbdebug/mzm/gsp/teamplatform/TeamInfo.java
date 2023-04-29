/*     */ package mzm.gsp.teamplatform;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class TeamInfo
/*     */   implements Marshal
/*     */ {
/*     */   public long teamid;
/*     */   public long leaderid;
/*     */   public String teamleadername;
/*     */   public int teamleaderoccupation;
/*     */   public int teamleadersex;
/*     */   public int teamleaderlevel;
/*     */   public int avatarid;
/*     */   public int avatarframeid;
/*     */   public int chatbubblecfgid;
/*     */   public LevelCfg level;
/*     */   public MatchCfg activitycfg;
/*     */   public int num;
/*     */   
/*     */   public TeamInfo()
/*     */   {
/*  25 */     this.teamleadername = "";
/*  26 */     this.level = new LevelCfg();
/*  27 */     this.activitycfg = new MatchCfg();
/*     */   }
/*     */   
/*     */   public TeamInfo(long _teamid_, long _leaderid_, String _teamleadername_, int _teamleaderoccupation_, int _teamleadersex_, int _teamleaderlevel_, int _avatarid_, int _avatarframeid_, int _chatbubblecfgid_, LevelCfg _level_, MatchCfg _activitycfg_, int _num_) {
/*  31 */     this.teamid = _teamid_;
/*  32 */     this.leaderid = _leaderid_;
/*  33 */     this.teamleadername = _teamleadername_;
/*  34 */     this.teamleaderoccupation = _teamleaderoccupation_;
/*  35 */     this.teamleadersex = _teamleadersex_;
/*  36 */     this.teamleaderlevel = _teamleaderlevel_;
/*  37 */     this.avatarid = _avatarid_;
/*  38 */     this.avatarframeid = _avatarframeid_;
/*  39 */     this.chatbubblecfgid = _chatbubblecfgid_;
/*  40 */     this.level = _level_;
/*  41 */     this.activitycfg = _activitycfg_;
/*  42 */     this.num = _num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     if (!this.level._validator_()) return false;
/*  47 */     if (!this.activitycfg._validator_()) return false;
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.teamid);
/*  53 */     _os_.marshal(this.leaderid);
/*  54 */     _os_.marshal(this.teamleadername, "UTF-16LE");
/*  55 */     _os_.marshal(this.teamleaderoccupation);
/*  56 */     _os_.marshal(this.teamleadersex);
/*  57 */     _os_.marshal(this.teamleaderlevel);
/*  58 */     _os_.marshal(this.avatarid);
/*  59 */     _os_.marshal(this.avatarframeid);
/*  60 */     _os_.marshal(this.chatbubblecfgid);
/*  61 */     _os_.marshal(this.level);
/*  62 */     _os_.marshal(this.activitycfg);
/*  63 */     _os_.marshal(this.num);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.teamid = _os_.unmarshal_long();
/*  69 */     this.leaderid = _os_.unmarshal_long();
/*  70 */     this.teamleadername = _os_.unmarshal_String("UTF-16LE");
/*  71 */     this.teamleaderoccupation = _os_.unmarshal_int();
/*  72 */     this.teamleadersex = _os_.unmarshal_int();
/*  73 */     this.teamleaderlevel = _os_.unmarshal_int();
/*  74 */     this.avatarid = _os_.unmarshal_int();
/*  75 */     this.avatarframeid = _os_.unmarshal_int();
/*  76 */     this.chatbubblecfgid = _os_.unmarshal_int();
/*  77 */     this.level.unmarshal(_os_);
/*  78 */     this.activitycfg.unmarshal(_os_);
/*  79 */     this.num = _os_.unmarshal_int();
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  84 */     if (_o1_ == this) return true;
/*  85 */     if ((_o1_ instanceof TeamInfo)) {
/*  86 */       TeamInfo _o_ = (TeamInfo)_o1_;
/*  87 */       if (this.teamid != _o_.teamid) return false;
/*  88 */       if (this.leaderid != _o_.leaderid) return false;
/*  89 */       if (!this.teamleadername.equals(_o_.teamleadername)) return false;
/*  90 */       if (this.teamleaderoccupation != _o_.teamleaderoccupation) return false;
/*  91 */       if (this.teamleadersex != _o_.teamleadersex) return false;
/*  92 */       if (this.teamleaderlevel != _o_.teamleaderlevel) return false;
/*  93 */       if (this.avatarid != _o_.avatarid) return false;
/*  94 */       if (this.avatarframeid != _o_.avatarframeid) return false;
/*  95 */       if (this.chatbubblecfgid != _o_.chatbubblecfgid) return false;
/*  96 */       if (!this.level.equals(_o_.level)) return false;
/*  97 */       if (!this.activitycfg.equals(_o_.activitycfg)) return false;
/*  98 */       if (this.num != _o_.num) return false;
/*  99 */       return true;
/*     */     }
/* 101 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 105 */     int _h_ = 0;
/* 106 */     _h_ += (int)this.teamid;
/* 107 */     _h_ += (int)this.leaderid;
/* 108 */     _h_ += this.teamleadername.hashCode();
/* 109 */     _h_ += this.teamleaderoccupation;
/* 110 */     _h_ += this.teamleadersex;
/* 111 */     _h_ += this.teamleaderlevel;
/* 112 */     _h_ += this.avatarid;
/* 113 */     _h_ += this.avatarframeid;
/* 114 */     _h_ += this.chatbubblecfgid;
/* 115 */     _h_ += this.level.hashCode();
/* 116 */     _h_ += this.activitycfg.hashCode();
/* 117 */     _h_ += this.num;
/* 118 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 122 */     StringBuilder _sb_ = new StringBuilder();
/* 123 */     _sb_.append("(");
/* 124 */     _sb_.append(this.teamid).append(",");
/* 125 */     _sb_.append(this.leaderid).append(",");
/* 126 */     _sb_.append("T").append(this.teamleadername.length()).append(",");
/* 127 */     _sb_.append(this.teamleaderoccupation).append(",");
/* 128 */     _sb_.append(this.teamleadersex).append(",");
/* 129 */     _sb_.append(this.teamleaderlevel).append(",");
/* 130 */     _sb_.append(this.avatarid).append(",");
/* 131 */     _sb_.append(this.avatarframeid).append(",");
/* 132 */     _sb_.append(this.chatbubblecfgid).append(",");
/* 133 */     _sb_.append(this.level).append(",");
/* 134 */     _sb_.append(this.activitycfg).append(",");
/* 135 */     _sb_.append(this.num).append(",");
/* 136 */     _sb_.append(")");
/* 137 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\TeamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */