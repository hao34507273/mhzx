/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class MarketPetEquipCon extends XBean implements xbean.MarketPetEquipCon
/*     */ {
/*     */   private int property;
/*     */   private SetX<Integer> skillids;
/*     */   private long custtime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.property = 0;
/*  23 */     this.skillids.clear();
/*  24 */     this.custtime = 0L;
/*     */   }
/*     */   
/*     */   MarketPetEquipCon(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.skillids = new SetX();
/*     */   }
/*     */   
/*     */   public MarketPetEquipCon()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MarketPetEquipCon(MarketPetEquipCon _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MarketPetEquipCon(xbean.MarketPetEquipCon _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof MarketPetEquipCon)) { assign((MarketPetEquipCon)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MarketPetEquipCon _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.property = _o_.property;
/*  56 */     this.skillids = new SetX();
/*  57 */     this.skillids.addAll(_o_.skillids);
/*  58 */     this.custtime = _o_.custtime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  63 */     this.property = _o_.property;
/*  64 */     this.skillids = new SetX();
/*  65 */     this.skillids.addAll(_o_.skillids);
/*  66 */     this.custtime = _o_.custtime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.marshal(this.property);
/*  74 */     _os_.compact_uint32(this.skillids.size());
/*  75 */     for (Integer _v_ : this.skillids)
/*     */     {
/*  77 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  79 */     _os_.marshal(this.custtime);
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  86 */     _xdb_verify_unsafe_();
/*  87 */     this.property = _os_.unmarshal_int();
/*  88 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  90 */       int _v_ = 0;
/*  91 */       _v_ = _os_.unmarshal_int();
/*  92 */       this.skillids.add(Integer.valueOf(_v_));
/*     */     }
/*  94 */     this.custtime = _os_.unmarshal_long();
/*  95 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 101 */     _xdb_verify_unsafe_();
/* 102 */     int _size_ = 0;
/* 103 */     _size_ += CodedOutputStream.computeInt32Size(1, this.property);
/* 104 */     for (Integer _v_ : this.skillids)
/*     */     {
/* 106 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */     }
/* 108 */     _size_ += CodedOutputStream.computeInt64Size(3, this.custtime);
/* 109 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 115 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 118 */       _output_.writeInt32(1, this.property);
/* 119 */       for (Integer _v_ : this.skillids)
/*     */       {
/* 121 */         _output_.writeInt32(2, _v_.intValue());
/*     */       }
/* 123 */       _output_.writeInt64(3, this.custtime);
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
/* 151 */           this.property = _input_.readInt32();
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 156 */           int _v_ = 0;
/* 157 */           _v_ = _input_.readInt32();
/* 158 */           this.skillids.add(Integer.valueOf(_v_));
/* 159 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 163 */           this.custtime = _input_.readInt64();
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
/*     */   public xbean.MarketPetEquipCon copy()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new MarketPetEquipCon(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MarketPetEquipCon toData()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MarketPetEquipCon toBean()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new MarketPetEquipCon(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MarketPetEquipCon toDataIf()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MarketPetEquipCon toBeanIf()
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
/*     */   public int getProperty()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return this.property;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Integer> getSkillids()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return xdb.Logs.logSet(new LogKey(this, "skillids"), this.skillids);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getSkillidsAsData()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/*     */     
/* 249 */     MarketPetEquipCon _o_ = this;
/* 250 */     Set<Integer> skillids = new SetX();
/* 251 */     skillids.addAll(_o_.skillids);
/* 252 */     return skillids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getCusttime()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return this.custtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setProperty(int _v_)
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/* 268 */     xdb.Logs.logIf(new LogKey(this, "property")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 272 */         new xdb.logs.LogInt(this, MarketPetEquipCon.this.property)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 276 */             MarketPetEquipCon.this.property = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 280 */     });
/* 281 */     this.property = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCusttime(long _v_)
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     xdb.Logs.logIf(new LogKey(this, "custtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 293 */         new xdb.logs.LogLong(this, MarketPetEquipCon.this.custtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 297 */             MarketPetEquipCon.this.custtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 301 */     });
/* 302 */     this.custtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 308 */     _xdb_verify_unsafe_();
/* 309 */     MarketPetEquipCon _o_ = null;
/* 310 */     if ((_o1_ instanceof MarketPetEquipCon)) { _o_ = (MarketPetEquipCon)_o1_;
/* 311 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 312 */       return false;
/* 313 */     if (this.property != _o_.property) return false;
/* 314 */     if (!this.skillids.equals(_o_.skillids)) return false;
/* 315 */     if (this.custtime != _o_.custtime) return false;
/* 316 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 322 */     _xdb_verify_unsafe_();
/* 323 */     int _h_ = 0;
/* 324 */     _h_ += this.property;
/* 325 */     _h_ += this.skillids.hashCode();
/* 326 */     _h_ = (int)(_h_ + this.custtime);
/* 327 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 333 */     _xdb_verify_unsafe_();
/* 334 */     StringBuilder _sb_ = new StringBuilder();
/* 335 */     _sb_.append("(");
/* 336 */     _sb_.append(this.property);
/* 337 */     _sb_.append(",");
/* 338 */     _sb_.append(this.skillids);
/* 339 */     _sb_.append(",");
/* 340 */     _sb_.append(this.custtime);
/* 341 */     _sb_.append(")");
/* 342 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 348 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 349 */     lb.add(new xdb.logs.ListenableChanged().setVarName("property"));
/* 350 */     lb.add(new xdb.logs.ListenableSet().setVarName("skillids"));
/* 351 */     lb.add(new xdb.logs.ListenableChanged().setVarName("custtime"));
/* 352 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MarketPetEquipCon {
/*     */     private Const() {}
/*     */     
/*     */     MarketPetEquipCon nThis() {
/* 359 */       return MarketPetEquipCon.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 365 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketPetEquipCon copy()
/*     */     {
/* 371 */       return MarketPetEquipCon.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketPetEquipCon toData()
/*     */     {
/* 377 */       return MarketPetEquipCon.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MarketPetEquipCon toBean()
/*     */     {
/* 382 */       return MarketPetEquipCon.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketPetEquipCon toDataIf()
/*     */     {
/* 388 */       return MarketPetEquipCon.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MarketPetEquipCon toBeanIf()
/*     */     {
/* 393 */       return MarketPetEquipCon.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getProperty()
/*     */     {
/* 400 */       MarketPetEquipCon.this._xdb_verify_unsafe_();
/* 401 */       return MarketPetEquipCon.this.property;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getSkillids()
/*     */     {
/* 408 */       MarketPetEquipCon.this._xdb_verify_unsafe_();
/* 409 */       return xdb.Consts.constSet(MarketPetEquipCon.this.skillids);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getSkillidsAsData()
/*     */     {
/* 415 */       MarketPetEquipCon.this._xdb_verify_unsafe_();
/*     */       
/* 417 */       MarketPetEquipCon _o_ = MarketPetEquipCon.this;
/* 418 */       Set<Integer> skillids = new SetX();
/* 419 */       skillids.addAll(_o_.skillids);
/* 420 */       return skillids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCusttime()
/*     */     {
/* 427 */       MarketPetEquipCon.this._xdb_verify_unsafe_();
/* 428 */       return MarketPetEquipCon.this.custtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setProperty(int _v_)
/*     */     {
/* 435 */       MarketPetEquipCon.this._xdb_verify_unsafe_();
/* 436 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCusttime(long _v_)
/*     */     {
/* 443 */       MarketPetEquipCon.this._xdb_verify_unsafe_();
/* 444 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 450 */       MarketPetEquipCon.this._xdb_verify_unsafe_();
/* 451 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 457 */       MarketPetEquipCon.this._xdb_verify_unsafe_();
/* 458 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 464 */       return MarketPetEquipCon.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 470 */       return MarketPetEquipCon.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 476 */       MarketPetEquipCon.this._xdb_verify_unsafe_();
/* 477 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 483 */       return MarketPetEquipCon.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 489 */       return MarketPetEquipCon.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 495 */       MarketPetEquipCon.this._xdb_verify_unsafe_();
/* 496 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 502 */       return MarketPetEquipCon.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 508 */       return MarketPetEquipCon.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 514 */       return MarketPetEquipCon.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 520 */       return MarketPetEquipCon.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 526 */       return MarketPetEquipCon.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 532 */       return MarketPetEquipCon.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 538 */       return MarketPetEquipCon.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MarketPetEquipCon
/*     */   {
/*     */     private int property;
/*     */     
/*     */     private HashSet<Integer> skillids;
/*     */     
/*     */     private long custtime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 554 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 559 */       this.skillids = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.MarketPetEquipCon _o1_)
/*     */     {
/* 564 */       if ((_o1_ instanceof MarketPetEquipCon)) { assign((MarketPetEquipCon)_o1_);
/* 565 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 566 */       } else if ((_o1_ instanceof MarketPetEquipCon.Const)) assign(((MarketPetEquipCon.Const)_o1_).nThis()); else {
/* 567 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MarketPetEquipCon _o_) {
/* 572 */       this.property = _o_.property;
/* 573 */       this.skillids = new HashSet();
/* 574 */       this.skillids.addAll(_o_.skillids);
/* 575 */       this.custtime = _o_.custtime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 580 */       this.property = _o_.property;
/* 581 */       this.skillids = new HashSet();
/* 582 */       this.skillids.addAll(_o_.skillids);
/* 583 */       this.custtime = _o_.custtime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 589 */       _os_.marshal(this.property);
/* 590 */       _os_.compact_uint32(this.skillids.size());
/* 591 */       for (Integer _v_ : this.skillids)
/*     */       {
/* 593 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 595 */       _os_.marshal(this.custtime);
/* 596 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 602 */       this.property = _os_.unmarshal_int();
/* 603 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 605 */         int _v_ = 0;
/* 606 */         _v_ = _os_.unmarshal_int();
/* 607 */         this.skillids.add(Integer.valueOf(_v_));
/*     */       }
/* 609 */       this.custtime = _os_.unmarshal_long();
/* 610 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 616 */       int _size_ = 0;
/* 617 */       _size_ += CodedOutputStream.computeInt32Size(1, this.property);
/* 618 */       for (Integer _v_ : this.skillids)
/*     */       {
/* 620 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */       }
/* 622 */       _size_ += CodedOutputStream.computeInt64Size(3, this.custtime);
/* 623 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 631 */         _output_.writeInt32(1, this.property);
/* 632 */         for (Integer _v_ : this.skillids)
/*     */         {
/* 634 */           _output_.writeInt32(2, _v_.intValue());
/*     */         }
/* 636 */         _output_.writeInt64(3, this.custtime);
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
/* 663 */             this.property = _input_.readInt32();
/* 664 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 668 */             int _v_ = 0;
/* 669 */             _v_ = _input_.readInt32();
/* 670 */             this.skillids.add(Integer.valueOf(_v_));
/* 671 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 675 */             this.custtime = _input_.readInt64();
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
/*     */     public xbean.MarketPetEquipCon copy()
/*     */     {
/* 703 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketPetEquipCon toData()
/*     */     {
/* 709 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MarketPetEquipCon toBean()
/*     */     {
/* 714 */       return new MarketPetEquipCon(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketPetEquipCon toDataIf()
/*     */     {
/* 720 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MarketPetEquipCon toBeanIf()
/*     */     {
/* 725 */       return new MarketPetEquipCon(this, null, null);
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
/*     */     public int getProperty()
/*     */     {
/* 762 */       return this.property;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getSkillids()
/*     */     {
/* 769 */       return this.skillids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getSkillidsAsData()
/*     */     {
/* 776 */       return this.skillids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCusttime()
/*     */     {
/* 783 */       return this.custtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setProperty(int _v_)
/*     */     {
/* 790 */       this.property = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCusttime(long _v_)
/*     */     {
/* 797 */       this.custtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 803 */       if (!(_o1_ instanceof Data)) return false;
/* 804 */       Data _o_ = (Data)_o1_;
/* 805 */       if (this.property != _o_.property) return false;
/* 806 */       if (!this.skillids.equals(_o_.skillids)) return false;
/* 807 */       if (this.custtime != _o_.custtime) return false;
/* 808 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 814 */       int _h_ = 0;
/* 815 */       _h_ += this.property;
/* 816 */       _h_ += this.skillids.hashCode();
/* 817 */       _h_ = (int)(_h_ + this.custtime);
/* 818 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 824 */       StringBuilder _sb_ = new StringBuilder();
/* 825 */       _sb_.append("(");
/* 826 */       _sb_.append(this.property);
/* 827 */       _sb_.append(",");
/* 828 */       _sb_.append(this.skillids);
/* 829 */       _sb_.append(",");
/* 830 */       _sb_.append(this.custtime);
/* 831 */       _sb_.append(")");
/* 832 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MarketPetEquipCon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */