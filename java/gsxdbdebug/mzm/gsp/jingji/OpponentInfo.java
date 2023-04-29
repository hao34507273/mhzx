/*     */ package mzm.gsp.jingji;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class OpponentInfo
/*     */   implements Marshal, Comparable<OpponentInfo>
/*     */ {
/*     */   public static final int TYPE_ROLE = 1;
/*     */   public static final int TYPE_ROBOT = 2;
/*     */   public static final int TYPE_TOP_ROLE = 3;
/*     */   public int opponenttype;
/*     */   public long roleid;
/*     */   public int sex;
/*     */   public int level;
/*     */   public int phase;
/*     */   public int occupation;
/*     */   public int rank;
/*     */   
/*     */   public OpponentInfo() {}
/*     */   
/*     */   public OpponentInfo(int _opponenttype_, long _roleid_, int _sex_, int _level_, int _phase_, int _occupation_, int _rank_)
/*     */   {
/*  25 */     this.opponenttype = _opponenttype_;
/*  26 */     this.roleid = _roleid_;
/*  27 */     this.sex = _sex_;
/*  28 */     this.level = _level_;
/*  29 */     this.phase = _phase_;
/*  30 */     this.occupation = _occupation_;
/*  31 */     this.rank = _rank_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  35 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  39 */     _os_.marshal(this.opponenttype);
/*  40 */     _os_.marshal(this.roleid);
/*  41 */     _os_.marshal(this.sex);
/*  42 */     _os_.marshal(this.level);
/*  43 */     _os_.marshal(this.phase);
/*  44 */     _os_.marshal(this.occupation);
/*  45 */     _os_.marshal(this.rank);
/*  46 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  50 */     this.opponenttype = _os_.unmarshal_int();
/*  51 */     this.roleid = _os_.unmarshal_long();
/*  52 */     this.sex = _os_.unmarshal_int();
/*  53 */     this.level = _os_.unmarshal_int();
/*  54 */     this.phase = _os_.unmarshal_int();
/*  55 */     this.occupation = _os_.unmarshal_int();
/*  56 */     this.rank = _os_.unmarshal_int();
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  61 */     if (_o1_ == this) return true;
/*  62 */     if ((_o1_ instanceof OpponentInfo)) {
/*  63 */       OpponentInfo _o_ = (OpponentInfo)_o1_;
/*  64 */       if (this.opponenttype != _o_.opponenttype) return false;
/*  65 */       if (this.roleid != _o_.roleid) return false;
/*  66 */       if (this.sex != _o_.sex) return false;
/*  67 */       if (this.level != _o_.level) return false;
/*  68 */       if (this.phase != _o_.phase) return false;
/*  69 */       if (this.occupation != _o_.occupation) return false;
/*  70 */       if (this.rank != _o_.rank) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.opponenttype;
/*  79 */     _h_ += (int)this.roleid;
/*  80 */     _h_ += this.sex;
/*  81 */     _h_ += this.level;
/*  82 */     _h_ += this.phase;
/*  83 */     _h_ += this.occupation;
/*  84 */     _h_ += this.rank;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.opponenttype).append(",");
/*  92 */     _sb_.append(this.roleid).append(",");
/*  93 */     _sb_.append(this.sex).append(",");
/*  94 */     _sb_.append(this.level).append(",");
/*  95 */     _sb_.append(this.phase).append(",");
/*  96 */     _sb_.append(this.occupation).append(",");
/*  97 */     _sb_.append(this.rank).append(",");
/*  98 */     _sb_.append(")");
/*  99 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(OpponentInfo _o_) {
/* 103 */     if (_o_ == this) return 0;
/* 104 */     int _c_ = 0;
/* 105 */     _c_ = this.opponenttype - _o_.opponenttype;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     _c_ = this.sex - _o_.sex;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = this.level - _o_.level;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.phase - _o_.phase;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.occupation - _o_.occupation;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.rank - _o_.rank;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\OpponentInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */