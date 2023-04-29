/*     */ package mzm.gsp.floor;
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
/*     */ public class SChallengeSuc
/*     */   extends __SChallengeSuc__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617739;
/*     */   public int activityid;
/*     */   public int floor;
/*     */   public int usedtime;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617739;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SChallengeSuc() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SChallengeSuc(int _activityid_, int _floor_, int _usedtime_)
/*     */   {
/*  38 */     this.activityid = _activityid_;
/*  39 */     this.floor = _floor_;
/*  40 */     this.usedtime = _usedtime_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.activityid);
/*  49 */     _os_.marshal(this.floor);
/*  50 */     _os_.marshal(this.usedtime);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.activityid = _os_.unmarshal_int();
/*  56 */     this.floor = _os_.unmarshal_int();
/*  57 */     this.usedtime = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SChallengeSuc)) {
/*  67 */       SChallengeSuc _o_ = (SChallengeSuc)_o1_;
/*  68 */       if (this.activityid != _o_.activityid) return false;
/*  69 */       if (this.floor != _o_.floor) return false;
/*  70 */       if (this.usedtime != _o_.usedtime) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.activityid;
/*  79 */     _h_ += this.floor;
/*  80 */     _h_ += this.usedtime;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.activityid).append(",");
/*  88 */     _sb_.append(this.floor).append(",");
/*  89 */     _sb_.append(this.usedtime).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SChallengeSuc _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.activityid - _o_.activityid;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.floor - _o_.floor;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.usedtime - _o_.usedtime;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floor\SChallengeSuc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */