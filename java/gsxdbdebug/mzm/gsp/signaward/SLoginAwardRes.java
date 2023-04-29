/*     */ package mzm.gsp.signaward;
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
/*     */ public class SLoginAwardRes
/*     */   extends __SLoginAwardRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12593410;
/*     */   public int loginday;
/*     */   public ArrayList<Integer> canawarddays;
/*     */   public ArrayList<Integer> awardeddays;
/*     */   public HashMap<Integer, Integer> item2num;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12593410;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SLoginAwardRes()
/*     */   {
/*  34 */     this.canawarddays = new ArrayList();
/*  35 */     this.awardeddays = new ArrayList();
/*  36 */     this.item2num = new HashMap();
/*     */   }
/*     */   
/*     */   public SLoginAwardRes(int _loginday_, ArrayList<Integer> _canawarddays_, ArrayList<Integer> _awardeddays_, HashMap<Integer, Integer> _item2num_) {
/*  40 */     this.loginday = _loginday_;
/*  41 */     this.canawarddays = _canawarddays_;
/*  42 */     this.awardeddays = _awardeddays_;
/*  43 */     this.item2num = _item2num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.loginday);
/*  52 */     _os_.compact_uint32(this.canawarddays.size());
/*  53 */     for (Integer _v_ : this.canawarddays) {
/*  54 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  56 */     _os_.compact_uint32(this.awardeddays.size());
/*  57 */     for (Integer _v_ : this.awardeddays) {
/*  58 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  60 */     _os_.compact_uint32(this.item2num.size());
/*  61 */     for (Map.Entry<Integer, Integer> _e_ : this.item2num.entrySet()) {
/*  62 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  63 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  69 */     this.loginday = _os_.unmarshal_int();
/*  70 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  72 */       int _v_ = _os_.unmarshal_int();
/*  73 */       this.canawarddays.add(Integer.valueOf(_v_));
/*     */     }
/*  75 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  77 */       int _v_ = _os_.unmarshal_int();
/*  78 */       this.awardeddays.add(Integer.valueOf(_v_));
/*     */     }
/*  80 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  82 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  84 */       int _v_ = _os_.unmarshal_int();
/*  85 */       this.item2num.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  87 */     if (!_validator_()) {
/*  88 */       throw new VerifyError("validator failed");
/*     */     }
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  94 */     if (_o1_ == this) return true;
/*  95 */     if ((_o1_ instanceof SLoginAwardRes)) {
/*  96 */       SLoginAwardRes _o_ = (SLoginAwardRes)_o1_;
/*  97 */       if (this.loginday != _o_.loginday) return false;
/*  98 */       if (!this.canawarddays.equals(_o_.canawarddays)) return false;
/*  99 */       if (!this.awardeddays.equals(_o_.awardeddays)) return false;
/* 100 */       if (!this.item2num.equals(_o_.item2num)) return false;
/* 101 */       return true;
/*     */     }
/* 103 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 107 */     int _h_ = 0;
/* 108 */     _h_ += this.loginday;
/* 109 */     _h_ += this.canawarddays.hashCode();
/* 110 */     _h_ += this.awardeddays.hashCode();
/* 111 */     _h_ += this.item2num.hashCode();
/* 112 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 116 */     StringBuilder _sb_ = new StringBuilder();
/* 117 */     _sb_.append("(");
/* 118 */     _sb_.append(this.loginday).append(",");
/* 119 */     _sb_.append(this.canawarddays).append(",");
/* 120 */     _sb_.append(this.awardeddays).append(",");
/* 121 */     _sb_.append(this.item2num).append(",");
/* 122 */     _sb_.append(")");
/* 123 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\signaward\SLoginAwardRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */