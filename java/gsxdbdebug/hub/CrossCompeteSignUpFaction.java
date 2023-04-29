/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class CrossCompeteSignUpFaction implements Marshal
/*     */ {
/*     */   public long factionid;
/*     */   public String faction_name;
/*     */   public int activeness;
/*     */   public HashMap<Long, Integer> faction2matchtimes;
/*     */   public int miss_turn_times;
/*     */   public int faction_level;
/*     */   public int member_count;
/*     */   public int particapte_count;
/*     */   
/*     */   public CrossCompeteSignUpFaction()
/*     */   {
/*  21 */     this.faction_name = "";
/*  22 */     this.faction2matchtimes = new HashMap();
/*     */   }
/*     */   
/*     */   public CrossCompeteSignUpFaction(long _factionid_, String _faction_name_, int _activeness_, HashMap<Long, Integer> _faction2matchtimes_, int _miss_turn_times_, int _faction_level_, int _member_count_, int _particapte_count_) {
/*  26 */     this.factionid = _factionid_;
/*  27 */     this.faction_name = _faction_name_;
/*  28 */     this.activeness = _activeness_;
/*  29 */     this.faction2matchtimes = _faction2matchtimes_;
/*  30 */     this.miss_turn_times = _miss_turn_times_;
/*  31 */     this.faction_level = _faction_level_;
/*  32 */     this.member_count = _member_count_;
/*  33 */     this.particapte_count = _particapte_count_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  37 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  41 */     _os_.marshal(this.factionid);
/*  42 */     _os_.marshal(this.faction_name, "UTF-16LE");
/*  43 */     _os_.marshal(this.activeness);
/*  44 */     _os_.compact_uint32(this.faction2matchtimes.size());
/*  45 */     for (Map.Entry<Long, Integer> _e_ : this.faction2matchtimes.entrySet()) {
/*  46 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  47 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  49 */     _os_.marshal(this.miss_turn_times);
/*  50 */     _os_.marshal(this.faction_level);
/*  51 */     _os_.marshal(this.member_count);
/*  52 */     _os_.marshal(this.particapte_count);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  57 */     this.factionid = _os_.unmarshal_long();
/*  58 */     this.faction_name = _os_.unmarshal_String("UTF-16LE");
/*  59 */     this.activeness = _os_.unmarshal_int();
/*  60 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  62 */       long _k_ = _os_.unmarshal_long();
/*     */       
/*  64 */       int _v_ = _os_.unmarshal_int();
/*  65 */       this.faction2matchtimes.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  67 */     this.miss_turn_times = _os_.unmarshal_int();
/*  68 */     this.faction_level = _os_.unmarshal_int();
/*  69 */     this.member_count = _os_.unmarshal_int();
/*  70 */     this.particapte_count = _os_.unmarshal_int();
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof CrossCompeteSignUpFaction)) {
/*  77 */       CrossCompeteSignUpFaction _o_ = (CrossCompeteSignUpFaction)_o1_;
/*  78 */       if (this.factionid != _o_.factionid) return false;
/*  79 */       if (!this.faction_name.equals(_o_.faction_name)) return false;
/*  80 */       if (this.activeness != _o_.activeness) return false;
/*  81 */       if (!this.faction2matchtimes.equals(_o_.faction2matchtimes)) return false;
/*  82 */       if (this.miss_turn_times != _o_.miss_turn_times) return false;
/*  83 */       if (this.faction_level != _o_.faction_level) return false;
/*  84 */       if (this.member_count != _o_.member_count) return false;
/*  85 */       if (this.particapte_count != _o_.particapte_count) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += (int)this.factionid;
/*  94 */     _h_ += this.faction_name.hashCode();
/*  95 */     _h_ += this.activeness;
/*  96 */     _h_ += this.faction2matchtimes.hashCode();
/*  97 */     _h_ += this.miss_turn_times;
/*  98 */     _h_ += this.faction_level;
/*  99 */     _h_ += this.member_count;
/* 100 */     _h_ += this.particapte_count;
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.factionid).append(",");
/* 108 */     _sb_.append("T").append(this.faction_name.length()).append(",");
/* 109 */     _sb_.append(this.activeness).append(",");
/* 110 */     _sb_.append(this.faction2matchtimes).append(",");
/* 111 */     _sb_.append(this.miss_turn_times).append(",");
/* 112 */     _sb_.append(this.faction_level).append(",");
/* 113 */     _sb_.append(this.member_count).append(",");
/* 114 */     _sb_.append(this.particapte_count).append(",");
/* 115 */     _sb_.append(")");
/* 116 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\CrossCompeteSignUpFaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */