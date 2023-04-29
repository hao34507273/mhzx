/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class MailContent extends XBean implements xbean.MailContent
/*     */ {
/*     */   private int mailcontenttype;
/*     */   private HashMap<Integer, String> contentmap;
/*     */   private HashMap<Integer, xbean.FormatArgs> formatargsmap;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.mailcontenttype = 0;
/*  23 */     this.contentmap.clear();
/*  24 */     this.formatargsmap.clear();
/*     */   }
/*     */   
/*     */   MailContent(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.contentmap = new HashMap();
/*  31 */     this.formatargsmap = new HashMap();
/*     */   }
/*     */   
/*     */   public MailContent()
/*     */   {
/*  36 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MailContent(MailContent _o_)
/*     */   {
/*  41 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MailContent(xbean.MailContent _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  46 */     super(_xp_, _vn_);
/*  47 */     if ((_o1_ instanceof MailContent)) { assign((MailContent)_o1_);
/*  48 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  49 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  50 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MailContent _o_) {
/*  55 */     _o_._xdb_verify_unsafe_();
/*  56 */     this.mailcontenttype = _o_.mailcontenttype;
/*  57 */     this.contentmap = new HashMap();
/*  58 */     for (Map.Entry<Integer, String> _e_ : _o_.contentmap.entrySet())
/*  59 */       this.contentmap.put(_e_.getKey(), _e_.getValue());
/*  60 */     this.formatargsmap = new HashMap();
/*  61 */     for (Map.Entry<Integer, xbean.FormatArgs> _e_ : _o_.formatargsmap.entrySet()) {
/*  62 */       this.formatargsmap.put(_e_.getKey(), new FormatArgs((xbean.FormatArgs)_e_.getValue(), this, "formatargsmap"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Data _o_) {
/*  67 */     this.mailcontenttype = _o_.mailcontenttype;
/*  68 */     this.contentmap = new HashMap();
/*  69 */     for (Map.Entry<Integer, String> _e_ : _o_.contentmap.entrySet())
/*  70 */       this.contentmap.put(_e_.getKey(), _e_.getValue());
/*  71 */     this.formatargsmap = new HashMap();
/*  72 */     for (Map.Entry<Integer, xbean.FormatArgs> _e_ : _o_.formatargsmap.entrySet()) {
/*  73 */       this.formatargsmap.put(_e_.getKey(), new FormatArgs((xbean.FormatArgs)_e_.getValue(), this, "formatargsmap"));
/*     */     }
/*     */   }
/*     */   
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     _os_.marshal(this.mailcontenttype);
/*  81 */     _os_.compact_uint32(this.contentmap.size());
/*  82 */     for (Map.Entry<Integer, String> _e_ : this.contentmap.entrySet())
/*     */     {
/*  84 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  85 */       _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*     */     }
/*  87 */     _os_.compact_uint32(this.formatargsmap.size());
/*  88 */     for (Map.Entry<Integer, xbean.FormatArgs> _e_ : this.formatargsmap.entrySet())
/*     */     {
/*  90 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  91 */       ((xbean.FormatArgs)_e_.getValue()).marshal(_os_);
/*     */     }
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/* 100 */     this.mailcontenttype = _os_.unmarshal_int();
/*     */     
/* 102 */     int size = _os_.uncompact_uint32();
/* 103 */     if (size >= 12)
/*     */     {
/* 105 */       this.contentmap = new HashMap(size * 2);
/*     */     }
/* 107 */     for (; size > 0; size--)
/*     */     {
/* 109 */       int _k_ = 0;
/* 110 */       _k_ = _os_.unmarshal_int();
/* 111 */       String _v_ = "";
/* 112 */       _v_ = _os_.unmarshal_String("UTF-16LE");
/* 113 */       this.contentmap.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/*     */ 
/* 117 */     int size = _os_.uncompact_uint32();
/* 118 */     if (size >= 12)
/*     */     {
/* 120 */       this.formatargsmap = new HashMap(size * 2);
/*     */     }
/* 122 */     for (; size > 0; size--)
/*     */     {
/* 124 */       int _k_ = 0;
/* 125 */       _k_ = _os_.unmarshal_int();
/* 126 */       xbean.FormatArgs _v_ = new FormatArgs(0, this, "formatargsmap");
/* 127 */       _v_.unmarshal(_os_);
/* 128 */       this.formatargsmap.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*     */     
/* 131 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 137 */     _xdb_verify_unsafe_();
/* 138 */     int _size_ = 0;
/* 139 */     _size_ += CodedOutputStream.computeInt32Size(1, this.mailcontenttype);
/* 140 */     for (Map.Entry<Integer, String> _e_ : this.contentmap.entrySet())
/*     */     {
/* 142 */       _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*     */       try
/*     */       {
/* 145 */         _size_ += CodedOutputStream.computeBytesSize(2, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/* 149 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/*     */     }
/* 152 */     for (Map.Entry<Integer, xbean.FormatArgs> _e_ : this.formatargsmap.entrySet())
/*     */     {
/* 154 */       _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 155 */       _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*     */     }
/* 157 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 163 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 166 */       _output_.writeInt32(1, this.mailcontenttype);
/* 167 */       for (Map.Entry<Integer, String> _e_ : this.contentmap.entrySet())
/*     */       {
/* 169 */         _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 170 */         _output_.writeBytes(2, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*     */       }
/* 172 */       for (Map.Entry<Integer, xbean.FormatArgs> _e_ : this.formatargsmap.entrySet())
/*     */       {
/* 174 */         _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 175 */         _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 180 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 182 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 188 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 191 */       boolean done = false;
/* 192 */       while (!done)
/*     */       {
/* 194 */         int tag = _input_.readTag();
/* 195 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 199 */           done = true;
/* 200 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 204 */           this.mailcontenttype = _input_.readInt32();
/* 205 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 209 */           int _k_ = 0;
/* 210 */           _k_ = _input_.readInt32();
/* 211 */           int readTag = _input_.readTag();
/* 212 */           if (18 != readTag)
/*     */           {
/* 214 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 216 */           String _v_ = "";
/* 217 */           _v_ = _input_.readBytes().toString("UTF-16LE");
/* 218 */           this.contentmap.put(Integer.valueOf(_k_), _v_);
/* 219 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 223 */           int _k_ = 0;
/* 224 */           _k_ = _input_.readInt32();
/* 225 */           int readTag = _input_.readTag();
/* 226 */           if (26 != readTag)
/*     */           {
/* 228 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */           }
/* 230 */           xbean.FormatArgs _v_ = new FormatArgs(0, this, "formatargsmap");
/* 231 */           _input_.readMessage(_v_);
/* 232 */           this.formatargsmap.put(Integer.valueOf(_k_), _v_);
/* 233 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 237 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 239 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 248 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 252 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 254 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MailContent copy()
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     return new MailContent(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MailContent toData()
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/* 268 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MailContent toBean()
/*     */   {
/* 273 */     _xdb_verify_unsafe_();
/* 274 */     return new MailContent(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MailContent toDataIf()
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MailContent toBeanIf()
/*     */   {
/* 286 */     _xdb_verify_unsafe_();
/* 287 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 293 */     _xdb_verify_unsafe_();
/* 294 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getMailcontenttype()
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     return this.mailcontenttype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, String> getContentmap()
/*     */   {
/* 309 */     _xdb_verify_unsafe_();
/* 310 */     return xdb.Logs.logMap(new LogKey(this, "contentmap"), this.contentmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, String> getContentmapAsData()
/*     */   {
/* 317 */     _xdb_verify_unsafe_();
/*     */     
/* 319 */     MailContent _o_ = this;
/* 320 */     Map<Integer, String> contentmap = new HashMap();
/* 321 */     for (Map.Entry<Integer, String> _e_ : _o_.contentmap.entrySet())
/* 322 */       contentmap.put(_e_.getKey(), _e_.getValue());
/* 323 */     return contentmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.FormatArgs> getFormatargsmap()
/*     */   {
/* 330 */     _xdb_verify_unsafe_();
/* 331 */     return xdb.Logs.logMap(new LogKey(this, "formatargsmap"), this.formatargsmap);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Map<Integer, xbean.FormatArgs> getFormatargsmapAsData()
/*     */   {
/* 338 */     _xdb_verify_unsafe_();
/*     */     
/* 340 */     MailContent _o_ = this;
/* 341 */     Map<Integer, xbean.FormatArgs> formatargsmap = new HashMap();
/* 342 */     for (Map.Entry<Integer, xbean.FormatArgs> _e_ : _o_.formatargsmap.entrySet())
/* 343 */       formatargsmap.put(_e_.getKey(), new FormatArgs.Data((xbean.FormatArgs)_e_.getValue()));
/* 344 */     return formatargsmap;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMailcontenttype(int _v_)
/*     */   {
/* 351 */     _xdb_verify_unsafe_();
/* 352 */     xdb.Logs.logIf(new LogKey(this, "mailcontenttype")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 356 */         new xdb.logs.LogInt(this, MailContent.this.mailcontenttype)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 360 */             MailContent.this.mailcontenttype = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 364 */     });
/* 365 */     this.mailcontenttype = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 371 */     _xdb_verify_unsafe_();
/* 372 */     MailContent _o_ = null;
/* 373 */     if ((_o1_ instanceof MailContent)) { _o_ = (MailContent)_o1_;
/* 374 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 375 */       return false;
/* 376 */     if (this.mailcontenttype != _o_.mailcontenttype) return false;
/* 377 */     if (!this.contentmap.equals(_o_.contentmap)) return false;
/* 378 */     if (!this.formatargsmap.equals(_o_.formatargsmap)) return false;
/* 379 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 385 */     _xdb_verify_unsafe_();
/* 386 */     int _h_ = 0;
/* 387 */     _h_ += this.mailcontenttype;
/* 388 */     _h_ += this.contentmap.hashCode();
/* 389 */     _h_ += this.formatargsmap.hashCode();
/* 390 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 396 */     _xdb_verify_unsafe_();
/* 397 */     StringBuilder _sb_ = new StringBuilder();
/* 398 */     _sb_.append("(");
/* 399 */     _sb_.append(this.mailcontenttype);
/* 400 */     _sb_.append(",");
/* 401 */     _sb_.append(this.contentmap);
/* 402 */     _sb_.append(",");
/* 403 */     _sb_.append(this.formatargsmap);
/* 404 */     _sb_.append(")");
/* 405 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 411 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 412 */     lb.add(new xdb.logs.ListenableChanged().setVarName("mailcontenttype"));
/* 413 */     lb.add(new xdb.logs.ListenableMap().setVarName("contentmap"));
/* 414 */     lb.add(new xdb.logs.ListenableMap().setVarName("formatargsmap"));
/* 415 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MailContent {
/*     */     private Const() {}
/*     */     
/*     */     MailContent nThis() {
/* 422 */       return MailContent.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 428 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MailContent copy()
/*     */     {
/* 434 */       return MailContent.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MailContent toData()
/*     */     {
/* 440 */       return MailContent.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MailContent toBean()
/*     */     {
/* 445 */       return MailContent.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MailContent toDataIf()
/*     */     {
/* 451 */       return MailContent.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MailContent toBeanIf()
/*     */     {
/* 456 */       return MailContent.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMailcontenttype()
/*     */     {
/* 463 */       MailContent.this._xdb_verify_unsafe_();
/* 464 */       return MailContent.this.mailcontenttype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, String> getContentmap()
/*     */     {
/* 471 */       MailContent.this._xdb_verify_unsafe_();
/* 472 */       return xdb.Consts.constMap(MailContent.this.contentmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, String> getContentmapAsData()
/*     */     {
/* 479 */       MailContent.this._xdb_verify_unsafe_();
/*     */       
/* 481 */       MailContent _o_ = MailContent.this;
/* 482 */       Map<Integer, String> contentmap = new HashMap();
/* 483 */       for (Map.Entry<Integer, String> _e_ : _o_.contentmap.entrySet())
/* 484 */         contentmap.put(_e_.getKey(), _e_.getValue());
/* 485 */       return contentmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.FormatArgs> getFormatargsmap()
/*     */     {
/* 492 */       MailContent.this._xdb_verify_unsafe_();
/* 493 */       return xdb.Consts.constMap(MailContent.this.formatargsmap);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.FormatArgs> getFormatargsmapAsData()
/*     */     {
/* 500 */       MailContent.this._xdb_verify_unsafe_();
/*     */       
/* 502 */       MailContent _o_ = MailContent.this;
/* 503 */       Map<Integer, xbean.FormatArgs> formatargsmap = new HashMap();
/* 504 */       for (Map.Entry<Integer, xbean.FormatArgs> _e_ : _o_.formatargsmap.entrySet())
/* 505 */         formatargsmap.put(_e_.getKey(), new FormatArgs.Data((xbean.FormatArgs)_e_.getValue()));
/* 506 */       return formatargsmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMailcontenttype(int _v_)
/*     */     {
/* 513 */       MailContent.this._xdb_verify_unsafe_();
/* 514 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 520 */       MailContent.this._xdb_verify_unsafe_();
/* 521 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 527 */       MailContent.this._xdb_verify_unsafe_();
/* 528 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 534 */       return MailContent.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 540 */       return MailContent.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 546 */       MailContent.this._xdb_verify_unsafe_();
/* 547 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 553 */       return MailContent.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 559 */       return MailContent.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 565 */       MailContent.this._xdb_verify_unsafe_();
/* 566 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 572 */       return MailContent.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 578 */       return MailContent.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 584 */       return MailContent.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 590 */       return MailContent.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 596 */       return MailContent.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 602 */       return MailContent.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 608 */       return MailContent.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MailContent
/*     */   {
/*     */     private int mailcontenttype;
/*     */     
/*     */     private HashMap<Integer, String> contentmap;
/*     */     
/*     */     private HashMap<Integer, xbean.FormatArgs> formatargsmap;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 624 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 629 */       this.contentmap = new HashMap();
/* 630 */       this.formatargsmap = new HashMap();
/*     */     }
/*     */     
/*     */     Data(xbean.MailContent _o1_)
/*     */     {
/* 635 */       if ((_o1_ instanceof MailContent)) { assign((MailContent)_o1_);
/* 636 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 637 */       } else if ((_o1_ instanceof MailContent.Const)) assign(((MailContent.Const)_o1_).nThis()); else {
/* 638 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MailContent _o_) {
/* 643 */       this.mailcontenttype = _o_.mailcontenttype;
/* 644 */       this.contentmap = new HashMap();
/* 645 */       for (Map.Entry<Integer, String> _e_ : _o_.contentmap.entrySet())
/* 646 */         this.contentmap.put(_e_.getKey(), _e_.getValue());
/* 647 */       this.formatargsmap = new HashMap();
/* 648 */       for (Map.Entry<Integer, xbean.FormatArgs> _e_ : _o_.formatargsmap.entrySet()) {
/* 649 */         this.formatargsmap.put(_e_.getKey(), new FormatArgs.Data((xbean.FormatArgs)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Data _o_) {
/* 654 */       this.mailcontenttype = _o_.mailcontenttype;
/* 655 */       this.contentmap = new HashMap();
/* 656 */       for (Map.Entry<Integer, String> _e_ : _o_.contentmap.entrySet())
/* 657 */         this.contentmap.put(_e_.getKey(), _e_.getValue());
/* 658 */       this.formatargsmap = new HashMap();
/* 659 */       for (Map.Entry<Integer, xbean.FormatArgs> _e_ : _o_.formatargsmap.entrySet()) {
/* 660 */         this.formatargsmap.put(_e_.getKey(), new FormatArgs.Data((xbean.FormatArgs)_e_.getValue()));
/*     */       }
/*     */     }
/*     */     
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 666 */       _os_.marshal(this.mailcontenttype);
/* 667 */       _os_.compact_uint32(this.contentmap.size());
/* 668 */       for (Map.Entry<Integer, String> _e_ : this.contentmap.entrySet())
/*     */       {
/* 670 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 671 */         _os_.marshal((String)_e_.getValue(), "UTF-16LE");
/*     */       }
/* 673 */       _os_.compact_uint32(this.formatargsmap.size());
/* 674 */       for (Map.Entry<Integer, xbean.FormatArgs> _e_ : this.formatargsmap.entrySet())
/*     */       {
/* 676 */         _os_.marshal(((Integer)_e_.getKey()).intValue());
/* 677 */         ((xbean.FormatArgs)_e_.getValue()).marshal(_os_);
/*     */       }
/* 679 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 685 */       this.mailcontenttype = _os_.unmarshal_int();
/*     */       
/* 687 */       int size = _os_.uncompact_uint32();
/* 688 */       if (size >= 12)
/*     */       {
/* 690 */         this.contentmap = new HashMap(size * 2);
/*     */       }
/* 692 */       for (; size > 0; size--)
/*     */       {
/* 694 */         int _k_ = 0;
/* 695 */         _k_ = _os_.unmarshal_int();
/* 696 */         String _v_ = "";
/* 697 */         _v_ = _os_.unmarshal_String("UTF-16LE");
/* 698 */         this.contentmap.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/*     */ 
/* 702 */       int size = _os_.uncompact_uint32();
/* 703 */       if (size >= 12)
/*     */       {
/* 705 */         this.formatargsmap = new HashMap(size * 2);
/*     */       }
/* 707 */       for (; size > 0; size--)
/*     */       {
/* 709 */         int _k_ = 0;
/* 710 */         _k_ = _os_.unmarshal_int();
/* 711 */         xbean.FormatArgs _v_ = xbean.Pod.newFormatArgsData();
/* 712 */         _v_.unmarshal(_os_);
/* 713 */         this.formatargsmap.put(Integer.valueOf(_k_), _v_);
/*     */       }
/*     */       
/* 716 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 722 */       int _size_ = 0;
/* 723 */       _size_ += CodedOutputStream.computeInt32Size(1, this.mailcontenttype);
/* 724 */       for (Map.Entry<Integer, String> _e_ : this.contentmap.entrySet())
/*     */       {
/* 726 */         _size_ += CodedOutputStream.computeInt32Size(2, ((Integer)_e_.getKey()).intValue());
/*     */         try
/*     */         {
/* 729 */           _size_ += CodedOutputStream.computeBytesSize(2, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*     */         }
/*     */         catch (java.io.UnsupportedEncodingException e)
/*     */         {
/* 733 */           throw new RuntimeException("UTF-16LE not supported?", e);
/*     */         }
/*     */       }
/* 736 */       for (Map.Entry<Integer, xbean.FormatArgs> _e_ : this.formatargsmap.entrySet())
/*     */       {
/* 738 */         _size_ += CodedOutputStream.computeInt32Size(3, ((Integer)_e_.getKey()).intValue());
/* 739 */         _size_ += CodedOutputStream.computeMessageSize(3, (ppbio.Message)_e_.getValue());
/*     */       }
/* 741 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 749 */         _output_.writeInt32(1, this.mailcontenttype);
/* 750 */         for (Map.Entry<Integer, String> _e_ : this.contentmap.entrySet())
/*     */         {
/* 752 */           _output_.writeInt32(2, ((Integer)_e_.getKey()).intValue());
/* 753 */           _output_.writeBytes(2, ppbio.ByteString.copyFrom((String)_e_.getValue(), "UTF-16LE"));
/*     */         }
/* 755 */         for (Map.Entry<Integer, xbean.FormatArgs> _e_ : this.formatargsmap.entrySet())
/*     */         {
/* 757 */           _output_.writeInt32(3, ((Integer)_e_.getKey()).intValue());
/* 758 */           _output_.writeMessage(3, (ppbio.Message)_e_.getValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 763 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 765 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 773 */         boolean done = false;
/* 774 */         while (!done)
/*     */         {
/* 776 */           int tag = _input_.readTag();
/* 777 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 781 */             done = true;
/* 782 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 786 */             this.mailcontenttype = _input_.readInt32();
/* 787 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 791 */             int _k_ = 0;
/* 792 */             _k_ = _input_.readInt32();
/* 793 */             int readTag = _input_.readTag();
/* 794 */             if (18 != readTag)
/*     */             {
/* 796 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 798 */             String _v_ = "";
/* 799 */             _v_ = _input_.readBytes().toString("UTF-16LE");
/* 800 */             this.contentmap.put(Integer.valueOf(_k_), _v_);
/* 801 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 805 */             int _k_ = 0;
/* 806 */             _k_ = _input_.readInt32();
/* 807 */             int readTag = _input_.readTag();
/* 808 */             if (26 != readTag)
/*     */             {
/* 810 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*     */             }
/* 812 */             xbean.FormatArgs _v_ = xbean.Pod.newFormatArgsData();
/* 813 */             _input_.readMessage(_v_);
/* 814 */             this.formatargsmap.put(Integer.valueOf(_k_), _v_);
/* 815 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 819 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 821 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 830 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 834 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 836 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MailContent copy()
/*     */     {
/* 842 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MailContent toData()
/*     */     {
/* 848 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MailContent toBean()
/*     */     {
/* 853 */       return new MailContent(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MailContent toDataIf()
/*     */     {
/* 859 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MailContent toBeanIf()
/*     */     {
/* 864 */       return new MailContent(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 870 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 874 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 878 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 882 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 886 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 890 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 894 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getMailcontenttype()
/*     */     {
/* 901 */       return this.mailcontenttype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, String> getContentmap()
/*     */     {
/* 908 */       return this.contentmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, String> getContentmapAsData()
/*     */     {
/* 915 */       return this.contentmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.FormatArgs> getFormatargsmap()
/*     */     {
/* 922 */       return this.formatargsmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Map<Integer, xbean.FormatArgs> getFormatargsmapAsData()
/*     */     {
/* 929 */       return this.formatargsmap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMailcontenttype(int _v_)
/*     */     {
/* 936 */       this.mailcontenttype = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 942 */       if (!(_o1_ instanceof Data)) return false;
/* 943 */       Data _o_ = (Data)_o1_;
/* 944 */       if (this.mailcontenttype != _o_.mailcontenttype) return false;
/* 945 */       if (!this.contentmap.equals(_o_.contentmap)) return false;
/* 946 */       if (!this.formatargsmap.equals(_o_.formatargsmap)) return false;
/* 947 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 953 */       int _h_ = 0;
/* 954 */       _h_ += this.mailcontenttype;
/* 955 */       _h_ += this.contentmap.hashCode();
/* 956 */       _h_ += this.formatargsmap.hashCode();
/* 957 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 963 */       StringBuilder _sb_ = new StringBuilder();
/* 964 */       _sb_.append("(");
/* 965 */       _sb_.append(this.mailcontenttype);
/* 966 */       _sb_.append(",");
/* 967 */       _sb_.append(this.contentmap);
/* 968 */       _sb_.append(",");
/* 969 */       _sb_.append(this.formatargsmap);
/* 970 */       _sb_.append(")");
/* 971 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MailContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */