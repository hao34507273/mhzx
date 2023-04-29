/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.item.ItemInfo;
/*     */ import mzm.gsp.pubdata.ModelInfo;
/*     */ 
/*     */ public class PetInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public static final int PET_TYPE_WILD = 0;
/*     */   public static final int PET_TYPE_BAOBAO = 1;
/*     */   public static final int PET_TYPE_BIANYI = 2;
/*     */   public static final int PET_TYPE_SHENSHOU = 3;
/*     */   public static final int PET_TYPE_MOSHOU = 4;
/*     */   public static final int EQUIP_HELMET = 0;
/*     */   public static final int EQUIP_NECKLACE = 1;
/*     */   public static final int EQUIP_AMULET = 2;
/*     */   public long petid;
/*     */   public int typeid;
/*     */   public String petname;
/*     */   public int pettype;
/*     */   public int petlevel;
/*     */   public int life;
/*     */   public int yaoli;
/*     */   public float grow;
/*     */   public int exp;
/*     */   public ModelInfo model;
/*     */   public int hp;
/*     */   public int maxhp;
/*     */   public int mp;
/*     */   public int maxmp;
/*     */   public int phyatk;
/*     */   public int phydef;
/*     */   public int magatk;
/*     */   public int magdef;
/*     */   public int speed;
/*     */   public int bindedstate;
/*     */   public int isdecorated;
/*     */   public int rememberskillid;
/*     */   public PetAptInfo petapt;
/*     */   public LinkedList<Integer> skillidlist;
/*     */   public HashMap<Integer, ItemInfo> equipmap;
/*     */   public HashMap<Integer, Integer> basepropmap;
/*     */   public HashMap<Integer, Integer> autoaddproppref;
/*     */   public int isautoaddflagopen;
/*     */   public int potentialpoint;
/*     */   public int iscanresetprop;
/*     */   public long marketbuytime;
/*     */   public int stagelevel;
/*     */   public int extramodelcfgid;
/*     */   public HashMap<Integer, PetSoulInfo> soulmap;
/*     */   public int petmarkcfgid;
/*     */   public int petmarklevel;
/*     */   public ArrayList<Integer> own_extra_model_cfg_ids;
/*     */   public ArrayList<Integer> extraremember;
/*     */   
/*     */   public PetInfo()
/*     */   {
/*  63 */     this.petname = "";
/*  64 */     this.model = new ModelInfo();
/*  65 */     this.petapt = new PetAptInfo();
/*  66 */     this.skillidlist = new LinkedList();
/*  67 */     this.equipmap = new HashMap();
/*  68 */     this.basepropmap = new HashMap();
/*  69 */     this.autoaddproppref = new HashMap();
/*  70 */     this.soulmap = new HashMap();
/*  71 */     this.own_extra_model_cfg_ids = new ArrayList();
/*  72 */     this.extraremember = new ArrayList();
/*     */   }
/*     */   
/*     */   public PetInfo(long _petid_, int _typeid_, String _petname_, int _pettype_, int _petlevel_, int _life_, int _yaoli_, float _grow_, int _exp_, ModelInfo _model_, int _hp_, int _maxhp_, int _mp_, int _maxmp_, int _phyatk_, int _phydef_, int _magatk_, int _magdef_, int _speed_, int _bindedstate_, int _isdecorated_, int _rememberskillid_, PetAptInfo _petapt_, LinkedList<Integer> _skillidlist_, HashMap<Integer, ItemInfo> _equipmap_, HashMap<Integer, Integer> _basepropmap_, HashMap<Integer, Integer> _autoaddproppref_, int _isautoaddflagopen_, int _potentialpoint_, int _iscanresetprop_, long _marketbuytime_, int _stagelevel_, int _extramodelcfgid_, HashMap<Integer, PetSoulInfo> _soulmap_, int _petmarkcfgid_, int _petmarklevel_, ArrayList<Integer> _own_extra_model_cfg_ids_) {
/*  76 */     this.petid = _petid_;
/*  77 */     this.typeid = _typeid_;
/*  78 */     this.petname = _petname_;
/*  79 */     this.pettype = _pettype_;
/*  80 */     this.petlevel = _petlevel_;
/*  81 */     this.life = _life_;
/*  82 */     this.yaoli = _yaoli_;
/*  83 */     this.grow = _grow_;
/*  84 */     this.exp = _exp_;
/*  85 */     this.model = _model_;
/*  86 */     this.hp = _hp_;
/*  87 */     this.maxhp = _maxhp_;
/*  88 */     this.mp = _mp_;
/*  89 */     this.maxmp = _maxmp_;
/*  90 */     this.phyatk = _phyatk_;
/*  91 */     this.phydef = _phydef_;
/*  92 */     this.magatk = _magatk_;
/*  93 */     this.magdef = _magdef_;
/*  94 */     this.speed = _speed_;
/*  95 */     this.bindedstate = _bindedstate_;
/*  96 */     this.isdecorated = _isdecorated_;
/*  97 */     this.rememberskillid = _rememberskillid_;
/*  98 */     this.petapt = _petapt_;
/*  99 */     this.skillidlist = _skillidlist_;
/* 100 */     this.equipmap = _equipmap_;
/* 101 */     this.basepropmap = _basepropmap_;
/* 102 */     this.autoaddproppref = _autoaddproppref_;
/* 103 */     this.isautoaddflagopen = _isautoaddflagopen_;
/* 104 */     this.potentialpoint = _potentialpoint_;
/* 105 */     this.iscanresetprop = _iscanresetprop_;
/* 106 */     this.marketbuytime = _marketbuytime_;
/* 107 */     this.stagelevel = _stagelevel_;
/* 108 */     this.extramodelcfgid = _extramodelcfgid_;
/* 109 */     this.soulmap = _soulmap_;
/* 110 */     this.petmarkcfgid = _petmarkcfgid_;
/* 111 */     this.petmarklevel = _petmarklevel_;
/* 112 */     this.own_extra_model_cfg_ids = _own_extra_model_cfg_ids_;
/* 113 */     this.extraremember = new ArrayList();
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/* 117 */     if ((!this.model._validator_()) || (!this.petapt._validator_())) {
/* 118 */       return false;
/*     */     }
/* 120 */     for (Map.Entry<Integer, ItemInfo> _e_ : this.equipmap.entrySet()) {
/* 121 */       if (!((ItemInfo)_e_.getValue())._validator_()) {
/* 122 */         return false;
/*     */       }
/*     */     }
/* 125 */     for (Map.Entry<Integer, PetSoulInfo> _e_2 : this.soulmap.entrySet()) {
/* 126 */       if (!((PetSoulInfo)_e_2.getValue())._validator_()) {
/* 127 */         return false;
/*     */       }
/*     */     }
/* 130 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/* 134 */     _os_.marshal(this.petid);
/* 135 */     _os_.marshal(this.typeid);
/* 136 */     _os_.marshal(this.petname, "UTF-16LE");
/* 137 */     _os_.marshal(this.pettype);
/* 138 */     _os_.marshal(this.petlevel);
/* 139 */     _os_.marshal(this.life);
/* 140 */     _os_.marshal(this.yaoli);
/* 141 */     _os_.marshal(this.grow);
/* 142 */     _os_.marshal(this.exp);
/* 143 */     _os_.marshal(this.model);
/* 144 */     _os_.marshal(this.hp);
/* 145 */     _os_.marshal(this.maxhp);
/* 146 */     _os_.marshal(this.mp);
/* 147 */     _os_.marshal(this.maxmp);
/* 148 */     _os_.marshal(this.phyatk);
/* 149 */     _os_.marshal(this.phydef);
/* 150 */     _os_.marshal(this.magatk);
/* 151 */     _os_.marshal(this.magdef);
/* 152 */     _os_.marshal(this.speed);
/* 153 */     _os_.marshal(this.bindedstate);
/* 154 */     _os_.marshal(this.isdecorated);
/* 155 */     _os_.marshal(this.rememberskillid);
/* 156 */     _os_.marshal(this.petapt);
/* 157 */     _os_.compact_uint32(this.skillidlist.size());
/* 158 */     Iterator<Integer> i$ = this.skillidlist.iterator();
/* 159 */     while (i$.hasNext()) {
/* 160 */       Integer _v_ = (Integer)i$.next();
/* 161 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 163 */     _os_.compact_uint32(this.equipmap.size());
/* 164 */     for (Map.Entry<Integer, ItemInfo> _e_ : this.equipmap.entrySet()) {
/* 165 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 166 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 168 */     _os_.compact_uint32(this.basepropmap.size());
/* 169 */     for (Map.Entry<Integer, Integer> _e_2 : this.basepropmap.entrySet()) {
/* 170 */       _os_.marshal(((Integer)_e_2.getKey()).intValue());
/* 171 */       _os_.marshal(((Integer)_e_2.getValue()).intValue());
/*     */     }
/* 173 */     _os_.compact_uint32(this.autoaddproppref.size());
/* 174 */     for (Map.Entry<Integer, Integer> _e_3 : this.autoaddproppref.entrySet()) {
/* 175 */       _os_.marshal(((Integer)_e_3.getKey()).intValue());
/* 176 */       _os_.marshal(((Integer)_e_3.getValue()).intValue());
/*     */     }
/* 178 */     _os_.marshal(this.isautoaddflagopen);
/* 179 */     _os_.marshal(this.potentialpoint);
/* 180 */     _os_.marshal(this.iscanresetprop);
/* 181 */     _os_.marshal(this.marketbuytime);
/* 182 */     _os_.marshal(this.stagelevel);
/* 183 */     _os_.marshal(this.extramodelcfgid);
/* 184 */     _os_.compact_uint32(this.soulmap.size());
/* 185 */     for (Map.Entry<Integer, PetSoulInfo> _e_4 : this.soulmap.entrySet()) {
/* 186 */       _os_.marshal(((Integer)_e_4.getKey()).intValue());
/* 187 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_4.getValue());
/*     */     }
/* 189 */     _os_.marshal(this.petmarkcfgid);
/* 190 */     _os_.marshal(this.petmarklevel);
/* 191 */     _os_.compact_uint32(this.own_extra_model_cfg_ids.size());
/* 192 */     Iterator<Integer> i$2 = this.own_extra_model_cfg_ids.iterator();
/* 193 */     while (i$2.hasNext()) {
/* 194 */       Integer _v_2 = (Integer)i$2.next();
/* 195 */       _os_.marshal(_v_2.intValue());
/*     */     }
/*     */     
/* 198 */     _os_.compact_uint32(this.extraremember.size());
/* 199 */     Iterator<Integer> i$3 = this.extraremember.iterator();
/* 200 */     while (i$3.hasNext()) {
/* 201 */       Integer _v_2 = (Integer)i$3.next();
/* 202 */       _os_.marshal(_v_2.intValue());
/*     */     }
/* 204 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 208 */     this.petid = _os_.unmarshal_long();
/* 209 */     this.typeid = _os_.unmarshal_int();
/* 210 */     this.petname = _os_.unmarshal_String("UTF-16LE");
/* 211 */     this.pettype = _os_.unmarshal_int();
/* 212 */     this.petlevel = _os_.unmarshal_int();
/* 213 */     this.life = _os_.unmarshal_int();
/* 214 */     this.yaoli = _os_.unmarshal_int();
/* 215 */     this.grow = _os_.unmarshal_float();
/* 216 */     this.exp = _os_.unmarshal_int();
/* 217 */     this.model.unmarshal(_os_);
/* 218 */     this.hp = _os_.unmarshal_int();
/* 219 */     this.maxhp = _os_.unmarshal_int();
/* 220 */     this.mp = _os_.unmarshal_int();
/* 221 */     this.maxmp = _os_.unmarshal_int();
/* 222 */     this.phyatk = _os_.unmarshal_int();
/* 223 */     this.phydef = _os_.unmarshal_int();
/* 224 */     this.magatk = _os_.unmarshal_int();
/* 225 */     this.magdef = _os_.unmarshal_int();
/* 226 */     this.speed = _os_.unmarshal_int();
/* 227 */     this.bindedstate = _os_.unmarshal_int();
/* 228 */     this.isdecorated = _os_.unmarshal_int();
/* 229 */     this.rememberskillid = _os_.unmarshal_int();
/* 230 */     this.petapt.unmarshal(_os_);
/* 231 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 232 */       this.skillidlist.add(Integer.valueOf(_os_.unmarshal_int()));
/*     */     }
/* 234 */     for (int size = _os_.uncompact_uint32(); size > 0; size--) {
/* 235 */       int _k_ = _os_.unmarshal_int();
/* 236 */       ItemInfo _v_ = new ItemInfo();
/* 237 */       _v_.unmarshal(_os_);
/* 238 */       this.equipmap.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 240 */     for (int size2 = _os_.uncompact_uint32(); size2 > 0; size2--) {
/* 241 */       int _k_2 = _os_.unmarshal_int();
/* 242 */       this.basepropmap.put(Integer.valueOf(_k_2), Integer.valueOf(_os_.unmarshal_int()));
/*     */     }
/* 244 */     for (int size3 = _os_.uncompact_uint32(); size3 > 0; size3--) {
/* 245 */       int _k_3 = _os_.unmarshal_int();
/* 246 */       this.autoaddproppref.put(Integer.valueOf(_k_3), Integer.valueOf(_os_.unmarshal_int()));
/*     */     }
/* 248 */     this.isautoaddflagopen = _os_.unmarshal_int();
/* 249 */     this.potentialpoint = _os_.unmarshal_int();
/* 250 */     this.iscanresetprop = _os_.unmarshal_int();
/* 251 */     this.marketbuytime = _os_.unmarshal_long();
/* 252 */     this.stagelevel = _os_.unmarshal_int();
/* 253 */     this.extramodelcfgid = _os_.unmarshal_int();
/* 254 */     for (int size4 = _os_.uncompact_uint32(); size4 > 0; size4--) {
/* 255 */       int _k_4 = _os_.unmarshal_int();
/* 256 */       PetSoulInfo _v_2 = new PetSoulInfo();
/* 257 */       _v_2.unmarshal(_os_);
/* 258 */       this.soulmap.put(Integer.valueOf(_k_4), _v_2);
/*     */     }
/* 260 */     this.petmarkcfgid = _os_.unmarshal_int();
/* 261 */     this.petmarklevel = _os_.unmarshal_int();
/* 262 */     for (int _size_2 = _os_.uncompact_uint32(); _size_2 > 0; _size_2--) {
/* 263 */       this.own_extra_model_cfg_ids.add(Integer.valueOf(_os_.unmarshal_int()));
/*     */     }
/* 265 */     for (int _size_2 = _os_.uncompact_uint32(); _size_2 > 0; _size_2--) {
/* 266 */       this.extraremember.add(Integer.valueOf(_os_.unmarshal_int()));
/*     */     }
/* 268 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 272 */     if (_o1_ == this) {
/* 273 */       return true;
/*     */     }
/* 275 */     if (!(_o1_ instanceof PetInfo)) {
/* 276 */       return false;
/*     */     }
/* 278 */     PetInfo _o_ = (PetInfo)_o1_;
/* 279 */     return (this.petid == _o_.petid) && (this.typeid == _o_.typeid) && (this.petname.equals(_o_.petname)) && (this.pettype == _o_.pettype) && (this.petlevel == _o_.petlevel) && (this.life == _o_.life) && (this.yaoli == _o_.yaoli) && (this.grow == _o_.grow) && (this.exp == _o_.exp) && (this.model.equals(_o_.model)) && (this.hp == _o_.hp) && (this.maxhp == _o_.maxhp) && (this.mp == _o_.mp) && (this.maxmp == _o_.maxmp) && (this.phyatk == _o_.phyatk) && (this.phydef == _o_.phydef) && (this.magatk == _o_.magatk) && (this.magdef == _o_.magdef) && (this.speed == _o_.speed) && (this.bindedstate == _o_.bindedstate) && (this.isdecorated == _o_.isdecorated) && (this.rememberskillid == _o_.rememberskillid) && (this.petapt.equals(_o_.petapt)) && (this.skillidlist.equals(_o_.skillidlist)) && (this.equipmap.equals(_o_.equipmap)) && (this.basepropmap.equals(_o_.basepropmap)) && (this.autoaddproppref.equals(_o_.autoaddproppref)) && (this.isautoaddflagopen == _o_.isautoaddflagopen) && (this.potentialpoint == _o_.potentialpoint) && (this.iscanresetprop == _o_.iscanresetprop) && (this.marketbuytime == _o_.marketbuytime) && (this.stagelevel == _o_.stagelevel) && (this.extramodelcfgid == _o_.extramodelcfgid) && (this.soulmap.equals(_o_.soulmap)) && (this.petmarkcfgid == _o_.petmarkcfgid) && (this.petmarklevel == _o_.petmarklevel) && (this.own_extra_model_cfg_ids.equals(_o_.own_extra_model_cfg_ids)) && (this.extraremember.equals(_o_.extraremember));
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 283 */     int _h_ = 0 + (int)this.petid;
/* 284 */     return _h_ + this.extraremember.hashCode() + this.typeid + this.petname.hashCode() + this.pettype + this.petlevel + this.life + this.yaoli + Float.floatToIntBits(this.grow) + this.exp + this.model.hashCode() + this.hp + this.maxhp + this.mp + this.maxmp + this.phyatk + this.phydef + this.magatk + this.magdef + this.speed + this.bindedstate + this.isdecorated + this.rememberskillid + this.petapt.hashCode() + this.skillidlist.hashCode() + this.equipmap.hashCode() + this.basepropmap.hashCode() + this.autoaddproppref.hashCode() + this.isautoaddflagopen + this.potentialpoint + this.iscanresetprop + (int)this.marketbuytime + this.stagelevel + this.extramodelcfgid + this.soulmap.hashCode() + this.petmarkcfgid + this.petmarklevel + this.own_extra_model_cfg_ids.hashCode();
/*     */   }
/*     */   
/*     */   public String toString() {
/* 288 */     StringBuilder _sb_ = new StringBuilder();
/* 289 */     _sb_.append("(");
/* 290 */     _sb_.append(this.petid).append(",");
/* 291 */     _sb_.append(this.typeid).append(",");
/* 292 */     _sb_.append("T").append(this.petname.length()).append(",");
/* 293 */     _sb_.append(this.pettype).append(",");
/* 294 */     _sb_.append(this.petlevel).append(",");
/* 295 */     _sb_.append(this.life).append(",");
/* 296 */     _sb_.append(this.yaoli).append(",");
/* 297 */     _sb_.append(this.grow).append(",");
/* 298 */     _sb_.append(this.exp).append(",");
/* 299 */     _sb_.append(this.model).append(",");
/* 300 */     _sb_.append(this.hp).append(",");
/* 301 */     _sb_.append(this.maxhp).append(",");
/* 302 */     _sb_.append(this.mp).append(",");
/* 303 */     _sb_.append(this.maxmp).append(",");
/* 304 */     _sb_.append(this.phyatk).append(",");
/* 305 */     _sb_.append(this.phydef).append(",");
/* 306 */     _sb_.append(this.magatk).append(",");
/* 307 */     _sb_.append(this.magdef).append(",");
/* 308 */     _sb_.append(this.speed).append(",");
/* 309 */     _sb_.append(this.bindedstate).append(",");
/* 310 */     _sb_.append(this.isdecorated).append(",");
/* 311 */     _sb_.append(this.rememberskillid).append(",");
/* 312 */     _sb_.append(this.petapt).append(",");
/* 313 */     _sb_.append(this.skillidlist).append(",");
/* 314 */     _sb_.append(this.equipmap).append(",");
/* 315 */     _sb_.append(this.basepropmap).append(",");
/* 316 */     _sb_.append(this.autoaddproppref).append(",");
/* 317 */     _sb_.append(this.isautoaddflagopen).append(",");
/* 318 */     _sb_.append(this.potentialpoint).append(",");
/* 319 */     _sb_.append(this.iscanresetprop).append(",");
/* 320 */     _sb_.append(this.marketbuytime).append(",");
/* 321 */     _sb_.append(this.stagelevel).append(",");
/* 322 */     _sb_.append(this.extramodelcfgid).append(",");
/* 323 */     _sb_.append(this.soulmap).append(",");
/* 324 */     _sb_.append(this.petmarkcfgid).append(",");
/* 325 */     _sb_.append(this.petmarklevel).append(",");
/* 326 */     _sb_.append(this.own_extra_model_cfg_ids).append(",");
/* 327 */     _sb_.append(this.extraremember).append(",");
/* 328 */     _sb_.append(")");
/* 329 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\PetInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */