/*     */ package mzm.gsp.fabao;
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
/*     */ public class SFabaoWashSucRes
/*     */   extends __SFabaoWashSucRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596008;
/*     */   public int equiped;
/*     */   public long fabaouuid;
/*     */   public int skillid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12596008;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SFabaoWashSucRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SFabaoWashSucRes(int _equiped_, long _fabaouuid_, int _skillid_)
/*     */   {
/*  38 */     this.equiped = _equiped_;
/*  39 */     this.fabaouuid = _fabaouuid_;
/*  40 */     this.skillid = _skillid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.equiped);
/*  49 */     _os_.marshal(this.fabaouuid);
/*  50 */     _os_.marshal(this.skillid);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.equiped = _os_.unmarshal_int();
/*  56 */     this.fabaouuid = _os_.unmarshal_long();
/*  57 */     this.skillid = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SFabaoWashSucRes)) {
/*  67 */       SFabaoWashSucRes _o_ = (SFabaoWashSucRes)_o1_;
/*  68 */       if (this.equiped != _o_.equiped) return false;
/*  69 */       if (this.fabaouuid != _o_.fabaouuid) return false;
/*  70 */       if (this.skillid != _o_.skillid) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.equiped;
/*  79 */     _h_ += (int)this.fabaouuid;
/*  80 */     _h_ += this.skillid;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.equiped).append(",");
/*  88 */     _sb_.append(this.fabaouuid).append(",");
/*  89 */     _sb_.append(this.skillid).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SFabaoWashSucRes _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.equiped - _o_.equiped;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = Long.signum(this.fabaouuid - _o_.fabaouuid);
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.skillid - _o_.skillid;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\SFabaoWashSucRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */