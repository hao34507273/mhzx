/*     */ package mzm.gsp.teamplatform;
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
/*     */ public class SSynLeaderMatchInfo
/*     */   extends __SSynLeaderMatchInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12593678;
/*     */   public static final int SYN__JOIN_TEAM = 1;
/*     */   public static final int SYN__BEGIN_MATCH = 2;
/*     */   public static final int SYN__TEAMER_LOGIN = 3;
/*     */   public MatchCfg activityinfo;
/*     */   public LevelCfg levelrange;
/*     */   public int syntype;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12593678;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynLeaderMatchInfo()
/*     */   {
/*  39 */     this.activityinfo = new MatchCfg();
/*  40 */     this.levelrange = new LevelCfg();
/*     */   }
/*     */   
/*     */   public SSynLeaderMatchInfo(MatchCfg _activityinfo_, LevelCfg _levelrange_, int _syntype_) {
/*  44 */     this.activityinfo = _activityinfo_;
/*  45 */     this.levelrange = _levelrange_;
/*  46 */     this.syntype = _syntype_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     if (!this.activityinfo._validator_()) return false;
/*  51 */     if (!this.levelrange._validator_()) return false;
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.activityinfo);
/*  57 */     _os_.marshal(this.levelrange);
/*  58 */     _os_.marshal(this.syntype);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.activityinfo.unmarshal(_os_);
/*  64 */     this.levelrange.unmarshal(_os_);
/*  65 */     this.syntype = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SSynLeaderMatchInfo)) {
/*  75 */       SSynLeaderMatchInfo _o_ = (SSynLeaderMatchInfo)_o1_;
/*  76 */       if (!this.activityinfo.equals(_o_.activityinfo)) return false;
/*  77 */       if (!this.levelrange.equals(_o_.levelrange)) return false;
/*  78 */       if (this.syntype != _o_.syntype) return false;
/*  79 */       return true;
/*     */     }
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  85 */     int _h_ = 0;
/*  86 */     _h_ += this.activityinfo.hashCode();
/*  87 */     _h_ += this.levelrange.hashCode();
/*  88 */     _h_ += this.syntype;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.activityinfo).append(",");
/*  96 */     _sb_.append(this.levelrange).append(",");
/*  97 */     _sb_.append(this.syntype).append(",");
/*  98 */     _sb_.append(")");
/*  99 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSynLeaderMatchInfo _o_) {
/* 103 */     if (_o_ == this) return 0;
/* 104 */     int _c_ = 0;
/* 105 */     _c_ = this.activityinfo.compareTo(_o_.activityinfo);
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.levelrange.compareTo(_o_.levelrange);
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     _c_ = this.syntype - _o_.syntype;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\SSynLeaderMatchInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */