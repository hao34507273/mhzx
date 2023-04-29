/*     */ package mzm.gsp.magicmark;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SUnLockMagicMarkRes
/*     */   extends __SUnLockMagicMarkRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609540;
/*     */   public static final int SUCCESS = 1;
/*     */   public static final int ERROR_ITEM_NOT_ENOUGH = 2;
/*     */   public static final int ERROR_ITEM_MAGIC_MARK_TYPE_NOT_SAME = 3;
/*     */   public static final int ERROR_DO_NOT_NEED_UNLOCK = 4;
/*     */   public static final int ERROR_ROLE_LEVEL_NOT_ENOUGH = 5;
/*     */   public int ret;
/*     */   public int magicmarktype;
/*     */   public long expiredtime;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609540;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SUnLockMagicMarkRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SUnLockMagicMarkRes(int _ret_, int _magicmarktype_, long _expiredtime_)
/*     */   {
/*  44 */     this.ret = _ret_;
/*  45 */     this.magicmarktype = _magicmarktype_;
/*  46 */     this.expiredtime = _expiredtime_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.ret);
/*  55 */     _os_.marshal(this.magicmarktype);
/*  56 */     _os_.marshal(this.expiredtime);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.ret = _os_.unmarshal_int();
/*  62 */     this.magicmarktype = _os_.unmarshal_int();
/*  63 */     this.expiredtime = _os_.unmarshal_long();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SUnLockMagicMarkRes)) {
/*  73 */       SUnLockMagicMarkRes _o_ = (SUnLockMagicMarkRes)_o1_;
/*  74 */       if (this.ret != _o_.ret) return false;
/*  75 */       if (this.magicmarktype != _o_.magicmarktype) return false;
/*  76 */       if (this.expiredtime != _o_.expiredtime) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += this.ret;
/*  85 */     _h_ += this.magicmarktype;
/*  86 */     _h_ += (int)this.expiredtime;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.ret).append(",");
/*  94 */     _sb_.append(this.magicmarktype).append(",");
/*  95 */     _sb_.append(this.expiredtime).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SUnLockMagicMarkRes _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = this.ret - _o_.ret;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.magicmarktype - _o_.magicmarktype;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = Long.signum(this.expiredtime - _o_.expiredtime);
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\SUnLockMagicMarkRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */