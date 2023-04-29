/*     */ package mzm.gsp.jingji;
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
/*     */ public class SsynRewardChanged
/*     */   extends __SsynRewardChanged__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12595720;
/*     */   public int isfirstvictoty;
/*     */   public int isfivefight;
/*     */   public int lastseasonphase;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12595720;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SsynRewardChanged() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SsynRewardChanged(int _isfirstvictoty_, int _isfivefight_, int _lastseasonphase_)
/*     */   {
/*  38 */     this.isfirstvictoty = _isfirstvictoty_;
/*  39 */     this.isfivefight = _isfivefight_;
/*  40 */     this.lastseasonphase = _lastseasonphase_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.isfirstvictoty);
/*  49 */     _os_.marshal(this.isfivefight);
/*  50 */     _os_.marshal(this.lastseasonphase);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.isfirstvictoty = _os_.unmarshal_int();
/*  56 */     this.isfivefight = _os_.unmarshal_int();
/*  57 */     this.lastseasonphase = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SsynRewardChanged)) {
/*  67 */       SsynRewardChanged _o_ = (SsynRewardChanged)_o1_;
/*  68 */       if (this.isfirstvictoty != _o_.isfirstvictoty) return false;
/*  69 */       if (this.isfivefight != _o_.isfivefight) return false;
/*  70 */       if (this.lastseasonphase != _o_.lastseasonphase) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.isfirstvictoty;
/*  79 */     _h_ += this.isfivefight;
/*  80 */     _h_ += this.lastseasonphase;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.isfirstvictoty).append(",");
/*  88 */     _sb_.append(this.isfivefight).append(",");
/*  89 */     _sb_.append(this.lastseasonphase).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SsynRewardChanged _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.isfirstvictoty - _o_.isfirstvictoty;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.isfivefight - _o_.isfivefight;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.lastseasonphase - _o_.lastseasonphase;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\SsynRewardChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */