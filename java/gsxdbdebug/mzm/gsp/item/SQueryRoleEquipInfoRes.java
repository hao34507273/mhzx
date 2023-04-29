/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import mzm.gsp.wing.WingSimpleData;
/*     */ 
/*     */ public class SQueryRoleEquipInfoRes extends __SQueryRoleEquipInfoRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584832;
/*     */   public long roleid;
/*     */   public String rolename;
/*     */   public int ocpid;
/*     */   public int level;
/*     */   public HashMap<Integer, ItemInfo> items;
/*     */   public mzm.gsp.pubdata.ModelInfo modelinfo;
/*     */   public ArrayList<WingSimpleData> winginfos;
/*     */   public ArrayList<ItemInfo> fabaoinfos;
/*     */   public mzm.gsp.aircraft.AircraftDataInfo aircraft;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12584832;
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
/*     */   public SQueryRoleEquipInfoRes()
/*     */   {
/*  39 */     this.rolename = "";
/*  40 */     this.items = new HashMap();
/*  41 */     this.modelinfo = new mzm.gsp.pubdata.ModelInfo();
/*  42 */     this.winginfos = new ArrayList();
/*  43 */     this.fabaoinfos = new ArrayList();
/*  44 */     this.aircraft = new mzm.gsp.aircraft.AircraftDataInfo();
/*     */   }
/*     */   
/*     */   public SQueryRoleEquipInfoRes(long _roleid_, String _rolename_, int _ocpid_, int _level_, HashMap<Integer, ItemInfo> _items_, mzm.gsp.pubdata.ModelInfo _modelinfo_, ArrayList<WingSimpleData> _winginfos_, ArrayList<ItemInfo> _fabaoinfos_, mzm.gsp.aircraft.AircraftDataInfo _aircraft_) {
/*  48 */     this.roleid = _roleid_;
/*  49 */     this.rolename = _rolename_;
/*  50 */     this.ocpid = _ocpid_;
/*  51 */     this.level = _level_;
/*  52 */     this.items = _items_;
/*  53 */     this.modelinfo = _modelinfo_;
/*  54 */     this.winginfos = _winginfos_;
/*  55 */     this.fabaoinfos = _fabaoinfos_;
/*  56 */     this.aircraft = _aircraft_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  60 */     for (java.util.Map.Entry<Integer, ItemInfo> _e_ : this.items.entrySet()) {
/*  61 */       if (!((ItemInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  63 */     if (!this.modelinfo._validator_()) return false;
/*  64 */     for (WingSimpleData _v_ : this.winginfos)
/*  65 */       if (!_v_._validator_()) return false;
/*  66 */     for (ItemInfo _v_ : this.fabaoinfos)
/*  67 */       if (!_v_._validator_()) return false;
/*  68 */     if (!this.aircraft._validator_()) return false;
/*  69 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  73 */     _os_.marshal(this.roleid);
/*  74 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  75 */     _os_.marshal(this.ocpid);
/*  76 */     _os_.marshal(this.level);
/*  77 */     _os_.compact_uint32(this.items.size());
/*  78 */     for (java.util.Map.Entry<Integer, ItemInfo> _e_ : this.items.entrySet()) {
/*  79 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  80 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  82 */     _os_.marshal(this.modelinfo);
/*  83 */     _os_.compact_uint32(this.winginfos.size());
/*  84 */     for (WingSimpleData _v_ : this.winginfos) {
/*  85 */       _os_.marshal(_v_);
/*     */     }
/*  87 */     _os_.compact_uint32(this.fabaoinfos.size());
/*  88 */     for (ItemInfo _v_ : this.fabaoinfos) {
/*  89 */       _os_.marshal(_v_);
/*     */     }
/*  91 */     _os_.marshal(this.aircraft);
/*  92 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  96 */     this.roleid = _os_.unmarshal_long();
/*  97 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  98 */     this.ocpid = _os_.unmarshal_int();
/*  99 */     this.level = _os_.unmarshal_int();
/* 100 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 102 */       int _k_ = _os_.unmarshal_int();
/* 103 */       ItemInfo _v_ = new ItemInfo();
/* 104 */       _v_.unmarshal(_os_);
/* 105 */       this.items.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 107 */     this.modelinfo.unmarshal(_os_);
/* 108 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 109 */       WingSimpleData _v_ = new WingSimpleData();
/* 110 */       _v_.unmarshal(_os_);
/* 111 */       this.winginfos.add(_v_);
/*     */     }
/* 113 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 114 */       ItemInfo _v_ = new ItemInfo();
/* 115 */       _v_.unmarshal(_os_);
/* 116 */       this.fabaoinfos.add(_v_);
/*     */     }
/* 118 */     this.aircraft.unmarshal(_os_);
/* 119 */     if (!_validator_()) {
/* 120 */       throw new VerifyError("validator failed");
/*     */     }
/* 122 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 126 */     if (_o1_ == this) return true;
/* 127 */     if ((_o1_ instanceof SQueryRoleEquipInfoRes)) {
/* 128 */       SQueryRoleEquipInfoRes _o_ = (SQueryRoleEquipInfoRes)_o1_;
/* 129 */       if (this.roleid != _o_.roleid) return false;
/* 130 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 131 */       if (this.ocpid != _o_.ocpid) return false;
/* 132 */       if (this.level != _o_.level) return false;
/* 133 */       if (!this.items.equals(_o_.items)) return false;
/* 134 */       if (!this.modelinfo.equals(_o_.modelinfo)) return false;
/* 135 */       if (!this.winginfos.equals(_o_.winginfos)) return false;
/* 136 */       if (!this.fabaoinfos.equals(_o_.fabaoinfos)) return false;
/* 137 */       if (!this.aircraft.equals(_o_.aircraft)) return false;
/* 138 */       return true;
/*     */     }
/* 140 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 144 */     int _h_ = 0;
/* 145 */     _h_ += (int)this.roleid;
/* 146 */     _h_ += this.rolename.hashCode();
/* 147 */     _h_ += this.ocpid;
/* 148 */     _h_ += this.level;
/* 149 */     _h_ += this.items.hashCode();
/* 150 */     _h_ += this.modelinfo.hashCode();
/* 151 */     _h_ += this.winginfos.hashCode();
/* 152 */     _h_ += this.fabaoinfos.hashCode();
/* 153 */     _h_ += this.aircraft.hashCode();
/* 154 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 158 */     StringBuilder _sb_ = new StringBuilder();
/* 159 */     _sb_.append("(");
/* 160 */     _sb_.append(this.roleid).append(",");
/* 161 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 162 */     _sb_.append(this.ocpid).append(",");
/* 163 */     _sb_.append(this.level).append(",");
/* 164 */     _sb_.append(this.items).append(",");
/* 165 */     _sb_.append(this.modelinfo).append(",");
/* 166 */     _sb_.append(this.winginfos).append(",");
/* 167 */     _sb_.append(this.fabaoinfos).append(",");
/* 168 */     _sb_.append(this.aircraft).append(",");
/* 169 */     _sb_.append(")");
/* 170 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SQueryRoleEquipInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */