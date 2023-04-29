/*     */ package mzm.gsp.fight;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ public class FighterStatus implements Marshal
/*     */ {
/*     */   public static final int STATUS_ALIVE = 0;
/*     */   public static final int STATUS_DEAD = 1;
/*     */   public static final int STATUS_ESCAPED = 2;
/*     */   public static final int STATUS_FAKE_DEAD = 3;
/*     */   public static final int STATUS_ATTACKED = 20;
/*     */   public static final int STATUS_CRITICAL_ATTACK = 21;
/*     */   public static final int STATUS_DODGE = 22;
/*     */   public static final int STATUS_RELIVE = 23;
/*     */   public static final int STATUS_COMBO_ATTACKED = 24;
/*     */   public static final int STATUS_ABSORB_DAMAGE = 26;
/*     */   public static final int STATUS_PROTECT_OTHER = 27;
/*     */   public static final int STATUS_COUNTER_ATTACK = 28;
/*     */   public static final int STATUS_DEFENSE = 29;
/*     */   public static final int STATUS_SEAL_NOT_HIT = 30;
/*     */   public static final int STATUS_IMMUNE = 31;
/*     */   public static final int STATUS_BLACKHOLE_DAMAGE = 32;
/*     */   public static final int STATUS_LIFELINK_DAMAGE = 33;
/*     */   public static final int STATUS_RELIVE_TIME_BACK = 34;
/*     */   public static final int BUFF_ST__REST = 100;
/*     */   public static final int BUFF_ST__SLEEP = 101;
/*     */   public static final int BUFF_ST__STONE = 102;
/*     */   public static final int BUFF_ST__MESS = 103;
/*     */   public static final int BUFF_ST__SEAL = 104;
/*     */   public static final int BUFF_ST__HOUFA = 105;
/*     */   public static final int BUFF_ST__FORBIDREBIRTH = 106;
/*     */   public static final int BUFF_ST__INVISIBLE = 107;
/*     */   public static final int BUFF_ST__VISIBLE = 108;
/*     */   public static final int BUFF_ST__DEFENCE = 109;
/*     */   public static final int BUFF_ST__WEAK = 110;
/*     */   public static final int BUFF_ST__TECH = 111;
/*     */   public static final int BUFF_ST__FORTUNE = 112;
/*     */   public static final int BUFF_ST__GHOST = 113;
/*     */   public static final int BUFF_ST__BEAT_GHOST = 114;
/*     */   public static final int BUFF_ST__PERSISTENT = 115;
/*     */   public static final int BUFF_ST__FLY = 116;
/*     */   public static final int BUFF_ST__AGILE = 117;
/*     */   public static final int BUFF_ST__ACCURATE = 118;
/*     */   public static final int BUFF_ST__FEAR = 119;
/*     */   public static final int BUFF_ST__SINCERELY = 120;
/*     */   public static final int BUFF_ST__TRIAL = 121;
/*     */   public static final int BUFF_ST__BARRIERS = 122;
/*     */   public static final int BUFF_ST__BREAK_BARRIERS = 123;
/*     */   public static final int BUFF_ST__PARRY = 124;
/*     */   public static final int BUFF_ST__PROPERTY_RELIVE = 125;
/*     */   public static final int BUFF_ST__IMMUNE = 126;
/*     */   public static final int BUFF_ST__TAUNT = 127;
/*     */   public static final int BUFF_ST__ICECOOL = 128;
/*     */   public static final int BUFF_ST__NOTLEAVE = 129;
/*     */   public static final int BUFF_ST__DEATHSKILL = 130;
/*     */   public static final int BUFF_ST__SUBSOULBOND = 131;
/*     */   public static final int BUFF_ST__RELEASE_SKILL_DEAD = 132;
/*     */   public static final int BUFF_ST__MARK = 133;
/*     */   public static final int BUFF_ST__HOUFA_MISSILE = 134;
/*     */   public static final int BUFF_ST__MIRROR_SKILL = 135;
/*     */   public int hpchange;
/*     */   public int mpchange;
/*     */   public int angerchange;
/*     */   public HashSet<Integer> status_set;
/*     */   public HashSet<Integer> buff_status_set;
/*     */   public LinkedList<Buff> buffs;
/*     */   public int hpmax;
/*     */   public int curhp;
/*     */   public int mpmax;
/*     */   public int curmp;
/*     */   public int angermax;
/*     */   public int curanger;
/*     */   public int curenergy;
/*     */   public HashSet<Integer> changemodels;
/*     */   public HashSet<Integer> triggerpassiveskills;
/*     */   
/*     */   public FighterStatus()
/*     */   {
/*  83 */     this.status_set = new HashSet();
/*  84 */     this.buff_status_set = new HashSet();
/*  85 */     this.buffs = new LinkedList();
/*  86 */     this.changemodels = new HashSet();
/*  87 */     this.triggerpassiveskills = new HashSet();
/*     */   }
/*     */   
/*     */   public FighterStatus(int _hpchange_, int _mpchange_, int _angerchange_, HashSet<Integer> _status_set_, HashSet<Integer> _buff_status_set_, LinkedList<Buff> _buffs_, int _hpmax_, int _curhp_, int _mpmax_, int _curmp_, int _angermax_, int _curanger_, int _curenergy_, HashSet<Integer> _changemodels_, HashSet<Integer> _triggerpassiveskills_) {
/*  91 */     this.hpchange = _hpchange_;
/*  92 */     this.mpchange = _mpchange_;
/*  93 */     this.angerchange = _angerchange_;
/*  94 */     this.status_set = _status_set_;
/*  95 */     this.buff_status_set = _buff_status_set_;
/*  96 */     this.buffs = _buffs_;
/*  97 */     this.hpmax = _hpmax_;
/*  98 */     this.curhp = _curhp_;
/*  99 */     this.mpmax = _mpmax_;
/* 100 */     this.curmp = _curmp_;
/* 101 */     this.angermax = _angermax_;
/* 102 */     this.curanger = _curanger_;
/* 103 */     this.curenergy = _curenergy_;
/* 104 */     this.changemodels = _changemodels_;
/* 105 */     this.triggerpassiveskills = _triggerpassiveskills_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/* 109 */     for (Buff _v_ : this.buffs)
/* 110 */       if (!_v_._validator_()) return false;
/* 111 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/* 115 */     _os_.marshal(this.hpchange);
/* 116 */     _os_.marshal(this.mpchange);
/* 117 */     _os_.marshal(this.angerchange);
/* 118 */     _os_.compact_uint32(this.status_set.size());
/* 119 */     for (Integer _v_ : this.status_set) {
/* 120 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 122 */     _os_.compact_uint32(this.buff_status_set.size());
/* 123 */     for (Integer _v_ : this.buff_status_set) {
/* 124 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 126 */     _os_.compact_uint32(this.buffs.size());
/* 127 */     for (Buff _v_ : this.buffs) {
/* 128 */       _os_.marshal(_v_);
/*     */     }
/* 130 */     _os_.marshal(this.hpmax);
/* 131 */     _os_.marshal(this.curhp);
/* 132 */     _os_.marshal(this.mpmax);
/* 133 */     _os_.marshal(this.curmp);
/* 134 */     _os_.marshal(this.angermax);
/* 135 */     _os_.marshal(this.curanger);
/* 136 */     _os_.marshal(this.curenergy);
/* 137 */     _os_.compact_uint32(this.changemodels.size());
/* 138 */     for (Integer _v_ : this.changemodels) {
/* 139 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 141 */     _os_.compact_uint32(this.triggerpassiveskills.size());
/* 142 */     for (Integer _v_ : this.triggerpassiveskills) {
/* 143 */       _os_.marshal(_v_.intValue());
/*     */     }
/* 145 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 149 */     this.hpchange = _os_.unmarshal_int();
/* 150 */     this.mpchange = _os_.unmarshal_int();
/* 151 */     this.angerchange = _os_.unmarshal_int();
/* 152 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 154 */       int _v_ = _os_.unmarshal_int();
/* 155 */       this.status_set.add(Integer.valueOf(_v_));
/*     */     }
/* 157 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 159 */       int _v_ = _os_.unmarshal_int();
/* 160 */       this.buff_status_set.add(Integer.valueOf(_v_));
/*     */     }
/* 162 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/* 163 */       Buff _v_ = new Buff();
/* 164 */       _v_.unmarshal(_os_);
/* 165 */       this.buffs.add(_v_);
/*     */     }
/* 167 */     this.hpmax = _os_.unmarshal_int();
/* 168 */     this.curhp = _os_.unmarshal_int();
/* 169 */     this.mpmax = _os_.unmarshal_int();
/* 170 */     this.curmp = _os_.unmarshal_int();
/* 171 */     this.angermax = _os_.unmarshal_int();
/* 172 */     this.curanger = _os_.unmarshal_int();
/* 173 */     this.curenergy = _os_.unmarshal_int();
/* 174 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 176 */       int _v_ = _os_.unmarshal_int();
/* 177 */       this.changemodels.add(Integer.valueOf(_v_));
/*     */     }
/* 179 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/* 181 */       int _v_ = _os_.unmarshal_int();
/* 182 */       this.triggerpassiveskills.add(Integer.valueOf(_v_));
/*     */     }
/* 184 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 188 */     if (_o1_ == this) return true;
/* 189 */     if ((_o1_ instanceof FighterStatus)) {
/* 190 */       FighterStatus _o_ = (FighterStatus)_o1_;
/* 191 */       if (this.hpchange != _o_.hpchange) return false;
/* 192 */       if (this.mpchange != _o_.mpchange) return false;
/* 193 */       if (this.angerchange != _o_.angerchange) return false;
/* 194 */       if (!this.status_set.equals(_o_.status_set)) return false;
/* 195 */       if (!this.buff_status_set.equals(_o_.buff_status_set)) return false;
/* 196 */       if (!this.buffs.equals(_o_.buffs)) return false;
/* 197 */       if (this.hpmax != _o_.hpmax) return false;
/* 198 */       if (this.curhp != _o_.curhp) return false;
/* 199 */       if (this.mpmax != _o_.mpmax) return false;
/* 200 */       if (this.curmp != _o_.curmp) return false;
/* 201 */       if (this.angermax != _o_.angermax) return false;
/* 202 */       if (this.curanger != _o_.curanger) return false;
/* 203 */       if (this.curenergy != _o_.curenergy) return false;
/* 204 */       if (!this.changemodels.equals(_o_.changemodels)) return false;
/* 205 */       if (!this.triggerpassiveskills.equals(_o_.triggerpassiveskills)) return false;
/* 206 */       return true;
/*     */     }
/* 208 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 212 */     int _h_ = 0;
/* 213 */     _h_ += this.hpchange;
/* 214 */     _h_ += this.mpchange;
/* 215 */     _h_ += this.angerchange;
/* 216 */     _h_ += this.status_set.hashCode();
/* 217 */     _h_ += this.buff_status_set.hashCode();
/* 218 */     _h_ += this.buffs.hashCode();
/* 219 */     _h_ += this.hpmax;
/* 220 */     _h_ += this.curhp;
/* 221 */     _h_ += this.mpmax;
/* 222 */     _h_ += this.curmp;
/* 223 */     _h_ += this.angermax;
/* 224 */     _h_ += this.curanger;
/* 225 */     _h_ += this.curenergy;
/* 226 */     _h_ += this.changemodels.hashCode();
/* 227 */     _h_ += this.triggerpassiveskills.hashCode();
/* 228 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 232 */     StringBuilder _sb_ = new StringBuilder();
/* 233 */     _sb_.append("(");
/* 234 */     _sb_.append(this.hpchange).append(",");
/* 235 */     _sb_.append(this.mpchange).append(",");
/* 236 */     _sb_.append(this.angerchange).append(",");
/* 237 */     _sb_.append(this.status_set).append(",");
/* 238 */     _sb_.append(this.buff_status_set).append(",");
/* 239 */     _sb_.append(this.buffs).append(",");
/* 240 */     _sb_.append(this.hpmax).append(",");
/* 241 */     _sb_.append(this.curhp).append(",");
/* 242 */     _sb_.append(this.mpmax).append(",");
/* 243 */     _sb_.append(this.curmp).append(",");
/* 244 */     _sb_.append(this.angermax).append(",");
/* 245 */     _sb_.append(this.curanger).append(",");
/* 246 */     _sb_.append(this.curenergy).append(",");
/* 247 */     _sb_.append(this.changemodels).append(",");
/* 248 */     _sb_.append(this.triggerpassiveskills).append(",");
/* 249 */     _sb_.append(")");
/* 250 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\FighterStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */