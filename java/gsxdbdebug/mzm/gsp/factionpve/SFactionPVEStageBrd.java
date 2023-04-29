/*     */ package mzm.gsp.factionpve;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SFactionPVEStageBrd
/*     */   extends __SFactionPVEStageBrd__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12613636;
/*     */   public static final int STG_BEFORE_START = 0;
/*     */   public static final int STG_PREPARE = 1;
/*     */   public static final int STG_KILL_MONSTER = 2;
/*     */   public static final int STG_BOSS_COUNTDOWN = 3;
/*     */   public static final int STG_KILL_BOSS = 4;
/*     */   public static final int STG_FINISH_COUNTDOWN = 5;
/*     */   public static final int STG_FINISHED = 6;
/*     */   public int stage;
/*     */   public long end_time;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12613636;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SFactionPVEStageBrd()
/*     */   {
/*  42 */     this.end_time = -1L;
/*     */   }
/*     */   
/*     */   public SFactionPVEStageBrd(int _stage_, long _end_time_) {
/*  46 */     this.stage = _stage_;
/*  47 */     this.end_time = _end_time_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.stage);
/*  56 */     _os_.marshal(this.end_time);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.stage = _os_.unmarshal_int();
/*  62 */     this.end_time = _os_.unmarshal_long();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof SFactionPVEStageBrd)) {
/*  72 */       SFactionPVEStageBrd _o_ = (SFactionPVEStageBrd)_o1_;
/*  73 */       if (this.stage != _o_.stage) return false;
/*  74 */       if (this.end_time != _o_.end_time) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.stage;
/*  83 */     _h_ += (int)this.end_time;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.stage).append(",");
/*  91 */     _sb_.append(this.end_time).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SFactionPVEStageBrd _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = this.stage - _o_.stage;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = Long.signum(this.end_time - _o_.end_time);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\SFactionPVEStageBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */