/*     */ package mzm.gsp.wing;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SUnderstandSkillRes
/*     */   extends __SUnderstandSkillRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596496;
/*     */   public int index;
/*     */   public int phase;
/*     */   public int skillindex;
/*     */   public WingSkill skill;
/*     */   public ModelId2DyeId modelid2dyeid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12596496;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SUnderstandSkillRes()
/*     */   {
/*  35 */     this.skill = new WingSkill();
/*  36 */     this.modelid2dyeid = new ModelId2DyeId();
/*     */   }
/*     */   
/*     */   public SUnderstandSkillRes(int _index_, int _phase_, int _skillindex_, WingSkill _skill_, ModelId2DyeId _modelid2dyeid_) {
/*  40 */     this.index = _index_;
/*  41 */     this.phase = _phase_;
/*  42 */     this.skillindex = _skillindex_;
/*  43 */     this.skill = _skill_;
/*  44 */     this.modelid2dyeid = _modelid2dyeid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     if (!this.skill._validator_()) return false;
/*  49 */     if (!this.modelid2dyeid._validator_()) return false;
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.index);
/*  55 */     _os_.marshal(this.phase);
/*  56 */     _os_.marshal(this.skillindex);
/*  57 */     _os_.marshal(this.skill);
/*  58 */     _os_.marshal(this.modelid2dyeid);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.index = _os_.unmarshal_int();
/*  64 */     this.phase = _os_.unmarshal_int();
/*  65 */     this.skillindex = _os_.unmarshal_int();
/*  66 */     this.skill.unmarshal(_os_);
/*  67 */     this.modelid2dyeid.unmarshal(_os_);
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof SUnderstandSkillRes)) {
/*  77 */       SUnderstandSkillRes _o_ = (SUnderstandSkillRes)_o1_;
/*  78 */       if (this.index != _o_.index) return false;
/*  79 */       if (this.phase != _o_.phase) return false;
/*  80 */       if (this.skillindex != _o_.skillindex) return false;
/*  81 */       if (!this.skill.equals(_o_.skill)) return false;
/*  82 */       if (!this.modelid2dyeid.equals(_o_.modelid2dyeid)) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += this.index;
/*  91 */     _h_ += this.phase;
/*  92 */     _h_ += this.skillindex;
/*  93 */     _h_ += this.skill.hashCode();
/*  94 */     _h_ += this.modelid2dyeid.hashCode();
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.index).append(",");
/* 102 */     _sb_.append(this.phase).append(",");
/* 103 */     _sb_.append(this.skillindex).append(",");
/* 104 */     _sb_.append(this.skill).append(",");
/* 105 */     _sb_.append(this.modelid2dyeid).append(",");
/* 106 */     _sb_.append(")");
/* 107 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\SUnderstandSkillRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */