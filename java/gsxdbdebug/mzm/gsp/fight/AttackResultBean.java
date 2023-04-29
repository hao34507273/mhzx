/*     */ package mzm.gsp.fight;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ public class AttackResultBean implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public static final int REBOUND = 0;
/*     */   public static final int TARGET_RELIVE = 1;
/*     */   public static final int RELEASER_RELIVE = 2;
/*     */   public FighterStatus attackerstatus;
/*     */   public FighterStatus targetstatus;
/*     */   public LinkedList<ShareDamageRet> sharedamagetargets;
/*     */   public CounterAttack counterattack;
/*     */   public HashMap<Integer, FighterStatus> statusmap;
/*     */   public LinkedList<AttackOtherBean> attackothers;
/*     */   
/*     */   public AttackResultBean()
/*     */   {
/*  21 */     this.attackerstatus = new FighterStatus();
/*  22 */     this.targetstatus = new FighterStatus();
/*  23 */     this.sharedamagetargets = new LinkedList();
/*  24 */     this.counterattack = new CounterAttack();
/*  25 */     this.statusmap = new HashMap();
/*  26 */     this.attackothers = new LinkedList();
/*     */   }
/*     */   
/*     */   public AttackResultBean(FighterStatus _attackerstatus_, FighterStatus _targetstatus_, LinkedList<ShareDamageRet> _sharedamagetargets_, CounterAttack _counterattack_, HashMap<Integer, FighterStatus> _statusmap_, LinkedList<AttackOtherBean> _attackothers_) {
/*  30 */     this.attackerstatus = _attackerstatus_;
/*  31 */     this.targetstatus = _targetstatus_;
/*  32 */     this.sharedamagetargets = _sharedamagetargets_;
/*  33 */     this.counterattack = _counterattack_;
/*  34 */     this.statusmap = _statusmap_;
/*  35 */     this.attackothers = _attackothers_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  39 */     if (!this.attackerstatus._validator_()) return false;
/*  40 */     if (!this.targetstatus._validator_()) return false;
/*  41 */     for (ShareDamageRet _v_ : this.sharedamagetargets)
/*  42 */       if (!_v_._validator_()) return false;
/*  43 */     if (!this.counterattack._validator_()) return false;
/*  44 */     for (java.util.Map.Entry<Integer, FighterStatus> _e_ : this.statusmap.entrySet()) {
/*  45 */       if (!((FighterStatus)_e_.getValue())._validator_()) return false;
/*     */     }
/*  47 */     for (AttackOtherBean _v_ : this.attackothers)
/*  48 */       if (!_v_._validator_()) return false;
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.attackerstatus);
/*  54 */     _os_.marshal(this.targetstatus);
/*  55 */     _os_.compact_uint32(this.sharedamagetargets.size());
/*  56 */     for (ShareDamageRet _v_ : this.sharedamagetargets) {
/*  57 */       _os_.marshal(_v_);
/*     */     }
/*  59 */     _os_.marshal(this.counterattack);
/*  60 */     _os_.compact_uint32(this.statusmap.size());
/*  61 */     for (java.util.Map.Entry<Integer, FighterStatus> _e_ : this.statusmap.entrySet()) {
/*  62 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  63 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  65 */     _os_.compact_uint32(this.attackothers.size());
/*  66 */     for (AttackOtherBean _v_ : this.attackothers) {
/*  67 */       _os_.marshal(_v_);
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  73 */     this.attackerstatus.unmarshal(_os_);
/*  74 */     this.targetstatus.unmarshal(_os_);
/*  75 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  76 */       ShareDamageRet _v_ = new ShareDamageRet();
/*  77 */       _v_.unmarshal(_os_);
/*  78 */       this.sharedamagetargets.add(_v_);
/*     */     }
/*  80 */     this.counterattack.unmarshal(_os_);
/*  81 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  83 */       int _k_ = _os_.unmarshal_int();
/*  84 */       FighterStatus _v_ = new FighterStatus();
/*  85 */       _v_.unmarshal(_os_);
/*  86 */       this.statusmap.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  88 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  89 */       AttackOtherBean _v_ = new AttackOtherBean();
/*  90 */       _v_.unmarshal(_os_);
/*  91 */       this.attackothers.add(_v_);
/*     */     }
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  97 */     if (_o1_ == this) return true;
/*  98 */     if ((_o1_ instanceof AttackResultBean)) {
/*  99 */       AttackResultBean _o_ = (AttackResultBean)_o1_;
/* 100 */       if (!this.attackerstatus.equals(_o_.attackerstatus)) return false;
/* 101 */       if (!this.targetstatus.equals(_o_.targetstatus)) return false;
/* 102 */       if (!this.sharedamagetargets.equals(_o_.sharedamagetargets)) return false;
/* 103 */       if (!this.counterattack.equals(_o_.counterattack)) return false;
/* 104 */       if (!this.statusmap.equals(_o_.statusmap)) return false;
/* 105 */       if (!this.attackothers.equals(_o_.attackothers)) return false;
/* 106 */       return true;
/*     */     }
/* 108 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 112 */     int _h_ = 0;
/* 113 */     _h_ += this.attackerstatus.hashCode();
/* 114 */     _h_ += this.targetstatus.hashCode();
/* 115 */     _h_ += this.sharedamagetargets.hashCode();
/* 116 */     _h_ += this.counterattack.hashCode();
/* 117 */     _h_ += this.statusmap.hashCode();
/* 118 */     _h_ += this.attackothers.hashCode();
/* 119 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 123 */     StringBuilder _sb_ = new StringBuilder();
/* 124 */     _sb_.append("(");
/* 125 */     _sb_.append(this.attackerstatus).append(",");
/* 126 */     _sb_.append(this.targetstatus).append(",");
/* 127 */     _sb_.append(this.sharedamagetargets).append(",");
/* 128 */     _sb_.append(this.counterattack).append(",");
/* 129 */     _sb_.append(this.statusmap).append(",");
/* 130 */     _sb_.append(this.attackothers).append(",");
/* 131 */     _sb_.append(")");
/* 132 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\AttackResultBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */