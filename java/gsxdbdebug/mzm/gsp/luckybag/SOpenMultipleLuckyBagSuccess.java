/*     */ package mzm.gsp.luckybag;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SOpenMultipleLuckyBagSuccess
/*     */   extends __SOpenMultipleLuckyBagSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12607499;
/*     */   public HashMap<Integer, Integer> items;
/*     */   public ArrayList<ItemInfo> award_items;
/*     */   public int instanceid;
/*     */   public byte use_yuanbao;
/*     */   public long client_yuanbao;
/*     */   public long need_yuanbao;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12607499;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SOpenMultipleLuckyBagSuccess()
/*     */   {
/*  38 */     this.items = new HashMap();
/*  39 */     this.award_items = new ArrayList();
/*     */   }
/*     */   
/*     */   public SOpenMultipleLuckyBagSuccess(HashMap<Integer, Integer> _items_, ArrayList<ItemInfo> _award_items_, int _instanceid_, byte _use_yuanbao_, long _client_yuanbao_, long _need_yuanbao_) {
/*  43 */     this.items = _items_;
/*  44 */     this.award_items = _award_items_;
/*  45 */     this.instanceid = _instanceid_;
/*  46 */     this.use_yuanbao = _use_yuanbao_;
/*  47 */     this.client_yuanbao = _client_yuanbao_;
/*  48 */     this.need_yuanbao = _need_yuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     for (ItemInfo _v_ : this.award_items)
/*  53 */       if (!_v_._validator_()) return false;
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
/*  64 */     for (ItemInfo _v_ : this.award_items) {
/*  65 */       _os_.marshal(_v_);
/*     */     }
/*  67 */     _os_.marshal(this.instanceid);
/*  68 */     _os_.marshal(this.use_yuanbao);
/*  69 */     _os_.marshal(this.client_yuanbao);
/*  70 */     _os_.marshal(this.need_yuanbao);
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  75 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  77 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  79 */       int _v_ = _os_.unmarshal_int();
/*  80 */       this.items.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  82 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  83 */       ItemInfo _v_ = new ItemInfo();
/*  84 */       _v_.unmarshal(_os_);
/*  85 */       this.award_items.add(_v_);
/*     */     }
/*  87 */     this.instanceid = _os_.unmarshal_int();
/*  88 */     this.use_yuanbao = _os_.unmarshal_byte();
/*  89 */     this.client_yuanbao = _os_.unmarshal_long();
/*  90 */     this.need_yuanbao = _os_.unmarshal_long();
/*  91 */     if (!_validator_()) {
/*  92 */       throw new VerifyError("validator failed");
/*     */     }
/*  94 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  98 */     if (_o1_ == this) return true;
/*  99 */     if ((_o1_ instanceof SOpenMultipleLuckyBagSuccess)) {
/* 100 */       SOpenMultipleLuckyBagSuccess _o_ = (SOpenMultipleLuckyBagSuccess)_o1_;
/* 101 */       if (!this.items.equals(_o_.items)) return false;
/* 102 */       if (!this.award_items.equals(_o_.award_items)) return false;
/* 103 */       if (this.instanceid != _o_.instanceid) return false;
/* 104 */       if (this.use_yuanbao != _o_.use_yuanbao) return false;
/* 105 */       if (this.client_yuanbao != _o_.client_yuanbao) return false;
/* 106 */       if (this.need_yuanbao != _o_.need_yuanbao) return false;
/* 107 */       return true;
/*     */     }
/* 109 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 113 */     int _h_ = 0;
/* 114 */     _h_ += this.items.hashCode();
/* 115 */     _h_ += this.award_items.hashCode();
/* 116 */     _h_ += this.instanceid;
/* 117 */     _h_ += this.use_yuanbao;
/* 118 */     _h_ += (int)this.client_yuanbao;
/* 119 */     _h_ += (int)this.need_yuanbao;
/* 120 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 124 */     StringBuilder _sb_ = new StringBuilder();
/* 125 */     _sb_.append("(");
/* 126 */     _sb_.append(this.items).append(",");
/* 127 */     _sb_.append(this.award_items).append(",");
/* 128 */     _sb_.append(this.instanceid).append(",");
/* 129 */     _sb_.append(this.use_yuanbao).append(",");
/* 130 */     _sb_.append(this.client_yuanbao).append(",");
/* 131 */     _sb_.append(this.need_yuanbao).append(",");
/* 132 */     _sb_.append(")");
/* 133 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckybag\SOpenMultipleLuckyBagSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */