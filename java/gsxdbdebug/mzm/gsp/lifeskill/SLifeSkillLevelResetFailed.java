/*     */ package mzm.gsp.lifeskill;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SLifeSkillLevelResetFailed
/*     */   extends __SLifeSkillLevelResetFailed__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12589069;
/*     */   public static final int ERROR_SYSTEM = -1;
/*     */   public static final int ERROR_USERID = -2;
/*     */   public static final int ERROR_CFG = -3;
/*     */   public static final int ERROR_PARAM = -4;
/*     */   public static final int ERROR_ROLE_LEVEL_LESS = -5;
/*     */   public static final int ERROR_SILVER_TO_MAX = -6;
/*     */   public static final int ERROR_BANGGONG_TO_MAX = -7;
/*     */   public static final int ERROR_NOT_IN_GANG = -8;
/*     */   public int skill_bag_id;
/*     */   public int ret_code;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12589069;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SLifeSkillLevelResetFailed() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SLifeSkillLevelResetFailed(int _skill_bag_id_, int _ret_code_)
/*     */   {
/*  46 */     this.skill_bag_id = _skill_bag_id_;
/*  47 */     this.ret_code = _ret_code_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.skill_bag_id);
/*  56 */     _os_.marshal(this.ret_code);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.skill_bag_id = _os_.unmarshal_int();
/*  62 */     this.ret_code = _os_.unmarshal_int();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof SLifeSkillLevelResetFailed)) {
/*  72 */       SLifeSkillLevelResetFailed _o_ = (SLifeSkillLevelResetFailed)_o1_;
/*  73 */       if (this.skill_bag_id != _o_.skill_bag_id) return false;
/*  74 */       if (this.ret_code != _o_.ret_code) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.skill_bag_id;
/*  83 */     _h_ += this.ret_code;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.skill_bag_id).append(",");
/*  91 */     _sb_.append(this.ret_code).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SLifeSkillLevelResetFailed _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = this.skill_bag_id - _o_.skill_bag_id;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.ret_code - _o_.ret_code;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lifeskill\SLifeSkillLevelResetFailed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */