/*     */ package mzm.gsp.mibao;
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
/*     */ public class SBuyMiBaoSuccess
/*     */   extends __SBuyMiBaoSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12603395;
/*     */   public ArrayList<MiBaoItemInfo> random_item_map;
/*     */   public int current_lucky_value;
/*     */   public int current_score;
/*     */   public int current_mibao_index_id;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12603395;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBuyMiBaoSuccess()
/*     */   {
/*  36 */     this.random_item_map = new ArrayList();
/*     */   }
/*     */   
/*     */   public SBuyMiBaoSuccess(ArrayList<MiBaoItemInfo> _random_item_map_, int _current_lucky_value_, int _current_score_, int _current_mibao_index_id_) {
/*  40 */     this.random_item_map = _random_item_map_;
/*  41 */     this.current_lucky_value = _current_lucky_value_;
/*  42 */     this.current_score = _current_score_;
/*  43 */     this.current_mibao_index_id = _current_mibao_index_id_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     for (MiBaoItemInfo _v_ : this.random_item_map)
/*  48 */       if (!_v_._validator_()) return false;
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.compact_uint32(this.random_item_map.size());
/*  54 */     for (MiBaoItemInfo _v_ : this.random_item_map) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     _os_.marshal(this.current_lucky_value);
/*  58 */     _os_.marshal(this.current_score);
/*  59 */     _os_.marshal(this.current_mibao_index_id);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  65 */       MiBaoItemInfo _v_ = new MiBaoItemInfo();
/*  66 */       _v_.unmarshal(_os_);
/*  67 */       this.random_item_map.add(_v_);
/*     */     }
/*  69 */     this.current_lucky_value = _os_.unmarshal_int();
/*  70 */     this.current_score = _os_.unmarshal_int();
/*  71 */     this.current_mibao_index_id = _os_.unmarshal_int();
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SBuyMiBaoSuccess)) {
/*  81 */       SBuyMiBaoSuccess _o_ = (SBuyMiBaoSuccess)_o1_;
/*  82 */       if (!this.random_item_map.equals(_o_.random_item_map)) return false;
/*  83 */       if (this.current_lucky_value != _o_.current_lucky_value) return false;
/*  84 */       if (this.current_score != _o_.current_score) return false;
/*  85 */       if (this.current_mibao_index_id != _o_.current_mibao_index_id) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.random_item_map.hashCode();
/*  94 */     _h_ += this.current_lucky_value;
/*  95 */     _h_ += this.current_score;
/*  96 */     _h_ += this.current_mibao_index_id;
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.random_item_map).append(",");
/* 104 */     _sb_.append(this.current_lucky_value).append(",");
/* 105 */     _sb_.append(this.current_score).append(",");
/* 106 */     _sb_.append(this.current_mibao_index_id).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mibao\SBuyMiBaoSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */