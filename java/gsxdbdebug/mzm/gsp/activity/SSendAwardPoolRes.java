/*     */ package mzm.gsp.activity;
/*     */ 
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
/*     */ public class SSendAwardPoolRes
/*     */   extends __SSendAwardPoolRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12587601;
/*     */   public static final int MONEY_YUANBAO = 0;
/*     */   public static final int MONEY_GOLD = 1;
/*     */   public static final int MONEY_SILVER = 2;
/*     */   public HashMap<Integer, Integer> awardmoney;
/*     */   public HashMap<Integer, Integer> awarditems;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12587601;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSendAwardPoolRes()
/*     */   {
/*  38 */     this.awardmoney = new HashMap();
/*  39 */     this.awarditems = new HashMap();
/*     */   }
/*     */   
/*     */   public SSendAwardPoolRes(HashMap<Integer, Integer> _awardmoney_, HashMap<Integer, Integer> _awarditems_) {
/*  43 */     this.awardmoney = _awardmoney_;
/*  44 */     this.awarditems = _awarditems_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.compact_uint32(this.awardmoney.size());
/*  53 */     for (Map.Entry<Integer, Integer> _e_ : this.awardmoney.entrySet()) {
/*  54 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  55 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  57 */     _os_.compact_uint32(this.awarditems.size());
/*  58 */     for (Map.Entry<Integer, Integer> _e_ : this.awarditems.entrySet()) {
/*  59 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  60 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  68 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  70 */       int _v_ = _os_.unmarshal_int();
/*  71 */       this.awardmoney.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  73 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  75 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  77 */       int _v_ = _os_.unmarshal_int();
/*  78 */       this.awarditems.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  80 */     if (!_validator_()) {
/*  81 */       throw new VerifyError("validator failed");
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  87 */     if (_o1_ == this) return true;
/*  88 */     if ((_o1_ instanceof SSendAwardPoolRes)) {
/*  89 */       SSendAwardPoolRes _o_ = (SSendAwardPoolRes)_o1_;
/*  90 */       if (!this.awardmoney.equals(_o_.awardmoney)) return false;
/*  91 */       if (!this.awarditems.equals(_o_.awarditems)) return false;
/*  92 */       return true;
/*     */     }
/*  94 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  98 */     int _h_ = 0;
/*  99 */     _h_ += this.awardmoney.hashCode();
/* 100 */     _h_ += this.awarditems.hashCode();
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.awardmoney).append(",");
/* 108 */     _sb_.append(this.awarditems).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\activity\SSendAwardPoolRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */