/*     */ package mzm.gsp.partner;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class Property implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public int hp;
/*     */   public int maxhp;
/*     */   public int mp;
/*     */   public int maxmp;
/*     */   public int phyatk;
/*     */   public int phydef;
/*     */   public int magatk;
/*     */   public int magdef;
/*     */   public int speed;
/*     */   public int magcrt;
/*     */   public int phycrt;
/*     */   public int sealres;
/*     */   public int fightvalue;
/*     */   public ArrayList<Integer> skills;
/*     */   public ArrayList<Integer> loves;
/*     */   public ArrayList<Integer> lovestoreplace;
/*     */   public int yuanlv;
/*     */   public ArrayList<Integer> levels;
/*     */   public HashMap<Integer, Integer> skillinfos;
/*     */   
/*     */   public Property()
/*     */   {
/*  32 */     this.skills = new ArrayList();
/*  33 */     this.loves = new ArrayList();
/*  34 */     this.lovestoreplace = new ArrayList();
/*  35 */     this.levels = new ArrayList();
/*  36 */     this.skillinfos = new HashMap();
/*     */   }
/*     */   
/*     */   public Property(int _hp_, int _maxhp_, int _mp_, int _maxmp_, int _phyatk_, int _phydef_, int _magatk_, int _magdef_, int _speed_, int _magcrt_, int _phycrt_, int _sealres_, int _fightvalue_, ArrayList<Integer> _skills_, ArrayList<Integer> _loves_, ArrayList<Integer> _lovestoreplace_, int _yuanlv_, ArrayList<Integer> _levels_, HashMap<Integer, Integer> _skillinfos_) {
/*  40 */     this.hp = _hp_;
/*  41 */     this.maxhp = _maxhp_;
/*  42 */     this.mp = _mp_;
/*  43 */     this.maxmp = _maxmp_;
/*  44 */     this.phyatk = _phyatk_;
/*  45 */     this.phydef = _phydef_;
/*  46 */     this.magatk = _magatk_;
/*  47 */     this.magdef = _magdef_;
/*  48 */     this.speed = _speed_;
/*  49 */     this.magcrt = _magcrt_;
/*  50 */     this.phycrt = _phycrt_;
/*  51 */     this.sealres = _sealres_;
/*  52 */     this.fightvalue = _fightvalue_;
/*  53 */     this.skills = _skills_;
/*  54 */     this.loves = _loves_;
/*  55 */     this.lovestoreplace = _lovestoreplace_;
/*  56 */     this.yuanlv = _yuanlv_;
/*  57 */     this.levels = _levels_;
/*  58 */     this.skillinfos = _skillinfos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  62 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  66 */     _os_.marshal(this.hp);
/*  67 */     _os_.marshal(this.maxhp);
/*  68 */     _os_.marshal(this.mp);
/*  69 */     _os_.marshal(this.maxmp);
/*  70 */     _os_.marshal(this.phyatk);
/*  71 */     _os_.marshal(this.phydef);
/*  72 */     _os_.marshal(this.magatk);
/*  73 */     _os_.marshal(this.magdef);
/*  74 */     _os_.marshal(this.speed);
/*  75 */     _os_.marshal(this.magcrt);
/*  76 */     _os_.marshal(this.phycrt);
/*  77 */     _os_.marshal(this.sealres);
/*  78 */     _os_.marshal(this.fightvalue);
/*  79 */     _os_.compact_uint32(this.skills.size());
/*  80 */     for (Integer _v_ : this.skills) {
/*  81 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  83 */     _os_.compact_uint32(this.loves.size());
/*  84 */     for (Integer _v_ : this.loves) {
/*  85 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  87 */     _os_.compact_uint32(this.lovestoreplace.size());
/*  88 */     for (Integer _v_ : this.lovestoreplace) {
/*  89 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  91 */     _os_.marshal(this.yuanlv);
/*  92 */     _os_.compact_uint32(this.levels.size());
/*  93 */     for (Integer _v_ : this.levels) {
/*  94 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  96 */     _os_.compact_uint32(this.skillinfos.size());
/*  97 */     for (Map.Entry<Integer, Integer> _e_ : this.skillinfos.entrySet()) {
/*  98 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  99 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/* 101 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 105 */     this.hp = _os_.unmarshal_int();
/* 106 */     this.maxhp = _os_.unmarshal_int();
/* 107 */     this.mp = _os_.unmarshal_int();
/* 108 */     this.maxmp = _os_.unmarshal_int();
/* 109 */     this.phyatk = _os_.unmarshal_int();
/* 110 */     this.phydef = _os_.unmarshal_int();
/* 111 */     this.magatk = _os_.unmarshal_int();
/* 112 */     this.magdef = _os_.unmarshal_int();
/* 113 */     this.speed = _os_.unmarshal_int();
/* 114 */     this.magcrt = _os_.unmarshal_int();
/* 115 */     this.phycrt = _os_.unmarshal_int();
/* 116 */     this.sealres = _os_.unmarshal_int();
/* 117 */     this.fightvalue = _os_.unmarshal_int();
/* 118 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 120 */       int _v_ = _os_.unmarshal_int();
/* 121 */       this.skills.add(Integer.valueOf(_v_));
/*     */     }
/* 123 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 125 */       int _v_ = _os_.unmarshal_int();
/* 126 */       this.loves.add(Integer.valueOf(_v_));
/*     */     }
/* 128 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 130 */       int _v_ = _os_.unmarshal_int();
/* 131 */       this.lovestoreplace.add(Integer.valueOf(_v_));
/*     */     }
/* 133 */     this.yuanlv = _os_.unmarshal_int();
/* 134 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 136 */       int _v_ = _os_.unmarshal_int();
/* 137 */       this.levels.add(Integer.valueOf(_v_));
/*     */     }
/* 139 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 141 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 143 */       int _v_ = _os_.unmarshal_int();
/* 144 */       this.skillinfos.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 146 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 150 */     if (_o1_ == this) return true;
/* 151 */     if ((_o1_ instanceof Property)) {
/* 152 */       Property _o_ = (Property)_o1_;
/* 153 */       if (this.hp != _o_.hp) return false;
/* 154 */       if (this.maxhp != _o_.maxhp) return false;
/* 155 */       if (this.mp != _o_.mp) return false;
/* 156 */       if (this.maxmp != _o_.maxmp) return false;
/* 157 */       if (this.phyatk != _o_.phyatk) return false;
/* 158 */       if (this.phydef != _o_.phydef) return false;
/* 159 */       if (this.magatk != _o_.magatk) return false;
/* 160 */       if (this.magdef != _o_.magdef) return false;
/* 161 */       if (this.speed != _o_.speed) return false;
/* 162 */       if (this.magcrt != _o_.magcrt) return false;
/* 163 */       if (this.phycrt != _o_.phycrt) return false;
/* 164 */       if (this.sealres != _o_.sealres) return false;
/* 165 */       if (this.fightvalue != _o_.fightvalue) return false;
/* 166 */       if (!this.skills.equals(_o_.skills)) return false;
/* 167 */       if (!this.loves.equals(_o_.loves)) return false;
/* 168 */       if (!this.lovestoreplace.equals(_o_.lovestoreplace)) return false;
/* 169 */       if (this.yuanlv != _o_.yuanlv) return false;
/* 170 */       if (!this.levels.equals(_o_.levels)) return false;
/* 171 */       if (!this.skillinfos.equals(_o_.skillinfos)) return false;
/* 172 */       return true;
/*     */     }
/* 174 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 178 */     int _h_ = 0;
/* 179 */     _h_ += this.hp;
/* 180 */     _h_ += this.maxhp;
/* 181 */     _h_ += this.mp;
/* 182 */     _h_ += this.maxmp;
/* 183 */     _h_ += this.phyatk;
/* 184 */     _h_ += this.phydef;
/* 185 */     _h_ += this.magatk;
/* 186 */     _h_ += this.magdef;
/* 187 */     _h_ += this.speed;
/* 188 */     _h_ += this.magcrt;
/* 189 */     _h_ += this.phycrt;
/* 190 */     _h_ += this.sealres;
/* 191 */     _h_ += this.fightvalue;
/* 192 */     _h_ += this.skills.hashCode();
/* 193 */     _h_ += this.loves.hashCode();
/* 194 */     _h_ += this.lovestoreplace.hashCode();
/* 195 */     _h_ += this.yuanlv;
/* 196 */     _h_ += this.levels.hashCode();
/* 197 */     _h_ += this.skillinfos.hashCode();
/* 198 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 202 */     StringBuilder _sb_ = new StringBuilder();
/* 203 */     _sb_.append("(");
/* 204 */     _sb_.append(this.hp).append(",");
/* 205 */     _sb_.append(this.maxhp).append(",");
/* 206 */     _sb_.append(this.mp).append(",");
/* 207 */     _sb_.append(this.maxmp).append(",");
/* 208 */     _sb_.append(this.phyatk).append(",");
/* 209 */     _sb_.append(this.phydef).append(",");
/* 210 */     _sb_.append(this.magatk).append(",");
/* 211 */     _sb_.append(this.magdef).append(",");
/* 212 */     _sb_.append(this.speed).append(",");
/* 213 */     _sb_.append(this.magcrt).append(",");
/* 214 */     _sb_.append(this.phycrt).append(",");
/* 215 */     _sb_.append(this.sealres).append(",");
/* 216 */     _sb_.append(this.fightvalue).append(",");
/* 217 */     _sb_.append(this.skills).append(",");
/* 218 */     _sb_.append(this.loves).append(",");
/* 219 */     _sb_.append(this.lovestoreplace).append(",");
/* 220 */     _sb_.append(this.yuanlv).append(",");
/* 221 */     _sb_.append(this.levels).append(",");
/* 222 */     _sb_.append(this.skillinfos).append(",");
/* 223 */     _sb_.append(")");
/* 224 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\partner\Property.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */