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
/*     */ public final class QMHWActivity extends XBean implements xbean.QMHWActivity
/*     */ {
/*     */   private long worldid;
/*     */   private SetX<Long> fightids;
/*     */   private int handleresult;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.worldid = 0L;
/*  23 */     this.fightids.clear();
/*  24 */     this.handleresult = 0;
/*     */   }
/*     */   
/*     */   QMHWActivity(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.fightids = new SetX();
/*     */   }
/*     */   
/*     */   public QMHWActivity()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public QMHWActivity(QMHWActivity _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   QMHWActivity(xbean.QMHWActivity _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof QMHWActivity)) { assign((QMHWActivity)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(QMHWActivity _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.worldid = _o_.worldid;
/*  56 */     this.fightids = new SetX();
/*  57 */     this.fightids.addAll(_o_.fightids);
/*  58 */     this.handleresult = _o_.handleresult;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  63 */     this.worldid = _o_.worldid;
/*  64 */     this.fightids = new SetX();
/*  65 */     this.fightids.addAll(_o_.fightids);
/*  66 */     this.handleresult = _o_.handleresult;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.marshal(this.worldid);
/*  74 */     _os_.compact_uint32(this.fightids.size());
/*  75 */     for (Long _v_ : this.fightids)
/*     */     {
/*  77 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  79 */     _os_.marshal(this.handleresult);
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  86 */     _xdb_verify_unsafe_();
/*  87 */     this.worldid = _os_.unmarshal_long();
/*  88 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  90 */       long _v_ = 0L;
/*  91 */       _v_ = _os_.unmarshal_long();
/*  92 */       this.fightids.add(Long.valueOf(_v_));
/*     */     }
/*  94 */     this.handleresult = _os_.unmarshal_int();
/*  95 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 101 */     _xdb_verify_unsafe_();
/* 102 */     int _size_ = 0;
/* 103 */     _size_ += CodedOutputStream.computeInt64Size(1, this.worldid);
/* 104 */     for (Long _v_ : this.fightids)
/*     */     {
/* 106 */       _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*     */     }
/* 108 */     _size_ += CodedOutputStream.computeInt32Size(3, this.handleresult);
/* 109 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 115 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 118 */       _output_.writeInt64(1, this.worldid);
/* 119 */       for (Long _v_ : this.fightids)
/*     */       {
/* 121 */         _output_.writeInt64(2, _v_.longValue());
/*     */       }
/* 123 */       _output_.writeInt32(3, this.handleresult);
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
/* 151 */           this.worldid = _input_.readInt64();
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 156 */           long _v_ = 0L;
/* 157 */           _v_ = _input_.readInt64();
/* 158 */           this.fightids.add(Long.valueOf(_v_));
/* 159 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 163 */           this.handleresult = _input_.readInt32();
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
/*     */   public xbean.QMHWActivity copy()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new QMHWActivity(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.QMHWActivity toData()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.QMHWActivity toBean()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new QMHWActivity(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.QMHWActivity toDataIf()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.QMHWActivity toBeanIf()
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
/*     */   public long getWorldid()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return this.worldid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Set<Long> getFightids()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return xdb.Logs.logSet(new LogKey(this, "fightids"), this.fightids);
/*     */   }
/*     */   
/*     */ 
/*     */   public Set<Long> getFightidsAsData()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/*     */     
/* 249 */     QMHWActivity _o_ = this;
/* 250 */     Set<Long> fightids = new SetX();
/* 251 */     fightids.addAll(_o_.fightids);
/* 252 */     return fightids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getHandleresult()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return this.handleresult;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setWorldid(long _v_)
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/* 268 */     xdb.Logs.logIf(new LogKey(this, "worldid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 272 */         new xdb.logs.LogLong(this, QMHWActivity.this.worldid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 276 */             QMHWActivity.this.worldid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 280 */     });
/* 281 */     this.worldid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setHandleresult(int _v_)
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     xdb.Logs.logIf(new LogKey(this, "handleresult")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 293 */         new xdb.logs.LogInt(this, QMHWActivity.this.handleresult)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 297 */             QMHWActivity.this.handleresult = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 301 */     });
/* 302 */     this.handleresult = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 308 */     _xdb_verify_unsafe_();
/* 309 */     QMHWActivity _o_ = null;
/* 310 */     if ((_o1_ instanceof QMHWActivity)) { _o_ = (QMHWActivity)_o1_;
/* 311 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 312 */       return false;
/* 313 */     if (this.worldid != _o_.worldid) return false;
/* 314 */     if (!this.fightids.equals(_o_.fightids)) return false;
/* 315 */     if (this.handleresult != _o_.handleresult) return false;
/* 316 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 322 */     _xdb_verify_unsafe_();
/* 323 */     int _h_ = 0;
/* 324 */     _h_ = (int)(_h_ + this.worldid);
/* 325 */     _h_ += this.fightids.hashCode();
/* 326 */     _h_ += this.handleresult;
/* 327 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 333 */     _xdb_verify_unsafe_();
/* 334 */     StringBuilder _sb_ = new StringBuilder();
/* 335 */     _sb_.append("(");
/* 336 */     _sb_.append(this.worldid);
/* 337 */     _sb_.append(",");
/* 338 */     _sb_.append(this.fightids);
/* 339 */     _sb_.append(",");
/* 340 */     _sb_.append(this.handleresult);
/* 341 */     _sb_.append(")");
/* 342 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 348 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 349 */     lb.add(new xdb.logs.ListenableChanged().setVarName("worldid"));
/* 350 */     lb.add(new xdb.logs.ListenableSet().setVarName("fightids"));
/* 351 */     lb.add(new xdb.logs.ListenableChanged().setVarName("handleresult"));
/* 352 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.QMHWActivity {
/*     */     private Const() {}
/*     */     
/*     */     QMHWActivity nThis() {
/* 359 */       return QMHWActivity.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 365 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.QMHWActivity copy()
/*     */     {
/* 371 */       return QMHWActivity.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.QMHWActivity toData()
/*     */     {
/* 377 */       return QMHWActivity.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.QMHWActivity toBean()
/*     */     {
/* 382 */       return QMHWActivity.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.QMHWActivity toDataIf()
/*     */     {
/* 388 */       return QMHWActivity.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.QMHWActivity toBeanIf()
/*     */     {
/* 393 */       return QMHWActivity.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getWorldid()
/*     */     {
/* 400 */       QMHWActivity.this._xdb_verify_unsafe_();
/* 401 */       return QMHWActivity.this.worldid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getFightids()
/*     */     {
/* 408 */       QMHWActivity.this._xdb_verify_unsafe_();
/* 409 */       return xdb.Consts.constSet(QMHWActivity.this.fightids);
/*     */     }
/*     */     
/*     */ 
/*     */     public Set<Long> getFightidsAsData()
/*     */     {
/* 415 */       QMHWActivity.this._xdb_verify_unsafe_();
/*     */       
/* 417 */       QMHWActivity _o_ = QMHWActivity.this;
/* 418 */       Set<Long> fightids = new SetX();
/* 419 */       fightids.addAll(_o_.fightids);
/* 420 */       return fightids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getHandleresult()
/*     */     {
/* 427 */       QMHWActivity.this._xdb_verify_unsafe_();
/* 428 */       return QMHWActivity.this.handleresult;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWorldid(long _v_)
/*     */     {
/* 435 */       QMHWActivity.this._xdb_verify_unsafe_();
/* 436 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHandleresult(int _v_)
/*     */     {
/* 443 */       QMHWActivity.this._xdb_verify_unsafe_();
/* 444 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 450 */       QMHWActivity.this._xdb_verify_unsafe_();
/* 451 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 457 */       QMHWActivity.this._xdb_verify_unsafe_();
/* 458 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 464 */       return QMHWActivity.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 470 */       return QMHWActivity.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 476 */       QMHWActivity.this._xdb_verify_unsafe_();
/* 477 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 483 */       return QMHWActivity.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 489 */       return QMHWActivity.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 495 */       QMHWActivity.this._xdb_verify_unsafe_();
/* 496 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 502 */       return QMHWActivity.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 508 */       return QMHWActivity.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 514 */       return QMHWActivity.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 520 */       return QMHWActivity.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 526 */       return QMHWActivity.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 532 */       return QMHWActivity.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 538 */       return QMHWActivity.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.QMHWActivity
/*     */   {
/*     */     private long worldid;
/*     */     
/*     */     private HashSet<Long> fightids;
/*     */     
/*     */     private int handleresult;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 554 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 559 */       this.fightids = new HashSet();
/*     */     }
/*     */     
/*     */     Data(xbean.QMHWActivity _o1_)
/*     */     {
/* 564 */       if ((_o1_ instanceof QMHWActivity)) { assign((QMHWActivity)_o1_);
/* 565 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 566 */       } else if ((_o1_ instanceof QMHWActivity.Const)) assign(((QMHWActivity.Const)_o1_).nThis()); else {
/* 567 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(QMHWActivity _o_) {
/* 572 */       this.worldid = _o_.worldid;
/* 573 */       this.fightids = new HashSet();
/* 574 */       this.fightids.addAll(_o_.fightids);
/* 575 */       this.handleresult = _o_.handleresult;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 580 */       this.worldid = _o_.worldid;
/* 581 */       this.fightids = new HashSet();
/* 582 */       this.fightids.addAll(_o_.fightids);
/* 583 */       this.handleresult = _o_.handleresult;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 589 */       _os_.marshal(this.worldid);
/* 590 */       _os_.compact_uint32(this.fightids.size());
/* 591 */       for (Long _v_ : this.fightids)
/*     */       {
/* 593 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 595 */       _os_.marshal(this.handleresult);
/* 596 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 602 */       this.worldid = _os_.unmarshal_long();
/* 603 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 605 */         long _v_ = 0L;
/* 606 */         _v_ = _os_.unmarshal_long();
/* 607 */         this.fightids.add(Long.valueOf(_v_));
/*     */       }
/* 609 */       this.handleresult = _os_.unmarshal_int();
/* 610 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 616 */       int _size_ = 0;
/* 617 */       _size_ += CodedOutputStream.computeInt64Size(1, this.worldid);
/* 618 */       for (Long _v_ : this.fightids)
/*     */       {
/* 620 */         _size_ += CodedOutputStream.computeInt64Size(2, _v_.longValue());
/*     */       }
/* 622 */       _size_ += CodedOutputStream.computeInt32Size(3, this.handleresult);
/* 623 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 631 */         _output_.writeInt64(1, this.worldid);
/* 632 */         for (Long _v_ : this.fightids)
/*     */         {
/* 634 */           _output_.writeInt64(2, _v_.longValue());
/*     */         }
/* 636 */         _output_.writeInt32(3, this.handleresult);
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
/* 663 */             this.worldid = _input_.readInt64();
/* 664 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 668 */             long _v_ = 0L;
/* 669 */             _v_ = _input_.readInt64();
/* 670 */             this.fightids.add(Long.valueOf(_v_));
/* 671 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 675 */             this.handleresult = _input_.readInt32();
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
/*     */     public xbean.QMHWActivity copy()
/*     */     {
/* 703 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.QMHWActivity toData()
/*     */     {
/* 709 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.QMHWActivity toBean()
/*     */     {
/* 714 */       return new QMHWActivity(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.QMHWActivity toDataIf()
/*     */     {
/* 720 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.QMHWActivity toBeanIf()
/*     */     {
/* 725 */       return new QMHWActivity(this, null, null);
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
/*     */     public long getWorldid()
/*     */     {
/* 762 */       return this.worldid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getFightids()
/*     */     {
/* 769 */       return this.fightids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Set<Long> getFightidsAsData()
/*     */     {
/* 776 */       return this.fightids;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getHandleresult()
/*     */     {
/* 783 */       return this.handleresult;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWorldid(long _v_)
/*     */     {
/* 790 */       this.worldid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHandleresult(int _v_)
/*     */     {
/* 797 */       this.handleresult = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 803 */       if (!(_o1_ instanceof Data)) return false;
/* 804 */       Data _o_ = (Data)_o1_;
/* 805 */       if (this.worldid != _o_.worldid) return false;
/* 806 */       if (!this.fightids.equals(_o_.fightids)) return false;
/* 807 */       if (this.handleresult != _o_.handleresult) return false;
/* 808 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 814 */       int _h_ = 0;
/* 815 */       _h_ = (int)(_h_ + this.worldid);
/* 816 */       _h_ += this.fightids.hashCode();
/* 817 */       _h_ += this.handleresult;
/* 818 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 824 */       StringBuilder _sb_ = new StringBuilder();
/* 825 */       _sb_.append("(");
/* 826 */       _sb_.append(this.worldid);
/* 827 */       _sb_.append(",");
/* 828 */       _sb_.append(this.fightids);
/* 829 */       _sb_.append(",");
/* 830 */       _sb_.append(this.handleresult);
/* 831 */       _sb_.append(")");
/* 832 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\QMHWActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */