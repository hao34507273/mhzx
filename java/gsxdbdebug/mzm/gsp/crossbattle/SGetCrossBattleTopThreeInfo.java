/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetCrossBattleTopThreeInfo
/*     */   extends __SGetCrossBattleTopThreeInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617088;
/*     */   public int session;
/*     */   public ArrayList<CorpsInfo> champion_corps;
/*     */   public ArrayList<CorpsInfo> second_place_corps;
/*     */   public ArrayList<CorpsInfo> third_place_corps;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617088;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetCrossBattleTopThreeInfo()
/*     */   {
/*  36 */     this.champion_corps = new ArrayList();
/*  37 */     this.second_place_corps = new ArrayList();
/*  38 */     this.third_place_corps = new ArrayList();
/*     */   }
/*     */   
/*     */   public SGetCrossBattleTopThreeInfo(int _session_, ArrayList<CorpsInfo> _champion_corps_, ArrayList<CorpsInfo> _second_place_corps_, ArrayList<CorpsInfo> _third_place_corps_) {
/*  42 */     this.session = _session_;
/*  43 */     this.champion_corps = _champion_corps_;
/*  44 */     this.second_place_corps = _second_place_corps_;
/*  45 */     this.third_place_corps = _third_place_corps_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     for (CorpsInfo _v_ : this.champion_corps)
/*  50 */       if (!_v_._validator_()) return false;
/*  51 */     for (CorpsInfo _v_ : this.second_place_corps)
/*  52 */       if (!_v_._validator_()) return false;
/*  53 */     for (CorpsInfo _v_ : this.third_place_corps)
/*  54 */       if (!_v_._validator_()) return false;
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.session);
/*  60 */     _os_.compact_uint32(this.champion_corps.size());
/*  61 */     for (CorpsInfo _v_ : this.champion_corps) {
/*  62 */       _os_.marshal(_v_);
/*     */     }
/*  64 */     _os_.compact_uint32(this.second_place_corps.size());
/*  65 */     for (CorpsInfo _v_ : this.second_place_corps) {
/*  66 */       _os_.marshal(_v_);
/*     */     }
/*  68 */     _os_.compact_uint32(this.third_place_corps.size());
/*  69 */     for (CorpsInfo _v_ : this.third_place_corps) {
/*  70 */       _os_.marshal(_v_);
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  76 */     this.session = _os_.unmarshal_int();
/*  77 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  78 */       CorpsInfo _v_ = new CorpsInfo();
/*  79 */       _v_.unmarshal(_os_);
/*  80 */       this.champion_corps.add(_v_);
/*     */     }
/*  82 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  83 */       CorpsInfo _v_ = new CorpsInfo();
/*  84 */       _v_.unmarshal(_os_);
/*  85 */       this.second_place_corps.add(_v_);
/*     */     }
/*  87 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  88 */       CorpsInfo _v_ = new CorpsInfo();
/*  89 */       _v_.unmarshal(_os_);
/*  90 */       this.third_place_corps.add(_v_);
/*     */     }
/*  92 */     if (!_validator_()) {
/*  93 */       throw new VerifyError("validator failed");
/*     */     }
/*  95 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  99 */     if (_o1_ == this) return true;
/* 100 */     if ((_o1_ instanceof SGetCrossBattleTopThreeInfo)) {
/* 101 */       SGetCrossBattleTopThreeInfo _o_ = (SGetCrossBattleTopThreeInfo)_o1_;
/* 102 */       if (this.session != _o_.session) return false;
/* 103 */       if (!this.champion_corps.equals(_o_.champion_corps)) return false;
/* 104 */       if (!this.second_place_corps.equals(_o_.second_place_corps)) return false;
/* 105 */       if (!this.third_place_corps.equals(_o_.third_place_corps)) return false;
/* 106 */       return true;
/*     */     }
/* 108 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 112 */     int _h_ = 0;
/* 113 */     _h_ += this.session;
/* 114 */     _h_ += this.champion_corps.hashCode();
/* 115 */     _h_ += this.second_place_corps.hashCode();
/* 116 */     _h_ += this.third_place_corps.hashCode();
/* 117 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 121 */     StringBuilder _sb_ = new StringBuilder();
/* 122 */     _sb_.append("(");
/* 123 */     _sb_.append(this.session).append(",");
/* 124 */     _sb_.append(this.champion_corps).append(",");
/* 125 */     _sb_.append(this.second_place_corps).append(",");
/* 126 */     _sb_.append(this.third_place_corps).append(",");
/* 127 */     _sb_.append(")");
/* 128 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SGetCrossBattleTopThreeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */