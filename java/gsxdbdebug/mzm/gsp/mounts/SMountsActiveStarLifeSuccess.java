/*     */ package mzm.gsp.mounts;
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
/*     */ public class SMountsActiveStarLifeSuccess
/*     */   extends __SMountsActiveStarLifeSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12606219;
/*     */   public long mounts_id;
/*     */   public int star_level;
/*     */   public int star_num;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12606219;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SMountsActiveStarLifeSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SMountsActiveStarLifeSuccess(long _mounts_id_, int _star_level_, int _star_num_)
/*     */   {
/*  38 */     this.mounts_id = _mounts_id_;
/*  39 */     this.star_level = _star_level_;
/*  40 */     this.star_num = _star_num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.mounts_id);
/*  49 */     _os_.marshal(this.star_level);
/*  50 */     _os_.marshal(this.star_num);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.mounts_id = _os_.unmarshal_long();
/*  56 */     this.star_level = _os_.unmarshal_int();
/*  57 */     this.star_num = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SMountsActiveStarLifeSuccess)) {
/*  67 */       SMountsActiveStarLifeSuccess _o_ = (SMountsActiveStarLifeSuccess)_o1_;
/*  68 */       if (this.mounts_id != _o_.mounts_id) return false;
/*  69 */       if (this.star_level != _o_.star_level) return false;
/*  70 */       if (this.star_num != _o_.star_num) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += (int)this.mounts_id;
/*  79 */     _h_ += this.star_level;
/*  80 */     _h_ += this.star_num;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.mounts_id).append(",");
/*  88 */     _sb_.append(this.star_level).append(",");
/*  89 */     _sb_.append(this.star_num).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SMountsActiveStarLifeSuccess _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.mounts_id - _o_.mounts_id);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.star_level - _o_.star_level;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.star_num - _o_.star_num;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\SMountsActiveStarLifeSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */