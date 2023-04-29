/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class MultiOccupation extends XBean implements xbean.MultiOccupation
/*     */ {
/*     */   private LinkedList<Integer> occupations;
/*     */   private long activate_time;
/*     */   private long switch_time;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.occupations.clear();
/*  23 */     this.activate_time = 0L;
/*  24 */     this.switch_time = 0L;
/*     */   }
/*     */   
/*     */   MultiOccupation(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.occupations = new LinkedList();
/*     */   }
/*     */   
/*     */   public MultiOccupation()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MultiOccupation(MultiOccupation _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MultiOccupation(xbean.MultiOccupation _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof MultiOccupation)) { assign((MultiOccupation)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MultiOccupation _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.occupations = new LinkedList();
/*  56 */     this.occupations.addAll(_o_.occupations);
/*  57 */     this.activate_time = _o_.activate_time;
/*  58 */     this.switch_time = _o_.switch_time;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  63 */     this.occupations = new LinkedList();
/*  64 */     this.occupations.addAll(_o_.occupations);
/*  65 */     this.activate_time = _o_.activate_time;
/*  66 */     this.switch_time = _o_.switch_time;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.compact_uint32(this.occupations.size());
/*  74 */     for (Integer _v_ : this.occupations)
/*     */     {
/*  76 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  78 */     _os_.marshal(this.activate_time);
/*  79 */     _os_.marshal(this.switch_time);
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  86 */     _xdb_verify_unsafe_();
/*  87 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  89 */       int _v_ = 0;
/*  90 */       _v_ = _os_.unmarshal_int();
/*  91 */       this.occupations.add(Integer.valueOf(_v_));
/*     */     }
/*  93 */     this.activate_time = _os_.unmarshal_long();
/*  94 */     this.switch_time = _os_.unmarshal_long();
/*  95 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 101 */     _xdb_verify_unsafe_();
/* 102 */     int _size_ = 0;
/* 103 */     for (Integer _v_ : this.occupations)
/*     */     {
/* 105 */       _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*     */     }
/* 107 */     _size_ += CodedOutputStream.computeInt64Size(2, this.activate_time);
/* 108 */     _size_ += CodedOutputStream.computeInt64Size(3, this.switch_time);
/* 109 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 115 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 118 */       for (Integer _v_ : this.occupations)
/*     */       {
/* 120 */         _output_.writeInt32(1, _v_.intValue());
/*     */       }
/* 122 */       _output_.writeInt64(2, this.activate_time);
/* 123 */       _output_.writeInt64(3, this.switch_time);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 127 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 129 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 135 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 138 */       boolean done = false;
/* 139 */       while (!done)
/*     */       {
/* 141 */         int tag = _input_.readTag();
/* 142 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 146 */           done = true;
/* 147 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 151 */           int _v_ = 0;
/* 152 */           _v_ = _input_.readInt32();
/* 153 */           this.occupations.add(Integer.valueOf(_v_));
/* 154 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 158 */           this.activate_time = _input_.readInt64();
/* 159 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 163 */           this.switch_time = _input_.readInt64();
/* 164 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 168 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 170 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 179 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 183 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 185 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MultiOccupation copy()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new MultiOccupation(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MultiOccupation toData()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MultiOccupation toBean()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new MultiOccupation(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MultiOccupation toDataIf()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MultiOccupation toBeanIf()
/*     */   {
/* 217 */     _xdb_verify_unsafe_();
/* 218 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 224 */     _xdb_verify_unsafe_();
/* 225 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Integer> getOccupations()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return xdb.Logs.logList(new LogKey(this, "occupations"), this.occupations);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Integer> getOccupationsAsData()
/*     */   {
/* 239 */     _xdb_verify_unsafe_();
/*     */     
/* 241 */     MultiOccupation _o_ = this;
/* 242 */     List<Integer> occupations = new LinkedList();
/* 243 */     occupations.addAll(_o_.occupations);
/* 244 */     return occupations;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getActivate_time()
/*     */   {
/* 251 */     _xdb_verify_unsafe_();
/* 252 */     return this.activate_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getSwitch_time()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return this.switch_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActivate_time(long _v_)
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/* 268 */     xdb.Logs.logIf(new LogKey(this, "activate_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 272 */         new xdb.logs.LogLong(this, MultiOccupation.this.activate_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 276 */             MultiOccupation.this.activate_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 280 */     });
/* 281 */     this.activate_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSwitch_time(long _v_)
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     xdb.Logs.logIf(new LogKey(this, "switch_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 293 */         new xdb.logs.LogLong(this, MultiOccupation.this.switch_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 297 */             MultiOccupation.this.switch_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 301 */     });
/* 302 */     this.switch_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 308 */     _xdb_verify_unsafe_();
/* 309 */     MultiOccupation _o_ = null;
/* 310 */     if ((_o1_ instanceof MultiOccupation)) { _o_ = (MultiOccupation)_o1_;
/* 311 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 312 */       return false;
/* 313 */     if (!this.occupations.equals(_o_.occupations)) return false;
/* 314 */     if (this.activate_time != _o_.activate_time) return false;
/* 315 */     if (this.switch_time != _o_.switch_time) return false;
/* 316 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 322 */     _xdb_verify_unsafe_();
/* 323 */     int _h_ = 0;
/* 324 */     _h_ += this.occupations.hashCode();
/* 325 */     _h_ = (int)(_h_ + this.activate_time);
/* 326 */     _h_ = (int)(_h_ + this.switch_time);
/* 327 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 333 */     _xdb_verify_unsafe_();
/* 334 */     StringBuilder _sb_ = new StringBuilder();
/* 335 */     _sb_.append("(");
/* 336 */     _sb_.append(this.occupations);
/* 337 */     _sb_.append(",");
/* 338 */     _sb_.append(this.activate_time);
/* 339 */     _sb_.append(",");
/* 340 */     _sb_.append(this.switch_time);
/* 341 */     _sb_.append(")");
/* 342 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 348 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 349 */     lb.add(new ListenableChanged().setVarName("occupations"));
/* 350 */     lb.add(new ListenableChanged().setVarName("activate_time"));
/* 351 */     lb.add(new ListenableChanged().setVarName("switch_time"));
/* 352 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MultiOccupation {
/*     */     private Const() {}
/*     */     
/*     */     MultiOccupation nThis() {
/* 359 */       return MultiOccupation.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 365 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MultiOccupation copy()
/*     */     {
/* 371 */       return MultiOccupation.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MultiOccupation toData()
/*     */     {
/* 377 */       return MultiOccupation.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MultiOccupation toBean()
/*     */     {
/* 382 */       return MultiOccupation.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MultiOccupation toDataIf()
/*     */     {
/* 388 */       return MultiOccupation.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MultiOccupation toBeanIf()
/*     */     {
/* 393 */       return MultiOccupation.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getOccupations()
/*     */     {
/* 400 */       MultiOccupation.this._xdb_verify_unsafe_();
/* 401 */       return xdb.Consts.constList(MultiOccupation.this.occupations);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Integer> getOccupationsAsData()
/*     */     {
/* 407 */       MultiOccupation.this._xdb_verify_unsafe_();
/*     */       
/* 409 */       MultiOccupation _o_ = MultiOccupation.this;
/* 410 */       List<Integer> occupations = new LinkedList();
/* 411 */       occupations.addAll(_o_.occupations);
/* 412 */       return occupations;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getActivate_time()
/*     */     {
/* 419 */       MultiOccupation.this._xdb_verify_unsafe_();
/* 420 */       return MultiOccupation.this.activate_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSwitch_time()
/*     */     {
/* 427 */       MultiOccupation.this._xdb_verify_unsafe_();
/* 428 */       return MultiOccupation.this.switch_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setActivate_time(long _v_)
/*     */     {
/* 435 */       MultiOccupation.this._xdb_verify_unsafe_();
/* 436 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSwitch_time(long _v_)
/*     */     {
/* 443 */       MultiOccupation.this._xdb_verify_unsafe_();
/* 444 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 450 */       MultiOccupation.this._xdb_verify_unsafe_();
/* 451 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 457 */       MultiOccupation.this._xdb_verify_unsafe_();
/* 458 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 464 */       return MultiOccupation.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 470 */       return MultiOccupation.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 476 */       MultiOccupation.this._xdb_verify_unsafe_();
/* 477 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 483 */       return MultiOccupation.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 489 */       return MultiOccupation.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 495 */       MultiOccupation.this._xdb_verify_unsafe_();
/* 496 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 502 */       return MultiOccupation.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 508 */       return MultiOccupation.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 514 */       return MultiOccupation.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 520 */       return MultiOccupation.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 526 */       return MultiOccupation.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 532 */       return MultiOccupation.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 538 */       return MultiOccupation.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MultiOccupation
/*     */   {
/*     */     private LinkedList<Integer> occupations;
/*     */     
/*     */     private long activate_time;
/*     */     
/*     */     private long switch_time;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 554 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 559 */       this.occupations = new LinkedList();
/*     */     }
/*     */     
/*     */     Data(xbean.MultiOccupation _o1_)
/*     */     {
/* 564 */       if ((_o1_ instanceof MultiOccupation)) { assign((MultiOccupation)_o1_);
/* 565 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 566 */       } else if ((_o1_ instanceof MultiOccupation.Const)) assign(((MultiOccupation.Const)_o1_).nThis()); else {
/* 567 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MultiOccupation _o_) {
/* 572 */       this.occupations = new LinkedList();
/* 573 */       this.occupations.addAll(_o_.occupations);
/* 574 */       this.activate_time = _o_.activate_time;
/* 575 */       this.switch_time = _o_.switch_time;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 580 */       this.occupations = new LinkedList();
/* 581 */       this.occupations.addAll(_o_.occupations);
/* 582 */       this.activate_time = _o_.activate_time;
/* 583 */       this.switch_time = _o_.switch_time;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 589 */       _os_.compact_uint32(this.occupations.size());
/* 590 */       for (Integer _v_ : this.occupations)
/*     */       {
/* 592 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 594 */       _os_.marshal(this.activate_time);
/* 595 */       _os_.marshal(this.switch_time);
/* 596 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 602 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 604 */         int _v_ = 0;
/* 605 */         _v_ = _os_.unmarshal_int();
/* 606 */         this.occupations.add(Integer.valueOf(_v_));
/*     */       }
/* 608 */       this.activate_time = _os_.unmarshal_long();
/* 609 */       this.switch_time = _os_.unmarshal_long();
/* 610 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 616 */       int _size_ = 0;
/* 617 */       for (Integer _v_ : this.occupations)
/*     */       {
/* 619 */         _size_ += CodedOutputStream.computeInt32Size(1, _v_.intValue());
/*     */       }
/* 621 */       _size_ += CodedOutputStream.computeInt64Size(2, this.activate_time);
/* 622 */       _size_ += CodedOutputStream.computeInt64Size(3, this.switch_time);
/* 623 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 631 */         for (Integer _v_ : this.occupations)
/*     */         {
/* 633 */           _output_.writeInt32(1, _v_.intValue());
/*     */         }
/* 635 */         _output_.writeInt64(2, this.activate_time);
/* 636 */         _output_.writeInt64(3, this.switch_time);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 640 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 642 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 650 */         boolean done = false;
/* 651 */         while (!done)
/*     */         {
/* 653 */           int tag = _input_.readTag();
/* 654 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 658 */             done = true;
/* 659 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 663 */             int _v_ = 0;
/* 664 */             _v_ = _input_.readInt32();
/* 665 */             this.occupations.add(Integer.valueOf(_v_));
/* 666 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 670 */             this.activate_time = _input_.readInt64();
/* 671 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 675 */             this.switch_time = _input_.readInt64();
/* 676 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 680 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 682 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 691 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 695 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 697 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MultiOccupation copy()
/*     */     {
/* 703 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MultiOccupation toData()
/*     */     {
/* 709 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MultiOccupation toBean()
/*     */     {
/* 714 */       return new MultiOccupation(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MultiOccupation toDataIf()
/*     */     {
/* 720 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MultiOccupation toBeanIf()
/*     */     {
/* 725 */       return new MultiOccupation(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 731 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 735 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 739 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 743 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 747 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 751 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 755 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getOccupations()
/*     */     {
/* 762 */       return this.occupations;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getOccupationsAsData()
/*     */     {
/* 769 */       return this.occupations;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getActivate_time()
/*     */     {
/* 776 */       return this.activate_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getSwitch_time()
/*     */     {
/* 783 */       return this.switch_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setActivate_time(long _v_)
/*     */     {
/* 790 */       this.activate_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSwitch_time(long _v_)
/*     */     {
/* 797 */       this.switch_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 803 */       if (!(_o1_ instanceof Data)) return false;
/* 804 */       Data _o_ = (Data)_o1_;
/* 805 */       if (!this.occupations.equals(_o_.occupations)) return false;
/* 806 */       if (this.activate_time != _o_.activate_time) return false;
/* 807 */       if (this.switch_time != _o_.switch_time) return false;
/* 808 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 814 */       int _h_ = 0;
/* 815 */       _h_ += this.occupations.hashCode();
/* 816 */       _h_ = (int)(_h_ + this.activate_time);
/* 817 */       _h_ = (int)(_h_ + this.switch_time);
/* 818 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 824 */       StringBuilder _sb_ = new StringBuilder();
/* 825 */       _sb_.append("(");
/* 826 */       _sb_.append(this.occupations);
/* 827 */       _sb_.append(",");
/* 828 */       _sb_.append(this.activate_time);
/* 829 */       _sb_.append(",");
/* 830 */       _sb_.append(this.switch_time);
/* 831 */       _sb_.append(")");
/* 832 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MultiOccupation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */