/*     */ package mzm.gsp.children;
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
/*     */ public class SLevelUpOccupationSkillRes
/*     */   extends __SLevelUpOccupationSkillRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609379;
/*     */   public long childrenid;
/*     */   public int skillid;
/*     */   public int lv;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609379;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SLevelUpOccupationSkillRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SLevelUpOccupationSkillRes(long _childrenid_, int _skillid_, int _lv_)
/*     */   {
/*  38 */     this.childrenid = _childrenid_;
/*  39 */     this.skillid = _skillid_;
/*  40 */     this.lv = _lv_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.childrenid);
/*  49 */     _os_.marshal(this.skillid);
/*  50 */     _os_.marshal(this.lv);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.childrenid = _os_.unmarshal_long();
/*  56 */     this.skillid = _os_.unmarshal_int();
/*  57 */     this.lv = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SLevelUpOccupationSkillRes)) {
/*  67 */       SLevelUpOccupationSkillRes _o_ = (SLevelUpOccupationSkillRes)_o1_;
/*  68 */       if (this.childrenid != _o_.childrenid) return false;
/*  69 */       if (this.skillid != _o_.skillid) return false;
/*  70 */       if (this.lv != _o_.lv) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += (int)this.childrenid;
/*  79 */     _h_ += this.skillid;
/*  80 */     _h_ += this.lv;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.childrenid).append(",");
/*  88 */     _sb_.append(this.skillid).append(",");
/*  89 */     _sb_.append(this.lv).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SLevelUpOccupationSkillRes _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.childrenid - _o_.childrenid);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.skillid - _o_.skillid;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.lv - _o_.lv;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SLevelUpOccupationSkillRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */