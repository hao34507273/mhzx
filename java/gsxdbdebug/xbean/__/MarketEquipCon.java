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
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.util.SetX;
/*     */ 
/*     */ public final class MarketEquipCon extends XBean implements xbean.MarketEquipCon
/*     */ {
/*     */   private int level;
/*     */   private SetX<Integer> colors;
/*     */   private SetX<Integer> skillids;
/*     */   private long custtime;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.level = 0;
/*  25 */     this.colors.clear();
/*  26 */     this.skillids.clear();
/*  27 */     this.custtime = 0L;
/*     */   }
/*     */   
/*     */   MarketEquipCon(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*  33 */     this.colors = new SetX();
/*  34 */     this.skillids = new SetX();
/*     */   }
/*     */   
/*     */   public MarketEquipCon()
/*     */   {
/*  39 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MarketEquipCon(MarketEquipCon _o_)
/*     */   {
/*  44 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MarketEquipCon(xbean.MarketEquipCon _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  49 */     super(_xp_, _vn_);
/*  50 */     if ((_o1_ instanceof MarketEquipCon)) { assign((MarketEquipCon)_o1_);
/*  51 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  52 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  53 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MarketEquipCon _o_) {
/*  58 */     _o_._xdb_verify_unsafe_();
/*  59 */     this.level = _o_.level;
/*  60 */     this.colors = new SetX();
/*  61 */     this.colors.addAll(_o_.colors);
/*  62 */     this.skillids = new SetX();
/*  63 */     this.skillids.addAll(_o_.skillids);
/*  64 */     this.custtime = _o_.custtime;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  69 */     this.level = _o_.level;
/*  70 */     this.colors = new SetX();
/*  71 */     this.colors.addAll(_o_.colors);
/*  72 */     this.skillids = new SetX();
/*  73 */     this.skillids.addAll(_o_.skillids);
/*  74 */     this.custtime = _o_.custtime;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     _os_.marshal(this.level);
/*  82 */     _os_.compact_uint32(this.colors.size());
/*  83 */     for (Integer _v_ : this.colors)
/*     */     {
/*  85 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  87 */     _os_.compact_uint32(this.skillids.size());
/*  88 */     for (Integer _v_ : this.skillids)
/*     */     {
/*  90 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  92 */     _os_.marshal(this.custtime);
/*  93 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/* 100 */     this.level = _os_.unmarshal_int();
/* 101 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 103 */       int _v_ = 0;
/* 104 */       _v_ = _os_.unmarshal_int();
/* 105 */       this.colors.add(Integer.valueOf(_v_));
/*     */     }
/* 107 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/* 109 */       int _v_ = 0;
/* 110 */       _v_ = _os_.unmarshal_int();
/* 111 */       this.skillids.add(Integer.valueOf(_v_));
/*     */     }
/* 113 */     this.custtime = _os_.unmarshal_long();
/* 114 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 120 */     _xdb_verify_unsafe_();
/* 121 */     int _size_ = 0;
/* 122 */     _size_ += CodedOutputStream.computeInt32Size(1, this.level);
/* 123 */     for (Integer _v_ : this.colors)
/*     */     {
/* 125 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */     }
/* 127 */     for (Integer _v_ : this.skillids)
/*     */     {
/* 129 */       _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*     */     }
/* 131 */     _size_ += CodedOutputStream.computeInt64Size(4, this.custtime);
/* 132 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 138 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 141 */       _output_.writeInt32(1, this.level);
/* 142 */       for (Integer _v_ : this.colors)
/*     */       {
/* 144 */         _output_.writeInt32(2, _v_.intValue());
/*     */       }
/* 146 */       for (Integer _v_ : this.skillids)
/*     */       {
/* 148 */         _output_.writeInt32(3, _v_.intValue());
/*     */       }
/* 150 */       _output_.writeInt64(4, this.custtime);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 154 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 156 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 162 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 165 */       boolean done = false;
/* 166 */       while (!done)
/*     */       {
/* 168 */         int tag = _input_.readTag();
/* 169 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 173 */           done = true;
/* 174 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 178 */           this.level = _input_.readInt32();
/* 179 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 183 */           int _v_ = 0;
/* 184 */           _v_ = _input_.readInt32();
/* 185 */           this.colors.add(Integer.valueOf(_v_));
/* 186 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 190 */           int _v_ = 0;
/* 191 */           _v_ = _input_.readInt32();
/* 192 */           this.skillids.add(Integer.valueOf(_v_));
/* 193 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 197 */           this.custtime = _input_.readInt64();
/* 198 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 202 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 204 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 213 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 217 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 219 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MarketEquipCon copy()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     return new MarketEquipCon(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MarketEquipCon toData()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MarketEquipCon toBean()
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     return new MarketEquipCon(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MarketEquipCon toDataIf()
/*     */   {
/* 245 */     _xdb_verify_unsafe_();
/* 246 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MarketEquipCon toBeanIf()
/*     */   {
/* 251 */     _xdb_verify_unsafe_();
/* 252 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getLevel()
/*     */   {
/* 266 */     _xdb_verify_unsafe_();
/* 267 */     return this.level;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Integer> getColors()
/*     */   {
/* 274 */     _xdb_verify_unsafe_();
/* 275 */     return xdb.Logs.logSet(new LogKey(this, "colors"), this.colors);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getColorsAsData()
/*     */   {
/* 281 */     _xdb_verify_unsafe_();
/*     */     
/* 283 */     MarketEquipCon _o_ = this;
/* 284 */     Set<Integer> colors = new SetX();
/* 285 */     colors.addAll(_o_.colors);
/* 286 */     return colors;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Integer> getSkillids()
/*     */   {
/* 293 */     _xdb_verify_unsafe_();
/* 294 */     return xdb.Logs.logSet(new LogKey(this, "skillids"), this.skillids);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Integer> getSkillidsAsData()
/*     */   {
/* 300 */     _xdb_verify_unsafe_();
/*     */     
/* 302 */     MarketEquipCon _o_ = this;
/* 303 */     Set<Integer> skillids = new SetX();
/* 304 */     skillids.addAll(_o_.skillids);
/* 305 */     return skillids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getCusttime()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     return this.custtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLevel(int _v_)
/*     */   {
/* 320 */     _xdb_verify_unsafe_();
/* 321 */     xdb.Logs.logIf(new LogKey(this, "level")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 325 */         new xdb.logs.LogInt(this, MarketEquipCon.this.level)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 329 */             MarketEquipCon.this.level = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 333 */     });
/* 334 */     this.level = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCusttime(long _v_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     xdb.Logs.logIf(new LogKey(this, "custtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 346 */         new xdb.logs.LogLong(this, MarketEquipCon.this.custtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 350 */             MarketEquipCon.this.custtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 354 */     });
/* 355 */     this.custtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 361 */     _xdb_verify_unsafe_();
/* 362 */     MarketEquipCon _o_ = null;
/* 363 */     if ((_o1_ instanceof MarketEquipCon)) { _o_ = (MarketEquipCon)_o1_;
/* 364 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 365 */       return false;
/* 366 */     if (this.level != _o_.level) return false;
/* 367 */     if (!this.colors.equals(_o_.colors)) return false;
/* 368 */     if (!this.skillids.equals(_o_.skillids)) return false;
/* 369 */     if (this.custtime != _o_.custtime) return false;
/* 370 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 376 */     _xdb_verify_unsafe_();
/* 377 */     int _h_ = 0;
/* 378 */     _h_ += this.level;
/* 379 */     _h_ += this.colors.hashCode();
/* 380 */     _h_ += this.skillids.hashCode();
/* 381 */     _h_ = (int)(_h_ + this.custtime);
/* 382 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 388 */     _xdb_verify_unsafe_();
/* 389 */     StringBuilder _sb_ = new StringBuilder();
/* 390 */     _sb_.append("(");
/* 391 */     _sb_.append(this.level);
/* 392 */     _sb_.append(",");
/* 393 */     _sb_.append(this.colors);
/* 394 */     _sb_.append(",");
/* 395 */     _sb_.append(this.skillids);
/* 396 */     _sb_.append(",");
/* 397 */     _sb_.append(this.custtime);
/* 398 */     _sb_.append(")");
/* 399 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 405 */     ListenableBean lb = new ListenableBean();
/* 406 */     lb.add(new xdb.logs.ListenableChanged().setVarName("level"));
/* 407 */     lb.add(new xdb.logs.ListenableSet().setVarName("colors"));
/* 408 */     lb.add(new xdb.logs.ListenableSet().setVarName("skillids"));
/* 409 */     lb.add(new xdb.logs.ListenableChanged().setVarName("custtime"));
/* 410 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MarketEquipCon {
/*     */     private Const() {}
/*     */     
/*     */     MarketEquipCon nThis() {
/* 417 */       return MarketEquipCon.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketEquipCon copy()
/*     */     {
/* 429 */       return MarketEquipCon.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketEquipCon toData()
/*     */     {
/* 435 */       return MarketEquipCon.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MarketEquipCon toBean()
/*     */     {
/* 440 */       return MarketEquipCon.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketEquipCon toDataIf()
/*     */     {
/* 446 */       return MarketEquipCon.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MarketEquipCon toBeanIf()
/*     */     {
/* 451 */       return MarketEquipCon.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLevel()
/*     */     {
/* 458 */       MarketEquipCon.this._xdb_verify_unsafe_();
/* 459 */       return MarketEquipCon.this.level;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getColors()
/*     */     {
/* 466 */       MarketEquipCon.this._xdb_verify_unsafe_();
/* 467 */       return xdb.Consts.constSet(MarketEquipCon.this.colors);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getColorsAsData()
/*     */     {
/* 473 */       MarketEquipCon.this._xdb_verify_unsafe_();
/*     */       
/* 475 */       MarketEquipCon _o_ = MarketEquipCon.this;
/* 476 */       Set<Integer> colors = new SetX();
/* 477 */       colors.addAll(_o_.colors);
/* 478 */       return colors;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getSkillids()
/*     */     {
/* 485 */       MarketEquipCon.this._xdb_verify_unsafe_();
/* 486 */       return xdb.Consts.constSet(MarketEquipCon.this.skillids);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Integer> getSkillidsAsData()
/*     */     {
/* 492 */       MarketEquipCon.this._xdb_verify_unsafe_();
/*     */       
/* 494 */       MarketEquipCon _o_ = MarketEquipCon.this;
/* 495 */       Set<Integer> skillids = new SetX();
/* 496 */       skillids.addAll(_o_.skillids);
/* 497 */       return skillids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCusttime()
/*     */     {
/* 504 */       MarketEquipCon.this._xdb_verify_unsafe_();
/* 505 */       return MarketEquipCon.this.custtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevel(int _v_)
/*     */     {
/* 512 */       MarketEquipCon.this._xdb_verify_unsafe_();
/* 513 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCusttime(long _v_)
/*     */     {
/* 520 */       MarketEquipCon.this._xdb_verify_unsafe_();
/* 521 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 527 */       MarketEquipCon.this._xdb_verify_unsafe_();
/* 528 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 534 */       MarketEquipCon.this._xdb_verify_unsafe_();
/* 535 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 541 */       return MarketEquipCon.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 547 */       return MarketEquipCon.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 553 */       MarketEquipCon.this._xdb_verify_unsafe_();
/* 554 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 560 */       return MarketEquipCon.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 566 */       return MarketEquipCon.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 572 */       MarketEquipCon.this._xdb_verify_unsafe_();
/* 573 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 579 */       return MarketEquipCon.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 585 */       return MarketEquipCon.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 591 */       return MarketEquipCon.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 597 */       return MarketEquipCon.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 603 */       return MarketEquipCon.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 609 */       return MarketEquipCon.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 615 */       return MarketEquipCon.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MarketEquipCon
/*     */   {
/*     */     private int level;
/*     */     
/*     */     private HashSet<Integer> colors;
/*     */     
/*     */     private HashSet<Integer> skillids;
/*     */     
/*     */     private long custtime;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 633 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 638 */       this.colors = new HashSet();
/* 639 */       this.skillids = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.MarketEquipCon _o1_)
/*     */     {
/* 644 */       if ((_o1_ instanceof MarketEquipCon)) { assign((MarketEquipCon)_o1_);
/* 645 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 646 */       } else if ((_o1_ instanceof MarketEquipCon.Const)) assign(((MarketEquipCon.Const)_o1_).nThis()); else {
/* 647 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MarketEquipCon _o_) {
/* 652 */       this.level = _o_.level;
/* 653 */       this.colors = new HashSet();
/* 654 */       this.colors.addAll(_o_.colors);
/* 655 */       this.skillids = new HashSet();
/* 656 */       this.skillids.addAll(_o_.skillids);
/* 657 */       this.custtime = _o_.custtime;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 662 */       this.level = _o_.level;
/* 663 */       this.colors = new HashSet();
/* 664 */       this.colors.addAll(_o_.colors);
/* 665 */       this.skillids = new HashSet();
/* 666 */       this.skillids.addAll(_o_.skillids);
/* 667 */       this.custtime = _o_.custtime;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 673 */       _os_.marshal(this.level);
/* 674 */       _os_.compact_uint32(this.colors.size());
/* 675 */       for (Integer _v_ : this.colors)
/*     */       {
/* 677 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 679 */       _os_.compact_uint32(this.skillids.size());
/* 680 */       for (Integer _v_ : this.skillids)
/*     */       {
/* 682 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 684 */       _os_.marshal(this.custtime);
/* 685 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 691 */       this.level = _os_.unmarshal_int();
/* 692 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 694 */         int _v_ = 0;
/* 695 */         _v_ = _os_.unmarshal_int();
/* 696 */         this.colors.add(Integer.valueOf(_v_));
/*     */       }
/* 698 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 700 */         int _v_ = 0;
/* 701 */         _v_ = _os_.unmarshal_int();
/* 702 */         this.skillids.add(Integer.valueOf(_v_));
/*     */       }
/* 704 */       this.custtime = _os_.unmarshal_long();
/* 705 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 711 */       int _size_ = 0;
/* 712 */       _size_ += CodedOutputStream.computeInt32Size(1, this.level);
/* 713 */       for (Integer _v_ : this.colors)
/*     */       {
/* 715 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */       }
/* 717 */       for (Integer _v_ : this.skillids)
/*     */       {
/* 719 */         _size_ += CodedOutputStream.computeInt32Size(3, _v_.intValue());
/*     */       }
/* 721 */       _size_ += CodedOutputStream.computeInt64Size(4, this.custtime);
/* 722 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 730 */         _output_.writeInt32(1, this.level);
/* 731 */         for (Integer _v_ : this.colors)
/*     */         {
/* 733 */           _output_.writeInt32(2, _v_.intValue());
/*     */         }
/* 735 */         for (Integer _v_ : this.skillids)
/*     */         {
/* 737 */           _output_.writeInt32(3, _v_.intValue());
/*     */         }
/* 739 */         _output_.writeInt64(4, this.custtime);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 743 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 745 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 753 */         boolean done = false;
/* 754 */         while (!done)
/*     */         {
/* 756 */           int tag = _input_.readTag();
/* 757 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 761 */             done = true;
/* 762 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 766 */             this.level = _input_.readInt32();
/* 767 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 771 */             int _v_ = 0;
/* 772 */             _v_ = _input_.readInt32();
/* 773 */             this.colors.add(Integer.valueOf(_v_));
/* 774 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 778 */             int _v_ = 0;
/* 779 */             _v_ = _input_.readInt32();
/* 780 */             this.skillids.add(Integer.valueOf(_v_));
/* 781 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 785 */             this.custtime = _input_.readInt64();
/* 786 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 790 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 792 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 801 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 805 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 807 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketEquipCon copy()
/*     */     {
/* 813 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketEquipCon toData()
/*     */     {
/* 819 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MarketEquipCon toBean()
/*     */     {
/* 824 */       return new MarketEquipCon(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MarketEquipCon toDataIf()
/*     */     {
/* 830 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MarketEquipCon toBeanIf()
/*     */     {
/* 835 */       return new MarketEquipCon(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 841 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 845 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 849 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 853 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 857 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 861 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 865 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLevel()
/*     */     {
/* 872 */       return this.level;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getColors()
/*     */     {
/* 879 */       return this.colors;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getColorsAsData()
/*     */     {
/* 886 */       return this.colors;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getSkillids()
/*     */     {
/* 893 */       return this.skillids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Integer> getSkillidsAsData()
/*     */     {
/* 900 */       return this.skillids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCusttime()
/*     */     {
/* 907 */       return this.custtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLevel(int _v_)
/*     */     {
/* 914 */       this.level = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCusttime(long _v_)
/*     */     {
/* 921 */       this.custtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 927 */       if (!(_o1_ instanceof Data)) return false;
/* 928 */       Data _o_ = (Data)_o1_;
/* 929 */       if (this.level != _o_.level) return false;
/* 930 */       if (!this.colors.equals(_o_.colors)) return false;
/* 931 */       if (!this.skillids.equals(_o_.skillids)) return false;
/* 932 */       if (this.custtime != _o_.custtime) return false;
/* 933 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 939 */       int _h_ = 0;
/* 940 */       _h_ += this.level;
/* 941 */       _h_ += this.colors.hashCode();
/* 942 */       _h_ += this.skillids.hashCode();
/* 943 */       _h_ = (int)(_h_ + this.custtime);
/* 944 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 950 */       StringBuilder _sb_ = new StringBuilder();
/* 951 */       _sb_.append("(");
/* 952 */       _sb_.append(this.level);
/* 953 */       _sb_.append(",");
/* 954 */       _sb_.append(this.colors);
/* 955 */       _sb_.append(",");
/* 956 */       _sb_.append(this.skillids);
/* 957 */       _sb_.append(",");
/* 958 */       _sb_.append(this.custtime);
/* 959 */       _sb_.append(")");
/* 960 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MarketEquipCon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */