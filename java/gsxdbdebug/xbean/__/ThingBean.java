/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ import xdb.logs.LogInt;
/*     */ 
/*     */ public final class ThingBean extends XBean implements xbean.ThingBean
/*     */ {
/*     */   private int id;
/*     */   private int count;
/*     */   private int sign;
/*     */   private int thingtype;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.id = 0;
/*  25 */     this.count = 0;
/*  26 */     this.sign = 0;
/*  27 */     this.thingtype = 0;
/*     */   }
/*     */   
/*     */   ThingBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.sign = 0;
/*     */   }
/*     */   
/*     */   public ThingBean()
/*     */   {
/*  38 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ThingBean(ThingBean _o_)
/*     */   {
/*  43 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ThingBean(xbean.ThingBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  48 */     super(_xp_, _vn_);
/*  49 */     if ((_o1_ instanceof ThingBean)) { assign((ThingBean)_o1_);
/*  50 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  51 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  52 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ThingBean _o_) {
/*  57 */     _o_._xdb_verify_unsafe_();
/*  58 */     this.id = _o_.id;
/*  59 */     this.count = _o_.count;
/*  60 */     this.sign = _o_.sign;
/*  61 */     this.thingtype = _o_.thingtype;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  66 */     this.id = _o_.id;
/*  67 */     this.count = _o_.count;
/*  68 */     this.sign = _o_.sign;
/*  69 */     this.thingtype = _o_.thingtype;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     _os_.marshal(this.id);
/*  77 */     _os_.marshal(this.count);
/*  78 */     _os_.marshal(this.sign);
/*  79 */     _os_.marshal(this.thingtype);
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  86 */     _xdb_verify_unsafe_();
/*  87 */     this.id = _os_.unmarshal_int();
/*  88 */     this.count = _os_.unmarshal_int();
/*  89 */     this.sign = _os_.unmarshal_int();
/*  90 */     this.thingtype = _os_.unmarshal_int();
/*  91 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  97 */     _xdb_verify_unsafe_();
/*  98 */     int _size_ = 0;
/*  99 */     _size_ += CodedOutputStream.computeInt32Size(1, this.id);
/* 100 */     _size_ += CodedOutputStream.computeInt32Size(2, this.count);
/* 101 */     _size_ += CodedOutputStream.computeInt32Size(3, this.sign);
/* 102 */     _size_ += CodedOutputStream.computeInt32Size(4, this.thingtype);
/* 103 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 109 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 112 */       _output_.writeInt32(1, this.id);
/* 113 */       _output_.writeInt32(2, this.count);
/* 114 */       _output_.writeInt32(3, this.sign);
/* 115 */       _output_.writeInt32(4, this.thingtype);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 119 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 121 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 127 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 130 */       boolean done = false;
/* 131 */       while (!done)
/*     */       {
/* 133 */         int tag = _input_.readTag();
/* 134 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 138 */           done = true;
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 143 */           this.id = _input_.readInt32();
/* 144 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 148 */           this.count = _input_.readInt32();
/* 149 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 153 */           this.sign = _input_.readInt32();
/* 154 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 158 */           this.thingtype = _input_.readInt32();
/* 159 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 163 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 165 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 174 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 178 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 180 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ThingBean copy()
/*     */   {
/* 186 */     _xdb_verify_unsafe_();
/* 187 */     return new ThingBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ThingBean toData()
/*     */   {
/* 193 */     _xdb_verify_unsafe_();
/* 194 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ThingBean toBean()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new ThingBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ThingBean toDataIf()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ThingBean toBeanIf()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 219 */     _xdb_verify_unsafe_();
/* 220 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getId()
/*     */   {
/* 227 */     _xdb_verify_unsafe_();
/* 228 */     return this.id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCount()
/*     */   {
/* 235 */     _xdb_verify_unsafe_();
/* 236 */     return this.count;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSign()
/*     */   {
/* 243 */     _xdb_verify_unsafe_();
/* 244 */     return this.sign;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getThingtype()
/*     */   {
/* 251 */     _xdb_verify_unsafe_();
/* 252 */     return this.thingtype;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setId(int _v_)
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     xdb.Logs.logIf(new LogKey(this, "id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 264 */         new LogInt(this, ThingBean.this.id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 268 */             ThingBean.this.id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 272 */     });
/* 273 */     this.id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCount(int _v_)
/*     */   {
/* 280 */     _xdb_verify_unsafe_();
/* 281 */     xdb.Logs.logIf(new LogKey(this, "count")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 285 */         new LogInt(this, ThingBean.this.count)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 289 */             ThingBean.this.count = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 293 */     });
/* 294 */     this.count = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSign(int _v_)
/*     */   {
/* 301 */     _xdb_verify_unsafe_();
/* 302 */     xdb.Logs.logIf(new LogKey(this, "sign")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 306 */         new LogInt(this, ThingBean.this.sign)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 310 */             ThingBean.this.sign = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 314 */     });
/* 315 */     this.sign = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setThingtype(int _v_)
/*     */   {
/* 322 */     _xdb_verify_unsafe_();
/* 323 */     xdb.Logs.logIf(new LogKey(this, "thingtype")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 327 */         new LogInt(this, ThingBean.this.thingtype)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 331 */             ThingBean.this.thingtype = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 335 */     });
/* 336 */     this.thingtype = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 342 */     _xdb_verify_unsafe_();
/* 343 */     ThingBean _o_ = null;
/* 344 */     if ((_o1_ instanceof ThingBean)) { _o_ = (ThingBean)_o1_;
/* 345 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 346 */       return false;
/* 347 */     if (this.id != _o_.id) return false;
/* 348 */     if (this.count != _o_.count) return false;
/* 349 */     if (this.sign != _o_.sign) return false;
/* 350 */     if (this.thingtype != _o_.thingtype) return false;
/* 351 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 357 */     _xdb_verify_unsafe_();
/* 358 */     int _h_ = 0;
/* 359 */     _h_ += this.id;
/* 360 */     _h_ += this.count;
/* 361 */     _h_ += this.sign;
/* 362 */     _h_ += this.thingtype;
/* 363 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 369 */     _xdb_verify_unsafe_();
/* 370 */     StringBuilder _sb_ = new StringBuilder();
/* 371 */     _sb_.append("(");
/* 372 */     _sb_.append(this.id);
/* 373 */     _sb_.append(",");
/* 374 */     _sb_.append(this.count);
/* 375 */     _sb_.append(",");
/* 376 */     _sb_.append(this.sign);
/* 377 */     _sb_.append(",");
/* 378 */     _sb_.append(this.thingtype);
/* 379 */     _sb_.append(")");
/* 380 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 386 */     ListenableBean lb = new ListenableBean();
/* 387 */     lb.add(new ListenableChanged().setVarName("id"));
/* 388 */     lb.add(new ListenableChanged().setVarName("count"));
/* 389 */     lb.add(new ListenableChanged().setVarName("sign"));
/* 390 */     lb.add(new ListenableChanged().setVarName("thingtype"));
/* 391 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ThingBean {
/*     */     private Const() {}
/*     */     
/*     */     ThingBean nThis() {
/* 398 */       return ThingBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 404 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ThingBean copy()
/*     */     {
/* 410 */       return ThingBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ThingBean toData()
/*     */     {
/* 416 */       return ThingBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ThingBean toBean()
/*     */     {
/* 421 */       return ThingBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ThingBean toDataIf()
/*     */     {
/* 427 */       return ThingBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ThingBean toBeanIf()
/*     */     {
/* 432 */       return ThingBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getId()
/*     */     {
/* 439 */       ThingBean.this._xdb_verify_unsafe_();
/* 440 */       return ThingBean.this.id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCount()
/*     */     {
/* 447 */       ThingBean.this._xdb_verify_unsafe_();
/* 448 */       return ThingBean.this.count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSign()
/*     */     {
/* 455 */       ThingBean.this._xdb_verify_unsafe_();
/* 456 */       return ThingBean.this.sign;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getThingtype()
/*     */     {
/* 463 */       ThingBean.this._xdb_verify_unsafe_();
/* 464 */       return ThingBean.this.thingtype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setId(int _v_)
/*     */     {
/* 471 */       ThingBean.this._xdb_verify_unsafe_();
/* 472 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCount(int _v_)
/*     */     {
/* 479 */       ThingBean.this._xdb_verify_unsafe_();
/* 480 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSign(int _v_)
/*     */     {
/* 487 */       ThingBean.this._xdb_verify_unsafe_();
/* 488 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setThingtype(int _v_)
/*     */     {
/* 495 */       ThingBean.this._xdb_verify_unsafe_();
/* 496 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 502 */       ThingBean.this._xdb_verify_unsafe_();
/* 503 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 509 */       ThingBean.this._xdb_verify_unsafe_();
/* 510 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 516 */       return ThingBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 522 */       return ThingBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 528 */       ThingBean.this._xdb_verify_unsafe_();
/* 529 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 535 */       return ThingBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 541 */       return ThingBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 547 */       ThingBean.this._xdb_verify_unsafe_();
/* 548 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 554 */       return ThingBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 560 */       return ThingBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 566 */       return ThingBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 572 */       return ThingBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 578 */       return ThingBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 584 */       return ThingBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 590 */       return ThingBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ThingBean
/*     */   {
/*     */     private int id;
/*     */     
/*     */     private int count;
/*     */     
/*     */     private int sign;
/*     */     
/*     */     private int thingtype;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 608 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 613 */       this.sign = 0;
/*     */     }
/*     */     
/*     */     Data(xbean.ThingBean _o1_)
/*     */     {
/* 618 */       if ((_o1_ instanceof ThingBean)) { assign((ThingBean)_o1_);
/* 619 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 620 */       } else if ((_o1_ instanceof ThingBean.Const)) assign(((ThingBean.Const)_o1_).nThis()); else {
/* 621 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ThingBean _o_) {
/* 626 */       this.id = _o_.id;
/* 627 */       this.count = _o_.count;
/* 628 */       this.sign = _o_.sign;
/* 629 */       this.thingtype = _o_.thingtype;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 634 */       this.id = _o_.id;
/* 635 */       this.count = _o_.count;
/* 636 */       this.sign = _o_.sign;
/* 637 */       this.thingtype = _o_.thingtype;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 643 */       _os_.marshal(this.id);
/* 644 */       _os_.marshal(this.count);
/* 645 */       _os_.marshal(this.sign);
/* 646 */       _os_.marshal(this.thingtype);
/* 647 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 653 */       this.id = _os_.unmarshal_int();
/* 654 */       this.count = _os_.unmarshal_int();
/* 655 */       this.sign = _os_.unmarshal_int();
/* 656 */       this.thingtype = _os_.unmarshal_int();
/* 657 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 663 */       int _size_ = 0;
/* 664 */       _size_ += CodedOutputStream.computeInt32Size(1, this.id);
/* 665 */       _size_ += CodedOutputStream.computeInt32Size(2, this.count);
/* 666 */       _size_ += CodedOutputStream.computeInt32Size(3, this.sign);
/* 667 */       _size_ += CodedOutputStream.computeInt32Size(4, this.thingtype);
/* 668 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 676 */         _output_.writeInt32(1, this.id);
/* 677 */         _output_.writeInt32(2, this.count);
/* 678 */         _output_.writeInt32(3, this.sign);
/* 679 */         _output_.writeInt32(4, this.thingtype);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 683 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 685 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 693 */         boolean done = false;
/* 694 */         while (!done)
/*     */         {
/* 696 */           int tag = _input_.readTag();
/* 697 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 701 */             done = true;
/* 702 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 706 */             this.id = _input_.readInt32();
/* 707 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 711 */             this.count = _input_.readInt32();
/* 712 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 716 */             this.sign = _input_.readInt32();
/* 717 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 721 */             this.thingtype = _input_.readInt32();
/* 722 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 726 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 728 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 737 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 741 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 743 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ThingBean copy()
/*     */     {
/* 749 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ThingBean toData()
/*     */     {
/* 755 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ThingBean toBean()
/*     */     {
/* 760 */       return new ThingBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ThingBean toDataIf()
/*     */     {
/* 766 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ThingBean toBeanIf()
/*     */     {
/* 771 */       return new ThingBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 777 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 781 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 785 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 789 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 793 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 797 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 801 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getId()
/*     */     {
/* 808 */       return this.id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getCount()
/*     */     {
/* 815 */       return this.count;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSign()
/*     */     {
/* 822 */       return this.sign;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getThingtype()
/*     */     {
/* 829 */       return this.thingtype;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setId(int _v_)
/*     */     {
/* 836 */       this.id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCount(int _v_)
/*     */     {
/* 843 */       this.count = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSign(int _v_)
/*     */     {
/* 850 */       this.sign = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setThingtype(int _v_)
/*     */     {
/* 857 */       this.thingtype = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 863 */       if (!(_o1_ instanceof Data)) return false;
/* 864 */       Data _o_ = (Data)_o1_;
/* 865 */       if (this.id != _o_.id) return false;
/* 866 */       if (this.count != _o_.count) return false;
/* 867 */       if (this.sign != _o_.sign) return false;
/* 868 */       if (this.thingtype != _o_.thingtype) return false;
/* 869 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 875 */       int _h_ = 0;
/* 876 */       _h_ += this.id;
/* 877 */       _h_ += this.count;
/* 878 */       _h_ += this.sign;
/* 879 */       _h_ += this.thingtype;
/* 880 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 886 */       StringBuilder _sb_ = new StringBuilder();
/* 887 */       _sb_.append("(");
/* 888 */       _sb_.append(this.id);
/* 889 */       _sb_.append(",");
/* 890 */       _sb_.append(this.count);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.sign);
/* 893 */       _sb_.append(",");
/* 894 */       _sb_.append(this.thingtype);
/* 895 */       _sb_.append(")");
/* 896 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ThingBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */