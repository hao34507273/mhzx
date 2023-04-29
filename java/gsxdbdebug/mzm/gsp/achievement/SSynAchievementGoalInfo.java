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
/*     */ public class SSynAchievementGoalInfo
/*     */   extends __SSynAchievementGoalInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12603910;
/*     */   public int activity_cfg_id;
/*     */   public int goal_cfg_id;
/*     */   public AchievementGoalInfo goal_info;
/*     */   public int now_score_value;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12603910;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynAchievementGoalInfo()
/*     */   {
/*  36 */     this.goal_info = new AchievementGoalInfo();
/*     */   }
/*     */   
/*     */   public SSynAchievementGoalInfo(int _activity_cfg_id_, int _goal_cfg_id_, AchievementGoalInfo _goal_info_, int _now_score_value_) {
/*  40 */     this.activity_cfg_id = _activity_cfg_id_;
/*  41 */     this.goal_cfg_id = _goal_cfg_id_;
/*  42 */     this.goal_info = _goal_info_;
/*  43 */     this.now_score_value = _now_score_value_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     if (!this.goal_info._validator_()) return false;
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.activity_cfg_id);
/*  53 */     _os_.marshal(this.goal_cfg_id);
/*  54 */     _os_.marshal(this.goal_info);
/*  55 */     _os_.marshal(this.now_score_value);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  61 */     this.goal_cfg_id = _os_.unmarshal_int();
/*  62 */     this.goal_info.unmarshal(_os_);
/*  63 */     this.now_score_value = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof SSynAchievementGoalInfo)) {
/*  73 */       SSynAchievementGoalInfo _o_ = (SSynAchievementGoalInfo)_o1_;
/*  74 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  75 */       if (this.goal_cfg_id != _o_.goal_cfg_id) return false;
/*  76 */       if (!this.goal_info.equals(_o_.goal_info)) return false;
/*  77 */       if (this.now_score_value != _o_.now_score_value) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.activity_cfg_id;
/*  86 */     _h_ += this.goal_cfg_id;
/*  87 */     _h_ += this.goal_info.hashCode();
/*  88 */     _h_ += this.now_score_value;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.activity_cfg_id).append(",");
/*  96 */     _sb_.append(this.goal_cfg_id).append(",");
/*  97 */     _sb_.append(this.goal_info).append(",");
/*  98 */     _sb_.append(this.now_score_value).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\SSynAchievementGoalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */