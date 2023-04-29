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
/*     */ public final class WingProperty extends XBean implements xbean.WingProperty
/*     */ {
/*     */   private int propertytype;
/*     */   private int propertyvalue;
/*     */   private int propertyphase;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.propertytype = 0;
/*  23 */     this.propertyvalue = 1;
/*  24 */     this.propertyphase = 1;
/*     */   }
/*     */   
/*     */   WingProperty(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.propertytype = 0;
/*  31 */     this.propertyvalue = 1;
/*  32 */     this.propertyphase = 1;
/*     */   }
/*     */   
/*     */   public WingProperty()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public WingProperty(WingProperty _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   WingProperty(xbean.WingProperty _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof WingProperty)) { assign((WingProperty)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(WingProperty _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.propertytype = _o_.propertytype;
/*  58 */     this.propertyvalue = _o_.propertyvalue;
/*  59 */     this.propertyphase = _o_.propertyphase;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  64 */     this.propertytype = _o_.propertytype;
/*  65 */     this.propertyvalue = _o_.propertyvalue;
/*  66 */     this.propertyphase = _o_.propertyphase;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.marshal(this.propertytype);
/*  74 */     _os_.marshal(this.propertyvalue);
/*  75 */     _os_.marshal(this.propertyphase);
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     this.propertytype = _os_.unmarshal_int();
/*  84 */     this.propertyvalue = _os_.unmarshal_int();
/*  85 */     this.propertyphase = _os_.unmarshal_int();
/*  86 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*  93 */     int _size_ = 0;
/*  94 */     _size_ += CodedOutputStream.computeInt32Size(1, this.propertytype);
/*  95 */     _size_ += CodedOutputStream.computeInt32Size(2, this.propertyvalue);
/*  96 */     _size_ += CodedOutputStream.computeInt32Size(3, this.propertyphase);
/*  97 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 103 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 106 */       _output_.writeInt32(1, this.propertytype);
/* 107 */       _output_.writeInt32(2, this.propertyvalue);
/* 108 */       _output_.writeInt32(3, this.propertyphase);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 112 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 114 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 123 */       boolean done = false;
/* 124 */       while (!done)
/*     */       {
/* 126 */         int tag = _input_.readTag();
/* 127 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 131 */           done = true;
/* 132 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 136 */           this.propertytype = _input_.readInt32();
/* 137 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 141 */           this.propertyvalue = _input_.readInt32();
/* 142 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 146 */           this.propertyphase = _input_.readInt32();
/* 147 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 151 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 153 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 162 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 166 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 168 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.WingProperty copy()
/*     */   {
/* 174 */     _xdb_verify_unsafe_();
/* 175 */     return new WingProperty(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.WingProperty toData()
/*     */   {
/* 181 */     _xdb_verify_unsafe_();
/* 182 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.WingProperty toBean()
/*     */   {
/* 187 */     _xdb_verify_unsafe_();
/* 188 */     return new WingProperty(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.WingProperty toDataIf()
/*     */   {
/* 194 */     _xdb_verify_unsafe_();
/* 195 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.WingProperty toBeanIf()
/*     */   {
/* 200 */     _xdb_verify_unsafe_();
/* 201 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 207 */     _xdb_verify_unsafe_();
/* 208 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPropertytype()
/*     */   {
/* 215 */     _xdb_verify_unsafe_();
/* 216 */     return this.propertytype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPropertyvalue()
/*     */   {
/* 223 */     _xdb_verify_unsafe_();
/* 224 */     return this.propertyvalue;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getPropertyphase()
/*     */   {
/* 231 */     _xdb_verify_unsafe_();
/* 232 */     return this.propertyphase;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPropertytype(int _v_)
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/* 240 */     xdb.Logs.logIf(new LogKey(this, "propertytype")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 244 */         new LogInt(this, WingProperty.this.propertytype)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 248 */             WingProperty.this.propertytype = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 252 */     });
/* 253 */     this.propertytype = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPropertyvalue(int _v_)
/*     */   {
/* 260 */     _xdb_verify_unsafe_();
/* 261 */     xdb.Logs.logIf(new LogKey(this, "propertyvalue")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 265 */         new LogInt(this, WingProperty.this.propertyvalue)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 269 */             WingProperty.this.propertyvalue = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 273 */     });
/* 274 */     this.propertyvalue = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setPropertyphase(int _v_)
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/* 282 */     xdb.Logs.logIf(new LogKey(this, "propertyphase")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 286 */         new LogInt(this, WingProperty.this.propertyphase)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 290 */             WingProperty.this.propertyphase = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 294 */     });
/* 295 */     this.propertyphase = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     WingProperty _o_ = null;
/* 303 */     if ((_o1_ instanceof WingProperty)) { _o_ = (WingProperty)_o1_;
/* 304 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 305 */       return false;
/* 306 */     if (this.propertytype != _o_.propertytype) return false;
/* 307 */     if (this.propertyvalue != _o_.propertyvalue) return false;
/* 308 */     if (this.propertyphase != _o_.propertyphase) return false;
/* 309 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 315 */     _xdb_verify_unsafe_();
/* 316 */     int _h_ = 0;
/* 317 */     _h_ += this.propertytype;
/* 318 */     _h_ += this.propertyvalue;
/* 319 */     _h_ += this.propertyphase;
/* 320 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 326 */     _xdb_verify_unsafe_();
/* 327 */     StringBuilder _sb_ = new StringBuilder();
/* 328 */     _sb_.append("(");
/* 329 */     _sb_.append(this.propertytype);
/* 330 */     _sb_.append(",");
/* 331 */     _sb_.append(this.propertyvalue);
/* 332 */     _sb_.append(",");
/* 333 */     _sb_.append(this.propertyphase);
/* 334 */     _sb_.append(")");
/* 335 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 341 */     ListenableBean lb = new ListenableBean();
/* 342 */     lb.add(new ListenableChanged().setVarName("propertytype"));
/* 343 */     lb.add(new ListenableChanged().setVarName("propertyvalue"));
/* 344 */     lb.add(new ListenableChanged().setVarName("propertyphase"));
/* 345 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.WingProperty {
/*     */     private Const() {}
/*     */     
/*     */     WingProperty nThis() {
/* 352 */       return WingProperty.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 358 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WingProperty copy()
/*     */     {
/* 364 */       return WingProperty.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WingProperty toData()
/*     */     {
/* 370 */       return WingProperty.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.WingProperty toBean()
/*     */     {
/* 375 */       return WingProperty.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WingProperty toDataIf()
/*     */     {
/* 381 */       return WingProperty.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.WingProperty toBeanIf()
/*     */     {
/* 386 */       return WingProperty.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPropertytype()
/*     */     {
/* 393 */       WingProperty.this._xdb_verify_unsafe_();
/* 394 */       return WingProperty.this.propertytype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPropertyvalue()
/*     */     {
/* 401 */       WingProperty.this._xdb_verify_unsafe_();
/* 402 */       return WingProperty.this.propertyvalue;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPropertyphase()
/*     */     {
/* 409 */       WingProperty.this._xdb_verify_unsafe_();
/* 410 */       return WingProperty.this.propertyphase;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPropertytype(int _v_)
/*     */     {
/* 417 */       WingProperty.this._xdb_verify_unsafe_();
/* 418 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPropertyvalue(int _v_)
/*     */     {
/* 425 */       WingProperty.this._xdb_verify_unsafe_();
/* 426 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPropertyphase(int _v_)
/*     */     {
/* 433 */       WingProperty.this._xdb_verify_unsafe_();
/* 434 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 440 */       WingProperty.this._xdb_verify_unsafe_();
/* 441 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 447 */       WingProperty.this._xdb_verify_unsafe_();
/* 448 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 454 */       return WingProperty.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 460 */       return WingProperty.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 466 */       WingProperty.this._xdb_verify_unsafe_();
/* 467 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 473 */       return WingProperty.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 479 */       return WingProperty.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 485 */       WingProperty.this._xdb_verify_unsafe_();
/* 486 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 492 */       return WingProperty.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 498 */       return WingProperty.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 504 */       return WingProperty.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 510 */       return WingProperty.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 516 */       return WingProperty.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 522 */       return WingProperty.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 528 */       return WingProperty.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.WingProperty
/*     */   {
/*     */     private int propertytype;
/*     */     
/*     */     private int propertyvalue;
/*     */     
/*     */     private int propertyphase;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 544 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 549 */       this.propertytype = 0;
/* 550 */       this.propertyvalue = 1;
/* 551 */       this.propertyphase = 1;
/*     */     }
/*     */     
/*     */     Data(xbean.WingProperty _o1_)
/*     */     {
/* 556 */       if ((_o1_ instanceof WingProperty)) { assign((WingProperty)_o1_);
/* 557 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 558 */       } else if ((_o1_ instanceof WingProperty.Const)) assign(((WingProperty.Const)_o1_).nThis()); else {
/* 559 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(WingProperty _o_) {
/* 564 */       this.propertytype = _o_.propertytype;
/* 565 */       this.propertyvalue = _o_.propertyvalue;
/* 566 */       this.propertyphase = _o_.propertyphase;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 571 */       this.propertytype = _o_.propertytype;
/* 572 */       this.propertyvalue = _o_.propertyvalue;
/* 573 */       this.propertyphase = _o_.propertyphase;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 579 */       _os_.marshal(this.propertytype);
/* 580 */       _os_.marshal(this.propertyvalue);
/* 581 */       _os_.marshal(this.propertyphase);
/* 582 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 588 */       this.propertytype = _os_.unmarshal_int();
/* 589 */       this.propertyvalue = _os_.unmarshal_int();
/* 590 */       this.propertyphase = _os_.unmarshal_int();
/* 591 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 597 */       int _size_ = 0;
/* 598 */       _size_ += CodedOutputStream.computeInt32Size(1, this.propertytype);
/* 599 */       _size_ += CodedOutputStream.computeInt32Size(2, this.propertyvalue);
/* 600 */       _size_ += CodedOutputStream.computeInt32Size(3, this.propertyphase);
/* 601 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 609 */         _output_.writeInt32(1, this.propertytype);
/* 610 */         _output_.writeInt32(2, this.propertyvalue);
/* 611 */         _output_.writeInt32(3, this.propertyphase);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 615 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 617 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 625 */         boolean done = false;
/* 626 */         while (!done)
/*     */         {
/* 628 */           int tag = _input_.readTag();
/* 629 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 633 */             done = true;
/* 634 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 638 */             this.propertytype = _input_.readInt32();
/* 639 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 643 */             this.propertyvalue = _input_.readInt32();
/* 644 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 648 */             this.propertyphase = _input_.readInt32();
/* 649 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 653 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 655 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 664 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 668 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 670 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WingProperty copy()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WingProperty toData()
/*     */     {
/* 682 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.WingProperty toBean()
/*     */     {
/* 687 */       return new WingProperty(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.WingProperty toDataIf()
/*     */     {
/* 693 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.WingProperty toBeanIf()
/*     */     {
/* 698 */       return new WingProperty(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 704 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 708 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 712 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 716 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 720 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 724 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 728 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPropertytype()
/*     */     {
/* 735 */       return this.propertytype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPropertyvalue()
/*     */     {
/* 742 */       return this.propertyvalue;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getPropertyphase()
/*     */     {
/* 749 */       return this.propertyphase;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPropertytype(int _v_)
/*     */     {
/* 756 */       this.propertytype = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPropertyvalue(int _v_)
/*     */     {
/* 763 */       this.propertyvalue = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setPropertyphase(int _v_)
/*     */     {
/* 770 */       this.propertyphase = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 776 */       if (!(_o1_ instanceof Data)) return false;
/* 777 */       Data _o_ = (Data)_o1_;
/* 778 */       if (this.propertytype != _o_.propertytype) return false;
/* 779 */       if (this.propertyvalue != _o_.propertyvalue) return false;
/* 780 */       if (this.propertyphase != _o_.propertyphase) return false;
/* 781 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 787 */       int _h_ = 0;
/* 788 */       _h_ += this.propertytype;
/* 789 */       _h_ += this.propertyvalue;
/* 790 */       _h_ += this.propertyphase;
/* 791 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 797 */       StringBuilder _sb_ = new StringBuilder();
/* 798 */       _sb_.append("(");
/* 799 */       _sb_.append(this.propertytype);
/* 800 */       _sb_.append(",");
/* 801 */       _sb_.append(this.propertyvalue);
/* 802 */       _sb_.append(",");
/* 803 */       _sb_.append(this.propertyphase);
/* 804 */       _sb_.append(")");
/* 805 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\WingProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */