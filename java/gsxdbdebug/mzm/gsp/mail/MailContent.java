/*     */ package mzm.gsp.mail;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ public class MailContent implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public static final int TYPE_MAIL_FULL_CFG = 1;
/*     */   public static final int TYPE_MAIL_AUTO = 2;
/*     */   public static final int TYPE_MAIL_CFG = 3;
/*     */   public static final int CONTENT_MAIL_CFG_ID = 51;
/*     */   public static final int CONTENT_MAIL_TITLE = 52;
/*     */   public static final int CONTENT_MAIL_TYPE = 53;
/*     */   public static final int CONTENT_MAIL_CONTENT = 54;
/*     */   public static final int FORMAT_STRING_TITLE = 201;
/*     */   public static final int FORMAT_STRING_CONTENT = 202;
/*     */   public int mailcontenttype;
/*     */   public HashMap<Integer, String> contentmap;
/*     */   public HashMap<Integer, FormatArgs> formatargsmap;
/*     */   
/*     */   public MailContent()
/*     */   {
/*  24 */     this.contentmap = new HashMap();
/*  25 */     this.formatargsmap = new HashMap();
/*     */   }
/*     */   
/*     */   public MailContent(int _mailcontenttype_, HashMap<Integer, String> _contentmap_, HashMap<Integer, FormatArgs> _formatargsmap_) {
/*  29 */     this.mailcontenttype = _mailcontenttype_;
/*  30 */     this.contentmap = _contentmap_;
/*  31 */     this.formatargsmap = _formatargsmap_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  35 */     for (Map.Entry<Integer, FormatArgs> _e_ : this.formatargsmap.entrySet()) {
/*  36 */       if (!((FormatArgs)_e_.getValue())._validator_()) return false;
/*     */     }
/*  38 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  42 */     _os_.marshal(this.mailcontenttype);
/*  43 */     _os_.compact_uint32(this.contentmap.size());
/*  44 */     for (Map.Entry<Integer, String> _e_ : this.contentmap.entrySet()) {
/*  45 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  46 */       _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*     */     }
/*  48 */     _os_.compact_uint32(this.formatargsmap.size());
/*  49 */     for (Map.Entry<Integer, FormatArgs> _e_ : this.formatargsmap.entrySet()) {
/*  50 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  51 */       _os_.marshal((com.goldhuman.Common.Marshal.Marshal)_e_.getValue());
/*     */     }
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  57 */     this.mailcontenttype = _os_.unmarshal_int();
/*  58 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  60 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  62 */       String _v_ = _os_.unmarshal_String("UTF-16LE");
/*  63 */       this.contentmap.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  65 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  67 */       int _k_ = _os_.unmarshal_int();
/*  68 */       FormatArgs _v_ = new FormatArgs();
/*  69 */       _v_.unmarshal(_os_);
/*  70 */       this.formatargsmap.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof MailContent)) {
/*  78 */       MailContent _o_ = (MailContent)_o1_;
/*  79 */       if (this.mailcontenttype != _o_.mailcontenttype) return false;
/*  80 */       if (!this.contentmap.equals(_o_.contentmap)) return false;
/*  81 */       if (!this.formatargsmap.equals(_o_.formatargsmap)) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.mailcontenttype;
/*  90 */     _h_ += this.contentmap.hashCode();
/*  91 */     _h_ += this.formatargsmap.hashCode();
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.mailcontenttype).append(",");
/*  99 */     _sb_.append(this.contentmap).append(",");
/* 100 */     _sb_.append(this.formatargsmap).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mail\MailContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */