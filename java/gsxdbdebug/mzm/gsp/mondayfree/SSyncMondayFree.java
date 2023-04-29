/*     */ package mzm.gsp.mondayfree;
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
/*     */ public class SSyncMondayFree
/*     */   extends __SSyncMondayFree__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12626184;
/*     */   public long sunday_award_time;
/*     */   public long monday_award_time;
/*     */   public long finish_shimen_time;
/*     */   public long finish_baotu_time;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12626184;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncMondayFree()
/*     */   {
/*  36 */     this.sunday_award_time = 0L;
/*  37 */     this.monday_award_time = 0L;
/*  38 */     this.finish_shimen_time = 0L;
/*  39 */     this.finish_baotu_time = 0L;
/*     */   }
/*     */   
/*     */   public SSyncMondayFree(long _sunday_award_time_, long _monday_award_time_, long _finish_shimen_time_, long _finish_baotu_time_) {
/*  43 */     this.sunday_award_time = _sunday_award_time_;
/*  44 */     this.monday_award_time = _monday_award_time_;
/*  45 */     this.finish_shimen_time = _finish_shimen_time_;
/*  46 */     this.finish_baotu_time = _finish_baotu_time_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.sunday_award_time);
/*  55 */     _os_.marshal(this.monday_award_time);
/*  56 */     _os_.marshal(this.finish_shimen_time);
/*  57 */     _os_.marshal(this.finish_baotu_time);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.sunday_award_time = _os_.unmarshal_long();
/*  63 */     this.monday_award_time = _os_.unmarshal_long();
/*  64 */     this.finish_shimen_time = _os_.unmarshal_long();
/*  65 */     this.finish_baotu_time = _os_.unmarshal_long();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SSyncMondayFree)) {
/*  75 */       SSyncMondayFree _o_ = (SSyncMondayFree)_o1_;
/*  76 */       if (this.sunday_award_time != _o_.sunday_award_time) return false;
/*  77 */       if (this.monday_award_time != _o_.monday_award_time) return false;
/*  78 */       if (this.finish_shimen_time != _o_.finish_shimen_time) return false;
/*  79 */       if (this.finish_baotu_time != _o_.finish_baotu_time) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += (int)this.sunday_award_time;
/*  88 */     _h_ += (int)this.monday_award_time;
/*  89 */     _h_ += (int)this.finish_shimen_time;
/*  90 */     _h_ += (int)this.finish_baotu_time;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.sunday_award_time).append(",");
/*  98 */     _sb_.append(this.monday_award_time).append(",");
/*  99 */     _sb_.append(this.finish_shimen_time).append(",");
/* 100 */     _sb_.append(this.finish_baotu_time).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncMondayFree _o_) {
/* 106 */     if (_o_ == this) return 0;
/* 107 */     int _c_ = 0;
/* 108 */     _c_ = Long.signum(this.sunday_award_time - _o_.sunday_award_time);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = Long.signum(this.monday_award_time - _o_.monday_award_time);
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = Long.signum(this.finish_shimen_time - _o_.finish_shimen_time);
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = Long.signum(this.finish_baotu_time - _o_.finish_baotu_time);
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mondayfree\SSyncMondayFree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */