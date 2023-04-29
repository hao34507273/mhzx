/*     */ package mzm.gsp.jingji;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SSynJingjiData
/*     */   extends __SSynJingjiData__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12595716;
/*     */   public int winpoint;
/*     */   public int phase;
/*     */   public int totalbuycount;
/*     */   public int challengecount;
/*     */   public int dayjifen;
/*     */   public long totaljifen;
/*     */   public int rank;
/*     */   public int isfirstvictoty;
/*     */   public int isfivefight;
/*     */   public int lastseasonphase;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12595716;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynJingjiData() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynJingjiData(int _winpoint_, int _phase_, int _totalbuycount_, int _challengecount_, int _dayjifen_, long _totaljifen_, int _rank_, int _isfirstvictoty_, int _isfivefight_, int _lastseasonphase_)
/*     */   {
/*  43 */     this.winpoint = _winpoint_;
/*  44 */     this.phase = _phase_;
/*  45 */     this.totalbuycount = _totalbuycount_;
/*  46 */     this.challengecount = _challengecount_;
/*  47 */     this.dayjifen = _dayjifen_;
/*  48 */     this.totaljifen = _totaljifen_;
/*  49 */     this.rank = _rank_;
/*  50 */     this.isfirstvictoty = _isfirstvictoty_;
/*  51 */     this.isfivefight = _isfivefight_;
/*  52 */     this.lastseasonphase = _lastseasonphase_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  56 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  60 */     _os_.marshal(this.winpoint);
/*  61 */     _os_.marshal(this.phase);
/*  62 */     _os_.marshal(this.totalbuycount);
/*  63 */     _os_.marshal(this.challengecount);
/*  64 */     _os_.marshal(this.dayjifen);
/*  65 */     _os_.marshal(this.totaljifen);
/*  66 */     _os_.marshal(this.rank);
/*  67 */     _os_.marshal(this.isfirstvictoty);
/*  68 */     _os_.marshal(this.isfivefight);
/*  69 */     _os_.marshal(this.lastseasonphase);
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  74 */     this.winpoint = _os_.unmarshal_int();
/*  75 */     this.phase = _os_.unmarshal_int();
/*  76 */     this.totalbuycount = _os_.unmarshal_int();
/*  77 */     this.challengecount = _os_.unmarshal_int();
/*  78 */     this.dayjifen = _os_.unmarshal_int();
/*  79 */     this.totaljifen = _os_.unmarshal_long();
/*  80 */     this.rank = _os_.unmarshal_int();
/*  81 */     this.isfirstvictoty = _os_.unmarshal_int();
/*  82 */     this.isfivefight = _os_.unmarshal_int();
/*  83 */     this.lastseasonphase = _os_.unmarshal_int();
/*  84 */     if (!_validator_()) {
/*  85 */       throw new VerifyError("validator failed");
/*     */     }
/*  87 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  91 */     if (_o1_ == this) return true;
/*  92 */     if ((_o1_ instanceof SSynJingjiData)) {
/*  93 */       SSynJingjiData _o_ = (SSynJingjiData)_o1_;
/*  94 */       if (this.winpoint != _o_.winpoint) return false;
/*  95 */       if (this.phase != _o_.phase) return false;
/*  96 */       if (this.totalbuycount != _o_.totalbuycount) return false;
/*  97 */       if (this.challengecount != _o_.challengecount) return false;
/*  98 */       if (this.dayjifen != _o_.dayjifen) return false;
/*  99 */       if (this.totaljifen != _o_.totaljifen) return false;
/* 100 */       if (this.rank != _o_.rank) return false;
/* 101 */       if (this.isfirstvictoty != _o_.isfirstvictoty) return false;
/* 102 */       if (this.isfivefight != _o_.isfivefight) return false;
/* 103 */       if (this.lastseasonphase != _o_.lastseasonphase) return false;
/* 104 */       return true;
/*     */     }
/* 106 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 110 */     int _h_ = 0;
/* 111 */     _h_ += this.winpoint;
/* 112 */     _h_ += this.phase;
/* 113 */     _h_ += this.totalbuycount;
/* 114 */     _h_ += this.challengecount;
/* 115 */     _h_ += this.dayjifen;
/* 116 */     _h_ += (int)this.totaljifen;
/* 117 */     _h_ += this.rank;
/* 118 */     _h_ += this.isfirstvictoty;
/* 119 */     _h_ += this.isfivefight;
/* 120 */     _h_ += this.lastseasonphase;
/* 121 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 125 */     StringBuilder _sb_ = new StringBuilder();
/* 126 */     _sb_.append("(");
/* 127 */     _sb_.append(this.winpoint).append(",");
/* 128 */     _sb_.append(this.phase).append(",");
/* 129 */     _sb_.append(this.totalbuycount).append(",");
/* 130 */     _sb_.append(this.challengecount).append(",");
/* 131 */     _sb_.append(this.dayjifen).append(",");
/* 132 */     _sb_.append(this.totaljifen).append(",");
/* 133 */     _sb_.append(this.rank).append(",");
/* 134 */     _sb_.append(this.isfirstvictoty).append(",");
/* 135 */     _sb_.append(this.isfivefight).append(",");
/* 136 */     _sb_.append(this.lastseasonphase).append(",");
/* 137 */     _sb_.append(")");
/* 138 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSynJingjiData _o_) {
/* 142 */     if (_o_ == this) return 0;
/* 143 */     int _c_ = 0;
/* 144 */     _c_ = this.winpoint - _o_.winpoint;
/* 145 */     if (0 != _c_) return _c_;
/* 146 */     _c_ = this.phase - _o_.phase;
/* 147 */     if (0 != _c_) return _c_;
/* 148 */     _c_ = this.totalbuycount - _o_.totalbuycount;
/* 149 */     if (0 != _c_) return _c_;
/* 150 */     _c_ = this.challengecount - _o_.challengecount;
/* 151 */     if (0 != _c_) return _c_;
/* 152 */     _c_ = this.dayjifen - _o_.dayjifen;
/* 153 */     if (0 != _c_) return _c_;
/* 154 */     _c_ = Long.signum(this.totaljifen - _o_.totaljifen);
/* 155 */     if (0 != _c_) return _c_;
/* 156 */     _c_ = this.rank - _o_.rank;
/* 157 */     if (0 != _c_) return _c_;
/* 158 */     _c_ = this.isfirstvictoty - _o_.isfirstvictoty;
/* 159 */     if (0 != _c_) return _c_;
/* 160 */     _c_ = this.isfivefight - _o_.isfivefight;
/* 161 */     if (0 != _c_) return _c_;
/* 162 */     _c_ = this.lastseasonphase - _o_.lastseasonphase;
/* 163 */     if (0 != _c_) return _c_;
/* 164 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\SSynJingjiData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */