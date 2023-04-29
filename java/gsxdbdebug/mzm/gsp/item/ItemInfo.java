/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ public class ItemInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public static final int BIND = 1;
/*     */   public int id;
/*     */   public int number;
/*     */   public int flag;
/*     */   public HashMap<Integer, Integer> extramap;
/*     */   public ArrayList<ExtraProBean> exprolist;
/*     */   public HashMap<Integer, TempExtraProInfo> extraprops;
/*     */   public ArrayList<Long> uuid;
/*     */   public ArrayList<FumoInfo> fumoprolist;
/*     */   public HashMap<Integer, Long> extrainfomap;
/*     */   public SuperEquipmentCostInfo super_equipment_cost_bean;
/*     */   public HashMap<Integer, JewelInfo> jewelmap;
/*     */   
/*     */   public ItemInfo()
/*     */   {
/*  24 */     this.extramap = new HashMap();
/*  25 */     this.exprolist = new ArrayList();
/*  26 */     this.extraprops = new HashMap();
/*  27 */     this.uuid = new ArrayList();
/*  28 */     this.fumoprolist = new ArrayList();
/*  29 */     this.extrainfomap = new HashMap();
/*  30 */     this.super_equipment_cost_bean = new SuperEquipmentCostInfo();
/*  31 */     this.jewelmap = new HashMap();
/*     */   }
/*     */   
/*     */   public ItemInfo(int _id_, int _number_, int _flag_, HashMap<Integer, Integer> _extramap_, ArrayList<ExtraProBean> _exprolist_, HashMap<Integer, TempExtraProInfo> _extraprops_, ArrayList<Long> _uuid_, ArrayList<FumoInfo> _fumoprolist_, HashMap<Integer, Long> _extrainfomap_, SuperEquipmentCostInfo _super_equipment_cost_bean_, HashMap<Integer, JewelInfo> _jewelmap_) {
/*  35 */     this.id = _id_;
/*  36 */     this.number = _number_;
/*  37 */     this.flag = _flag_;
/*  38 */     this.extramap = _extramap_;
/*  39 */     this.exprolist = _exprolist_;
/*  40 */     this.extraprops = _extraprops_;
/*  41 */     this.uuid = _uuid_;
/*  42 */     this.fumoprolist = _fumoprolist_;
/*  43 */     this.extrainfomap = _extrainfomap_;
/*  44 */     this.super_equipment_cost_bean = _super_equipment_cost_bean_;
/*  45 */     this.jewelmap = _jewelmap_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     for (ExtraProBean _v_ : this.exprolist)
/*  50 */       if (!_v_._validator_()) return false;
/*  51 */     for (java.util.Map.Entry<Integer, TempExtraProInfo> _e_ : this.extraprops.entrySet()) {
/*  52 */       if (!((TempExtraProInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  54 */     for (FumoInfo _v_ : this.fumoprolist)
/*  55 */       if (!_v_._validator_()) return false;
/*  56 */     if (!this.super_equipment_cost_bean._validator_()) return false;
/*  57 */     for (java.util.Map.Entry<Integer, JewelInfo> _e_ : this.jewelmap.entrySet()) {
/*  58 */       if (!((JewelInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  60 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  64 */     _os_.marshal(this.id);
/*  65 */     _os_.marshal(this.number);
/*  66 */     _os_.marshal(this.flag);
/*  67 */     _os_.compact_uint32(this.extramap.size());
/*  68 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.extramap.entrySet()) {
/*  69 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  70 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  72 */     _os_.compact_uint32(this.exprolist.size());
/*  73 */     for (ExtraProBean _v_ : this.exprolist) {
/*  74 */       _os_.marshal(_v_);
/*     */     }
/*  76 */     _os_.compact_uint32(this.extraprops.size());
/*  77 */     for (java.util.Map.Entry<Integer, TempExtraProInfo> _e_ : this.extraprops.entrySet()) {
/*  78 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  79 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  81 */     _os_.compact_uint32(this.uuid.size());
/*  82 */     for (Long _v_ : this.uuid) {
/*  83 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  85 */     _os_.compact_uint32(this.fumoprolist.size());
/*  86 */     for (FumoInfo _v_ : this.fumoprolist) {
/*  87 */       _os_.marshal(_v_);
/*     */     }
/*  89 */     _os_.compact_uint32(this.extrainfomap.size());
/*  90 */     for (java.util.Map.Entry<Integer, Long> _e_ : this.extrainfomap.entrySet()) {
/*  91 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  92 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */     }
/*  94 */     _os_.marshal(this.super_equipment_cost_bean);
/*  95 */     _os_.compact_uint32(this.jewelmap.size());
/*  96 */     for (java.util.Map.Entry<Integer, JewelInfo> _e_ : this.jewelmap.entrySet()) {
/*  97 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  98 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 104 */     this.id = _os_.unmarshal_int();
/* 105 */     this.number = _os_.unmarshal_int();
/* 106 */     this.flag = _os_.unmarshal_int();
/* 107 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 109 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 111 */       int _v_ = _os_.unmarshal_int();
/* 112 */       this.extramap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 114 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 115 */       ExtraProBean _v_ = new ExtraProBean();
/* 116 */       _v_.unmarshal(_os_);
/* 117 */       this.exprolist.add(_v_);
/*     */     }
/* 119 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 121 */       int _k_ = _os_.unmarshal_int();
/* 122 */       TempExtraProInfo _v_ = new TempExtraProInfo();
/* 123 */       _v_.unmarshal(_os_);
/* 124 */       this.extraprops.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 126 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 128 */       long _v_ = _os_.unmarshal_long();
/* 129 */       this.uuid.add(Long.valueOf(_v_));
/*     */     }
/* 131 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 132 */       FumoInfo _v_ = new FumoInfo();
/* 133 */       _v_.unmarshal(_os_);
/* 134 */       this.fumoprolist.add(_v_);
/*     */     }
/* 136 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 138 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 140 */       long _v_ = _os_.unmarshal_long();
/* 141 */       this.extrainfomap.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*     */     }
/* 143 */     this.super_equipment_cost_bean.unmarshal(_os_);
/* 144 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 146 */       int _k_ = _os_.unmarshal_int();
/* 147 */       JewelInfo _v_ = new JewelInfo();
/* 148 */       _v_.unmarshal(_os_);
/* 149 */       this.jewelmap.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 151 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 155 */     if (_o1_ == this) return true;
/* 156 */     if ((_o1_ instanceof ItemInfo)) {
/* 157 */       ItemInfo _o_ = (ItemInfo)_o1_;
/* 158 */       if (this.id != _o_.id) return false;
/* 159 */       if (this.number != _o_.number) return false;
/* 160 */       if (this.flag != _o_.flag) return false;
/* 161 */       if (!this.extramap.equals(_o_.extramap)) return false;
/* 162 */       if (!this.exprolist.equals(_o_.exprolist)) return false;
/* 163 */       if (!this.extraprops.equals(_o_.extraprops)) return false;
/* 164 */       if (!this.uuid.equals(_o_.uuid)) return false;
/* 165 */       if (!this.fumoprolist.equals(_o_.fumoprolist)) return false;
/* 166 */       if (!this.extrainfomap.equals(_o_.extrainfomap)) return false;
/* 167 */       if (!this.super_equipment_cost_bean.equals(_o_.super_equipment_cost_bean)) return false;
/* 168 */       if (!this.jewelmap.equals(_o_.jewelmap)) return false;
/* 169 */       return true;
/*     */     }
/* 171 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 175 */     int _h_ = 0;
/* 176 */     _h_ += this.id;
/* 177 */     _h_ += this.number;
/* 178 */     _h_ += this.flag;
/* 179 */     _h_ += this.extramap.hashCode();
/* 180 */     _h_ += this.exprolist.hashCode();
/* 181 */     _h_ += this.extraprops.hashCode();
/* 182 */     _h_ += this.uuid.hashCode();
/* 183 */     _h_ += this.fumoprolist.hashCode();
/* 184 */     _h_ += this.extrainfomap.hashCode();
/* 185 */     _h_ += this.super_equipment_cost_bean.hashCode();
/* 186 */     _h_ += this.jewelmap.hashCode();
/* 187 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 191 */     StringBuilder _sb_ = new StringBuilder();
/* 192 */     _sb_.append("(");
/* 193 */     _sb_.append(this.id).append(",");
/* 194 */     _sb_.append(this.number).append(",");
/* 195 */     _sb_.append(this.flag).append(",");
/* 196 */     _sb_.append(this.extramap).append(",");
/* 197 */     _sb_.append(this.exprolist).append(",");
/* 198 */     _sb_.append(this.extraprops).append(",");
/* 199 */     _sb_.append(this.uuid).append(",");
/* 200 */     _sb_.append(this.fumoprolist).append(",");
/* 201 */     _sb_.append(this.extrainfomap).append(",");
/* 202 */     _sb_.append(this.super_equipment_cost_bean).append(",");
/* 203 */     _sb_.append(this.jewelmap).append(",");
/* 204 */     _sb_.append(")");
/* 205 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\ItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */