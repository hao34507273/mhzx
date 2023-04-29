/*     */ package mzm.gsp.mail;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class MailData implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public static final int EXTRA_KEY_MAIL_DEL_TIME_SEC = 1;
/*     */   public static final int EXTRA_KEY_ZERO_PROFIT = 2;
/*     */   public int mailindex;
/*     */   public MailContent mailcontent;
/*     */   public int readstate;
/*     */   public int createtime;
/*     */   public int hasthing;
/*     */   public HashMap<Integer, Integer> extraparam;
/*     */   
/*     */   public MailData()
/*     */   {
/*  20 */     this.mailcontent = new MailContent();
/*  21 */     this.extraparam = new HashMap();
/*     */   }
/*     */   
/*     */   public MailData(int _mailindex_, MailContent _mailcontent_, int _readstate_, int _createtime_, int _hasthing_, HashMap<Integer, Integer> _extraparam_) {
/*  25 */     this.mailindex = _mailindex_;
/*  26 */     this.mailcontent = _mailcontent_;
/*  27 */     this.readstate = _readstate_;
/*  28 */     this.createtime = _createtime_;
/*  29 */     this.hasthing = _hasthing_;
/*  30 */     this.extraparam = _extraparam_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  34 */     if (!this.mailcontent._validator_()) return false;
/*  35 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  39 */     _os_.marshal(this.mailindex);
/*  40 */     _os_.marshal(this.mailcontent);
/*  41 */     _os_.marshal(this.readstate);
/*  42 */     _os_.marshal(this.createtime);
/*  43 */     _os_.marshal(this.hasthing);
/*  44 */     _os_.compact_uint32(this.extraparam.size());
/*  45 */     for (Map.Entry<Integer, Integer> _e_ : this.extraparam.entrySet()) {
/*  46 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  47 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  53 */     this.mailindex = _os_.unmarshal_int();
/*  54 */     this.mailcontent.unmarshal(_os_);
/*  55 */     this.readstate = _os_.unmarshal_int();
/*  56 */     this.createtime = _os_.unmarshal_int();
/*  57 */     this.hasthing = _os_.unmarshal_int();
/*  58 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  60 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  62 */       int _v_ = _os_.unmarshal_int();
/*  63 */       this.extraparam.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof MailData)) {
/*  71 */       MailData _o_ = (MailData)_o1_;
/*  72 */       if (this.mailindex != _o_.mailindex) return false;
/*  73 */       if (!this.mailcontent.equals(_o_.mailcontent)) return false;
/*  74 */       if (this.readstate != _o_.readstate) return false;
/*  75 */       if (this.createtime != _o_.createtime) return false;
/*  76 */       if (this.hasthing != _o_.hasthing) return false;
/*  77 */       if (!this.extraparam.equals(_o_.extraparam)) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.mailindex;
/*  86 */     _h_ += this.mailcontent.hashCode();
/*  87 */     _h_ += this.readstate;
/*  88 */     _h_ += this.createtime;
/*  89 */     _h_ += this.hasthing;
/*  90 */     _h_ += this.extraparam.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.mailindex).append(",");
/*  98 */     _sb_.append(this.mailcontent).append(",");
/*  99 */     _sb_.append(this.readstate).append(",");
/* 100 */     _sb_.append(this.createtime).append(",");
/* 101 */     _sb_.append(this.hasthing).append(",");
/* 102 */     _sb_.append(this.extraparam).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mail\MailData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */