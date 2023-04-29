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
/*     */ public final class Opponent extends XBean implements xbean.Opponent
/*     */ {
/*     */   private long lastfreshtime;
/*     */   private long autofreshtime;
/*     */   private ArrayList<Long> opponentroleids;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.lastfreshtime = 0L;
/*  23 */     this.autofreshtime = 0L;
/*  24 */     this.opponentroleids.clear();
/*     */   }
/*     */   
/*     */   Opponent(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.opponentroleids = new ArrayList();
/*     */   }
/*     */   
/*     */   public Opponent()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Opponent(Opponent _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Opponent(xbean.Opponent _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof Opponent)) { assign((Opponent)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Opponent _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.lastfreshtime = _o_.lastfreshtime;
/*  56 */     this.autofreshtime = _o_.autofreshtime;
/*  57 */     this.opponentroleids = new ArrayList();
/*  58 */     this.opponentroleids.addAll(_o_.opponentroleids);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  63 */     this.lastfreshtime = _o_.lastfreshtime;
/*  64 */     this.autofreshtime = _o_.autofreshtime;
/*  65 */     this.opponentroleids = new ArrayList();
/*  66 */     this.opponentroleids.addAll(_o_.opponentroleids);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.marshal(this.lastfreshtime);
/*  74 */     _os_.marshal(this.autofreshtime);
/*  75 */     _os_.compact_uint32(this.opponentroleids.size());
/*  76 */     for (Long _v_ : this.opponentroleids)
/*     */     {
/*  78 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  86 */     _xdb_verify_unsafe_();
/*  87 */     this.lastfreshtime = _os_.unmarshal_long();
/*  88 */     this.autofreshtime = _os_.unmarshal_long();
/*  89 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  91 */       long _v_ = 0L;
/*  92 */       _v_ = _os_.unmarshal_long();
/*  93 */       this.opponentroleids.add(Long.valueOf(_v_));
/*     */     }
/*  95 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 101 */     _xdb_verify_unsafe_();
/* 102 */     int _size_ = 0;
/* 103 */     _size_ += CodedOutputStream.computeInt64Size(1, this.lastfreshtime);
/* 104 */     _size_ += CodedOutputStream.computeInt64Size(2, this.autofreshtime);
/* 105 */     for (Long _v_ : this.opponentroleids)
/*     */     {
/* 107 */       _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*     */     }
/* 109 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 115 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 118 */       _output_.writeInt64(1, this.lastfreshtime);
/* 119 */       _output_.writeInt64(2, this.autofreshtime);
/* 120 */       for (Long _v_ : this.opponentroleids)
/*     */       {
/* 122 */         _output_.writeInt64(3, _v_.longValue());
/*     */       }
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
/* 151 */           this.lastfreshtime = _input_.readInt64();
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 156 */           this.autofreshtime = _input_.readInt64();
/* 157 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 161 */           long _v_ = 0L;
/* 162 */           _v_ = _input_.readInt64();
/* 163 */           this.opponentroleids.add(Long.valueOf(_v_));
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
/*     */   public xbean.Opponent copy()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Opponent(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Opponent toData()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Opponent toBean()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new Opponent(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Opponent toDataIf()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Opponent toBeanIf()
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
/*     */   public long getLastfreshtime()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return this.lastfreshtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getAutofreshtime()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return this.autofreshtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getOpponentroleids()
/*     */   {
/* 248 */     _xdb_verify_unsafe_();
/* 249 */     return xdb.Logs.logList(new LogKey(this, "opponentroleids"), this.opponentroleids);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getOpponentroleidsAsData()
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/*     */     
/* 257 */     Opponent _o_ = this;
/* 258 */     List<Long> opponentroleids = new ArrayList();
/* 259 */     opponentroleids.addAll(_o_.opponentroleids);
/* 260 */     return opponentroleids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLastfreshtime(long _v_)
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/* 268 */     xdb.Logs.logIf(new LogKey(this, "lastfreshtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 272 */         new xdb.logs.LogLong(this, Opponent.this.lastfreshtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 276 */             Opponent.this.lastfreshtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 280 */     });
/* 281 */     this.lastfreshtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAutofreshtime(long _v_)
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     xdb.Logs.logIf(new LogKey(this, "autofreshtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 293 */         new xdb.logs.LogLong(this, Opponent.this.autofreshtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 297 */             Opponent.this.autofreshtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 301 */     });
/* 302 */     this.autofreshtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 308 */     _xdb_verify_unsafe_();
/* 309 */     Opponent _o_ = null;
/* 310 */     if ((_o1_ instanceof Opponent)) { _o_ = (Opponent)_o1_;
/* 311 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 312 */       return false;
/* 313 */     if (this.lastfreshtime != _o_.lastfreshtime) return false;
/* 314 */     if (this.autofreshtime != _o_.autofreshtime) return false;
/* 315 */     if (!this.opponentroleids.equals(_o_.opponentroleids)) return false;
/* 316 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 322 */     _xdb_verify_unsafe_();
/* 323 */     int _h_ = 0;
/* 324 */     _h_ = (int)(_h_ + this.lastfreshtime);
/* 325 */     _h_ = (int)(_h_ + this.autofreshtime);
/* 326 */     _h_ += this.opponentroleids.hashCode();
/* 327 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 333 */     _xdb_verify_unsafe_();
/* 334 */     StringBuilder _sb_ = new StringBuilder();
/* 335 */     _sb_.append("(");
/* 336 */     _sb_.append(this.lastfreshtime);
/* 337 */     _sb_.append(",");
/* 338 */     _sb_.append(this.autofreshtime);
/* 339 */     _sb_.append(",");
/* 340 */     _sb_.append(this.opponentroleids);
/* 341 */     _sb_.append(")");
/* 342 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 348 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 349 */     lb.add(new ListenableChanged().setVarName("lastfreshtime"));
/* 350 */     lb.add(new ListenableChanged().setVarName("autofreshtime"));
/* 351 */     lb.add(new ListenableChanged().setVarName("opponentroleids"));
/* 352 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Opponent {
/*     */     private Const() {}
/*     */     
/*     */     Opponent nThis() {
/* 359 */       return Opponent.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 365 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Opponent copy()
/*     */     {
/* 371 */       return Opponent.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Opponent toData()
/*     */     {
/* 377 */       return Opponent.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Opponent toBean()
/*     */     {
/* 382 */       return Opponent.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Opponent toDataIf()
/*     */     {
/* 388 */       return Opponent.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Opponent toBeanIf()
/*     */     {
/* 393 */       return Opponent.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLastfreshtime()
/*     */     {
/* 400 */       Opponent.this._xdb_verify_unsafe_();
/* 401 */       return Opponent.this.lastfreshtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getAutofreshtime()
/*     */     {
/* 408 */       Opponent.this._xdb_verify_unsafe_();
/* 409 */       return Opponent.this.autofreshtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getOpponentroleids()
/*     */     {
/* 416 */       Opponent.this._xdb_verify_unsafe_();
/* 417 */       return xdb.Consts.constList(Opponent.this.opponentroleids);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getOpponentroleidsAsData()
/*     */     {
/* 423 */       Opponent.this._xdb_verify_unsafe_();
/*     */       
/* 425 */       Opponent _o_ = Opponent.this;
/* 426 */       List<Long> opponentroleids = new ArrayList();
/* 427 */       opponentroleids.addAll(_o_.opponentroleids);
/* 428 */       return opponentroleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLastfreshtime(long _v_)
/*     */     {
/* 435 */       Opponent.this._xdb_verify_unsafe_();
/* 436 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAutofreshtime(long _v_)
/*     */     {
/* 443 */       Opponent.this._xdb_verify_unsafe_();
/* 444 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 450 */       Opponent.this._xdb_verify_unsafe_();
/* 451 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 457 */       Opponent.this._xdb_verify_unsafe_();
/* 458 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 464 */       return Opponent.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 470 */       return Opponent.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 476 */       Opponent.this._xdb_verify_unsafe_();
/* 477 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 483 */       return Opponent.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 489 */       return Opponent.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 495 */       Opponent.this._xdb_verify_unsafe_();
/* 496 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 502 */       return Opponent.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 508 */       return Opponent.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 514 */       return Opponent.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 520 */       return Opponent.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 526 */       return Opponent.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 532 */       return Opponent.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 538 */       return Opponent.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Opponent
/*     */   {
/*     */     private long lastfreshtime;
/*     */     
/*     */     private long autofreshtime;
/*     */     
/*     */     private ArrayList<Long> opponentroleids;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 554 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 559 */       this.opponentroleids = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.Opponent _o1_)
/*     */     {
/* 564 */       if ((_o1_ instanceof Opponent)) { assign((Opponent)_o1_);
/* 565 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 566 */       } else if ((_o1_ instanceof Opponent.Const)) assign(((Opponent.Const)_o1_).nThis()); else {
/* 567 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Opponent _o_) {
/* 572 */       this.lastfreshtime = _o_.lastfreshtime;
/* 573 */       this.autofreshtime = _o_.autofreshtime;
/* 574 */       this.opponentroleids = new ArrayList();
/* 575 */       this.opponentroleids.addAll(_o_.opponentroleids);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 580 */       this.lastfreshtime = _o_.lastfreshtime;
/* 581 */       this.autofreshtime = _o_.autofreshtime;
/* 582 */       this.opponentroleids = new ArrayList();
/* 583 */       this.opponentroleids.addAll(_o_.opponentroleids);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 589 */       _os_.marshal(this.lastfreshtime);
/* 590 */       _os_.marshal(this.autofreshtime);
/* 591 */       _os_.compact_uint32(this.opponentroleids.size());
/* 592 */       for (Long _v_ : this.opponentroleids)
/*     */       {
/* 594 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 596 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 602 */       this.lastfreshtime = _os_.unmarshal_long();
/* 603 */       this.autofreshtime = _os_.unmarshal_long();
/* 604 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 606 */         long _v_ = 0L;
/* 607 */         _v_ = _os_.unmarshal_long();
/* 608 */         this.opponentroleids.add(Long.valueOf(_v_));
/*     */       }
/* 610 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 616 */       int _size_ = 0;
/* 617 */       _size_ += CodedOutputStream.computeInt64Size(1, this.lastfreshtime);
/* 618 */       _size_ += CodedOutputStream.computeInt64Size(2, this.autofreshtime);
/* 619 */       for (Long _v_ : this.opponentroleids)
/*     */       {
/* 621 */         _size_ += CodedOutputStream.computeInt64Size(3, _v_.longValue());
/*     */       }
/* 623 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 631 */         _output_.writeInt64(1, this.lastfreshtime);
/* 632 */         _output_.writeInt64(2, this.autofreshtime);
/* 633 */         for (Long _v_ : this.opponentroleids)
/*     */         {
/* 635 */           _output_.writeInt64(3, _v_.longValue());
/*     */         }
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
/* 663 */             this.lastfreshtime = _input_.readInt64();
/* 664 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 668 */             this.autofreshtime = _input_.readInt64();
/* 669 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 673 */             long _v_ = 0L;
/* 674 */             _v_ = _input_.readInt64();
/* 675 */             this.opponentroleids.add(Long.valueOf(_v_));
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
/*     */     public xbean.Opponent copy()
/*     */     {
/* 703 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Opponent toData()
/*     */     {
/* 709 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Opponent toBean()
/*     */     {
/* 714 */       return new Opponent(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Opponent toDataIf()
/*     */     {
/* 720 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Opponent toBeanIf()
/*     */     {
/* 725 */       return new Opponent(this, null, null);
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
/*     */     public long getLastfreshtime()
/*     */     {
/* 762 */       return this.lastfreshtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getAutofreshtime()
/*     */     {
/* 769 */       return this.autofreshtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getOpponentroleids()
/*     */     {
/* 776 */       return this.opponentroleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getOpponentroleidsAsData()
/*     */     {
/* 783 */       return this.opponentroleids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLastfreshtime(long _v_)
/*     */     {
/* 790 */       this.lastfreshtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAutofreshtime(long _v_)
/*     */     {
/* 797 */       this.autofreshtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 803 */       if (!(_o1_ instanceof Data)) return false;
/* 804 */       Data _o_ = (Data)_o1_;
/* 805 */       if (this.lastfreshtime != _o_.lastfreshtime) return false;
/* 806 */       if (this.autofreshtime != _o_.autofreshtime) return false;
/* 807 */       if (!this.opponentroleids.equals(_o_.opponentroleids)) return false;
/* 808 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 814 */       int _h_ = 0;
/* 815 */       _h_ = (int)(_h_ + this.lastfreshtime);
/* 816 */       _h_ = (int)(_h_ + this.autofreshtime);
/* 817 */       _h_ += this.opponentroleids.hashCode();
/* 818 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 824 */       StringBuilder _sb_ = new StringBuilder();
/* 825 */       _sb_.append("(");
/* 826 */       _sb_.append(this.lastfreshtime);
/* 827 */       _sb_.append(",");
/* 828 */       _sb_.append(this.autofreshtime);
/* 829 */       _sb_.append(",");
/* 830 */       _sb_.append(this.opponentroleids);
/* 831 */       _sb_.append(")");
/* 832 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Opponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */