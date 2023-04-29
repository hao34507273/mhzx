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
/*     */ public class SBuyChallengeCountRes
/*     */   extends __SBuyChallengeCountRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12595724;
/*     */   public int buycount;
/*     */   public int challengecount;
/*     */   public int totalbuycount;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12595724;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SBuyChallengeCountRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SBuyChallengeCountRes(int _buycount_, int _challengecount_, int _totalbuycount_)
/*     */   {
/*  36 */     this.buycount = _buycount_;
/*  37 */     this.challengecount = _challengecount_;
/*  38 */     this.totalbuycount = _totalbuycount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  46 */     _os_.marshal(this.buycount);
/*  47 */     _os_.marshal(this.challengecount);
/*  48 */     _os_.marshal(this.totalbuycount);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  53 */     this.buycount = _os_.unmarshal_int();
/*  54 */     this.challengecount = _os_.unmarshal_int();
/*  55 */     this.totalbuycount = _os_.unmarshal_int();
/*  56 */     if (!_validator_()) {
/*  57 */       throw new VerifyError("validator failed");
/*     */     }
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  63 */     if (_o1_ == this) return true;
/*  64 */     if ((_o1_ instanceof SBuyChallengeCountRes)) {
/*  65 */       SBuyChallengeCountRes _o_ = (SBuyChallengeCountRes)_o1_;
/*  66 */       if (this.buycount != _o_.buycount) return false;
/*  67 */       if (this.challengecount != _o_.challengecount) return false;
/*  68 */       if (this.totalbuycount != _o_.totalbuycount) return false;
/*  69 */       return true;
/*     */     }
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  75 */     int _h_ = 0;
/*  76 */     _h_ += this.buycount;
/*  77 */     _h_ += this.challengecount;
/*  78 */     _h_ += this.totalbuycount;
/*  79 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  83 */     StringBuilder _sb_ = new StringBuilder();
/*  84 */     _sb_.append("(");
/*  85 */     _sb_.append(this.buycount).append(",");
/*  86 */     _sb_.append(this.challengecount).append(",");
/*  87 */     _sb_.append(this.totalbuycount).append(",");
/*  88 */     _sb_.append(")");
/*  89 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SBuyChallengeCountRes _o_) {
/*  93 */     if (_o_ == this) return 0;
/*  94 */     int _c_ = 0;
/*  95 */     _c_ = this.buycount - _o_.buycount;
/*  96 */     if (0 != _c_) return _c_;
/*  97 */     _c_ = this.challengecount - _o_.challengecount;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.totalbuycount - _o_.totalbuycount;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jingji\SBuyChallengeCountRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */