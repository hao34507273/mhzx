/*     */ package mzm.gsp.factionpve;
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
/*     */ 
/*     */ 
/*     */ public class SSyncParticipateTimes
/*     */   extends __SSyncParticipateTimes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12613655;
/*     */   public int participate_times;
/*     */   public long participate_millis;
/*     */   public long participate_faction;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12613655;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncParticipateTimes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSyncParticipateTimes(int _participate_times_, long _participate_millis_, long _participate_faction_)
/*     */   {
/*  38 */     this.participate_times = _participate_times_;
/*  39 */     this.participate_millis = _participate_millis_;
/*  40 */     this.participate_faction = _participate_faction_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.participate_times);
/*  49 */     _os_.marshal(this.participate_millis);
/*  50 */     _os_.marshal(this.participate_faction);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.participate_times = _os_.unmarshal_int();
/*  56 */     this.participate_millis = _os_.unmarshal_long();
/*  57 */     this.participate_faction = _os_.unmarshal_long();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SSyncParticipateTimes)) {
/*  67 */       SSyncParticipateTimes _o_ = (SSyncParticipateTimes)_o1_;
/*  68 */       if (this.participate_times != _o_.participate_times) return false;
/*  69 */       if (this.participate_millis != _o_.participate_millis) return false;
/*  70 */       if (this.participate_faction != _o_.participate_faction) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.participate_times;
/*  79 */     _h_ += (int)this.participate_millis;
/*  80 */     _h_ += (int)this.participate_faction;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.participate_times).append(",");
/*  88 */     _sb_.append(this.participate_millis).append(",");
/*  89 */     _sb_.append(this.participate_faction).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncParticipateTimes _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.participate_times - _o_.participate_times;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = Long.signum(this.participate_millis - _o_.participate_millis);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = Long.signum(this.participate_faction - _o_.participate_faction);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\factionpve\SSyncParticipateTimes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */