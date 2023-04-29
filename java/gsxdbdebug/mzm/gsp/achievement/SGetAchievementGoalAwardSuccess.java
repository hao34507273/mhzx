/*     */ package mzm.gsp.achievement;
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
/*     */ public class SGetAchievementGoalAwardSuccess
/*     */   extends __SGetAchievementGoalAwardSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12603908;
/*     */   public int activity_cfg_id;
/*     */   public int goal_cfg_id;
/*     */   public int now_score_value;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12603908;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetAchievementGoalAwardSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetAchievementGoalAwardSuccess(int _activity_cfg_id_, int _goal_cfg_id_, int _now_score_value_)
/*     */   {
/*  38 */     this.activity_cfg_id = _activity_cfg_id_;
/*  39 */     this.goal_cfg_id = _goal_cfg_id_;
/*  40 */     this.now_score_value = _now_score_value_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.activity_cfg_id);
/*  49 */     _os_.marshal(this.goal_cfg_id);
/*  50 */     _os_.marshal(this.now_score_value);
/*  51 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  55 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  56 */     this.goal_cfg_id = _os_.unmarshal_int();
/*  57 */     this.now_score_value = _os_.unmarshal_int();
/*  58 */     if (!_validator_()) {
/*  59 */       throw new VerifyError("validator failed");
/*     */     }
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  65 */     if (_o1_ == this) return true;
/*  66 */     if ((_o1_ instanceof SGetAchievementGoalAwardSuccess)) {
/*  67 */       SGetAchievementGoalAwardSuccess _o_ = (SGetAchievementGoalAwardSuccess)_o1_;
/*  68 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  69 */       if (this.goal_cfg_id != _o_.goal_cfg_id) return false;
/*  70 */       if (this.now_score_value != _o_.now_score_value) return false;
/*  71 */       return true;
/*     */     }
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  77 */     int _h_ = 0;
/*  78 */     _h_ += this.activity_cfg_id;
/*  79 */     _h_ += this.goal_cfg_id;
/*  80 */     _h_ += this.now_score_value;
/*  81 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  85 */     StringBuilder _sb_ = new StringBuilder();
/*  86 */     _sb_.append("(");
/*  87 */     _sb_.append(this.activity_cfg_id).append(",");
/*  88 */     _sb_.append(this.goal_cfg_id).append(",");
/*  89 */     _sb_.append(this.now_score_value).append(",");
/*  90 */     _sb_.append(")");
/*  91 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetAchievementGoalAwardSuccess _o_) {
/*  95 */     if (_o_ == this) return 0;
/*  96 */     int _c_ = 0;
/*  97 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.goal_cfg_id - _o_.goal_cfg_id;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = this.now_score_value - _o_.now_score_value;
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\SGetAchievementGoalAwardSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */