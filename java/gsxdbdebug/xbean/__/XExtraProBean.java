/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ import xdb.logs.LogInt;
/*     */ 
/*     */ public final class XExtraProBean extends XBean implements xbean.XExtraProBean
/*     */ {
/*     */   private int protype;
/*     */   private int provalue;
/*     */   private int islock;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.protype = 0;
/*  23 */     this.provalue = 0;
/*  24 */     this.islock = 0;
/*     */   }
/*     */   
/*     */   XExtraProBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.islock = 0;
/*     */   }
/*     */   
/*     */   public XExtraProBean()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public XExtraProBean(XExtraProBean _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   XExtraProBean(xbean.XExtraProBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof XExtraProBean)) { assign((XExtraProBean)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(XExtraProBean _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.protype = _o_.protype;
/*  56 */     this.provalue = _o_.provalue;
/*  57 */     this.islock = _o_.islock;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  62 */     this.protype = _o_.protype;
/*  63 */     this.provalue = _o_.provalue;
/*  64 */     this.islock = _o_.islock;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.marshal(this.protype);
/*  72 */     _os_.marshal(this.provalue);
/*  73 */     _os_.marshal(this.islock);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     this.protype = _os_.unmarshal_int();
/*  82 */     this.provalue = _os_.unmarshal_int();
/*  83 */     this.islock = _os_.unmarshal_int();
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*  91 */     int _size_ = 0;
/*  92 */     _size_ += CodedOutputStream.computeInt32Size(1, this.protype);
/*  93 */     _size_ += CodedOutputStream.computeInt32Size(2, this.provalue);
/*  94 */     _size_ += CodedOutputStream.computeInt32Size(3, this.islock);
/*  95 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 101 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 104 */       _output_.writeInt32(1, this.protype);
/* 105 */       _output_.writeInt32(2, this.provalue);
/* 106 */       _output_.writeInt32(3, this.islock);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 110 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 112 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 118 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 121 */       boolean done = false;
/* 122 */       while (!done)
/*     */       {
/* 124 */         int tag = _input_.readTag();
/* 125 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 129 */           done = true;
/* 130 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 134 */           this.protype = _input_.readInt32();
/* 135 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 139 */           this.provalue = _input_.readInt32();
/* 140 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 144 */           this.islock = _input_.readInt32();
/* 145 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 149 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 151 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 160 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 164 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 166 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.XExtraProBean copy()
/*     */   {
/* 172 */     _xdb_verify_unsafe_();
/* 173 */     return new XExtraProBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.XExtraProBean toData()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.XExtraProBean toBean()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new XExtraProBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.XExtraProBean toDataIf()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.XExtraProBean toBeanIf()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getProtype()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     return this.protype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getProvalue()
/*     */   {
/* 221 */     _xdb_verify_unsafe_();
/* 222 */     return this.provalue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getIslock()
/*     */   {
/* 229 */     _xdb_verify_unsafe_();
/* 230 */     return this.islock;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setProtype(int _v_)
/*     */   {
/* 237 */     _xdb_verify_unsafe_();
/* 238 */     xdb.Logs.logIf(new LogKey(this, "protype")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 242 */         new LogInt(this, XExtraProBean.this.protype)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 246 */             XExtraProBean.this.protype = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 250 */     });
/* 251 */     this.protype = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setProvalue(int _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "provalue")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 263 */         new LogInt(this, XExtraProBean.this.provalue)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             XExtraProBean.this.provalue = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.provalue = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIslock(int _v_)
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     xdb.Logs.logIf(new LogKey(this, "islock")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 284 */         new LogInt(this, XExtraProBean.this.islock)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             XExtraProBean.this.islock = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 292 */     });
/* 293 */     this.islock = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 299 */     _xdb_verify_unsafe_();
/* 300 */     XExtraProBean _o_ = null;
/* 301 */     if ((_o1_ instanceof XExtraProBean)) { _o_ = (XExtraProBean)_o1_;
/* 302 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 303 */       return false;
/* 304 */     if (this.protype != _o_.protype) return false;
/* 305 */     if (this.provalue != _o_.provalue) return false;
/* 306 */     if (this.islock != _o_.islock) return false;
/* 307 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 313 */     _xdb_verify_unsafe_();
/* 314 */     int _h_ = 0;
/* 315 */     _h_ += this.protype;
/* 316 */     _h_ += this.provalue;
/* 317 */     _h_ += this.islock;
/* 318 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 324 */     _xdb_verify_unsafe_();
/* 325 */     StringBuilder _sb_ = new StringBuilder();
/* 326 */     _sb_.append("(");
/* 327 */     _sb_.append(this.protype);
/* 328 */     _sb_.append(",");
/* 329 */     _sb_.append(this.provalue);
/* 330 */     _sb_.append(",");
/* 331 */     _sb_.append(this.islock);
/* 332 */     _sb_.append(")");
/* 333 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 339 */     ListenableBean lb = new ListenableBean();
/* 340 */     lb.add(new ListenableChanged().setVarName("protype"));
/* 341 */     lb.add(new ListenableChanged().setVarName("provalue"));
/* 342 */     lb.add(new ListenableChanged().setVarName("islock"));
/* 343 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.XExtraProBean {
/*     */     private Const() {}
/*     */     
/*     */     XExtraProBean nThis() {
/* 350 */       return XExtraProBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 356 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XExtraProBean copy()
/*     */     {
/* 362 */       return XExtraProBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XExtraProBean toData()
/*     */     {
/* 368 */       return XExtraProBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.XExtraProBean toBean()
/*     */     {
/* 373 */       return XExtraProBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XExtraProBean toDataIf()
/*     */     {
/* 379 */       return XExtraProBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.XExtraProBean toBeanIf()
/*     */     {
/* 384 */       return XExtraProBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getProtype()
/*     */     {
/* 391 */       XExtraProBean.this._xdb_verify_unsafe_();
/* 392 */       return XExtraProBean.this.protype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getProvalue()
/*     */     {
/* 399 */       XExtraProBean.this._xdb_verify_unsafe_();
/* 400 */       return XExtraProBean.this.provalue;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getIslock()
/*     */     {
/* 407 */       XExtraProBean.this._xdb_verify_unsafe_();
/* 408 */       return XExtraProBean.this.islock;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setProtype(int _v_)
/*     */     {
/* 415 */       XExtraProBean.this._xdb_verify_unsafe_();
/* 416 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setProvalue(int _v_)
/*     */     {
/* 423 */       XExtraProBean.this._xdb_verify_unsafe_();
/* 424 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIslock(int _v_)
/*     */     {
/* 431 */       XExtraProBean.this._xdb_verify_unsafe_();
/* 432 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 438 */       XExtraProBean.this._xdb_verify_unsafe_();
/* 439 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 445 */       XExtraProBean.this._xdb_verify_unsafe_();
/* 446 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 452 */       return XExtraProBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 458 */       return XExtraProBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 464 */       XExtraProBean.this._xdb_verify_unsafe_();
/* 465 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 471 */       return XExtraProBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 477 */       return XExtraProBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 483 */       XExtraProBean.this._xdb_verify_unsafe_();
/* 484 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 490 */       return XExtraProBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 496 */       return XExtraProBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 502 */       return XExtraProBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 508 */       return XExtraProBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 514 */       return XExtraProBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 520 */       return XExtraProBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 526 */       return XExtraProBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.XExtraProBean
/*     */   {
/*     */     private int protype;
/*     */     
/*     */     private int provalue;
/*     */     
/*     */     private int islock;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 542 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 547 */       this.islock = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.XExtraProBean _o1_)
/*     */     {
/* 552 */       if ((_o1_ instanceof XExtraProBean)) { assign((XExtraProBean)_o1_);
/* 553 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 554 */       } else if ((_o1_ instanceof XExtraProBean.Const)) assign(((XExtraProBean.Const)_o1_).nThis()); else {
/* 555 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(XExtraProBean _o_) {
/* 560 */       this.protype = _o_.protype;
/* 561 */       this.provalue = _o_.provalue;
/* 562 */       this.islock = _o_.islock;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 567 */       this.protype = _o_.protype;
/* 568 */       this.provalue = _o_.provalue;
/* 569 */       this.islock = _o_.islock;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 575 */       _os_.marshal(this.protype);
/* 576 */       _os_.marshal(this.provalue);
/* 577 */       _os_.marshal(this.islock);
/* 578 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 584 */       this.protype = _os_.unmarshal_int();
/* 585 */       this.provalue = _os_.unmarshal_int();
/* 586 */       this.islock = _os_.unmarshal_int();
/* 587 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 593 */       int _size_ = 0;
/* 594 */       _size_ += CodedOutputStream.computeInt32Size(1, this.protype);
/* 595 */       _size_ += CodedOutputStream.computeInt32Size(2, this.provalue);
/* 596 */       _size_ += CodedOutputStream.computeInt32Size(3, this.islock);
/* 597 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 605 */         _output_.writeInt32(1, this.protype);
/* 606 */         _output_.writeInt32(2, this.provalue);
/* 607 */         _output_.writeInt32(3, this.islock);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 611 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 613 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 621 */         boolean done = false;
/* 622 */         while (!done)
/*     */         {
/* 624 */           int tag = _input_.readTag();
/* 625 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 629 */             done = true;
/* 630 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 634 */             this.protype = _input_.readInt32();
/* 635 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 639 */             this.provalue = _input_.readInt32();
/* 640 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 644 */             this.islock = _input_.readInt32();
/* 645 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 649 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 651 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 660 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 664 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 666 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XExtraProBean copy()
/*     */     {
/* 672 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XExtraProBean toData()
/*     */     {
/* 678 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.XExtraProBean toBean()
/*     */     {
/* 683 */       return new XExtraProBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XExtraProBean toDataIf()
/*     */     {
/* 689 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.XExtraProBean toBeanIf()
/*     */     {
/* 694 */       return new XExtraProBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 700 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 704 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 708 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 712 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 716 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 720 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 724 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getProtype()
/*     */     {
/* 731 */       return this.protype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getProvalue()
/*     */     {
/* 738 */       return this.provalue;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getIslock()
/*     */     {
/* 745 */       return this.islock;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setProtype(int _v_)
/*     */     {
/* 752 */       this.protype = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setProvalue(int _v_)
/*     */     {
/* 759 */       this.provalue = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIslock(int _v_)
/*     */     {
/* 766 */       this.islock = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 772 */       if (!(_o1_ instanceof Data)) return false;
/* 773 */       Data _o_ = (Data)_o1_;
/* 774 */       if (this.protype != _o_.protype) return false;
/* 775 */       if (this.provalue != _o_.provalue) return false;
/* 776 */       if (this.islock != _o_.islock) return false;
/* 777 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 783 */       int _h_ = 0;
/* 784 */       _h_ += this.protype;
/* 785 */       _h_ += this.provalue;
/* 786 */       _h_ += this.islock;
/* 787 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 793 */       StringBuilder _sb_ = new StringBuilder();
/* 794 */       _sb_.append("(");
/* 795 */       _sb_.append(this.protype);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.provalue);
/* 798 */       _sb_.append(",");
/* 799 */       _sb_.append(this.islock);
/* 800 */       _sb_.append(")");
/* 801 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\XExtraProBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */