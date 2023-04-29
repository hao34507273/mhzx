/*     */ package mzm.gsp.zoo;
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
/*     */ public class SAnimalMateFailed
/*     */   extends __SAnimalMateFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12615433;
/*     */   public static final int ERROR_MATE_CD = -1;
/*     */   public static final int ERROR_ANIMAL_MYSELF = -2;
/*     */   public static final int ERROR_ANIMAL_MARRIAGE = -3;
/*     */   public int retcode;
/*     */   public long animalid;
/*     */   public long target_animalid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12615433;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAnimalMateFailed() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SAnimalMateFailed(int _retcode_, long _animalid_, long _target_animalid_)
/*     */   {
/*  42 */     this.retcode = _retcode_;
/*  43 */     this.animalid = _animalid_;
/*  44 */     this.target_animalid = _target_animalid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.retcode);
/*  53 */     _os_.marshal(this.animalid);
/*  54 */     _os_.marshal(this.target_animalid);
/*  55 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  59 */     this.retcode = _os_.unmarshal_int();
/*  60 */     this.animalid = _os_.unmarshal_long();
/*  61 */     this.target_animalid = _os_.unmarshal_long();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SAnimalMateFailed)) {
/*  71 */       SAnimalMateFailed _o_ = (SAnimalMateFailed)_o1_;
/*  72 */       if (this.retcode != _o_.retcode) return false;
/*  73 */       if (this.animalid != _o_.animalid) return false;
/*  74 */       if (this.target_animalid != _o_.target_animalid) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.retcode;
/*  83 */     _h_ += (int)this.animalid;
/*  84 */     _h_ += (int)this.target_animalid;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.retcode).append(",");
/*  92 */     _sb_.append(this.animalid).append(",");
/*  93 */     _sb_.append(this.target_animalid).append(",");
/*  94 */     _sb_.append(")");
/*  95 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SAnimalMateFailed _o_) {
/*  99 */     if (_o_ == this) return 0;
/* 100 */     int _c_ = 0;
/* 101 */     _c_ = this.retcode - _o_.retcode;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = Long.signum(this.animalid - _o_.animalid);
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = Long.signum(this.target_animalid - _o_.target_animalid);
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\SAnimalMateFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */