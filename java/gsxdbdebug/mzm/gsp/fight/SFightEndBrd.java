/*     */ package mzm.gsp.fight;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SFightEndBrd
/*     */   extends __SFightEndBrd__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594188;
/*     */   public static final int RESULT_ACTIVE_WIN = 1;
/*     */   public static final int RESULT_ACTIVE_LOSE = 2;
/*     */   public static final int END_REASON_MAX_ROUND = 100;
/*     */   public static final int END_REASON_NORMAL = 101;
/*     */   public static final int END_REASON_UNKNOWN_ERROR = 102;
/*     */   public static final int END_REASON_TIME_LIMIT = 103;
/*     */   public static final int END_REASON_FORCE_END = 104;
/*     */   public int result;
/*     */   public int reason;
/*     */   public long fight_uuid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12594188;
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
/*     */ 
/*     */   public SFightEndBrd()
/*     */   {
/*  43 */     this.result = 1;
/*  44 */     this.reason = 101;
/*     */   }
/*     */   
/*     */   public SFightEndBrd(int _result_, int _reason_, long _fight_uuid_) {
/*  48 */     this.result = _result_;
/*  49 */     this.reason = _reason_;
/*  50 */     this.fight_uuid = _fight_uuid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.result);
/*  59 */     _os_.marshal(this.reason);
/*  60 */     _os_.marshal(this.fight_uuid);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.result = _os_.unmarshal_int();
/*  66 */     this.reason = _os_.unmarshal_int();
/*  67 */     this.fight_uuid = _os_.unmarshal_long();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SFightEndBrd)) {
/*  77 */       SFightEndBrd _o_ = (SFightEndBrd)_o1_;
/*  78 */       if (this.result != _o_.result) return false;
/*  79 */       if (this.reason != _o_.reason) return false;
/*  80 */       if (this.fight_uuid != _o_.fight_uuid) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.result;
/*  89 */     _h_ += this.reason;
/*  90 */     _h_ += (int)this.fight_uuid;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.result).append(",");
/*  98 */     _sb_.append(this.reason).append(",");
/*  99 */     _sb_.append(this.fight_uuid).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SFightEndBrd _o_) {
/* 105 */     if (_o_ == this) return 0;
/* 106 */     int _c_ = 0;
/* 107 */     _c_ = this.result - _o_.result;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     _c_ = this.reason - _o_.reason;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = Long.signum(this.fight_uuid - _o_.fight_uuid);
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\SFightEndBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */