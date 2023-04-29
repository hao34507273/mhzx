/*     */ package mzm.gsp.mounts;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class MountsInfo implements Marshal
/*     */ {
/*     */   public int mounts_cfg_id;
/*     */   public int mounts_rank;
/*     */   public int color_id;
/*     */   public ArrayList<PassiveSkillInfo> passive_skill_list;
/*     */   public long remain_time;
/*     */   public int current_star_level;
/*     */   public int current_max_active_star_num;
/*     */   public int current_score;
/*     */   public int current_ornament_rank;
/*     */   public int protect_pet_expand_size;
/*     */   
/*     */   public MountsInfo()
/*     */   {
/*  23 */     this.passive_skill_list = new ArrayList();
/*     */   }
/*     */   
/*     */   public MountsInfo(int _mounts_cfg_id_, int _mounts_rank_, int _color_id_, ArrayList<PassiveSkillInfo> _passive_skill_list_, long _remain_time_, int _current_star_level_, int _current_max_active_star_num_, int _current_score_, int _current_ornament_rank_, int _protect_pet_expand_size_) {
/*  27 */     this.mounts_cfg_id = _mounts_cfg_id_;
/*  28 */     this.mounts_rank = _mounts_rank_;
/*  29 */     this.color_id = _color_id_;
/*  30 */     this.passive_skill_list = _passive_skill_list_;
/*  31 */     this.remain_time = _remain_time_;
/*  32 */     this.current_star_level = _current_star_level_;
/*  33 */     this.current_max_active_star_num = _current_max_active_star_num_;
/*  34 */     this.current_score = _current_score_;
/*  35 */     this.current_ornament_rank = _current_ornament_rank_;
/*  36 */     this.protect_pet_expand_size = _protect_pet_expand_size_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  40 */     for (PassiveSkillInfo _v_ : this.passive_skill_list)
/*  41 */       if (!_v_._validator_()) return false;
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  46 */     _os_.marshal(this.mounts_cfg_id);
/*  47 */     _os_.marshal(this.mounts_rank);
/*  48 */     _os_.marshal(this.color_id);
/*  49 */     _os_.compact_uint32(this.passive_skill_list.size());
/*  50 */     for (PassiveSkillInfo _v_ : this.passive_skill_list) {
/*  51 */       _os_.marshal(_v_);
/*     */     }
/*  53 */     _os_.marshal(this.remain_time);
/*  54 */     _os_.marshal(this.current_star_level);
/*  55 */     _os_.marshal(this.current_max_active_star_num);
/*  56 */     _os_.marshal(this.current_score);
/*  57 */     _os_.marshal(this.current_ornament_rank);
/*  58 */     _os_.marshal(this.protect_pet_expand_size);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.mounts_cfg_id = _os_.unmarshal_int();
/*  64 */     this.mounts_rank = _os_.unmarshal_int();
/*  65 */     this.color_id = _os_.unmarshal_int();
/*  66 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  67 */       PassiveSkillInfo _v_ = new PassiveSkillInfo();
/*  68 */       _v_.unmarshal(_os_);
/*  69 */       this.passive_skill_list.add(_v_);
/*     */     }
/*  71 */     this.remain_time = _os_.unmarshal_long();
/*  72 */     this.current_star_level = _os_.unmarshal_int();
/*  73 */     this.current_max_active_star_num = _os_.unmarshal_int();
/*  74 */     this.current_score = _os_.unmarshal_int();
/*  75 */     this.current_ornament_rank = _os_.unmarshal_int();
/*  76 */     this.protect_pet_expand_size = _os_.unmarshal_int();
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof MountsInfo)) {
/*  83 */       MountsInfo _o_ = (MountsInfo)_o1_;
/*  84 */       if (this.mounts_cfg_id != _o_.mounts_cfg_id) return false;
/*  85 */       if (this.mounts_rank != _o_.mounts_rank) return false;
/*  86 */       if (this.color_id != _o_.color_id) return false;
/*  87 */       if (!this.passive_skill_list.equals(_o_.passive_skill_list)) return false;
/*  88 */       if (this.remain_time != _o_.remain_time) return false;
/*  89 */       if (this.current_star_level != _o_.current_star_level) return false;
/*  90 */       if (this.current_max_active_star_num != _o_.current_max_active_star_num) return false;
/*  91 */       if (this.current_score != _o_.current_score) return false;
/*  92 */       if (this.current_ornament_rank != _o_.current_ornament_rank) return false;
/*  93 */       if (this.protect_pet_expand_size != _o_.protect_pet_expand_size) return false;
/*  94 */       return true;
/*     */     }
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 100 */     int _h_ = 0;
/* 101 */     _h_ += this.mounts_cfg_id;
/* 102 */     _h_ += this.mounts_rank;
/* 103 */     _h_ += this.color_id;
/* 104 */     _h_ += this.passive_skill_list.hashCode();
/* 105 */     _h_ += (int)this.remain_time;
/* 106 */     _h_ += this.current_star_level;
/* 107 */     _h_ += this.current_max_active_star_num;
/* 108 */     _h_ += this.current_score;
/* 109 */     _h_ += this.current_ornament_rank;
/* 110 */     _h_ += this.protect_pet_expand_size;
/* 111 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 115 */     StringBuilder _sb_ = new StringBuilder();
/* 116 */     _sb_.append("(");
/* 117 */     _sb_.append(this.mounts_cfg_id).append(",");
/* 118 */     _sb_.append(this.mounts_rank).append(",");
/* 119 */     _sb_.append(this.color_id).append(",");
/* 120 */     _sb_.append(this.passive_skill_list).append(",");
/* 121 */     _sb_.append(this.remain_time).append(",");
/* 122 */     _sb_.append(this.current_star_level).append(",");
/* 123 */     _sb_.append(this.current_max_active_star_num).append(",");
/* 124 */     _sb_.append(this.current_score).append(",");
/* 125 */     _sb_.append(this.current_ornament_rank).append(",");
/* 126 */     _sb_.append(this.protect_pet_expand_size).append(",");
/* 127 */     _sb_.append(")");
/* 128 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\MountsInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */