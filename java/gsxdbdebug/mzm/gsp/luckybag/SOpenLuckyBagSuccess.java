/*     */ package mzm.gsp.luckybag;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SOpenLuckyBagSuccess
/*     */   extends __SOpenLuckyBagSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12607491;
/*     */   public HashMap<Integer, Integer> items;
/*     */   public HashMap<Integer, Integer> award_items;
/*     */   public int index;
/*     */   public int instanceid;
/*     */   public byte use_yuanbao;
/*     */   public long client_yuanbao;
/*     */   public long need_yuanbao;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12607491;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SOpenLuckyBagSuccess()
/*     */   {
/*  39 */     this.items = new HashMap();
/*  40 */     this.award_items = new HashMap();
/*     */   }
/*     */   
/*     */   public SOpenLuckyBagSuccess(HashMap<Integer, Integer> _items_, HashMap<Integer, Integer> _award_items_, int _index_, int _instanceid_, byte _use_yuanbao_, long _client_yuanbao_, long _need_yuanbao_) {
/*  44 */     this.items = _items_;
/*  45 */     this.award_items = _award_items_;
/*  46 */     this.index = _index_;
/*  47 */     this.instanceid = _instanceid_;
/*  48 */     this.use_yuanbao = _use_yuanbao_;
/*  49 */     this.client_yuanbao = _client_yuanbao_;
/*  50 */     this.need_yuanbao = _need_yuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  58 */     _os_.compact_uint32(this.items.size());
/*  59 */     for (Map.Entry<Integer, Integer> _e_ : this.items.entrySet()) {
/*  60 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  61 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  63 */     _os_.compact_uint32(this.award_items.size());
/*  64 */     for (Map.Entry<Integer, Integer> _e_ : this.award_items.entrySet()) {
/*  65 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  66 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  68 */     _os_.marshal(this.index);
/*  69 */     _os_.marshal(this.instanceid);
/*  70 */     _os_.marshal(this.use_yuanbao);
/*  71 */     _os_.marshal(this.client_yuanbao);
/*  72 */     _os_.marshal(this.need_yuanbao);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  77 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  79 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  81 */       int _v_ = _os_.unmarshal_int();
/*  82 */       this.items.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  84 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  86 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  88 */       int _v_ = _os_.unmarshal_int();
/*  89 */       this.award_items.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  91 */     this.index = _os_.unmarshal_int();
/*  92 */     this.instanceid = _os_.unmarshal_int();
/*  93 */     this.use_yuanbao = _os_.unmarshal_byte();
/*  94 */     this.client_yuanbao = _os_.unmarshal_long();
/*  95 */     this.need_yuanbao = _os_.unmarshal_long();
/*  96 */     if (!_validator_()) {
/*  97 */       throw new VerifyError("validator failed");
/*     */     }
/*  99 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 103 */     if (_o1_ == this) return true;
/* 104 */     if ((_o1_ instanceof SOpenLuckyBagSuccess)) {
/* 105 */       SOpenLuckyBagSuccess _o_ = (SOpenLuckyBagSuccess)_o1_;
/* 106 */       if (!this.items.equals(_o_.items)) return false;
/* 107 */       if (!this.award_items.equals(_o_.award_items)) return false;
/* 108 */       if (this.index != _o_.index) return false;
/* 109 */       if (this.instanceid != _o_.instanceid) return false;
/* 110 */       if (this.use_yuanbao != _o_.use_yuanbao) return false;
/* 111 */       if (this.client_yuanbao != _o_.client_yuanbao) return false;
/* 112 */       if (this.need_yuanbao != _o_.need_yuanbao) return false;
/* 113 */       return true;
/*     */     }
/* 115 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 119 */     int _h_ = 0;
/* 120 */     _h_ += this.items.hashCode();
/* 121 */     _h_ += this.award_items.hashCode();
/* 122 */     _h_ += this.index;
/* 123 */     _h_ += this.instanceid;
/* 124 */     _h_ += this.use_yuanbao;
/* 125 */     _h_ += (int)this.client_yuanbao;
/* 126 */     _h_ += (int)this.need_yuanbao;
/* 127 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 131 */     StringBuilder _sb_ = new StringBuilder();
/* 132 */     _sb_.append("(");
/* 133 */     _sb_.append(this.items).append(",");
/* 134 */     _sb_.append(this.award_items).append(",");
/* 135 */     _sb_.append(this.index).append(",");
/* 136 */     _sb_.append(this.instanceid).append(",");
/* 137 */     _sb_.append(this.use_yuanbao).append(",");
/* 138 */     _sb_.append(this.client_yuanbao).append(",");
/* 139 */     _sb_.append(this.need_yuanbao).append(",");
/* 140 */     _sb_.append(")");
/* 141 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\SOpenLuckyBagSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */