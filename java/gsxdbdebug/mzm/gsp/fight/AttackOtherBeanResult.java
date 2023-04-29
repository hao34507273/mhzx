/*     */ package mzm.gsp.fight;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ public class AttackOtherBeanResult implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public FighterStatus attackerstatus;
/*     */   public FighterStatus targetstatus;
/*     */   public java.util.LinkedList<ShareDamageRet> sharedamagetargets;
/*     */   public CounterAttack counterattack;
/*     */   public HashMap<Integer, FighterStatus> statusmap;
/*     */   
/*     */   public AttackOtherBeanResult()
/*     */   {
/*  16 */     this.attackerstatus = new FighterStatus();
/*  17 */     this.targetstatus = new FighterStatus();
/*  18 */     this.sharedamagetargets = new java.util.LinkedList();
/*  19 */     this.counterattack = new CounterAttack();
/*  20 */     this.statusmap = new HashMap();
/*     */   }
/*     */   
/*     */   public AttackOtherBeanResult(FighterStatus _attackerstatus_, FighterStatus _targetstatus_, java.util.LinkedList<ShareDamageRet> _sharedamagetargets_, CounterAttack _counterattack_, HashMap<Integer, FighterStatus> _statusmap_) {
/*  24 */     this.attackerstatus = _attackerstatus_;
/*  25 */     this.targetstatus = _targetstatus_;
/*  26 */     this.sharedamagetargets = _sharedamagetargets_;
/*  27 */     this.counterattack = _counterattack_;
/*  28 */     this.statusmap = _statusmap_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  32 */     if (!this.attackerstatus._validator_()) return false;
/*  33 */     if (!this.targetstatus._validator_()) return false;
/*  34 */     for (ShareDamageRet _v_ : this.sharedamagetargets)
/*  35 */       if (!_v_._validator_()) return false;
/*  36 */     if (!this.counterattack._validator_()) return false;
/*  37 */     for (java.util.Map.Entry<Integer, FighterStatus> _e_ : this.statusmap.entrySet()) {
/*  38 */       if (!((FighterStatus)_e_.getValue())._validator_()) return false;
/*     */     }
/*  40 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  44 */     _os_.marshal(this.attackerstatus);
/*  45 */     _os_.marshal(this.targetstatus);
/*  46 */     _os_.compact_uint32(this.sharedamagetargets.size());
/*  47 */     for (ShareDamageRet _v_ : this.sharedamagetargets) {
/*  48 */       _os_.marshal(_v_);
/*     */     }
/*  50 */     _os_.marshal(this.counterattack);
/*  51 */     _os_.compact_uint32(this.statusmap.size());
/*  52 */     for (java.util.Map.Entry<Integer, FighterStatus> _e_ : this.statusmap.entrySet()) {
/*  53 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  54 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  60 */     this.attackerstatus.unmarshal(_os_);
/*  61 */     this.targetstatus.unmarshal(_os_);
/*  62 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  63 */       ShareDamageRet _v_ = new ShareDamageRet();
/*  64 */       _v_.unmarshal(_os_);
/*  65 */       this.sharedamagetargets.add(_v_);
/*     */     }
/*  67 */     this.counterattack.unmarshal(_os_);
/*  68 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  70 */       int _k_ = _os_.unmarshal_int();
/*  71 */       FighterStatus _v_ = new FighterStatus();
/*  72 */       _v_.unmarshal(_os_);
/*  73 */       this.statusmap.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof AttackOtherBeanResult)) {
/*  81 */       AttackOtherBeanResult _o_ = (AttackOtherBeanResult)_o1_;
/*  82 */       if (!this.attackerstatus.equals(_o_.attackerstatus)) return false;
/*  83 */       if (!this.targetstatus.equals(_o_.targetstatus)) return false;
/*  84 */       if (!this.sharedamagetargets.equals(_o_.sharedamagetargets)) return false;
/*  85 */       if (!this.counterattack.equals(_o_.counterattack)) return false;
/*  86 */       if (!this.statusmap.equals(_o_.statusmap)) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += this.attackerstatus.hashCode();
/*  95 */     _h_ += this.targetstatus.hashCode();
/*  96 */     _h_ += this.sharedamagetargets.hashCode();
/*  97 */     _h_ += this.counterattack.hashCode();
/*  98 */     _h_ += this.statusmap.hashCode();
/*  99 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 103 */     StringBuilder _sb_ = new StringBuilder();
/* 104 */     _sb_.append("(");
/* 105 */     _sb_.append(this.attackerstatus).append(",");
/* 106 */     _sb_.append(this.targetstatus).append(",");
/* 107 */     _sb_.append(this.sharedamagetargets).append(",");
/* 108 */     _sb_.append(this.counterattack).append(",");
/* 109 */     _sb_.append(this.statusmap).append(",");
/* 110 */     _sb_.append(")");
/* 111 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\AttackOtherBeanResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */