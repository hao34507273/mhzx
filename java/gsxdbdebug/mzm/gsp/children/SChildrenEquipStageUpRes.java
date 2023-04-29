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
/*     */ public class SChildrenEquipStageUpRes
/*     */   extends __SChildrenEquipStageUpRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609420;
/*     */   public long childrenid;
/*     */   public int pos;
/*     */   public int stage;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609420;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SChildrenEquipStageUpRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SChildrenEquipStageUpRes(long _childrenid_, int _pos_, int _stage_)
/*     */   {
/*  38 */     this.childrenid = _childrenid_;
/*  39 */     this.pos = _pos_;
/*  40 */     this.stage = _stage_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.childrenid);
/*  49 */     _os_.marshal(this.pos);
/*  50 */     _os_.marshal(this.stage);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.childrenid = _os_.unmarshal_long();
/*  56 */     this.pos = _os_.unmarshal_int();
/*  57 */     this.stage = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SChildrenEquipStageUpRes)) {
/*  67 */       SChildrenEquipStageUpRes _o_ = (SChildrenEquipStageUpRes)_o1_;
/*  68 */       if (this.childrenid != _o_.childrenid) return false;
/*  69 */       if (this.pos != _o_.pos) return false;
/*  70 */       if (this.stage != _o_.stage) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += (int)this.childrenid;
/*  79 */     _h_ += this.pos;
/*  80 */     _h_ += this.stage;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.childrenid).append(",");
/*  88 */     _sb_.append(this.pos).append(",");
/*  89 */     _sb_.append(this.stage).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SChildrenEquipStageUpRes _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = Long.signum(this.childrenid - _o_.childrenid);
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.pos - _o_.pos;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.stage - _o_.stage;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\SChildrenEquipStageUpRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */