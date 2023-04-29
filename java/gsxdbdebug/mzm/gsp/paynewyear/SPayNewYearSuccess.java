/*     */ package mzm.gsp.paynewyear;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SPayNewYearSuccess
/*     */   extends __SPayNewYearSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12609029;
/*     */   public Octets role_name;
/*     */   public int aleardy_pay_new_year_times;
/*     */   public HashMap<Integer, Integer> award_item_map;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12609029;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SPayNewYearSuccess()
/*     */   {
/*  35 */     this.role_name = new Octets();
/*  36 */     this.award_item_map = new HashMap();
/*     */   }
/*     */   
/*     */   public SPayNewYearSuccess(Octets _role_name_, int _aleardy_pay_new_year_times_, HashMap<Integer, Integer> _award_item_map_) {
/*  40 */     this.role_name = _role_name_;
/*  41 */     this.aleardy_pay_new_year_times = _aleardy_pay_new_year_times_;
/*  42 */     this.award_item_map = _award_item_map_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.role_name);
/*  51 */     _os_.marshal(this.aleardy_pay_new_year_times);
/*  52 */     _os_.compact_uint32(this.award_item_map.size());
/*  53 */     for (Map.Entry<Integer, Integer> _e_ : this.award_item_map.entrySet()) {
/*  54 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  55 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.role_name = _os_.unmarshal_Octets();
/*  62 */     this.aleardy_pay_new_year_times = _os_.unmarshal_int();
/*  63 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  65 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  67 */       int _v_ = _os_.unmarshal_int();
/*  68 */       this.award_item_map.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof SPayNewYearSuccess)) {
/*  79 */       SPayNewYearSuccess _o_ = (SPayNewYearSuccess)_o1_;
/*  80 */       if (!this.role_name.equals(_o_.role_name)) return false;
/*  81 */       if (this.aleardy_pay_new_year_times != _o_.aleardy_pay_new_year_times) return false;
/*  82 */       if (!this.award_item_map.equals(_o_.award_item_map)) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += this.role_name.hashCode();
/*  91 */     _h_ += this.aleardy_pay_new_year_times;
/*  92 */     _h_ += this.award_item_map.hashCode();
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append("B").append(this.role_name.size()).append(",");
/* 100 */     _sb_.append(this.aleardy_pay_new_year_times).append(",");
/* 101 */     _sb_.append(this.award_item_map).append(",");
/* 102 */     _sb_.append(")");
/* 103 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paynewyear\SPayNewYearSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */