/*     */ package mzm.gsp.children;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ public class AdulthoodInfo implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int occupation;
/*     */   public HashMap<Integer, Integer> aptitudeinitmap;
/*     */   public int useaptitudeitemcount;
/*     */   public int usegrowthitemcount;
/*     */   public HashMap<Integer, Integer> occupationskill2value;
/*     */   public java.util.ArrayList<Integer> fightskills;
/*     */   public java.util.ArrayList<Integer> skillbookskills;
/*     */   public int specialskillid;
/*     */   public HashMap<Integer, Integer> propset;
/*     */   public int potentialpoint;
/*     */   public int hp;
/*     */   public int mp;
/*     */   public float grow;
/*     */   public int unlockskillposnum;
/*     */   public HashMap<Integer, Integer> propmap;
/*     */   public int character;
/*     */   public int level;
/*     */   public HashMap<Integer, mzm.gsp.item.ItemInfo> equipitem;
/*     */   public HashMap<Integer, mzm.gsp.item.ItemInfo> equippetitem;
/*     */   
/*     */   public AdulthoodInfo()
/*     */   {
/*  30 */     this.occupation = -1;
/*  31 */     this.aptitudeinitmap = new HashMap();
/*  32 */     this.occupationskill2value = new HashMap();
/*  33 */     this.fightskills = new java.util.ArrayList();
/*  34 */     this.skillbookskills = new java.util.ArrayList();
/*  35 */     this.propset = new HashMap();
/*  36 */     this.propmap = new HashMap();
/*  37 */     this.equipitem = new HashMap();
/*  38 */     this.equippetitem = new HashMap();
/*     */   }
/*     */   
/*     */   public AdulthoodInfo(int _occupation_, HashMap<Integer, Integer> _aptitudeinitmap_, int _useaptitudeitemcount_, int _usegrowthitemcount_, HashMap<Integer, Integer> _occupationskill2value_, java.util.ArrayList<Integer> _fightskills_, java.util.ArrayList<Integer> _skillbookskills_, int _specialskillid_, HashMap<Integer, Integer> _propset_, int _potentialpoint_, int _hp_, int _mp_, float _grow_, int _unlockskillposnum_, HashMap<Integer, Integer> _propmap_, int _character_, int _level_, HashMap<Integer, mzm.gsp.item.ItemInfo> _equipitem_, HashMap<Integer, mzm.gsp.item.ItemInfo> _equippetitem_) {
/*  42 */     this.occupation = _occupation_;
/*  43 */     this.aptitudeinitmap = _aptitudeinitmap_;
/*  44 */     this.useaptitudeitemcount = _useaptitudeitemcount_;
/*  45 */     this.usegrowthitemcount = _usegrowthitemcount_;
/*  46 */     this.occupationskill2value = _occupationskill2value_;
/*  47 */     this.fightskills = _fightskills_;
/*  48 */     this.skillbookskills = _skillbookskills_;
/*  49 */     this.specialskillid = _specialskillid_;
/*  50 */     this.propset = _propset_;
/*  51 */     this.potentialpoint = _potentialpoint_;
/*  52 */     this.hp = _hp_;
/*  53 */     this.mp = _mp_;
/*  54 */     this.grow = _grow_;
/*  55 */     this.unlockskillposnum = _unlockskillposnum_;
/*  56 */     this.propmap = _propmap_;
/*  57 */     this.character = _character_;
/*  58 */     this.level = _level_;
/*  59 */     this.equipitem = _equipitem_;
/*  60 */     this.equippetitem = _equippetitem_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  64 */     for (java.util.Map.Entry<Integer, mzm.gsp.item.ItemInfo> _e_ : this.equipitem.entrySet()) {
/*  65 */       if (!((mzm.gsp.item.ItemInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  67 */     for (java.util.Map.Entry<Integer, mzm.gsp.item.ItemInfo> _e_ : this.equippetitem.entrySet()) {
/*  68 */       if (!((mzm.gsp.item.ItemInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  70 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  74 */     _os_.marshal(this.occupation);
/*  75 */     _os_.compact_uint32(this.aptitudeinitmap.size());
/*  76 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.aptitudeinitmap.entrySet()) {
/*  77 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  78 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  80 */     _os_.marshal(this.useaptitudeitemcount);
/*  81 */     _os_.marshal(this.usegrowthitemcount);
/*  82 */     _os_.compact_uint32(this.occupationskill2value.size());
/*  83 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.occupationskill2value.entrySet()) {
/*  84 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  85 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  87 */     _os_.compact_uint32(this.fightskills.size());
/*  88 */     for (Integer _v_ : this.fightskills) {
/*  89 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  91 */     _os_.compact_uint32(this.skillbookskills.size());
/*  92 */     for (Integer _v_ : this.skillbookskills) {
/*  93 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  95 */     _os_.marshal(this.specialskillid);
/*  96 */     _os_.compact_uint32(this.propset.size());
/*  97 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.propset.entrySet()) {
/*  98 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  99 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 101 */     _os_.marshal(this.potentialpoint);
/* 102 */     _os_.marshal(this.hp);
/* 103 */     _os_.marshal(this.mp);
/* 104 */     _os_.marshal(this.grow);
/* 105 */     _os_.marshal(this.unlockskillposnum);
/* 106 */     _os_.compact_uint32(this.propmap.size());
/* 107 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.propmap.entrySet()) {
/* 108 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 109 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 111 */     _os_.marshal(this.character);
/* 112 */     _os_.marshal(this.level);
/* 113 */     _os_.compact_uint32(this.equipitem.size());
/* 114 */     for (java.util.Map.Entry<Integer, mzm.gsp.item.ItemInfo> _e_ : this.equipitem.entrySet()) {
/* 115 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 116 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 118 */     _os_.compact_uint32(this.equippetitem.size());
/* 119 */     for (java.util.Map.Entry<Integer, mzm.gsp.item.ItemInfo> _e_ : this.equippetitem.entrySet()) {
/* 120 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 121 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/* 123 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 127 */     this.occupation = _os_.unmarshal_int();
/* 128 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 130 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 132 */       int _v_ = _os_.unmarshal_int();
/* 133 */       this.aptitudeinitmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 135 */     this.useaptitudeitemcount = _os_.unmarshal_int();
/* 136 */     this.usegrowthitemcount = _os_.unmarshal_int();
/* 137 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 139 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 141 */       int _v_ = _os_.unmarshal_int();
/* 142 */       this.occupationskill2value.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 144 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 146 */       int _v_ = _os_.unmarshal_int();
/* 147 */       this.fightskills.add(Integer.valueOf(_v_));
/*     */     }
/* 149 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 151 */       int _v_ = _os_.unmarshal_int();
/* 152 */       this.skillbookskills.add(Integer.valueOf(_v_));
/*     */     }
/* 154 */     this.specialskillid = _os_.unmarshal_int();
/* 155 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 157 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 159 */       int _v_ = _os_.unmarshal_int();
/* 160 */       this.propset.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 162 */     this.potentialpoint = _os_.unmarshal_int();
/* 163 */     this.hp = _os_.unmarshal_int();
/* 164 */     this.mp = _os_.unmarshal_int();
/* 165 */     this.grow = _os_.unmarshal_float();
/* 166 */     this.unlockskillposnum = _os_.unmarshal_int();
/* 167 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 169 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 171 */       int _v_ = _os_.unmarshal_int();
/* 172 */       this.propmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 174 */     this.character = _os_.unmarshal_int();
/* 175 */     this.level = _os_.unmarshal_int();
/* 176 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 178 */       int _k_ = _os_.unmarshal_int();
/* 179 */       mzm.gsp.item.ItemInfo _v_ = new mzm.gsp.item.ItemInfo();
/* 180 */       _v_.unmarshal(_os_);
/* 181 */       this.equipitem.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 183 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 185 */       int _k_ = _os_.unmarshal_int();
/* 186 */       mzm.gsp.item.ItemInfo _v_ = new mzm.gsp.item.ItemInfo();
/* 187 */       _v_.unmarshal(_os_);
/* 188 */       this.equippetitem.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 190 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 194 */     if (_o1_ == this) return true;
/* 195 */     if ((_o1_ instanceof AdulthoodInfo)) {
/* 196 */       AdulthoodInfo _o_ = (AdulthoodInfo)_o1_;
/* 197 */       if (this.occupation != _o_.occupation) return false;
/* 198 */       if (!this.aptitudeinitmap.equals(_o_.aptitudeinitmap)) return false;
/* 199 */       if (this.useaptitudeitemcount != _o_.useaptitudeitemcount) return false;
/* 200 */       if (this.usegrowthitemcount != _o_.usegrowthitemcount) return false;
/* 201 */       if (!this.occupationskill2value.equals(_o_.occupationskill2value)) return false;
/* 202 */       if (!this.fightskills.equals(_o_.fightskills)) return false;
/* 203 */       if (!this.skillbookskills.equals(_o_.skillbookskills)) return false;
/* 204 */       if (this.specialskillid != _o_.specialskillid) return false;
/* 205 */       if (!this.propset.equals(_o_.propset)) return false;
/* 206 */       if (this.potentialpoint != _o_.potentialpoint) return false;
/* 207 */       if (this.hp != _o_.hp) return false;
/* 208 */       if (this.mp != _o_.mp) return false;
/* 209 */       if (this.grow != _o_.grow) return false;
/* 210 */       if (this.unlockskillposnum != _o_.unlockskillposnum) return false;
/* 211 */       if (!this.propmap.equals(_o_.propmap)) return false;
/* 212 */       if (this.character != _o_.character) return false;
/* 213 */       if (this.level != _o_.level) return false;
/* 214 */       if (!this.equipitem.equals(_o_.equipitem)) return false;
/* 215 */       if (!this.equippetitem.equals(_o_.equippetitem)) return false;
/* 216 */       return true;
/*     */     }
/* 218 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 222 */     int _h_ = 0;
/* 223 */     _h_ += this.occupation;
/* 224 */     _h_ += this.aptitudeinitmap.hashCode();
/* 225 */     _h_ += this.useaptitudeitemcount;
/* 226 */     _h_ += this.usegrowthitemcount;
/* 227 */     _h_ += this.occupationskill2value.hashCode();
/* 228 */     _h_ += this.fightskills.hashCode();
/* 229 */     _h_ += this.skillbookskills.hashCode();
/* 230 */     _h_ += this.specialskillid;
/* 231 */     _h_ += this.propset.hashCode();
/* 232 */     _h_ += this.potentialpoint;
/* 233 */     _h_ += this.hp;
/* 234 */     _h_ += this.mp;
/* 235 */     _h_ += Float.floatToIntBits(this.grow);
/* 236 */     _h_ += this.unlockskillposnum;
/* 237 */     _h_ += this.propmap.hashCode();
/* 238 */     _h_ += this.character;
/* 239 */     _h_ += this.level;
/* 240 */     _h_ += this.equipitem.hashCode();
/* 241 */     _h_ += this.equippetitem.hashCode();
/* 242 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 246 */     StringBuilder _sb_ = new StringBuilder();
/* 247 */     _sb_.append("(");
/* 248 */     _sb_.append(this.occupation).append(",");
/* 249 */     _sb_.append(this.aptitudeinitmap).append(",");
/* 250 */     _sb_.append(this.useaptitudeitemcount).append(",");
/* 251 */     _sb_.append(this.usegrowthitemcount).append(",");
/* 252 */     _sb_.append(this.occupationskill2value).append(",");
/* 253 */     _sb_.append(this.fightskills).append(",");
/* 254 */     _sb_.append(this.skillbookskills).append(",");
/* 255 */     _sb_.append(this.specialskillid).append(",");
/* 256 */     _sb_.append(this.propset).append(",");
/* 257 */     _sb_.append(this.potentialpoint).append(",");
/* 258 */     _sb_.append(this.hp).append(",");
/* 259 */     _sb_.append(this.mp).append(",");
/* 260 */     _sb_.append(this.grow).append(",");
/* 261 */     _sb_.append(this.unlockskillposnum).append(",");
/* 262 */     _sb_.append(this.propmap).append(",");
/* 263 */     _sb_.append(this.character).append(",");
/* 264 */     _sb_.append(this.level).append(",");
/* 265 */     _sb_.append(this.equipitem).append(",");
/* 266 */     _sb_.append(this.equippetitem).append(",");
/* 267 */     _sb_.append(")");
/* 268 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\AdulthoodInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */