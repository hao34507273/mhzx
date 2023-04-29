/*     */ package mzm.gsp.homeland;
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
/*     */ public class STrainPetRes
/*     */   extends __STrainPetRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605445;
/*     */   public long petid;
/*     */   public int addexpnum;
/*     */   public int dayttrainpetcount;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12605445;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public STrainPetRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public STrainPetRes(long _petid_, int _addexpnum_, int _dayttrainpetcount_)
/*     */   {
/*  36 */     this.petid = _petid_;
/*  37 */     this.addexpnum = _addexpnum_;
/*  38 */     this.dayttrainpetcount = _dayttrainpetcount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  46 */     _os_.marshal(this.petid);
/*  47 */     _os_.marshal(this.addexpnum);
/*  48 */     _os_.marshal(this.dayttrainpetcount);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  53 */     this.petid = _os_.unmarshal_long();
/*  54 */     this.addexpnum = _os_.unmarshal_int();
/*  55 */     this.dayttrainpetcount = _os_.unmarshal_int();
/*  56 */     if (!_validator_()) {
/*  57 */       throw new VerifyError("validator failed");
/*     */     }
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  63 */     if (_o1_ == this) return true;
/*  64 */     if ((_o1_ instanceof STrainPetRes)) {
/*  65 */       STrainPetRes _o_ = (STrainPetRes)_o1_;
/*  66 */       if (this.petid != _o_.petid) return false;
/*  67 */       if (this.addexpnum != _o_.addexpnum) return false;
/*  68 */       if (this.dayttrainpetcount != _o_.dayttrainpetcount) return false;
/*  69 */       return true;
/*     */     }
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  75 */     int _h_ = 0;
/*  76 */     _h_ += (int)this.petid;
/*  77 */     _h_ += this.addexpnum;
/*  78 */     _h_ += this.dayttrainpetcount;
/*  79 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  83 */     StringBuilder _sb_ = new StringBuilder();
/*  84 */     _sb_.append("(");
/*  85 */     _sb_.append(this.petid).append(",");
/*  86 */     _sb_.append(this.addexpnum).append(",");
/*  87 */     _sb_.append(this.dayttrainpetcount).append(",");
/*  88 */     _sb_.append(")");
/*  89 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(STrainPetRes _o_) {
/*  93 */     if (_o_ == this) return 0;
/*  94 */     int _c_ = 0;
/*  95 */     _c_ = Long.signum(this.petid - _o_.petid);
/*  96 */     if (0 != _c_) return _c_;
/*  97 */     _c_ = this.addexpnum - _o_.addexpnum;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.dayttrainpetcount - _o_.dayttrainpetcount;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\STrainPetRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */