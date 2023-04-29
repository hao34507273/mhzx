/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ public class SSynRoleCrossBattleOwnInfo
/*     */   extends __SSynRoleCrossBattleOwnInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12616988;
/*     */   public int activity_cfg_id;
/*     */   public int stage;
/*     */   public ArrayList<Long> vote_stage_direct_promotion_corps_list;
/*     */   public ArrayList<Long> round_robin_point_rank_list;
/*     */   public int round_robin_round_index;
/*     */   public int round_robin_round_stage;
/*     */   public ArrayList<Long> round_robin_stage_promotion_corps_list;
/*     */   public byte register_info;
/*     */   public int vote_times;
/*     */   public int canvass_timestamp;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12616988;
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
/*     */ 
/*     */   public SSynRoleCrossBattleOwnInfo()
/*     */   {
/*  42 */     this.vote_stage_direct_promotion_corps_list = new ArrayList();
/*  43 */     this.round_robin_point_rank_list = new ArrayList();
/*  44 */     this.round_robin_stage_promotion_corps_list = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSynRoleCrossBattleOwnInfo(int _activity_cfg_id_, int _stage_, ArrayList<Long> _vote_stage_direct_promotion_corps_list_, ArrayList<Long> _round_robin_point_rank_list_, int _round_robin_round_index_, int _round_robin_round_stage_, ArrayList<Long> _round_robin_stage_promotion_corps_list_, byte _register_info_, int _vote_times_, int _canvass_timestamp_) {
/*  48 */     this.activity_cfg_id = _activity_cfg_id_;
/*  49 */     this.stage = _stage_;
/*  50 */     this.vote_stage_direct_promotion_corps_list = _vote_stage_direct_promotion_corps_list_;
/*  51 */     this.round_robin_point_rank_list = _round_robin_point_rank_list_;
/*  52 */     this.round_robin_round_index = _round_robin_round_index_;
/*  53 */     this.round_robin_round_stage = _round_robin_round_stage_;
/*  54 */     this.round_robin_stage_promotion_corps_list = _round_robin_stage_promotion_corps_list_;
/*  55 */     this.register_info = _register_info_;
/*  56 */     this.vote_times = _vote_times_;
/*  57 */     this.canvass_timestamp = _canvass_timestamp_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  61 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  65 */     _os_.marshal(this.activity_cfg_id);
/*  66 */     _os_.marshal(this.stage);
/*  67 */     _os_.compact_uint32(this.vote_stage_direct_promotion_corps_list.size());
/*  68 */     for (Long _v_ : this.vote_stage_direct_promotion_corps_list) {
/*  69 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  71 */     _os_.compact_uint32(this.round_robin_point_rank_list.size());
/*  72 */     for (Long _v_ : this.round_robin_point_rank_list) {
/*  73 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  75 */     _os_.marshal(this.round_robin_round_index);
/*  76 */     _os_.marshal(this.round_robin_round_stage);
/*  77 */     _os_.compact_uint32(this.round_robin_stage_promotion_corps_list.size());
/*  78 */     for (Long _v_ : this.round_robin_stage_promotion_corps_list) {
/*  79 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  81 */     _os_.marshal(this.register_info);
/*  82 */     _os_.marshal(this.vote_times);
/*  83 */     _os_.marshal(this.canvass_timestamp);
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  88 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  89 */     this.stage = _os_.unmarshal_int();
/*  90 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  92 */       long _v_ = _os_.unmarshal_long();
/*  93 */       this.vote_stage_direct_promotion_corps_list.add(Long.valueOf(_v_));
/*     */     }
/*  95 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  97 */       long _v_ = _os_.unmarshal_long();
/*  98 */       this.round_robin_point_rank_list.add(Long.valueOf(_v_));
/*     */     }
/* 100 */     this.round_robin_round_index = _os_.unmarshal_int();
/* 101 */     this.round_robin_round_stage = _os_.unmarshal_int();
/* 102 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 104 */       long _v_ = _os_.unmarshal_long();
/* 105 */       this.round_robin_stage_promotion_corps_list.add(Long.valueOf(_v_));
/*     */     }
/* 107 */     this.register_info = _os_.unmarshal_byte();
/* 108 */     this.vote_times = _os_.unmarshal_int();
/* 109 */     this.canvass_timestamp = _os_.unmarshal_int();
/* 110 */     if (!_validator_()) {
/* 111 */       throw new VerifyError("validator failed");
/*     */     }
/* 113 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 117 */     if (_o1_ == this) return true;
/* 118 */     if ((_o1_ instanceof SSynRoleCrossBattleOwnInfo)) {
/* 119 */       SSynRoleCrossBattleOwnInfo _o_ = (SSynRoleCrossBattleOwnInfo)_o1_;
/* 120 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/* 121 */       if (this.stage != _o_.stage) return false;
/* 122 */       if (!this.vote_stage_direct_promotion_corps_list.equals(_o_.vote_stage_direct_promotion_corps_list)) return false;
/* 123 */       if (!this.round_robin_point_rank_list.equals(_o_.round_robin_point_rank_list)) return false;
/* 124 */       if (this.round_robin_round_index != _o_.round_robin_round_index) return false;
/* 125 */       if (this.round_robin_round_stage != _o_.round_robin_round_stage) return false;
/* 126 */       if (!this.round_robin_stage_promotion_corps_list.equals(_o_.round_robin_stage_promotion_corps_list)) return false;
/* 127 */       if (this.register_info != _o_.register_info) return false;
/* 128 */       if (this.vote_times != _o_.vote_times) return false;
/* 129 */       if (this.canvass_timestamp != _o_.canvass_timestamp) return false;
/* 130 */       return true;
/*     */     }
/* 132 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 136 */     int _h_ = 0;
/* 137 */     _h_ += this.activity_cfg_id;
/* 138 */     _h_ += this.stage;
/* 139 */     _h_ += this.vote_stage_direct_promotion_corps_list.hashCode();
/* 140 */     _h_ += this.round_robin_point_rank_list.hashCode();
/* 141 */     _h_ += this.round_robin_round_index;
/* 142 */     _h_ += this.round_robin_round_stage;
/* 143 */     _h_ += this.round_robin_stage_promotion_corps_list.hashCode();
/* 144 */     _h_ += this.register_info;
/* 145 */     _h_ += this.vote_times;
/* 146 */     _h_ += this.canvass_timestamp;
/* 147 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 151 */     StringBuilder _sb_ = new StringBuilder();
/* 152 */     _sb_.append("(");
/* 153 */     _sb_.append(this.activity_cfg_id).append(",");
/* 154 */     _sb_.append(this.stage).append(",");
/* 155 */     _sb_.append(this.vote_stage_direct_promotion_corps_list).append(",");
/* 156 */     _sb_.append(this.round_robin_point_rank_list).append(",");
/* 157 */     _sb_.append(this.round_robin_round_index).append(",");
/* 158 */     _sb_.append(this.round_robin_round_stage).append(",");
/* 159 */     _sb_.append(this.round_robin_stage_promotion_corps_list).append(",");
/* 160 */     _sb_.append(this.register_info).append(",");
/* 161 */     _sb_.append(this.vote_times).append(",");
/* 162 */     _sb_.append(this.canvass_timestamp).append(",");
/* 163 */     _sb_.append(")");
/* 164 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SSynRoleCrossBattleOwnInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */