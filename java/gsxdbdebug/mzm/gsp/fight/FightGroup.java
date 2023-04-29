/*     */ package mzm.gsp.fight;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class FightGroup implements Marshal
/*     */ {
/*     */   public static final int TYPE_ROLE = 0;
/*     */   public static final int TYPE_MONSTER = 1;
/*     */   public static final int TYPE_FELLOW = 2;
/*     */   public int group_type;
/*     */   public HashMap<Integer, Fighter> fighters;
/*     */   public long roleid;
/*     */   public int useitemtimes;
/*     */   public int summonpettimes;
/*     */   public int summonchldtimes;
/*     */   public HashSet<Long> fightedpets;
/*     */   public HashSet<Long> fightedchilds;
/*     */   
/*     */   public FightGroup()
/*     */   {
/*  25 */     this.fighters = new HashMap();
/*  26 */     this.roleid = -1L;
/*  27 */     this.useitemtimes = -1;
/*  28 */     this.summonpettimes = -1;
/*  29 */     this.summonchldtimes = -1;
/*  30 */     this.fightedpets = new HashSet();
/*  31 */     this.fightedchilds = new HashSet();
/*     */   }
/*     */   
/*     */   public FightGroup(int _group_type_, HashMap<Integer, Fighter> _fighters_, long _roleid_, int _useitemtimes_, int _summonpettimes_, int _summonchldtimes_, HashSet<Long> _fightedpets_, HashSet<Long> _fightedchilds_) {
/*  35 */     this.group_type = _group_type_;
/*  36 */     this.fighters = _fighters_;
/*  37 */     this.roleid = _roleid_;
/*  38 */     this.useitemtimes = _useitemtimes_;
/*  39 */     this.summonpettimes = _summonpettimes_;
/*  40 */     this.summonchldtimes = _summonchldtimes_;
/*  41 */     this.fightedpets = _fightedpets_;
/*  42 */     this.fightedchilds = _fightedchilds_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     for (Map.Entry<Integer, Fighter> _e_ : this.fighters.entrySet()) {
/*  47 */       if (!((Fighter)_e_.getValue())._validator_()) return false;
/*     */     }
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.group_type);
/*  54 */     _os_.compact_uint32(this.fighters.size());
/*  55 */     for (Map.Entry<Integer, Fighter> _e_ : this.fighters.entrySet()) {
/*  56 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  57 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  59 */     _os_.marshal(this.roleid);
/*  60 */     _os_.marshal(this.useitemtimes);
/*  61 */     _os_.marshal(this.summonpettimes);
/*  62 */     _os_.marshal(this.summonchldtimes);
/*  63 */     _os_.compact_uint32(this.fightedpets.size());
/*  64 */     for (Long _v_ : this.fightedpets) {
/*  65 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  67 */     _os_.compact_uint32(this.fightedchilds.size());
/*  68 */     for (Long _v_ : this.fightedchilds) {
/*  69 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  75 */     this.group_type = _os_.unmarshal_int();
/*  76 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  78 */       int _k_ = _os_.unmarshal_int();
/*  79 */       Fighter _v_ = new Fighter();
/*  80 */       _v_.unmarshal(_os_);
/*  81 */       this.fighters.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  83 */     this.roleid = _os_.unmarshal_long();
/*  84 */     this.useitemtimes = _os_.unmarshal_int();
/*  85 */     this.summonpettimes = _os_.unmarshal_int();
/*  86 */     this.summonchldtimes = _os_.unmarshal_int();
/*  87 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  89 */       long _v_ = _os_.unmarshal_long();
/*  90 */       this.fightedpets.add(Long.valueOf(_v_));
/*     */     }
/*  92 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  94 */       long _v_ = _os_.unmarshal_long();
/*  95 */       this.fightedchilds.add(Long.valueOf(_v_));
/*     */     }
/*  97 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 101 */     if (_o1_ == this) return true;
/* 102 */     if ((_o1_ instanceof FightGroup)) {
/* 103 */       FightGroup _o_ = (FightGroup)_o1_;
/* 104 */       if (this.group_type != _o_.group_type) return false;
/* 105 */       if (!this.fighters.equals(_o_.fighters)) return false;
/* 106 */       if (this.roleid != _o_.roleid) return false;
/* 107 */       if (this.useitemtimes != _o_.useitemtimes) return false;
/* 108 */       if (this.summonpettimes != _o_.summonpettimes) return false;
/* 109 */       if (this.summonchldtimes != _o_.summonchldtimes) return false;
/* 110 */       if (!this.fightedpets.equals(_o_.fightedpets)) return false;
/* 111 */       if (!this.fightedchilds.equals(_o_.fightedchilds)) return false;
/* 112 */       return true;
/*     */     }
/* 114 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 118 */     int _h_ = 0;
/* 119 */     _h_ += this.group_type;
/* 120 */     _h_ += this.fighters.hashCode();
/* 121 */     _h_ += (int)this.roleid;
/* 122 */     _h_ += this.useitemtimes;
/* 123 */     _h_ += this.summonpettimes;
/* 124 */     _h_ += this.summonchldtimes;
/* 125 */     _h_ += this.fightedpets.hashCode();
/* 126 */     _h_ += this.fightedchilds.hashCode();
/* 127 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 131 */     StringBuilder _sb_ = new StringBuilder();
/* 132 */     _sb_.append("(");
/* 133 */     _sb_.append(this.group_type).append(",");
/* 134 */     _sb_.append(this.fighters).append(",");
/* 135 */     _sb_.append(this.roleid).append(",");
/* 136 */     _sb_.append(this.useitemtimes).append(",");
/* 137 */     _sb_.append(this.summonpettimes).append(",");
/* 138 */     _sb_.append(this.summonchldtimes).append(",");
/* 139 */     _sb_.append(this.fightedpets).append(",");
/* 140 */     _sb_.append(this.fightedchilds).append(",");
/* 141 */     _sb_.append(")");
/* 142 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\FightGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */