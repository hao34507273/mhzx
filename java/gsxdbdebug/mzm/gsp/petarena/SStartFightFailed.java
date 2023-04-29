/*     */ package mzm.gsp.petarena;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SStartFightFailed
/*     */   extends __SStartFightFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12628238;
/*     */   public static final int ERROR_LEVEL = -1;
/*     */   public static final int ERROR_ACTIVITY_JOIN = -2;
/*     */   public static final int ERROR_CHALLENGE_NOT_ENOUGH = -3;
/*     */   public static final int ERROR_ATTACK_TEAM_EMPTY = -4;
/*     */   public static final int ERROR_DEFEND_TEAM_EMPTY = -5;
/*     */   public static final int ERROR_IN_TEAM = -6;
/*     */   public static final int ERROR_RANK_CHANGED = -7;
/*     */   public static final int ERROR_OPPONENT_CHANGED = -8;
/*     */   public long target_roleid;
/*     */   public int rank;
/*     */   public int teamid;
/*     */   public int retcode;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12628238;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SStartFightFailed() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SStartFightFailed(long _target_roleid_, int _rank_, int _teamid_, int _retcode_)
/*     */   {
/*  48 */     this.target_roleid = _target_roleid_;
/*  49 */     this.rank = _rank_;
/*  50 */     this.teamid = _teamid_;
/*  51 */     this.retcode = _retcode_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.target_roleid);
/*  60 */     _os_.marshal(this.rank);
/*  61 */     _os_.marshal(this.teamid);
/*  62 */     _os_.marshal(this.retcode);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.target_roleid = _os_.unmarshal_long();
/*  68 */     this.rank = _os_.unmarshal_int();
/*  69 */     this.teamid = _os_.unmarshal_int();
/*  70 */     this.retcode = _os_.unmarshal_int();
/*  71 */     if (!_validator_()) {
/*  72 */       throw new VerifyError("validator failed");
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  78 */     if (_o1_ == this) return true;
/*  79 */     if ((_o1_ instanceof SStartFightFailed)) {
/*  80 */       SStartFightFailed _o_ = (SStartFightFailed)_o1_;
/*  81 */       if (this.target_roleid != _o_.target_roleid) return false;
/*  82 */       if (this.rank != _o_.rank) return false;
/*  83 */       if (this.teamid != _o_.teamid) return false;
/*  84 */       if (this.retcode != _o_.retcode) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += (int)this.target_roleid;
/*  93 */     _h_ += this.rank;
/*  94 */     _h_ += this.teamid;
/*  95 */     _h_ += this.retcode;
/*  96 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 100 */     StringBuilder _sb_ = new StringBuilder();
/* 101 */     _sb_.append("(");
/* 102 */     _sb_.append(this.target_roleid).append(",");
/* 103 */     _sb_.append(this.rank).append(",");
/* 104 */     _sb_.append(this.teamid).append(",");
/* 105 */     _sb_.append(this.retcode).append(",");
/* 106 */     _sb_.append(")");
/* 107 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SStartFightFailed _o_) {
/* 111 */     if (_o_ == this) return 0;
/* 112 */     int _c_ = 0;
/* 113 */     _c_ = Long.signum(this.target_roleid - _o_.target_roleid);
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.rank - _o_.rank;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.teamid - _o_.teamid;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.retcode - _o_.retcode;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\SStartFightFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */