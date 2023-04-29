/*     */ package mzm.gsp.memorycompetition;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class SMemoryCompetitionQuestionStart
/*     */   extends __SMemoryCompetitionQuestionStart__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12613126;
/*     */   public int activity_cfg_id;
/*     */   public int memory_competition_cfg_id;
/*     */   public int score;
/*     */   public int now_round_num;
/*     */   public int total_round_num;
/*     */   public int left_seconds;
/*     */   public int left_seek_help_times;
/*     */   public HashMap<Long, QuestionInfo> roles_question_map;
/*     */   public HashMap<Long, Integer> roles_right_num_map;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12613126;
/*     */   }
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
/*     */   public SMemoryCompetitionQuestionStart()
/*     */   {
/*  41 */     this.roles_question_map = new HashMap();
/*  42 */     this.roles_right_num_map = new HashMap();
/*     */   }
/*     */   
/*     */   public SMemoryCompetitionQuestionStart(int _activity_cfg_id_, int _memory_competition_cfg_id_, int _score_, int _now_round_num_, int _total_round_num_, int _left_seconds_, int _left_seek_help_times_, HashMap<Long, QuestionInfo> _roles_question_map_, HashMap<Long, Integer> _roles_right_num_map_) {
/*  46 */     this.activity_cfg_id = _activity_cfg_id_;
/*  47 */     this.memory_competition_cfg_id = _memory_competition_cfg_id_;
/*  48 */     this.score = _score_;
/*  49 */     this.now_round_num = _now_round_num_;
/*  50 */     this.total_round_num = _total_round_num_;
/*  51 */     this.left_seconds = _left_seconds_;
/*  52 */     this.left_seek_help_times = _left_seek_help_times_;
/*  53 */     this.roles_question_map = _roles_question_map_;
/*  54 */     this.roles_right_num_map = _roles_right_num_map_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  58 */     for (Map.Entry<Long, QuestionInfo> _e_ : this.roles_question_map.entrySet()) {
/*  59 */       if (!((QuestionInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  61 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  65 */     _os_.marshal(this.activity_cfg_id);
/*  66 */     _os_.marshal(this.memory_competition_cfg_id);
/*  67 */     _os_.marshal(this.score);
/*  68 */     _os_.marshal(this.now_round_num);
/*  69 */     _os_.marshal(this.total_round_num);
/*  70 */     _os_.marshal(this.left_seconds);
/*  71 */     _os_.marshal(this.left_seek_help_times);
/*  72 */     _os_.compact_uint32(this.roles_question_map.size());
/*  73 */     for (Map.Entry<Long, QuestionInfo> _e_ : this.roles_question_map.entrySet()) {
/*  74 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  75 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  77 */     _os_.compact_uint32(this.roles_right_num_map.size());
/*  78 */     for (Map.Entry<Long, Integer> _e_ : this.roles_right_num_map.entrySet()) {
/*  79 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  80 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  82 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  86 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  87 */     this.memory_competition_cfg_id = _os_.unmarshal_int();
/*  88 */     this.score = _os_.unmarshal_int();
/*  89 */     this.now_round_num = _os_.unmarshal_int();
/*  90 */     this.total_round_num = _os_.unmarshal_int();
/*  91 */     this.left_seconds = _os_.unmarshal_int();
/*  92 */     this.left_seek_help_times = _os_.unmarshal_int();
/*  93 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  95 */       long _k_ = _os_.unmarshal_long();
/*  96 */       QuestionInfo _v_ = new QuestionInfo();
/*  97 */       _v_.unmarshal(_os_);
/*  98 */       this.roles_question_map.put(Long.valueOf(_k_), _v_);
/*     */     }
/* 100 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 102 */       long _k_ = _os_.unmarshal_long();
/*     */       
/* 104 */       int _v_ = _os_.unmarshal_int();
/* 105 */       this.roles_right_num_map.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 107 */     if (!_validator_()) {
/* 108 */       throw new VerifyError("validator failed");
/*     */     }
/* 110 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 114 */     if (_o1_ == this) return true;
/* 115 */     if ((_o1_ instanceof SMemoryCompetitionQuestionStart)) {
/* 116 */       SMemoryCompetitionQuestionStart _o_ = (SMemoryCompetitionQuestionStart)_o1_;
/* 117 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 118 */       if (this.memory_competition_cfg_id != _o_.memory_competition_cfg_id) return false;
/* 119 */       if (this.score != _o_.score) return false;
/* 120 */       if (this.now_round_num != _o_.now_round_num) return false;
/* 121 */       if (this.total_round_num != _o_.total_round_num) return false;
/* 122 */       if (this.left_seconds != _o_.left_seconds) return false;
/* 123 */       if (this.left_seek_help_times != _o_.left_seek_help_times) return false;
/* 124 */       if (!this.roles_question_map.equals(_o_.roles_question_map)) return false;
/* 125 */       if (!this.roles_right_num_map.equals(_o_.roles_right_num_map)) return false;
/* 126 */       return true;
/*     */     }
/* 128 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 132 */     int _h_ = 0;
/* 133 */     _h_ += this.activity_cfg_id;
/* 134 */     _h_ += this.memory_competition_cfg_id;
/* 135 */     _h_ += this.score;
/* 136 */     _h_ += this.now_round_num;
/* 137 */     _h_ += this.total_round_num;
/* 138 */     _h_ += this.left_seconds;
/* 139 */     _h_ += this.left_seek_help_times;
/* 140 */     _h_ += this.roles_question_map.hashCode();
/* 141 */     _h_ += this.roles_right_num_map.hashCode();
/* 142 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 146 */     StringBuilder _sb_ = new StringBuilder();
/* 147 */     _sb_.append("(");
/* 148 */     _sb_.append(this.activity_cfg_id).append(",");
/* 149 */     _sb_.append(this.memory_competition_cfg_id).append(",");
/* 150 */     _sb_.append(this.score).append(",");
/* 151 */     _sb_.append(this.now_round_num).append(",");
/* 152 */     _sb_.append(this.total_round_num).append(",");
/* 153 */     _sb_.append(this.left_seconds).append(",");
/* 154 */     _sb_.append(this.left_seek_help_times).append(",");
/* 155 */     _sb_.append(this.roles_question_map).append(",");
/* 156 */     _sb_.append(this.roles_right_num_map).append(",");
/* 157 */     _sb_.append(")");
/* 158 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\SMemoryCompetitionQuestionStart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */