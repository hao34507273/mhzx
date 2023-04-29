/*     */ package mzm.gsp.lifeskill;
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
/*     */ public class SLifeSkillLevelResetSuccess
/*     */   extends __SLifeSkillLevelResetSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12589067;
/*     */   public int skill_bag_id;
/*     */   public int after_level;
/*     */   public long return_silver;
/*     */   public long return_banggong;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12589067;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SLifeSkillLevelResetSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SLifeSkillLevelResetSuccess(int _skill_bag_id_, int _after_level_, long _return_silver_, long _return_banggong_)
/*     */   {
/*  39 */     this.skill_bag_id = _skill_bag_id_;
/*  40 */     this.after_level = _after_level_;
/*  41 */     this.return_silver = _return_silver_;
/*  42 */     this.return_banggong = _return_banggong_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.skill_bag_id);
/*  51 */     _os_.marshal(this.after_level);
/*  52 */     _os_.marshal(this.return_silver);
/*  53 */     _os_.marshal(this.return_banggong);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.skill_bag_id = _os_.unmarshal_int();
/*  59 */     this.after_level = _os_.unmarshal_int();
/*  60 */     this.return_silver = _os_.unmarshal_long();
/*  61 */     this.return_banggong = _os_.unmarshal_long();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SLifeSkillLevelResetSuccess)) {
/*  71 */       SLifeSkillLevelResetSuccess _o_ = (SLifeSkillLevelResetSuccess)_o1_;
/*  72 */       if (this.skill_bag_id != _o_.skill_bag_id) return false;
/*  73 */       if (this.after_level != _o_.after_level) return false;
/*  74 */       if (this.return_silver != _o_.return_silver) return false;
/*  75 */       if (this.return_banggong != _o_.return_banggong) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.skill_bag_id;
/*  84 */     _h_ += this.after_level;
/*  85 */     _h_ += (int)this.return_silver;
/*  86 */     _h_ += (int)this.return_banggong;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.skill_bag_id).append(",");
/*  94 */     _sb_.append(this.after_level).append(",");
/*  95 */     _sb_.append(this.return_silver).append(",");
/*  96 */     _sb_.append(this.return_banggong).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SLifeSkillLevelResetSuccess _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.skill_bag_id - _o_.skill_bag_id;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.after_level - _o_.after_level;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = Long.signum(this.return_silver - _o_.return_silver);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = Long.signum(this.return_banggong - _o_.return_banggong);
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\SLifeSkillLevelResetSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */