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
/*     */ public class SSynBattleTotalInfo
/*     */   extends __SSynBattleTotalInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12621571;
/*     */   public int battlecfgid;
/*     */   public HashMap<Integer, CampGlobalInfo> campinfos;
/*     */   public int stage;
/*     */   public int starttime;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12621571;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynBattleTotalInfo()
/*     */   {
/*  36 */     this.campinfos = new HashMap();
/*     */   }
/*     */   
/*     */   public SSynBattleTotalInfo(int _battlecfgid_, HashMap<Integer, CampGlobalInfo> _campinfos_, int _stage_, int _starttime_) {
/*  40 */     this.battlecfgid = _battlecfgid_;
/*  41 */     this.campinfos = _campinfos_;
/*  42 */     this.stage = _stage_;
/*  43 */     this.starttime = _starttime_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     for (Map.Entry<Integer, CampGlobalInfo> _e_ : this.campinfos.entrySet()) {
/*  48 */       if (!((CampGlobalInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.battlecfgid);
/*  55 */     _os_.compact_uint32(this.campinfos.size());
/*  56 */     for (Map.Entry<Integer, CampGlobalInfo> _e_ : this.campinfos.entrySet()) {
/*  57 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  58 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  60 */     _os_.marshal(this.stage);
/*  61 */     _os_.marshal(this.starttime);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.battlecfgid = _os_.unmarshal_int();
/*  67 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  69 */       int _k_ = _os_.unmarshal_int();
/*  70 */       CampGlobalInfo _v_ = new CampGlobalInfo();
/*  71 */       _v_.unmarshal(_os_);
/*  72 */       this.campinfos.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  74 */     this.stage = _os_.unmarshal_int();
/*  75 */     this.starttime = _os_.unmarshal_int();
/*  76 */     if (!_validator_()) {
/*  77 */       throw new VerifyError("validator failed");
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof SSynBattleTotalInfo)) {
/*  85 */       SSynBattleTotalInfo _o_ = (SSynBattleTotalInfo)_o1_;
/*  86 */       if (this.battlecfgid != _o_.battlecfgid) return false;
/*  87 */       if (!this.campinfos.equals(_o_.campinfos)) return false;
/*  88 */       if (this.stage != _o_.stage) return false;
/*  89 */       if (this.starttime != _o_.starttime) return false;
/*  90 */       return true;
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  96 */     int _h_ = 0;
/*  97 */     _h_ += this.battlecfgid;
/*  98 */     _h_ += this.campinfos.hashCode();
/*  99 */     _h_ += this.stage;
/* 100 */     _h_ += this.starttime;
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.battlecfgid).append(",");
/* 108 */     _sb_.append(this.campinfos).append(",");
/* 109 */     _sb_.append(this.stage).append(",");
/* 110 */     _sb_.append(this.starttime).append(",");
/* 111 */     _sb_.append(")");
/* 112 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\SSynBattleTotalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */