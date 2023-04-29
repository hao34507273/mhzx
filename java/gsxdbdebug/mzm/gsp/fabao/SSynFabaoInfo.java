/*     */ package mzm.gsp.fabao;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.item.ItemInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynFabaoInfo
/*     */   extends __SSynFabaoInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12595990;
/*     */   public HashMap<Integer, ItemInfo> euqipfabao;
/*     */   public HashMap<Integer, LongJingInfo> euqiplongjing;
/*     */   public int disfabaotype;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12595990;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynFabaoInfo()
/*     */   {
/*  35 */     this.euqipfabao = new HashMap();
/*  36 */     this.euqiplongjing = new HashMap();
/*     */   }
/*     */   
/*     */   public SSynFabaoInfo(HashMap<Integer, ItemInfo> _euqipfabao_, HashMap<Integer, LongJingInfo> _euqiplongjing_, int _disfabaotype_) {
/*  40 */     this.euqipfabao = _euqipfabao_;
/*  41 */     this.euqiplongjing = _euqiplongjing_;
/*  42 */     this.disfabaotype = _disfabaotype_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     for (Map.Entry<Integer, ItemInfo> _e_ : this.euqipfabao.entrySet()) {
/*  47 */       if (!((ItemInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  49 */     for (Map.Entry<Integer, LongJingInfo> _e_ : this.euqiplongjing.entrySet()) {
/*  50 */       if (!((LongJingInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.compact_uint32(this.euqipfabao.size());
/*  57 */     for (Map.Entry<Integer, ItemInfo> _e_ : this.euqipfabao.entrySet()) {
/*  58 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  59 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  61 */     _os_.compact_uint32(this.euqiplongjing.size());
/*  62 */     for (Map.Entry<Integer, LongJingInfo> _e_ : this.euqiplongjing.entrySet()) {
/*  63 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  64 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  66 */     _os_.marshal(this.disfabaotype);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  71 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  73 */       int _k_ = _os_.unmarshal_int();
/*  74 */       ItemInfo _v_ = new ItemInfo();
/*  75 */       _v_.unmarshal(_os_);
/*  76 */       this.euqipfabao.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  78 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  80 */       int _k_ = _os_.unmarshal_int();
/*  81 */       LongJingInfo _v_ = new LongJingInfo();
/*  82 */       _v_.unmarshal(_os_);
/*  83 */       this.euqiplongjing.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  85 */     this.disfabaotype = _os_.unmarshal_int();
/*  86 */     if (!_validator_()) {
/*  87 */       throw new VerifyError("validator failed");
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  93 */     if (_o1_ == this) return true;
/*  94 */     if ((_o1_ instanceof SSynFabaoInfo)) {
/*  95 */       SSynFabaoInfo _o_ = (SSynFabaoInfo)_o1_;
/*  96 */       if (!this.euqipfabao.equals(_o_.euqipfabao)) return false;
/*  97 */       if (!this.euqiplongjing.equals(_o_.euqiplongjing)) return false;
/*  98 */       if (this.disfabaotype != _o_.disfabaotype) return false;
/*  99 */       return true;
/*     */     }
/* 101 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 105 */     int _h_ = 0;
/* 106 */     _h_ += this.euqipfabao.hashCode();
/* 107 */     _h_ += this.euqiplongjing.hashCode();
/* 108 */     _h_ += this.disfabaotype;
/* 109 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 113 */     StringBuilder _sb_ = new StringBuilder();
/* 114 */     _sb_.append("(");
/* 115 */     _sb_.append(this.euqipfabao).append(",");
/* 116 */     _sb_.append(this.euqiplongjing).append(",");
/* 117 */     _sb_.append(this.disfabaotype).append(",");
/* 118 */     _sb_.append(")");
/* 119 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\SSynFabaoInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */