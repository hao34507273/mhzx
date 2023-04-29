/*     */ package mzm.gsp.skill;
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
/*     */ public class SFuMoSkillPreviewRes
/*     */   extends __SFuMoSkillPreviewRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12591625;
/*     */   public int skillid;
/*     */   public int needvigor;
/*     */   public int itemid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12591625;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SFuMoSkillPreviewRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SFuMoSkillPreviewRes(int _skillid_, int _needvigor_, int _itemid_)
/*     */   {
/*  38 */     this.skillid = _skillid_;
/*  39 */     this.needvigor = _needvigor_;
/*  40 */     this.itemid = _itemid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.skillid);
/*  49 */     _os_.marshal(this.needvigor);
/*  50 */     _os_.marshal(this.itemid);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.skillid = _os_.unmarshal_int();
/*  56 */     this.needvigor = _os_.unmarshal_int();
/*  57 */     this.itemid = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SFuMoSkillPreviewRes)) {
/*  67 */       SFuMoSkillPreviewRes _o_ = (SFuMoSkillPreviewRes)_o1_;
/*  68 */       if (this.skillid != _o_.skillid) return false;
/*  69 */       if (this.needvigor != _o_.needvigor) return false;
/*  70 */       if (this.itemid != _o_.itemid) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.skillid;
/*  79 */     _h_ += this.needvigor;
/*  80 */     _h_ += this.itemid;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.skillid).append(",");
/*  88 */     _sb_.append(this.needvigor).append(",");
/*  89 */     _sb_.append(this.itemid).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SFuMoSkillPreviewRes _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.skillid - _o_.skillid;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.needvigor - _o_.needvigor;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.itemid - _o_.itemid;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\skill\SFuMoSkillPreviewRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */