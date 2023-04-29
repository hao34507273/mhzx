/*     */ package mzm.gsp.lonngboatrace;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSyncRaceInfo
/*     */   extends __SSyncRaceInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12619278;
/*     */   public int raceid;
/*     */   public long matchbegintimestamp;
/*     */   public HashMap<Long, TeamStat> teamid2teamstat;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12619278;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncRaceInfo()
/*     */   {
/*  35 */     this.teamid2teamstat = new HashMap();
/*     */   }
/*     */   
/*     */   public SSyncRaceInfo(int _raceid_, long _matchbegintimestamp_, HashMap<Long, TeamStat> _teamid2teamstat_) {
/*  39 */     this.raceid = _raceid_;
/*  40 */     this.matchbegintimestamp = _matchbegintimestamp_;
/*  41 */     this.teamid2teamstat = _teamid2teamstat_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (Map.Entry<Long, TeamStat> _e_ : this.teamid2teamstat.entrySet()) {
/*  46 */       if (!((TeamStat)_e_.getValue())._validator_()) return false;
/*     */     }
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.raceid);
/*  53 */     _os_.marshal(this.matchbegintimestamp);
/*  54 */     _os_.compact_uint32(this.teamid2teamstat.size());
/*  55 */     for (Map.Entry<Long, TeamStat> _e_ : this.teamid2teamstat.entrySet()) {
/*  56 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  57 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.raceid = _os_.unmarshal_int();
/*  64 */     this.matchbegintimestamp = _os_.unmarshal_long();
/*  65 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  67 */       long _k_ = _os_.unmarshal_long();
/*  68 */       TeamStat _v_ = new TeamStat();
/*  69 */       _v_.unmarshal(_os_);
/*  70 */       this.teamid2teamstat.put(Long.valueOf(_k_), _v_);
/*     */     }
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SSyncRaceInfo)) {
/*  81 */       SSyncRaceInfo _o_ = (SSyncRaceInfo)_o1_;
/*  82 */       if (this.raceid != _o_.raceid) return false;
/*  83 */       if (this.matchbegintimestamp != _o_.matchbegintimestamp) return false;
/*  84 */       if (!this.teamid2teamstat.equals(_o_.teamid2teamstat)) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += this.raceid;
/*  93 */     _h_ += (int)this.matchbegintimestamp;
/*  94 */     _h_ += this.teamid2teamstat.hashCode();
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.raceid).append(",");
/* 102 */     _sb_.append(this.matchbegintimestamp).append(",");
/* 103 */     _sb_.append(this.teamid2teamstat).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\SSyncRaceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */