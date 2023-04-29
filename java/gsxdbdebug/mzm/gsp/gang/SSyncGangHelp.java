/*     */ package mzm.gsp.gang;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ 
/*     */ public class SSyncGangHelp extends __SSyncGangHelp__ {
/*     */   public static final int PROTOCOL_TYPE = 12589846;
/*     */   public static final int TYPE_HUN = 0;
/*     */   public static final int TYPE_CIRCLETASK = 1;
/*     */   public static final int TYPE_LUNHUIQUESTION = 2;
/*     */   public static final int TYPE_QING_YUN_XUE_TANG_QUESTION = 3;
/*     */   public static final int HUN_ROLE_ID = 10;
/*     */   public static final int HUN_ITEM_ID = 11;
/*     */   public static final int HUN_ITEM_NUM = 12;
/*     */   public static final int HUN_ITEM_SLOT_NUM = 13;
/*     */   public static final int ROLE_ID = 14;
/*     */   public static final int QUESTION_ID = 15;
/*     */   public static final int PAGE_INDEX = 16;
/*     */   public static final int TEAM_ID = 17;
/*     */   public static final int TASK_ID = 18;
/*     */   public int helpertype;
/*     */   public HashMap<Integer, String> paramstring;
/*     */   public HashMap<Integer, Long> paramlong;
/*     */   public HashMap<Integer, Integer> paramint;
/*     */   
/*     */   protected void process() {}
/*     */   
/*  27 */   public int getType() { return 12589846; }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncGangHelp()
/*     */   {
/*  50 */     this.paramstring = new HashMap();
/*  51 */     this.paramlong = new HashMap();
/*  52 */     this.paramint = new HashMap();
/*     */   }
/*     */   
/*     */   public SSyncGangHelp(int _helpertype_, HashMap<Integer, String> _paramstring_, HashMap<Integer, Long> _paramlong_, HashMap<Integer, Integer> _paramint_) {
/*  56 */     this.helpertype = _helpertype_;
/*  57 */     this.paramstring = _paramstring_;
/*  58 */     this.paramlong = _paramlong_;
/*  59 */     this.paramint = _paramint_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  63 */     return true;
/*     */   }
/*     */   
/*     */   public com.goldhuman.Common.Marshal.OctetsStream marshal(com.goldhuman.Common.Marshal.OctetsStream _os_) {
/*  67 */     _os_.marshal(this.helpertype);
/*  68 */     _os_.compact_uint32(this.paramstring.size());
/*  69 */     for (java.util.Map.Entry<Integer, String> _e_ : this.paramstring.entrySet()) {
/*  70 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  71 */       _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*     */     }
/*  73 */     _os_.compact_uint32(this.paramlong.size());
/*  74 */     for (java.util.Map.Entry<Integer, Long> _e_ : this.paramlong.entrySet()) {
/*  75 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  76 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */     }
/*  78 */     _os_.compact_uint32(this.paramint.size());
/*  79 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.paramint.entrySet()) {
/*  80 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  81 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public com.goldhuman.Common.Marshal.OctetsStream unmarshal(com.goldhuman.Common.Marshal.OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  87 */     this.helpertype = _os_.unmarshal_int();
/*  88 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  90 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  92 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  93 */       this.paramstring.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  95 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  97 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  99 */       long _v_ = _os_.unmarshal_long();
/* 100 */       this.paramlong.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*     */     }
/* 102 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 104 */       int _k_ = _os_.unmarshal_int();
/*     */       
/* 106 */       int _v_ = _os_.unmarshal_int();
/* 107 */       this.paramint.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/* 109 */     if (!_validator_()) {
/* 110 */       throw new VerifyError("validator failed");
/*     */     }
/* 112 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 116 */     if (_o1_ == this) return true;
/* 117 */     if ((_o1_ instanceof SSyncGangHelp)) {
/* 118 */       SSyncGangHelp _o_ = (SSyncGangHelp)_o1_;
/* 119 */       if (this.helpertype != _o_.helpertype) return false;
/* 120 */       if (!this.paramstring.equals(_o_.paramstring)) return false;
/* 121 */       if (!this.paramlong.equals(_o_.paramlong)) return false;
/* 122 */       if (!this.paramint.equals(_o_.paramint)) return false;
/* 123 */       return true;
/*     */     }
/* 125 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 129 */     int _h_ = 0;
/* 130 */     _h_ += this.helpertype;
/* 131 */     _h_ += this.paramstring.hashCode();
/* 132 */     _h_ += this.paramlong.hashCode();
/* 133 */     _h_ += this.paramint.hashCode();
/* 134 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 138 */     StringBuilder _sb_ = new StringBuilder();
/* 139 */     _sb_.append("(");
/* 140 */     _sb_.append(this.helpertype).append(",");
/* 141 */     _sb_.append(this.paramstring).append(",");
/* 142 */     _sb_.append(this.paramlong).append(",");
/* 143 */     _sb_.append(this.paramint).append(",");
/* 144 */     _sb_.append(")");
/* 145 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\SSyncGangHelp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */