/*     */ package mzm.gsp.bigboss;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynBigbossDataChanged
/*     */   extends __SSynBigbossDataChanged__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12598018;
/*     */   public int ocp;
/*     */   public int damagepoint;
/*     */   public int delta;
/*     */   public int rank;
/*     */   public int challengecount;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12598018;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynBigbossDataChanged() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynBigbossDataChanged(int _ocp_, int _damagepoint_, int _delta_, int _rank_, int _challengecount_)
/*     */   {
/*  40 */     this.ocp = _ocp_;
/*  41 */     this.damagepoint = _damagepoint_;
/*  42 */     this.delta = _delta_;
/*  43 */     this.rank = _rank_;
/*  44 */     this.challengecount = _challengecount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.ocp);
/*  53 */     _os_.marshal(this.damagepoint);
/*  54 */     _os_.marshal(this.delta);
/*  55 */     _os_.marshal(this.rank);
/*  56 */     _os_.marshal(this.challengecount);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.ocp = _os_.unmarshal_int();
/*  62 */     this.damagepoint = _os_.unmarshal_int();
/*  63 */     this.delta = _os_.unmarshal_int();
/*  64 */     this.rank = _os_.unmarshal_int();
/*  65 */     this.challengecount = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SSynBigbossDataChanged)) {
/*  75 */       SSynBigbossDataChanged _o_ = (SSynBigbossDataChanged)_o1_;
/*  76 */       if (this.ocp != _o_.ocp) return false;
/*  77 */       if (this.damagepoint != _o_.damagepoint) return false;
/*  78 */       if (this.delta != _o_.delta) return false;
/*  79 */       if (this.rank != _o_.rank) return false;
/*  80 */       if (this.challengecount != _o_.challengecount) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.ocp;
/*  89 */     _h_ += this.damagepoint;
/*  90 */     _h_ += this.delta;
/*  91 */     _h_ += this.rank;
/*  92 */     _h_ += this.challengecount;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.ocp).append(",");
/* 100 */     _sb_.append(this.damagepoint).append(",");
/* 101 */     _sb_.append(this.delta).append(",");
/* 102 */     _sb_.append(this.rank).append(",");
/* 103 */     _sb_.append(this.challengecount).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSynBigbossDataChanged _o_) {
/* 109 */     if (_o_ == this) return 0;
/* 110 */     int _c_ = 0;
/* 111 */     _c_ = this.ocp - _o_.ocp;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.damagepoint - _o_.damagepoint;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     _c_ = this.delta - _o_.delta;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.rank - _o_.rank;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.challengecount - _o_.challengecount;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\SSynBigbossDataChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */