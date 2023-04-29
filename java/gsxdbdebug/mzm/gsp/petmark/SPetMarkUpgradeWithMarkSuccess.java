/*     */ package mzm.gsp.petmark;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SPetMarkUpgradeWithMarkSuccess
/*     */   extends __SPetMarkUpgradeWithMarkSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12628499;
/*     */   public long main_pet_mark_id;
/*     */   public long cost_pet_mark_id;
/*     */   public int now_level;
/*     */   public int now_exp;
/*     */   public int add_exp;
/*     */   public HashMap<Long, PetMarkInfo> new_pet_mark_info_map;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12628499;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SPetMarkUpgradeWithMarkSuccess()
/*     */   {
/*  38 */     this.new_pet_mark_info_map = new HashMap();
/*     */   }
/*     */   
/*     */   public SPetMarkUpgradeWithMarkSuccess(long _main_pet_mark_id_, long _cost_pet_mark_id_, int _now_level_, int _now_exp_, int _add_exp_, HashMap<Long, PetMarkInfo> _new_pet_mark_info_map_) {
/*  42 */     this.main_pet_mark_id = _main_pet_mark_id_;
/*  43 */     this.cost_pet_mark_id = _cost_pet_mark_id_;
/*  44 */     this.now_level = _now_level_;
/*  45 */     this.now_exp = _now_exp_;
/*  46 */     this.add_exp = _add_exp_;
/*  47 */     this.new_pet_mark_info_map = _new_pet_mark_info_map_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     for (Map.Entry<Long, PetMarkInfo> _e_ : this.new_pet_mark_info_map.entrySet()) {
/*  52 */       if (!((PetMarkInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.marshal(this.main_pet_mark_id);
/*  59 */     _os_.marshal(this.cost_pet_mark_id);
/*  60 */     _os_.marshal(this.now_level);
/*  61 */     _os_.marshal(this.now_exp);
/*  62 */     _os_.marshal(this.add_exp);
/*  63 */     _os_.compact_uint32(this.new_pet_mark_info_map.size());
/*  64 */     for (Map.Entry<Long, PetMarkInfo> _e_ : this.new_pet_mark_info_map.entrySet()) {
/*  65 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  66 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  72 */     this.main_pet_mark_id = _os_.unmarshal_long();
/*  73 */     this.cost_pet_mark_id = _os_.unmarshal_long();
/*  74 */     this.now_level = _os_.unmarshal_int();
/*  75 */     this.now_exp = _os_.unmarshal_int();
/*  76 */     this.add_exp = _os_.unmarshal_int();
/*  77 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  79 */       long _k_ = _os_.unmarshal_long();
/*  80 */       PetMarkInfo _v_ = new PetMarkInfo();
/*  81 */       _v_.unmarshal(_os_);
/*  82 */       this.new_pet_mark_info_map.put(Long.valueOf(_k_), _v_);
/*     */     }
/*  84 */     if (!_validator_()) {
/*  85 */       throw new VerifyError("validator failed");
/*     */     }
/*  87 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  91 */     if (_o1_ == this) return true;
/*  92 */     if ((_o1_ instanceof SPetMarkUpgradeWithMarkSuccess)) {
/*  93 */       SPetMarkUpgradeWithMarkSuccess _o_ = (SPetMarkUpgradeWithMarkSuccess)_o1_;
/*  94 */       if (this.main_pet_mark_id != _o_.main_pet_mark_id) return false;
/*  95 */       if (this.cost_pet_mark_id != _o_.cost_pet_mark_id) return false;
/*  96 */       if (this.now_level != _o_.now_level) return false;
/*  97 */       if (this.now_exp != _o_.now_exp) return false;
/*  98 */       if (this.add_exp != _o_.add_exp) return false;
/*  99 */       if (!this.new_pet_mark_info_map.equals(_o_.new_pet_mark_info_map)) return false;
/* 100 */       return true;
/*     */     }
/* 102 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 106 */     int _h_ = 0;
/* 107 */     _h_ += (int)this.main_pet_mark_id;
/* 108 */     _h_ += (int)this.cost_pet_mark_id;
/* 109 */     _h_ += this.now_level;
/* 110 */     _h_ += this.now_exp;
/* 111 */     _h_ += this.add_exp;
/* 112 */     _h_ += this.new_pet_mark_info_map.hashCode();
/* 113 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 117 */     StringBuilder _sb_ = new StringBuilder();
/* 118 */     _sb_.append("(");
/* 119 */     _sb_.append(this.main_pet_mark_id).append(",");
/* 120 */     _sb_.append(this.cost_pet_mark_id).append(",");
/* 121 */     _sb_.append(this.now_level).append(",");
/* 122 */     _sb_.append(this.now_exp).append(",");
/* 123 */     _sb_.append(this.add_exp).append(",");
/* 124 */     _sb_.append(this.new_pet_mark_info_map).append(",");
/* 125 */     _sb_.append(")");
/* 126 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petmark\SPetMarkUpgradeWithMarkSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */