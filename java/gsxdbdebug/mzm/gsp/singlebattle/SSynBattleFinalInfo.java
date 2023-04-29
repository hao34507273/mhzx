/*     */ package mzm.gsp.singlebattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynBattleFinalInfo
/*     */   extends __SSynBattleFinalInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12621577;
/*     */   public int battlecfgid;
/*     */   public int wincampid;
/*     */   public HashMap<Integer, CampFinalInfo> campfinalinfos;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12621577;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynBattleFinalInfo()
/*     */   {
/*  35 */     this.campfinalinfos = new HashMap();
/*     */   }
/*     */   
/*     */   public SSynBattleFinalInfo(int _battlecfgid_, int _wincampid_, HashMap<Integer, CampFinalInfo> _campfinalinfos_) {
/*  39 */     this.battlecfgid = _battlecfgid_;
/*  40 */     this.wincampid = _wincampid_;
/*  41 */     this.campfinalinfos = _campfinalinfos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     for (Map.Entry<Integer, CampFinalInfo> _e_ : this.campfinalinfos.entrySet()) {
/*  46 */       if (!((CampFinalInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.battlecfgid);
/*  53 */     _os_.marshal(this.wincampid);
/*  54 */     _os_.compact_uint32(this.campfinalinfos.size());
/*  55 */     for (Map.Entry<Integer, CampFinalInfo> _e_ : this.campfinalinfos.entrySet()) {
/*  56 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  57 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.battlecfgid = _os_.unmarshal_int();
/*  64 */     this.wincampid = _os_.unmarshal_int();
/*  65 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  67 */       int _k_ = _os_.unmarshal_int();
/*  68 */       CampFinalInfo _v_ = new CampFinalInfo();
/*  69 */       _v_.unmarshal(_os_);
/*  70 */       this.campfinalinfos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SSynBattleFinalInfo)) {
/*  81 */       SSynBattleFinalInfo _o_ = (SSynBattleFinalInfo)_o1_;
/*  82 */       if (this.battlecfgid != _o_.battlecfgid) return false;
/*  83 */       if (this.wincampid != _o_.wincampid) return false;
/*  84 */       if (!this.campfinalinfos.equals(_o_.campfinalinfos)) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += this.battlecfgid;
/*  93 */     _h_ += this.wincampid;
/*  94 */     _h_ += this.campfinalinfos.hashCode();
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.battlecfgid).append(",");
/* 102 */     _sb_.append(this.wincampid).append(",");
/* 103 */     _sb_.append(this.campfinalinfos).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\SSynBattleFinalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */