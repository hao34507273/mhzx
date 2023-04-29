/*     */ package mzm.gsp.bigboss;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynBigbossData
/*     */   extends __SSynBigbossData__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12598017;
/*     */   public int damagepoint;
/*     */   public int ocp;
/*     */   public int rank;
/*     */   public int totalbuycount;
/*     */   public int challengecount;
/*     */   public int monsterid;
/*     */   public int nextmonsterid;
/*     */   public long starttime;
/*     */   public long endtime;
/*     */   public long nextstarttime;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12598017;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynBigbossData() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynBigbossData(int _damagepoint_, int _ocp_, int _rank_, int _totalbuycount_, int _challengecount_, int _monsterid_, int _nextmonsterid_, long _starttime_, long _endtime_, long _nextstarttime_)
/*     */   {
/*  45 */     this.damagepoint = _damagepoint_;
/*  46 */     this.ocp = _ocp_;
/*  47 */     this.rank = _rank_;
/*  48 */     this.totalbuycount = _totalbuycount_;
/*  49 */     this.challengecount = _challengecount_;
/*  50 */     this.monsterid = _monsterid_;
/*  51 */     this.nextmonsterid = _nextmonsterid_;
/*  52 */     this.starttime = _starttime_;
/*  53 */     this.endtime = _endtime_;
/*  54 */     this.nextstarttime = _nextstarttime_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  58 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  62 */     _os_.marshal(this.damagepoint);
/*  63 */     _os_.marshal(this.ocp);
/*  64 */     _os_.marshal(this.rank);
/*  65 */     _os_.marshal(this.totalbuycount);
/*  66 */     _os_.marshal(this.challengecount);
/*  67 */     _os_.marshal(this.monsterid);
/*  68 */     _os_.marshal(this.nextmonsterid);
/*  69 */     _os_.marshal(this.starttime);
/*  70 */     _os_.marshal(this.endtime);
/*  71 */     _os_.marshal(this.nextstarttime);
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  76 */     this.damagepoint = _os_.unmarshal_int();
/*  77 */     this.ocp = _os_.unmarshal_int();
/*  78 */     this.rank = _os_.unmarshal_int();
/*  79 */     this.totalbuycount = _os_.unmarshal_int();
/*  80 */     this.challengecount = _os_.unmarshal_int();
/*  81 */     this.monsterid = _os_.unmarshal_int();
/*  82 */     this.nextmonsterid = _os_.unmarshal_int();
/*  83 */     this.starttime = _os_.unmarshal_long();
/*  84 */     this.endtime = _os_.unmarshal_long();
/*  85 */     this.nextstarttime = _os_.unmarshal_long();
/*  86 */     if (!_validator_()) {
/*  87 */       throw new VerifyError("validator failed");
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  93 */     if (_o1_ == this) return true;
/*  94 */     if ((_o1_ instanceof SSynBigbossData)) {
/*  95 */       SSynBigbossData _o_ = (SSynBigbossData)_o1_;
/*  96 */       if (this.damagepoint != _o_.damagepoint) return false;
/*  97 */       if (this.ocp != _o_.ocp) return false;
/*  98 */       if (this.rank != _o_.rank) return false;
/*  99 */       if (this.totalbuycount != _o_.totalbuycount) return false;
/* 100 */       if (this.challengecount != _o_.challengecount) return false;
/* 101 */       if (this.monsterid != _o_.monsterid) return false;
/* 102 */       if (this.nextmonsterid != _o_.nextmonsterid) return false;
/* 103 */       if (this.starttime != _o_.starttime) return false;
/* 104 */       if (this.endtime != _o_.endtime) return false;
/* 105 */       if (this.nextstarttime != _o_.nextstarttime) return false;
/* 106 */       return true;
/*     */     }
/* 108 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 112 */     int _h_ = 0;
/* 113 */     _h_ += this.damagepoint;
/* 114 */     _h_ += this.ocp;
/* 115 */     _h_ += this.rank;
/* 116 */     _h_ += this.totalbuycount;
/* 117 */     _h_ += this.challengecount;
/* 118 */     _h_ += this.monsterid;
/* 119 */     _h_ += this.nextmonsterid;
/* 120 */     _h_ += (int)this.starttime;
/* 121 */     _h_ += (int)this.endtime;
/* 122 */     _h_ += (int)this.nextstarttime;
/* 123 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 127 */     StringBuilder _sb_ = new StringBuilder();
/* 128 */     _sb_.append("(");
/* 129 */     _sb_.append(this.damagepoint).append(",");
/* 130 */     _sb_.append(this.ocp).append(",");
/* 131 */     _sb_.append(this.rank).append(",");
/* 132 */     _sb_.append(this.totalbuycount).append(",");
/* 133 */     _sb_.append(this.challengecount).append(",");
/* 134 */     _sb_.append(this.monsterid).append(",");
/* 135 */     _sb_.append(this.nextmonsterid).append(",");
/* 136 */     _sb_.append(this.starttime).append(",");
/* 137 */     _sb_.append(this.endtime).append(",");
/* 138 */     _sb_.append(this.nextstarttime).append(",");
/* 139 */     _sb_.append(")");
/* 140 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSynBigbossData _o_) {
/* 144 */     if (_o_ == this) return 0;
/* 145 */     int _c_ = 0;
/* 146 */     _c_ = this.damagepoint - _o_.damagepoint;
/* 147 */     if (0 != _c_) return _c_;
/* 148 */     _c_ = this.ocp - _o_.ocp;
/* 149 */     if (0 != _c_) return _c_;
/* 150 */     _c_ = this.rank - _o_.rank;
/* 151 */     if (0 != _c_) return _c_;
/* 152 */     _c_ = this.totalbuycount - _o_.totalbuycount;
/* 153 */     if (0 != _c_) return _c_;
/* 154 */     _c_ = this.challengecount - _o_.challengecount;
/* 155 */     if (0 != _c_) return _c_;
/* 156 */     _c_ = this.monsterid - _o_.monsterid;
/* 157 */     if (0 != _c_) return _c_;
/* 158 */     _c_ = this.nextmonsterid - _o_.nextmonsterid;
/* 159 */     if (0 != _c_) return _c_;
/* 160 */     _c_ = Long.signum(this.starttime - _o_.starttime);
/* 161 */     if (0 != _c_) return _c_;
/* 162 */     _c_ = Long.signum(this.endtime - _o_.endtime);
/* 163 */     if (0 != _c_) return _c_;
/* 164 */     _c_ = Long.signum(this.nextstarttime - _o_.nextstarttime);
/* 165 */     if (0 != _c_) return _c_;
/* 166 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\SSynBigbossData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */