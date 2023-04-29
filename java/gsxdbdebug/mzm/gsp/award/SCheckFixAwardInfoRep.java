/*     */ package mzm.gsp.award;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ public class SCheckFixAwardInfoRep
/*     */   extends __SCheckFixAwardInfoRep__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12583426;
/*     */   public ArrayList<MoneyAwardBean> moneyvalue;
/*     */   public ArrayList<ExpAwardBean> expvalue;
/*     */   public HashMap<Integer, Integer> itemmap;
/*     */   public int appellationid;
/*     */   public int titleid;
/*     */   public int itemindex;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12583426;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SCheckFixAwardInfoRep()
/*     */   {
/*  36 */     this.moneyvalue = new ArrayList();
/*  37 */     this.expvalue = new ArrayList();
/*  38 */     this.itemmap = new HashMap();
/*     */   }
/*     */   
/*     */   public SCheckFixAwardInfoRep(ArrayList<MoneyAwardBean> _moneyvalue_, ArrayList<ExpAwardBean> _expvalue_, HashMap<Integer, Integer> _itemmap_, int _appellationid_, int _titleid_, int _itemindex_) {
/*  42 */     this.moneyvalue = _moneyvalue_;
/*  43 */     this.expvalue = _expvalue_;
/*  44 */     this.itemmap = _itemmap_;
/*  45 */     this.appellationid = _appellationid_;
/*  46 */     this.titleid = _titleid_;
/*  47 */     this.itemindex = _itemindex_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     for (MoneyAwardBean _v_ : this.moneyvalue)
/*  52 */       if (!_v_._validator_()) return false;
/*  53 */     for (ExpAwardBean _v_ : this.expvalue)
/*  54 */       if (!_v_._validator_()) return false;
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.compact_uint32(this.moneyvalue.size());
/*  60 */     for (MoneyAwardBean _v_ : this.moneyvalue) {
/*  61 */       _os_.marshal(_v_);
/*     */     }
/*  63 */     _os_.compact_uint32(this.expvalue.size());
/*  64 */     for (ExpAwardBean _v_ : this.expvalue) {
/*  65 */       _os_.marshal(_v_);
/*     */     }
/*  67 */     _os_.compact_uint32(this.itemmap.size());
/*  68 */     for (Map.Entry<Integer, Integer> _e_ : this.itemmap.entrySet()) {
/*  69 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  70 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  72 */     _os_.marshal(this.appellationid);
/*  73 */     _os_.marshal(this.titleid);
/*  74 */     _os_.marshal(this.itemindex);
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  79 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  80 */       MoneyAwardBean _v_ = new MoneyAwardBean();
/*  81 */       _v_.unmarshal(_os_);
/*  82 */       this.moneyvalue.add(_v_);
/*     */     }
/*  84 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  85 */       ExpAwardBean _v_ = new ExpAwardBean();
/*  86 */       _v_.unmarshal(_os_);
/*  87 */       this.expvalue.add(_v_);
/*     */     }
/*  89 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  91 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  93 */       int _v_ = _os_.unmarshal_int();
/*  94 */       this.itemmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  96 */     this.appellationid = _os_.unmarshal_int();
/*  97 */     this.titleid = _os_.unmarshal_int();
/*  98 */     this.itemindex = _os_.unmarshal_int();
/*  99 */     if (!_validator_()) {
/* 100 */       throw new VerifyError("validator failed");
/*     */     }
/* 102 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 106 */     if (_o1_ == this) return true;
/* 107 */     if ((_o1_ instanceof SCheckFixAwardInfoRep)) {
/* 108 */       SCheckFixAwardInfoRep _o_ = (SCheckFixAwardInfoRep)_o1_;
/* 109 */       if (!this.moneyvalue.equals(_o_.moneyvalue)) return false;
/* 110 */       if (!this.expvalue.equals(_o_.expvalue)) return false;
/* 111 */       if (!this.itemmap.equals(_o_.itemmap)) return false;
/* 112 */       if (this.appellationid != _o_.appellationid) return false;
/* 113 */       if (this.titleid != _o_.titleid) return false;
/* 114 */       if (this.itemindex != _o_.itemindex) return false;
/* 115 */       return true;
/*     */     }
/* 117 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 121 */     int _h_ = 0;
/* 122 */     _h_ += this.moneyvalue.hashCode();
/* 123 */     _h_ += this.expvalue.hashCode();
/* 124 */     _h_ += this.itemmap.hashCode();
/* 125 */     _h_ += this.appellationid;
/* 126 */     _h_ += this.titleid;
/* 127 */     _h_ += this.itemindex;
/* 128 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 132 */     StringBuilder _sb_ = new StringBuilder();
/* 133 */     _sb_.append("(");
/* 134 */     _sb_.append(this.moneyvalue).append(",");
/* 135 */     _sb_.append(this.expvalue).append(",");
/* 136 */     _sb_.append(this.itemmap).append(",");
/* 137 */     _sb_.append(this.appellationid).append(",");
/* 138 */     _sb_.append(this.titleid).append(",");
/* 139 */     _sb_.append(this.itemindex).append(",");
/* 140 */     _sb_.append(")");
/* 141 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\SCheckFixAwardInfoRep.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */