/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ public class ChildBean implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public static final int BABY_PERIOD = 0;
/*     */   public static final int CHILDHOOD_PERIOD = 1;
/*     */   public static final int ADULT_PERIOD = 2;
/*     */   public long child_id;
/*     */   public Octets child_name;
/*     */   public int child_gender;
/*     */   public HashMap<Integer, Integer> child_model_cfg_id_map;
/*     */   public int child_period;
/*     */   public long child_belong_role_id;
/*     */   public long child_another_parent_role_id;
/*     */   public Octets child_period_info;
/*     */   public HashMap<Integer, DressedInfo> fashions;
/*     */   
/*     */   public ChildBean()
/*     */   {
/*  24 */     this.child_name = new Octets();
/*  25 */     this.child_model_cfg_id_map = new HashMap();
/*  26 */     this.child_period_info = new Octets();
/*  27 */     this.fashions = new HashMap();
/*     */   }
/*     */   
/*     */   public ChildBean(long _child_id_, Octets _child_name_, int _child_gender_, HashMap<Integer, Integer> _child_model_cfg_id_map_, int _child_period_, long _child_belong_role_id_, long _child_another_parent_role_id_, Octets _child_period_info_, HashMap<Integer, DressedInfo> _fashions_) {
/*  31 */     this.child_id = _child_id_;
/*  32 */     this.child_name = _child_name_;
/*  33 */     this.child_gender = _child_gender_;
/*  34 */     this.child_model_cfg_id_map = _child_model_cfg_id_map_;
/*  35 */     this.child_period = _child_period_;
/*  36 */     this.child_belong_role_id = _child_belong_role_id_;
/*  37 */     this.child_another_parent_role_id = _child_another_parent_role_id_;
/*  38 */     this.child_period_info = _child_period_info_;
/*  39 */     this.fashions = _fashions_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  43 */     for (java.util.Map.Entry<Integer, DressedInfo> _e_ : this.fashions.entrySet()) {
/*  44 */       if (!((DressedInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.child_id);
/*  51 */     _os_.marshal(this.child_name);
/*  52 */     _os_.marshal(this.child_gender);
/*  53 */     _os_.compact_uint32(this.child_model_cfg_id_map.size());
/*  54 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.child_model_cfg_id_map.entrySet()) {
/*  55 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  56 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  58 */     _os_.marshal(this.child_period);
/*  59 */     _os_.marshal(this.child_belong_role_id);
/*  60 */     _os_.marshal(this.child_another_parent_role_id);
/*  61 */     _os_.marshal(this.child_period_info);
/*  62 */     _os_.compact_uint32(this.fashions.size());
/*  63 */     for (java.util.Map.Entry<Integer, DressedInfo> _e_ : this.fashions.entrySet()) {
/*  64 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  65 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  71 */     this.child_id = _os_.unmarshal_long();
/*  72 */     this.child_name = _os_.unmarshal_Octets();
/*  73 */     this.child_gender = _os_.unmarshal_int();
/*  74 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  76 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  78 */       int _v_ = _os_.unmarshal_int();
/*  79 */       this.child_model_cfg_id_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  81 */     this.child_period = _os_.unmarshal_int();
/*  82 */     this.child_belong_role_id = _os_.unmarshal_long();
/*  83 */     this.child_another_parent_role_id = _os_.unmarshal_long();
/*  84 */     this.child_period_info = _os_.unmarshal_Octets();
/*  85 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  87 */       int _k_ = _os_.unmarshal_int();
/*  88 */       DressedInfo _v_ = new DressedInfo();
/*  89 */       _v_.unmarshal(_os_);
/*  90 */       this.fashions.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  92 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  96 */     if (_o1_ == this) return true;
/*  97 */     if ((_o1_ instanceof ChildBean)) {
/*  98 */       ChildBean _o_ = (ChildBean)_o1_;
/*  99 */       if (this.child_id != _o_.child_id) return false;
/* 100 */       if (!this.child_name.equals(_o_.child_name)) return false;
/* 101 */       if (this.child_gender != _o_.child_gender) return false;
/* 102 */       if (!this.child_model_cfg_id_map.equals(_o_.child_model_cfg_id_map)) return false;
/* 103 */       if (this.child_period != _o_.child_period) return false;
/* 104 */       if (this.child_belong_role_id != _o_.child_belong_role_id) return false;
/* 105 */       if (this.child_another_parent_role_id != _o_.child_another_parent_role_id) return false;
/* 106 */       if (!this.child_period_info.equals(_o_.child_period_info)) return false;
/* 107 */       if (!this.fashions.equals(_o_.fashions)) return false;
/* 108 */       return true;
/*     */     }
/* 110 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 114 */     int _h_ = 0;
/* 115 */     _h_ += (int)this.child_id;
/* 116 */     _h_ += this.child_name.hashCode();
/* 117 */     _h_ += this.child_gender;
/* 118 */     _h_ += this.child_model_cfg_id_map.hashCode();
/* 119 */     _h_ += this.child_period;
/* 120 */     _h_ += (int)this.child_belong_role_id;
/* 121 */     _h_ += (int)this.child_another_parent_role_id;
/* 122 */     _h_ += this.child_period_info.hashCode();
/* 123 */     _h_ += this.fashions.hashCode();
/* 124 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 128 */     StringBuilder _sb_ = new StringBuilder();
/* 129 */     _sb_.append("(");
/* 130 */     _sb_.append(this.child_id).append(",");
/* 131 */     _sb_.append("B").append(this.child_name.size()).append(",");
/* 132 */     _sb_.append(this.child_gender).append(",");
/* 133 */     _sb_.append(this.child_model_cfg_id_map).append(",");
/* 134 */     _sb_.append(this.child_period).append(",");
/* 135 */     _sb_.append(this.child_belong_role_id).append(",");
/* 136 */     _sb_.append(this.child_another_parent_role_id).append(",");
/* 137 */     _sb_.append("B").append(this.child_period_info.size()).append(",");
/* 138 */     _sb_.append(this.fashions).append(",");
/* 139 */     _sb_.append(")");
/* 140 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\ChildBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */