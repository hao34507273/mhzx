/*     */ package mzm.gsp.achievement;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynAchievementInfo
/*     */   extends __SSynAchievementInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12603907;
/*     */   public int activity_cfg_id;
/*     */   public HashMap<Integer, AchievementGoalInfo> goal_map_info;
/*     */   public HashSet<Integer> aleardy_awarded_score;
/*     */   public int now_score_value;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12603907;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynAchievementInfo()
/*     */   {
/*  36 */     this.goal_map_info = new HashMap();
/*  37 */     this.aleardy_awarded_score = new HashSet();
/*     */   }
/*     */   
/*     */   public SSynAchievementInfo(int _activity_cfg_id_, HashMap<Integer, AchievementGoalInfo> _goal_map_info_, HashSet<Integer> _aleardy_awarded_score_, int _now_score_value_) {
/*  41 */     this.activity_cfg_id = _activity_cfg_id_;
/*  42 */     this.goal_map_info = _goal_map_info_;
/*  43 */     this.aleardy_awarded_score = _aleardy_awarded_score_;
/*  44 */     this.now_score_value = _now_score_value_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     for (Map.Entry<Integer, AchievementGoalInfo> _e_ : this.goal_map_info.entrySet()) {
/*  49 */       if (!((AchievementGoalInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.activity_cfg_id);
/*  56 */     _os_.compact_uint32(this.goal_map_info.size());
/*  57 */     for (Map.Entry<Integer, AchievementGoalInfo> _e_ : this.goal_map_info.entrySet()) {
/*  58 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  59 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  61 */     _os_.compact_uint32(this.aleardy_awarded_score.size());
/*  62 */     for (Integer _v_ : this.aleardy_awarded_score) {
/*  63 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  65 */     _os_.marshal(this.now_score_value);
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  70 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  71 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  73 */       int _k_ = _os_.unmarshal_int();
/*  74 */       AchievementGoalInfo _v_ = new AchievementGoalInfo();
/*  75 */       _v_.unmarshal(_os_);
/*  76 */       this.goal_map_info.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  78 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  80 */       int _v_ = _os_.unmarshal_int();
/*  81 */       this.aleardy_awarded_score.add(Integer.valueOf(_v_));
/*     */     }
/*  83 */     this.now_score_value = _os_.unmarshal_int();
/*  84 */     if (!_validator_()) {
/*  85 */       throw new VerifyError("validator failed");
/*     */     }
/*  87 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  91 */     if (_o1_ == this) return true;
/*  92 */     if ((_o1_ instanceof SSynAchievementInfo)) {
/*  93 */       SSynAchievementInfo _o_ = (SSynAchievementInfo)_o1_;
/*  94 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  95 */       if (!this.goal_map_info.equals(_o_.goal_map_info)) return false;
/*  96 */       if (!this.aleardy_awarded_score.equals(_o_.aleardy_awarded_score)) return false;
/*  97 */       if (this.now_score_value != _o_.now_score_value) return false;
/*  98 */       return true;
/*     */     }
/* 100 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 104 */     int _h_ = 0;
/* 105 */     _h_ += this.activity_cfg_id;
/* 106 */     _h_ += this.goal_map_info.hashCode();
/* 107 */     _h_ += this.aleardy_awarded_score.hashCode();
/* 108 */     _h_ += this.now_score_value;
/* 109 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 113 */     StringBuilder _sb_ = new StringBuilder();
/* 114 */     _sb_.append("(");
/* 115 */     _sb_.append(this.activity_cfg_id).append(",");
/* 116 */     _sb_.append(this.goal_map_info).append(",");
/* 117 */     _sb_.append(this.aleardy_awarded_score).append(",");
/* 118 */     _sb_.append(this.now_score_value).append(",");
/* 119 */     _sb_.append(")");
/* 120 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\achievement\SSynAchievementInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */