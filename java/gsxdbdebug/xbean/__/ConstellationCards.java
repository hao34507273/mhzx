/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class ConstellationCards extends XBean implements xbean.ConstellationCards
/*     */ {
/*     */   private int constellation;
/*     */   private ArrayList<Integer> stars;
/*     */   private int fortune;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.constellation = 0;
/*  23 */     this.stars.clear();
/*  24 */     this.fortune = 0;
/*     */   }
/*     */   
/*     */   ConstellationCards(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.stars = new ArrayList();
/*     */   }
/*     */   
/*     */   public ConstellationCards()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ConstellationCards(ConstellationCards _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ConstellationCards(xbean.ConstellationCards _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof ConstellationCards)) { assign((ConstellationCards)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ConstellationCards _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.constellation = _o_.constellation;
/*  56 */     this.stars = new ArrayList();
/*  57 */     this.stars.addAll(_o_.stars);
/*  58 */     this.fortune = _o_.fortune;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  63 */     this.constellation = _o_.constellation;
/*  64 */     this.stars = new ArrayList();
/*  65 */     this.stars.addAll(_o_.stars);
/*  66 */     this.fortune = _o_.fortune;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.marshal(this.constellation);
/*  74 */     _os_.compact_uint32(this.stars.size());
/*  75 */     for (Integer _v_ : this.stars)
/*     */     {
/*  77 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  79 */     _os_.marshal(this.fortune);
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  86 */     _xdb_verify_unsafe_();
/*  87 */     this.constellation = _os_.unmarshal_int();
/*  88 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  90 */       int _v_ = 0;
/*  91 */       _v_ = _os_.unmarshal_int();
/*  92 */       this.stars.add(Integer.valueOf(_v_));
/*     */     }
/*  94 */     this.fortune = _os_.unmarshal_int();
/*  95 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 101 */     _xdb_verify_unsafe_();
/* 102 */     int _size_ = 0;
/* 103 */     _size_ += CodedOutputStream.computeInt32Size(1, this.constellation);
/* 104 */     for (Integer _v_ : this.stars)
/*     */     {
/* 106 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */     }
/* 108 */     _size_ += CodedOutputStream.computeInt32Size(3, this.fortune);
/* 109 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 115 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 118 */       _output_.writeInt32(1, this.constellation);
/* 119 */       for (Integer _v_ : this.stars)
/*     */       {
/* 121 */         _output_.writeInt32(2, _v_.intValue());
/*     */       }
/* 123 */       _output_.writeInt32(3, this.fortune);
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
/* 151 */           this.constellation = _input_.readInt32();
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 156 */           int _v_ = 0;
/* 157 */           _v_ = _input_.readInt32();
/* 158 */           this.stars.add(Integer.valueOf(_v_));
/* 159 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 163 */           this.fortune = _input_.readInt32();
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
/*     */   public xbean.ConstellationCards copy()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new ConstellationCards(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ConstellationCards toData()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ConstellationCards toBean()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new ConstellationCards(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ConstellationCards toDataIf()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ConstellationCards toBeanIf()
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
/*     */   public int getConstellation()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return this.constellation;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Integer> getStars()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return xdb.Logs.logList(new LogKey(this, "stars"), this.stars);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Integer> getStarsAsData()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/*     */     
/* 249 */     ConstellationCards _o_ = this;
/* 250 */     List<Integer> stars = new ArrayList();
/* 251 */     stars.addAll(_o_.stars);
/* 252 */     return stars;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getFortune()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return this.fortune;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setConstellation(int _v_)
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/* 268 */     xdb.Logs.logIf(new LogKey(this, "constellation")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 272 */         new xdb.logs.LogInt(this, ConstellationCards.this.constellation)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 276 */             ConstellationCards.this.constellation = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 280 */     });
/* 281 */     this.constellation = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setFortune(int _v_)
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     xdb.Logs.logIf(new LogKey(this, "fortune")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 293 */         new xdb.logs.LogInt(this, ConstellationCards.this.fortune)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 297 */             ConstellationCards.this.fortune = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 301 */     });
/* 302 */     this.fortune = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 308 */     _xdb_verify_unsafe_();
/* 309 */     ConstellationCards _o_ = null;
/* 310 */     if ((_o1_ instanceof ConstellationCards)) { _o_ = (ConstellationCards)_o1_;
/* 311 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 312 */       return false;
/* 313 */     if (this.constellation != _o_.constellation) return false;
/* 314 */     if (!this.stars.equals(_o_.stars)) return false;
/* 315 */     if (this.fortune != _o_.fortune) return false;
/* 316 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 322 */     _xdb_verify_unsafe_();
/* 323 */     int _h_ = 0;
/* 324 */     _h_ += this.constellation;
/* 325 */     _h_ += this.stars.hashCode();
/* 326 */     _h_ += this.fortune;
/* 327 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 333 */     _xdb_verify_unsafe_();
/* 334 */     StringBuilder _sb_ = new StringBuilder();
/* 335 */     _sb_.append("(");
/* 336 */     _sb_.append(this.constellation);
/* 337 */     _sb_.append(",");
/* 338 */     _sb_.append(this.stars);
/* 339 */     _sb_.append(",");
/* 340 */     _sb_.append(this.fortune);
/* 341 */     _sb_.append(")");
/* 342 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 348 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 349 */     lb.add(new ListenableChanged().setVarName("constellation"));
/* 350 */     lb.add(new ListenableChanged().setVarName("stars"));
/* 351 */     lb.add(new ListenableChanged().setVarName("fortune"));
/* 352 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ConstellationCards {
/*     */     private Const() {}
/*     */     
/*     */     ConstellationCards nThis() {
/* 359 */       return ConstellationCards.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 365 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ConstellationCards copy()
/*     */     {
/* 371 */       return ConstellationCards.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ConstellationCards toData()
/*     */     {
/* 377 */       return ConstellationCards.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ConstellationCards toBean()
/*     */     {
/* 382 */       return ConstellationCards.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ConstellationCards toDataIf()
/*     */     {
/* 388 */       return ConstellationCards.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ConstellationCards toBeanIf()
/*     */     {
/* 393 */       return ConstellationCards.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getConstellation()
/*     */     {
/* 400 */       ConstellationCards.this._xdb_verify_unsafe_();
/* 401 */       return ConstellationCards.this.constellation;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getStars()
/*     */     {
/* 408 */       ConstellationCards.this._xdb_verify_unsafe_();
/* 409 */       return xdb.Consts.constList(ConstellationCards.this.stars);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Integer> getStarsAsData()
/*     */     {
/* 415 */       ConstellationCards.this._xdb_verify_unsafe_();
/*     */       
/* 417 */       ConstellationCards _o_ = ConstellationCards.this;
/* 418 */       List<Integer> stars = new ArrayList();
/* 419 */       stars.addAll(_o_.stars);
/* 420 */       return stars;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getFortune()
/*     */     {
/* 427 */       ConstellationCards.this._xdb_verify_unsafe_();
/* 428 */       return ConstellationCards.this.fortune;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setConstellation(int _v_)
/*     */     {
/* 435 */       ConstellationCards.this._xdb_verify_unsafe_();
/* 436 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFortune(int _v_)
/*     */     {
/* 443 */       ConstellationCards.this._xdb_verify_unsafe_();
/* 444 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 450 */       ConstellationCards.this._xdb_verify_unsafe_();
/* 451 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 457 */       ConstellationCards.this._xdb_verify_unsafe_();
/* 458 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 464 */       return ConstellationCards.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 470 */       return ConstellationCards.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 476 */       ConstellationCards.this._xdb_verify_unsafe_();
/* 477 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 483 */       return ConstellationCards.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 489 */       return ConstellationCards.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 495 */       ConstellationCards.this._xdb_verify_unsafe_();
/* 496 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 502 */       return ConstellationCards.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 508 */       return ConstellationCards.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 514 */       return ConstellationCards.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 520 */       return ConstellationCards.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 526 */       return ConstellationCards.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 532 */       return ConstellationCards.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 538 */       return ConstellationCards.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ConstellationCards
/*     */   {
/*     */     private int constellation;
/*     */     
/*     */     private ArrayList<Integer> stars;
/*     */     
/*     */     private int fortune;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 554 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 559 */       this.stars = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.ConstellationCards _o1_)
/*     */     {
/* 564 */       if ((_o1_ instanceof ConstellationCards)) { assign((ConstellationCards)_o1_);
/* 565 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 566 */       } else if ((_o1_ instanceof ConstellationCards.Const)) assign(((ConstellationCards.Const)_o1_).nThis()); else {
/* 567 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ConstellationCards _o_) {
/* 572 */       this.constellation = _o_.constellation;
/* 573 */       this.stars = new ArrayList();
/* 574 */       this.stars.addAll(_o_.stars);
/* 575 */       this.fortune = _o_.fortune;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 580 */       this.constellation = _o_.constellation;
/* 581 */       this.stars = new ArrayList();
/* 582 */       this.stars.addAll(_o_.stars);
/* 583 */       this.fortune = _o_.fortune;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 589 */       _os_.marshal(this.constellation);
/* 590 */       _os_.compact_uint32(this.stars.size());
/* 591 */       for (Integer _v_ : this.stars)
/*     */       {
/* 593 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 595 */       _os_.marshal(this.fortune);
/* 596 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 602 */       this.constellation = _os_.unmarshal_int();
/* 603 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 605 */         int _v_ = 0;
/* 606 */         _v_ = _os_.unmarshal_int();
/* 607 */         this.stars.add(Integer.valueOf(_v_));
/*     */       }
/* 609 */       this.fortune = _os_.unmarshal_int();
/* 610 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 616 */       int _size_ = 0;
/* 617 */       _size_ += CodedOutputStream.computeInt32Size(1, this.constellation);
/* 618 */       for (Integer _v_ : this.stars)
/*     */       {
/* 620 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */       }
/* 622 */       _size_ += CodedOutputStream.computeInt32Size(3, this.fortune);
/* 623 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 631 */         _output_.writeInt32(1, this.constellation);
/* 632 */         for (Integer _v_ : this.stars)
/*     */         {
/* 634 */           _output_.writeInt32(2, _v_.intValue());
/*     */         }
/* 636 */         _output_.writeInt32(3, this.fortune);
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
/* 663 */             this.constellation = _input_.readInt32();
/* 664 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 668 */             int _v_ = 0;
/* 669 */             _v_ = _input_.readInt32();
/* 670 */             this.stars.add(Integer.valueOf(_v_));
/* 671 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 675 */             this.fortune = _input_.readInt32();
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
/*     */     public xbean.ConstellationCards copy()
/*     */     {
/* 703 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ConstellationCards toData()
/*     */     {
/* 709 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ConstellationCards toBean()
/*     */     {
/* 714 */       return new ConstellationCards(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ConstellationCards toDataIf()
/*     */     {
/* 720 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ConstellationCards toBeanIf()
/*     */     {
/* 725 */       return new ConstellationCards(this, null, null);
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
/*     */     public int getConstellation()
/*     */     {
/* 762 */       return this.constellation;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getStars()
/*     */     {
/* 769 */       return this.stars;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getStarsAsData()
/*     */     {
/* 776 */       return this.stars;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getFortune()
/*     */     {
/* 783 */       return this.fortune;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setConstellation(int _v_)
/*     */     {
/* 790 */       this.constellation = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setFortune(int _v_)
/*     */     {
/* 797 */       this.fortune = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 803 */       if (!(_o1_ instanceof Data)) return false;
/* 804 */       Data _o_ = (Data)_o1_;
/* 805 */       if (this.constellation != _o_.constellation) return false;
/* 806 */       if (!this.stars.equals(_o_.stars)) return false;
/* 807 */       if (this.fortune != _o_.fortune) return false;
/* 808 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 814 */       int _h_ = 0;
/* 815 */       _h_ += this.constellation;
/* 816 */       _h_ += this.stars.hashCode();
/* 817 */       _h_ += this.fortune;
/* 818 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 824 */       StringBuilder _sb_ = new StringBuilder();
/* 825 */       _sb_.append("(");
/* 826 */       _sb_.append(this.constellation);
/* 827 */       _sb_.append(",");
/* 828 */       _sb_.append(this.stars);
/* 829 */       _sb_.append(",");
/* 830 */       _sb_.append(this.fortune);
/* 831 */       _sb_.append(")");
/* 832 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ConstellationCards.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */