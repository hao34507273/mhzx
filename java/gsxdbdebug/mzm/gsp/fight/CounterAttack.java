/*     */ package mzm.gsp.fight;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class CounterAttack implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public static final int REBOUND = 0;
/*     */   public static final int TARGET_RELIVE = 1;
/*     */   public static final int RELEASER_RELIVE = 2;
/*     */   public int skill;
/*     */   public FighterStatus attackerstatus;
/*     */   public FighterStatus targetstatus;
/*     */   public HashMap<Integer, FighterStatus> statusmap;
/*     */   public InfluenceOther influences;
/*     */   
/*     */   public CounterAttack()
/*     */   {
/*  20 */     this.attackerstatus = new FighterStatus();
/*  21 */     this.targetstatus = new FighterStatus();
/*  22 */     this.statusmap = new HashMap();
/*  23 */     this.influences = new InfluenceOther();
/*     */   }
/*     */   
/*     */   public CounterAttack(int _skill_, FighterStatus _attackerstatus_, FighterStatus _targetstatus_, HashMap<Integer, FighterStatus> _statusmap_, InfluenceOther _influences_) {
/*  27 */     this.skill = _skill_;
/*  28 */     this.attackerstatus = _attackerstatus_;
/*  29 */     this.targetstatus = _targetstatus_;
/*  30 */     this.statusmap = _statusmap_;
/*  31 */     this.influences = _influences_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  35 */     if (!this.attackerstatus._validator_()) return false;
/*  36 */     if (!this.targetstatus._validator_()) return false;
/*  37 */     for (Map.Entry<Integer, FighterStatus> _e_ : this.statusmap.entrySet()) {
/*  38 */       if (!((FighterStatus)_e_.getValue())._validator_()) return false;
/*     */     }
/*  40 */     if (!this.influences._validator_()) return false;
/*  41 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  45 */     _os_.marshal(this.skill);
/*  46 */     _os_.marshal(this.attackerstatus);
/*  47 */     _os_.marshal(this.targetstatus);
/*  48 */     _os_.compact_uint32(this.statusmap.size());
/*  49 */     for (Map.Entry<Integer, FighterStatus> _e_ : this.statusmap.entrySet()) {
/*  50 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  51 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  53 */     _os_.marshal(this.influences);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  58 */     this.skill = _os_.unmarshal_int();
/*  59 */     this.attackerstatus.unmarshal(_os_);
/*  60 */     this.targetstatus.unmarshal(_os_);
/*  61 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  63 */       int _k_ = _os_.unmarshal_int();
/*  64 */       FighterStatus _v_ = new FighterStatus();
/*  65 */       _v_.unmarshal(_os_);
/*  66 */       this.statusmap.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  68 */     this.influences.unmarshal(_os_);
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof CounterAttack)) {
/*  75 */       CounterAttack _o_ = (CounterAttack)_o1_;
/*  76 */       if (this.skill != _o_.skill) return false;
/*  77 */       if (!this.attackerstatus.equals(_o_.attackerstatus)) return false;
/*  78 */       if (!this.targetstatus.equals(_o_.targetstatus)) return false;
/*  79 */       if (!this.statusmap.equals(_o_.statusmap)) return false;
/*  80 */       if (!this.influences.equals(_o_.influences)) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += this.skill;
/*  89 */     _h_ += this.attackerstatus.hashCode();
/*  90 */     _h_ += this.targetstatus.hashCode();
/*  91 */     _h_ += this.statusmap.hashCode();
/*  92 */     _h_ += this.influences.hashCode();
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.skill).append(",");
/* 100 */     _sb_.append(this.attackerstatus).append(",");
/* 101 */     _sb_.append(this.targetstatus).append(",");
/* 102 */     _sb_.append(this.statusmap).append(",");
/* 103 */     _sb_.append(this.influences).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\CounterAttack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */