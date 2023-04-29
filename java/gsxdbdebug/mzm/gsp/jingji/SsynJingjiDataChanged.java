/*     */ package mzm.gsp.jingji;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SsynJingjiDataChanged
/*     */   extends __SsynJingjiDataChanged__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12595722;
/*     */   public int iswin;
/*     */   public int winpoint;
/*     */   public int winpointdelta;
/*     */   public int phase;
/*     */   public int challengecount;
/*     */   public int dayjifen;
/*     */   public long totaljifen;
/*     */   public int rank;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12595722;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SsynJingjiDataChanged() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SsynJingjiDataChanged(int _iswin_, int _winpoint_, int _winpointdelta_, int _phase_, int _challengecount_, int _dayjifen_, long _totaljifen_, int _rank_)
/*     */   {
/*  43 */     this.iswin = _iswin_;
/*  44 */     this.winpoint = _winpoint_;
/*  45 */     this.winpointdelta = _winpointdelta_;
/*  46 */     this.phase = _phase_;
/*  47 */     this.challengecount = _challengecount_;
/*  48 */     this.dayjifen = _dayjifen_;
/*  49 */     this.totaljifen = _totaljifen_;
/*  50 */     this.rank = _rank_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.iswin);
/*  59 */     _os_.marshal(this.winpoint);
/*  60 */     _os_.marshal(this.winpointdelta);
/*  61 */     _os_.marshal(this.phase);
/*  62 */     _os_.marshal(this.challengecount);
/*  63 */     _os_.marshal(this.dayjifen);
/*  64 */     _os_.marshal(this.totaljifen);
/*  65 */     _os_.marshal(this.rank);
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  70 */     this.iswin = _os_.unmarshal_int();
/*  71 */     this.winpoint = _os_.unmarshal_int();
/*  72 */     this.winpointdelta = _os_.unmarshal_int();
/*  73 */     this.phase = _os_.unmarshal_int();
/*  74 */     this.challengecount = _os_.unmarshal_int();
/*  75 */     this.dayjifen = _os_.unmarshal_int();
/*  76 */     this.totaljifen = _os_.unmarshal_long();
/*  77 */     this.rank = _os_.unmarshal_int();
/*  78 */     if (!_validator_()) {
/*  79 */       throw new VerifyError("validator failed");
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  85 */     if (_o1_ == this) return true;
/*  86 */     if ((_o1_ instanceof SsynJingjiDataChanged)) {
/*  87 */       SsynJingjiDataChanged _o_ = (SsynJingjiDataChanged)_o1_;
/*  88 */       if (this.iswin != _o_.iswin) return false;
/*  89 */       if (this.winpoint != _o_.winpoint) return false;
/*  90 */       if (this.winpointdelta != _o_.winpointdelta) return false;
/*  91 */       if (this.phase != _o_.phase) return false;
/*  92 */       if (this.challengecount != _o_.challengecount) return false;
/*  93 */       if (this.dayjifen != _o_.dayjifen) return false;
/*  94 */       if (this.totaljifen != _o_.totaljifen) return false;
/*  95 */       if (this.rank != _o_.rank) return false;
/*  96 */       return true;
/*     */     }
/*  98 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 102 */     int _h_ = 0;
/* 103 */     _h_ += this.iswin;
/* 104 */     _h_ += this.winpoint;
/* 105 */     _h_ += this.winpointdelta;
/* 106 */     _h_ += this.phase;
/* 107 */     _h_ += this.challengecount;
/* 108 */     _h_ += this.dayjifen;
/* 109 */     _h_ += (int)this.totaljifen;
/* 110 */     _h_ += this.rank;
/* 111 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 115 */     StringBuilder _sb_ = new StringBuilder();
/* 116 */     _sb_.append("(");
/* 117 */     _sb_.append(this.iswin).append(",");
/* 118 */     _sb_.append(this.winpoint).append(",");
/* 119 */     _sb_.append(this.winpointdelta).append(",");
/* 120 */     _sb_.append(this.phase).append(",");
/* 121 */     _sb_.append(this.challengecount).append(",");
/* 122 */     _sb_.append(this.dayjifen).append(",");
/* 123 */     _sb_.append(this.totaljifen).append(",");
/* 124 */     _sb_.append(this.rank).append(",");
/* 125 */     _sb_.append(")");
/* 126 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SsynJingjiDataChanged _o_) {
/* 130 */     if (_o_ == this) return 0;
/* 131 */     int _c_ = 0;
/* 132 */     _c_ = this.iswin - _o_.iswin;
/* 133 */     if (0 != _c_) return _c_;
/* 134 */     _c_ = this.winpoint - _o_.winpoint;
/* 135 */     if (0 != _c_) return _c_;
/* 136 */     _c_ = this.winpointdelta - _o_.winpointdelta;
/* 137 */     if (0 != _c_) return _c_;
/* 138 */     _c_ = this.phase - _o_.phase;
/* 139 */     if (0 != _c_) return _c_;
/* 140 */     _c_ = this.challengecount - _o_.challengecount;
/* 141 */     if (0 != _c_) return _c_;
/* 142 */     _c_ = this.dayjifen - _o_.dayjifen;
/* 143 */     if (0 != _c_) return _c_;
/* 144 */     _c_ = Long.signum(this.totaljifen - _o_.totaljifen);
/* 145 */     if (0 != _c_) return _c_;
/* 146 */     _c_ = this.rank - _o_.rank;
/* 147 */     if (0 != _c_) return _c_;
/* 148 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\SsynJingjiDataChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */