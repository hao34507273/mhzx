/*     */ package mzm.gsp.map;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ 
/*     */ public class MapModelInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public static final int TITLEID = 0;
/*     */   public static final int APPELLATIONID = 1;
/*     */   public static final int HUSONG_FOLLOW_MONSTER_ID = 4;
/*     */   public static final int MAP_APP_COLOR_ID = 5;
/*     */   public static final int HUSONG_COUPLE_FLY_NPC_CFG_ID = 6;
/*     */   public static final int GENDER = 7;
/*     */   public static final int NAME = 0;
/*     */   public static final int APPELLATION = 1;
/*     */   public static final int MAP_APP_TEXT = 2;
/*     */   public long id;
/*     */   public ModelInfo model;
/*     */   public int velocity;
/*     */   public java.util.ArrayList<Integer> role_status_list;
/*     */   public HashMap<Integer, Integer> int_props;
/*     */   public HashMap<Integer, String> string_props;
/*     */   public HashMap<Integer, ModelInfo> other_models;
/*     */   public HashMap<Integer, com.goldhuman.Common.Octets> protocol_octets_map;
/*     */   
/*     */   public MapModelInfo()
/*     */   {
/*  29 */     this.model = new ModelInfo();
/*  30 */     this.role_status_list = new java.util.ArrayList();
/*  31 */     this.int_props = new HashMap();
/*  32 */     this.string_props = new HashMap();
/*  33 */     this.other_models = new HashMap();
/*  34 */     this.protocol_octets_map = new HashMap();
/*     */   }
/*     */   
/*     */   public MapModelInfo(long _id_, ModelInfo _model_, int _velocity_, java.util.ArrayList<Integer> _role_status_list_, HashMap<Integer, Integer> _int_props_, HashMap<Integer, String> _string_props_, HashMap<Integer, ModelInfo> _other_models_, HashMap<Integer, com.goldhuman.Common.Octets> _protocol_octets_map_) {
/*  38 */     this.id = _id_;
/*  39 */     this.model = _model_;
/*  40 */     this.velocity = _velocity_;
/*  41 */     this.role_status_list = _role_status_list_;
/*  42 */     this.int_props = _int_props_;
/*  43 */     this.string_props = _string_props_;
/*  44 */     this.other_models = _other_models_;
/*  45 */     this.protocol_octets_map = _protocol_octets_map_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     if (!this.model._validator_()) return false;
/*  50 */     for (java.util.Map.Entry<Integer, ModelInfo> _e_ : this.other_models.entrySet()) {
/*  51 */       if (!((ModelInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.id);
/*  58 */     _os_.marshal(this.model);
/*  59 */     _os_.marshal(this.velocity);
/*  60 */     _os_.compact_uint32(this.role_status_list.size());
/*  61 */     for (Integer _v_ : this.role_status_list) {
/*  62 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  64 */     _os_.compact_uint32(this.int_props.size());
/*  65 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.int_props.entrySet()) {
/*  66 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  67 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  69 */     _os_.compact_uint32(this.string_props.size());
/*  70 */     for (java.util.Map.Entry<Integer, String> _e_ : this.string_props.entrySet()) {
/*  71 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  72 */       _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*     */     }
/*  74 */     _os_.compact_uint32(this.other_models.size());
/*  75 */     for (java.util.Map.Entry<Integer, ModelInfo> _e_ : this.other_models.entrySet()) {
/*  76 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  77 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  79 */     _os_.compact_uint32(this.protocol_octets_map.size());
/*  80 */     for (java.util.Map.Entry<Integer, com.goldhuman.Common.Octets> _e_ : this.protocol_octets_map.entrySet()) {
/*  81 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  82 */       _os_.marshal((com.goldhuman.Common.Octets)_e_.getValue());
/*     */     }
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  88 */     this.id = _os_.unmarshal_long();
/*  89 */     this.model.unmarshal(_os_);
/*  90 */     this.velocity = _os_.unmarshal_int();
/*  91 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  93 */       int _v_ = _os_.unmarshal_int();
/*  94 */       this.role_status_list.add(Integer.valueOf(_v_));
/*     */     }
/*  96 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  98 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 100 */       int _v_ = _os_.unmarshal_int();
/* 101 */       this.int_props.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 103 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 105 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 107 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/* 108 */       this.string_props.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 110 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 112 */       int _k_ = _os_.unmarshal_int();
/* 113 */       ModelInfo _v_ = new ModelInfo();
/* 114 */       _v_.unmarshal(_os_);
/* 115 */       this.other_models.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 117 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 119 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 121 */       com.goldhuman.Common.Octets _v_ = _os_.unmarshal_Octets();
/* 122 */       this.protocol_octets_map.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 124 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 128 */     if (_o1_ == this) return true;
/* 129 */     if ((_o1_ instanceof MapModelInfo)) {
/* 130 */       MapModelInfo _o_ = (MapModelInfo)_o1_;
/* 131 */       if (this.id != _o_.id) return false;
/* 132 */       if (!this.model.equals(_o_.model)) return false;
/* 133 */       if (this.velocity != _o_.velocity) return false;
/* 134 */       if (!this.role_status_list.equals(_o_.role_status_list)) return false;
/* 135 */       if (!this.int_props.equals(_o_.int_props)) return false;
/* 136 */       if (!this.string_props.equals(_o_.string_props)) return false;
/* 137 */       if (!this.other_models.equals(_o_.other_models)) return false;
/* 138 */       if (!this.protocol_octets_map.equals(_o_.protocol_octets_map)) return false;
/* 139 */       return true;
/*     */     }
/* 141 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 145 */     int _h_ = 0;
/* 146 */     _h_ += (int)this.id;
/* 147 */     _h_ += this.model.hashCode();
/* 148 */     _h_ += this.velocity;
/* 149 */     _h_ += this.role_status_list.hashCode();
/* 150 */     _h_ += this.int_props.hashCode();
/* 151 */     _h_ += this.string_props.hashCode();
/* 152 */     _h_ += this.other_models.hashCode();
/* 153 */     _h_ += this.protocol_octets_map.hashCode();
/* 154 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 158 */     StringBuilder _sb_ = new StringBuilder();
/* 159 */     _sb_.append("(");
/* 160 */     _sb_.append(this.id).append(",");
/* 161 */     _sb_.append(this.model).append(",");
/* 162 */     _sb_.append(this.velocity).append(",");
/* 163 */     _sb_.append(this.role_status_list).append(",");
/* 164 */     _sb_.append(this.int_props).append(",");
/* 165 */     _sb_.append(this.string_props).append(",");
/* 166 */     _sb_.append(this.other_models).append(",");
/* 167 */     _sb_.append(this.protocol_octets_map).append(",");
/* 168 */     _sb_.append(")");
/* 169 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\MapModelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */