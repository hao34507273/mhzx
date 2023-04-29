/*     */ package mzm.gsp.feisheng;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class SSynZhuXianJianZhenActivityStageInfo extends __SSynZhuXianJianZhenActivityStageInfo__ { public static final int PROTOCOL_TYPE = 12614178;
/*     */   public static final int STAGE_OVER = 0;
/*     */   public static final int STAGE_COLLECT_ITEM = 1;
/*     */   public static final int STAGE_KILL_MONSTER = 2;
/*     */   public static final int STATE_BEGIN = 1;
/*     */   public static final int STATE_RUNNING = 2;
/*     */   public static final int STATE_END = 3;
/*     */   public static final int RESULT_NULL = 0;
/*     */   public static final int RESULT_SUCCESS = 1;
/*     */   public static final int RESULT_FAIL = 2;
/*     */   public int activity_cfg_id;
/*     */   public int stage;
/*     */   public int state;
/*     */   public int result;
/*     */   public int commit_item_num;
/*     */   public int kill_monster_num;
/*     */   public int stage_collect_item_start_timestamp;
/*     */   public int stage_kill_monster_start_timestamp;
/*     */   public int daily_try_times;
/*     */   
/*     */   protected void process() {}
/*     */   
/*  27 */   public int getType() { return 12614178; }
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
/*     */ 
/*     */ 
/*     */   public SSynZhuXianJianZhenActivityStageInfo() {}
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
/*     */ 
/*     */   public SSynZhuXianJianZhenActivityStageInfo(int _activity_cfg_id_, int _stage_, int _state_, int _result_, int _commit_item_num_, int _kill_monster_num_, int _stage_collect_item_start_timestamp_, int _stage_kill_monster_start_timestamp_, int _daily_try_times_)
/*     */   {
/*  54 */     this.activity_cfg_id = _activity_cfg_id_;
/*  55 */     this.stage = _stage_;
/*  56 */     this.state = _state_;
/*  57 */     this.result = _result_;
/*  58 */     this.commit_item_num = _commit_item_num_;
/*  59 */     this.kill_monster_num = _kill_monster_num_;
/*  60 */     this.stage_collect_item_start_timestamp = _stage_collect_item_start_timestamp_;
/*  61 */     this.stage_kill_monster_start_timestamp = _stage_kill_monster_start_timestamp_;
/*  62 */     this.daily_try_times = _daily_try_times_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  66 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  70 */     _os_.marshal(this.activity_cfg_id);
/*  71 */     _os_.marshal(this.stage);
/*  72 */     _os_.marshal(this.state);
/*  73 */     _os_.marshal(this.result);
/*  74 */     _os_.marshal(this.commit_item_num);
/*  75 */     _os_.marshal(this.kill_monster_num);
/*  76 */     _os_.marshal(this.stage_collect_item_start_timestamp);
/*  77 */     _os_.marshal(this.stage_kill_monster_start_timestamp);
/*  78 */     _os_.marshal(this.daily_try_times);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  83 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  84 */     this.stage = _os_.unmarshal_int();
/*  85 */     this.state = _os_.unmarshal_int();
/*  86 */     this.result = _os_.unmarshal_int();
/*  87 */     this.commit_item_num = _os_.unmarshal_int();
/*  88 */     this.kill_monster_num = _os_.unmarshal_int();
/*  89 */     this.stage_collect_item_start_timestamp = _os_.unmarshal_int();
/*  90 */     this.stage_kill_monster_start_timestamp = _os_.unmarshal_int();
/*  91 */     this.daily_try_times = _os_.unmarshal_int();
/*  92 */     if (!_validator_()) {
/*  93 */       throw new VerifyError("validator failed");
/*     */     }
/*  95 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  99 */     if (_o1_ == this) return true;
/* 100 */     if ((_o1_ instanceof SSynZhuXianJianZhenActivityStageInfo)) {
/* 101 */       SSynZhuXianJianZhenActivityStageInfo _o_ = (SSynZhuXianJianZhenActivityStageInfo)_o1_;
/* 102 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 103 */       if (this.stage != _o_.stage) return false;
/* 104 */       if (this.state != _o_.state) return false;
/* 105 */       if (this.result != _o_.result) return false;
/* 106 */       if (this.commit_item_num != _o_.commit_item_num) return false;
/* 107 */       if (this.kill_monster_num != _o_.kill_monster_num) return false;
/* 108 */       if (this.stage_collect_item_start_timestamp != _o_.stage_collect_item_start_timestamp) return false;
/* 109 */       if (this.stage_kill_monster_start_timestamp != _o_.stage_kill_monster_start_timestamp) return false;
/* 110 */       if (this.daily_try_times != _o_.daily_try_times) return false;
/* 111 */       return true;
/*     */     }
/* 113 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 117 */     int _h_ = 0;
/* 118 */     _h_ += this.activity_cfg_id;
/* 119 */     _h_ += this.stage;
/* 120 */     _h_ += this.state;
/* 121 */     _h_ += this.result;
/* 122 */     _h_ += this.commit_item_num;
/* 123 */     _h_ += this.kill_monster_num;
/* 124 */     _h_ += this.stage_collect_item_start_timestamp;
/* 125 */     _h_ += this.stage_kill_monster_start_timestamp;
/* 126 */     _h_ += this.daily_try_times;
/* 127 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 131 */     StringBuilder _sb_ = new StringBuilder();
/* 132 */     _sb_.append("(");
/* 133 */     _sb_.append(this.activity_cfg_id).append(",");
/* 134 */     _sb_.append(this.stage).append(",");
/* 135 */     _sb_.append(this.state).append(",");
/* 136 */     _sb_.append(this.result).append(",");
/* 137 */     _sb_.append(this.commit_item_num).append(",");
/* 138 */     _sb_.append(this.kill_monster_num).append(",");
/* 139 */     _sb_.append(this.stage_collect_item_start_timestamp).append(",");
/* 140 */     _sb_.append(this.stage_kill_monster_start_timestamp).append(",");
/* 141 */     _sb_.append(this.daily_try_times).append(",");
/* 142 */     _sb_.append(")");
/* 143 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSynZhuXianJianZhenActivityStageInfo _o_) {
/* 147 */     if (_o_ == this) return 0;
/* 148 */     int _c_ = 0;
/* 149 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 150 */     if (0 != _c_) return _c_;
/* 151 */     _c_ = this.stage - _o_.stage;
/* 152 */     if (0 != _c_) return _c_;
/* 153 */     _c_ = this.state - _o_.state;
/* 154 */     if (0 != _c_) return _c_;
/* 155 */     _c_ = this.result - _o_.result;
/* 156 */     if (0 != _c_) return _c_;
/* 157 */     _c_ = this.commit_item_num - _o_.commit_item_num;
/* 158 */     if (0 != _c_) return _c_;
/* 159 */     _c_ = this.kill_monster_num - _o_.kill_monster_num;
/* 160 */     if (0 != _c_) return _c_;
/* 161 */     _c_ = this.stage_collect_item_start_timestamp - _o_.stage_collect_item_start_timestamp;
/* 162 */     if (0 != _c_) return _c_;
/* 163 */     _c_ = this.stage_kill_monster_start_timestamp - _o_.stage_kill_monster_start_timestamp;
/* 164 */     if (0 != _c_) return _c_;
/* 165 */     _c_ = this.daily_try_times - _o_.daily_try_times;
/* 166 */     if (0 != _c_) return _c_;
/* 167 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\SSynZhuXianJianZhenActivityStageInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */