/*     */ package mzm.gsp.petmark;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ public class SPetMarkUpgradeUseAllSuccess
/*     */   extends __SPetMarkUpgradeUseAllSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12628507;
/*     */   public long main_pet_mark_id;
/*     */   public int now_level;
/*     */   public int now_exp;
/*     */   public int add_exp;
/*     */   public ArrayList<Long> cost_pet_mark_ids;
/*     */   public HashMap<Integer, Integer> cost_item_map;
/*     */   public HashMap<Long, PetMarkInfo> new_pet_mark_info_map;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12628507;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SPetMarkUpgradeUseAllSuccess()
/*     */   {
/*  39 */     this.cost_pet_mark_ids = new ArrayList();
/*  40 */     this.cost_item_map = new HashMap();
/*  41 */     this.new_pet_mark_info_map = new HashMap();
/*     */   }
/*     */   
/*     */   public SPetMarkUpgradeUseAllSuccess(long _main_pet_mark_id_, int _now_level_, int _now_exp_, int _add_exp_, ArrayList<Long> _cost_pet_mark_ids_, HashMap<Integer, Integer> _cost_item_map_, HashMap<Long, PetMarkInfo> _new_pet_mark_info_map_) {
/*  45 */     this.main_pet_mark_id = _main_pet_mark_id_;
/*  46 */     this.now_level = _now_level_;
/*  47 */     this.now_exp = _now_exp_;
/*  48 */     this.add_exp = _add_exp_;
/*  49 */     this.cost_pet_mark_ids = _cost_pet_mark_ids_;
/*  50 */     this.cost_item_map = _cost_item_map_;
/*  51 */     this.new_pet_mark_info_map = _new_pet_mark_info_map_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     for (Map.Entry<Long, PetMarkInfo> _e_ : this.new_pet_mark_info_map.entrySet()) {
/*  56 */       if (!((PetMarkInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  58 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  62 */     _os_.marshal(this.main_pet_mark_id);
/*  63 */     _os_.marshal(this.now_level);
/*  64 */     _os_.marshal(this.now_exp);
/*  65 */     _os_.marshal(this.add_exp);
/*  66 */     _os_.compact_uint32(this.cost_pet_mark_ids.size());
/*  67 */     for (Long _v_ : this.cost_pet_mark_ids) {
/*  68 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  70 */     _os_.compact_uint32(this.cost_item_map.size());
/*  71 */     for (Map.Entry<Integer, Integer> _e_ : this.cost_item_map.entrySet()) {
/*  72 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  73 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  75 */     _os_.compact_uint32(this.new_pet_mark_info_map.size());
/*  76 */     for (Map.Entry<Long, PetMarkInfo> _e_ : this.new_pet_mark_info_map.entrySet()) {
/*  77 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  78 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  84 */     this.main_pet_mark_id = _os_.unmarshal_long();
/*  85 */     this.now_level = _os_.unmarshal_int();
/*  86 */     this.now_exp = _os_.unmarshal_int();
/*  87 */     this.add_exp = _os_.unmarshal_int();
/*  88 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  90 */       long _v_ = _os_.unmarshal_long();
/*  91 */       this.cost_pet_mark_ids.add(Long.valueOf(_v_));
/*     */     }
/*  93 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  95 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  97 */       int _v_ = _os_.unmarshal_int();
/*  98 */       this.cost_item_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 100 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 102 */       long _k_ = _os_.unmarshal_long();
/* 103 */       PetMarkInfo _v_ = new PetMarkInfo();
/* 104 */       _v_.unmarshal(_os_);
/* 105 */       this.new_pet_mark_info_map.put(Long.valueOf(_k_), _v_);
/*     */     }
/* 107 */     if (!_validator_()) {
/* 108 */       throw new VerifyError("validator failed");
/*     */     }
/* 110 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 114 */     if (_o1_ == this) return true;
/* 115 */     if ((_o1_ instanceof SPetMarkUpgradeUseAllSuccess)) {
/* 116 */       SPetMarkUpgradeUseAllSuccess _o_ = (SPetMarkUpgradeUseAllSuccess)_o1_;
/* 117 */       if (this.main_pet_mark_id != _o_.main_pet_mark_id) return false;
/* 118 */       if (this.now_level != _o_.now_level) return false;
/* 119 */       if (this.now_exp != _o_.now_exp) return false;
/* 120 */       if (this.add_exp != _o_.add_exp) return false;
/* 121 */       if (!this.cost_pet_mark_ids.equals(_o_.cost_pet_mark_ids)) return false;
/* 122 */       if (!this.cost_item_map.equals(_o_.cost_item_map)) return false;
/* 123 */       if (!this.new_pet_mark_info_map.equals(_o_.new_pet_mark_info_map)) return false;
/* 124 */       return true;
/*     */     }
/* 126 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 130 */     int _h_ = 0;
/* 131 */     _h_ += (int)this.main_pet_mark_id;
/* 132 */     _h_ += this.now_level;
/* 133 */     _h_ += this.now_exp;
/* 134 */     _h_ += this.add_exp;
/* 135 */     _h_ += this.cost_pet_mark_ids.hashCode();
/* 136 */     _h_ += this.cost_item_map.hashCode();
/* 137 */     _h_ += this.new_pet_mark_info_map.hashCode();
/* 138 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 142 */     StringBuilder _sb_ = new StringBuilder();
/* 143 */     _sb_.append("(");
/* 144 */     _sb_.append(this.main_pet_mark_id).append(",");
/* 145 */     _sb_.append(this.now_level).append(",");
/* 146 */     _sb_.append(this.now_exp).append(",");
/* 147 */     _sb_.append(this.add_exp).append(",");
/* 148 */     _sb_.append(this.cost_pet_mark_ids).append(",");
/* 149 */     _sb_.append(this.cost_item_map).append(",");
/* 150 */     _sb_.append(this.new_pet_mark_info_map).append(",");
/* 151 */     _sb_.append(")");
/* 152 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\SPetMarkUpgradeUseAllSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */