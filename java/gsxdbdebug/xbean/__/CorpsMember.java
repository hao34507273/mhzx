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
/*     */ 
/*     */ public final class CorpsMember extends XBean implements xbean.CorpsMember
/*     */ {
/*     */   private long corpsid;
/*     */   private long jointime;
/*     */   private int duty;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.corpsid = 0L;
/*  23 */     this.jointime = 0L;
/*  24 */     this.duty = 0;
/*     */   }
/*     */   
/*     */   CorpsMember(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public CorpsMember()
/*     */   {
/*  34 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public CorpsMember(CorpsMember _o_)
/*     */   {
/*  39 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   CorpsMember(xbean.CorpsMember _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  44 */     super(_xp_, _vn_);
/*  45 */     if ((_o1_ instanceof CorpsMember)) { assign((CorpsMember)_o1_);
/*  46 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  47 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  48 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(CorpsMember _o_) {
/*  53 */     _o_._xdb_verify_unsafe_();
/*  54 */     this.corpsid = _o_.corpsid;
/*  55 */     this.jointime = _o_.jointime;
/*  56 */     this.duty = _o_.duty;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.corpsid = _o_.corpsid;
/*  62 */     this.jointime = _o_.jointime;
/*  63 */     this.duty = _o_.duty;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.corpsid);
/*  71 */     _os_.marshal(this.jointime);
/*  72 */     _os_.marshal(this.duty);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     this.corpsid = _os_.unmarshal_long();
/*  81 */     this.jointime = _os_.unmarshal_long();
/*  82 */     this.duty = _os_.unmarshal_int();
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     _size_ += CodedOutputStream.computeInt64Size(1, this.corpsid);
/*  92 */     _size_ += CodedOutputStream.computeInt64Size(2, this.jointime);
/*  93 */     _size_ += CodedOutputStream.computeInt32Size(3, this.duty);
/*  94 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       _output_.writeInt64(1, this.corpsid);
/* 104 */       _output_.writeInt64(2, this.jointime);
/* 105 */       _output_.writeInt32(3, this.duty);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 109 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 111 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 120 */       boolean done = false;
/* 121 */       while (!done)
/*     */       {
/* 123 */         int tag = _input_.readTag();
/* 124 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 128 */           done = true;
/* 129 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 133 */           this.corpsid = _input_.readInt64();
/* 134 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 138 */           this.jointime = _input_.readInt64();
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 143 */           this.duty = _input_.readInt32();
/* 144 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 148 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 150 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 159 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 163 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 165 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CorpsMember copy()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new CorpsMember(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CorpsMember toData()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CorpsMember toBean()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new CorpsMember(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.CorpsMember toDataIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.CorpsMember toBeanIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getCorpsid()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this.corpsid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getJointime()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.jointime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getDuty()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.duty;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCorpsid(long _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "corpsid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new xdb.logs.LogLong(this, CorpsMember.this.corpsid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             CorpsMember.this.corpsid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.corpsid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setJointime(long _v_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     xdb.Logs.logIf(new LogKey(this, "jointime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 262 */         new xdb.logs.LogLong(this, CorpsMember.this.jointime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 266 */             CorpsMember.this.jointime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 270 */     });
/* 271 */     this.jointime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setDuty(int _v_)
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     xdb.Logs.logIf(new LogKey(this, "duty")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 283 */         new xdb.logs.LogInt(this, CorpsMember.this.duty)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 287 */             CorpsMember.this.duty = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 291 */     });
/* 292 */     this.duty = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     CorpsMember _o_ = null;
/* 300 */     if ((_o1_ instanceof CorpsMember)) { _o_ = (CorpsMember)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (this.corpsid != _o_.corpsid) return false;
/* 304 */     if (this.jointime != _o_.jointime) return false;
/* 305 */     if (this.duty != _o_.duty) return false;
/* 306 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     int _h_ = 0;
/* 314 */     _h_ = (int)(_h_ + this.corpsid);
/* 315 */     _h_ = (int)(_h_ + this.jointime);
/* 316 */     _h_ += this.duty;
/* 317 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     StringBuilder _sb_ = new StringBuilder();
/* 325 */     _sb_.append("(");
/* 326 */     _sb_.append(this.corpsid);
/* 327 */     _sb_.append(",");
/* 328 */     _sb_.append(this.jointime);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.duty);
/* 331 */     _sb_.append(")");
/* 332 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 338 */     ListenableBean lb = new ListenableBean();
/* 339 */     lb.add(new ListenableChanged().setVarName("corpsid"));
/* 340 */     lb.add(new ListenableChanged().setVarName("jointime"));
/* 341 */     lb.add(new ListenableChanged().setVarName("duty"));
/* 342 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.CorpsMember {
/*     */     private Const() {}
/*     */     
/*     */     CorpsMember nThis() {
/* 349 */       return CorpsMember.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 355 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CorpsMember copy()
/*     */     {
/* 361 */       return CorpsMember.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CorpsMember toData()
/*     */     {
/* 367 */       return CorpsMember.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.CorpsMember toBean()
/*     */     {
/* 372 */       return CorpsMember.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CorpsMember toDataIf()
/*     */     {
/* 378 */       return CorpsMember.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.CorpsMember toBeanIf()
/*     */     {
/* 383 */       return CorpsMember.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCorpsid()
/*     */     {
/* 390 */       CorpsMember.this._xdb_verify_unsafe_();
/* 391 */       return CorpsMember.this.corpsid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getJointime()
/*     */     {
/* 398 */       CorpsMember.this._xdb_verify_unsafe_();
/* 399 */       return CorpsMember.this.jointime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getDuty()
/*     */     {
/* 406 */       CorpsMember.this._xdb_verify_unsafe_();
/* 407 */       return CorpsMember.this.duty;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCorpsid(long _v_)
/*     */     {
/* 414 */       CorpsMember.this._xdb_verify_unsafe_();
/* 415 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setJointime(long _v_)
/*     */     {
/* 422 */       CorpsMember.this._xdb_verify_unsafe_();
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDuty(int _v_)
/*     */     {
/* 430 */       CorpsMember.this._xdb_verify_unsafe_();
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 437 */       CorpsMember.this._xdb_verify_unsafe_();
/* 438 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 444 */       CorpsMember.this._xdb_verify_unsafe_();
/* 445 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 451 */       return CorpsMember.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 457 */       return CorpsMember.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 463 */       CorpsMember.this._xdb_verify_unsafe_();
/* 464 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 470 */       return CorpsMember.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 476 */       return CorpsMember.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 482 */       CorpsMember.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 489 */       return CorpsMember.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 495 */       return CorpsMember.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 501 */       return CorpsMember.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 507 */       return CorpsMember.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 513 */       return CorpsMember.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 519 */       return CorpsMember.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 525 */       return CorpsMember.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.CorpsMember
/*     */   {
/*     */     private long corpsid;
/*     */     
/*     */     private long jointime;
/*     */     
/*     */     private int duty;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 541 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.CorpsMember _o1_)
/*     */     {
/* 550 */       if ((_o1_ instanceof CorpsMember)) { assign((CorpsMember)_o1_);
/* 551 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 552 */       } else if ((_o1_ instanceof CorpsMember.Const)) assign(((CorpsMember.Const)_o1_).nThis()); else {
/* 553 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(CorpsMember _o_) {
/* 558 */       this.corpsid = _o_.corpsid;
/* 559 */       this.jointime = _o_.jointime;
/* 560 */       this.duty = _o_.duty;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 565 */       this.corpsid = _o_.corpsid;
/* 566 */       this.jointime = _o_.jointime;
/* 567 */       this.duty = _o_.duty;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 573 */       _os_.marshal(this.corpsid);
/* 574 */       _os_.marshal(this.jointime);
/* 575 */       _os_.marshal(this.duty);
/* 576 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       this.corpsid = _os_.unmarshal_long();
/* 583 */       this.jointime = _os_.unmarshal_long();
/* 584 */       this.duty = _os_.unmarshal_int();
/* 585 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 591 */       int _size_ = 0;
/* 592 */       _size_ += CodedOutputStream.computeInt64Size(1, this.corpsid);
/* 593 */       _size_ += CodedOutputStream.computeInt64Size(2, this.jointime);
/* 594 */       _size_ += CodedOutputStream.computeInt32Size(3, this.duty);
/* 595 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 603 */         _output_.writeInt64(1, this.corpsid);
/* 604 */         _output_.writeInt64(2, this.jointime);
/* 605 */         _output_.writeInt32(3, this.duty);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 609 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 611 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 619 */         boolean done = false;
/* 620 */         while (!done)
/*     */         {
/* 622 */           int tag = _input_.readTag();
/* 623 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 627 */             done = true;
/* 628 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 632 */             this.corpsid = _input_.readInt64();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             this.jointime = _input_.readInt64();
/* 638 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 642 */             this.duty = _input_.readInt32();
/* 643 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 647 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 649 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 658 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 662 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 664 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CorpsMember copy()
/*     */     {
/* 670 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CorpsMember toData()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.CorpsMember toBean()
/*     */     {
/* 681 */       return new CorpsMember(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.CorpsMember toDataIf()
/*     */     {
/* 687 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.CorpsMember toBeanIf()
/*     */     {
/* 692 */       return new CorpsMember(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 698 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 702 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 706 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 710 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 714 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 718 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 722 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getCorpsid()
/*     */     {
/* 729 */       return this.corpsid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getJointime()
/*     */     {
/* 736 */       return this.jointime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getDuty()
/*     */     {
/* 743 */       return this.duty;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCorpsid(long _v_)
/*     */     {
/* 750 */       this.corpsid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setJointime(long _v_)
/*     */     {
/* 757 */       this.jointime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setDuty(int _v_)
/*     */     {
/* 764 */       this.duty = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 770 */       if (!(_o1_ instanceof Data)) return false;
/* 771 */       Data _o_ = (Data)_o1_;
/* 772 */       if (this.corpsid != _o_.corpsid) return false;
/* 773 */       if (this.jointime != _o_.jointime) return false;
/* 774 */       if (this.duty != _o_.duty) return false;
/* 775 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 781 */       int _h_ = 0;
/* 782 */       _h_ = (int)(_h_ + this.corpsid);
/* 783 */       _h_ = (int)(_h_ + this.jointime);
/* 784 */       _h_ += this.duty;
/* 785 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 791 */       StringBuilder _sb_ = new StringBuilder();
/* 792 */       _sb_.append("(");
/* 793 */       _sb_.append(this.corpsid);
/* 794 */       _sb_.append(",");
/* 795 */       _sb_.append(this.jointime);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.duty);
/* 798 */       _sb_.append(")");
/* 799 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\CorpsMember.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */