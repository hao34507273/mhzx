/*     */ package mzm.gsp.fight;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class PlaySkill implements Marshal
/*     */ {
/*     */   public static final int NORMAL = 0;
/*     */   public static final int LIAN_XIE_JI = 1;
/*     */   public static final int LIAN_JI = 2;
/*     */   public static final int ZHUI_JI = 3;
/*     */   public static final int DEATH_TRIGGER = 4;
/*     */   public static final int DEATH_BOOMING = 5;
/*     */   public static final int SKILL_CAUSING_DEATH = 6;
/*     */   public static final int SKILL_COUNTER_ATTACK = 7;
/*     */   public static final int EXTRA_LIAN_XIE_JI_TIGGER_ID = 501;
/*     */   public static final int EXTRA_LIAN_XIE_JI_CFG_ID = 502;
/*     */   public int fighterid;
/*     */   public int skill;
/*     */   public int skillplaytype;
/*     */   public HashMap<Integer, Integer> extra;
/*     */   public FighterStatus releaser;
/*     */   public FighterStatus afterreleaser;
/*     */   public ArrayList<Integer> targets;
/*     */   public HashMap<Integer, AttackResult> status_map;
/*     */   public HashMap<Integer, HitAgain> hitagain_map;
/*     */   public HashMap<Integer, Protect> protect_map;
/*     */   public HashMap<Integer, InfluenceOther> influencemap;
/*     */   public HashMap<Integer, Skillids> deathfighter2skills;
/*     */   
/*     */   public PlaySkill()
/*     */   {
/*  36 */     this.extra = new HashMap();
/*  37 */     this.releaser = new FighterStatus();
/*  38 */     this.afterreleaser = new FighterStatus();
/*  39 */     this.targets = new ArrayList();
/*  40 */     this.status_map = new HashMap();
/*  41 */     this.hitagain_map = new HashMap();
/*  42 */     this.protect_map = new HashMap();
/*  43 */     this.influencemap = new HashMap();
/*  44 */     this.deathfighter2skills = new HashMap();
/*     */   }
/*     */   
/*     */   public PlaySkill(int _fighterid_, int _skill_, int _skillplaytype_, HashMap<Integer, Integer> _extra_, FighterStatus _releaser_, FighterStatus _afterreleaser_, ArrayList<Integer> _targets_, HashMap<Integer, AttackResult> _status_map_, HashMap<Integer, HitAgain> _hitagain_map_, HashMap<Integer, Protect> _protect_map_, HashMap<Integer, InfluenceOther> _influencemap_, HashMap<Integer, Skillids> _deathfighter2skills_) {
/*  48 */     this.fighterid = _fighterid_;
/*  49 */     this.skill = _skill_;
/*  50 */     this.skillplaytype = _skillplaytype_;
/*  51 */     this.extra = _extra_;
/*  52 */     this.releaser = _releaser_;
/*  53 */     this.afterreleaser = _afterreleaser_;
/*  54 */     this.targets = _targets_;
/*  55 */     this.status_map = _status_map_;
/*  56 */     this.hitagain_map = _hitagain_map_;
/*  57 */     this.protect_map = _protect_map_;
/*  58 */     this.influencemap = _influencemap_;
/*  59 */     this.deathfighter2skills = _deathfighter2skills_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  63 */     if (!this.releaser._validator_()) return false;
/*  64 */     if (!this.afterreleaser._validator_()) return false;
/*  65 */     for (Map.Entry<Integer, AttackResult> _e_ : this.status_map.entrySet()) {
/*  66 */       if (!((AttackResult)_e_.getValue())._validator_()) return false;
/*     */     }
/*  68 */     for (Map.Entry<Integer, HitAgain> _e_ : this.hitagain_map.entrySet()) {
/*  69 */       if (!((HitAgain)_e_.getValue())._validator_()) return false;
/*     */     }
/*  71 */     for (Map.Entry<Integer, Protect> _e_ : this.protect_map.entrySet()) {
/*  72 */       if (!((Protect)_e_.getValue())._validator_()) return false;
/*     */     }
/*  74 */     for (Map.Entry<Integer, InfluenceOther> _e_ : this.influencemap.entrySet()) {
/*  75 */       if (!((InfluenceOther)_e_.getValue())._validator_()) return false;
/*     */     }
/*  77 */     for (Map.Entry<Integer, Skillids> _e_ : this.deathfighter2skills.entrySet()) {
/*  78 */       if (!((Skillids)_e_.getValue())._validator_()) return false;
/*     */     }
/*  80 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  84 */     _os_.marshal(this.fighterid);
/*  85 */     _os_.marshal(this.skill);
/*  86 */     _os_.marshal(this.skillplaytype);
/*  87 */     _os_.compact_uint32(this.extra.size());
/*  88 */     for (Map.Entry<Integer, Integer> _e_ : this.extra.entrySet()) {
/*  89 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  90 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  92 */     _os_.marshal(this.releaser);
/*  93 */     _os_.marshal(this.afterreleaser);
/*  94 */     _os_.compact_uint32(this.targets.size());
/*  95 */     for (Integer _v_ : this.targets) {
/*  96 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  98 */     _os_.compact_uint32(this.status_map.size());
/*  99 */     for (Map.Entry<Integer, AttackResult> _e_ : this.status_map.entrySet()) {
/* 100 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 101 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/* 103 */     _os_.compact_uint32(this.hitagain_map.size());
/* 104 */     for (Map.Entry<Integer, HitAgain> _e_ : this.hitagain_map.entrySet()) {
/* 105 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 106 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/* 108 */     _os_.compact_uint32(this.protect_map.size());
/* 109 */     for (Map.Entry<Integer, Protect> _e_ : this.protect_map.entrySet()) {
/* 110 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 111 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/* 113 */     _os_.compact_uint32(this.influencemap.size());
/* 114 */     for (Map.Entry<Integer, InfluenceOther> _e_ : this.influencemap.entrySet()) {
/* 115 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 116 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/* 118 */     _os_.compact_uint32(this.deathfighter2skills.size());
/* 119 */     for (Map.Entry<Integer, Skillids> _e_ : this.deathfighter2skills.entrySet()) {
/* 120 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 121 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/* 123 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 127 */     this.fighterid = _os_.unmarshal_int();
/* 128 */     this.skill = _os_.unmarshal_int();
/* 129 */     this.skillplaytype = _os_.unmarshal_int();
/* 130 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 132 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 134 */       int _v_ = _os_.unmarshal_int();
/* 135 */       this.extra.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 137 */     this.releaser.unmarshal(_os_);
/* 138 */     this.afterreleaser.unmarshal(_os_);
/* 139 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 141 */       int _v_ = _os_.unmarshal_int();
/* 142 */       this.targets.add(Integer.valueOf(_v_));
/*     */     }
/* 144 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 146 */       int _k_ = _os_.unmarshal_int();
/* 147 */       AttackResult _v_ = new AttackResult();
/* 148 */       _v_.unmarshal(_os_);
/* 149 */       this.status_map.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 151 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 153 */       int _k_ = _os_.unmarshal_int();
/* 154 */       HitAgain _v_ = new HitAgain();
/* 155 */       _v_.unmarshal(_os_);
/* 156 */       this.hitagain_map.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 158 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 160 */       int _k_ = _os_.unmarshal_int();
/* 161 */       Protect _v_ = new Protect();
/* 162 */       _v_.unmarshal(_os_);
/* 163 */       this.protect_map.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 165 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 167 */       int _k_ = _os_.unmarshal_int();
/* 168 */       InfluenceOther _v_ = new InfluenceOther();
/* 169 */       _v_.unmarshal(_os_);
/* 170 */       this.influencemap.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 172 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 174 */       int _k_ = _os_.unmarshal_int();
/* 175 */       Skillids _v_ = new Skillids();
/* 176 */       _v_.unmarshal(_os_);
/* 177 */       this.deathfighter2skills.put(Integer.valueOf(_k_), _v_);
/*     */     }
/* 179 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 183 */     if (_o1_ == this) return true;
/* 184 */     if ((_o1_ instanceof PlaySkill)) {
/* 185 */       PlaySkill _o_ = (PlaySkill)_o1_;
/* 186 */       if (this.fighterid != _o_.fighterid) return false;
/* 187 */       if (this.skill != _o_.skill) return false;
/* 188 */       if (this.skillplaytype != _o_.skillplaytype) return false;
/* 189 */       if (!this.extra.equals(_o_.extra)) return false;
/* 190 */       if (!this.releaser.equals(_o_.releaser)) return false;
/* 191 */       if (!this.afterreleaser.equals(_o_.afterreleaser)) return false;
/* 192 */       if (!this.targets.equals(_o_.targets)) return false;
/* 193 */       if (!this.status_map.equals(_o_.status_map)) return false;
/* 194 */       if (!this.hitagain_map.equals(_o_.hitagain_map)) return false;
/* 195 */       if (!this.protect_map.equals(_o_.protect_map)) return false;
/* 196 */       if (!this.influencemap.equals(_o_.influencemap)) return false;
/* 197 */       if (!this.deathfighter2skills.equals(_o_.deathfighter2skills)) return false;
/* 198 */       return true;
/*     */     }
/* 200 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 204 */     int _h_ = 0;
/* 205 */     _h_ += this.fighterid;
/* 206 */     _h_ += this.skill;
/* 207 */     _h_ += this.skillplaytype;
/* 208 */     _h_ += this.extra.hashCode();
/* 209 */     _h_ += this.releaser.hashCode();
/* 210 */     _h_ += this.afterreleaser.hashCode();
/* 211 */     _h_ += this.targets.hashCode();
/* 212 */     _h_ += this.status_map.hashCode();
/* 213 */     _h_ += this.hitagain_map.hashCode();
/* 214 */     _h_ += this.protect_map.hashCode();
/* 215 */     _h_ += this.influencemap.hashCode();
/* 216 */     _h_ += this.deathfighter2skills.hashCode();
/* 217 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 221 */     StringBuilder _sb_ = new StringBuilder();
/* 222 */     _sb_.append("(");
/* 223 */     _sb_.append(this.fighterid).append(",");
/* 224 */     _sb_.append(this.skill).append(",");
/* 225 */     _sb_.append(this.skillplaytype).append(",");
/* 226 */     _sb_.append(this.extra).append(",");
/* 227 */     _sb_.append(this.releaser).append(",");
/* 228 */     _sb_.append(this.afterreleaser).append(",");
/* 229 */     _sb_.append(this.targets).append(",");
/* 230 */     _sb_.append(this.status_map).append(",");
/* 231 */     _sb_.append(this.hitagain_map).append(",");
/* 232 */     _sb_.append(this.protect_map).append(",");
/* 233 */     _sb_.append(this.influencemap).append(",");
/* 234 */     _sb_.append(this.deathfighter2skills).append(",");
/* 235 */     _sb_.append(")");
/* 236 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\PlaySkill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */